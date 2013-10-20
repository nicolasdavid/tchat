/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Function;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Client {
       protected String id;
       protected Function f;
       
       public Client(){
    	   try{
    		   //f=(Function)Naming.lookup("//127.0.0.1/C:/users/Nicolas/Desktop/ei3/info/objet/tp_tchat/tchat/");
    		   f=(Function)Naming.lookup("//192.168.0.17/C:/users/Nicolas/Desktop/ei3/info/objet/tp_tchat/tchat/");
    		   //f=(Function) Naming.lookup("//127.0.0.1/C:/users/sylvain/workspace/tchat/tchat/bin");
    		   System.out.println("Client connecté");
    	   }
    	   catch (Exception e){
    		   e.printStackTrace();
    	   }
           Scanner sc = new Scanner(System.in);
           System.out.println("Please enter your name to enter the tchat");
           this.id = sc.nextLine();
           try{
               System.out.println(f.request("connect "+this.id));
           }
           catch(Exception e){
               System.out.println(e.getMessage());
           }
       }
       
       public static void main(String[] args){System.setSecurityManager(new RMISecurityManager());
	       Client user = new Client();
       }
}
