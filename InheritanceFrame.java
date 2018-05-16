
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Super classen til ChairmanFrame, CoachFrame & TreasurerFrame.
public  class InheritanceFrame extends JFrame implements ActionListener
{
   protected JPanel contentPane;
   protected JButton newMemberButton;
   protected JButton showDebtorButton;
   protected JButton enterTimeButton;
   protected JButton showMembersButton;
   protected JButton showFullMembersButton;
   protected JButton showTopButton;
   protected JButton logOutButton;
   protected JLabel lblNewLabel;
   
   public static void main(String[] args) 
   {
      new InheritanceFrame();
   }  

   public InheritanceFrame() 
   {
		setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
		setResizable(false);
		
		logOutButton = new JButton("Log ud");
      logOutButton.addActionListener(this);
		
		lblNewLabel = new JLabel("Formand/Kasserer/Træner");
		lblNewLabel.setBounds(10, 11, 210, 14);

		newMemberButton = new JButton("Opret medlem");
      newMemberButton.addActionListener(this);
      
      showDebtorButton = new JButton("Vis skyldnere");	
      showDebtorButton.addActionListener(this);	
      
		enterTimeButton = new JButton("Indtast tid");
      enterTimeButton.addActionListener(this);
      
		showMembersButton = new JButton("Vis medlemmer");
      showMembersButton.addActionListener(this);
      
      showFullMembersButton = new JButton("Vis medlemmer");
      showFullMembersButton.addActionListener(this);
      
		showTopButton = new JButton("Vis top 5");
      showTopButton.addActionListener(this);

		setVisible(true);
	}
      public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == logOutButton)
      {
         dispose();
         new LoginFrame();
      }
      else if(event.getSource() == newMemberButton)
      {
         dispose();
         new MemberTypeFrame();
      }
      else if(event.getSource() == showMembersButton)
      {
         new ShowMembersFrame();
      }
      else if(event.getSource() == showTopButton)
      {
         new DisciplineTypeFrame();
      }
      else if(event.getSource() == enterTimeButton)
      {
         new AddTimeFrame();
      }
      else if(event.getSource() == showFullMembersButton)
      {
         new ShowFullMembersFrame();
      }
   } 
}
