/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exception.BadRequest;
import exception.UnloggedUserException;

/**
 *
 * @author Nicolas
 */
public interface Function extends Remote {
    
    /**
     * method to connect user to the server "Call me daddy"
     * @param id
     * @return 
     */
    public String request(String id) throws BadRequest, RemoteException;
    /**
     * Method giving the list of new messages
     * @param id
     * 		Id of the user who do the request
     * @return
     * 		The list of messages
     * @throws UnloggedUserException 
     * @throws BadRequest 
     */
    public String[] getMessage(String id) throws UnloggedUserException, BadRequest, RemoteException;
    
}
