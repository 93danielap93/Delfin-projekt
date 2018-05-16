

public class Chairman
{
   private MemberInfo chairman;//objekt af MemberInfo der er sat som formand
     
   public void setChairman(MemberInfo t)
   {
      t = currentTreasurer;
   }
     
   public MemberInfo getChairman()
   {
      return chairman;
   }
        
}