// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.AndroidX.Navigation.safeArgsGradle)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}
