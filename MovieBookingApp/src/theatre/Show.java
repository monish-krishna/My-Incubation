/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package theatre;

import java.time.LocalTime;

/**
 *
 * @author Monish Krishna Selva
 */
public class Show {
    private final LocalTime showTime;
    private final long screenID;
    private final boolean[][] seats;
    private boolean seatAvailability;
    
    public Show(Screen screen,LocalTime showTime){
        seats=new boolean[screen.getSeating()[0]][screen.getSeating()[1]];
        this.showTime=showTime;
        screenID=screen.getScreenID();
        initiateSeats();
    }
    
    public void initiateSeats(){
        for(int i=0; i<seats.length;i++){
            for(int j=0; j<seats[i].length;j++){
                setSeat(true,i,j);
            }
        }
    }
    
    public void setSeat(boolean availability,int m,int n){
        seats[m][n]=availability;
        setSeatAvailability();
    }
    
    public void setSeatAvailability(){
        boolean checker = true;
        int count=0;
        outer: for(boolean row[]:seats){
            for(boolean seat:row){
                if(seat==true){
                    break outer;
                }else{
                    count++;
                }
            }
        }
        int showSeatCount=seats.length*seats[0].length;
        if(count==showSeatCount){
            checker=false;
        }
        seatAvailability=checker;
    }
    
    public boolean getSeatAvailability(){
        return seatAvailability;
    }
    
    public LocalTime getShowTime(){
        return showTime;
    }
    
    public long getScreenID(){
        return screenID;
    }
    
    public boolean[][] getSeats(){
        return seats;
    }
    
    public boolean getSeatStatus(int row,int column){
        return seats[row][column];
    }
}
