# Fundamental Project 

## BenchMark 

BenchMark is an application designed for fitness trainers to keep track of their clients. Users will have the ability to add as many clients as they like and record workouts done by each client. Alongside adding, users can delete or update a clients details.     

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

![ERD](https://user-images.githubusercontent.com/47117365/92161573-b7531780-ee28-11ea-8c6e-6f7963d4b676.png)  <br>
As can be seen in the entity relatoinship diagram there is a one to many relationship between the Client table and the workout table. This states that a single user can have multiple workouts, wheras a workout has to lead back to a single user.  

## Project Planning
JIRA software was used for planning the diffrent stages of the project.
![JiraBoard](https://user-images.githubusercontent.com/47117365/92308076-061cc080-ef93-11ea-8fea-549ffdc12988.png)
Each phase of the development process was divided into sprints. There was a spring for developing the back-end in java and the front end in HTML, CSS and JavaScript. A sprint for creating the documentation, a sprint for connecting to the database and lastly for deploying the app on a cloud based VM.  <br  />

When a sprint has started it will appear on the board which is divided into three sections. TO DO, in progress and completed. A task is clicked and dropped in the "in progress" whilst it is being worked on. Then added to completed once it is finished. You can only work on one sprint at a time. If any task in one sprint has not been completed it will automatucaly be moved onto the next sprint.  <br>
The agile project management tool was helpful for keeping track of the entire development process and was an essential part of the project.


## Risk assesment
![Risk Assessment](https://user-images.githubusercontent.com/47117365/92334670-267a7700-f088-11ea-80fb-e986b53f81d8.png)
## Front-end Structure
![StoryBoard](https://user-images.githubusercontent.com/47117365/92334664-21b5c300-f088-11ea-95a8-3e3162c22583.png) <br>
Pictured above is the structure of the front end web pages. The home page is where the all the data is displayed and consists of all the links to the other pages. The story boards above provide an insight into all the diffrent pages, and the data that is taken in. The remainder of the links do consists of links to navigate through the website. These are just not shown in the storyboards above.


## Future improvements 
There are a number of improvements I would like to implement
* Functinality for searching a user by name.
* Better presentation of displaying all data.
* Add fields in some of the tables to display and track more data.



## Authors
Areeb Panjwani.

