import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import com.sergeyzorych.timetracker.buildlogic.configureAndroidKoin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Android Studio on 05/02/2023 18:18
 *
 * @author Sergey Zorych
 */
class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            val androidExtension = extensions.getByName("android")
            val extension: CommonExtension<*, *, *, *> =
                extensions.findByType<ApplicationExtension>()
                    ?: extensions.getByType<LibraryExtension>()

            configureAndroidKoin(androidExtension, extension)
        }
    }
}