
import java.util.*;

public class Coach
{  
   private ArrayList<MemberInfo> coaches = new ArrayList<MemberInfo>();//arrayliste der kan indeholde trænere (objekter af MemberInfo)
   
   //Tilføjer objekt af memberinfo som træner
   public void addCoach(MemberInfo c)
   {
      coaches.add(c);
   }
   //fjerner en træner fra listen
   public void removeCoach(Memberinfo c)
   {
      coaches.remove(c);
   }
   //Returnerer hele listen med trænere
   public ArrayList getCoaches()
   {
      return coaches;
   }
}