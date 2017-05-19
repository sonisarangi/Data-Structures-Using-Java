import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
class BillingInput extends JFrame implements ActionListener
{
 JLabel lpatid,lpattype;
 JButton bsub,bback,bclr;
 JTextField tfpatid;
 Choice chpattype;
 String patid,pattype;;
 String name;
 
 BillingInput(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(500,500);
  setVisible(true);
  setLayout(null);

  lpatid=new JLabel("Enter Patient Id");
  lpatid.setBounds(100,100,180,20);
  add(lpatid);
  
  tfpatid=new JTextField(30);
  tfpatid.setBounds(200,100,100,20);
  add(tfpatid);
  
  lpattype=new JLabel("Patient Type ");
  lpattype.setBounds(100,150,100,20);
  add(lpattype);
  
  chpattype=new Choice();
  chpattype.setBounds(200,150,100,20);
  chpattype.addItem("In Patient");
  chpattype.addItem("Out Patient");
  add(chpattype);
  
  bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
  bclr.setBounds(200,300,100,30);
  add(bclr);
  
  bsub=new JButton("Submit",new ImageIcon("images/backup.png"));
  bsub.setBounds(80,300,100,30);
  add(bsub);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(320,300,100,30);
  add(bback);
  
  bclr.addActionListener(new clear());
  bsub.addActionListener(new submit());
  bback.addActionListener(new back());

 }
 
 public void actionPerformed(ActionEvent ae)
        {}

    class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new  Input(name);
            setVisible(false);
        }
    }
    
    class clear implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            tfpatid.setText("");
        }
    }


  class submit implements ActionListener
  {
        public void actionPerformed(ActionEvent ae)
        {
         patid=tfpatid.getText().trim();
         if(patid.equals(""))
         {
          new ErrorDialog1();
         }
         else
         {
             pattype=(String)chpattype.getSelectedItem();
             if(pattype.equals("In Patient"))
            {
                //String x,String name1,String no,String dateadd,String rt,String dd1
               // new Bill(name);
               // setVisible(false);
               try
                {
                    
                            Calendar cal=Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        df.setLenient(false);  
         String dateadd=df.format(cal.getTime());
                            
                IPNODE o= new IPview().searchIPById(Integer.parseInt(patid));
                new BillDisplay(name,o.name,patid,o.joining,o.room+"",dateadd,o.amount);
                setVisible(false);
            }
            catch(Exception e)
            {} 
               
            }
            else
            {
                try
                {
                OPNODE o= new OPview().searchOPById(Integer.parseInt(patid));
                new OutPatientBillDisplay(name,o.name,patid,o.amount+"");
                setVisible(false);
            }
            catch(Exception e)
            {}
                
            }
         }
     }
    }
    
    /*public static void main(String args[])
    {
     String n="xyz";
     new BillingInput(n);
    }*/
}






