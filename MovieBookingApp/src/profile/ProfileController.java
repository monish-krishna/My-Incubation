/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

import booking.Booking;
import data.Data;
import helper.Helper;
import java.util.ArrayList;
import user.User;
import user.Wallet;


/**
 *
 * @author Monish Krishna Selva
 */
public class ProfileController {
    private User user;
    private Wallet wallet;
    private ArrayList<Booking> bookings;
    private final Data data=Data.getInstance();
    private static ProfileController profile;
    private final Helper helper=new Helper();
    
    private ProfileController(){
    }
    
    public static ProfileController getInstance(){
        if(profile==null)
            profile=new ProfileController();
        return profile;
    }
    
    public void setUser(User user){
        this.user=user;
        setWallet(user);
        setBookings(user);
    }
    
    private void setWallet(User user){
        wallet=data.getWallet(user.getMailID());
    }
    
    public Wallet getWallet(){
        return wallet;
    }
    
    private void setBookings(User user){
        bookings=data.getBookings(user.getUserID());
    }
    
    public User getProfileUser(){
        return user;
    }
    
    public void setUpProfile(){
        user.setAddress(helper.getAddress());
        user.setLocation(helper.getLocation());
        initiateWallet();
    }
    
    public void initiateWallet(){
        wallet =new Wallet(user.getUserID());
        data.addWallet(wallet);
        switch(helper.getWalletAction(true)){
            case 1:{
                float amount=helper.getTopUpAmount();
                wallet.addBalance(amount);
                break;
            }case 2:{
                System.out.println("Skipping Wallet Top-Up for now. \nNOTE: Booking tickets will be done through wallet only.\n"
                        + "Kindly ensure recharging wallet before booking.");
                break;
            }
        }
    }
    
    public boolean isWalletInitiated(){
        return data.containsWallet(wallet);
    }
    
    public void topUpWallet(){
        float amount = helper.getTopUpAmount();
        wallet.addBalance(amount);
        System.out.println("Top-Up Successfull...");
    }
    
    public void changeName(){
        String newName = helper.getNewName();
        user.setName(newName);
        System.out.println("Name changed to '"+newName+"'.");
    }
    
    public void changeMailID(){
        user.setMailID(helper.getNewMailID());
    }
    
    public void changeMobileNo(){
        user.setMobileNo(helper.getNewMobileNo());
    }
    
    public void changePassword(){
        user.setPassword(helper.getNewPassword());
    }
    public void changeLocation(){
        user.setLocation(helper.getLocation());
    }
    
    public void changeAddress(){
        user.setAddress(helper.getAddress());
    }
}
