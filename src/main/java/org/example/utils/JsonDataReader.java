package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataReader {

    private static final Logger logger = LogManager.getLogger(JsonDataReader.class);

    /**
     * Reads a JSON array from a file and converts it into a List of objects of the specified class.
     *
     * @param filePath The path to the JSON file.
     * @param typeReference A TypeReference representing the generic type of the List (e.g., new TypeReference<List<Post>>() {}).
     * @param <T> The type of the objects in the list.
     * @return A List of objects populated with data from the JSON file.
     */
    public static <T> List<T> readJsonArray(String filePath, TypeReference<List<T>> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("Reading JSON data from file: {}", filePath);
            return mapper.readValue(new File(filePath), typeReference);
        } catch (IOException e) {
            logger.error("Failed to read JSON data file: {}. Error: {}", filePath, e.getMessage());
            throw new RuntimeException("Could not read JSON data file.", e);
        }
    }
}
