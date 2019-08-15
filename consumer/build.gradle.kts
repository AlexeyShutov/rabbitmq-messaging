val springBootVersion = "2.1.7.RELEASE"

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

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

springBoot {
    mainClassName = "com.messaging.consumer.ConsumerApp"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-parent:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-amqp:$springBootVersion")
}