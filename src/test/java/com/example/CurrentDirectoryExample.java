package com.example;

public class CurrentDirectoryExample {

    public static void main(String[] args) {
        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");
        String packagePath = "/src/main/java/org/Selenium";

        // Combine the root with the package path
        String fullPath = currentDirectory + packagePath;

        // Print the full path
        System.out.println("Full path including package directory: " + fullPath);

        // Print the current directory

    }
}

