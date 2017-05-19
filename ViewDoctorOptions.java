import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewDoctorOptions extends JFrame implements ActionListener
{
 JButton bback,bdoctorList,bsearchDoctor,bhome;
 JLabel ldoctorList,lsearchDoctor,linfo;
 String name;
 
 ViewDoctorOptions(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(600,600);
  setVisible(true);
  setLayout(null);

  linfo=new JLabel("Select The Appropriate Option");
  linfo.setBounds(100,30,210,20);
  add(linfo);

  ldoctorList=new JLabel("1.  View all Doctor's List");
  ldoctorList.setBounds(80,80,210,20);
  add(ldoctorList);
  
  bdoctorList=new JButton("View",new ImageIcon("images/4111.gif"));
  bdoctorList.setBounds(180,130,180,35);
  add(bdoctorList);
  
  lsearchDoctor=new JLabel("2. Search a particular Doctor details");
  lsearchDoctor.setBounds(80,180,210,20);
  add(lsearchDoctor);
  
  bsearchDoctor=new JButton("Search",new ImageIcon("images/4642.gif"));
  bsearchDoctor.setBounds(180,230,180,35);
  add(bsearchDoctor);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(200,350,100,30);
  add(bback);
  
  bhome=new JButton("HOME",new ImageIcon("images/branch.png"));
    bhome.setBounds(320,350,100,30);
    add(bhome);
  
  bsearchDoctor.addActionListener(new searchDoctor());
  bdoctorList.addActionListener(new doctorList());
  bback.addActionListener(new back());
  bhome.addActionListener(new home());
  
 }
 
 public void actionPerformed(ActionEvent ae)
  {}

  class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new  DoctOptions(name);
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

    
    class searchDoctor implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new  DoctorDetails(name);
            setVisible( false);
        }
    }
    
    class doctorList implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                new ViewDoctorList(name);
                setVisible(false);
            }
            catch(Exception e)
            {}
        }
    }
    
    /*public static void main(String args[])
    {
    
     String n="xyz";
     new ViewOptions(n);
     }*/
}







