import java.io.*;
import java.util.*;
public class addUser
{
    private String username;
    private String password;
    private String infi = "pass.txt";
    public addUser(String u, String p) throws IOException
    {
        FileWriter write = new FileWriter(infi,true);
        PrintWriter out = new PrintWriter(write);
        out.println(u);
        out.println(p);
        out.close();
        //return "User Added Successfully";
    }
}