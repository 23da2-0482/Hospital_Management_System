package com.hospital.models;

public class Visit {
    private String visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;
    private Visit next;
    
    // Constructor
    public Visit(String visitId, String visitDate, String doctorName, 
                 String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
    
    // ============ ALL GETTERS ============
    public String getVisitId() {
        return visitId;
    }
    
    public String getVisitDate() {
        return visitDate;
    }
    
    public String getDoctorName() {
        return doctorName;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public String getTreatment() {
        return treatment;
    }
    
    public Visit getNext() {
        return next;
    }
    
    // ============ ALL SETTERS ============
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
    
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
    public void setNext(Visit next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Visit ID: " + visitId + 
               ", Date: " + visitDate + 
               ", Doctor: " + doctorName + 
               ", Diagnosis: " + diagnosis + 
               ", Treatment: " + treatment;
    }
}