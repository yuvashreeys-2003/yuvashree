package com.hospital.entity;

import java.sql.Date;

public class Appointment {
    private int appointmentId;
    private Patient patient;    
    private Doctor doctor;      
    private Date appointmentDate;
    private String description;

  
    public Appointment() {}


    public Appointment(Patient patient, Doctor doctor, Date appointmentDate, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public int getAppointmentId() {
    	return appointmentId; }
    public void setAppointmentId(int appointmentId) {
    	this.appointmentId = appointmentId; }

    public Patient getPatient() {
    	return patient; }
    public void setPatient(Patient patient) { 
    	this.patient = patient; }

    public Doctor getDoctor() {
    	return doctor; }
    public void setDoctor(Doctor doctor) { 
    	this.doctor = doctor; }

    public Date getAppointmentDate() {
    	return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { 
    	this.appointmentDate = appointmentDate; }

    public String getDescription() { 
    	return description; }
    public void setDescription(String description) {
    	this.description = description; }

    @Override
    public String toString() {
        return "Appointment{ " +
                "appointmentId=" + appointmentId +"\n"+
                ", patient=" + patient.getFirstName() + " " + patient.getLastName() +
                ", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() +"\n"+
                ", appointmentDate=" + appointmentDate +"\n"+
                ", description='" + description + '\'' +
                '}';
    }
}