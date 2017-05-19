import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class DoctorAdd extends JFrame implements ActionListener
{
    
    JLabel lmain,lname,ldid,lspecial,lwork,lworkfrom,lworkto,lqual;
    JTextField tfname,tfdid,tfworkf,tfworkt,tfqual;
    TextArea taspecial;
    JButton bsub,bclr,bback,bhome;
   String name1,did,workf,workt,special;
    String name;
    String qualification ="MBBS, MD";
    
    DoctorAdd(String x)
    {
    super("Logged in as " +x);
    name=x;
    setSize(768,768);
    setVisible(true);
    setLayout(null);

    lmain=new JLabel("Add Doctor Information");
    lmain.setBounds(40,35,160,15);
    add(lmain);


    lname=new JLabel("Name :");
    lname.setBounds(100,80,70,25);
    add(lname);

    tfname=new JTextField(30);
    tfname.setBounds(250,80,250,20);
    add(tfname);

    lspecial=new JLabel("Specialization :");
    lspecial.setBounds(100,130,140,20);
    add(lspecial);

    taspecial=new TextArea();
    taspecial.setBounds(250,130,250,100);
    add(taspecial);

    lqual=new JLabel("Qualification:");
    lqual.setBounds(100,250,100,20);
    add(lqual);

    tfqual=new JTextField(60);
    tfqual.setBounds(250,250,80,20);
    add(tfqual);
    
    
    ldid=new JLabel("Doctor ID:");
    ldid.setBounds(100,290,70,20);
    add(ldid);

    tfdid=new JTextField(30);
    tfdid.setBounds(250,290,50,20);
    add(tfdid);

    lwork=new JLabel("Working hours :");
    lwork.setBounds(100,350,100,20);
    add(lwork);

    lworkfrom=new JLabel("From :");
    lworkfrom.setBounds(220,350,40,20);
    add(lworkfrom);

    tfworkf=new JTextField(30);
    tfworkf.setBounds(270,350,30,20);
    add(tfworkf);
    
    lworkto=new JLabel("To :");
    lworkto.setBounds(310,350,40,20);
    add(lworkto);
    

    tfworkt=new JTextField(30);
    tfworkt.setBounds(360,350,30,20);
    add(tfworkt);
     
        
    bsub=new JButton("ADD",new ImageIcon("images/add.gif"));
    bsub.setBounds(130,500,100,30);
    add(bsub);  

    bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
    bclr.setBounds(250,500,100,30);
    add(bclr);

    bback=new JButton("BACK",new ImageIcon("images/restore.png"));
    bback.setBounds(370,500,100,30);
    add(bback);
    
    bhome=new JButton("HOME",new ImageIcon("images/branch.png"));
    bhome.setBounds(490,500,100,30);
    add(bhome);


    bclr.addActionListener(new clear());
    bsub.addActionListener(new submit());
    bback.addActionListener(new back());
    bhome.addActionListener(new home());

    }

class clear implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            
            tfname.setText("");
            tfdid.setText("");
            tfworkf.setText("");
            tfworkt.setText("");
            taspecial.setText("");
            
        }
    }


class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new DoctOptions(name);
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



class submit implements ActionListener
{
        public void actionPerformed(ActionEvent ae)
    {

      name1=tfname.getText().trim();
      did=tfdid.getText().trim();
      qualific=tfqual.getText().trim();
      workf=tfworkf.getText().trim();
      workt=tfworkt.getText().trim();
      special=taspecial.getText().trim();
      
      if((name1.equals(""))||(did.equals(""))||(workf.equals(""))||(qualific.equals(""))||(workt.equals(""))||(special.equals("")))
      {
       new ErrorDialog1();
      }
      else
      {
          try
          {
              int a=Integer.parseInt(workt);
              int b=Integer.parseInt(workf);
              int hrs =0;
              if(b>a)
                hrs = a-b+12;
              else
                hrs = a-b;
          String message = new addDoc().addNew(name1,Integer.parseInt(did),special,qualific,hrs);
         JOptionPane.showMessageDialog(new JFrame(), message, "DONE!!!", JOptionPane.INFORMATION_MESSAGE);
                  new DoctOptions(name);
         setVisible(false);
        }
        catch(Exception e)
        {}
       /*new backend(name,name1,did,workf,workt,special);
        setVisible(false);*/
      }
     }
    }
        
    
public void actionPerformed(ActionEvent ae)
    {}

    /*public static void main(String[] args) 
    {
        new DoctorInfoAdd();
    }*/
}






