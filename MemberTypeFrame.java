
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemberTypeFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
   private JButton activeButton;
   private JButton passivButton;
   private JButton backButton;
   
   public static void main(String[] args)
   {
      new MemberTypeFrame();
   }

	public MemberTypeFrame() {
		setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setLocationRelativeTo(null);
		setResizable(false);
		
		activeButton = new JButton("Aktiv");
		activeButton.setBounds(0, 15, 379, 47);
		contentPane.add(activeButton);
      activeButton.addActionListener(this);
		
		passivButton = new JButton("Passiv");
		passivButton.setBounds(0, 73, 379, 47);
		contentPane.add(passivButton);
		passivButton.addActionListener(this);
      
		backButton = new JButton("Tilbage");
		backButton.setBounds(279, 148, 89, 23);
		contentPane.add(backButton);
      backButton.addActionListener(this);
      
      setVisible(true);
	}
   
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == activeButton)
      {
         dispose();
         new NewMemberFrame();
      }
      else if(event.getSource() == passivButton)
      {
         dispose();
         new PassivMemberFrame();
      }
      else if(event.getSource() == backButton)
      {
         dispose();
         new ChairmanFrame();   
      }
   }
}
