# earth-gravitational-model [![Build Status](https://travis-ci.org/barbeau/earth-gravitational-model.svg?branch=master)](https://travis-ci.org/barbeau/earth-gravitational-model)
A lightweight port of the GeoTools [EarthGravitationalModel](http://docs.geotools.org/latest/javadocs/org/geotools/referencing/operation/transform/EarthGravitationalModel.html) ([source code](https://github.com/geotools/geotools/blob/master/modules/plugin/referencing3D/src/main/java/org/geotools/referencing/operation/transform/EarthGravitationalModel.java)) that can be used on Android without requiring the entire GeoTools suite.

From the original `EarthGravitationalModel.java` file:

>This class transforms vertical coordinates using coefficients from the <A HREF="http://earth-info.nima.mil/GandG/wgs84/gravitymod/wgs84_180/wgs84_180.html">Earth Gravitational Model</A>.
This class is an adaption of Fortran code <code><a href="http://earth-info.nga.mil/GandG/wgs84/gravitymod/wgs84_180/clenqt.for">clenqt.for</a></code> from the <cite>National Geospatial-Intelligence Agency</cite> and available in public domain. The <cite>normalized geopotential coefficients</cite> file bundled in this module is an adaptation of <code><a href="http://earth-info.nima.mil/GandG/wgs84/gravitymod/wgs84_180/egm180.nor">egm180.nor</a></code> file, with some spaces trimmed.

The `egm180.nor` file is included in `src/main/resources` directory in this project.

### Requirements

You'll need [JDK 7 or higher](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

### Usage

The below example shows how to use the `EarthGravitationalModel`.

~~~
EarthGravitationalModel gh = new EarthGravitationalModel();
gh.load("/egm180.nor");

// GPS lat, lon, and altitude
double lat = 45;
double lon = 45;
double altitudeWgs84 = 0;

// Calculate the offset between the ellipsoid and geoid
double offset = gh.heightOffset(lat, lon, altitudeWgs84);

// Add the offset to the GPS altitude to get the height above the geoid (in meters)
double altitudeMeanSeaLevel = altitudeWgs84 + offset;
~~~

## Compiling the code yourself

### Setting up your environment

This project was created in [IntelliJ](https://www.jetbrains.com/idea/).  You can also compile it from the command line using [Maven](https://maven.apache.org/).

### Getting the code

To get started with this project, use a Git client to clone this repository to your local computer.  Then, in IntelliJ import the project as a Maven project.

### Build the project

* IntelliJ - Clean and build the project
* Maven - `mvn install`