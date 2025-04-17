package com.hospital.util;

public class HexaConstants {
	
	public static final String EMP_NOT_FOUND="Employee not found";
	public static final String EMP_EXISTS="Employee ID exists";
	public static final String DELIMITER = ",";
	public static final String DB_FILE_NAME = "src/hexadb.properties";
	public static final String DB_DRIVER = "driver";
	public static final String DB_URL="dburl";
	public static final String CANNOT_OPEN_CONNECTION = "Connection cannot be opened.";
	
	
//queries
	
	public static final String PATIENT_ID_APPOINTMENT_QUERY="SELECT a.appointmentId, a.appointmentDate, a.description, " +
            "p.patientId AS p_patientId, p.firstName AS p_firstName, p.lastName AS p_lastName, " +
            "p.dateOfBirth AS p_dateOfBirth, p.gender AS p_gender, " +
            "p.contactNumber AS p_contactNumber, p.address AS p_address, " +
            "d.doctorId AS d_doctorId, d.firstName AS d_firstName, d.lastName AS d_lastName, " +
            "d.specialization AS d_specialization, d.contactNumber AS d_contactNumber " +
            "FROM Appointment a " +
            "JOIN Patient p ON a.patientId = p.patientId " +
            "JOIN Doctor d ON a.doctorId = d.doctorId " +
            "WHERE a.patientId = ?";
	
	public static final String APPOINTMENT_ID_QUERY="SELECT a.*, " +
            "p.patientId AS p_patientId, p.firstName AS p_firstName, p.lastName AS p_lastName, " +
            "p.dateOfBirth AS p_dateOfBirth, p.gender AS p_gender, " + 
            "p.contactNumber AS p_contactNumber, p.address AS p_address, " +
            "d.doctorId AS d_doctorId, d.firstName AS d_firstName, d.lastName AS d_lastName, " +
            "d.specialization AS d_specialization, d.contactNumber AS d_contactNumber " + 
            "FROM Appointment a " +
            "JOIN Patient p ON a.patientId = p.patientId " +
            "JOIN Doctor d ON a.doctorId = d.doctorId " +
            "WHERE a.appointmentId = ?";
	
}
	
