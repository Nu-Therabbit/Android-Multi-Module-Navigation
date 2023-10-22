import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class DefaultGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        setProjectConfig(target)
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            buildFeatures {
                viewBinding = true
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }
}
