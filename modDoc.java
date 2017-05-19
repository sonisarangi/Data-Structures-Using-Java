
import java.io.*;
import java.util.*;
class modDoc
{
    
    private DrAvai list = new DrAvai();
    DRNODE temp = list.list.doctor.list;
    int chk;
    public modDoc(int n) throws FileNotFoundException
    {        
        while(temp.right != null && !(temp.regno == n))
        {
            temp = temp.right;
        }
        chk = n;
//         if(temp.regno == n)
//         {
//             return temp;
//         }
//         else
//         {
//             return null; 
//         }
    }
    public DRNODE getDocDet()
    {
        return temp;
    }
    
    private String infi = "doctor.txt";
        public String modify(String dr,int id,String sp,String q,int h) throws IOException
    {
        if(id== chk)
        {
        String temp = "0"+id + ".txt";
        
        PrintWriter doc = new PrintWriter(temp);
        doc.println(dr);
        doc.println(sp);
        doc.println(q);
        doc.println(h);
        doc.println(h*1500*4);
        doc.close();
        //list.list.doctor.dn(dr);
        //list.list.doctor.oi(dr,id,sp,q,h);
        list.list = new LoadDoc();
     return "Doctor modified Successfully";
    }
    else
    {
        return "Cannot change Id";
    }
    }
}