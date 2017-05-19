import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewPatientOptions extends JFrame implements ActionListener
{
 JButton bback,bpatientList,bsearchPatient,bhome;
 JLabel lpatientList,lsearchPatient,linfo;
 String name;
 
 ViewPatientOptions(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(600,600);
  setVisible(true);
  setLayout(null);

  linfo=new JLabel("Select The Appropriate Option");
  linfo.setBounds(100,30,210,20);
  add(linfo);

  lpatientList=new JLabel("1.  View all Patient's List");
  lpatientList.setBounds(80,80,210,20);
  add(lpatientList);
  
  bpatientList=new JButton("View",new ImageIcon("images/4111.gif"));
  bpatientList.setBounds(180,130,180,35);
  add(bpatientList);
  
  lsearchPatient=new JLabel("2. Search a particular Patient details");
  lsearchPatient.setBounds(80,180,210,20);
  add(lsearchPatient);
  
  bsearchPatient=new JButton("Search",new ImageIcon("images/4642.gif"));
  bsearchPatient.setBounds(180,230,180,30);
  add(bsearchPatient);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(200,350,100,30);
  add(bback);
  
  bhome=new JButton("HOME",new ImageIcon("images/branch.png"));
	bhome.setBounds(320,350,100,30);
	add(bhome);
  
  bsearchPatient.addActionListener(new searchPatient());
  bpatientList.addActionListener(new patientList());
  bback.addActionListener(new back());
  bhome.addActionListener(new home());

  
 }
 
 public void actionPerformed(ActionEvent ae)
  {}

  class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  PatOptions(name);
			setVisible(false);
		}
	}
	
	class home implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new Input(name);
			setVisible(false);
		}
	}

	
	class searchPatient implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  PatientDetails(name);
			setVisible(false);
		}
	}
	
	class patientList implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
		    {
			new  ViewPatientList(name);
			setVisible(false);
		}
		catch (Exception e)
		{}
		}
	}
	
	/*public static void main(String args[])
	{
	
	 String n="xyz";
	 new ViewPatientOptions(n);
	 }*/
}







