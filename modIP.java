import java.io.*;
import java.util.*;
class modIP
{
    
    private IPview list = new IPview();
    IPNODE temp = list.list.ip.list;
    int chk;
    public modIP(int n) throws FileNotFoundException
    {        
        while(temp.right != null && !(temp.ipid == n))
        {
            temp = temp.right;
        }
        chk = n;
    }
    public IPNODE getIPDet()
    {
        list.list.ip.display();
        return temp;
    }
    
    private String infi = "ip.txt";
        public String modify(String s,String t,int id,int dc,String j,int hrs, int rm) throws IOException
    {
        if(id== chk)
        {
         //FileWriter write = new FileWriter(infi,true);
        //PrintWriter out = new PrintWriter(infi);
        String temp = "1"+id + ".txt";
        //out.println(id);
        //out.close();
        PrintWriter ipd = new PrintWriter(temp);
        ipd.println(s);
        ipd.println(t);
        DRNODE doc = new DrAvai().searchDocById(dc);
        ipd.println(doc.regno);
        ipd.println(j);
        ipd.println(hrs);
        ipd.println(rm);
        ipd.close();
        list.list = new LOADIP();
         return " Modified Successfully";
    }
    else
    {
        return "Can't Modify";
    }
    }
}