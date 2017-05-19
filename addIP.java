import java.io.*;
import java.util.*;
public class addIP
{
    addIP()throws FileNotFoundException
    {
    }
    private IPview list = new IPview();
    private String name;
    private int id;
    private String infi = "ip.txt";
    public String addNew(String s,String t,int id,int dc,String j,int hrs, int rm) throws IOException
    {
         if(!(list.searchIPById(id)==null))
             return "Register number already in records";
        FileWriter write = new FileWriter(infi,true);
        PrintWriter out = new PrintWriter(write);
        String temp = "1"+id + ".txt";
        out.println(id);
        out.close();
        PrintWriter ipd = new PrintWriter(temp);
        ipd.println(s);
        ipd.println(t);
        DRNODE doc = new DrAvai().searchDocById(dc);
        ipd.println(doc.regno);
        ipd.println(j);
        ipd.println(hrs);
        ipd.println(rm);
        
        ipd.close();
        list.list.ip.oi(s,t,id,doc,j,hrs,rm);        
        return "In-Patient Added Successfully";
    }
}