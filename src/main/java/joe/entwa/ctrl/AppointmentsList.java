/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe.entwa.ctrl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import joe.entwa.ent.Appointment;
import joe.entwa.login.LoginSession;

/**
 * Controller for the appointments list view
 * @author Joe
 */
@Named(value = "appointmentsList")
@RequestScoped
public class AppointmentsList {
    
    @Inject
    private LoginSession loginSession;
    private List<Appointment> appointments = new ArrayList<>();
    private DateTimeFormatter ukDate = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    
    /**
     * Creates a new instance of AppointmentsList
     */
    public AppointmentsList() {
    }
    
    /**
     * Method to retrieve the current user's appointments. Combines the lists of the user's owned and attending appointments and removes the duplicates.
     * @return a list of appointments which the current user owns and/or is attending.
     */
    public List<Appointment> getAppointments() {
        //Creates sets for owned and attending appointments, to ensure there are no duplicates
        Set<Appointment> setOwn = new HashSet<>();
        Set<Appointment> setAtt = new HashSet<>();
        setOwn.addAll(loginSession.getUser().getOwnedAppointments());
        setAtt.addAll(loginSession.getUser().getAttendAppointments());
        
        //Combines the two sets to get the union, without any elements repeated.
        setOwn.addAll(setAtt);
        
        //Returns the union of the two sets as the expected list type.
        appointments.addAll(setOwn);
        return appointments;
    }

    public DateTimeFormatter getUkDate() {
        return ukDate;
    }
}
