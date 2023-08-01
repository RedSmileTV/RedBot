plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "de.redsmiletv"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.dv8tion:JDA:5.0.0-beta.10")
    implementation("com.sedmelluq:lavaplayer:1.3.77")
    implementation ("com.google.apis:google-api-services-youtube:v3-rev222-1.25.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes ["Main-Class"] = "de.redsmiletv.Main"
    }
}

tasks.shadowJar {
    archiveFileName.set("RedBot-$version.jar")
}