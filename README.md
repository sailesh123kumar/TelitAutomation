# Telit Automation

A robust **Test Automation Framework** built with Java, Selenium, and TestNG for automating test scenarios on the Telit platform.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Data](#test-data)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This project is a comprehensive test automation framework designed to automate end-to-end testing scenarios for the Telit application. It follows industry best practices with modular design, data-driven testing, and comprehensive reporting capabilities.

## ✨ Features

- **Selenium WebDriver Integration** - Cross-browser automation support
- **Page Object Model (POM)** - Maintainable and scalable test structure
- **TestNG Framework** - Powerful test execution and reporting
- **Data-Driven Testing** - Support for CSV and Excel data sources
- **ExtentReports** - Beautiful and detailed HTML test reports
- **Log4j Logging** - Comprehensive logging mechanism
- **Maven Build Tool** - Easy dependency management and test execution
- **Headless Mode Support** - Run tests in headless browsers for CI/CD
- **Screenshot Capture** - Automatic screenshot on test failures
- **LambdaTest Integration** - Cloud-based browser testing support

## 🛠 Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17 | Core programming language |
| **Selenium WebDriver** | 4.37.0 | Web browser automation |
| **TestNG** | 7.10.2 | Test execution framework |
| **Maven** | 3.9.x | Build and dependency management |
| **ExtentReports** | 5.0.8 | Test reporting |
| **Log4j** | 2.24.3 | Logging |
| **Apache POI** | 5.4.1 | Excel file handling |
| **OpenCSV** | 5.10 | CSV file handling |
| **Gson** | 2.12.1 | JSON parsing |
| **Lombok** | 1.18.32 | Boilerplate code reduction |

## 📁 Project Structure

```
TelitAutomation/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/              # Page Object Model classes
│   │       ├── base/               # Base classes and utilities
│   │       ├── utils/              # Helper utilities
│   │       └── config/             # Configuration classes
│   └── test/
│       └── java/
│           └── tests/              # Test classes
├── testData/                        # Test data files (CSV, Excel)
├── config/                          # Configuration files
├── screenshots/                     # Failed test screenshots
├── pom.xml                         # Maven configuration
├── testng.xml                      # TestNG test suite configuration
└── README.md                       # This file
```

## 📦 Prerequisites

- **Java JDK 17** or higher
- **Maven 3.9.x** or higher
- **Git** for version control
- **Chrome/Firefox/Edge browser** (for local testing)
- **Internet connection** (for cloud-based testing with LambdaTest)

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/sailesh123kumar/TelitAutomation.git
cd TelitAutomation
```

### 2. Install Dependencies

```bash
mvn clean install
```

This will download all required dependencies specified in `pom.xml`.

### 3. Verify Installation

```bash
mvn -version
java -version
```

## ⚙️ Configuration

### 1. Browser Configuration

Update the `testng.xml` or use system properties to configure:

```xml
<parameter name="browser" value="chrome" />
<parameter name="isHeadless" value="false" />
<parameter name="isLambdaTest" value="false" />
```

**Supported Browsers:**
- `chrome` - Google Chrome
- `firefox` - Mozilla Firefox
- `edge` - Microsoft Edge

### 2. Environment Setup

Create a `config.properties` file in the `config/` directory:

```properties
# Application URL
app.url=https://telit.example.com

# Headless Mode
headless.mode=false

# Browser Configuration
browser.name=chrome
implicit.wait=10
explicit.wait=20

# LambdaTest Configuration (if using cloud)
lambdatest.username=your_username
lambdatest.access.key=your_access_key
```

### 3. Test Data Configuration

Place your test data files in the `testData/` directory:
- Excel files (`.xlsx`)
- CSV files (`.csv`)
- JSON files for API testing

## ▶️ Running Tests

### 1. Run All Tests

```bash
mvn clean test
```

### 2. Run Specific Test Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### 3. Run with Custom Parameters

```bash
mvn clean test -Dbrowser=firefox -DisHeadless=true -Dgroups=smoke
```

### 4. Run Specific Test Class

```bash
mvn test -Dtest=TestClassName
```

### 5. Run Tests on LambdaTest Cloud

```bash
mvn clean test -DisLambdaTest=true -Dbrowser=chrome
```

### 6. Generate Report After Test Run

```bash
mvn clean test -Dreport=true
```

## 📊 Test Data

### Excel Data Format

Create Excel files in `testData/` with columns as test parameters:

| Username | Password | Expected Result |
|----------|----------|-----------------|
| user1    | pass1    | Success         |
| user2    | pass2    | Success         |

### CSV Data Format

```csv
username,password,expected_result
user1,pass1,Success
user2,pass2,Success
```

## 📈 Reporting

### ExtentReports

After test execution, the HTML report is generated in:
```
target/extent-reports/ExtentReport.html
```

**Report Features:**
- Test execution summary
- Pass/Fail statistics
- Screenshots on failures
- Detailed logs
- Timeline view

### View Report

```bash
# Open the report in browser (on Mac/Linux)
open target/extent-reports/ExtentReport.html

# On Windows
start target/extent-reports/ExtentReport.html
```

## 🔍 Best Practices

1. **Page Object Model** - Create one page class per page
2. **Explicit Waits** - Use explicit waits instead of sleep()
3. **Test Data Separation** - Keep test data separate from test logic
4. **Logging** - Log important steps and actions
5. **Screenshots** - Capture screenshots on failures
6. **Assertions** - Use meaningful assertion messages
7. **Reusable Methods** - Create utility methods for common actions

## 🐛 Troubleshooting

### Issue: Tests not running
- Verify Java version: `java -version`
- Clear Maven cache: `mvn clean`
- Check pom.xml for syntax errors

### Issue: Browser not found
- Install the required browser
- Check browser PATH variable
- Use headless mode if browser GUI is unavailable

### Issue: Tests timing out
- Increase `explicit.wait` timeout
- Check internet connection (for cloud testing)
- Verify application URL is accessible

### Issue: Screenshots not saved
- Ensure `screenshots/` directory exists and has write permissions
- Check file path configuration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is private and owned by sailesh123kumar. All rights reserved.

## 👨‍💻 Author

**Sailesh Kumar**  
GitHub: [@sailesh123kumar](https://github.com/sailesh123kumar)

## 📧 Support

For issues, questions, or suggestions, please create an [Issue](https://github.com/sailesh123kumar/TelitAutomation/issues) in the repository.

---

**Last Updated:** June 12, 2026  
**Project Version:** 0.0.1-SNAPSHOT
