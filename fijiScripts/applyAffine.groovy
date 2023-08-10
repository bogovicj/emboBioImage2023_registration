#@ Dataset moving
#@ Dataset fixed
#@ File file

//file = new File( "/home/john/Documents/teaching/embo2023/AffineTransformParameters.0.txt" );
affineTransform = affine( file )
println( affineTransform )




fixedResolution = new Scale3D(fixed.averageScale(0),
				fixed.averageScale(1),
				fixed.averageScale(2));

fixedImage = RealViews.affine(
	Views.interpolate( Views.extendZero(fixed),
			new NearestNeighborInterpolatorFactory()),
	fixedResolution );
	
movingResolution = new Scale3D(moving.averageScale(0),
			moving.averageScale(1),
			moving.averageScale(2));

println( fixedResolution.getRowPackedCopy() );
println( movingResolution.getRowPackedCopy() );


println( affineTransform )
total = affineTransform.inverse();
total.concatenate(movingResolution);
println( total )

movingImage = RealViews.affine(
	Views.interpolate( Views.extendZero(moving),
			new NearestNeighborInterpolatorFactory()),
	total );
	

bdv = BdvFunctions.show(fixedImage, fixed, "fixed image");
BdvFunctions.show(movingImage, fixed, "transformed image", 
	BdvOptions.options().addTo(bdv));


def affine(file) {
	
	paramsPrefix = "TransformParameters";
	centerPrefix = "CenterOfRotationPoint";
	lines = Files.lines(file.toPath()).collect(Collectors.toList());
	isAffine = lines.stream().anyMatch( x -> x.startsWith("(Transform") && x.contains("\"AffineTransform\""));
	parameters = lines.stream().filter(x -> x.startsWith("(" + paramsPrefix)).map( x -> parameters(paramsPrefix, x) ).findFirst().get();
	center = lines.stream().filter(x -> x.startsWith("("+centerPrefix)).map( x -> parameters(centerPrefix, x) ).findFirst().get();
	return  affine3d( parameters, center );
}

def parameters( prefix, parameterLine) {
	final String r = parameterLine.replaceFirst("^\\("+prefix+" ", "").replaceFirst("\\)", "");
	println(r)
	return Arrays.stream( r.split(" ")).mapToDouble( Double::parseDouble ).toArray();
}


def affine3d( parameters, center ) {

     
    double[] translation = new double[]{ 
        parameters[9],
        parameters[10],
        parameters[11]
    };
    
	reshapedParameters = new double[]{
			parameters[0], parameters[1], parameters[2], 0.0,
			parameters[3], parameters[4], parameters[5], 0.0,
			parameters[6], parameters[7], parameters[8], 0.0,
	};
	
	
	centerOfRotation = new Translation3D( center );
	
	affine = new AffineTransform3D();
	affine.set(reshapedParameters);
	affine.concatenate(centerOfRotation.inverse());
	affine.preConcatenate( centerOfRotation );
	affine.translate(translation);

	return affine;
}

/*
 * see:
 * https://github.com/image-transform-converters/image-transform-converters/blob/master/src/main/java/itc/converters/ElastixAffine3DToAffineTransform3D.java
 */


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bdv.util.BdvFunctions;
import bdv.util.BdvOptions;
import bdv.util.BdvStackSource;

import net.imglib2.Interval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.RealRandomAccessible;
import net.imglib2.interpolation.randomaccess.NearestNeighborInterpolatorFactory;
import net.imglib2.realtransform.AffineTransform3D;
import net.imglib2.realtransform.Scale3D;
import net.imglib2.realtransform.Translation3D;
import net.imglib2.realtransform.RealViews;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.NumericType;
import net.imglib2.view.Views;
