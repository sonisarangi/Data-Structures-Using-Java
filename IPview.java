import java.io.*;
import java.util.*;
public class IPview
{
    
    LOADIP list = new LOADIP();
    IPview() throws FileNotFoundException
    {
    }
    public String[][] getip() throws FileNotFoundException
    {
        
        return list.ip.getArray();
    }
    public IPNODE searchIPByName(String name) throws FileNotFoundException
    {
        IPNODE temp = list.ip.list;
        String x = temp.name;
        while(temp.right != null && !(x.equalsIgnoreCase(name)))
        {
            temp = temp.right;
            x=temp.name;
        }
        if(x.equalsIgnoreCase(name))
        {
                System.out.println("Name                    : "+temp.name);
                System.out.println("ID                      : "+temp.ipid);
                System.out.println("Disorder              : "+temp.disorder);                   
                System.out.println("\n");
                return temp;
        }
        else
        {
            return null; 
        }
    }
    public IPNODE searchIPById(int n) throws FileNotFoundException
    {
        IPNODE temp = list.ip.list;
        while(temp.right != null && !(temp.ipid == n))
        {
            temp = temp.right;
        }
        if(temp.ipid == n)
         {
//                 System.out.println("Name                    : "+temp.name);
//                 System.out.println("ID                      : "+temp.ipid);
//                 System.out.println("Disorder             : "+temp.disorder);
//                 
//                 System.out.println("\n");
                return temp;
        }
        else
        {
            return null; 
        }
    }    
}