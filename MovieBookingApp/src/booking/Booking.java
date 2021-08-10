/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Monish Krishna Selva
 */
public class Booking {
    private long movieID;
    private long screenID;
    private LocalDate showDate;
    private LocalDate date;
    private LocalTime showTime;
    private String seats[]; //as string
    private final long bookingRefNo;
    private boolean cancelStatus;
    private static long refNo=1000;
    
    public Booking(){
        this.bookingRefNo=++refNo;
        cancelStatus=false;
    }
    
    public void setMovieID(long movieID){
        this.movieID=movieID;
    }
    
    public void setScreenID(long screenID){
        this.screenID=screenID;
    }
    
    public void setDate(LocalDate date){
        this.date=date;
    }
    
    public void setShowDate(LocalDate date){
        this.showDate=date;
    }
    
    public void setShowTime(LocalTime time){
        this.showTime=time;
    }
    
    public void setSeats(String seats[]){
        this.seats=seats;
    }
    
    public void setCancelStatus(boolean cancelStatus){
        this.cancelStatus=cancelStatus;
    }
    
    public long getBookingRefNo(){
        return bookingRefNo;
    }
    
    public long getMovieID(){
        return this.movieID;
    }
    
    public long getScreenID(){
        return this.screenID;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public LocalDate getShowDate(){
        return this.showDate;
    }
    
    public LocalTime getShowTime(){
        return showTime;
    }
    
    public String[] getSeats(){
        return seats;
    }
    
    public boolean getCancelStatus(){
        return cancelStatus;
    }
}
