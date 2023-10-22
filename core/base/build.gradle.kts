plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<DefaultGradlePlugin>()

android {
    namespace = "com.anusorn.core.base"
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    androidxAppCompat()
    ktxLifecycleRuntime()
    navigation()
    material()
}
