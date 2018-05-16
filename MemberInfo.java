
import java.util.*;
import java.io.Serializable;

public class MemberInfo implements Serializable
{
   private static final long serialVersionUID = 1L;
   private String firstName;
   private String lastName;
   private int year;
   private Gender gender; // Enum
   private String address;
   private String cprNumber; 
   private String status;
   private String eliteStatus;
   private ArrayList<Times> times;
   //Member id attributter
   public int id;
   
   //Kønstruktør for aktiv medlem
   public MemberInfo(String firstName, String lastName, String cprNumber, int year, Gender gender, String address, String status, String eliteStatus)   
   {
      //ID delen
      id = Members.memberList.size() + 1;
      //Member delen
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.year = year;
      this.cprNumber = cprNumber;
      this.address = address;
      this.status = status;
      this.eliteStatus = eliteStatus;
      times = new ArrayList<Times>();
    }
    
    public MemberInfo()
    {
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.year = year;
      this.cprNumber = cprNumber;
      this.address = address;
    }
    
    public String getFirstName()
    {
       return firstName;
    }
    
    public String getLastName()
    {
       return lastName;  
    }
    
    public String getGender()
    {
      if(gender.equals(Gender.MALE))
      {
         return "Mand";
      }
      else if(gender.equals(Gender.FEMALE))
      {
         return "Kvinde";
      }
      return null;
    }
    
    public int getYear()
    {
       return year;
    }

    public String getAddress()
    {
       return address; 
    }
   
    public int getId()
    {
       return id; 
    }
    
    public String getCprNumber()
    {
      return cprNumber;
    }
      
    public String getStatus()
    {
      return status;  
    }
    public String getEliteStatus()
    {
      return eliteStatus;       
    }
    public ArrayList<Times> getTimes()
    {
      return times;
    }
    
    public void addTime(Times t)
    {
      times.add(t);
    }
    
    public static void addTimeByMember(int id, Times t)
    {
       Members m = new Members();
       MemberInfo member = m.findMemberById(id);
       member.addTime(t);
    }
    
    public void setFirstName(String firstName)
    {
      this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
      this.lastName = lastName;
    }
    
    public void setYear(int year)
    {
      this.year = year;
    }
     
    public void setAddress(String address)
    {
      this.address = address;
    }
    
    public void setCprNumber(String cprNumber)
    {
      cprNumber = cprNumber;
    }

    public void setId(int id)
    {
      id = id;
    }
    
    public void setStatus (String status)
    {
      this.status = status;
    }
    
    public void setEliteStatus(String eliteStatus)
    {
      this.eliteStatus = eliteStatus;
    }
}



   
   
   



            
       