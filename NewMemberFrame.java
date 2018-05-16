
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class NewMemberFrame extends JFrame implements ActionListener 
{
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField cprField;
	private JTextField ageField;
	private JTextField addressField;
   private JButton addMemberButton;
   private JButton backButton;
   private JComboBox eliteComboBox = new JComboBox();
   private JComboBox genderComboBox = new JComboBox();
   private int systemYear = Calendar.getInstance().get(Calendar.YEAR);
   private int year;
   
	public static void main(String[] args)
   {
      new NewMemberFrame();
   }
   
	public NewMemberFrame() {
		setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblFornavn = new JLabel("Fornavn:");
		lblFornavn.setBounds(10, 57, 71, 26);
		contentPane.add(lblFornavn);
		
		JLabel lblEfternavn = new JLabel("Efternavn:");
		lblEfternavn.setBounds(10, 106, 71, 26);
		contentPane.add(lblEfternavn);
		
		JLabel lblCprNr = new JLabel("Cpr nr:");
		lblCprNr.setBounds(10, 157, 71, 26);
		contentPane.add(lblCprNr);
		
		JLabel lblKn = new JLabel("Køn:");
		lblKn.setBounds(10, 261, 71, 26);
		contentPane.add(lblKn);
		
		JLabel lblAlder = new JLabel("Fødselsår:");
		lblAlder.setBounds(10, 213, 71, 26);
		contentPane.add(lblAlder);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(10, 314, 71, 26);
		contentPane.add(lblAdresse);
		
		JLabel lblEliteSvmmer = new JLabel("Type:");
		lblEliteSvmmer.setBounds(10, 364, 71, 26);
		contentPane.add(lblEliteSvmmer);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(91, 56, 313, 29);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(91, 105, 313, 29);
		contentPane.add(lastNameField);
		
		cprField = new JTextField();
		cprField.setColumns(10);
		cprField.setBounds(91, 156, 313, 29);
		contentPane.add(cprField);
      //Tillader kun int.
      cprField.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)
            {
               evt.consume();
            }
			}
		});
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(91, 212, 313, 29);
		contentPane.add(ageField);
      //Tillader kun int.
      ageField.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)
            {
               evt.consume();
            }
			}
		});
		
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mand", "Kvinde"}));
		genderComboBox.setMaximumRowCount(2);
		genderComboBox.setBounds(91, 260, 313, 29);
		contentPane.add(genderComboBox);
      
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(91, 313, 313, 29);
		contentPane.add(addressField);
		
		eliteComboBox.setModel(new DefaultComboBoxModel(new String[] {"Motionssvømmer", "Elitesvømmer"}));
		eliteComboBox.setBounds(91, 363, 313, 29);
		contentPane.add(eliteComboBox);
		
		backButton = new JButton("Tilbage");
		backButton.setBounds(362, 512, 89, 23);
		contentPane.add(backButton);
      backButton.addActionListener(this);
		
		addMemberButton = new JButton("Tilføj");
		addMemberButton.setBounds(263, 512, 89, 23);
		contentPane.add(addMemberButton);
      addMemberButton.addActionListener(this);
      
		setVisible(true);
	}
   
   public void updateMemberList()
   {  
      Gender gender = Gender.MALE;
      
      if(genderComboBox.getSelectedIndex() == 0)
      {
         gender = Gender.MALE;
      }
      else if(genderComboBox.getSelectedIndex() == 1)
      {
         gender = Gender.FEMALE;
      }
           
      String readYear = ageField.getText();
      int year = Integer.parseInt(readYear);
      
      String status = null;
      if((systemYear - year) < 18)
      {
         status = "Junior";
      }
      else if((systemYear - year) >= 18)
      {
         status = "Senior";
      }
      
      String elite = null;
      if(eliteComboBox.getSelectedItem().equals("Elitesvømmer"))
      {
         elite = "Elitesvømmer";
      }
      else if(eliteComboBox.getSelectedItem().equals("Motionssvømmer"))
      {
         elite = "Motionssvømmer";
      }
      
      Members members = new Members();
      members.addMember(firstNameField.getText(), lastNameField.getText(), cprField.getText(), year, gender, addressField.getText(), status, elite);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == backButton)
      {
         dispose();
         new ChairmanFrame();
      }
      else if(event.getSource() == addMemberButton)
      {
         try
         { 
            updateMemberList();
            ShowMembersFrame.updateMemberTable();
            JOptionPane.showMessageDialog(contentPane, "Medlem tilføjet!");
            dispose();
            new ChairmanFrame();
         }
         
         catch (Exception e) 
         {
            JOptionPane.showMessageDialog(contentPane, "Alle felter skal udfyldes!");
         }      
      }
   }
}
