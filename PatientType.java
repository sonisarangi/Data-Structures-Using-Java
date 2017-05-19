import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PatientType extends JFrame implements ActionListener
{
 JLabel linfo,linpat,loutpat;
 JButton binpat,boutpat,bback;
 String name;
 
 PatientType(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(600,600);
  setVisible(true);
  setLayout(null);

  linfo=new JLabel("Select The Appropriate Option");
  linfo.setBounds(100,30,210,20);
  add(linfo);

  linpat=new JLabel("1.  Click for In-Patient");
  linpat.setBounds(80,80,210,20);
  add(linpat);
  
  binpat=new JButton("In-Patient",new ImageIcon("images/4111.gif"));
  binpat.setBounds(180,130,180,35);
  add(binpat);
  
  loutpat=new JLabel("2. Click for Out-Patient");
  loutpat.setBounds(80,180,210,20);
  add(loutpat);
  
  boutpat=new JButton("Out-Patient",new ImageIcon("images/4111.gif"));
  boutpat.setBounds(180,230,180,35);
  add(boutpat);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(250,350,100,30);
  add(bback);
  
  boutpat.addActionListener(new outPat());
  binpat.addActionListener(new inPat());
  bback.addActionListener(new back());

  
 }
 
 public void actionPerformed(ActionEvent ae)
  {}

  class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  Input(name);
			setVisible(false);
		}
	}
	
	class outPat implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  PatOptions(name);
			setVisible(false);
		}
	}
	
	class inPat implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  PatOptionsIn(name);
			setVisible(false);
		}
	}
	
	/*public static void main(String args[])
	{
	
	 String n="xyz";
	 new PatientType(n);
	 }*/
}







