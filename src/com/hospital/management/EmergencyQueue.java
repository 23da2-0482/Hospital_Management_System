package com.hospital.management;

import com.hospital.models.Patient;
import java.util.LinkedList;

public class EmergencyQueue {
    private LinkedList<Patient> queue;
    
    public EmergencyQueue() {
        this.queue = new LinkedList<>();
    }
    
    // Enqueue - add patient to the queue
    public void enqueue(Patient patient) {
        queue.addLast(patient);
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
        System.out.println("Queue size: " + queue.size());
    }
    
    // Dequeue - remove and return the next patient
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to process.");
            return null;
        }
        Patient patient = queue.removeFirst();
        System.out.println("Patient " + patient.getName() + " is being processed.");
        System.out.println("Remaining in queue: " + queue.size());
        return patient;
    }
    
    // Display all patients waiting
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        
        System.out.println("\n=== Emergency Queue (FIFO) ===");
        System.out.println("Patients waiting for treatment:");
        for (int i = 0; i < queue.size(); i++) {
            Patient p = queue.get(i);
            System.out.println((i + 1) + ". " + p);
        }
        System.out.println("Total waiting: " + queue.size());
    }
    
    // Peek at the next patient without removing
    public Patient peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queue.getFirst();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
}