import java.io.*;
import java.util.*;
public class DrAvai
{
    
    LoadDoc list = new LoadDoc();
    DrAvai() throws FileNotFoundException
    {
    }
    public String [][] getDoc() throws FileNotFoundException
    {
        
        String a[][] = list.doctor.getArray();
        return a;
    }
    public DRNODE searchDocByName(String name) throws FileNotFoundException
    {
        DRNODE temp = list.doctor.list;
        String x = temp.name;
        while(temp.right != null && !(x.equalsIgnoreCase(name)))
        {
            temp = temp.right;
            x=temp.name;
        }
        if(x.equalsIgnoreCase(name))
        {
               /* System.out.println("Name                    : "+temp.name);
                System.out.println("Registration Number : "+temp.regno);
                System.out.println("Speciality              : "+temp.speciality);
                System.out.println("Qualification           : "+temp.qualific);                
                System.out.println("Hours of work           : "+temp.hrs);
                System.out.println("Salary                  : Rs "+temp.salary);
                System.out.println("\n");*/
                return temp;
        }
        else
        {
            return null; 
        }
    }
    public DRNODE searchDocById(int n) throws FileNotFoundException
    {
        DRNODE temp = list.doctor.list;
        while(temp.right != null && !(temp.regno == n))
        {
            temp = temp.right;
        }
        if(temp.regno == n)
        {
              /*  System.out.println("Name                    : "+temp.name);
                System.out.println(" Registration Number : "+temp.regno);
                System.out.println("Speciality              : "+temp.speciality);
                System.out.println("Qualification           : "+temp.qualific);                
                System.out.println("Hours of work           : "+temp.hrs);
                System.out.println("Salary                  : Rs "+temp.salary);
                System.out.println("\n");*/
                return temp;
        }
        else
        {
            return null; 
        }
    }    
}