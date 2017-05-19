import java.io.*;
import java.util.*;
public class password
{
    private String username;
    private String password;
    private String infi = "pass.txt";
    private USRLIST admin = new USRLIST();
    public boolean checkPass(String u, String p) throws FileNotFoundException
    {
        FileReader read = new FileReader(infi);
        Scanner in= new Scanner(read);
        while(in.hasNextLine())
        {
            username = in.nextLine();
            password = in.nextLine();
            admin.fi(username,password);
            if(admin.chkUs(u) && admin.chkPa(p))
            {
                return true;
            }
        }  
        return false;
    }
}