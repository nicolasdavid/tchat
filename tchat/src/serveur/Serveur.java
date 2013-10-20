/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import exception.BadRequest;
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
        
        //Test
        try{
        //Connection of diferents users
        System.out.println(serv.request("connect Loutrosky"));
        System.out.println(serv.request("connect GitanEnCaravane"));
        System.out.println(serv.request("connect T0t0_du_44"));
        
        //Sending messages
        System.out.println(serv.request("send Loutrosky Je suis une loutre bien grasse"));
        System.out.println(serv.request("send T0t0_du_44 Et tuaimes ça!!!"));
        System.out.println(serv.request("send GitanEnCaravane tu t'appellerais pas Sébastien par hasard ?"));
        
        //Quit
        System.out.println(serv.request("quit Loutrosky"));
        
        //Sending messages
        System.out.println(serv.request("send T0t0_du_44 Tu l'as vexé..."));
        System.out.println(serv.request("send GitanEnCaravane Quelle tata celui-la"));
        System.out.println(serv.request("send GitanEnCaravane Bon je m'en vais"));
        
        //Quit
        System.out.println(serv.request("quit GitanEnCaravane"));
        System.out.println(serv.request("quit T0t0_du_44"));
        }
        catch(Exception e){
            
        }
    }

    
    public String request(String str) throws BadRequest{
        char parseChar = ' ';
        int indiceToParseREQ;
        int indiceToParseID;
        
        indiceToParseREQ = str.indexOf(parseChar); 
        String subStrA;
        String subStrBC;
        String subStrB;
        String subStrC;
        
        if(indiceToParseREQ==-1){
            subStrA = str;
            subStrBC="";
        }
        else {
            subStrA = str.substring(0, indiceToParseREQ); 
            subStrBC = str.substring(indiceToParseREQ+1); 
        }
        
        indiceToParseID = subStrBC.indexOf(parseChar);

        if (indiceToParseID == -1){
            subStrB=subStrBC;
            subStrC="";
        }
        else {
            subStrB = subStrBC.substring(indiceToParseREQ+1, indiceToParseID); 
            subStrC = subStrBC.substring(indiceToParseID+1);
        }
      
        switch (subStrA){
           case "connect":
               //TODO if B empty throws exception
                return "the user " +subStrB+ " is connected"; //TODO test sur subStrB vérifier que la requete est bonne
           case "send":
               //TODO if B||C empty throws exception
               return "message send";
           case "bye":
               //TODO if B empty throws exception
               return "l'utilisateur "+subStrB+" s'est déconnecté"; //rajouter son nom et son id
           case "who":
               String listUsers = new String();
               for(String idUser : this.listCorrespondance.keySet()){
                   listUsers+=idUser;
               }
               return listUsers; //liste des personnes présentent dans la hashmap
           default:
               throw new BadRequest("The request "+ subStrA +" does not exist ! Try another one please.");
               
        }
        
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
