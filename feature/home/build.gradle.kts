plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    id("androidx.navigation.safeargs.kotlin")
}

apply<DefaultGradlePlugin>()

android {
    namespace = "com.anusorn.feature.home"
}

dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    androidxFragment()
    ktxLifecycleRuntime()
    coreBase()
    koin()
    navigationCore()
    navigation()
}
