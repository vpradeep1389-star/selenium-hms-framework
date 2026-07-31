# HMS Site - Selenium Automation Framework
### Page Object Model + TestNG + Cucumber (BDD) + Extent Reports

## 1. Prerequisites

- Java JDK 17+ installed (`java -version`)
- Maven installed (`mvn -version`)
- Chrome and/or Firefox installed (WebDriverManager handles the driver binaries automatically — no manual driver downloads needed)

## 2. Setup on your machine (D:\ drive)

```powershell
cd D:\
# extract the zip here -> gives you D:\selenium-hms-framework
cd selenium-hms-framework
mvn clean install -DskipTests
```

Edit `src/test/resources/config.properties` and set:
- `base.url` — the HMS site URL
- `hms.username` / `hms.password` — your test login
- `browser` — `chrome` or `firefox`
- `headless` — `true` to run without a visible browser window

## 3. Folder structure & flow

```
selenium-hms-framework/
├── pom.xml                       # Maven dependencies (Selenium, TestNG, Cucumber, ExtentReports)
├── testng.xml                    # TestNG suite - registers the ExtentSuiteListener + TestRunner
│
├── src/main/java/com/hms/
│   ├── base/
│   │   ├── DriverManager.java    # creates/quits WebDriver (ThreadLocal-safe for parallel runs)
│   │   └── BasePage.java         # shared Selenium actions (click, type, isDisplayed, select...)
│   ├── pages/                    # ONE class per page = "Page Object" (locators + actions only)
│   │   ├── LoginPage.java
│   │   ├── customer/
│   │   ├── facility/
│   │   ├── inventory/
│   │   ├── manufacturer/
│   │   ├── vendor/
│   │   ├── ticket/
│   │   ├── contract/
│   │   └── billing/
│   └── utils/
│       ├── ConfigReader.java     # loads config.properties
│       └── ExtentReportManager.java  # singleton ExtentReports instance (ThreadLocal ExtentTest)
│
├── src/test/java/com/hms/
│   ├── stepdefinitions/
│   │   ├── Hooks.java            # @Before starts browser + Extent test node; @After screenshots on failure, quits browser
│   │   ├── LoginSteps.java
│   │   ├── CustomerSteps.java
│   │   └── ...one Steps class per page
│   ├── listeners/
│   │   └── ExtentSuiteListener.java  # flushes the Extent HTML report when the suite finishes
│   └── runners/
│       └── TestRunner.java       # Cucumber+TestNG entry point (points at features/ and glue package)
│
└── src/test/resources/
    ├── config.properties
    └── features/                 # Gherkin .feature files, mirrors pages/ folder structure
        ├── login.feature
        ├── customer/
        ├── facility/
        ├── inventory/
        ├── manufacturer/
        ├── vendor/
        ├── ticket/
        ├── contract/
        └── billing/
```

### The flow, in plain terms

1. **`pages/*.java`** — Each page object holds **locators** (`By` fields) and
   **actions** (methods like `login()`, `addCustomer()`, `searchCustomer()`).
   No assertions here — page objects describe the page, not the test.

2. **`features/*.feature`** — Plain-English Gherkin scenarios (`Given/When/Then`)
   that describe test cases. This is where YOU write new test cases as you go
   through each page — no Java needed to add a new scenario, just Gherkin steps.

3. **`stepdefinitions/*.java`** — Java code that maps each Gherkin line to
   actual Selenium actions, by calling page object methods. One `Steps` class
   per page, matching the feature file.

4. **`Hooks.java`** — Runs automatically before/after every scenario: starts
   the browser, creates an Extent report entry, captures a screenshot if the
   scenario fails, then closes the browser.

5. **`TestRunner.java` + `testng.xml`** — TestNG drives execution; Cucumber
   reads your `.feature` files and calls the matching step definitions.
   `ExtentSuiteListener` writes the final HTML report once everything's done.

### Example: how a scenario ties together

`features/login.feature`:
```gherkin
Scenario: Successful login with valid credentials
  Given I am on the login page
  When I login with valid credentials
  Then I should be redirected to the dashboard
```

`stepdefinitions/LoginSteps.java` maps each line to `LoginPage` methods:
```java
@Given("I am on the login page")
public void i_am_on_the_login_page() {
    loginPage.goTo();
}
```

## 4. What's already fully built vs. what's a template

Fully working examples (use these as your reference pattern):
- `pages/LoginPage.java` + `features/login.feature` + `stepdefinitions/LoginSteps.java`
- `pages/customer/CustomersPage.java` + `features/customer/customers.feature`
- `pages/customer/AddCustomerPage.java` + `features/customer/addCustomer.feature` (includes a data-table example)
- `stepdefinitions/CustomerSteps.java` covers both of the above

The remaining 17 pages (Customer Contact, Facilities, Inventory, Manufacturer,
Vendor, Tickets, Contracts, Billing) are scaffolded with the same structure —
placeholder locators, a basic "page is displayed" scenario, and a matching
Steps class — ready for you to extend with real locators and scenarios.

## 5. Recommended day-to-day workflow

1. Open the real HMS page in your browser, inspect the elements you need (F12 DevTools).
2. Update the placeholder `By` locators in the matching `pages/**/*.java` file.
3. Add new `Scenario:` blocks to the matching `.feature` file in plain English.
4. Run once — Cucumber will print "undefined step" snippets for any new step
   text you haven't implemented yet; paste those into the matching `Steps` class.
5. Run just one feature while developing by tagging it, e.g. add `@wip` above
   the scenario, set `tags = "@wip"` in `TestRunner.java` temporarily.

## 6. Running tests

```powershell
# Run the full suite via Maven + TestNG
mvn clean test

# Or run TestRunner.java directly from your IDE (right-click > Run)
```

Reports after a run:
- **Extent Report:** `test-output/ExtentReport.html` — open in any browser
- **Cucumber HTML report:** `test-output/cucumber-report.html`
- **Screenshots on failure:** attached automatically inside the Extent report

## 7. Dependencies included (pom.xml)

| Dependency | Purpose |
|---|---|
| `selenium-java` | Browser automation |
| `webdrivermanager` | Auto-downloads/matches the right ChromeDriver/GeckoDriver — no manual setup |
| `testng` | Test runner, assertions, suite/listener support |
| `cucumber-java` | Gherkin step definitions |
| `cucumber-testng` | Bridges Cucumber scenarios into TestNG execution |
| `extentreports` | Rich HTML test reports with screenshots |
| `log4j-core` / `log4j-api` | Logging |

## 8. Next steps once locators are real

- Add `@smoke`, `@regression` tags to scenarios so you can run subsets.
- Consider a login-once approach (save/reuse browser cookies) if login is slow and repeated across every scenario.
- Ask me to wire up parallel execution across `testng.xml` once you have enough scenarios to benefit from it.
