/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import authenticate.AuthenticationController;
import booking.Booking;
import data.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import profile.ProfileController;
import theatre.Movie;
import theatre.Screen;
import theatre.Theatre;
import user.Address;
import user.Location;

/**
 *
 * @author Monish Krishna Selva
 */
public class Helper {
    private final AuthenticationController authController; 
    public Helper(){
        this.authController=AuthenticationController.getInstance();
    }
    
    //For Registeration
    
    public byte getActionRegister(){
        Scanner s = new Scanner(System.in);
        System.out.print("\n1 - Complete profile set-up\n"
                + "2 - Skip for now\n-> ");
        return s.nextByte();
    }
    
    public String getName(){
        Scanner s = new Scanner(System.in);
        String name;
        System.out.print("Name: ");
        name = s.nextLine();
        return name;
    }
    
    public String getMailID(){
        Scanner s = new Scanner(System.in);
        String mailID;
        while(true){
            System.out.print("e-mailID: ");
            mailID = s.nextLine().toLowerCase();
            if(authController.isMailIDAvailable(mailID)){
                break;
            }else{
                System.out.print("Email ID already registered. Try another");
            }
        }
        return mailID;
    }
    
    public long getMobileNo(){
        Scanner s = new Scanner(System.in);
        long mobileNo;
        System.out.print("Mobile No: ");
        mobileNo = s.nextLong();
        return mobileNo;
    }
    
    public String getPassword(){
        String password;
        Scanner s = new Scanner(System.in);
        while(true){
            String passCheck;
            System.out.print("Password: ");
            password=s.nextLine();
            System.out.print("Confirm password: ");
            passCheck=s.nextLine();
            if(authController.confirmPassword(password, passCheck))
                return password;
            else
                System.out.println("Passwords didn't match.");
        }
    }
    
    public String getUserMailID(){  //for User Log-In
        Scanner s = new Scanner(System.in);
        String mailID;
        while(true){
            System.out.print("e-mail ID: ");
            mailID=s.next();
            mailID=mailID.toLowerCase();
            if(authController.isMailIDRegistered(mailID)){
                break;
            }else{
                System.out.print("e-mail ID is not registered kindly re-enter e-mail ID.\n\t"
                        + "1 - Retry\n\t"
                        + "0 - Exit\n-> ");
                if(s.nextByte()==0){
                   return null; 
                }
            }
        }
        return mailID;
    }
    
    public boolean checkUserPassword(String mailID){    //for User Log-In
        Scanner s = new Scanner(System.in);
        String password;
        while(true){
            System.out.print("Password: ");
            password=s.next();
            if(authController.checkPassword(mailID, password)){
                return true;
            }else{
                System.out.println("Incorrect password.\n\t"
                        + "1 - Retry\n\t"
                        + "0 - Exit");
                if(s.nextByte()==0){
                   return false; 
                }
            }
        }
    }
    
    public void printProfile(){
        ProfileController profileControl = ProfileController.getInstance();
        System.out.println("Your Profile:-");
        System.out.printf("%-17s : %s\n","NAME",profileControl.getProfileUser().getName());
        System.out.printf("%-17s : %s\n","E-MAIL ID",profileControl.getProfileUser().getMailID());
        System.out.printf("%-17s : %s\n","MOBILE NUMBER",profileControl.getProfileUser().getMobileNo());
        System.out.printf("%-17s : %s\n","CURRENT LOCATION",(profileControl.getProfileUser().getLocation()==null)?(" -"):(profileControl.getProfileUser().getLocation()));
        System.out.printf("%-17s : %s\n","ADDRESS",(profileControl.getProfileUser().getAddress()==null)?(" -"):(profileControl.getProfileUser().getAddress()));
        
    }
    
    public Address getAddress(){
        Scanner s = new Scanner(System.in);
        Address address=new Address();
        System.out.printf("Address: \n\t%13s : ","Door No.");
        address.setDoorNo(s.nextLine());
        System.out.printf("\t%13s : ","Lanmark/Area");
        address.setAddressLine1(s.nextLine());
        System.out.printf("\t%13s : ","District");
        address.setDistrict(s.nextLine());
        System.out.printf("\t%13s : ","State");
        address.setState(s.nextLine());
        System.out.printf("\t%13s : ","Pincode");
        address.setPincode(s.nextInt());
        return address;
    }
    
    
    public Location getLocation(){
        Scanner s = new Scanner(System.in);
        Location location;
        int count=0;
        ArrayList<Location> locations = new ArrayList<>();
        locations.addAll(Data.getInstance().theatres.keySet());
        System.out.println("Locations:-");
        for(Location current:locations){
            count++;
            System.out.print(current.ordinal()+". "+current+" ");
            if(count%4==0) System.out.println();
        }
        System.out.print("\nSelect your preferred location/location for booking: ");
        int noLocation=s.nextInt()-1;
        location=locations.get(noLocation);
        return location;
    }
    
    public String getNewName(){
        Scanner s = new Scanner(System.in);
        String newName; 
        
        System.out.print("Enter new Name: ");
        newName = s.nextLine();
        return newName;
    }
    
    public byte getWalletAction(boolean initial){
        Scanner s = new Scanner(System.in);
        
        if(initial){
            System.out.print("Wallet Top-Up\n\t"
                    + "1 - Recharge now\n\t"
                    + "0 - Skip Top Up for now\n"
                    + "-> ");
        }else{
            System.out.print("-----] Wallet [-----\n\t"
                    + "1 - Recharge Wallet\n\t"
                    + "0 - Back to Profile\n\t"
                    + "-> ");
        }
        
        return s.nextByte();
    }
    
    public void printWalletBalance(){
        System.out.println("\nWallet Balanace: "
                +ProfileController.getInstance().getWallet().getBalance());
    }
    
    public float getTopUpAmount(){
        Scanner s = new Scanner(System.in);
        float amount;
        System.out.print("Amount to Top-Up: ");
        amount = s.nextFloat();
        return amount;
    }
    
    
    
    public boolean authenticateUser(){
        Scanner s = new Scanner(System.in);
        ProfileController profileControl = ProfileController.getInstance();
        while(true){
            System.out.println("Confirm your mail ID and password to proceed...");
            System.out.print("Enter mailID: ");
            String mailID=s.next().toLowerCase();
            if(profileControl.getProfileUser().getMailID().equals(mailID)){
                while(true){
                    System.out.print("Enter password: ");
                    String password = s.next();
                    if(profileControl.getProfileUser().getPassword().equals(password)){
                        return true;
                    }else{
                        System.out.println("Password didn't match. Re-try!");
                    }
                }
            }else{
                System.out.println("Mail ID you entered is incorrect. Re-enter Mail ID.");
            }
        }
    }
    
    public String getNewMailID(){
        Scanner s = new Scanner(System.in);
        String newMailID="";
        if(authenticateUser()){
            System.out.print("Enter new Mail ID: ");
            newMailID=s.next();
        }
        return newMailID;
    }
    
    public long getNewMobileNo(){
        Scanner s = new Scanner(System.in);
        long newMobileNo=0;
        if(authenticateUser()){
            System.out.print("Enter new Mobile Number: ");
            newMobileNo=s.nextLong();
        }
        return newMobileNo;
    }
    
    public String getNewPassword(){
        Scanner s = new Scanner(System.in);
        String newPassword="";
        if(authenticateUser()){
            System.out.print("Enter new Password: ");
            newPassword=s.nextLine();
        }
        return newPassword;
    }
    
    //theatres
    public void printTheatres(ArrayList<Theatre> theatres){
        System.out.println("⫼⫼⫼ Theatres ⫼⫼⫼");
        System.out.printf(" %6s | %-15s | %-6s \n","S. No.","Theatre","Movie(s)");
        int index=0;
        for(Theatre theatre:theatres){
            ++index;
            ArrayList<Screen> theatreScreens = theatre.getScreens();
            System.out.printf(" %6s | %-15s | ",index,theatre.getName());
            String movieName=null;
            for(Screen screen: theatreScreens){ 
                if(movieName!=null) System.out.printf("%s, ",movieName);
                movieName =Data.getInstance().getMovieName(screen.getMovieID());
            }
            System.out.println(movieName);
        }
    }
    
    public int getSelectedTheatreNo(){
        Scanner s = new Scanner(System.in);
        int theatreNo;
        System.out.print("Enter Theatre No.: ");
        theatreNo=s.nextInt()-1;
        return theatreNo;
    }
    
    public int getSelectedMovieNo(){
        Scanner s = new Scanner(System.in);
        int movieNo;
        System.out.print("Enter Movie No.: ");
        movieNo=s.nextInt()-1;
        return movieNo;
    }
    
    public byte getTheatreSectionAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Select Theatre\n"
                + "0 - Back to Main menu\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public byte getMovieSectionAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Select Movie\n"
                + "0 - Back to Main menu\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public byte getScreenSectionAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Select Screen\n"
                + "0 - Back\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public byte getReviewSectionAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Give Rating\n"
                + "2 - Give Review\n"
                + "0 - Back\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public byte getRating(){
        Scanner s = new Scanner(System.in);
        System.out.print("Rate 1 - 5\n"
                + "Your rating: ");
        return s.nextByte();
    }
    
    public String getReview(){
        Scanner s = new Scanner(System.in);
        System.out.print("Your review: ");
        return s.nextLine();
    }
    
    public byte getMovieAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Movie details\n"
                + "2 - Go to Screens\n"
                + "0 - Back to Movies\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public LocalDate getShowDate(){
        Scanner s = new Scanner(System.in);
        LocalDate yDate = LocalDate.now().minusDays(1);
        System.out.println("Dates:-");
        int sNo=0;
        for(int i=0; i<5; i++){
            System.out.print("⫷ "+(++sNo)+" ⫸ "+yDate.plusDays(i+1).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+"  ");
        }
        System.out.print("\nSelect Date: ");
        LocalDate selectedDate = yDate.plusDays(s.nextByte());
        return selectedDate;
    }
    
    public LocalTime getShowTime(){
        Scanner s = new Scanner(System.in);
        LocalTime time= LocalTime.of(6, 00);
        System.out.println("Shows:-");
        for(int i=0; i<4; i++){
            System.out.print("⫷ "+(i+1)+" ⫸ "+time.plusHours(4*(i+1)).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))+" ");
        }
        System.out.print("\nSelect show time: ");
        LocalTime showTime = time.plusHours(s.nextByte()*4);
        return showTime;
    }
    
    public void printScreens(Theatre theatre){
        ArrayList<Screen> screens = theatre.getScreens();
        Data data = Data.getInstance();
        int index=0;
        String format = "%-6s | %-16s | %-15s \n";
        System.out.println(theatre.getName().toUpperCase()+"'s Screens:-");
        System.out.printf(format,"S. No.","Screen","Movie");
        for(Screen screen: screens){
            System.out.printf(format, ++index,screen.getName(),data.getMovieName(screen.getMovieID()));
        }
    }
    
    public void printScreens(ArrayList<Screen> screens){
        Data data = Data.getInstance();
        int index=0;
        String format = "%-6s | %-16s | %-15s \n";
        System.out.println("Screens for '"+data.getMovieName(screens.get(index).getMovieID())+"':-");
        System.out.printf(format,"S. No.","Screen","Theatre");
        for(Screen screen: screens){
            System.out.printf(format, ++index,screen.getName(),data.getTheatre(screen.getTheatreID()).getName());
        }
    }
    
    public Screen getSelectedScreen(ArrayList<Screen> screens){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Screen No.: ");
        int screenNo=s.nextInt()-1;
        return screens.get(screenNo);
    }
    
    public void printScreenName(String screenName){
        System.out.println("⫼⫼⫼ "+screenName+" ⫼⫼⫼");
    }
    
    public byte getScreenAction(){
        Scanner s= new Scanner(System.in);
        System.out.print("1 - Movie details\n"
                + "2 - Start Booking\n"
                + "0 - Back to Screens\n⪢ ");
        return s.nextByte();
    }
    
    public void printMovie(Movie movie){
        System.out.println("Movie:-");
        System.out.println("Name: "+movie.getName());
        System.out.println("Cast:- ");
        String cast[]= movie.getCast();
        if(cast!=null){
        for(int i=0;i<cast.length-1;i++){
            System.out.println((i+1)+". "+cast[i]+",");
        }
        System.out.println(cast.length+". "+cast[cast.length-1]+".");
        }else{
            System.out.println("\tCast details not available.");
        }
        
        System.out.print("Rating: ");
        float rating = movie.getRating();
        if(rating>0){
            System.out.println(rating);
        }else{
            System.out.println("No ratings yet.");
        }
        int spaceCount=0;
        if(movie.getDescription()!=null){
            String words[] = movie.getDescription().split(" ");
            System.out.print("\t");
            for (String word : words) {
                System.out.print(word + " ");
                spaceCount++;
                if(spaceCount%10==0) System.out.println();
            }
        }
        System.out.println();
        
        ArrayList<String> reviews = movie.getReview();
        int index=0;
        if(reviews.size()>0){
            System.out.println("Reviews:-");
            for(String review: reviews){
                System.out.println(++index+". "+review);
            }
        }
        System.out.println();
    }
    
    public byte getActionBactToScreen(){
        Scanner s = new Scanner(System.in);
        System.out.print("0 - Back to Screen\n"
                + "⪢ ");
        return s.nextByte();
    }
    
    public void printShowStartedMessage(){
        System.out.println("Show booking closed. This show may already have been started. Select another show.");
    }
    
    public void printShowHouseFullMessage(){
        System.out.println("This show is HOUSEFULL. Select another show/date.");
    }
    
    public void printSeats(boolean seats[][]){
        System.out.println("Seats:-");
        for(int i=0;i<seats.length;i++){
            char row = (char)(i+'A');
            System.out.printf(" Row %2d : ",i+1);
            for(int j=0;j<seats[i].length;j++){
                String s =(seats[i][j])?(String.format(" %c%-2d ",row,j+1)):(String.format(" %-3s ","###"));
                System.out.print("|"+s);
            }
            System.out.println("|");
        }
        System.out.println("### - Seat not available");
    }
    
    public byte getActionShow(){
        Scanner s = new Scanner(System.in);
        System.out.print("1 - Book seats\n"
                + "2 - Change Show\n"
                + "3 - Change Date\n"
                + "0 - Back to Screen\n"
                + "⪢ ");
        return s.nextByte();
    }
    
    public String[] getSeats(){
        Scanner s = new Scanner(System.in);
        int noOfSeats;
        String[] seats;
        while(true){
            System.out.print("Number of Seats: ");
            noOfSeats = s.nextInt();
            seats= new String[noOfSeats];
            if(noOfSeats<=5){
                for(int i=0; i<noOfSeats; i++){
                    System.out.print("Seat "+(i+1)+": ");
                    seats[i]=s.next().toUpperCase();
                }
                break;
            }else{
                System.out.print("Note: Only 5 seats are allowed per booking at a time.\n"
                        + "If more than  seats are entered others will be discarded.\n");
            }
        }
        return seats;
    }
    
    public void printSeatNotAvailable(){
        System.out.println("Seats selected were not availabe/incorrect. Kindly enter available/correct seats.");
    }
    
    public void printTheatreNoIncorrect(){
        System.out.println("Theatre number is incorrect. Give valid Theatre Number.");
    }
    
    public byte getPaymentConfirmAction(String seats[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Selected seats: ");
        for(String seat : seats){
            System.out.print(seat+" ");
        }
        System.out.print("\n1 - Confirm & Go to Payment [via wallet]\n"
                + "0 - Cancel Booking\n"
                + "⪢ ");
        return s.nextByte();
    }
    
    public void printBookingConfirmation(String seats[]){
        System.out.print((seats.length>1)?("Seats "):("Seat "));
        for(int i=0; i<seats.length-1;i++){
            System.out.print(seats[i]+", ");
        }
        System.out.print(seats[seats.length-1]+((seats.length>1)?(" were"):(" was"))+" booked. Enjoy the show.\n");
    }
    
    public void printInsufficientBalanceMessage(){
        System.out.println("Insuffient balance. Kindly Top-Up enough amount before booking.");
    }
    
    public void printBooking(Booking booking){
        Data data = Data.getInstance();
        System.out.println("\nBooking Ref. ID: "+booking.getBookingRefNo());
        System.out.println("Screen: "+data.getScreen(booking.getScreenID()).getName());
        System.out.println("Movie: "+data.getMovieName(booking.getMovieID()));
        System.out.println("Show Date: "+ booking.getShowDate());
        System.out.println("Show Time: "+ booking.getShowTime().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        String seats[] = booking.getSeats();
        System.out.print((seats.length>1)?("Seats "):("Seat "));
        for(int i=0; i<seats.length-1;i++){
            System.out.print(seats[i]+", ");
        }
        System.out.println(seats[seats.length-1]+ ".");
        
        System.out.println("Booked Date: "+booking.getDate());
        System.out.println((booking.getCancelStatus())?("This booking was CANCELLED\n"):("\n"));
    }
    
    public void printMovieScreen(LinkedHashMap<Long,ArrayList<Screen>> movieScreens){
        System.out.println("⫼⫼⫼ Movies ⫼⫼⫼");
        System.out.printf(" %6s | %-15s | %-6s \n","S. No.","Movie","Screen(s)");
        int index=0;
        Data data = Data.getInstance();
        long movieID;
        Iterator<Long> iterator = movieScreens.keySet().iterator();
        while(iterator.hasNext()){
            ++index;
            movieID=iterator.next();
            ArrayList<Screen> screens = movieScreens.get(movieID);
            System.out.printf(" %6s | %-15s | ",index,data.getMovieName(movieID));
            String screenName=null;
            for(Screen screen: screens){ 
                if(screenName!=null) System.out.printf("%s, ",screenName);
                screenName =screen.getName();
            }
            System.out.println(screenName);
        }
    }
    
    public void printBookings(ArrayList<Booking> bookings,boolean currentBooking){
        if(bookings!=null && bookings.size()>0){
            int previousBookingCounter=0;
            int currentBookingCounter=0;
            System.out.println(((currentBooking)?("Current Bookings:-"):("Previous Bookings:-")));
            for(Booking booking: bookings){
                LocalDateTime showDateTime = LocalDateTime.of(booking.getShowDate(), booking.getShowTime());
                if(currentBooking){
                    if(showDateTime.isAfter(LocalDateTime.now())){
                        printBooking(booking);
                        currentBookingCounter++;
                    }
                }else{
                    if(showDateTime.isBefore(LocalDateTime.now())){
                        printBooking(booking);
                        previousBookingCounter++;
                    }
                }
            }
            if(currentBooking && currentBookingCounter==0){
                System.out.println("No current Bookings.");
            }else if(!currentBooking && previousBookingCounter==0){
                System.out.println("No previous Bookings.");
            }
        }else{
            System.out.println("No Bookings Yet.");
        }
    }
    
    public byte getBookingAction(){
        Scanner s = new Scanner(System.in);
        byte action;
        System.out.print("1 - Cancel Booking\n"
                + "0 - Back to Profile\n"
                + "⫸ ");
        action = s.nextByte();
        return action;
    }
    
    public Long getBookingRefID(){
        Scanner s = new Scanner(System.in);
        System.out.print("Booking Cancellation:-\n"
                + "Enter Booking Ref. ID: ");
        return s.nextLong();
    }
}

