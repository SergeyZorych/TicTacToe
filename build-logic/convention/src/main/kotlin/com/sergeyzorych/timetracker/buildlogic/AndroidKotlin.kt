import com.android.build.api.dsl.CommonExtension
import com.sergeyzorych.timetracker.buildlogic.AndroidConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by Android Studio on 04/29/2023 21:02
 *
 * @author Sergey Zorych
 */

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = AndroidConfig.compileSdkVersion

        defaultConfig {
            minSdk = AndroidConfig.minSdkVersion
        }

        compileOptions {
            sourceCompatibility = AndroidConfig.javaVersion
            targetCompatibility = AndroidConfig.javaVersion
        }
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = AndroidConfig.jvmTarget
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                // Enable experimental coroutines APIs, including Flow
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-opt-in=kotlinx.coroutines.FlowPreview",
            )
        }
    }

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
        val timberDep = libs.findLibrary("timber").get()
        add("implementation", timberDep)
    }
}