/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Function;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Client {
       protected String id;
       protected Function f;
       
       public Client(){
           Scanner sc = new Scanner(System.in);
           System.out.println("Please enter your name to enter the tchat");
           this.id = sc.nextLine();
           try{
               System.out.println(f.request(this.id));
           }
           catch(Exception e){
               System.out.println(e.getMessage());
           }
       }
       
       public static void main(String[] args){
             Client user = new Client();  
       }
}
