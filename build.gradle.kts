plugins {
    id("java")
}

group = "com.doiche"
version = "1.0-SNAPSHOT"

tasks.withType(JavaCompile::class.java){
    options.encoding = "UTF-8"
}
tasks.jar{
    destinationDir = File("C:\\Users\\3doll\\OneDrive\\바탕 화면\\1.19.2-test\\plugins")
}
repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("org.spigotmc:spigot:1.19.2-R0.1-SNAPSHOT")
    implementation("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
}