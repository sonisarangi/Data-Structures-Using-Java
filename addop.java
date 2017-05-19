import java.io.*;
import java.util.*;
public class addop
{
    addop()throws FileNotFoundException
    {
    }
    private OPview list = new OPview();
    private String name;
    private int i;
    private String infi = "op.txt";
    public String addNew(String name,int i,String dp, int dc) throws IOException
    {
        if(!(list.searchOPById(i)==null))
            return "Register number already in records";
        FileWriter write = new FileWriter(infi,true);
        PrintWriter out = new PrintWriter(write);
        String temp = "2" + i + ".txt";
        out.println(i);
        out.close();
        PrintWriter opd = new PrintWriter(temp);
        opd.println(name);
        opd.println(dp);        
        
        DRNODE doc = new DrAvai().searchDocById(dc);
        
        opd.println(doc.regno);
        opd.close();
        list.list.op.oi(name,i,dp,doc);        
        return "Out-Patient Added Successfully";
    }
}