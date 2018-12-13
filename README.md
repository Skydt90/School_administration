# KEA School Administration

This repository contains the source code for our final mandatory assignment on the 3. semester in the computer science study programme at KEA. Below is a section descriping how to deploy the system followed by a list of requirements and a brief description of our solution to those requirements.

## Deployment:

## Requirements:
**1. CRUD for course, including a list with students assigned to that course** 

Everything here is implemented with the exception of the delete part. The entirety of this requirement was solved using an implementation of JPA in Spring Boot with a few custom implementations to make everything work.

**2. Login for each type of the user.**

Fully implemented using the Spring Security framework.

**3. All the requirements for the different type of user**

Mostly implemented using JPA and Spring Secruity with a few minor exceptions. 

Auto update of the content on pages when need it (jQuery)
A user-friendly design.
Call against the provided Web-Service to fetch some of the content (Teachers & Courses) use the swagger documentation for the details. 
When you add/update a new Teacher or Course to your backend, the newly added/updated resource should also be reflected in the legacy system.

