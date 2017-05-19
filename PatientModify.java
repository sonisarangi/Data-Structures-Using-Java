import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PatientModify extends JFrame implements ActionListener
{
 JLabel lpatid;
 JButton bsub,bback,bclr;
 JTextField tfpatid;
 String patid;
 String name;
 
 PatientModify(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(400,400);
  setVisible(true);
  setLayout(null);

  lpatid=new JLabel("Enter Patient Id");
  lpatid.setBounds(100,100,180,20);
  add(lpatid);
  
  tfpatid=new JTextField(30);
  tfpatid.setBounds(200,100,100,20);
  add(tfpatid);
  
  bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
  bclr.setBounds(160,180,100,30);
  add(bclr);
  
  bsub=new JButton("SUBMIT",new ImageIcon("images/backup.png"));
  bsub.setBounds(100,220,100,30);
  add(bsub);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(220,220,100,30);
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
            new  PatOptions(name);
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
             try
             {
             Loadop load = new Loadop();
             OPNODE pat = new OPview().searchOPById(Integer.parseInt(patid));
             if(pat != null)
             {                 
             new PatientModifySubmit(name,pat.name,pat.opid+"",pat.disability,pat.doc.name+"");
             setVisible(false);
            }
            
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Patient not found", "SORRY", JOptionPane.ERROR_MESSAGE);
            }
         }
         catch(Exception e)
         {JOptionPane.showMessageDialog(new JFrame(), "Patient not found", "SORRY", JOptionPane.ERROR_MESSAGE);}
         }
     }
    }
    
    /*public static void main(String args[])
    {
     String n="xyz";
     new PatientDetails(n);
    }*/
}






