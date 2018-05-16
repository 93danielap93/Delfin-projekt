
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddTimeFrame2 extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField timeField;
   private JButton addButton;
   private JButton backButton;
   private JTextField datoField;
   private JComboBox disciplinBox = new JComboBox();
   private JComboBox distanceBox = new JComboBox();
   private MemberInfo memberInfo;
	
	public AddTimeFrame2(MemberInfo m) 
   {  
      memberInfo = m;
      
      setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblTid = new JLabel("Tid:");
		lblTid.setBounds(10, 48, 71, 26);
		contentPane.add(lblTid);
		
		JLabel lblDisciplin = new JLabel("Disciplin:");
		lblDisciplin.setBounds(10, 153, 71, 26);
		contentPane.add(lblDisciplin);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(10, 204, 71, 26);
		contentPane.add(lblDistance);
		
		timeField = new JTextField();
		timeField.setBounds(91, 47, 313, 29);
		contentPane.add(timeField);
		timeField.setColumns(10);
      //Tillader kun int.
      timeField.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent evt) {
            Character c = evt.getKeyChar();
            //Hvis indtastede er forskelligt fra et tal, backspace eller delete, så tillader den det ikke.
            if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)
            {
               evt.consume();
            }
			}
		});
		
		disciplinBox.setModel(new DefaultComboBoxModel(new String[] {"Bryst", "Butterfly", "Crawl", "Medly", "Rygcrawl"}));
		disciplinBox.setBounds(91, 152, 313, 29);
		contentPane.add(disciplinBox);
		
		distanceBox.setModel(new DefaultComboBoxModel(new String[] {"100"}));
		distanceBox.setBounds(91, 203, 313, 29);
		contentPane.add(distanceBox);
		
		backButton = new JButton("Tilbage");
		backButton.setBounds(362, 243, 89, 23);
		contentPane.add(backButton);
      backButton.addActionListener(this);
		
		addButton = new JButton("Tilføj");
		addButton.setBounds(263, 243, 89, 23);
		contentPane.add(addButton);
      addButton.addActionListener(this);
		
		JLabel lblISekunder = new JLabel("Skrives i sekunder:");
		lblISekunder.setBounds(91, 28, 121, 14);
		contentPane.add(lblISekunder);
		
		datoField = new JTextField();
		datoField.setColumns(10);
		datoField.setBounds(91, 102, 313, 29);
		contentPane.add(datoField);
		
		JLabel lblDato = new JLabel("Dato:");
		lblDato.setBounds(10, 103, 71, 26);
		contentPane.add(lblDato);
		
		JLabel lblSkrivHeleDato = new JLabel("ex. 20-12-2013");
		lblSkrivHeleDato.setBounds(91, 85, 201, 14);
		contentPane.add(lblSkrivHeleDato);
      
		setVisible(true);
	}
   
   public void updateTimeList()
   {  
      
      String disc = null;
      if(disciplinBox.getSelectedItem().equals("Bryst"))
      {
         disc = "Bryst";
      }
      else if(disciplinBox.getSelectedItem().equals("Butterfly"))
      {
         disc = "Butterfly";
      }
      else if(disciplinBox.getSelectedItem().equals("Crawl"))
      {
         disc = "Crawl";
      }
      else if(disciplinBox.getSelectedItem().equals("Medly"))
      {
         disc = "Medly";
      }
      else if(disciplinBox.getSelectedItem().equals("Rygcrawl"))
      {
         disc = "Rygcrawl";
      }
      
      //Oversætter det valgte i distanceboksen til en int.
      String readDistance = (String)distanceBox.getSelectedItem();
      int dist = Integer.parseInt(readDistance);
      //Oversætter det valgte i timefield til en double.
      String readTime = timeField.getText();
      double time = Double.parseDouble(readTime);
      
      String date = datoField.getText();
      
      Times t = new Times(disc, dist, time, date);
      //Tilføjer en tid til valgte medlem.
      memberInfo.addTimeByMember(memberInfo.getId(), t);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == backButton)
      {
         dispose();
      }
      else if(event.getSource() == addButton)
      {
         try
         {
            updateTimeList();
            dispose();
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(contentPane, "Du skal udfylde alle felter!");
         }
      }
   }
}
