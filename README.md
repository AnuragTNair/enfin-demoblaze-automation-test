# enfin-demoblaze-automation-test

# Demoblaze Automation Project

**Tech Stack**: Java 17, Maven, Selenium 4, TestNG, Log4j, Extent Reports, WebDriverManager

## Project Structure
```
src/test/java
  └── com/enfin
      ├── pages      # Page Object classes
      ├── tests      # Test classes
      ├── utils      # Utilities (screenshots, constants, etc.)
      └── listeners  # TestNG listeners
```
## Prerequisites
* Java 17+
* Maven 3.9+
* Chrome browser

## How to Run
```bash
mvn clean test
```
Test reports will be generated under `test-output/` (TestNG) and `reports/` (Extent).
