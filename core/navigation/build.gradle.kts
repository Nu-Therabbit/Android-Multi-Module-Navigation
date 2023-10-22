plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
    id("androidx.navigation.safeargs.kotlin")
}

apply<DefaultGradlePlugin>()

android {
    namespace = "com.anusorn.core.navigation"
}

dependencies {
    koin()
    navigation()
}
