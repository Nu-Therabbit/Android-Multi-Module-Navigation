import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

//util functions for adding the different type dependencies from build.gradle file

fun DependencyHandler.room() {
    implementation(Dependencies.AndroidX.Room.compiler)
    implementation(Dependencies.AndroidX.Room.ktx)
    kapt(Dependencies.AndroidX.Room.compiler)
}

fun DependencyHandler.androidxCore() {
    implementation(Dependencies.AndroidX.coreKtx)
}

fun DependencyHandler.androidxAppCompat() {
    implementation(Dependencies.AndroidX.appcompat)
}

fun DependencyHandler.androidxConstraintLayout() {
    implementation(Dependencies.AndroidX.constraintLayout)
}

fun DependencyHandler.androidxActivity() {
    implementation(Dependencies.AndroidX.activity)
}

fun DependencyHandler.androidxFragment() {
    implementation(Dependencies.AndroidX.fragment)
}

fun DependencyHandler.ktxLifecycleRuntime() {
    implementation(Dependencies.AndroidX.Lifecycle.runtime)
}

fun DependencyHandler.material() {
    implementation(Dependencies.Android.material)
}

fun DependencyHandler.koin() {
    implementation(Dependencies.koin)
}

fun DependencyHandler.navigationCore() {
    implementation(project(":core:navigation"))
}

fun DependencyHandler.homeFeature() {
    implementation(project(":feature:home"))
}

fun DependencyHandler.settingFeature() {
    implementation(project(":feature:setting"))
}

fun DependencyHandler.loginFeature() {
    implementation(project(":feature:login"))
}

fun DependencyHandler.coreBase() {
    implementation(project(":core:base"))
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.AndroidX.Navigation.runtime)
    implementation(Dependencies.AndroidX.Navigation.fragment)
    implementation(Dependencies.AndroidX.Navigation.ui)
    implementation(Dependencies.AndroidX.Navigation.dynamicFeatures)
}

fun DependencyHandler.junit() {
    test(Dependencies.JUnit.junit)
    androidTest(Dependencies.AndroidX.Test.junitExt)
}

fun DependencyHandler.espresso() {
    androidTest(Dependencies.AndroidX.Test.espressoCore)
}
