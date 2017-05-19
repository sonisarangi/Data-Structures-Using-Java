import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;


class PatientModifySubmitIn extends JFrame implements ActionListener
{

    JLabel lmain,lpi,lname,ladd,ltel,lmi,lbg,ldob,lhis,lcur,lpno,lroom,ldate,lgender,lrtype,ldtip,ldtip2,licu,ldocname,ldateadd,ldid;
    JTextField tfname,tftel,tfdob,tfpno,tficu,tfroom,tfdocname;
    TextArea taadd,tahis,tacur;
    Choice chbg,chrt;
    CheckboxGroup cbmf;
    Checkbox cbm,cbf;
    JButton bsub,bclr,bback,bhome;
    String name1,tel,dob,pno,room,dateadd,docname,add,cur,bloodgp,rt;
    int hrs;
        String dialogmessage;
    String dialogs,joi;
     int dialogtype = JOptionPane.PLAIN_MESSAGE;
     String name;



PatientModifySubmitIn(String x, String name2,String ipid,String admis,String doctname,String disability,int hrs)
{
    super("Logged in as " +x);
    name=x;
    setSize(1024,768);
    setVisible(true);
    setLayout(null);
    joi = admis;
    pno = ipid;
// PERSONAL INFORMATION

    lmain=new JLabel("Modify InPatient Information");
    lmain.setBounds(40,40,200,20);
    add(lmain);
    
    lname=new JLabel("Name* :");
    lname.setBounds(104,97,80,25);
    add(lname);

    tfname=new JTextField(30);
    tfname.setBounds(270,97,250,20);
    add(tfname);

    ladd=new JLabel("Address :");
    ladd.setBounds(104,138,70,15);
    add(ladd);

    taadd=new TextArea();
    taadd.setBounds(270,138,250,100);
    add(taadd);

    licu=new JLabel("Contact :");
    licu.setBounds(575,138,50,25);
    add(licu);
    
    tficu=new JTextField(30);
    tficu.setBounds(640,138,250,20);
    add(tficu);

    lpno=new JLabel("Patient No.* :");
    lpno.setBounds(570,97,80,25);
    add(lpno);

    ldid=new JLabel(ipid);
    ldid.setBounds(653,97,50,20);
    add(ldid);

    licu=new JLabel("ICU Hrs.:");
    licu.setBounds(720,97,60,20);
    add(licu);

    tficu=new JTextField(30);
    tficu.setBounds(788,97,60,20);
    add(tficu);
    
    
    ldate=new JLabel("Date Of Admission*  :");
    ldate.setBounds(575,160,120,25);
    add(ldate);

     ldateadd=new JLabel(admis);
     ldateadd.setBounds(696,160,80,25);
     add(ldateadd);
            
    ldtip2=new JLabel("(dd-mm-yyyy)");
    ldtip2.setBounds(782,160,100,25);
    add(ldtip2);

    
    lgender=new JLabel("Gender :");
    lgender.setBounds(596,223,50,15);
    add(lgender);


    
    cbmf=new CheckboxGroup();
    cbm=new Checkbox("Male",cbmf,true);
    cbf=new Checkbox("Female",cbmf,false);
    cbm.setBounds(698,223,50,15);
    add(cbm);
    cbf.setBounds(760,223,60,15);
    add(cbf);
    
    

    // End of personal information
    
    //Medical Information

    lmi=new JLabel("Add Medical Information");
    lmi.setBounds(40,268,160,15);
    add(lmi);
    
    lbg=new JLabel("Blood Group :");
    lbg.setBounds(104,306,79,15);
    add(lbg);

    chbg=new Choice();
    chbg.setBounds(270,306,53,15);
    chbg.addItem("A -ve");
    chbg.addItem("A +ve");
    chbg.addItem("B -ve");
    chbg.addItem("B +ve");
    chbg.addItem("AB -ve");
    chbg.addItem("AB +ve");
    chbg.addItem("O +ve");
    chbg.addItem("O -ve");
    add(chbg);
    
    /*ldob=new JLabel("Date of Birth :");
    ldob.setBounds(575,306,120,15);
    add(ldob);

    tfdob=new JTextField(15);
    tfdob.setBounds(696,305,80,20);
    add(tfdob);


    ldtip=new JLabel("(dd-mm-yyyy)");
    ldtip.setBounds(782,305,100,20);
    add(ldtip);*/

    lhis=new JLabel("Previous History :");
    lhis.setBounds(104,365,50,15);
    add(lhis);

    tahis=new TextArea();
    tahis.setBounds(270,365,250,100);
    add(tahis);

    lcur=new JLabel("Current Distory* :");
    lcur.setBounds(575,365,120,15);
    add(lcur);

    tacur=new TextArea();
    tacur.setBounds(720,365,250,100);
    add(tacur);     

    
    ldocname=new JLabel("Attending Doctor :");
    ldocname.setBounds(575,510,130,15);
    add(ldocname);

    tfdocname=new JTextField(100);
    tfdocname.setBounds(720,510,250,20);
    add(tfdocname);

        
    lrtype=new JLabel("Type Of Room : ");
    lrtype.setBounds(104,510,120,25);
    add(lrtype);

    chrt=new Choice();
    chrt.setBounds(270,510,80,15);
    //chrt.addItem("Deluxe");
    chrt.addItem("Special");
    chrt.addItem("Semi-Special");
    chrt.addItem("General");
    add(chrt);

//End of medical Information
   bhome=new JButton("HOME",new ImageIcon("images/branch.png"));
    bhome.setBounds(580,643,100,30);
    add(bhome);
    
    bsub=new JButton("MODIFY",new ImageIcon("images/add.gif"));
    bsub.setBounds(220,643,130,30);
    add(bsub);  

    bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
    bclr.setBounds(360,643,100,30);
    add(bclr);

    bback=new JButton("BACK",new ImageIcon("images/restore.png"));
    bback.setBounds(470,643,100,30);
    add(bback); 
    
    set(name2, doctname,disability,hrs);   //call to a set method

    bclr.addActionListener(new clear());
    bsub.addActionListener(new submit());
    bback.addActionListener(new back());
    bhome.addActionListener(new home());


    
}

//End of constructor

    

public void actionPerformed(ActionEvent ae)
    {}



class clear implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            tfname.setText("");
            tficu.setText("");
            tfdob.setText("");
            taadd.setText("");
            tahis.setText("");
            tacur.setText("");
            tfpno.setText("");
            tfroom.setText("");
            tfdocname.setText("");
        }
    }


class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new PatientModifyIn(name);
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
      hrs=Integer.parseInt(tficu.getText().trim());
      //dob=tfdob.getText().trim();
      //pno=tfpno.getText().trim();
      //room=tfroom.getText();
      docname=tfdocname.getText().trim();
      add=taadd.getText().trim();
      cur=tacur.getText().trim();
      bloodgp=(String)chbg.getSelectedItem();
      rt=(String)chrt.getSelectedItem();
      
      if((name1.equals(""))||(docname.equals(""))||(cur.equals("")))
      {
       new ErrorDialog1();
      }
      else
      {
        try
          {
              int rm=10;
              if(rt.equals("Special"))
            rm = 10;
         else if(rt.equals("Semi-Special"))
            rm = 5;
            else if(rt.equals("General"))
                rm = 1;
              DRNODE doc = new DrAvai().searchDocByName(docname);
              int id = doc.regno;
              //String s,String t,int id,int dc,String j,int hrs, int rm
          String message = new modIP(Integer.parseInt(pno)).modify(name1,cur,Integer.parseInt(pno),id,joi,hrs,rm );
          JOptionPane.showMessageDialog(new JFrame(), message, "DONE!!!", JOptionPane.INFORMATION_MESSAGE);
                   new PatOptionsIn(name);
         setVisible(false);
        }
        catch(Exception e)
        {} 
         
        //setVisible(false);
      }
     }
    }
    
    public void set(String name2,String doctname,String disability,int hrs)
    {
         tfname.setText(name2);
            tacur.setText(disability);
            tfdocname.setText(doctname);
            tficu.setText(hrs+"");
     
    }
    
    /*public static void main(String[] args)
    {
     String n="xyz";
        new PatientModifySubmitIn(n,"sonik","9663576273","19-11-1996","fghjk","ghjkl");
        
    }*/

}       
        






