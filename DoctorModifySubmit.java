import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class DoctorModifySubmit extends JFrame implements ActionListener
{
    
    JLabel lmain,lname,ldid,lspecial,lwork,lqual,lid;
    JTextField tfname,tfdid,tfwork,tfqual;
    TextArea taspecial;
    JButton bsub,bclr,bback,bhome;
    String name1,did,workf,special;
    String name;
    String quali;
    
    DoctorModifySubmit(String x,String name2,String id,String work,String specialist,String qualification)
    {
    super("Logged in as " +x);
    name=x;
    setSize(768,768);
    setVisible(true);
    setLayout(null);
    did = id;
    lmain=new JLabel("Modify Doctor Information");
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
    add(taspecial) ;

    ldid=new JLabel("Doctor ID:  ");
    ldid.setBounds(100,290,110,20);
    add(ldid);
    
    lid=new JLabel(id);
    lid.setBounds(250,290,110,20);
    add(lid);
    
    lwork=new JLabel("Working hours :");
    lwork.setBounds(100,350,100,20);
    add(lwork);
// 
//  lworkfrom=new JLabel("From :");
//  lworkfrom.setBounds(220,350,40,20);
//  add(lworkfrom);
// 
//  tfworkf=new JTextField(30);
//  tfworkf.setBounds(270,350,30,20);
//  add(tfworkf);
//  
//  lworkto=new JLabel("to :");
//  lworkto.setBounds(310,350,40,20);
//  add(lworkto);
    

    tfwork=new JTextField(30);
    tfwork.setBounds(250,350,40,20);
    add(tfwork);
    
    lqual=new JLabel("Qualification :");
	lqual.setBounds(100,320,110,25);
	add(lqual);

	tfqual=new JTextField(30);
	tfqual.setBounds(250,320,200,20);
	add(tfqual);
        
    bsub=new JButton("MODIFY",new ImageIcon("images/add.gif"));
    bsub.setBounds(100,500,130,30);
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
    
    set(name2,work,specialist,qualification);//call to set method


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
            tfwork.setText("");
            taspecial.setText("");
            
        }
    }


class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new DoctorModify(name);
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
      //did=tfdid.getText().trim();
      //workf=tfworkf.getText().trim();
      workf=tfwork.getText().trim();
      special=taspecial.getText().trim();
      quali=tfqual.getText().trim();
      if((name1.equals(""))||(did.equals(""))||(workf.equals(""))||(quali.equals(""))||(special.equals("")))
      {
       new ErrorDialog1();
      }
      else
      {
                   
        try
          {
              int hrs = Integer.parseInt(workf);
          String message = new modDoc(Integer.parseInt(did)).modify(name1,Integer.parseInt(did),special,quali,hrs );
         JOptionPane.showMessageDialog(new JFrame(), message, "DONE!!!", JOptionPane.INFORMATION_MESSAGE);
         new DoctOptions(name);
         setVisible(false);
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        } 

      }
     }
    }
    
    public void set(String name2,String work,String specialist,String qual)
    {
         tfname.setText(name2);
            tfwork.setText(work);
            tfqual.setText(qual);
            taspecial.setText(specialist);
    }
        
    
public void actionPerformed(ActionEvent ae)
    {}

    public static void main(String[] args) 
    {
        //new DoctorModifySubmit("xyz","sonika","09","05","surgery");
    }
}






