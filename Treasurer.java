

import java.util.*;

  
public class Treasurer
{  
   private MemberInfo currentTreasurer;//attribut some indeholder det objekt af MemberInfo der er sat som kasserer
     
   public void setTreasurer(MemberInfo t)
   {
      t = currentTreasurer;
   }
     
   public MemberInfo getTreasurer()
   {
      return currentTreasurer;
   }     
   //showdebts metoden kalder listen af skyldnere fra PaymentReg klassens getDebt metode  
   public ArrayList<MemberInfo> showDebts()
   {
      return PaymentReg.getDebt();
   }
}