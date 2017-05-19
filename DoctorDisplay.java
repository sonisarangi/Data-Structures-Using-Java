
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DoctorDisplay extends JFrame implements ActionListener
{
 JLabel ldocname,lqual,ldocno,lwork,lspecial,lsal;
 String docname,name,docno,workf,workto,special;
 JButton bok;
 DoctorDisplay(String x,String docname,String docno,String work,String special,String quali,String sal)
 {
  super("Logged in as " +x);
  name=x;
  setSize(500,500);
  setVisible(true);
  setLayout(null);
  this.docname=docname;
  this.docno=docno;
  this.workf=workf;
  this.workto=workto;
  this.special=special;
  
    ldocname=new JLabel("Doctor Name :   " +docname);
	ldocname.setBounds(100,70,300,20);
	add(ldocname);
	 
	 ldocno=new JLabel("Doctor Id :    " +docno);
	 ldocno.setBounds(100,120,300,20);
	 add(ldocno);
	 
	 lwork=new JLabel("Work Hours :    " +work);
	 lwork.setBounds(100,170,300,20);
	 add(lwork);
	 
	 lspecial=new JLabel("Specialization :   " +special);
	 lspecial.setBounds(100,220,350,20);
	 add(lspecial);
	 
	 lqual=new JLabel("Qualification :   " +quali);
	 lqual.setBounds(100,270,350,20);
	 add(lqual);
	 
	 lsal=new JLabel("Salary :   Rs " +sal);
	 lsal.setBounds(100,320,350,20);
	 add(lsal);
	 
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
			new  DoctorDetails(name);
			setVisible(false);
		}
	}
	
	
	/*public static void main(String args[])
	{
	String n="xyz";
	String na="pqr";
	String num="12";
	String from="09";
	String to="05";
	String spe="Surgeon";
	
	 new DoctorDisplay(n,na,num,from,to,spe);
	}*/
}

