
public class Login 
{  
   //Dette er vores 3 mulige logins.
   public static boolean authenticate(String username, String password) 
   {
      if(username.equals("formand") && password.equals("formand")) 
      {
         return true;
      }
      return false;
   }
   public static boolean authenticate2(String username, String password) 
   {
      if(username.equals("kasserer") && password.equals("kasserer")) 
      {
         return true;
      }
      return false;
   }
   public static boolean authenticate3(String username, String password) 
   {
      if(username.equals("traener") && password.equals("traener")) 
      {
         return true;
      }
      return false;
   }
}




