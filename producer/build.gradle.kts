import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.1.7.RELEASE")
    }
}

plugins {
    java
    id("org.springframework.boot") version "2.1.7.RELEASE"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.getByName<BootJar>("bootJar") {
    mainClassName = "com.messaging.producer.ProducerApp"
    group = "com.messaging.services"
    baseName = "producer"
    version = "1.0-SNAPSHOT"
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.1.7.RELEASE"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-parent:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-amqp:$springBootVersion")
}