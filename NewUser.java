import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NewUser extends JFrame implements ActionListener
{
 JLabel lusername,lpass,lrepass,lemailid;
 JTextField tfusername,tfemailid;
 JPasswordField tfpass,tfrepass;
 JButton bback,bsub,bclr;
 String name,pass,repass,username,emailid;
 
 NewUser(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(768,600);
  setVisible(true);
  setLayout(null);

  lusername=new JLabel("Username:");
  lusername.setBounds(100,80,180,20);
  add(lusername);
  
  tfusername=new JTextField(30);
  tfusername.setBounds(220,80,150,20);
  add(tfusername);
  
  lpass=new JLabel("Password:");
  lpass.setBounds(100,140,180,20);
  add(lpass);
  
  tfpass=new JPasswordField(30);
  tfpass.setBounds(220,140,150,20);
  add(tfpass);
  
  lrepass=new JLabel("Re-Enter Password:");
  lrepass.setBounds(100,200,180,20);
  add(lrepass);
  
  tfrepass=new JPasswordField(30);
  tfrepass.setBounds(220,200,150,20);
  add(tfrepass);
  
  lemailid=new JLabel("Email-Id:");
  lemailid.setBounds(100,260,180,20);
  add(lemailid);
  
  tfemailid=new JTextField(70);
  tfemailid.setBounds(220,260,220,20);
  add(tfemailid);
  
  bsub=new JButton("ADD",new ImageIcon("images/add.gif"));
  bsub.setBounds(210,400,100,30);
  add(bsub);	

  bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
  bclr.setBounds(330,400,100,30);
  add(bclr);

  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(450,400,100,30);
  add(bback);
 
  bclr.addActionListener(new clear());
  bsub.addActionListener(new submit());
  bback.addActionListener(new back());
  
 }
 
 public void actionPerformed(ActionEvent ae)
		{}

 
 class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{

			tfpass.setText("");
			tfrepass.setText("");
			tfemailid.setText("");
			tfusername.setText("");
		}
	}
 
 class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new Input(name);
			setVisible(false);
		}
	}
	
	class submit implements ActionListener
	{
	  public void actionPerformed(ActionEvent ae)
	  {
	   pass=tfpass.getText().trim();
		repass=tfrepass.getText().trim();
		username=tfusername.getText().trim();
		emailid=tfemailid.getText().trim();
		
		if((pass.equals(""))||(repass.equals(""))||(username.equals(""))||(emailid.equals("")))
		{
		 new ErrorDialog1();
		}

		if(!(pass.equals(repass)))
		{
		 JOptionPane.showMessageDialog(null,"Entered Passwords did not match" , "Try Again!!!",JOptionPane.INFORMATION_MESSAGE);
	   tfpass.setText("");
      tfrepass.setText("");

		}
		else
		{
		 JOptionPane.showMessageDialog(null,"User added Successfully!!!" , "Done!!!",JOptionPane.INFORMATION_MESSAGE);
		 try
		 {
		     new addUser(username,pass);
		  }
		  catch(Exception e)
		  {}
		  new Input(name);
		  setVisible(false);
		}
	 }
  }
	
	/*public static void main(String args[])
	{
	 String n="xyz";
	 new NewUser(n);
	}*/
}




  

  
  

  
  
  
  
