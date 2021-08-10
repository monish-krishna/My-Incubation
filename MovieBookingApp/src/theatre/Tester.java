/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre;

import booking.BookingController;
import data.Data;
import helper.Helper;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import user.Address;
import user.Location;
import user.User;
import user.Wallet;

/**
 *
 * @author Monish Krishna Selva
 */
public class Tester {

    /**
     */
    public void run() {
        Screen screen=new Screen(1,3);
        screen.setName("Ajantha");
        screen.setSeatPrice(120);
        Screen screen1=new Screen(1,3);
        screen1.setName("Ellora");
        screen1.setSeatPrice(120);
        Screen screen3 = new Screen(1,5);
        screen3.setName("Kavithalaya");
        screen3.setSeatPrice(120);
        Screen screen4 = new Screen(1,5);
        screen4.setName("Amutha");
        screen4.setSeatPrice(120);
        Screen screen5 = new Screen(1,5);
        screen5.setName("PonAmutha");
        screen5.setSeatPrice(120);
        Screen screen6 = new Screen(1,5);
        screen6.setName("Kalaiyarangam");
        screen6.setSeatPrice(120);
        Screen screen7 = new Screen(5,5);
        screen7.setName("Arangam - DELUXE");
        screen7.setSeatPrice(200);
        
        Movie movie = new Movie();
        movie.setName("Sulthan");
        String des1 = "Vikram a.k.a. Sulthan is a motherless child is raised by a group of hardened criminals who work for his father"
                + " Sethupathi. He loves these 100 men as brothers but despises their taste for violence. "
                + "Following Sethupathi's death, the responsibility to take care of these men falls on Sulthan's shoulders. "
                + "That is when he decides to transform the men and teach them to live as civilized people. It is a Herculean "
                + "task, but the loyalty and the love that these men have towards Sulthan gives him a fighting chance.";
        movie.setDescription(des1);
        String cast[] = {"Karthi as Vikram a.k.a. Sulthan",
            "Rashmika Mandanna as Rukmani \"Rukku\"",
            "Napoleon as Sethupathi, Vikram's father"};
        movie.setCast(cast);
        movie.addRating(4);
        movie.addRating(5);
        
        Movie movie1 = new Movie();
        movie1.setName("Karnan");
        des1 = "Karnan, a fearless youth, fights against police brutality and oppression in his village.";
        movie1.setDescription(des1);
        String cast1[] = {"Dhanush as Karnan",
            "Rajisha Vijayan as Draupathai",
            "Lal as Yema Raja (Thatha)"};
        movie1.setCast(cast1);
        movie1.addRating(5);
        
        Movie movie2 = new Movie();
        movie2.setName("Soorarai Pottru");
        des1 = "Maara, a young man from a remote village, dreams of launching his own airline service. However, he must overcome "
                + "several obstacles and challenges in order to be successful in his quest.";
        movie2.setDescription(des1);
        String cast2[] = {"Suriya as Nedumaaran Rajangam (Maara)",
            "Mohan Babu as M. Bhaktavatsalam Naidu",
            "Paresh Rawal as Paresh Goswami",
            "Aparna Balamurali as Sundari \"Bommi\" Nedumaaran"};
        movie2.setCast(cast2);
        movie2.addReview("Good movie.");
        
        screen.setMovieID(movie.getMovieID());
        screen1.setMovieID(movie1.getMovieID());
        screen7.setMovieID(movie.getMovieID());
        screen3.setMovieID(movie1.getMovieID());
        screen4.setMovieID(movie.getMovieID());
        screen5.setMovieID(movie2.getMovieID());
        screen6.setMovieID(movie2.getMovieID());
        
        Theatre theatre = new Theatre();
        theatre.setName("AJATHA & ELLORA");
        theatre.setLocation(Location.COIMBATORE);
        Theatre theatre1 = new Theatre();
        theatre1.setName("KALAIYARANGAM");
        theatre1.setLocation(Location.COIMBATORE);
        Theatre theatre2 = new Theatre();
        theatre2.setName("AMUTHA");
        theatre2.setLocation(Location.CHENNAI);
        
        Data data = Data.getInstance();
        data.addMovie(movie);
        data.addMovie(movie1);
        data.addMovie(movie2);
        data.addTheatre(theatre);
        data.addScreen(screen, theatre);
        data.addScreen(screen1, theatre);
        data.addTheatre(theatre1);
        data.addScreen(screen6, theatre1);
        data.addScreen(screen3, theatre1);
        data.addScreen(screen7, theatre1);
        data.addTheatre(theatre2);
        data.addScreen(screen4, theatre2);
        data.addScreen(screen5, theatre2);
        
        String name="Monish Krishna S";
        String mailID="mk@123.com";
        long mobileNo=9486802137L;
        String password="mk123";
        User user;
        user=new User.UserBuilder()
                .name(name)
                .mailID(mailID)
                .mobileNo(mobileNo)
                .password(password)
                .build();
        Data.getInstance().addUser(user);
        Address address = new Address();
        address.setDoorNo("9/108A");
        address.setAddressLine1("PVP Nagar, Manmangalam");
        address.setDistrict("Karur");
        address.setState("Tamilnadu");
        address.setPincode(639006);
        user.setAddress(address);
        user.setLocation(Location.COIMBATORE);
        Wallet wallet = new Wallet(user.getUserID());
        data.addWallet(wallet);
        wallet.addBalance(500);
    }
}
