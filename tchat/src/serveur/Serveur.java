/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import interfaces.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exception.UnloggedUserException;

/**
 *
 * @author Nicolas & Sylvain
 */
public class Serveur implements Function{
    
    protected String name ;
    protected ArrayList<Thread> listThreads;
    protected ArrayList<String> listMessages;
    protected HashMap<String,Integer> listCorrespondance; //the "String" represents the last message received by the user number "Integer"
    
    public Serveur(){
      this.name="Call me daddy";
      this.listThreads = new ArrayList<Thread>();
      this.listMessages = new ArrayList<String>();
      this.listCorrespondance = new HashMap<String,Integer>();
    }
    
    public static void main(String[] args){
        Serveur serv = new Serveur();
    }

    @Override
    public String request(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getMessage(String id) throws UnloggedUserException {
    	String[] messages=null;
	
		if(listCorrespondance.get(id)==null){
			throw new UnloggedUserException("The user '"+id+"' isn't logged on the server");
		}
		else{
	    	int i = listCorrespondance.get(id);
	    	//Creation of a patern string array ofthe correct size
	    	String[] patern = new String[listMessages.size()-1-i];
	    	//Obtention of the subList representing the new messages
	    	List<String> subList = listMessages.subList(i, listMessages.size()-1);
	    	//Conversion of the sublist into String array
	    	messages=subList.toArray(patern);
		}
    	
    	return messages;
    }
    
    
}
