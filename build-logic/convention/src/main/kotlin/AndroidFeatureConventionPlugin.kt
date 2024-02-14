import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Android Studio on 05/07/2023 22:25
 *
 * @author Sergey Zorych
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("timetracker.android.library")
                apply("timetracker.android.library.compose")
                apply("timetracker.android.koin")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":shared:design_system"))
                add("implementation", project(":shared:navigation"))
                add("implementation", project(":shared:core"))
                add("implementation", project(":shared:utils"))
                add("implementation", project(":domain"))

                val voyagerDeps = libs.findBundle("voyager").get()
                val lifecycleDeps = libs.findBundle("lifecycle").get()
                add("implementation", voyagerDeps)
                add("implementation", lifecycleDeps)
            }
        }
    }
}