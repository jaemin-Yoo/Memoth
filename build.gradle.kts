buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.jaemin.buildsrc.Depends.ClassPaths.gradle)
        classpath(com.jaemin.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin)
        classpath(com.jaemin.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}