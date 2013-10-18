/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import interfaces.Function;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nicolas & Sylvain
 */
public class Serveur implements Function{
    
    protected String name ;
    protected ArrayList<Thread> listThreads;
    protected ArrayList<String> listMessages;
    protected HashMap<String,Integer> listeCorrespondance; //the "String" represents the last message received by the user number "Integer"
    
    public Serveur(){
      this.name="Call me daddy";
      this.listThreads = new ArrayList<Thread>();
      this.listMessages = new ArrayList<String>();
      this.listeCorrespondance = new HashMap<String,Integer>();
    }
    
    public static void main(String[] args){
        Serveur serv = new Serveur();
    }

    @Override
    public String request(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
