# AsyncTask Android Library
A simple AsyncTask Library. It is very easy to use, to use this library follow these steps.


## For Gradle:
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency:
```
dependencies {
        implementation 'com.github.mrasif:android-asynctask:v1.0.0'
}
```
### For Maven:
Step 1. Add the JitPack repository to your build file:
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
Step 2. Add the dependency:
```
<dependency>
    <groupId>com.github.mrasif</groupId>
    <artifactId>android-asynctask</artifactId>
    <version>v1.0.0</version>
</dependency>
```
### For SBT:
Step 1. Add the JitPack repository to your build.sbt file:
```
resolvers += "jitpack" at "https://jitpack.io"
```
Step 2. Add the dependency:
```
libraryDependencies += "com.github.mrasif" % "android-asynctask" % "v1.0.0"
```
### For Leiningen:
Step 1. Add it in your project.clj at the end of repositories:
```
:repositories [["jitpack" "https://jitpack.io"]]
```
Step 2. Add the dependency:
```
:dependencies [[com.github.mrasif/android-asynctask "v1.0.0"]]
```


Now you can use AsyncTask feature in android project.