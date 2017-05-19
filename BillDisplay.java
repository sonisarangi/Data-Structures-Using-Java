import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BillDisplay extends JFrame implements ActionListener
{
 JLabel lpatname,lpatno,ldateadd,lrt,ldateofdis,lservicechg,lroomchg,ltotal,ldct,ldays;
 String patname,name,patno,dateadd,rt,dateofdis;
 JButton bok;
 final double servicechg=100.0;
 int[][] daytab={
          {0,31,28,31,30,31,30,31,31,30,31,30,31},
          {0,31,29,31,30,31,30,31,31,30,31,30,31}
			};

 double chg,total;
  int days,addda,admonth,disda, dismonth,adyear,disyear,addday, disday,i,leap;
 
 
 BillDisplay(String x,String name1,String no,String dateadd,String rt,String dd1,int dct)
 {
  super("Logged in as " +x);
  name=x;
  setSize(600,600);
  setVisible(true);
  setLayout(null);
  this.patname=name1;
  this.patno=no;
  this.dateadd=dateadd;
  this.rt=rt;
  this.dateofdis=dd1;
    addda=Integer.parseInt(dateadd.substring(0,2));
	 admonth=Integer.parseInt(dateadd.substring(3,5));
	 disda=Integer.parseInt(dateofdis.substring(0,2));	
	 dismonth=Integer.parseInt(dateofdis.substring(3,5));	
	 adyear=Integer.parseInt(dateadd.substring(6,10));		
	 disyear=Integer.parseInt(dateofdis.substring(6,10));
	 addday=dayofyear(adyear,admonth,addda);
	 disday=dayofyear(disyear,dismonth,disda);
	
	  days=disday-addday+1; 
	 
	  
	  if((rt.equals("10")))
	  {
	   chg=500*days;
	  }
	  else if((rt.equals("5")))
	  {
	   chg=300*days;
	 }
	 else if((rt.equals("1")))
	 {
	  chg=150*days;
	 }
	 else 
	 {
	  chg=80*days;
	 }
   total=servicechg+chg+dct;

    lpatname=new JLabel("Patient Name :   " +patname);
	 lpatname.setBounds(100,70,300,20);
	 add(lpatname);
	 
	 lpatid=new JLabel("Patient Id :    " +patid);
	 lpatid.setBounds(100,120,300,20);
	 add(lpatid);
	 
	 ldateadd=new JLabel("Date of Admission :   " +dateadd);
	 ldateadd.setBounds(100,170,300,20);
	 add(ldateadd);
	 
	 ldateofdis=new JLabel("Date of Discharge :   " +dateofdis);
	 ldateofdis.setBounds(100,220,300,20);
	 add(ldateofdis);
	 
	 ldct=new JLabel("Doctor Charges :    Rs" +dct);
	 ldct.setBounds(100,420,300,20);
	 add(ldct);
	 
	 ldays=new JLabel("Total number of days :   " +days);
	 ldays.setBounds(100,270,300,20);
	 add(ldays);
	 
	 lservicechg=new JLabel("Service Charges  :    Rs" +servicechg);
	 lservicechg.setBounds(100,320,300,20);
	 add(lservicechg);
	 
	 lroomchg=new JLabel("Room Charges :     Rs" +chg);
	 lroomchg.setBounds(100,370,300,20);
	 add(lroomchg);
	 
	 ltotal=new JLabel("Total Amount to be paid : Rs" +total);
	 ltotal.setBounds(100,470,300,20);
	 add(ltotal);
	 
	 
	 bok=new JButton("OK",new ImageIcon("images/ok.png"));
	 bok.setBounds(275,500,80,30);
	 add(bok);
	 
	  bok.addActionListener(new ok());
  }
  
  public int dayofyear(int year, int month, int day)
	{
	   int i,leap;
		if( year%4==0)
	    leap=1;
	  else
	  leap=0;
	  for(i=1;i<month;i++)
	  day+=daytab[leap][i];
	  return day;
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
	String num="10";
	String datea="10/11/2015";
	String datedi="12/11/2015";
	String room="Deluxe";
	
	 new BillDisplay(n,na,num,datea,room,datedi);
	}*/
}
