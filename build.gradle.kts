plugins {
    id("java")
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
    antlr("org.antlr:antlr4:4.13.1")
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}