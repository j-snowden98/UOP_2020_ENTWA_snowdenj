/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe.entwa.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import joe.entwa.ent.Account;
import joe.entwa.pers.AccountFacade;

/**
 *
 * @author Joe
 */
@Stateless
public class ContactService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private AccountFacade af;
    
    public Account addContact(Account user, Account newContact) {
        user.getContacts().add(newContact);
        newContact.getContacts().add(user);
        
        af.edit(user);
        af.edit(newContact);
        return user;
    }
}