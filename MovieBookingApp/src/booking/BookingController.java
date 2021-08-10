/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import data.Data;
import helper.Helper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import profile.ProfileController;
import theatre.Movie;
import theatre.Screen;
import theatre.Show;
import theatre.Theatre;
import user.Location;
import user.User;

/**
 *
 * @author Monish Krishna Selva
 */
public class BookingController {
    private final Data data = Data.getInstance();
    private final ProfileController profileControl = ProfileController.getInstance();
    private final Helper helper;
    
    public BookingController(){
        helper=new Helper();
    }
    public void runMoviesSection() {
        LinkedHashMap<Long,ArrayList<Screen>> movieScreens = getAvailableMovieScreens();
        loopWhile: while(true){
            helper.printMovieScreen(movieScreens); 
            switch(helper.getMovieSectionAction()){ 
                case 1:{
                    runMovie(movieScreens);
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public void runMovie(LinkedHashMap<Long,ArrayList<Screen>> movieScreens){
        try{
            Iterator<Long> movieIDs = movieScreens.keySet().iterator();
            int index=0;
            int position=helper.getSelectedMovieNo();
            long movieID=0;
            while(movieIDs.hasNext()){
                if(index==position){
                    movieID=movieIDs.next();
                    break;
                }
                ++index;
            }
            ArrayList<Screen> screens = movieScreens.get(movieID); 
            loopWhile: while(true){
                switch(helper.getMovieAction()){
                    case 1:{
                        Movie movie = data.getMovie(movieID);
                        helper.printMovie(movie);
                        runReviewSection(movie);
                        break;
                    }case 2:{
                        runScreenSection(screens);
                        break;
                    }case 0:{
                        break loopWhile;
                    }
                }
            }
        }catch(IndexOutOfBoundsException ex){
            helper.printTheatreNoIncorrect();
        }
    }
    
    public void runReviewSection(Movie movie){
        loopWhile: while(true){
            switch(helper.getReviewSectionAction()){
                case 1:{
                    movie.addRating(helper.getRating());
                    break;
                }case 2:{
                    movie.addReview(helper.getReview());
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public void runScreenSection(ArrayList<Screen> screens){
        loopWhile: while(true){
            helper.printScreens(screens);
            switch(helper.getScreenSectionAction()){
                case 1:{
                    Screen screen = helper.getSelectedScreen(screens);
                    runScreen(screen);
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public LinkedHashMap<Long,ArrayList<Screen>> getAvailableMovieScreens(){
        Location location=getUserLocation();
        ArrayList<Screen> availScreens = data.getAvailableScreens(location);
        LinkedHashMap<Long,ArrayList<Screen>> movieScreens = new LinkedHashMap<>();
        long movieID;
        for(Screen screen: availScreens){
            movieID = screen.getMovieID();
            if(movieScreens.containsKey(movieID)){
                movieScreens.get(movieID).add(screen);
            }else{
                ArrayList<Screen> screens = new ArrayList<>();
                screens.add(screen);
                movieScreens.put(movieID, screens);
            }
        }
        return movieScreens;
    }
    
    public Location getUserLocation(){
        Location location;
        if(profileControl.getProfileUser().getLocation()==null){
            profileControl.getProfileUser().setLocation(helper.getLocation());
        }
        location = profileControl.getProfileUser().getLocation();
        return location;
    }
    
    public void runTheatresSection(){
        Location location=getUserLocation();
        ArrayList<Theatre> theatres = data.getAvailableTheatres(location);
        loopWhile: while(true){
            helper.printTheatres(theatres);
            switch(helper.getTheatreSectionAction()){
                case 1:{
                    runTheatre(theatres);
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
    }
    
    public void runTheatre(ArrayList<Theatre> theatres){
        try{
        Theatre theatre = theatres.get(helper.getSelectedTheatreNo());
        loopWhile: while(true){
            helper.printScreens(theatre);
            switch(helper.getScreenSectionAction()){
                case 1:{
                    Screen screen = helper.getSelectedScreen(theatre.getScreens());
                    runScreen(screen);
                    break;
                }case 0:{
                    break loopWhile;
                }
            }
        }
        }catch(IndexOutOfBoundsException ex){
            helper.printTheatreNoIncorrect();
        }
    }
    
    public void runScreen(Screen screen){
        helper.printScreenName(screen.getName());
        Movie movie = data.getMovie(screen.getMovieID());
        loopWhile: while(true){
            switch(helper.getScreenAction()){
                case 0:{
                    break loopWhile;
                }case 1:{
                    helper.printMovie(movie);
                    while(true){
                      if(helper.getActionBactToScreen()==0) break;
                    }
                    break;
                }case 2:{
                    runBooking(screen);
                    break;
                }
            }
        }
    }
    
    public void runBooking(Screen screen){
        LocalDate showDate;
        LocalTime showTime;
        showDate = helper.getShowDate();
        showTime = helper.getShowTime();
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime showDateTime = LocalDateTime.of(showDate, showTime);
        Show show = data.getShow(screen, showDate, showTime);
        if(showDateTime.minusHours(1).isAfter(currentDateTime) && show.getSeatAvailability()){
        loopWhile: while(true){
            show = data.getShow(screen, showDate, showTime);
            if(show.getSeatAvailability()){
                helper.printSeats(show.getSeats());
                switch(helper.getActionShow()){
                    case 1:{
                        bookShow(screen,show,showDate);
                        break loopWhile;
                    }case 2:{
                        showTime=helper.getShowTime();
                        break;
                    }case 3:{
                        showDate = helper.getShowDate();
                        break;
                    }case 0:{
                        break loopWhile;
                    }
                }
            }else{
                helper.printShowHouseFullMessage();
                break;
            }
        }
        }else if(!show.getSeatAvailability()){
            helper.printShowHouseFullMessage();
        }else{
            helper.printShowStartedMessage();
        }
    }
    
    public void bookShow(Screen screen,Show show,LocalDate showDate){
        String seats[];
        while(true){      
            seats=helper.getSeats();
            if(validateSeats(show,seats)){
                bookSeats(screen,show,showDate,seats);
                break;
            }else{
                helper.printSeatNotAvailable();
            }
        }
    }
    
    public void bookSeats(Screen screen,Show show,LocalDate showDate,String seats[]){
        byte action = helper.getPaymentConfirmAction(seats);
        loopWhile: while(true){
            switch(action){
                case 1:{
                    User profileUser=profileControl.getProfileUser();
                    boolean passwordChecker = helper.checkUserPassword(profileUser.getMailID());
                    float totalPrice = seats.length*data.getScreen(show.getScreenID()).getSeatPrice();
                    if(passwordChecker && profileControl.getWallet().getBalance()>=totalPrice){
                        profileControl.getWallet().deductBalance(totalPrice);
                        Booking booking = createBooking(screen,show,showDate,seats);
                        data.addBooking(profileUser.getUserID(), booking);
                        setSeatsBooked(show,seats);
                        helper.printBookingConfirmation(seats);
                    }else{
                        helper.printInsufficientBalanceMessage();
                        return;
                    }
                }case 0:{
                    return;
                }
            }
        }
    }
    
    public Booking createBooking(Screen screen,Show show,LocalDate showDate,String seats[]){
        Booking booking ;
        booking = new Booking();
        booking.setShowDate(showDate);
        booking.setDate(LocalDate.now());
        booking.setMovieID(screen.getMovieID());
        booking.setScreenID(screen.getScreenID());
        booking.setShowTime(show.getShowTime());
        booking.setSeats(seats);
        return booking;
    }
    
    public boolean validateSeats(Show show,String seats[]){
        int row;
        int column;
        try{
        for (String seat : seats) {
            if (seat != null) {
                row = getSeatRow(seat);
                column = getSeatColumn(seat);
                if(!show.getSeatStatus(row, column)){
                    return false;
                }
            }
        }
        }catch(IndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
    public int getSeatRow(String seat){
        seat=seat.toLowerCase();
        char seatChars[] = seat.toCharArray();
        int row=(int)seatChars[0] - 'a';
        return row;
    }
    
    public int getSeatColumn(String seat){
        char seatChars[] = seat.toCharArray();
        int column=(int)seatChars[1] - (int)'0';
        if(seatChars.length>2){
            column=(column*10)+((int)seatChars[2] - '0');
        }
        return column-1;
    }
    
    public void setSeatsBooked(Show show,String seats[]){
        for(String seat: seats){
            int row=getSeatRow(seat);
            int column= getSeatColumn(seat);
            show.setSeat(false, row, column);
        }
    }
}
