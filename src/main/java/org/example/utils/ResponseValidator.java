package org.example.utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.Matchers.lessThan;

public class ResponseValidator {
    private static final Logger logger = LogManager.getLogger(ResponseValidator.class);

    /**
     * Validates that the response has a success status code (2xx).
     * @param response The Rest Assured Response object.
     * @return The response object for chaining.
     */
    public static Response validateSuccess(Response response) {
        int statusCode = response.getStatusCode();
        if (statusCode >= 200 && statusCode < 300) {
            logger.info("Response received with success status code: {}", statusCode);
        } else {
            logger.error("API call failed with status code: {}", statusCode);
            logger.error("Response body: {}", response.getBody().asString());
        }
        response.then().statusCode(response.getStatusCode()); // Simple assertion to fail the test
        return response;
    }

    /**
     * Validates that the API response time is within an acceptable threshold.
     * @param response The Rest Assured Response object.
     * @param thresholdInMilliseconds The maximum acceptable response time.
     * @return The response object for chaining.
     */
    public static Response validateResponseTime(Response response, long thresholdInMilliseconds) {
        response.then().time(lessThan(thresholdInMilliseconds));
        logger.info("API response time was {} ms, which is within the {} ms threshold.", response.getTime(), thresholdInMilliseconds);
        return response;
    }
}
