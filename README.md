# Distance calculator 

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

Simple GIU Java app calculating distance between one main point and three others. 

## Table of contents
* [What am I for?](#what-am-i-for)
* [Built with](#built-with)
* [Screenshots](#screenshots)

## What am I for?
#### First requirements from the SDA class [(this is continuation of 3rd exercise - POINTS)](https://git.kobiela.click/wiktor.kobiela/JavaHomeworkExcersice#user-content-3rd-excercise-points)
``` 
Write a simple Java program to calculate:
   1. House is point [x = 0 y = 0]
   2. Old Żabka [x = 1.2, y = 2.5], Biedronka [x = 3.3, y=2.7]
   3. Old Żabka is closed, new Żabka [x = 5.5, y = -2.3] 
   4. How far is from home to new closest shop?
   5. Is it in favor or disadvantage for us? What's the difference?
 ```
 
#### Current solution  
  - Start from Main.java file,
  - GUI application,
  - 4 points to enter, 1 main (home point) and three other,
  - 4 buttons: clear and fill textfields with default data, draw chart and calculate,
  - Working exceptions with info popup,
  - Implemented Cucumber/Gherkin simple test to test Calculate/Point classes,
  - Simple menu-bar with About window and Exit option with popup checking decision,
  - Now using Nimbus Java look if available.
  
## Built With
###### App
  - [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
  - Swing UI Designer from IntelliJ
  - [XChart](https://github.com/knowm/XChart) - light-weight Java library for plotting data
  - [Project Lombok](https://projectlombok.org/) -  java library that can automatically create setters/getters and so on
###### Tests
  - [Cucumber](https://cucumber.io/) - IntelliJ plugin
  - [Gherkin](https://cucumber.io/docs/gherkin/) - IntelliJ plugin
  
## Screenshots  
  
  ###### Main app window
  ![Window app](https://i.imgur.com/KhjfhIP.png)
  ###### About window
  ![About window](https://i.imgur.com/QVVrcGt.png)
  ###### Closing window
  ![Closing window](https://i.imgur.com/K6P8nID.png)
  ###### Chart window
  ![Chart](https://i.imgur.com/UIb5rkU.png)
  ###### Tests
  ![Test](https://i.imgur.com/m5KwxVB.png)
  
  