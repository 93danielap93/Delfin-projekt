
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Persistence 
{

	//Change path and filename according to your machine.
	//private static String filePath = "C:\\Users\\Desktop\\Desktop\\";
   private static final long serialVersionUID = 1L;
	private static String fileName = "Members.ser";
	
	public static void save(ArrayList<MemberInfo> m)
	{
		ObjectOutputStream out = null;
		FileOutputStream fileOut = null;
		
		File yourFile = new File(fileName);
		try 
      {
			yourFile.createNewFile(); //create file if it doesn't exist
		
			fileOut = new FileOutputStream(fileName, false);
			out = new ObjectOutputStream(fileOut);
			
			out.writeObject(m); //write to file
			
		} 
      catch (IOException e) 
      {
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
				fileOut.close();
	       } 
          catch (IOException e) 
            {
				   e.printStackTrace();
			   }
		}
	}

	public static ArrayList<MemberInfo> load() 
   {
		
		ArrayList<MemberInfo> m = new ArrayList<MemberInfo>();
      File yourFile = new File(fileName);
      
	    try
	    {
	       FileInputStream fileIn = new FileInputStream(fileName);
	       ObjectInputStream in = new ObjectInputStream(fileIn);
	       
	       try 
          {
    		      m = (ArrayList<MemberInfo>)in.readObject(); //cast object read from file to MovieDatabase
	       }
    	    catch(Exception e)
    	    {
    		   e.printStackTrace();
    	    }

	       in.close();
	       fileIn.close();
	    }
	    catch(IOException i)
	    {
	    	try
         {
            yourFile.createNewFile();
         }
         catch(Exception e)
          {
    		   e.printStackTrace();
    	    }
	    }
		
		return m;
	}
	
}
