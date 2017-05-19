import java.io.*;
import java.util.*;
public class LoadDoc
{
    public DRLIST doctor = new DRLIST();
    private String dr,sp,q;
    private int id,sal,hrs;
    private String infi = "doctor.txt";
    public LoadDoc() throws FileNotFoundException
    {
        FileReader read = new FileReader(infi);
        Scanner in= new Scanner(read);
        while(in.hasNextLine())
        {
        
            id = Integer.parseInt(in.nextLine());
            String temp = "0"+id + ".txt";
            FileReader readDet = new FileReader (temp);
            Scanner indet = new Scanner(readDet);
                    
            dr = indet.nextLine();
            sp = indet.nextLine();
            q = indet.nextLine();
            hrs = Integer.parseInt(indet.nextLine());
            sal = Integer.parseInt(indet.nextLine());

            
            doctor.oi(dr,id,sp,q,hrs);
        }  
    }
}