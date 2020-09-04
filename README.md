# Fundamental Project 

## BenchMark 

BenchMark is an application designed for fitness trainers to keep track of their clients. Users will have the ability to add as many clients as they like and record workouts done by each client. Alongside adding users can delete or update a clients details.     

## Getting Started
The objective is to create an application that utilises create, read, update and delete functionality. The project also employs several diffrent concepts such as
* Project Management
* Databases
* Java SE
* Spring Boot
* Front-End Development
* Continuous Integration
* Cloud Fundamentals

## Requirements 
There are a minimum set of requirements that were added during the duration of the project. The requirements are: 
* A Jira board with full expansion on user stories, use cases and tasks needed to complete the project.
* Documentation from a design phase describing the architecture used for the project.
* A Risk Assessment created at the beginning of the project.
* A relational database used to store data for the project.
* A functional application created in the OOP language.
* The application must have a functioning front-end website and integrated API.
* Code fully integrated into a Version Control System
* Code built through a CI server
* Application deployed to a cloud-based virtual machine

## Approach 
To achieve the requirements the benchmark app consists of the following functionality.
* Create a client. Whcih stores
  * user_id
  * First Name
  * Last Name
  * Gender
* Create a workout. Which stores 
  * Title of the workout (e.g benchpress)
  * Description of the workout.
* View all clients and workouts.
* Delete a clients details.
* Update a client details.
  

## Architecture
### Database Structure 
![ERD](https://user-images.githubusercontent.com/47117365/92161573-b7531780-ee28-11ea-8c6e-6f7963d4b676.png)
As can be seen in the entity relatoinship diagram there is a one to many relationship between the CLient table and the workout table. This states that a single user can have multiple workouts, wheras a workout has to lead back to a single user.  

## Project Planning



## Risk assesment



## Deployment
Add additional notes about how to deploy this on a live system



## Authors
Areeb Panjwani.

