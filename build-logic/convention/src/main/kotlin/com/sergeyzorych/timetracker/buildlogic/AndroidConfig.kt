package com.sergeyzorych.timetracker.buildlogic

import org.gradle.api.JavaVersion

/**
 *  Created by Android Studio on 5/5/21 8:07 PM
 *  Developer: Sergey Zorych
 */

object AndroidConfig {

    private const val major = 1
    private const val minor = 0
    private const val patch = 0

    private val ciBuildNumber = System.getenv("CI_PIPELINE_IID")?.toInt()
    private const val clearVersionCode = (10000 * major + 100 * minor + patch)

    const val compileSdkVersion = 33
    const val targetSdkVersion = 33
    const val minSdkVersion = 26
    const val androidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    @JvmStatic
    val versionCode = ciBuildNumber?.let { clearVersionCode + ciBuildNumber } ?: clearVersionCode

    @JvmStatic
    val versionName = "$major.$minor.$patch"

    val javaVersion = JavaVersion.VERSION_17
    val jvmTarget = javaVersion.toString()


    val freeCompilerArgs = listOf(
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi",
        "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
    )
}