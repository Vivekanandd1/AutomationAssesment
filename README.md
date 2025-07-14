🧪 **End-to-End Automation Framework**
This project is an End-to-End (E2E) Test Automation Framework built using TestNG and Cucumber for running a Basic Regression Test Suite. It follows the Page Object Model (POM) design pattern for better code maintainability and scalability.

🔧 **Key Features**
✅ Hybrid Test Framework combining the strengths of TestNG and Cucumber:

       .TestNG for parallel execution, test configuration, and reporting.

       .Cucumber for writing human-readable test scenarios (Gherkin syntax).

🧱 Page Object Model (POM) to keep UI elements and test logic cleanly separated.

🧰 WebDriverFactory implemented as an abstract class to manage browser instantiation and driver configuration seamlessly.

🔄 Supports Cross-Browser Execution by configuring the desired browser type.

📊 [Coming Soon] Allure Reporting Integration for rich, interactive test reports.

📁 **Project Structure**
<pre> 
bash
Copy
Edit
├── src
│   ├── main
│   │   └── java
│   │       └── factory
│   │           └── WebDriverFactory.java   # Abstract class to manage WebDriver setup
│   ├── test
│   │   └── java
│   │       ├── pages                      # All Page Object classes
│   │       ├── stepDefinitions            # Cucumber Step Definitions
│   │       ├── runners                    # TestNG + Cucumber runner classes
│   │       └── utilities                  # Reusable utility classes (e.g., config reader, waits)
│
├── features                               # Gherkin feature files
│
├── testng.xml                             # TestNG suite configuration
├── pom.xml                                # Maven project configuration
└── README.md

</pre>
🚀 Getting Started
Clone the repository.

Install dependencies using Maven:

nginx
Copy
Edit
mvn clean install
Run tests using TestNG or Cucumber runner.


