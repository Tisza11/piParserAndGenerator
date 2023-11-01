plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("application")
    antlr
}

group = "hu.bme.mit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.beust:jcommander:1.82")
    antlr("org.antlr:antlr4:4.13.1")
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClassName = "piConcurrent.Main"
}
