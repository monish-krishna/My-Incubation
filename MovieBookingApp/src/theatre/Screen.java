/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre;

/**
 *
 * @author Monish Krishna Selva
 */
public class Screen {
    private String name;
    private final long screenID;
    private long movieID;
    private long theatreID;
    private boolean availability;
    private final int seating[];
    private  float seatPrice;
    private static long refNo=1000;
    
    Screen(int seatRows,int seatColumns){
        screenID=++refNo;
        seating = new int[2];
        seating[0]=seatRows;
        seating[1]=seatColumns;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setMovieID(long movieID){
        this.movieID=movieID;
    }
    
    public void setTheatreID(long theatreID){
        this.theatreID=theatreID;
    }
    
    public void setAvailability(boolean availability){
        this.availability=availability;
    }
    
    public void setSeatPrice(float price){
        seatPrice = price;
    }
    
    public String getName(){
        return name;
    }
    
    public long getMovieID(){
        return movieID;
    }
    
    public long getTheatreID(){
        return theatreID;
    }
    
    public long getScreenID(){
        return screenID;
    }
    
    public boolean getAvailability(){
        return availability;
    }
    
    public int[] getSeating(){
        return seating;
    }
    
    public float getSeatPrice(){
        return seatPrice;
    }
}
