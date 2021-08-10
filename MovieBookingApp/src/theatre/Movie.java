
package theatre;

import java.util.ArrayList;


public class Movie {
   private String name;
   private long movieID;
   private String cast[];
   private String description;
   private float rating;
   private ArrayList<String> reviews;
   private static long refNo=1000;
   
   public void setName(String name){
       this.name=name;
       this.rating=0.0F;
       this.reviews=new ArrayList<>();
       this.movieID=++refNo;
   }
   
   public void setCast(String ... cast){
       this.cast=cast;
   }
   
   public void setDescription(String description){
       this.description=description;
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
   
   public String[] getCast(){
       return cast;
   }
   
   public String getDescription(){
       return description;
   }
   
   public float getRating(){
       return rating;
   }
   
   public ArrayList<String> getReview(){
       return reviews;
   }
   
   public long getMovieID(){
       return movieID;
   }
}
