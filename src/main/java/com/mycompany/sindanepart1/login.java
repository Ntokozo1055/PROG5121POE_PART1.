/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sindanepart1;

/**
 *
 * @author ntokozo
 */
public class login {
    // Declaration 
    
    String registeredUsername;
    String registeredPassword;
    String registeredCellNum;
    String firstName;
    String lastName;
    
    //Check the username 
    
   boolean checkUsername(String username){
        return username.contains("_")&& username.length()<=5;
            
    }
   
   // Check password complexity
   
   
   boolean checkPasswordComplexity(String password){
       boolean hasLength=false;
       boolean hasCapital=false;
       boolean hasNumber=false;
       boolean hasSpecialChar=false;
       
       //we will check the length first
       if(password.length()>=8){
           hasLength=true;
       }
       
       int i=0;
       while(i<password.length()){
           char character=password.charAt(i);
           
           if(Character.isUpperCase(character)){
               hasCapital=true;
           }else if(Character.isDigit(character)){
               hasNumber=true;
           }else if(Character.isLetterOrDigit(character)){
           hasSpecialChar=true;
       }
          i++;     
              
       }
       
       if(hasLength && hasCapital && hasNumber && hasSpecialChar){
           return true;
       }else{
           return false;
       }
   }
   
   //check the cell phone number
   
   boolean checkCellPhoneNumber(String cellPhoneNum){
       if(cellPhoneNum.startsWith("+")&& cellPhoneNum.length()<=10){
           
           int i=1;
           while(i<cellPhoneNum.length()){
               if(!Character.isDigit(cellPhoneNum.charAt(i))){
                   return false;
               }
               i++;
           }
           return true;
       }else{
           return false;
       }
   }
   
   //we will now register the user
   
   String registerUser(String username, String password, String cellPhoneNum, String name,
           String surname){
       
       this.firstName=surname;
       this.lastName=surname;
       
       if(!checkUsername(username)){
           return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters.";
       }
       if(!checkPasswordComplexity(password)){
           return "Password is not correctly formatted, please ensure that the password contains at least 8 characters a capital letter, a numberand a special character.";
           
       }
       if(!checkCellPhoneNumber(cellPhoneNum)){
           return "Cell phone number is not correctly formatted or does not contain an international code. Please correctthe numberand try again.";
       }
       
       this.registeredUsername=username;
       this.registeredPassword=password;
       this.registeredCellNum=cellPhoneNum;
       
       return "User registered successfully.";
   }
   
   //Now we login the user in
   boolean loginUser(String enteredUsername, String enteredPassword){
       if(enteredUsername.equals(registeredUsername)&& enteredPassword.equals(registeredPassword)){
           return true;
       }else{
           return false;
       }
   }
    
   //return login status
   
   String returnLoginStatus(boolean isLoggedIn){
       if(isLoggedIn){
           return "Welcome"+firstName+";"+lastName+"it is great to see you.";
       }else{
           return "Username or password is incorrect, please try again.";
       }
   }
}
