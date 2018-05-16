
//Sub klasse til InheritanceFrame og arver derfra.
public class CoachFrame extends InheritanceFrame
{

   public static void main(String[] args)
   {
      new CoachFrame();
   }

   public CoachFrame()
   {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      lblNewLabel.setText("'Logget ind som Træner'");
      add(lblNewLabel);
      
      enterTimeButton.setBounds(10, 61, 144, 23);
		add(enterTimeButton);
      
      showMembersButton.setBounds(10, 88, 144, 23);
		add(showMembersButton);
      
      showTopButton.setBounds(10, 114, 144, 23);
		add(showTopButton);
      
      logOutButton.setBounds(212, 211, 123, 63);
		add(logOutButton);
	}
}
