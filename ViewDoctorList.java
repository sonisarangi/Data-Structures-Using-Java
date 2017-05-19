import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewDoctorList extends JFrame implements ActionListener
{
 JTable docList;
 JScrollPane jsp;
 JButton bok;
 JLabel ldoc;
 String name;
 String[] colHeads={"Doctor Id","Doctor name","Specilization"};
 LoadDoc load = new LoadDoc();
 String[][] doc = new DrAvai().getDoc();
 
 
 ViewDoctorList(String x)throws Exception
 {
   super("Logged in as " +x);
    name=x;
    setSize(500,500);
    setVisible(true);
    setLayout(null);
    
    ldoc=new JLabel("Doctor List");
    ldoc.setBounds(70,60,100,20);
    add(ldoc);

   docList=new JTable(doc,colHeads);
    docList.setBounds(70,100,350,250);
    add(docList);
    
    jsp=new JScrollPane(docList);
    jsp.setBounds(70,100,350,250);
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
            new  ViewDoctorOptions(name);
            setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {}
    
    /*public static void main(String[] args)
    {
     String n="xyz";
     new ViewDoctorList(n);
    }*/
}
      

   