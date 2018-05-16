
import java.awt.*;

import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedlyTopFrame extends JFrame implements ActionListener 
{
	   private JTable menTable;
	   private JButton backButton;
	   private JTable womenTable;
	   private Statistics s;
	   private JPanel contentPane;
   
   public static void main(String[] args)
   {
      new MedlyTopFrame();
   }
	
	public MedlyTopFrame() 
   {  
		s = new Statistics();
	   setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	   contentPane.setLayout(null);
      setLocationRelativeTo(null);
		setResizable(false);
		
		menTable = new JTable();
		menTable.setBounds(24, 68, 289, 196);
		contentPane.add(menTable);
		
		womenTable = new JTable();
		womenTable.setBounds(378, 68, 289, 196);
		contentPane.add(womenTable);
     		
		backButton = new JButton("Tilbage");
		backButton.setBounds(594, 317, 85, 25);
		contentPane.add(backButton);
		
		JLabel menLabel = new JLabel("Mænd:");
		menLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		menLabel.setBounds(24, 43, 85, 14);
		contentPane.add(menLabel);
		
		JLabel womenLabel = new JLabel("Kvinder:");
		womenLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		womenLabel.setBounds(378, 43, 85, 14);
		contentPane.add(womenLabel);
      backButton.addActionListener(this);
		
      setVisible(true);
	   updateMenTable();
      updateWomenTable();
	}
	 public void updateMenTable()
	   {
	      DefaultTableModel model = new DefaultTableModel();
	      model.setColumnIdentifiers(new String[] {"Navn", "Tid"});
	      model.setRowCount(5);
	      int row = 0;
	      for(Statistics s : this.s.getTopFiveMen("Medly", 100))
	      {
	         model.setValueAt(s.getName(), row, 0);
	         model.setValueAt(s.getTimes(), row, 1);
	         row++;
	      }
	      menTable.setModel(model);
	   }
	   
	   public void updateWomenTable()
	   {
	      DefaultTableModel model2 = new DefaultTableModel();
	      model2.setColumnIdentifiers(new String[] {"Navn", "Tid"});
	      model2.setRowCount(5);
	      int row = 0;
	      for(Statistics s : this.s.getTopFiveWomen("Medly", 100))
	      {
	         model2.setValueAt(s.getName(), row, 0);
	         model2.setValueAt(s.getTimes(), row, 1);
	         row++;
	      }
	      womenTable.setModel(model2);
	   }
	   
	   public void actionPerformed(ActionEvent event)
	   {
	      if(event.getSource() == backButton)
	      {
	         dispose();
	      }
	    }
	}

