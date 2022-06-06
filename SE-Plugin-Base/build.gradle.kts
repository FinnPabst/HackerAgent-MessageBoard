import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "FinnPabst.jvm"
version = "1.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("lib/airportargentsim.jar"))
    implementation(kotlin("script-runtime"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}