
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisciplineTypeFrame extends JFrame implements ActionListener 
{
	private JPanel contentPane;
   private JButton backButton;
   private JButton crawlButton;
   private JButton rygCrawlButton;
   private JButton butterflyButton;
   private JButton medlyButton;
   private JButton brystButton;
   
   public static void main(String[] args)
   {
      new DisciplineTypeFrame();
   }
	
	public DisciplineTypeFrame() 
   {
		setTitle("Svømmeklubben Delfinen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      setResizable(false);
		
		backButton = new JButton("Tilbage");
		backButton.setBounds(263, 185, 89, 23);
		contentPane.add(backButton);
      backButton.addActionListener(this);
		
		crawlButton = new JButton("Crawl");
		crawlButton.setBounds(10, 36, 99, 49);
		contentPane.add(crawlButton);
      crawlButton.addActionListener(this);
		
		rygCrawlButton = new JButton("Rygcrawl");
		rygCrawlButton.setBounds(117, 36, 99, 49);
		contentPane.add(rygCrawlButton);
      rygCrawlButton.addActionListener(this);
		
		butterflyButton = new JButton("Butterfly");
		butterflyButton.setBounds(64, 106, 99, 49);
		contentPane.add(butterflyButton);
      butterflyButton.addActionListener(this);
		
		medlyButton = new JButton("Medly");
		medlyButton.setBounds(184, 106, 99, 49);
		contentPane.add(medlyButton);
      medlyButton.addActionListener(this);
		
		brystButton = new JButton("Brystsvømning");
		brystButton.setBounds(226, 36, 126, 49);
		contentPane.add(brystButton);
		setLocationRelativeTo(null);
      brystButton.addActionListener(this);
		
		setVisible(true);
	}
   
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == crawlButton)
      {
         new CrawlTopFrame();
      }
      else if(event.getSource() == rygCrawlButton)
      {
         new RygcrawlTopFrame();
      }
      else if(event.getSource() == butterflyButton)
      {
         new ButterflyTopFrame();
      }
      else if(event.getSource() == medlyButton)
      {
         new MedlyTopFrame();
      }
      else if(event.getSource() == brystButton)
      {
         new BrystTopFrame(); 
      }
      else if(event.getSource() == backButton)
      {
         dispose();   
      }
   }
}
