/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe.entwa.ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Joe
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String forename;
    private String surname;
    private String username;
    
    @Size(min=5)
    private String password;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private String telephone;
    @Pattern(regexp = "[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
    private String email;
    
    @ManyToMany 
    private List<Account> contacts = new ArrayList<>();
    
    @ManyToMany(mappedBy="contacts")
    private List<Account> contactsOf = new ArrayList<>();
    
    @OneToMany(mappedBy="owner")
    private List<Appointment> ownedAppointments = new ArrayList<>();
    
    @ManyToMany(mappedBy="participants")
    private List<Appointment> attendAppointments = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getContacts() {
        return contacts;
    }

    public void setContacts(List<Account> contacts) {
        this.contacts = contacts;
    }

    public List<Account> getContactsOf() {
        return contactsOf;
    }

    public void setContactsOf(List<Account> contactsOf) {
        this.contactsOf = contactsOf;
    }

    public List<Appointment> getOwnedAppointments() {
        return ownedAppointments;
    }

    public void setOwnedAppointments(List<Appointment> ownedAppointments) {
        this.ownedAppointments = ownedAppointments;
    }

    public List<Appointment> getAttendAppointments() {
        return attendAppointments;
    }

    public void setAttendAppointments(List<Appointment> attendAppointments) {
        this.attendAppointments = attendAppointments;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "up822603.entwadraft.ent.user[ id=" + id + " ]";
    }
    
}
