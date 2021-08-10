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
public class User {
    private long userID;
    private String name;
    private String mailID;
    private long mobileNo;
    private String password;
    private Address address;
    private Location location;
    private static long refNo=1000;
    
    public User(UserBuilder builder){
        this.name=builder.name;
        this.mailID=builder.mailID;
        this.mobileNo=builder.mobileNo;
        this.password=builder.password;
        this.address=builder.address;
        this.location=builder.location;
        this.userID=++refNo;
    }
    
    //setters
    public void setName(String name){
        this.name=name;
    }
    
    public void setMailID(String mailID){
        this.mailID=mailID;
    }
    
    public void setMobileNo(long mobileNo){
        this.mobileNo=mobileNo;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public void setAddress(Address address){
        this.address=address;
    }
    
    public void setLocation(Location location){
        this.location=location;
    }
    
    //getters
    public String getName(){
        return name;
    }
    
    public String getMailID(){
        return mailID;
    }
    
    public long getMobileNo(){
        return mobileNo;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public Location getLocation(){
        return location;
    }
    
    public long getUserID(){
        return userID;
    }
    
    public static class UserBuilder{
        private String name;
        private String mailID;
        private long mobileNo;
        private String password;
        private Address address;
        private Location location;
        
        public UserBuilder name(String name){
            this.name=name;
            return this;
        }

        public UserBuilder mailID(String mailID){
            this.mailID=mailID;
            return this;
        }

        public UserBuilder mobileNo(long mobileNo){
            this.mobileNo=mobileNo;
            return this;
        }

        public UserBuilder password(String password){
            this.password=password;
            return this;
        }

        public UserBuilder address(Address address){
            this.address=address;
            return this;
        }

        public UserBuilder location(Location location){
            this.location=location;
            return this;
        }
        
        public User build(){
            User user = new User(this);
            return user;
        }
    }
}
