import com.jaemin.buildsrc.Depends

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion

        testInstrumentationRunner = Depends.Versions.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.appcompat)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.constraintlayout)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    androidTestImplementation(Depends.Libraries.test_ext_junit)
    androidTestImplementation(Depends.Libraries.espresso_core)

    // Custom bottom nav
    //implementation(Depends.Libraries.zagori_bottom_navigation)
    implementation("com.github.ibrahimsn98:SmoothBottomBar:1.7.9")

    // Jetpack navigation
    implementation(Depends.Libraries.navigation_fragment_ktx)
    implementation(Depends.Libraries.navigation_ui_ktx)

    // dependency injection
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
}