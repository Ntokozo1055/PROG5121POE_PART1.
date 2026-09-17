/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sindanepart1;
import java.util.Scanner; 
/**
 *
 * @author ntokozo
 */
public class SindanePart1 {

    public static void main(String[] args) {
        // Declaration 
        String name;
        String surname;
        String username;
        String password;
        String cellPhoneNum;
        String registerationMessage;
        
        
        Scanner myInput=new Scanner(System.in);
        login loginSystem=new login();
        
        System.out.println("=====REGISTERATION=====");
        
        //prompt the user for their details in order to get logged in
        
        System.out.print("Enter your first name: ");
        name=myInput.nextLine();
        
        System.out.print("Enter your last name: ");
        surname=myInput.nextLine();
        
        System.out.println("Your username must contain an underscore '_' and maximum 5 character.");
        System.out.print("Enter your username: ");
        username=myInput.nextLine();
        
         System.out.println("Your password must contain minimum 8 character, 1 capital letter, 1 number, 1 special character.");
        System.out.print("Enter your password: ");
        password=myInput.nextLine();
        
        System.out.print("Enter your cell phone number (e.g. +27603425132): ");
        cellPhoneNum=myInput.nextLine();
        
        //call the register method and display the result
        registerationMessage=loginSystem.registerUser(username, password, cellPhoneNum, name, surname);
        System.out.println(registerationMessage);
        
        //only login if registeration was successful
        
        if(registerationMessage.equals("User registered successfully.")){
            System.out.println("=====LOGIN=====");
            
            System.out.print("Enter username: ");
            String loginUsername=myInput.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword=myInput.nextLine();
            
            //check login and display status
            
            boolean isLoggedIn=loginSystem.loginUser(loginUsername, loginPassword);
            System.out.println(loginSystem.returnLoginStatus(isLoggedIn));
            
            
        }
         myInput.close();
    }
}
