
import java.util.*;

public class Coach
{  
   private ArrayList<MemberInfo> coaches = new ArrayList<MemberInfo>();//arrayliste der kan indeholde tr�nere (objekter af MemberInfo)
   
   //Tilf�jer objekt af memberinfo som tr�ner
   public void addCoach(MemberInfo c)
   {
      coaches.add(c);
   }
   //fjerner en tr�ner fra listen
   public void removeCoach(Memberinfo c)
   {
      coaches.remove(c);
   }
   //Returnerer hele listen med tr�nere
   public ArrayList getCoaches()
   {
      return coaches;
   }
}