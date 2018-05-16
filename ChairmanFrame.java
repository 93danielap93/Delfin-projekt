
import java.awt.event.ActionEvent;

//Sub klasse til InheritanceFrame og arver derfra.
public class ChairmanFrame extends InheritanceFrame 
{ 

   public static void main(String[] args)
   {
      new ChairmanFrame();
   }

	public ChairmanFrame() 
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      lblNewLabel.setText("'Logget ind som Formand'");
      add(lblNewLabel);
      
      newMemberButton.setBounds(10, 61, 144, 23);
		add(newMemberButton);
      
      showFullMembersButton.setBounds(10, 88, 144, 23);
		add(showFullMembersButton);
      
      showTopButton.setBounds(10, 114, 144, 23);
		add(showTopButton);
      
      logOutButton.setBounds(212, 211, 123, 63);
		add(logOutButton);
    
	}
}
