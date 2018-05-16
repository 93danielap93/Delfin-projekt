
//Sub klasse og arver fra InheritanceFrame.
public class TreasurerFrame extends InheritanceFrame 
{ 
	public TreasurerFrame() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      lblNewLabel.setText("'Logget ind som Kasserer'");
      add(lblNewLabel);
      
      showDebtorButton.setBounds(10, 61, 144, 23);
		add(showDebtorButton);
      
      showMembersButton.setBounds(10, 88, 144, 23);
		add(showMembersButton);
      
      showTopButton.setBounds(10, 114, 144, 23);
		add(showTopButton);
            
      logOutButton.setBounds(212, 211, 123, 63);
		add(logOutButton);
	}

}
