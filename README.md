*Banking Application

Prerequisites :
-Java

-Maven

-STS

-MySQL database




*Database setup :

To create database use the following commanads,
  
-CREATE DATABASE assignment;

-USE assignment;

-CREATE TABLE users(username varchar(255),password varchar(255),balance int,PRIMARY KEY (username));

-CREATE TABLE transaction(id int AUTO_INCREMENT,rusername varchar(255),sendername varchar(255),amount int,PRIMARY KEY (id));




*How to run the application :
	
  To run the application in your system follow the steps given below-

1]Download the complete project folder.

2]Import the project into STS using import Maven prject option.

3]Now run the application with "run as spring boot app" option fron "Run as" menu.

4]Open your web browser and go to the URL : "http://localhost:8081/bankingapplication"

5]Register as a new user and you are good to go.
