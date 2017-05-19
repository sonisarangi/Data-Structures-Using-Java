import java.io.*;
import java.util.*;
public class addDoc
{
    addDoc()throws FileNotFoundException
    {
    }
    private DrAvai list = new DrAvai();
    private String drname;
    private int id;
    private String infi = "doctor.txt";
    public String addNew(String dr,int id,String sp,String q,int h) throws IOException
    {
        if(!(list.searchDocById(id)==null))
            return "Register number already in records";
        FileWriter write = new FileWriter(infi,true);
        PrintWriter out = new PrintWriter(write);
        String temp = "0"+id + ".txt";
        out.println(id);
        out.close();
        PrintWriter doc = new PrintWriter(temp);
        doc.println(dr);
        doc.println(sp);
        doc.println(q);
        doc.println(h);
        doc.println(h*1500*4);
        doc.close();
        list.list.doctor.oi(dr,id,sp,q,h);        
        return "Doctor Added Successfully";
    }
}