
import java.util.Date;
import java.util.*;
import java.io.Serializable;

public class Members implements Serializable
{
   private static final long serialVersionUID = 1L;
   private MemberInfo info = new MemberInfo();
   private int id = info.getId();
   public static ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();   
   //Opretter medlemmer.
   public void addMember(String firstName, String lastName, String cprNumber, int age, Gender gender, String address, String status, String eliteStatus)
   {
      MemberInfo list = new MemberInfo(firstName, lastName, cprNumber, age, gender, address, status, eliteStatus);
      memberList.add(list);
   }
   //Finder specifikke medlemmer vha. id.
   public static MemberInfo findMemberById(int id)
   {
      for(MemberInfo m : memberList)
      {
         {  
            if(id == m.getId())
            return m;
         }
      }
      return null;
   }
   public static void removeMember(int id)
   {
      removeMember(findMemberById(id));
   } 
   public static void removeMember(MemberInfo m)
   {
      memberList.remove(m);
   }   
   public int getId(MemberInfo m)
   {
      return m.getId();
   }
   public int getNewId()
   {
      return this.id;
   }
   public static ArrayList<MemberInfo> getMembers()
   {
      return memberList;
   }
   public String getFirstName(MemberInfo m)
   {
      return m.getFirstName();
   }
   public String getLastName(MemberInfo m)
   {
      return m.getLastName();
   }
   public int getYear(MemberInfo m)
   {
      return m.getYear();
   }
   public String getAddress(MemberInfo m)
   {
      return m.getAddress();
   }
   public String getCprNumber(MemberInfo m)
   {
      return m.getCprNumber();
   }
   public String getGender(MemberInfo m)
   {
      return m.getGender();
   }
   public ArrayList<Times> getTimes(MemberInfo m)
   {
      return m.getTimes();
   }
   public String getStatus(MemberInfo m)
   {
      return m.getStatus();
   }
   public String getEliteStatus(MemberInfo m)
   {
      return m.getEliteStatus();
   }

   public static int getMemberCount()
   {
      return memberList.size();
   }   
 
   public MemberInfo searchid(int id)
   {
      for(MemberInfo m : memberList)
      {
         if(id == (m.getId()))
         {
            return m;
         }
      }
      return null;
   }     
   
   public MemberInfo searchFirstName(String firstName)
   {
      for(MemberInfo m: memberList)
      {
         if(firstName.equalsIgnoreCase(m.getFirstName()))
         {
            return m;
         }
      }
      return null;
   }
   
   public MemberInfo searchLastName(String lastName)
   {
      for(MemberInfo m: memberList)
      {
         if(lastName.equalsIgnoreCase(m.getLastName()))
         {
            return m;
         }
      }
      return null;
   }
   
   public MemberInfo freeSearch(String randomSearchParameter)
   {
      randomSearchParameter.toLowerCase();
      for(MemberInfo m: memberList)
      {
         if(randomSearchParameter.contains(m.getFirstName()))
         {
            return m;
         }
         else if(randomSearchParameter.contains(m.getLastName()))
         {  
            return m;
         }
      }
      return null;
   }
}