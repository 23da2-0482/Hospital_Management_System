package com.hospital.management;

import java.util.Stack;

public class TreatmentStack {
    private Stack<String> treatmentHistory;
    
    public TreatmentStack() {
        this.treatmentHistory = new Stack<>();
    }
    
    // Push - add treatment record
    public void push(String treatmentRecord) {
        treatmentHistory.push(treatmentRecord);
        System.out.println("Treatment record pushed to stack.");
        System.out.println("Stack size: " + treatmentHistory.size());
    }
    
    // Pop - remove most recent treatment record
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No treatment records to pop.");
            return null;
        }
        String record = treatmentHistory.pop();
        System.out.println("Popped most recent treatment record.");
        System.out.println("Remaining in stack: " + treatmentHistory.size());
        return record;
    }
    
    // Display all treatment records (LIFO order)
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is empty.");
            return;
        }
        
        System.out.println("\n=== Treatment History (LIFO) ===");
        System.out.println("Most recent treatments:");
        for (int i = treatmentHistory.size() - 1; i >= 0; i--) {
            System.out.println((treatmentHistory.size() - i) + ". " + treatmentHistory.get(i));
        }
        System.out.println("Total treatments: " + treatmentHistory.size());
    }
    
    // Peek at most recent without removing
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return treatmentHistory.peek();
    }
    
    public boolean isEmpty() {
        return treatmentHistory.isEmpty();
    }
    
    public int size() {
        return treatmentHistory.size();
    }
}