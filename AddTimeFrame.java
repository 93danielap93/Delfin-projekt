
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class AddTimeFrame extends JFrame implements ActionListener 
{

	private JPanel contentPane;
   private static JTable table = new JTable();
   private JButton enterTimeButton;
   private JButton backButton;
   private JScrollPane scrollPane;
   private Members memberData = new Members();
   
   public static void main(String[] args)
   {
      new AddTimeFrame();
   }
	
	public AddTimeFrame() 
   {
      setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      
		enterTimeButton = new JButton("Indtast tid");
		enterTimeButton.setBounds(632, 606, 96, 25);
		contentPane.add(enterTimeButton);
      enterTimeButton.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 62, 779, 515);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel overskrift1 = new JLabel("Medlemmer:");
		overskrift1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		overskrift1.setBounds(26, 26, 278, 25);
		contentPane.add(overskrift1);
		
		backButton = new JButton("Tilbage");
		backButton.setBounds(738, 606, 96, 25);
		contentPane.add(backButton);
      backButton.addActionListener(this); 
      setVisible(true);
      
		updateMemberTable();
	}
	public static void updateMemberTable()
	   {
	      DefaultTableModel model = new DefaultTableModel();
	      table.setModel(model);
	      model.setColumnIdentifiers(new String[] {"ID", "Fornavn", "Efternavn", "Fødselsår", "Køn", "Adresse", "Status", "Elite Status"});
	      model.setRowCount(Members.getMemberCount());
	      
	      int row = 0;
	      for(MemberInfo m : Members.getMembers())
	      {
	         model.setValueAt(m.getId(), row, 0);
            model.setValueAt(m.getFirstName(), row, 1);
	         model.setValueAt(m.getLastName(), row, 2);
	         model.setValueAt(m.getYear(), row, 3);
	         model.setValueAt(m.getGender(), row, 4);
	         model.setValueAt(m.getAddress(), row, 5);
	         model.setValueAt(m.getStatus(), row, 6);
	         model.setValueAt(m.getEliteStatus(), row, 7);
	         row++;
	      }
	   }

      
   public void actionPerformed(ActionEvent event)
   {	
		if (event.getSource() == enterTimeButton)
		{
         try 
         {
               //Opretter en lokal variable hvor i vi gemmer værdien af den valgte række.
	            int selectedRowIndex = table.getSelectedRow();
               //Laver vores model om til defualt table.
               DefaultTableModel model = (DefaultTableModel) table.getModel();
	            //Vi caster vores getValueAt metode til en int som vi så gemmer i id.
               int id = (int) model.getValueAt(selectedRowIndex, 0);
	            //Vi finder medlem via id.
               MemberInfo m = Members.findMemberById(id);
	            new AddTimeFrame2(m);
         }
            
         catch (Exception e) 
         {
            JOptionPane.showMessageDialog(scrollPane, "Vælg et medlem du vil indtaste tid på");
         } 
            
		}
      else if(event.getSource() == backButton)
      {
         dispose();
      }
	}
}
