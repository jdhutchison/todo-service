plugins {
  kotlin("jvm")
  kotlin("plugin.allopen")
  id("io.quarkus")
}

group = "sh.hutch"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
  implementation(enforcedPlatform("$quarkusPlatformGroupId:$quarkusPlatformArtifactId:$quarkusPlatformVersion"))

  implementation("io.quarkus:quarkus-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
  implementation("io.quarkus:quarkus-arc")
  implementation("io.quarkus:quarkus-config-yaml")
  implementation("io.quarkus:quarkus-rest")
  implementation("io.quarkus:quarkus-rest-jackson")
  implementation("io.quarkus:quarkus-smallrye-health")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(25)
  }
}

kotlin {
  jvmToolchain(25)
  compilerOptions {
    javaParameters = true
  }
}

allOpen {
  annotation("jakarta.ws.rs.Path")
  annotation("jakarta.enterprise.context.ApplicationScoped")
  annotation("jakarta.enterprise.context.RequestScoped")
  annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
