package org.example.tests.base;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.ConfigManager;
import org.testng.annotations.*;


public abstract class BaseTest {

    /*
     * The BaseTest class serves as the parent for all test classes.
     * It is responsible for setting up the common test environment
     * for the entire test suite.
     */

    private static final Logger logger = LogManager.getLogger(ConfigManager.class);
    private final ConfigManager configManager = ConfigManager.getInstance();

    /*
     * This method runs once before the entire test suite.
     * It uses the configuration manager to set the base URI for Rest Assured.
     */

    @BeforeSuite(alwaysRun = true)

    public void setUp()
    {
        logger.info("Executing @BeforeSuite: Global test suite setup.");
        RestAssured.baseURI = configManager.getBaseUri();
        logger.info("The base uri is "+configManager.getBaseUri());
    }

    /*
     * This method runs once after the entire test suite.
     * It is used for any global cleanup, such as stopping a mock server.
     */

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        logger.info("Executing @AfterSuite: Global test suite teardown.");

    }

    /**
     * This method runs once before any tests in a test tag.
     */
    @BeforeTest
    public void beforeTest() {
        logger.info("Executing @BeforeTest: Test group setup.");
    }

    /**
     * This method runs once after all tests in a test tag.
     */
    @AfterTest
    public void afterTest() {
        logger.info("Executing @AfterTest: Test group teardown.");
    }

    /**
     * This method runs before each test method.
     */
    @BeforeMethod
    public void beforeMethod() {
        logger.info("Executing @BeforeMethod: Test method setup.");
    }

    /**
     * This method runs after each test method.
     */
    @AfterMethod
    public void afterMethod() {
        logger.info("Executing @AfterMethod: Test method teardown.");
    }

}
