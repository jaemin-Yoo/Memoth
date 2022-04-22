import com.jaemin.buildsrc.Depends

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        applicationId = "com.jaemin.memoth"
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        versionCode = Depends.Versions.appVersionCode
        versionName = Depends.generateVersionName()

        testInstrumentationRunner = Depends.Versions.testInstrumentationRunner
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
}

dependencies {
    implementation(project(":domain"))

    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.appcompat)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.constraintlayout)
    androidTestImplementation(Depends.Libraries.test_ext_junit)
    androidTestImplementation(Depends.Libraries.espresso_core)
}