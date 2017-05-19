import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewPatientListIn extends JFrame implements ActionListener
{
 JTable patList;
 JScrollPane jsp;
 JButton bok;
 JLabel lpat;
 String name;
 String[] colHeads={"Patient Id","Patient name","Consulting Doctor"};
 LOADIP load = new LOADIP();
 String[][] pat = new IPview().getip();
 ViewPatientListIn(String x) throws Exception
 {
   super("Logged in as " +x);
	name=x;
	setSize(500,500);
	setVisible(true);
	setLayout(null);
	
	lpat=new JLabel("Patient List");
	lpat.setBounds(60,60,100,20);
	add(lpat);

   patList=new JTable(pat,colHeads);
	patList.setBounds(60,100,380,250);
	add(patList);
	
	jsp=new JScrollPane(patList);
	jsp.setBounds(60,100,380,250);
	add(jsp);
	
	
	 bok=new JButton("OK",new ImageIcon("images/ok.png"));
	 bok.setBounds(200,400,80,30);
	 add(bok);
	 
	  bok.addActionListener(new ok());
	
	}
	
	
	class ok implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  ViewPatientOptionsIn(name);
			setVisible(false);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{}
	
	/*public static void main(String[] args)
	{
	 String n="xyz";
	 new ViewPatientList(n);
	}*/
}
	  

   