class OPLIST
{
    OPNODE list;
    OPLIST()
    {
        list= null;
    }
    void fi(String s,int i,String dp, DRNODE dc)
    {
        OPNODE node = new OPNODE(s,i,dp,dc);
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
    void ei(String s,int i,String dp, DRNODE dc)
    {
        OPNODE node = new OPNODE(s,i,dp,dc);
        if(list == null)
        {
            list = node;
            node.right = node.left = null;
        }
        else
        {
            OPNODE temp = list;
            while(temp.right != null)
            {
                temp = temp.right;
            }
            temp.right = node;
            node.left = temp;
            node.right = null;
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
            OPNODE temp = list;
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
            OPNODE temp = list;
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
    void oi(String s,int i,String dp, DRNODE dc)
    {
        OPNODE node = new OPNODE(s,i,dp,dc);
        if(list == null)
        {
            list = node;
        }
        else if (i < list.opid) //FI
        {
            list.left = node;
            node.right = list;
            list = node;
        }
        else
        {
            OPNODE temp = list;
            while(temp.right != null && i>temp.opid)
            {
                temp = temp.right;                      
            }
            if(i<= temp.opid)
            {
                node.left = temp.left;
                node.left.right = node;
                node.right = temp;
                temp.left = node;
            }
            else if(temp.right == null)
            {
                temp.right = node;
                node.left = temp;
                node.right = null;
            }
        }
    }
        
        void display()
    {
        OPNODE temp = list;
        if(list == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            System.out.println("The list of Out-Patients is");
            while(temp != null)
            {
                System.out.println("Name                    : "+temp.name);
                System.out.println("OPID                    : "+temp.opid);
                System.out.println("Disorder             : "+temp.disorder);             
                System.out.println("\n");
                temp = temp.right;
            }
        }
    }
         void dn(String op)
    {
        if(list == null)
        {
            System.out.println("EMPTY");
        }
        else if(op == list.name)
        {
            fd();
        }
        else
        {
            OPNODE temp = list;
            while(temp.right != null && temp.name!= op)
            {
                temp = temp.right;
            }
            if(temp.name == op && temp.right!= null)
            {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
            }
            else if(temp.name == op && temp.right == null)
            {
                ed();
            }
            else
            {
               // System.out.println("NnF");
            }
        }
    }
        String a[][]= new String [10][3];
    String [][] getArray()
    {
        OPNODE temp = list;
        int i=0,n=0;
        if(list != null)
        {
            while(temp != null)
            {
                temp = temp.right;
                n++;
            }
            a = new String [n][3];
            temp = list;
            while(temp != null)
            {
                a[i][0] = (temp.opid+ "");
                a[i][1] = temp.name;
                a[i][2] = temp.doc.name;
                temp = temp.right;
                i++;
            }
        }
        return a;
    }
}
