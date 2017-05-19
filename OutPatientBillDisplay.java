import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OutPatientBillDisplay extends JFrame implements ActionListener
{
 JLabel lpatname,lpatno,lservicechgs,lamount,ltotal,lhospitalchgs;
 String patname,name,patno;
 JButton bok;
 final double servicechgs=50.0;
 final double hospitalchgs=150.0;
 double total,amount;
 
 
 OutPatientBillDisplay(String x,String name1,String no,String amount1)
 {
  super("Logged in as " +x);
  name=x;
  setSize(500,500);
  setVisible(true);
  setLayout(null);
  this.patname=name1;
  this.patno=no;
  this.amount=Double.parseDouble(amount1);
  total=servicechgs+hospitalchgs+amount;

     lpatname=new JLabel("Patient Name :   " +patname);
	 lpatname.setBounds(100,70,300,20);
	 add(lpatname);
	 
	 lpatno=new JLabel("Patient Id :    " +patno);
	 lpatno.setBounds(100,120,300,20);
	 add(lpatno);
	 
	 lservicechgs=new JLabel("Service Charges :   Rs " +servicechgs);
	 lservicechgs.setBounds(100,170,300,20);
	 add(lservicechgs);
	 
	 lhospitalchgs=new JLabel("Hospital Charges :   Rs " +hospitalchgs);
	 lhospitalchgs.setBounds(100,220,300,20);
	 add(lhospitalchgs);
	 
	 lamount=new JLabel("Doctor Fees :    Rs " +amount);
	 lamount.setBounds(100,270,300,20);
	 add(lamount);
	 
	 ltotal=new JLabel("Total amount to be paid :   Rs" +total);
	 ltotal.setBounds(100,320,300,20);
	 add(ltotal);
	 
	 
	 bok=new JButton("OK",new ImageIcon("images/ok.png"));
	 bok.setBounds(225,390,80,30);
	 add(bok);
	 
	  bok.addActionListener(new ok());
  }

 
  public void actionPerformed(ActionEvent ae)
  {}

  class ok implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  Input(name);
			setVisible(false);
		}
	}
	
	/*public static void main(String args[])
	{
	String n="xyz";
	String na="pqr";
	String num="12";
	String datea="2000.0";
	
	 new OutPatientBillDisplay(n,na,num,datea);
	}*/
}
