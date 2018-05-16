
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
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ShowFullMembersFrame extends JFrame implements ActionListener 
{
	private JPanel contentPane;
   private static JTable table = new JTable();
   private JButton saveButton;
   private JScrollPane scrollPane;
   private Members memberData;
   private JButton loadButton;
   private JButton removeButton;
   private JButton backButton;
   
   public static void main(String[] args)
   {
      new ShowFullMembersFrame();
   }
	
	public ShowFullMembersFrame() 
   {  
      this.memberData = new Members();
      
      setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
		
		saveButton = new JButton("Gem");
		saveButton.setBounds(423, 615, 85, 25);
		contentPane.add(saveButton);
      saveButton.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 62, 779, 515);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel overskrift1 = new JLabel("Medlemmer:");
		overskrift1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		overskrift1.setBounds(26, 26, 278, 25);
		contentPane.add(overskrift1);
		
		loadButton = new JButton("Indlæs");
		loadButton.setBounds(518, 616, 85, 25);
		contentPane.add(loadButton);
      loadButton.addActionListener(this); 
		
		removeButton = new JButton("Fjern");
		removeButton.setBounds(613, 616, 85, 25);
		contentPane.add(removeButton);
      removeButton.addActionListener(this); 
		
		backButton = new JButton("Tilbage");
		backButton.setBounds(708, 615, 85, 25);
		contentPane.add(backButton);
      backButton.addActionListener(this); 
      
      setVisible(true);
		updateMemberTable();
	}
	public static void updateMemberTable()
	   {
	      DefaultTableModel model = new DefaultTableModel();
	      table.setModel(model);
	      model.setColumnIdentifiers(new String[] {"ID", "Fornavn", "Efternavn", "Fødselsår", "CPR Nummer", "Køn", "Adresse", "Status", "Elite Status"});
	      model.setRowCount(Members.getMemberCount());
	      
	      int row = 0;
	      for(MemberInfo m : Members.getMembers())
	      {
	         model.setValueAt(m.getId(), row, 0);
            model.setValueAt(m.getFirstName(), row, 1);
	         model.setValueAt(m.getLastName(), row, 2);
	         model.setValueAt(m.getYear(), row, 3);
            model.setValueAt(m.getCprNumber(), row, 4);
	         model.setValueAt(m.getGender(), row, 5);
	         model.setValueAt(m.getAddress(), row, 6);
	         model.setValueAt(m.getStatus(), row, 7);
	         model.setValueAt(m.getEliteStatus(), row, 8);
	         row++;
	      }
	   }
      
   public void actionPerformed(ActionEvent event)
   {	
		if (event.getSource() == saveButton)
		{
         Persistence.save(memberData.memberList);
		}
      else if (event.getSource() == loadButton)
		{
         Members.memberList = Persistence.load();
         this.updateMemberTable(); 
		}
      else if (event.getSource() == removeButton)
		{
         try
         {
	         int selectedRowIndex = table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
	         int id = (int) model.getValueAt(selectedRowIndex, 0);
            Members.removeMember(id);
            this.updateMemberTable();
         }
         catch (Exception e) 
         {
            JOptionPane.showMessageDialog(scrollPane, "Vælg et medlem du vil fjerne");
         } 
            
		}
      else if (event.getSource() == backButton)
		{
         dispose();
		}
	}
}
