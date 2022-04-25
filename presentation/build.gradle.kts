import com.jaemin.buildsrc.Depends

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
    androidTestImplementation(Depends.Libraries.test_ext_junit)
    androidTestImplementation(Depends.Libraries.espresso_core)

    implementation(Depends.Libraries.bottom_navigation)
    implementation("io.github.zagori:bottomnavbar:1.0.3")
}