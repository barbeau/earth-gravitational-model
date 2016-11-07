# earth-gravitational-model [![Build Status](https://travis-ci.org/barbeau/earth-gravitational-model.svg?branch=master)](https://travis-ci.org/barbeau/earth-gravitational-model)
A lightweight port of the GeoTools [EarthGravitationalModel](http://docs.geotools.org/latest/javadocs/org/geotools/referencing/operation/transform/EarthGravitationalModel.html).

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