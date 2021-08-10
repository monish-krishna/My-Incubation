/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre;

import java.util.ArrayList;
import user.Location;

/**
 *
 * @author Monish Krishna Selva
 */
public class Theatre {
    private String name;
    private final long theatreID;
    private Location location;
    private ArrayList<Screen> screens;
    private float rating;
    private ArrayList<String> reviews;
    private static long refNo=1000;
    
    public Theatre(){
        theatreID=++refNo;
        screens=new ArrayList<Screen>();
        reviews = new ArrayList<String>();
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setLocation(Location location){
        this.location=location;
    }
    
    public void addScreen(Screen screen){
        screens.add(screen);
    }
    
    public void removeScreen(Screen screen){
        screens.remove(screen);
    }
    
    public void addRating(float userRating){
        rating=(rating+userRating)/2;
    }
   
    public void addReview(String review){
        this.reviews.add(review);
    }
    
    public String getName(){
        return name;
    }
    
    public long getTheatreID(){
        return theatreID;
    }
    
    public Location getLocation(){
        return location;
    }
    
    public ArrayList<Screen> getScreens(){
        return screens;
    }
    
    public float getRating(){
        return rating;
    }
   
    public ArrayList<String> getReview(){
        return reviews;
    }
}
