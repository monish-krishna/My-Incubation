/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package authenticate;

import data.Data;
import helper.Helper;
import profile.ProfileController;
import user.User;

/**
 *
 * @author Monish Krishna Selva
 */
public class Register {
    private User user;
    private final Data regUsers;
    private final Helper helper;
    
    public Register(){
        this.regUsers=Data.getInstance();
        this.helper=new Helper();
    }
    
    public void run(){
        registerUser(1);
        byte action=helper.getActionRegister();
        registerUser(action+1);
        System.out.println("Registration successful.");
    }
    
    public void registerUser(int action){
        switch(action){
            case 1:{
                regUserEssential();
                regUsers.addUser(user);
                break;
            }case 2:{
                regUserAdditional();
                break;
            }
        }
    }
    
    public void regUserEssential(){
        String name;
        String mailID;
        long mobileNo;
        String password;
        
        name=helper.getName();
        mailID=helper.getMailID();
        mobileNo = helper.getMobileNo();
        password=helper.getPassword();
        
        user=new User.UserBuilder()
                .name(name)
                .mailID(mailID)
                .mobileNo(mobileNo)
                .password(password)
                .build();
        
    }
    
    public void regUserAdditional(){
        ProfileController.getInstance().setUser(user);
        user.setAddress(helper.getAddress());
        user.setLocation(helper.getLocation());
        ProfileController.getInstance().initiateWallet();
    }
}
