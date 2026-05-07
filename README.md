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

### 1. Unsafe Integer Parsing Without Try-Catch
- **Type:** Bug Fix
- **Motivation:** SonarQube detected unsafe integer parsing in multiple Java files 
without proper exception handling. This can cause the application to crash when 
invalid input is received. Adding try-catch blocks will prevent runtime errors 
and ensure system stability.

### 2. XXE (XML External Entity) Vulnerability in XML Parsing
- **Type:** Bug Fix
- **Motivation:** SonarQube detected 120 security issues including disabled access 
to external entities in XML parsing in DatabaseUpdate.java. This is a critical 
security vulnerability that allows attackers to read system files. Disabling 
external entity processing will secure the system.

### 3. Null Pointer Exception in Core Classes
- **Type:** Bug Fix
- **Motivation:** SonarQube detected 1,596 reliability issues including 
NullPointerException in Debug.java and CreateBaseModelFromXml.java where variables 
are nullable and can crash the application. Adding proper null checks will ensure 
system stability.

### 4. Hard-coded Secret Token in Source Code
- **Type:** Bug Fix
- **Motivation:** SonarQube detected a blocker security issue in 
ImportTranslations.java where a token is hard-coded in the source code. This is 
a serious security risk as anyone with access to the code can steal the token. 
Moving the token to a configuration file will secure the system.

### 5. Incorrect Logical Operator Causing Wrong Behavior
- **Type:** Bug Fix
- **Motivation:** SonarQube detected in VariableTitleCourseConnector.java that a 
bitwise "&" operator is used instead of the logical "&&" operator. This causes 
incorrect logical evaluation and wrong behavior in course title processing. 
Replacing "&" with "&&" will fix the logical evaluation.
