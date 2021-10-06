# earth-gravitational-model [![Java CI with Gradle](https://github.com/barbeau/earth-gravitational-model/actions/workflows/gradle.yml/badge.svg)](https://github.com/barbeau/earth-gravitational-model/actions/workflows/gradle.yml)
A lightweight port of the GeoTools [EarthGravitationalModel](http://docs.geotools.org/latest/javadocs/org/geotools/referencing/operation/transform/EarthGravitationalModel.html) ([source code](https://github.com/geotools/geotools/blob/master/modules/plugin/referencing3D/src/main/java/org/geotools/referencing/operation/transform/EarthGravitationalModel.java)) that can be used on Android without requiring the entire GeoTools suite.

From the original `EarthGravitationalModel.java` file:

>This class transforms vertical coordinates using coefficients from the <A HREF="http://earth-info.nima.mil/GandG/wgs84/gravitymod/wgs84_180/wgs84_180.html">Earth Gravitational Model</A>.
This class is an adaption of Fortran code <code><a href="http://earth-info.nga.mil/GandG/wgs84/gravitymod/wgs84_180/clenqt.for">clenqt.for</a></code> from the <cite>National Geospatial-Intelligence Agency</cite> and available in public domain. The <cite>normalized geopotential coefficients</cite> file bundled in this module is an adaptation of <code><a href="http://earth-info.nima.mil/GandG/wgs84/gravitymod/wgs84_180/egm180.nor">egm180.nor</a></code> file, with some spaces trimmed.

The `egm180.nor` file is included in `src/main/resources` directory in this project, which appears to be the EGM84 model.

Releases are published using the [GitHub Package Registry](https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-gradle).

*NOTE: You need [to authenticate with GitHub](https://github.com/TobseF/github-plugin-registry-example#enable-authentication) to download the below artifacts*

#### Maven

```xml
<repositories>
    <repository>
        <id>github</id>
        <name>GitHub earth-gravitational-model</name>
        <url>https://maven.pkg.github.com/barbeau/earth-gravitational-model</url>
        <releases><enabled>true</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
...
<dependency>
    <groupId>com.barbeaudev</groupId>
    <artifactId>earth-gravitational-model</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle

```groovy
repositories {
    maven { url 'https://maven.pkg.github.com/barbeau/earth-gravitational-model' }
}
    
dependencies {
    implementation 'com.barbeaudev:earth-gravitational-model:1.0.0'
}
```

### Requirements

You'll need [JDK 8 or higher](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

### Usage

The below example shows how to use the `EarthGravitationalModel`.

```java
EarthGravitationalModel gh = new EarthGravitationalModel();
gh.load("/egm180.nor");

// GPS lat, lon, and altitude
double lat = 45;
double lon = 45;
double altitudeWgs84 = 0;

// Calculate the offset between the ellipsoid and geoid
double offset = gh.heightOffset(lon, lat, altitudeWgs84);

// Add the offset to the GPS altitude to get the height above the geoid (in meters)
double altitudeMeanSeaLevel = altitudeWgs84 - offset;
```

## Compiling the code yourself

### Setting up your environment

This project was created in [IntelliJ](https://www.jetbrains.com/idea/).  You can also compile it from the command line using [Gradle](https://gradle.org/).

### Getting the code

To get started with this project, use a Git client to clone this repository to your local computer.  Then, in IntelliJ import the project as a Gradle project.

### Build the project

* IntelliJ - Clean and build the project
* Gradle - `./gradlew build`

### Releases

1. Change version from `x-SNAPSHOT to x`
2. Create a tag using Git
3. Create a GitHub release using that tag
4. Change version from `x` to `nextversion-SNAPSHOT`

The GitHub Action [publish.yml](.github/workflows/publish.yml) will then automatically create and publish a package for the [GitHub Package Registry](https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-gradle) as soon as the Release is published.

## License

This project is a port of the GeoTools [EarthGravitationalModel](http://docs.geotools.org/latest/javadocs/org/geotools/referencing/operation/transform/EarthGravitationalModel.html) ([source code](https://github.com/geotools/geotools/blob/master/modules/plugin/referencing3D/src/main/java/org/geotools/referencing/operation/transform/EarthGravitationalModel.java)) and therefore [inherits the LGPL license from that project](https://docs.geotools.org/latest/userguide/welcome/license.html).
