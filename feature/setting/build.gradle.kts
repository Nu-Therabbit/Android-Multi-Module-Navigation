plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    id("androidx.navigation.safeargs.kotlin")
}

apply<DefaultGradlePlugin>()

android {
    namespace = "com.anusorn.feature.setting"
}

dependencies {

    androidxFragment()
    ktxLifecycleRuntime()
    coreBase()
    koin()
    navigationCore()
    navigation()
}
