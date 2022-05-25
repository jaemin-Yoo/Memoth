import com.jaemin.buildsrc.Depends

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.material)
    testImplementation(Depends.Libraries.junit)
    androidTestImplementation(Depends.Libraries.espresso_core)

    // dependency injection
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
}