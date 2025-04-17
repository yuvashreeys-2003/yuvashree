package com.hospital.dao;

import com.hospital.entity.Appointment;
import com.hospital.exception.AppointmentNotFoundException;
import com.hospital.exception.DbConnectionException;
import com.hospital.exception.DoctorNotFoundException;
import com.hospital.exception.PatientNumberNotFoundException;

import java.util.List;

public interface IHospitalService {
    Appointment getAppointmentById(int appointmentId) 
        throws AppointmentNotFoundException, DbConnectionException;
    
    List<Appointment> getAppointmentsForPatient(int patientId) 
        throws PatientNumberNotFoundException, DbConnectionException;
    
    boolean scheduleAppointment(Appointment appointment) 
        throws PatientNumberNotFoundException, DoctorNotFoundException,DbConnectionException;
}