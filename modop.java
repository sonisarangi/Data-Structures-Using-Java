import java.io.*;
import java.util.*;
class modop
{
    
    private OPview list = new OPview();
    OPNODE temp = list.list.op.list;
    int chk;
    public modop(int n) throws FileNotFoundException
    {        
        while(temp.right != null && !(temp.opid == n))
        {
            temp = temp.right;
        }
        chk = n;
    }
    public OPNODE getOPDet()
    {
        return temp;
    }
    
    private String infi = "op.txt";
        public String modify(String name,int i,String dp,int dc) throws IOException
    {
        if(i== chk)
        {
        // FileWriter write = new FileWriter(infi,true);
        //PrintWriter out = new PrintWriter(infi);
        String temp ="2"+ i + ".txt";
        //out.println(i);
        //out.close();
        PrintWriter opd = new PrintWriter(temp);
        opd.println(name);
        opd.println(dp);        
        DRNODE doc = new DrAvai().searchDocById(dc);
        
        opd.println(doc.regno);
        opd.close();
        list.list = new Loadop();       
        return "Out-Patient modified Successfully";
    }
    else
    {
        return "Can't Modify";
    }
    }
}