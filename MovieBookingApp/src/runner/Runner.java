/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import java.util.Scanner;
import authenticate.LogIn;
import authenticate.Register;
import booking.Booking;
import booking.BookingController;
import data.Data;
import helper.Helper;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import profile.ProfileController;
import theatre.Tester;
import user.User;


/**
 *
 * @author Monish Krishna Selva
 */
public class Runner {
    private final LogIn logIn = LogIn.getInstance();
    private User user;
    private final ProfileController profileControl = ProfileController.getInstance();
    private final Helper helper;
    private final BookingController bookingControl;
    
    public Runner(){
        this.helper=new Helper();
        this.bookingControl=new BookingController();
    }
    
    public byte getOpenAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - LogIn\n2 - Register\n0 - Exit Application\n-> ");
        action = s.nextByte();
        return action;
    }
    
    public void runLogIn(){
        boolean result=logIn.run();
        if(result){ 
            user=logIn.getLoggedInUser();
            profileControl.setUser(user);
            System.out.println("Successfully Logged In");
            runMainMenu();
        }
        else System.out.println("Exiting LogIn.");
    }
    
    public byte getMainMenuAction(){
        Scanner s = new Scanner(System.in);
        System.out.print("-----] Main Menu [-----\n\t"
                + "1 - Profile\n\t"
                + "2 - Movies\n\t"
                + "3 - Theatres\n\t"
                + "0 - Log Out\n\t"
                + "-> ");
        return s.nextByte();
    }
    
    public byte getProfileAction(){
        Scanner s = new Scanner(System.in);
        System.out.print("-----] Profile [-----\n\t"
                + "1 - Print Profile\n\t"
                + "2 - Wallet\n\t"
                + "3 - Edit Profile\n\t"
                + "4 - Current Bookings\n\t"
                + "5 - Previous Bookings\n\t"
                + "0 - Exit profile\n\t"
                + "-> ");
        return s.nextByte();
    }
    
    public void printProfile(){
        helper.printProfile();
    }
    
    public void runProfileSetUp(){
        System.out.println("Complete profile setup...");
        profileControl.setUpProfile();
    }
    
    public void runWallet(){
        if(!profileControl.isWalletInitiated()){
            profileControl.initiateWallet();
        }
        loopWhile: while(true){
            helper.printWalletBalance();
            switch(helper.getWalletAction(false)){
                case 1:{
                    profileControl.topUpWallet();
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public byte getEditProfileAction(){
        Scanner s = new Scanner(System.in);
        System.out.print("-----] Edit profile [-----\n\t"
                + "1 - Change Name\n\t"
                + "2 - Change Mail ID\n\t"
                + "3 - Change Mobile Number\n\t"
                + "4 - Change Location\n\t"
                + "5 - Change Password\n\t"
                + "6 - Change Address\n\t"
                + "0 - Back to Profile\n\t"
                + "-> ");
        return s.nextByte();
    }
    
    public void runEditProfile(){
        loopWhile: while(true){
            switch(getEditProfileAction()){
                case 1:{
                    profileControl.changeName();
                    break;
                }case 2:{
                    profileControl.changeMailID();
                    break;
                }case 3:{
                    profileControl.changeMobileNo();
                    break;
                }case 4:{
                    profileControl.changeLocation();
                    break;
                }case 5:{
                    profileControl.changePassword();
                    break;
                }case 6:{
                    profileControl.changeAddress();
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public void runBookings(boolean currentBooking){
        ArrayList<Booking> bookings=Data.getInstance().getBookings(user.getUserID());
        loopWhile: while(true){
            helper.printBookings(bookings, currentBooking);
            if(currentBooking && (bookings!=null && bookings.size()>0)){
                switch(helper.getBookingAction()){
                    case 1:{
                        if(helper.checkUserPassword(profileControl.getProfileUser().getMailID())){
                            cancelBooking(bookings);
                        }
                        break;
                    }case 0:{
                        break loopWhile;
                    }
                }
            }else{
                break;
            }
        }
    }
    
    public void cancelBooking(ArrayList<Booking> bookings){
        Long bookingRefID = helper.getBookingRefID();
        boolean checker = true;
        for(Booking booking: bookings){
            if(!booking.getCancelStatus() && booking.getBookingRefNo()==bookingRefID){
                int noOfSeats=booking.getSeats().length;
                float seatPrice= Data.getInstance().getScreen(booking.getScreenID()).getSeatPrice();
                float totalPrice = seatPrice*noOfSeats;
                profileControl.getWallet().addBalance(totalPrice);
                booking.setCancelStatus(true);
                checker=false;
                return;
            }
        }
        if(checker){
            System.out.println("No bookings in this ID/ This booking might be cancelled already.");
        }
    }
    
    public void runProfile(){
        if(user.getAddress()==null){
            runProfileSetUp();
        }
        loopWhile: while(true){
            switch(getProfileAction()){
                case 1:{
                    printProfile(); 
                    break;
                }case 2:{
                    runWallet(); 
                    break;
                }case 3:{
                    runEditProfile();
                    break;
                }case 4:{
                    runBookings(true);
                    break;
                }case 5:{
                    runBookings(false);
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    
    
    public void runMainMenu(){
        loopWhile: while(true){
            switch(getMainMenuAction()){
                case 1:{
                    runProfile();
                    break;
                }case 2:{
                    bookingControl.runMoviesSection();
                    break;
                }case 3:{
                    bookingControl.runTheatresSection();
                    break;
                }case 0:{
                    logIn.setLogInStatus(false);
                    System.out.println("Logged Out.");
                    break loopWhile;
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Runner runner = new Runner();
        Tester tester = new Tester();
        tester.run();
        loopWhile: while(true){
            switch(runner.getOpenAction()){
                case 1:{
                    System.out.println("-----] LOG IN [-----");
                    runner.runLogIn();
                    break;
                }case 2:{
                    System.out.println("-----] REGISTER [-----");
                    Register register = new Register();
                    register.run();
                    break;
                }case 0:{
                    break loopWhile;
                }
                default:{
                    System.out.println("Invalid Input");
                }
            }
        }
    }
}
