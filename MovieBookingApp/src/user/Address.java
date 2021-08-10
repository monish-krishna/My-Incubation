/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Monish Krishna Selva
 */
public class Address {
    private String doorNo;
    private String area;
    private String district;
    private String state;
    private int pincode;
    
    //setters
    public void setDoorNo(String doorNo){
        this.doorNo=doorNo;
    }
    
    public void setAddressLine1(String area){
        this.area=area;
    }
    
    public void setDistrict(String district){
        this.district=district;
    }
    
    public void setState(String state){
        this.state=state;
    }
    
    public void setPincode(int pincode){
        this.pincode=pincode;
    }
    
    //getters
    public String getDoorNo(){
        return doorNo;
    }
    
    public String getArea(){
        return area;
    }
    
    public String getDistrict(){
        return district;
    }
    
    public String getState(){
        return state;
    }
    
    public int getPincode(){
        return pincode;
    }
    
    @Override
    public String toString(){
        String s = String.format("\n   %-8s : %s\n","Door No.",getDoorNo());
        s=s+String.format("   %-8s : %s\n","Area",getArea());
        s=s+String.format("   %-8s : %s\n","District",getDistrict());
        s=s+String.format("   %-8s : %s\n","State",getState());
        s=s+String.format("   %-8s : %s\n","Pincode",getPincode());
        return s;
    }
}
