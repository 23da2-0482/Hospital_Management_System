# Hospital Management System - CIT300 Assignment

## Project Overview
This is a Hospital Management System implementing four core data structures:
1. **Binary Search Tree (BST)** - Patient Records Management
2. **Queue** - Emergency Patient Queue
3. **Stack** - Treatment History
4. **Singly Linked List** - Patient Visit History

## Features

### 1. Patient Records (BST)
- Insert new patient records
- Search patients by ID
- Delete patients by ID
- Display all patients in ascending order

### 2. Emergency Queue
- Enqueue patients waiting for treatment
- Dequeue next patient for treatment
- Display all waiting patients
- FIFO (First-In, First-Out) principle

### 3. Treatment History (Stack)
- Push completed treatment records
- Pop most recent treatment record
- Display treatment history
- LIFO (Last-In, First-Out) principle

### 4. Visit History (Linked List)
- Add new visits
- Remove visits
- Search for visits
- Display complete visit history

## Project Structure
HospitalManagementSystem/
├── src/
│ └── com/
│ └── hospital/
│ ├── models/
│ │ ├── Patient.java
│ │ ├── Visit.java
│ │ └── TreatmentRecord.java
│ ├── bst/
│ │ ├── BSTNode.java
│ │ └── PatientBST.java
│ ├── queue/
│ │ └── EmergencyQueue.java
│ ├── stack/
│ │ └── TreatmentStack.java
│ ├── linkedlist/
│ │ ├── VisitNode.java
│ │ └── VisitHistory.java
│ └── main/
│ └── HospitalSystem.java
├── resources/
├── README.md
└── .git


## Technologies Used
- Java (JDK 17+)
- Eclipse IDE
- Git & GitHub

## How to Run
Navigate to HospitalManagementSystem.java
Right-click → Run As → Java Application

### Prerequisites
- Java JDK 17 or higher
- Eclipse IDE or any Java IDE

