
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
   
   //Finder top 5 for m�nd
   public ArrayList<Statistics> getTopFiveMen(String discipline, int distance)
   {
      ArrayList<Statistics> topFive = new ArrayList<Statistics>(); //Listen vi returnerer til sidst
      ArrayList<Statistics> allTimes = new ArrayList<Statistics>(); //Listen vi gemmer alle tider i
      ArrayList<MemberInfo> allMen = new ArrayList<MemberInfo>(); //Listen vi gemmer alle m�nd i
      
      for(MemberInfo m : Members.memberList) //Gennemg�r listen af medlemmer
      {
         if(m.getGender().equals("Mand")) //Finder alle m�nd
         {
            allMen.add(m); //Tlf�jer m�nd til allMen
         }
      }
      
      for(MemberInfo m2 : allMen) //Gennemg�r listen af m�nd
      {
         name = m2.getFirstName() + " " + m2.getLastName(); //Sammens�tter firstName og lastName til 1 string "name"
         
         for(Times t : m2.getTimes()) //Gennemg�r hver mands liste af tider
         {
            if(t.getDiscipline().equals(discipline) && t.getDistance() == distance) //Finder tider for den �nskede disciplin og distance
            {
               double newTime = t.getTime();
               Statistics stats = new Statistics(newTime, name);
               allTimes.add(stats); //Tilf�jer tiderne til allTimes
            }
         } 
      }
      
      try
      {
         for(int i = 0; i <= 4; i++) //G�r f�lgende 5 gange (hence; top5)
         {
            double smallest = 9999; //Opretter lokal attribut "smallest", der bruges til at sammenligne tider
            String name1 = null; //Opretter lokal attribut "name1", der bruges til at tilknytte en tid til en mand
            int index = 0; //Bruges til at finde objektet i listen
         
            for(Statistics s : allTimes) //Gennemg�r allTimes
            {
               if(s.getTimes() <= smallest) //Sammenligner "smallest" med getTimes()
               {
                  smallest = s.getTimes(); //S�tter "smallest" til den nye (mindre) v�rdi
                  name1 = s.getName();
                  index = allTimes.indexOf(s); 
               }  
            }
            Statistics temp = new Statistics(smallest, name1);
            topFive.add(temp); //Tilf�jer den hurtigste tid til topFive
            allTimes.remove(index); //Fjerner den hurtigste tid fra allTimes, s� vi n�ste gang finder den n�sthurtigste tid
         }
      }
      catch(IndexOutOfBoundsException e)
      {
         JOptionPane.showMessageDialog(null, "Ikke nok tider til at vise en fuld top 5");
      }
      return topFive;
   }
   
   //Top5 for kvinder, fungerer p� samme m�de som m�nd, eneste forskel er den finder kvinder
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
         for(int i = 0; i <= 4; i++) //G�r f�lgende 5 gange (hence; top5)
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