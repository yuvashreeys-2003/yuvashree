package comhospital.client;
import java.sql.Date;

import com.hospital.dao.HospitalServiceImpl;
import com.hospital.dao.IHospitalService;
import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.exception.*;
import com.hospital.util.DbConnectionUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    private static final IHospitalService hospitalService = new HospitalServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        int choice;
        do {
            handleMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                    	try {
                            getAppointmentById(); 
                        } catch (AppointmentNotFoundException | DbConnectionException e) {
                            System.out.println("ID Doesn't Exists \n" + e.getMessage());
                        }
                        
                        break;
                    case 2:
                    	try {
                    		 getAppointmentsForPatient();
                        } catch (PatientNumberNotFoundException | DbConnectionException e) {
                            System.out.println("ID Doesn't Exists \n" + e.getMessage());
                        }
                       
                        break;
                    case 3:
                    	try {
                    		scheduleAppointment();
                       } catch (ParseException | DbConnectionException e) {
                           System.out.println("ID Doesn't Exists \n" + e.getMessage());
                       }
                        
                        
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);
    }

    private static void handleMenu() {
        System.out.println("\n--- Hospital Management System ---");
        System.out.println("1. Get Appointment by ID");
        System.out.println("2. Get Appointments for Patient");
        System.out.println("3. Schedule New Appointment");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void getAppointmentById() throws AppointmentNotFoundException, DbConnectionException {
        System.out.print("Enter Appointment ID: ");
        int appId = scanner.nextInt();
        
        Appointment appointment = hospitalService.getAppointmentById(appId);
        System.out.println("Appointment Details:\n" + appointment);
    }

    private static void getAppointmentsForPatient() throws PatientNumberNotFoundException, DbConnectionException {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        
        List<Appointment> appointments = hospitalService.getAppointmentsForPatient(patientId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            appointments.forEach(System.out::println);
        }
    }

    
    
    private static void scheduleAppointment() throws ParseException, DbConnectionException {
        try {
            System.out.println("Enter appointment details:");
            
            System.out.print("Patient ID: ");
            int patientId = scanner.nextInt();
            Patient patient = new Patient();
            patient.setPatientId(patientId);

            System.out.print("Doctor ID: ");
            int doctorId = scanner.nextInt();
            Doctor doctor = new Doctor();
            doctor.setDoctorId(doctorId);

            scanner.nextLine(); 
            System.out.print("Appointment Date (yyyy-MM-dd): ");
            java.sql.Date date = new java.sql.Date(dateFormat.parse(scanner.nextLine()).getTime());
           

            System.out.print("Description: ");
            String description = scanner.nextLine();

            Appointment appointment = new Appointment(patient, doctor, date, description);
            
            boolean success = hospitalService.scheduleAppointment(appointment);
            if (success) {
                System.out.println("Appointment scheduled successfully! ID: " + appointment.getAppointmentId());
            } else {
                System.out.println("Failed to schedule appointment.");
            }
        } catch (PatientNumberNotFoundException | DoctorNotFoundException e) {
            System.out.println(e.getMessage());
        } }
    }
