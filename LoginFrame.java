//Login main page
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame implements ActionListener
{
   private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField brugernavnField;
   private JPasswordField passwordField;
   private JButton logInButton;
   private JButton clearButton;
   
   public static void main(String[] args)
   {
      new LoginFrame();
   }

	public LoginFrame() 
   {
      Members.memberList = Persistence.load();
      ShowFullMembersFrame.updateMemberTable();
      
      contentPane = new JPanel();
      setBounds(100, 100, 298, 300);
		setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
      setResizable(false);
      
		JLabel brugernavnLabel = new JLabel("Brugernavn:");
		brugernavnLabel.setBounds(21, 85, 88, 14);
		contentPane.add(brugernavnLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(21, 113, 88, 14);
		contentPane.add(passwordLabel);
		
		brugernavnField = new JTextField();
		brugernavnField.setBounds(96, 82, 160, 20);
		contentPane.add(brugernavnField);
		brugernavnField.setColumns(10);
		
	   passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(96, 110, 160, 20);
		contentPane.add(passwordField);
		
		logInButton = new JButton("Log ind");
		logInButton.setBounds(96, 152, 76, 23);
		contentPane.add(logInButton);
      logInButton.addActionListener(this);
      //Dette gør at login knappen, reagere på enter knappen.
      contentPane.getRootPane().setDefaultButton(logInButton);
		
		clearButton = new JButton("Ryd");
		clearButton.setBounds(180, 152, 76, 23);
		contentPane.add(clearButton);
      clearButton.addActionListener(this);
      
      setVisible(true);
	}
   
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == logInButton)
      {  
         //Opretter lokal variabel og gemmer brugerinput også tjekker via metoderne.
         String username = brugernavnField.getText();
         String password = passwordField.getText();
         if(Login.authenticate(username, password) == true)
         {
            dispose();
            new ChairmanFrame();
         }
         else if(Login.authenticate2(username, password) == true)
         {
            dispose();
            new TreasurerFrame();
         }
         else if(Login.authenticate3(username, password) == true)
         {
            dispose();
            new CoachFrame();
         }
         else JOptionPane.showMessageDialog(contentPane, "Forkert brugernavn eller kode, prøv igen.");
      }
      if(event.getSource() == clearButton)
         {
            brugernavnField.setText("");
            passwordField.setText("");
         }
   }
}
