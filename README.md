

# Rest Assured API Automation Framework 🚀

This is a production-grade API automation framework designed to validate RESTful APIs efficiently and reliably. Built on a robust architecture, the framework prioritizes scalability, maintainability, and security, making it suitable for both small projects and large-scale enterprise applications.

## Key Features & Technologies

* **REST Assured**: A powerful Java library for testing REST services.
* **TestNG**: The primary test framework for managing test suites, parallel execution, and assertions.
* **Maven**: Manages all project dependencies, builds, and test executions.
* **Lombok & Jackson**: Used for creating simple POJOs for API request/response payloads, ensuring type-safe data handling.
* **Log4j2**: Provides detailed, configurable logging for efficient debugging and test visibility.
* **Allure Reporting**: Generates beautiful, interactive HTML reports that provide a comprehensive overview of test results, including trends, timelines, and execution details.
* **Configuration Management**: A centralized `ConfigManager` handles environment-specific properties and securely retrieves sensitive data like API tokens from environment variables.
* **Data-Driven Capabilities**: The framework is designed to support data-driven testing by externalizing test data from the code.
* **Client Layer**: A dedicated API client layer abstracts HTTP requests and responses from test scripts, making tests cleaner and more maintainable.
* **Utility Classes**: Includes reusable utility methods for common tasks like data generation and robust error handling.

## Framework Architecture

The framework is designed around a multi-layered, scalable architecture:

1.  **Configuration Layer**: Manages all environment and configuration properties from external `.properties` files.
2.  **Test Base Layer**: A `BaseTest` class centralizes setup and teardown logic to enforce the DRY (Don't Repeat Yourself) principle.
3.  **API Client Layer**: Dedicated classes for each API resource handle all requests and responses, separating the "how" from the "what."
4.  **Test Layer**: Test classes contain the core test logic, focusing solely on validating business requirements.
5.  **Utility & Helper Layer**: Houses reusable methods for logging, data generation, and common assertions, ensuring code reusability and efficiency.
6.  **Reporting Layer**: Allure reporting is integrated to provide rich, visual insights into test execution.

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 21 or higher
* Apache Maven 3.6+

### Build and Run Tests

1.  Clone the repository to your local machine:
    ```
    git clone [https://github.com/PrabodhGhosh/rest-assured-api-automation-framework.git](https://github.com/PrabodhGhosh/rest-assured-api-automation-framework.git)
    ```
2.  Navigate to the project root directory:
    ```
    cd rest-assured-api-automation-framework
    ```
3.  Execute all tests using Maven:
    ```
    mvn clean test
    ```

### Generate and View Allure Report

After the tests have been executed, you can generate and view the interactive Allure report.

1.  Run the following command to generate and serve the report on a local web server:
    ```
    mvn allure:serve
    ```
2.  This will automatically open the report in your default web browser.

## Extensibility

This framework is built with **extensibility** in mind. Key areas for expansion include:

* **Continuous Integration**: Easily integrate into a CI/CD pipeline (e.g., Jenkins, GitLab CI) to automate test execution on every code commit.
* **Parallel Execution**: Configure TestNG and Maven to run tests in parallel, significantly reducing execution time for large test suites.
* **Enhanced Reporting**: Extend Allure reports with annotations like `@TmsLink` and `@Story` for improved test traceability.

