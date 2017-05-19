import java.io.*;
import java.util.*;
public class LOADIP
{
    public IPLIST ip = new IPLIST();
    private String name,ds;
    private int id;
    private DRNODE dc;
    private String j;
    private String infi = "ip.txt";
    public LOADIP() throws FileNotFoundException
    {
        FileReader read = new FileReader(infi);
        Scanner in= new Scanner(read);
        while(in.hasNextLine())
        {
            id = Integer.parseInt(in.nextLine());
            String temp = "1" + id + ".txt";
            FileReader readDet = new FileReader (temp);
            Scanner indet = new Scanner(readDet);
                    
            name = indet.nextLine();
            ds = indet.nextLine();
            int tmp = Integer.parseInt(indet.nextLine());
            dc = new DrAvai().searchDocById(tmp);
            j = indet.nextLine();
            int hrs = Integer.parseInt(indet.nextLine());
            int rm = Integer.parseInt(indet.nextLine());
            
            ip.oi(name,ds,id,dc,j,hrs,rm);
        }  
    }
}