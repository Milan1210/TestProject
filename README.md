Selenium / Rest-ASSURED Maven-project
=======================

### About project
The same tool was used to write API and UI tests, that is Java Maven and not separated configuration is required to run them.
All what is needed is to set Java and Maven to system you run tests.

### Prerequisite
Install and Setup Java

Setup Maven

A maven template for Selenium 4 and Rest ASSURED 4 that have the latest dependencies so that you can just check out and start writing tests in four easy steps.
1. Open a terminal window/command prompt
2. Clone this project.
3. `cd simphony` (Or whatever folder you cloned it into)
4. `mvn clean verify`

All dependencies should now be downloaded and tests will have run successfully 

### What should I know?

- To run any suite tests on this project you just need to ensure right suite name, suit path or browser
```shell
mvn clean verify -DsuiteXmlFiles=suits/UI_tests.xml -Dbrowser=chrome
```

### Known problems...

As browser drivers Chrome, Firefox and Edge are supported, for some reason there is a problem runing test to Mac-OS Firefox, that problem is related to DriverManager dependecy 
and it can be resolved by adding ff driver directly to the project.

### Suported browsers?

You can specify which browser you want to use by using one of the following on the command line:
As mentioned above suported browsers are Chrome, FireFox and Edge

- `-Dbrowser=firefox`
- `-Dbrowser=chrome`
- `-Dbrowser=edge`

### Suits
The Suit define group of tests configured in xml file that can be run easily.
There are two suites in the project. One fore UI (UI_tests.xml) tests and second for API tests(BE_tests.xml), If you wanto to run all UI or API tests you don't have to run them separatly one by one
you can just run some of mentioned suit and all related tests will be run.


You don't need to worry about downloading the EdgeDriver, ChromeDriver and GeckoDriver binaries for cpecific system, this project will recognize your OS and will run webdriver according to that

### How to run test
By default if you run ``` mvn clean install ``` command the UI tests will be exetuting on Chrome browser, but you can choose which browser or suit you want to run, so there is simple command where you can specify which tests and where they will be run.
If you want to execute UI tests on edge browser you should specify only supported browser name like command below command below, you can copy and paste it to terminal of your project (the specified browser must be installed on the local machine)
```shell
mvn clean verify -DsuiteXmlFiles=suits/UI_tests.xml -Dbrowser=edge
```
If you want to execute API tests you should specify suit name with path and extension, you can use command below. Remember you don't have to specify browser for API tests because they don't use browser for their executing. 
```shell
mvn clean verify -DsuiteXmlFiles=suits/BE_tests.xml
```
