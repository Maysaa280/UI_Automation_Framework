# gk_web_automation

This project demonstrates web UI automation using Java, Selenium WebDriver, TestNg and gradle build tool and the website used is http://automationpractice.com.
The framework has been built to make it easy for test engineers to add new features/testcases of scripts.

### How to get started?

Without further ado, let us dive straight into what we need to get started running this project on local,
following are the tools and the how to's we need to get started. Some dependancies like Selenium WebDriver and TestNG are referenced on gradle,
so there's no manual configs or installation needed for them, they will be automatically downloaded and installed when we build the project.

#### prerequisite

* JDK version 8 or greater
* Gradle 3.3 or greater
* IntelliJ IDE
* Gitbash (optional)

##### Installing JDK and setting environment variables

Please follow the steps from https://www.theserverside.com/tutorial/How-to-install-the-JDK-on-Windows-and-setup-JAVA_HOME to install JDK.

##### Installing IntelliJ

Please download and install IntelliJ IDE from https://www.jetbrains.com/idea/

##### Installing gradle

Please follow the instruction from https://docs.gradle.org/current/userguide/installation.html to install gradle and set environment variables.

#### Cloning the project

- From Windows explorer, navigate to the location the project will exist/run from
- Open Gitbash/CLI of your choice, ensure the locationm is the one you wish to run the project from
- Run the following command:
  ```
  git clone https://github.com/luvomgulwa/gk_web_automation.git
  ```
- Once the project has finished cloning, navigate to the root folder of the project with Gitbash/CLI of your choice

#### Running the tests

- Assuming you still have Gitbash/CLI of your choice open to the root of the project, if not, please navigate to the root of the project
- The prject has two test groups (more on this later), therefore to execute a specific group, run the following command:
  ```
  gradle clean execute_tests -P testGroup=womenColor --stacktrace
  gradle clean execute_tests -P testGroup=landingPage --stacktrace
  ```

Please note, the group name can be replaced by another specific group name that needs to be executed at that point.

##### How do I run all the tests regardless of their groups?

So you ask me... :)

Run the following command:
```
gradle clean test --stacktrace
```

## Project structure breakdown

- **webdrivers**: This directory contains browser drivers like chromedriver
- **modules**: Classes from this directory contain logic and assertions from the page objects
- **pages**: Classes from this directory deal with web elements and interaction with the browser
- **utils**: Classes from here provide common resuable functionality across the framework
- **GK_Tests**: This class contains the actual method tests annotated with testng's @Test

Please note: the results of the tests after execution can be found on \gk_web_automation\build\reports

## Tests scripts written, what do they do?

For the demonstration of this assessment, two testcases have been written which are grouped into **landingPage** and **womenColor**.

- **landingPage**: Navigates to http://automationpractice.com and verifies that the menu and the search field are visible from the landing page
- **womenColor**: - Navigates to http://automationpractice.com,
                  clicks on the Women menu link, 
                  validates that it has landed successfully on the link clicked by asserting the Women page header, 
                  clicks on the color passed from the dataprovider e.g. Orange,
                  verifies that the filtered color has been applied successfully.
                  

## Last words

Even though much effort has been put into completing, adding more and documenting as much in this project, I do acknowledge that I might have missed a lot of key points and requirements. I'd be glad to answer questions, concerns or provide clarity on this assessment to the best of my ability.
