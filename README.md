# Selenium Page Object Model with Cucumber 





#### Introduction

A modular approach to application of Page Object Model with Java and Cucumber. This repository contains information about Page Object Model, Selenium Grid, BDD methods, logging, locator management, driver types, environment management and multi-browser support in Selenium.

<br />

#### Table Of Content
-------------
- [Introduction](#introduction)
- [Test Rules](#-test-rules)
- [Project Structure](#-project-structure)
- [Dependencies](#-dependencies)
- [Utilities](#-utilities)
    - [Locator Manager](#locator-manager)
    - [Config Manager](#config-manager)
    - [Environment Manager](#environment-manager)
         - [How to change environment variable?](#how-to-change-environment-variable)
    - [Page Object Manager](#page-object-manager)
    - [Driver Manager](#driver-manager)
- [Enums](#-enums)
    - [Browser Types](#browser-types)
    - [Driver Types](#driver-types)
    - [Environments](#environments)
 - [What is TestContext class?](#-what-is-testcontext-class)
 - [Services (API)](#-services)
 - [Properties File](#-properties-file)
 - [How to run tests?](#-how-to-run-tests)
 - [How to run parallel tests with Docker and Selenium Grid?](#-how-to-run-parallel-tests-with-docker-and-selenium-grid)
   - [Increasing Maximum Session Limit](#increasing-maximum-session-limit)
- [License](#license)

<br/>


#### Test Rules
-------------
- Simplified, efficient and easy to understand BDD clauses.
- Grammerly understandable and reusable clauses.
 - 1 behavior means 1 scenario. It means 1 scenario tests only 1 behavior. So you can easily make changes in scenario to change behavior.
- Completely reusable commands. So you can implement same clause again and again. Simply change input variable in clause if exist then you can run.

<br>


#### Project Structure
-------------
    📁 Enums
         📁 BrowserTypes
         📁 DriverTypes
         📁 Environments
    📁 Feature
         📁 Homepage.feature
    📁 Models
         📁 Locator
    📁 Pages
         📁 BasePage
         📁 HomePage
         📁 SearchPage
    📁 Steps
         📁 HomeSteps
         📁 SearchSteps
    📁 Utils
         📁 ConfigManager
         📁 DriverManager
         📁 EnvironmentManager
         📁 LocatorManager
         📁 PageObjectManager
         📁 SmartDateFormatter
         📁 TestContext
    📁Resources
         📁 drivers
         📁 outputs
         📁 page-objects

<br/>


#### Dependencies
-------------
* Selenium (version 4.0.0-alpha-6)

* Cucumber (version 5.6.0)

* Log4J (version 2.14.1)

* JUnit (version 4.13.2)

* Lombok (version 1.18.30)

* Gson (version 2.10.1)

<br/>


#### Utilities
-------------

* ##### Locator Manager
  	The Locator Manager is a crucial component of this project. Its primarily used to manage and organize the locators of HTML elements used in web application. These locators are essential for interacting with and automating various user interactions on a web page. Every page has distinct json data that store locators information. Locator manager reaches all locators and serves to the application
    
    
* ##### Config Manager
  	The Config Manager is retrieve constants from properties config.properties file in main directory. After retrieved these constants it's immediately sets keys as system property. Thanks to that these contants is reacheable in every part of project.
    
    
* ##### Environment Manager
  	Environment Manager, controls which environment is set to run tests. You can easily set and get current environment for logical operations.
    -  ###### How to change environment variable?
  	   You can use TestContext instance to reach EnvironmentManager. Then you can get and set environment variable using Environment Enums.
    
    
            
* ##### Page Object Manager
  	The PageObjectManager class exists to provide a centralized and efficient way of managing and initializing Page Objects in project. It encapsulates the instantiation of page objects, promoting code reusability, and improving the maintainability of the test automation framework.In this class, it initializes and caches the Page Objects, ensuring that each Page Object is created only once and reused as needed, which reduces the overhead of creating new instances of page objects throughout the test suite. This results in cleaner and more efficient test scripts by abstracting away the details of how page objects are created and managed.
    
    
                
* ##### Driver Manager
  DriverManager manages and facilitate the configuration and creation of WebDriver instances in a project. It plays a pivotal role in handling different browser types, local and remote execution, as well as loading the appropriate web application URL based on the selected environment.



<br/>


#### Enums
-------------

* ##### Driver Types
    > - REMOTE
    > - LOCAL

    
* ##### Browser Types
    > - CHROME
    > - FIREFOX
    > - EDGE
    > - SAFARI

    
* ##### Environments 
    > - TEST
    > - QA
    > - STAGING
    > - PROD



<br/>


#### What is TestContext class?
-------------

TestContext class serve as a central container or context for managing key components and resources in a project. It is responsible for initializing and providing access to essential objects, including the WebDriver Manager, Environment Manager, and Page Object Manager. This class helps ensure a clean, low memory usage and organized structure for project.



<br/>



#### Services
-------------

Services are the classes that contains methods to interact with REST API. These methods are used in step definitions to interact with API to assert the results. Services are created to keep the step definitions clean and easy to understand. Services are created for each resource in the API. For example, if there are multiple endpoints for a resource, then a single service class is created for that resource. Each method in the service class corresponds to an endpoint in the API. The methods in the service class are used to interact with the API and return the response. The response is then used in the step definitions to assert the results.

* ##### AuthService.java
  > - login()
  > - refreshToken()
  > - logout()

* ##### AccountService.java
  > - getAccountInformation()
  > - updateAccountInformation()


<br/>


#### Properties File
-------------

The variables in this file serving by Config Manager to whole projects. It easily accessible with key in every level of structure.

 > config.properties
 
    seleniumGridUrl = http://localhost:4444
    randomizeBrowsers = false
    driverType = LOCAL
    browserType = CHROME
    environment = TEST



<br/>


#### How to run tests?
-------------

Run this command in OS terminal:

`$ npm clone https://github.com/hilaldkmn`



Run this command in IDE terminal to install dependencies:

`$ mvn install`

Then you can run project to see test result.



<br/>


#### How to run parallel tests with Docker and Selenium Grid?
-------------
Navigate project folder in terminal and run this command. It runs Selenium Hub, Chrome, Firefox, Edge and Safari nodes.

```bash
  docker compose -f docker-compose.yml up
```

You can change browser type, driver type and randomize browser settings in config.properties or Driver Manager class

```bash
    browserType = BrowserType.CHROME;
    driverType = DriverType.REMOTE;
    randomizeBrowsers = false;
```

Then you can follow your running tests and nodes in Selenium Hub at http://localhost:4444

<br>


*  ##### Increasing Maximum Session Limit

    Change max session variable at docker-compose.yml like shown below:

    ```bash
    - SE_NODE_MAX_SESSIONS=5
    ```
  
  <br/>


#### License
* [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0 "Apache 2.0 License")
* 2025 - Hilal DİKMAN
