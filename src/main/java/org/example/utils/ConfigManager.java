package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;


    public final class ConfigManager {

        /**
         * A utility class for managing configuration properties from a file.
         * This class loads the 'config.properties' file and provides a method
         * to retrieve properties by key.
         */

        private static final Logger logger = LogManager.getLogger(ConfigManager.class);
        private static final Properties prop = new Properties();
        private static final ConfigManager INSTANCE = new ConfigManager();


        private ConfigManager() {
            // Get environment from system property, defaulting to "dev"
            String environment = System.getProperty("env", "dev").toLowerCase();
            String configFileName = String.format("config/%s.properties", environment);

            logger.info("Loading configuration for environment: {}", environment);
            try (InputStream is = getClass().getClassLoader().getResourceAsStream(configFileName)) {
                if (is == null) {
                    logger.error("config.properties file not found in the classpath.");
                    throw new IOException("config.properties file not found.");
                }
                prop.load(is);
            } catch (IOException e) {
                logger.error("Error loading config.properties file: {}", e.getMessage());
                throw new RuntimeException("Could not load config.properties file.", e);
            }
        }

        /**
         * Retrieves the singleton instance of the ConfigManager.
         * @return The ConfigManager instance.
         */
        public static ConfigManager getInstance() {
            return INSTANCE;
        }

        /**
         * Retrieves a property value from the configuration.
         * @param key The key of the property.
         * @return The value of the property.
         */
        public String getString(String key) {
            String value = prop.getProperty(key);
            if (value == null || value.isEmpty()) {
                logger.warn("Property '{}' not found in config.properties.", key);
            }
            return value;
        }

        /**
         * Retrieves the base URI from the configuration.
         * @return The base URI string.
         */
        public String getBaseUri() {
            return getString("base.uri");
        }

        /**
         * Retrieves the API authentication token, checking for an environment variable first.
         * This is a best practice for handling sensitive data.
         * @return The authentication token.
         */
        public String getAuthToken() {
            String authToken = System.getenv("AUTH_TOKEN");
            if (authToken != null && !authToken.isEmpty()) {
                logger.info("Using auth token from environment variable.");
                return authToken;
            }
            return getString("auth.token");
        }

        /**
         * Retrieves the mock server port.
         * @return The port as a string.
         */
        public String getMockServerPort() {
            return getString("mock.server.port");
        }
}
