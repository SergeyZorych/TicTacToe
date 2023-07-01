package com.sergeyzorych.timetracker.buildlogic

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

/**
 * Created by Android Studio on 05/02/2023 17:58
 *
 * @author Sergey Zorych
 */

internal fun Project.configureAndroidKoin(
    androidExtension: Any,
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    when (androidExtension) {
        is AppExtension -> {
            androidExtension.applicationVariants.configureEach {
                kotlin.sourceSets {
                    getByName(name) {
                        kotlin.srcDirs("kotlin.srcDir(\"build/generated/ksp/${this.name}/kotlin\")")
                    }
                }
            }
        }

        is LibraryExtension -> {
            androidExtension.libraryVariants.configureEach {
                addJavaSourceFoldersToModel(file("kotlin.srcDir(\"build/generated/ksp/${this.name}/kotlin\")"))
            }
        }
    }

    commonExtension.apply {
        dependencies {
            val koinDeps = libs.findBundle("koin").get()
            val koinKspCompiler = libs.findLibrary("koin-ksp-compiler").get()
            add("implementation", koinDeps)
            add("ksp", koinKspCompiler)
        }
    }
}

internal val Project.kotlin: KotlinAndroidProjectExtension
    get() =
        (this as ExtensionAware).extensions.getByName("kotlin") as KotlinAndroidProjectExtension


internal fun KotlinAndroidProjectExtension.sourceSets(configure: Action<NamedDomainObjectContainer<KotlinSourceSet>>): Unit =
    (this as ExtensionAware).extensions.configure("sourceSets", configure)

