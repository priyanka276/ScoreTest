## Appium UI testing for mobile application

## Introduction
This repository contains UI test for Score Android Mobile application as part of interview process

## Requirement
*Java -16

*maven - any version

*testng- 7.7.0

*io.appium.java-client - 7.5.1

*Intellij or eclipse IDE

*appium2

*score apk file -latest added in mail

## About the tests
* This project use data driven approach for running tests parallely
* Uses Page Object model for defining page elements
  

## Running the test
Test can be run from IDE 

1.LeagueTest.java - 
* contains end to end test from splash screen to selecting new league, new team and adding players in favourites
* Used testng priority parameter for setting the order of tests
2. SplashTest.java -contains test that splash page shows up and asserting that text of heading and button text is correct.

