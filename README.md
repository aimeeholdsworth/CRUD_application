# CRUD_application

# Contents
1. Resources
2. Brief
3. Kanban Board
4. Database Structure
5. Data Stack
6. Testing
7. Frontend
8. Stretch Goals
Author

#Resources
- Presentation https://docs.google.com/presentation/d/18Nmvaqwc9m9YAowbr2EQ2odozBgD07S7MHN2ol1sJuU/edit?usp=sharing 
- Kanban Board https://aimee-qatraining.atlassian.net/secure/RapidBoard.jspa?rapidView=3&projectKey=QA&selectedIssue=QA-18&atlOrigin=eyJpIjoiY2IyN2UzYzE1Yzk2NDYwOWFiZWU5NDI5MzZjZGI2N2QiLCJwIjoiaiJ9
- Front End Git Repo https://github.com/aimeeholdsworth/frontend_crud

# Brief 

Create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.
This project will involve concepts from:

- Project Management
- Databases
- Java SE
- Spring Boot
- Front-End Development
- Automated Testing

For this project I have decided to create a simple CRUD app that allows the user to keep track of their upcoming music gigs/events, allowing them to view the data in one easy to read place. Users can add new entries, change entries should the details change or delete them if they are no longer going.

#KanBan Board
This project used a Kanban board to keep track of what needed to be done for the project and allow for it to be managed well. It is modelled on the Agile method, with user stories and tasks developed to get a better picture of what the application needed to acheive. 

![image](https://user-images.githubusercontent.com/33550375/111071783-a8cc7380-84cf-11eb-9232-dc80f072f9e4.png)

![image](https://user-images.githubusercontent.com/33550375/111071823-cd285000-84cf-11eb-90f2-4413ffb11dcd.png)


# Database Structure
This application is a simple one table database due to the time constraints on the project. The table structure contains fields for Artist, City, Venue, Gig Date and Gig Time, and it creates an id field which is it's primary key.
![image](https://user-images.githubusercontent.com/33550375/111071972-7e2eea80-84d0-11eb-8e9d-585f097780aa.png)

# Data Stack
# Database
The project is connected to a SQL Server to access and store the data in a database. Java links to the project through a gig-data.sql and gig-schema.sql file to access and enter data.

# Back End
The back end for this project uses Java and Spring Boot and is connected to GitHub for version control.

# Front End
The front end for this project is built using HTML, CSS and JS. Some bootstrap elements have been used and enhanced to create a user friendly interface, for example the nav bar and modal. JS allows the website to connect to the DB and append information onto the HTML page

# Testing
Two kinds of testing were completed during this project, these were Unit Testing using Junit and Mockito, Integration Testing using MockMVC and then Selenium for the front end.

