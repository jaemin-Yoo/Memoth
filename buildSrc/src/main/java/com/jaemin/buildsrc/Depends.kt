package com.jaemin.buildsrc

import com.jaemin.buildsrc.Depends.Versions.appVersionCode

object Depends {

    object Versions {
        const val appVersionCode = 1_000_000
        const val androidCompileSdkVersion = 32
        const val targetSdkVersion = 32
        const val minSdkVersion = 21
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val constraintLayoutVersion = "2.1.3"
        const val supportVersion = "1.4.1"
        const val materialVersion = "1.4.0"
        const val coreKtxVersion = "1.7.0"
        const val junitVersion = "4.13.2"
        const val testExtJunitVersion = "1.1.3"
        const val espressoVersion = "3.4.0"
        const val application = "7.1.2"
        const val library = "7.1.2"
        const val kotlin_android = "1.5.30"
        const val kotlin_jvm = "1.5.30"
        const val bottomNavigationVersion = "1.6.0-alpha02"
        const val zagoriBottomNavigationVersion = "1.0.3"
    }

    object Libraries {
        const val android_core_ktx =
            "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val test_ext_junit = "androidx.test.ext:junit:${Versions.testExtJunitVersion}"
        const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val bottom_navigation = "com.google.android.material:material:${Versions.bottomNavigationVersion}"
        const val zagori_bottom_navigation = "io.github.zagori:bottomnavbar:${Versions.zagoriBottomNavigationVersion}"
    }

    fun generateVersionName(): String {
        val patch: Int = appVersionCode.rem(1000)
        val minor: Int = (appVersionCode / 1000).rem(1000)
        val major: Int = (appVersionCode / 1000000).rem(1000)

        return "$major.$minor.$patch"
    }
}