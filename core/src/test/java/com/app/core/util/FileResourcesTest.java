/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author MARLON FIGUEROA
 */
public class FileResourcesTest {

    @DisplayName("Test loading a properties file")
    @Test
    void loadPropTest() throws IOException, URISyntaxException {

        String fileName = "application.properties";
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        //File file = new File(resource.getFile());
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        //lines.forEach(System.out::println);
        Assertions.assertEquals(8, lines.size());
    }

}
