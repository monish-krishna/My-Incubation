/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authenticate;

import data.Data;

/**
 *
 * @author Monish Krishna Selva
 */
public class AuthenticationController {
    private final Data regUsers=Data.getInstance();
    private static AuthenticationController authController;
    
    private AuthenticationController(){}
    
    public static AuthenticationController getInstance(){
        if(authController==null)
            authController=new AuthenticationController();
        return authController;
    }
    
    public boolean isMailIDAvailable(String mailID){
        return !regUsers.isUserRegistered(mailID);
    }
    
    public boolean isMailIDRegistered(String mailID){
        return regUsers.isUserRegistered(mailID);
    }
    
    public boolean confirmPassword(String password,String passCheck){
        return (password!=null&&passCheck!=null)&&password.equals(passCheck);
    }
    
    public boolean checkPassword(String mailID,String password){
        return password!=null&&password.equals(regUsers.getRegUser(mailID).getPassword());
    }
}
