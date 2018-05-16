
import java.util.*;

public class Times
{
   private String discipline;
   private int distance;
   private double time;
   private String date;
   
   public Times(String discipline, int distance, double time, String date)
   {
      this.discipline = discipline;
      this.distance = distance;
      this.time = time;
      this.date = date;
   }
   
   public String getDiscipline(){
      return discipline;
   }
   
   public int getDistance(){
      return distance;
   }
   
   public double getTime(){
      return time;
   }
   
   public String getDate(){
      return date;
   }
   
   public void setDiscipline(String discipline){
      this.discipline = discipline;
   }
   
   public void setDistance(int distance){
      this.distance = distance;
   }
   
   public void setTime(double time){
      this.time = time;
   }
   
   public void setDate(String date){
      this.date = date;
   }
}