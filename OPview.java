import java.io.*;
import java.util.*;
public class OPview
{
    
    Loadop list = new Loadop();
    OPview() throws FileNotFoundException
    {
    }
    public String [][] getop() throws FileNotFoundException
    {
        return list.op.getArray();
    }
    public OPNODE searchOPByName(String name) throws FileNotFoundException
    {
        OPNODE temp = list.op.list;
        String x = temp.name;
        while(temp.right != null && !(x.equalsIgnoreCase(name)))
        {
            temp = temp.right;
            x=temp.name;
        }
        if(x.equalsIgnoreCase(name))
        {
//                 System.out.println("Name                    : "+temp.name);
//                 System.out.println("OPID                    : "+temp.opid);
//                 System.out.println("Disorder              : "+temp.disorder);
//                 System.out.println("\n");
                return temp;
        }
        else
        {
            return null; 
        }
    }
    public OPNODE searchOPById(int n) throws FileNotFoundException
    {
        OPNODE temp = list.op.list;
        if(temp == null)
            return null;
        while(temp.right != null && !(temp.opid == n))
        {
            temp = temp.right;
        }
        if(temp.opid == n)
        {
//                 
//                 System.out.println("Name                    : "+temp.name);
//                 System.out.println("OPID                    : "+temp.opid);
//                 System.out.println("Disorder             : "+temp.disorder);
//                 System.out.println("\n");
                return temp;
        }
        else
        {
            return null; 
        }
    }    
}