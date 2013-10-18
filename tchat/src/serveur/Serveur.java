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
    public String request(String str) {
        char parseChar = ' ';
        int indiceToParse;
        indiceToParse = str.indexOf(parseChar);
        
        String subStr = str.substring(0, indiceToParse);
        
        switch (subStr){
           case "connect":
                return "l'utilisateur s'est connecté"; //rajouter son nom et son id
           case "send":
               return "message envoyé"; //rajouter le message
           case "bye":
               return "l'utilisateur s'est déconnecté"; //rajouter son nom et son id
           case "who":
               String listUsers = new String();
               for(String idUser : this.listeCorrespondance.keySet()){
                   listUsers+=idUser;
               }
               return listUsers; //liste des personnes présentent dans la hashmap
           default:
               return""; 
        }
        
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
