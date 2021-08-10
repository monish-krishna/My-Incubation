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
public class Wallet {
    private static long refNo=1000;
    private final long walletID;
    private float balance;
    private final long userID;
    
    public Wallet(long userID){
        this.walletID=++refNo;
        this.balance=0;
        this.userID=userID;
    }
    
    public void addBalance(float amount){
        this.balance+=amount;
    }
    
    public void deductBalance(float amount){
        this.balance-=amount;
    }
    
    public long getWalletID(){
        return walletID;
    }
    
    public float getBalance(){
        return balance;
    }
    
    public long getUserID(){
        return userID;
    }
}
