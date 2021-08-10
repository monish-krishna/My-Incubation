/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authenticate;

import data.Data;
import helper.Helper;
import user.User;

/**
 *
 * @author Monish Krishna Selva
 */
public class LogIn {
    private User loggedInUser;
    private boolean logInStatus;
    private final Data allUsers = Data.getInstance();
    private static LogIn logIn;
    private final Helper helper;
    
    private LogIn(){
        logInStatus=false;
        helper = new Helper();
    }
    
    public static LogIn getInstance(){
        if(logIn==null)
            logIn=new LogIn();
        return logIn;
    }
    
    public boolean run(){
        String mailID=helper.getUserMailID();
        if(mailID==null){
            return false;
        }
        if(helper.checkUserPassword(mailID)){
            setLoggedInUser(allUsers.getRegUser(mailID));
            setLogInStatus(true);
            return true;
        }else{
            return false;
        }
    }
    
    private void setLoggedInUser(User user){
        if(user!=null&&logInStatus==false)
            loggedInUser=user;
    }
    
    public User getLoggedInUser(){
        return loggedInUser;
    }
    
    public void setLogInStatus(boolean status){
        logInStatus=status;
    }
    
    public boolean getLogInStatus(){
        return logInStatus;
    }
}
