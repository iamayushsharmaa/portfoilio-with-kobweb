import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    //alias(libs.plugins.kobweb.worker)
    // alias(libs.plugins.kobwebx.markdown)
}
group = "com.example.portfoliowebsite"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")
            }
            description.set("Powered by Kobweb")
            faviconPath.set("images/a_logo.svg")
        }
    }
}

kotlin {
    configAsKobwebApplication("portfoliowebsite")

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.compose.runtime)
            }
        }
        jsMain {
            dependencies {
                implementation(libs.compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.silk.icons.fa)
                //implementation(libs.kobweb.worker)
            }
        }
    }
}