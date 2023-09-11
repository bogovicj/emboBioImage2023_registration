# emboBioImage2023_registration
Materials for the advanced image registration section of the "Advanced methods in bioimage analysis" EMBO 2023 course

## Course outline

#### 1 Lecture

1. Watch [the lecture video](https://youtu.be/OCbFJfLoZbY)
2. (Optional) [Download the lecture slides](https://github.com/bogovicj/emboBioImage2023_registration/blob/main/slides/embo2023Registration.pdf)

#### 2 Setup

If working on EMBL's BAND Platform, run these once:

* Open a terminal (click the icon near the top of the screen, or Applications > System tools > MATE terminal)
* Run `/scratch/bioimagecourse2023/session4/get-data.sh`

Now you should have a folder in your home directory called `emboBioImage2023_registration`. It should contain
a folder called `sampleImages` containing six files.

When you're ready to start the hands-on portion run these two commands in a terminal.

* `source /scratch/bioimagecourse2023/session4/setup.sh`
* `/scratch/bioimagecourse2023/session4/notebook.sh`

Otherwise:

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

Unsurprisingly, the recommended order for notebooks is:

1. `1_resample_images.ipnb`
2. `2_translation_initialization.ipnb`
3. `3_similarity_metrics.ipnb`
4. `4_multi_resolution.ipnb`
5. `5_nonlinear.ipynb`

## Dependencies 

* [simple-elastix](https://simpleelastix.github.io/)
* [itk-widgets](https://github.com/InsightSoftwareConsortium/itkwidgets)

## Registration tools

* Automatic
    * [elastix](https://elastix.lumc.nl/)
    * [ANTs](http://stnava.github.io/ANTs/)
    * [CMTK](https://www.nitrc.org/projects/cmtk/)
    * [BigStream](https://github.com/GFleishman/bigstream) (for big data)
* (Semi)Manual
    * [BigWarp](https://imagej.net/plugins/bigwarp)
    * [BigStitcher](https://imagej.net/plugins/bigstitcher/)
* Point cloud registration
    * Iterative closest point (ICP): classical algorithm with many implementations
    * Coherent point drift
        * [a copy of the original matlab code](https://github.com/weigert/CoherentPointDrift)
        * [a python reimplementation](https://github.com/siavashk/pycpd)
* Others
    * [Janelia "render services"](https://github.com/saalfeldlab/render)

## Acknowledgements

Thank you to the organizers of the course: Ignacio Arganda-Carreras, Anna Klemm, Perrine Paul-Gilloteaux, Christian Tischer,
Irena Provaznikova, and Alba Catherine Casas Saavedra. The Saalfeld lab and HHMI Janelia for supporting me, and all the course
particpants.

## Image credits

* CT / MR
    * Adapted from the [2007 MIT registration course](https://ocw.mit.edu/courses/health-sciences-and-technology/hst-582j-biomedical-signal-and-image-processing-spring-2007/lecture-notes/l16_reg1.pdf) by Zollei and Wells
* [JFRC2010](https://github.com/VirtualFlyBrain/DrosAdultBRAINdomains)
    * [Jenett et al 2012](http://dx.doi.org/10.1016/j.celrep.2012.09.011)
* [JFRC2018](https://www.janelia.org/open-science/jrc-2018-brain-templates)
    * [Bogovic et al 2020](https://doi.org/10.1371/journal.pone.0236495)

