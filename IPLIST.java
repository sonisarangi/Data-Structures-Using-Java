class IPLIST
{
    IPNODE list;
    IPLIST()
    {
        list= null;
    }
    void fi(String s,String t,int id,DRNODE dc,String j,int hrs,int rm)
    {
        IPNODE node = new IPNODE(s,t,id,dc,j,hrs,rm);
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
    void ei(String s,String t,int id,DRNODE dc,String j,int hrs,int rm)
   
     {
        IPNODE node = new IPNODE(s,t,id,dc,j,hrs,rm);

        if(list == null)
        {
            list = node;
            node.right = node.left = null;
        }
        else
        {
            IPNODE temp = list;
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
            IPNODE temp = list;
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
            IPNODE temp = list;
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
    void oi(String s,String t,int id,DRNODE dc,String ja,int hrs,int rm)

    {
        IPNODE node = new IPNODE(s,t,id,dc,ja,hrs,rm);

                if(list == null)
        {
            list = node;
        }
        else if (id < list.ipid) //FI
        {
            list.left = node;
            node.right = list;
            list = node;
        }
        else
        {
            IPNODE temp = list;
            while(temp.right != null && id>temp.ipid)
            {
                temp = temp.right;                      
            }
            if(id<= temp.ipid)
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
     void dn(String ip)
    {
        if(list == null)
        {
            System.out.println("EMPTY");
        }
        else if(ip == list.name)
        {
            fd();
        }
        else
        {
            IPNODE temp = list;
            while(temp.right != null && temp.name!= ip)
            {
                temp = temp.right;
            }
            if(temp.name == ip && temp.right!= null)
            {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
            }
            else if(temp.name == ip && temp.right == null)
            {
                ed();
            }
            else
            {
               // System.out.println("NnF");
            }
        }
    }
        void display()
    {
        IPNODE temp = list;
        if(list == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            System.out.println("The In-Patients are");
            while(temp != null)
            {
                System.out.println("Name                    : "+temp.name);
                System.out.println("Patient Id :            : "+temp.ipid);
                System.out.println("Disorder              : "+temp.disorder);
                System.out.println("Consulting Doctor     : "+temp.doc.name);                  
                System.out.println(" Reg number          : "+temp.doc.regno);                
                System.out.println("Room Type               : "+temp.room);
                System.out.println("Hours in ICU            : "+temp.hrsinICU);
                System.out.println("Amount                  : Rs "+temp.amount);
                System.out.println("\n");
                temp = temp.right;
            }
        }
    }
    String a[][]= new String [10][3];
    String [][] getArray()
    {
        IPNODE temp = list;
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
                a[i][0] = (temp.ipid+ "");
                a[i][1] = temp.name;
                a[i][2] = temp.doc.name;
                temp = temp.right;
                i++;
            }
        }
        return a;
    }
}
