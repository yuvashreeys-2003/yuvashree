package com.hospital.dao;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.exception.*;
import com.hospital.util.DbConnectionUtil;
import com.hospital.util.HexaConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {

    @Override
    public Appointment getAppointmentById(int appointmentId) 
            throws AppointmentNotFoundException,  DbConnectionException {
        
        
        
        try (Connection conn = DbConnectionUtil.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(HexaConstants.APPOINTMENT_ID_QUERY)) {
            
            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return mapAppointment(rs);
            } else {
                throw new AppointmentNotFoundException("Appointment with ID " + appointmentId + " not found");
            }
            
        } catch (SQLException e) {
            throw new DbConnectionException("Error retrieving appointment: " + e.getMessage());
        }
        
    }

    
    
    
    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) 
            throws PatientNumberNotFoundException,  DbConnectionException {
        
     
        
        List<Appointment> appointments = new ArrayList<>();
        
        try (Connection conn = DbConnectionUtil.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(HexaConstants.PATIENT_ID_APPOINTMENT_QUERY)) {
            
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                appointments.add(mapAppointment(rs));
            }
            
            if (appointments.isEmpty()) {
                throw new PatientNumberNotFoundException("No appointments found for patient ID " + patientId);
            }
            
            return appointments;
            
        } catch (SQLException e) {
            throw new DbConnectionException("Error retrieving appointments: " + e.getMessage());
        }
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) 
            throws PatientNumberNotFoundException, DoctorNotFoundException, DbConnectionException {
        
        if (!patientExists(appointment.getPatient().getPatientId())) {
            throw new PatientNumberNotFoundException("Patient ID " + 
                appointment.getPatient().getPatientId() + " not found");
        }
        
        if (!doctorExists(appointment.getDoctor().getDoctorId())) {
            throw new DoctorNotFoundException("Doctor ID " + 
                appointment.getDoctor().getDoctorId() + " not found");
        }
        
        String query = "INSERT INTO Appointment (patientId, doctorId, appointmentDate, description) " +
                       "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DbConnectionUtil.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, appointment.getPatient().getPatientId());
            pstmt.setInt(2, appointment.getDoctor().getDoctorId());
            pstmt.setDate(3, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            pstmt.setString(4, appointment.getDescription());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        appointment.setAppointmentId(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            throw new DbConnectionException("Error scheduling appointment: " + e.getMessage());
        }
    }

    private Appointment mapAppointment(ResultSet rs) throws SQLException {
    	Patient patient = new Patient(
    	        rs.getString("p_firstName"),
    	        rs.getString("p_lastName"),
    	        rs.getDate("p_dateOfBirth"), 
    	        rs.getString("p_gender"),
    	        rs.getString("p_contactNumber"),
    	        rs.getString("p_address")
    		    );
    	patient.setPatientId(rs.getInt("p_patientId"));

        Doctor doctor = new Doctor(
                rs.getString("d_firstName"),
                rs.getString("d_lastName"),
                rs.getString("d_specialization"), 
                rs.getString("d_contactNumber")
            );
        doctor.setDoctorId(rs.getInt("d_doctorId"));

        Appointment appointment = new Appointment(
            patient,
            doctor,
            rs.getDate("appointmentDate"),
            rs.getString("description")
        );
        appointment.setAppointmentId(rs.getInt("appointmentId"));

        return appointment;
    }

    
    
    
    private boolean patientExists(int patientId) throws DbConnectionException {
      
        String query = "SELECT COUNT(*) FROM Patient WHERE patientId = ?";
        try (Connection conn = DbConnectionUtil.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
        }
        return false;
    }

    private boolean doctorExists(int doctorId) throws DbConnectionException {
        String query = "SELECT COUNT(*) FROM Doctor WHERE doctorId = ?";
        try (Connection conn = DbConnectionUtil.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, doctorId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
        }
        return false;
    }
}