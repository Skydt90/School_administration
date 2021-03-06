# KEA School Administration

This repository contains the source code for our final mandatory assignment on the 3. semester in the computer science study programme at KEA. Below is a section descriping how to deploy the system followed by a list of requirements and a brief description of our solution to those requirements.

## Deployment:
1. Clone repo
2. Build Project using IntelliJ
3. Run project
4. Populate database with sql script
5. Open browser at localhost:8080
6. Login using username 'jarlen' & password '123' or username 'muskelmartin' & password '123'

## Requirements:
### 1. CRUD for course, including a list with students assigned to that course.
Everything here is implemented with the exception of the delete part. The entirety of this requirement was solved using an implementation of JPA in Spring Boot with a few custom implementations to make everything work.

### 2. Login for each type of the user.
Fully implemented using the Spring Security framework.

### 3. All the requirements for the different type of user.
Mostly implemented using JPA and Spring Secruity with a few minor exceptions. En example would be that a teacher is not only restricted to edit his own courses or the ones he teaches, but everything.

### 4. Auto update of the content on pages when needed(jQuery).
Not implemented. Using Jquery to improve user experience and enable searching and AJAX to display details in a popup window.


### 5. Call against the provided Web-Service to fetch some of the content (Teachers & Courses).
Fully implemented for Courses using RestTemplate, HttpEntity and ResponseEntity. A call is made to the service each time we need the data. Afterwards we merge that data with our own before presenting it to the user. We dont save any service data locally.

### 6. When you add/update a new Teacher or Course to your backend, the newly added/updated resource should also be reflected in the legacy system.
Fully implemented using RestTemplate, HttpEntity and ResponseEntity.

