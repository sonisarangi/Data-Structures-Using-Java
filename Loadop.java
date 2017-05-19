import java.io.*;
import java.util.*;
public class Loadop
{
    public OPLIST op = new OPLIST();
    private String name,dp;
    private int i;
    private String infi = "op.txt";
    public Loadop() throws FileNotFoundException
    {
        FileReader read = new FileReader(infi);
        Scanner in= new Scanner(read);
        while(in.hasNextLine())
        {
            i = Integer.parseInt(in.nextLine());
            String temp = "2" + i + ".txt";
            FileReader readDet = new FileReader (temp);
            Scanner indet = new Scanner(readDet);
                    
            name = indet.nextLine();
            dp = indet.nextLine();
            
                 int tmp = Integer.parseInt(indet.nextLine());
            DRNODE dc = new DrAvai().searchDocById(tmp);      
            op.oi(name,i,dp,dc);
        }  
    }
}