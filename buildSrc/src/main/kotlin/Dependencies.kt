object Dependencies {
    object Android {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
        const val activity = "androidx.activity:activity-ktx:${Versions.androidxActivity}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKTX}"
        }

        object Navigation {
            const val runtime =
                "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
            const val fragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
            const val dynamicFeatures =
                "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
            const val safeArgsGradle =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        }

        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
            const val ktx = "androidx.room:room-ktx:${Versions.room}"
        }

        object Test {
            const val junitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
        }
    }

    object JUnit {
        const val junit = "junit:junit:${Versions.jUnit}"
    }

    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
}

