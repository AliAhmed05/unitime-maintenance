# UniTime - University Timetabling System

## Project Description
UniTime is an open-source comprehensive university timetabling system. 
It is designed to help universities automate the process of scheduling 
courses, exams, and managing classroom assignments. The system eliminates 
manual scheduling conflicts and reduces administrative workload.

## Requirements
1. The system shall allow administrators to create and manage course schedules
2. The system shall automatically detect and prevent room conflicts
3. The system shall support exam timetabling separately from course timetabling
4. The system shall allow students to enroll in courses
5. The system shall support multiple departments and academic sessions
6. The system shall allow rooms to be shared between different departments
7. The system shall generate schedule reports for students and staff
8. The system shall support multiple universities in a distributed setup
9. The system shall allow instructors to set their availability preferences
10. The system shall send notifications when timetable changes occur

## Users
- University Administrators: manage schedules and rooms
- Professors/Instructors: view schedules and set preferences
- Students: view timetables and enroll in courses
## Proposed Changes

### 1. Remove commented out code in CourseCreditUnitConfig.hbm.xml
- Type: Enhancement
- Description: SonarQube detected commented out code in CourseCreditUnitConfig.hbm.xml that should be removed to improve maintainability.

### 2. Remove commented out code in CourseOffering.hbm.xml
- Type: Enhancement
- Description: SonarQube detected commented out code in CourseOffering.hbm.xml that should be removed to improve maintainability.

### 3. Fix NullPointerException in Debug.java
- Type: Bug Fix
- Description: SonarQube detected that a NullPointerException could be thrown in Debug.java. A null check must be added.

### 4. Fix NullPointerException in CreateBaseModelFromXml.java
- Type: Bug Fix
- Description: SonarQube detected that a NullPointerException could be thrown in CreateBaseModelFromXml.java. A null check must be added.

### 5. Correct "&" to "&&" in VariableTitleCourseConnector.java
- Type: Bug Fix
- Description: SonarQube detected that "&" should be "&&" in VariableTitleCourseConnector.java to prevent incorrect behavior.
