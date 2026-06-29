# 🧪 End-to-End Automation Framework

This repository contains an End-to-End (E2E) Test Automation Framework built with TestNG and Cucumber (Gherkin). The framework follows the Page Object Model (POM) design pattern and provides a basic regression test suite with support for cross-browser execution.

## 🔧 Key Features

- Hybrid framework using TestNG and Cucumber
  - TestNG for parallel execution, configuration, and reporting
  - Cucumber for readable feature files (Gherkin)
- Page Object Model (POM) to separate UI locators from test logic
- WebDriverFactory (abstract class) to manage browser instantiation and driver configuration
- Cross-browser execution via configurable browser settings
- [Planned] Allure reporting integration for interactive test reports

## 📁 Project Structure

```
├── src
│   ├── main
│   │   └── java
│   │       └── factory
│   │           └── WebDriverFactory.java   # Abstract class to manage WebDriver setup
│   ├── test
│   │   └── java
│   │       ├── pages                      # Page Object classes
│   │       ├── stepDefinitions            # Cucumber step definitions
│   │       ├── runners                    # TestNG + Cucumber runner classes
│   │       └── utilities                  # Reusable utilities (config reader, waits)
│
├── features                               # Gherkin feature files
├── testng.xml                             # TestNG suite configuration
├── pom.xml                                # Maven project configuration
└── README.md
```

## 🚀 Getting started

Prerequisites:
- Java 11+ (or the version declared in pom.xml)
- Maven 3.6+
- A supported browser (Chrome, Firefox, etc.) and matching WebDriver binaries if not using a manager

1. Clone the repository

   git clone https://github.com/Vivekanandd1/AutomationAssesment.git
   cd AutomationAssesment

2. Build and install dependencies

   mvn clean install

3. Run tests

- Run the default TestNG suite:

  mvn test -DtestngSuite=testng.xml

- Run via a Cucumber/TestNG runner class (example):

  mvn -Dtest=YourRunnerClass test

(Replace `YourRunnerClass` with the actual runner class name in `runners/`.)

## 📊 Reporting

- The project currently uses TestNG reports. Allure integration is planned — update will be added when configured.

## Contributing

Contributions and fixes are welcome. Open an issue or submit a PR with a short description of your change.

---

If you want, I can also:
- Add badges (build, test coverage)
- Wire up Allure reporting and add example commands
- Add a sample .env or config example for browser selection
