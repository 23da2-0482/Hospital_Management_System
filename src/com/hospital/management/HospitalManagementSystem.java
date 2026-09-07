package com.hospital.management;

import com.hospital.models.Patient;
import com.hospital.models.Visit;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static PatientBST patientBST = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentStack = new TreatmentStack();
    private static Scanner scanner = new Scanner(System.in);
    private static int patientIdCounter = 1001;
    
    public static void main(String[] args) {
        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM ===");
        System.out.println("===================================\n");
        
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    patientManagementMenu();
                    break;
                case 2:
                    emergencyQueueMenu();
                    break;
                case 3:
                    treatmentHistoryMenu();
                    break;
                case 4:
                    visitHistoryMenu();
                    break;
                case 5:
                    displayAllData();
                    break;
                case 6:
                    System.out.println("Thank you for using Hospital Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Patient Records (BST)");
        System.out.println("2. Emergency Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("5. Display All Data");
        System.out.println("6. Exit");
    }
    
    // ==================== PATIENT MANAGEMENT (BST) ====================
    private static void patientManagementMenu() {
        while (true) {
            System.out.println("\n=== PATIENT RECORDS (BST) ===");
            System.out.println("1. Insert Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In-order)");
            System.out.println("5. Back to Main Menu");
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    insertPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    patientBST.inorder();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    private static void insertPatient() {
        System.out.println("\n--- Insert New Patient ---");
        int id = patientIdCounter++;
        System.out.println("Generated Patient ID: " + id);
        
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        
        int age = getIntInput("Enter Age: ");
        
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();
        
        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
    }
    
    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        int id = getIntInput("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);
        
        if (patient != null) {
            System.out.println("Patient found:");
            System.out.println(patient);
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        int id = getIntInput("Enter Patient ID to delete: ");
        patientBST.delete(id);
    }
    
    // ==================== EMERGENCY QUEUE ====================
    private static void emergencyQueueMenu() {
        while (true) {
            System.out.println("\n=== EMERGENCY QUEUE ===");
            System.out.println("1. Enqueue Patient");
            System.out.println("2. Dequeue Patient (Process)");
            System.out.println("3. Display Waiting Patients");
            System.out.println("4. Peek Next Patient");
            System.out.println("5. Back to Main Menu");
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    enqueuePatient();
                    break;
                case 2:
                    dequeuePatient();
                    break;
                case 3:
                    emergencyQueue.displayQueue();
                    break;
                case 4:
                    Patient next = emergencyQueue.peek();
                    if (next != null) {
                        System.out.println("Next patient: " + next.getName());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    private static void enqueuePatient() {
        System.out.println("\n--- Enqueue Patient ---");
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter Age: ");
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();
        
        Patient patient = new Patient(patientIdCounter++, name, age, contact, condition);
        emergencyQueue.enqueue(patient);
        patientBST.insert(patient);
    }
    
    private static void dequeuePatient() {
        System.out.println("\n--- Dequeue Patient ---");
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
            System.out.println("Processing patient: " + patient.getName());
            String treatmentRecord = "Patient: " + patient.getName() + 
                                   " (ID: " + patient.getPatientId() + 
                                   ") - " + patient.getMedicalCondition();
            treatmentStack.push(treatmentRecord);
        }
    }
    
    // ==================== TREATMENT HISTORY (STACK) ====================
    private static void treatmentHistoryMenu() {
        while (true) {
            System.out.println("\n=== TREATMENT HISTORY (STACK) ===");
            System.out.println("1. Push Treatment Record");
            System.out.println("2. Pop Treatment Record");
            System.out.println("3. Display All Treatments");
            System.out.println("4. Peek Most Recent");
            System.out.println("5. Back to Main Menu");
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    pushTreatment();
                    break;
                case 2:
                    popTreatment();
                    break;
                case 3:
                    treatmentStack.displayStack();
                    break;
                case 4:
                    String recent = treatmentStack.peek();
                    if (recent != null) {
                        System.out.println("Most recent treatment: " + recent);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    private static void pushTreatment() {
        System.out.println("\n--- Push Treatment Record ---");
        System.out.print("Enter Treatment Record: ");
        String record = scanner.nextLine();
        treatmentStack.push(record);
    }
    
    private static void popTreatment() {
        System.out.println("\n--- Pop Treatment Record ---");
        String record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Removed: " + record);
        }
    }
    
    // ==================== VISIT HISTORY (LINKED LIST) ====================
    private static void visitHistoryMenu() {
        while (true) {
            System.out.println("\n=== VISIT HISTORY (LINKED LIST) ===");
            System.out.println("1. Add Visit to Patient");
            System.out.println("2. Remove Visit");
            System.out.println("3. Search Visit");
            System.out.println("4. Display Patient Visit History");
            System.out.println("5. Back to Main Menu");
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addVisit();
                    break;
                case 2:
                    removeVisit();
                    break;
                case 3:
                    searchVisit();
                    break;
                case 4:
                    displayVisits();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    private static void addVisit() {
        System.out.println("\n--- Add Visit ---");
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        
        System.out.print("Enter Visit ID: ");
        String visitId = scanner.nextLine();
        System.out.print("Enter Visit Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();
        
        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);
    }
    
    private static void removeVisit() {
        System.out.println("\n--- Remove Visit ---");
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        
        System.out.print("Enter Visit ID to remove: ");
        String visitId = scanner.nextLine();
        patient.getVisitHistory().removeVisit(visitId);
    }
    
    private static void searchVisit() {
        System.out.println("\n--- Search Visit ---");
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        
        System.out.print("Enter Visit ID to search: ");
        String visitId = scanner.nextLine();
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        
        if (visit != null) {
            System.out.println("Visit found:");
            System.out.println(visit);
        } else {
            System.out.println("Visit not found!");
        }
    }
    
    private static void displayVisits() {
        System.out.println("\n--- Display Visits ---");
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        
        patient.getVisitHistory().displayVisits();
    }
    
    // ==================== DISPLAY ALL DATA ====================
    private static void displayAllData() {
        System.out.println("\n=== ALL SYSTEM DATA ===");
        System.out.println("\n--- Patient Records ---");
        patientBST.inorder();
        
        System.out.println("\n--- Emergency Queue ---");
        emergencyQueue.displayQueue();
        
        System.out.println("\n--- Treatment History ---");
        treatmentStack.displayStack();
    }
    
    // ==================== UTILITY METHODS ====================
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}