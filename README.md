# emboBioImage2023_registration
Materials for the advanced image registration section of the "Advanced methods in bioimage analysis" EMBO 2023 course

## Course outline

#### 1 Lecture

1. Watch [the lecture video](https://youtu.be/OCbFJfLoZbY)

#### 2 Setup

1. Check out this repository
2. Run `./downloadSampleImages` to ... download more sample images
3. Set up your environment, if necessary (see below)

#### 3 Practical / Hands-on 

Each notebook contains instructions and comments. To get the most out of them,
students should read and follow instructions in the notebooks, run the notebook
cell-by-cell, ensuring they understand the code. Also important:

* Predict the output / result of each cell before running
* Observe the result after running the cell
* Compare to your prediction

The recommended order for notebooks is:

1. Run `resample_images.ipnb` notebook
2. Run `translation_initialization.ipnb` notebook
3. Run `similarity_metrics.ipnb` notebook
4. Run `multi_resolution.ipnb` notebook
5. Run `nonlinear.ipynb` notebook

## Dependencies 

* [simple-elastix](https://simpleelastix.github.io/)
* [itk-widgets](https://github.com/InsightSoftwareConsortium/itkwidgets)

## Image credits

* CT / MR
    * Adapted from the [2007 MIT registration course](https://ocw.mit.edu/courses/health-sciences-and-technology/hst-582j-biomedical-signal-and-image-processing-spring-2007/lecture-notes/l16_reg1.pdf) by Zollei and Wells
* [JFRC2010](https://github.com/VirtualFlyBrain/DrosAdultBRAINdomains)
    * [Jenett et al 2012](http://dx.doi.org/10.1016/j.celrep.2012.09.011)
* [JFRC2018](https://www.janelia.org/open-science/jrc-2018-brain-templates)
    * [Bogovic et al 2020](https://doi.org/10.1371/journal.pone.0236495)
