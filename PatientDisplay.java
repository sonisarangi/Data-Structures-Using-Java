
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PatientDisplay extends JFrame implements ActionListener
{
 JLabel lpatname,lpatno,lpattype,ldateadd,lrt,ldis;
 String patname,name,patno,dateadd,rt,pattype;
 JButton bok;
 PatientDisplay(String x,String patname,String patno,String doc,String cur)
 {
  super("Logged in as " +x);
  name=x;
  setSize(500,500);
  setVisible(true);
  setLayout(null);
  this.patname=patname;
  this.patno=patno;
  this.dateadd=dateadd;
  this.rt=rt;
  this.pattype="Out Patient";
  
    lpatname=new JLabel("Patient Name :   " +patname);
	lpatname.setBounds(100,70,300,20);
	add(lpatname);
	 
	 lpatno=new JLabel("Patient Id :    " +patno);
	 lpatno.setBounds(100,120,300,20);
	 add(lpatno);
	 
	 lpattype=new JLabel("Patient Type :   " +pattype);
	 lpattype.setBounds(100,170,300,20);
	 add(lpattype);
	 
	 
	 
	 ldateadd=new JLabel("Consulting Doctor :   " +doc);
	 ldateadd.setBounds(100,220,300,20);
	 add(ldateadd);
	 ldis=new JLabel("Disorder :   " +cur);
	 ldis.setBounds(100,270,300,20);
	 add(ldis);
	 
	 bok=new JButton("OK",new ImageIcon("images/ok.png"));
	 bok.setBounds(200,350,80,30);
	 add(bok);
	 
	  bok.addActionListener(new ok());
  }
  
  
  public void actionPerformed(ActionEvent ae)
  {}

  class ok implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  PatientDetails(name);
			setVisible(false);
		}
	}
	
	
	/*public static void main(String args[])
	{
	String n="xyz";
	String na="pqr";
	String num="12";
	String datea="12/11/2015";
	String room="Deluxe";
	
	 new PatientDisplay(n,na,num,room,datea);
	}*/
}

