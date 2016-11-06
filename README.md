# earth-gravitational-model [![Build Status](https://travis-ci.org/barbeau/earth-gravitational-model.svg?branch=master)](https://travis-ci.org/barbeau/earth-gravitational-model)
A Java library that makes it easy to call the [Mapzen Pelias Search API](https://mapzen.com/documentation/search/search/)

### Requirements

You'll need [JDK 7 or higher](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

### Usage

The below example shows how to use the `EarthGravitationalModel`.

~~~
EarthGravitationalModel gh = new EarthGravitationalModel();
gh.load("/egm180.nor");
gh.heightOffset(45, 45, 0);
~~~

## Compiling the code yourself

### Setting up your environment

This project was created in [IntelliJ](https://www.jetbrains.com/idea/).  You can also compile it from the command line using [Maven](https://maven.apache.org/).

### Getting the code

To get started with this project, use a Git client to clone this repository to your local computer.  Then, in IntelliJ import the project as a Maven project.

### Build the project

* IntelliJ - Clean and build the project
* Maven - `mvn install`