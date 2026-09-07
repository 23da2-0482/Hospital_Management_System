package com.hospital.models;

public class VisitHistory {
    private Visit head;
    private int size;
    
    public VisitHistory() {
        this.head = null;
        this.size = 0;
    }
    
    // Add a new visit
    public void addVisit(Visit visit) {
        if (head == null) {
            head = visit;
        } else {
            Visit current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(visit);
        }
        size++;
        System.out.println("Visit added successfully!");
    }
    
    // Remove a visit by ID
    public boolean removeVisit(String visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return false;
        }
        
        if (head.getVisitId().equals(visitId)) {
            head = head.getNext();
            size--;
            System.out.println("Visit removed successfully!");
            return true;
        }
        
        Visit current = head;
        while (current.getNext() != null) {
            if (current.getNext().getVisitId().equals(visitId)) {
                current.setNext(current.getNext().getNext());
                size--;
                System.out.println("Visit removed successfully!");
                return true;
            }
            current = current.getNext();
        }
        
        System.out.println("Visit not found with ID: " + visitId);
        return false;
    }
    
    // Search for a visit by ID
    public Visit searchVisit(String visitId) {
        Visit current = head;
        while (current != null) {
            if (current.getVisitId().equals(visitId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visits in history.");
            return;
        }
        
        System.out.println("\n=== Patient Visit History ===");
        Visit current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println("Total Visits: " + size);
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}