
class USRLIST
{
    USRNODE list;
    USRLIST()
    {
        list= null;
    }
    void fi(String s, String p)
    {
        USRNODE node = new USRNODE(s,p);
        if(list == null)
        {
            list = node;
            node.right = node.left = null;
        }
        else 
        {
            list.left = node;
            node.right = list;
            list = node;
        }
    }
        void fd()
    {
        if(list == null)
        {
            System.out.println("Empty list");
        }
        else if(list.right == null)
        {
            list = null;
        }
        else
        {
            list.right.left = null;
            list = list.right;
        }
    }
    void ed()
    {
        if(list == null)
        {
            System.out.println("Empty list");
        }
        else if(list.right == null)
        {
            list = null;
        }
        else
        {
            USRNODE temp = list;
            while(temp.right != null)
            {
                temp = temp.right;
            }
            temp.left.right = null;
        }
    }
    void pd(int pos)
    {
        if(list == null)
        {
            System.out.println("Empty list");
        }
        else if(list.right == null && pos ==1)
        {
            list = null;
        }
        else if (pos ==1 )
        {
            fd();
        }
        else
        {
            USRNODE temp = list;
            int j=1;
            while(temp.right != null && j<pos)
            {
                temp = temp.right;
                j++;
            }
            if(j==pos)
            {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
            }
            else if (temp.right == null)
            {
                ed();
            }
            else
            {
                System.out.println("INVALID");
            }
        }
    }
    boolean chkUs(String s)
    {
        USRNODE temp = list;
        while(temp.right != null && !(temp.name.equalsIgnoreCase(s)) )
        {
            temp = temp.right;
        }
        if(temp.name.equalsIgnoreCase(s))
        {
            return true;
        }
        return false;
    }
        boolean chkPa(String s)
    {
        USRNODE temp = list;
        while(temp.right != null && !(temp.pass.equalsIgnoreCase(s)) )
        {
            temp = temp.right;
        }
        if(temp.pass.equalsIgnoreCase(s))
        {
            return true;
        }
        return false;
    }
}
