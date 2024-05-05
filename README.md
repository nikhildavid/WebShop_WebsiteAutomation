# Web Shop Automation
Framework is built in POM design pattern using TestNG framework integrated with Maven. 

# Requirements
To utilise this project, you need to have the following installed locally:
Maven
Java 
IDE (Selenium)

# Usage

This project handle execution of test cases through Command line using maven commands.
To run the test cases in a particular browser change the browser value in the below command. 
mvn test -Dbrowser=edge

If browser is not passed as an argument in the maven command, then browser value set in the configuration file will be taken. If no browser has been set, then Chrome driver will be the default browser.
Configuration file is available in the below path:
WebShop_App\src\test\resources\config.properties

# Reporting
Reports for each suite run will written into the below directory.
WebShop_App\reports\WebShop_Test Execution Report.html

# Utilities
Utility methods are written under Utilities package. These methods can be reused across different tests within the project. It includes both generic functions, and application specific functions. 

