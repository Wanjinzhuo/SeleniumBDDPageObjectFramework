# Java Selenium BDD Page Object Framework

This is a behavior-driven development (BDD) automation framework built with **Java**, **Cucumber**, and the **Page Object** design pattern. It's designed to streamline UI test automation using Selenium WebDriver, JUnit 5, and AssertJ.

---

## 📚 Table of Contents

- [Features](#features)
- [Installation](#installation)
- [How to Use](#how-to-use)
- [Test Execution](#test-execution)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## 🚀 Features

- **Cucumber BDD**: Write tests in Gherkin format for better readability and collaboration.
- **Page Object Pattern**: Encapsulates page logic to improve maintainability.
- **Selenium WebDriver**: Supports browser automation on Chrome, Firefox, and more.
- **JUnit 5**: For test execution and assertions.
- **AssertJ**: Fluent assertions for improved test readability.
- **Utility Classes**: Includes helpers like [WaitHelper](file://C:\repo\javaTest\src\test\java\utilities\WaitHelper.java#L10-L24), [Base64Helper](file://C:\repo\javaTest\src\test\java\utilities\Base64Helper.java#L5-L21), etc.

---

## 🛠️ Installation

1. Clone the repository:

   bash git clone https://github.com/Wanjinzhuo/SeleniumBDDPageObjectFramework.git 
   cd SeleniumBDDPageObjectFramework

2. Install dependencies using Maven:
    bash 
    mvn clean install

---

## 🧪 How to Use

To run all Cucumber tests:
    bash 
    mvn test

Tests are located in the `src/test/java` directory and use feature files from `resources`.

---

## 📊 Test Execution

After running tests, you can find the test reports in:

    target/cucumber-reports/

---

## 🗂️ Project Structure

    src/ 
    ├── test/ 
    │ ├── java/ 
    │ │ ├── pageObjects/ # Page-specific classes 
    │ │ ├── stepDefinitions/ # Cucumber step implementations 
    │ │ └── utilities/ # Helper classes (e.g., WaitHelper, Base64Helper) 
    │ └── resources/ 
    │ ├── config.properties # Configuration file 
    │ └── junit-platform.properties 
    └── main/ 
    └── java/ # Main application code (if any) 
    pom.xml # Maven build configuration
    README.md # This file

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repo
2. Create a new branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Submit a Pull Request

---

## 📄 License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

   