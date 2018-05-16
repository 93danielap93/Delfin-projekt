
import java.util.*;
import javax.swing.JOptionPane;

public class Statistics
{
   private double time;
   private String name;
   public ArrayList<Statistics> men = new ArrayList<Statistics>();
   public ArrayList<Statistics> women = new ArrayList<Statistics>();
   
   public Statistics(double time, String name)
   {
      this.time = time;
      this.name = name;
   }
   
   public Statistics()
   {}
   
   public double getTimes()
   {
      return time;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void addStatMen(Statistics s)
   {
      men.add(s);
   }
   
   //Finder top 5 for mænd
   public ArrayList<Statistics> getTopFiveMen(String discipline, int distance)
   {
      ArrayList<Statistics> topFive = new ArrayList<Statistics>(); //Listen vi returnerer til sidst
      ArrayList<Statistics> allTimes = new ArrayList<Statistics>(); //Listen vi gemmer alle tider i
      ArrayList<MemberInfo> allMen = new ArrayList<MemberInfo>(); //Listen vi gemmer alle mænd i
      
      for(MemberInfo m : Members.memberList) //Gennemgår listen af medlemmer
      {
         if(m.getGender().equals("Mand")) //Finder alle mænd
         {
            allMen.add(m); //Tlføjer mænd til allMen
         }
      }
      
      for(MemberInfo m2 : allMen) //Gennemgår listen af mænd
      {
         name = m2.getFirstName() + " " + m2.getLastName(); //Sammensætter firstName og lastName til 1 string "name"
         
         for(Times t : m2.getTimes()) //Gennemgår hver mands liste af tider
         {
            if(t.getDiscipline().equals(discipline) && t.getDistance() == distance) //Finder tider for den ønskede disciplin og distance
            {
               double newTime = t.getTime();
               Statistics stats = new Statistics(newTime, name);
               allTimes.add(stats); //Tilføjer tiderne til allTimes
            }
         } 
      }
      
      try
      {
         for(int i = 0; i <= 4; i++) //Gør følgende 5 gange (hence; top5)
         {
            double smallest = 9999; //Opretter lokal attribut "smallest", der bruges til at sammenligne tider
            String name1 = null; //Opretter lokal attribut "name1", der bruges til at tilknytte en tid til en mand
            int index = 0; //Bruges til at finde objektet i listen
         
            for(Statistics s : allTimes) //Gennemgår allTimes
            {
               if(s.getTimes() <= smallest) //Sammenligner "smallest" med getTimes()
               {
                  smallest = s.getTimes(); //Sætter "smallest" til den nye (mindre) værdi
                  name1 = s.getName();
                  index = allTimes.indexOf(s); 
               }  
            }
            Statistics temp = new Statistics(smallest, name1);
            topFive.add(temp); //Tilføjer den hurtigste tid til topFive
            allTimes.remove(index); //Fjerner den hurtigste tid fra allTimes, så vi næste gang finder den næsthurtigste tid
         }
      }
      catch(IndexOutOfBoundsException e)
      {
         JOptionPane.showMessageDialog(null, "Ikke nok tider til at vise en fuld top 5");
      }
      return topFive;
   }
   
   //Top5 for kvinder, fungerer på samme måde som mænd, eneste forskel er den finder kvinder
   public ArrayList<Statistics> getTopFiveWomen(String discipline, int distance)
   {
      ArrayList<Statistics> topFive = new ArrayList<Statistics>();
      ArrayList<Statistics> allTimes = new ArrayList<Statistics>();
      ArrayList<MemberInfo> allWomen = new ArrayList<MemberInfo>();
      
      for(MemberInfo m : Members.memberList)
      {
         if(m.getGender().equals("Kvinde")) //Her
         {
            allWomen.add(m);
         }
      }
      
      for(MemberInfo m2 : allWomen)
      {
         name = m2.getFirstName() + " " + m2.getLastName();
         
         for(Times t : m2.getTimes())
         {
            if(t.getDiscipline().equals(discipline) && t.getDistance() == distance)
            {
               double newTime = t.getTime();
               Statistics stats = new Statistics(newTime, name);
               allTimes.add(stats);
            }
         } 
      }
      
      try
      {
         for(int i = 0; i <= 4; i++) //Gør følgende 5 gange (hence; top5)
         {
            double smallest = 9999; //Opretter lokal attribut "smallest", der bruges til at sammenligne tider
            String name1 = null; //Opretter lokal attribut "name1", der bruges til at tilknytte en tid til en kvinde
            int index = 0;
         
            for(Statistics s : allTimes)
            {
               if(s.getTimes() <= smallest)
               {
                  smallest = s.getTimes();
                  name1 = s.getName();
                  index = allTimes.indexOf(s);
               }  
            }
            Statistics temp = new Statistics(smallest, name1);
            topFive.add(temp);
            allTimes.remove(index);
         }
      }
      catch(IndexOutOfBoundsException e)
      {
         JOptionPane.showMessageDialog(null, "Ikke nok tider til at vise en fuld top 5");
      }
      return topFive;
   }
}