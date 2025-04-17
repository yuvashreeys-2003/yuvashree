package com.hospital.entity;

import java.util.Date;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;

    public Patient() {}

    public Patient(String firstName, String lastName, Date dateOfBirth, 
                   String gender, String contactNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public int getPatientId() { 
    	return patientId; }
    public void setPatientId(int patientId) { 
    	this.patientId = patientId; }

    public String getFirstName() { 
    	return firstName; }
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { 
    	this.lastName = lastName; }

    public Date getDateOfBirth() { 
    	return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { 
    	this.dateOfBirth = dateOfBirth; }

    public String getGender() { 
    	return gender; }
    public void setGender(String gender) { 
    	this.gender = gender; }

    public String getContactNumber() { 
    	return contactNumber; }
    public void setContactNumber(String contactNumber) { 
    	this.contactNumber = contactNumber; }

    public String getAddress() {
    	return address; }
    public void setAddress(String address) { 
    	this.address = address; }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}