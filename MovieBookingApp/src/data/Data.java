/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import booking.Booking;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import theatre.Movie;
import theatre.Screen;
import theatre.Show;
import theatre.Theatre;
import user.Location;
import user.User;
import user.Wallet;

/**
 *
 * @author Monish Krishna Selva
 */
public class Data{
    private final HashMap<Long/*UserID*/,User> registeredUsers =new HashMap<>();
    private final HashMap<String,Long/*UserID*/> userIDs=new HashMap<>();
    private final HashMap<Long/*UserID*/,Wallet> wallets = new HashMap<>();
    private final HashMap<Long/*UserID*/,ArrayList<Booking>> allBookings = new HashMap<>();
    public final HashMap<Long/*ScreenID*/,HashMap<LocalDate,ArrayList<Show>>> allShows = new HashMap<>();
    public final HashMap<Long/*TheatreID*/,Theatre> allTheatres = new HashMap<>();
    public final HashMap<Long/*ScreenID*/,Screen> allScreens = new HashMap<>();
    public final HashMap<Location,ArrayList<Long/*TheatreID*/>> theatres = new HashMap<>();
    public final HashMap<Location,ArrayList<Long/*ScreenID*/>> screens = new HashMap<>();
    public final HashMap<Long,Movie> allMovies=new HashMap<>();
    private static Data regUsers;
    
    private Data(){}
    
    public static Data getInstance(){
        if(regUsers==null)
            regUsers=new Data();
        return regUsers;
    }
    
    public void addUser(User user){
        registeredUsers.put(user.getUserID(), user);
        userIDs.put(user.getMailID(),user.getUserID());
    }
    
    public void addWallet(Wallet wallet){
        wallets.put(wallet.getUserID(), wallet);
    }
    
    public void addBooking(Long userID,Booking booking){
        if(allBookings.containsKey(userID)){
            allBookings.get(userID).add(booking);
        }else{
            ArrayList<Booking> bookings = new ArrayList<>();
            bookings.add(booking);
            allBookings.put(userID, bookings);
        }
    }
    
    public ArrayList<Booking> getBookings(long userID){
        return allBookings.get(userID);
    }
    
    public User removeUser(long userID){
        return registeredUsers.remove(userID);
    }
    
    public boolean isUserRegistered(long userID){
        return registeredUsers.containsKey(userID);
    }
    
    public boolean isUserRegistered(String mailID){
        long userID=(userIDs.get(mailID)==null)?(0):(userIDs.get(mailID));
        return registeredUsers.containsKey(userID);
    }
    
    public User getRegUser(long userID){
        return registeredUsers.get(userID);
    }
    
    public User getRegUser(String mailID){
        long userID=userIDs.get(mailID);
        return registeredUsers.get(userID);
    }
    
    public Wallet getWallet(String mailID){
        long userID=userIDs.get(mailID);
        return wallets.get(userID);
    }
    
    public boolean containsWallet(Wallet wallet){
        return wallets.containsKey(wallet.getUserID());
    }
    
    //For theatres & Screens
    public void addTheatre(Theatre theatre){
        long theatreID = theatre.getTheatreID();
        allTheatres.put(theatreID, theatre);
        if(theatres.containsKey(theatre.getLocation())){
            theatres.get(theatre.getLocation()).add(theatreID);
        }else{
            ArrayList<Long> theatreIDs = new ArrayList<>();
            theatreIDs.add(theatreID);
            theatres.put(theatre.getLocation(), theatreIDs);
        }
    }
    
    public Theatre getTheatre(Long theatreID){
        return allTheatres.get(theatreID);
    }
    
    public ArrayList<Long> getTheatreIDs(Location location){
        return theatres.get(location);
    }
    
    public void addScreen(Screen screen,Theatre theatre){
        theatre.addScreen(screen);
        screen.setTheatreID(theatre.getTheatreID());
        long screenID = screen.getScreenID();
        allScreens.put(screenID, screen);
        if(screens.containsKey(theatre.getLocation())){
            screens.get(theatre.getLocation()).add(screenID);
        }else{
            ArrayList<Long> screenIDs = new ArrayList<>();
            screens.put(theatre.getLocation(), screenIDs);
            screenIDs.add(screenID);
        }
    }
    
    public Screen getScreen(long screenID){
        return allScreens.get(screenID);
    }
    
    public ArrayList<Long> getScreenIDs(Location location){
        return screens.get(location);
    }
       
    public ArrayList<Theatre> getAvailableTheatres(Location location){
        ArrayList<Long> theatreIDs=getTheatreIDs(location);
        ArrayList<Theatre> theatres =new ArrayList<>();
        for(Long theatreID:theatreIDs){
            theatres.add(getTheatre(theatreID));
        }
        return theatres;
    }
    
    public ArrayList<Screen> getAvailableScreens(Location location){
        ArrayList<Long> screenIDs=getTheatreIDs(location);
        ArrayList<Screen> screens =new ArrayList<>();
        for(Long screenID:screenIDs){
            screens.add(getScreen(screenID));
        }
        return screens;
    }
    
    public Movie getMovie(Long movieID){
        return allMovies.get(movieID);
    }
    
    public String getMovieName(Long movieID){
        return getMovie(movieID).getName();
    }
    
    public void addMovie(Movie movie){
        allMovies.put(movie.getMovieID(), movie);
    }
    
    public Show getShow(Screen screen,LocalDate showDate,LocalTime showTime){
        long screenID = screen.getScreenID();
        Show show;
        while(true){
            if(allShows.containsKey(screenID)){
                HashMap<LocalDate, ArrayList<Show>> screenShows = allShows.get(screenID);
                if(screenShows.containsKey(showDate)){
                    ArrayList<Show> shows = screenShows.get(showDate);
                    Iterator<Show> iterator= shows.iterator();
                    boolean checker=true;
                    while(iterator.hasNext()){
                        show =iterator.next();
                        if(show.getScreenID()==screenID && show.getShowTime().equals(showTime)){
                            checker=false;
                            return show;
                        }
                    }
                    if(checker){
                        show=new Show(screen,showTime);
                        shows.add(show);
                        return show;
                    }
                }else{
                    screenShows.put(showDate, new ArrayList<>());
                }
            }else{
                allShows.put(screenID, new HashMap<>());
            }
        }
    }
}
