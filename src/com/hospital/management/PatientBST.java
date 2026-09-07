package com.hospital.management;

import com.hospital.models.Patient;

public class PatientBST {
    
    private class Node {
        Patient patient;
        Node left;
        Node right;
        
        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    
    public PatientBST() {
        this.root = null;
    }
    
    // Insert a patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
        System.out.println("Patient inserted successfully!");
    }
    
    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }
        
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient ID already exists!");
        }
        
        return root;
    }
    
    // Search for a patient
    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        if (result != null) {
            return result.patient;
        }
        return null;
    }
    
    private Node searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root;
        }
        
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }
    
    // Delete a patient
    public boolean delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient not found!");
            return false;
        }
        root = deleteRec(root, patientId);
        System.out.println("Patient deleted successfully!");
        return true;
    }
    
    private Node deleteRec(Node root, int patientId) {
        if (root == null) {
            return root;
        }
        
        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            // Node with two children
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }
    
    private Patient minValue(Node root) {
        Patient min = root.patient;
        while (root.left != null) {
            min = root.left.patient;
            root = root.left;
        }
        return min;
    }
    
    // In-order traversal
    public void inorder() {
        System.out.println("\n=== Patients in ascending order of ID ===");
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }
    
    public boolean isEmpty() {
        return root == null;
    }
}
