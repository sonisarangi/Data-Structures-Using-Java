class DRLIST
{
    DRNODE list;
    DRLIST()
    {
        list= null;
    }
    void fi(String s,int i,String sp,String q,int h)
    {
        DRNODE node = new DRNODE(s,i,sp,q,h);
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
    void ei(String s,int i,String sp,String q,int h)
    {
        DRNODE node = new DRNODE(s,i,sp,q,h);
        if(list == null)
        {
            list = node;
            node.right = node.left = null;
        }
        else
        {
            DRNODE temp = list;
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
            DRNODE temp = list;
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
            DRNODE temp = list;
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
    void oi(String s,int i,String sp,String q,int h)
    {
        DRNODE node = new DRNODE(s,i,sp,q,h);
        if(list == null)
        {
            list = node;
        }
        else if (i < list.regno) 
        {
            list.left = node;
            node.right = list;
            list = node;
        }
        else
        {
            DRNODE temp = list;
            while(temp.right != null && i>temp.regno)
            {
                temp = temp.right;                      
            }
            if(i<= temp.regno)
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
    void dn(String dr)
    {
        if(list == null)
        {
            System.out.println("EMPTY");
        }
        else if(dr == list.name)
        {
            fd();
        }
        else
        {
            DRNODE temp = list;
            while(temp.right != null && temp.name!= dr)
            {
                temp = temp.right;
            }
            if(temp.name == dr && temp.right!= null)
            {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
            }
            else if(temp.name == dr && temp.right == null)
            {
                ed();
            }
            else
            {
                //System.out.println("NnF");
            }
        }
    }
    void display()
    {
        DRNODE temp = list;
        if(list == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            System.out.println("The available doctors are");
            while(temp != null)
            {
                System.out.println("Name                    : "+temp.name);
                System.out.println(" Registration Number : "+temp.regno);
                System.out.println("Speciality              : "+temp.speciality);
                System.out.println("Qualification           : "+temp.qualific);                
                System.out.println("Hours of work           : "+temp.hrs);
                System.out.println("Salary                  : Rs "+temp.salary);
                System.out.println("\n");
                temp = temp.right;
            }
        }
    }
    String a[][]= new String [10][3];
    String [][] getArray()
    {
        DRNODE temp = list;
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
                a[i][0] = (temp.regno+ "");
                a[i][1] = temp.name;
                a[i][2] = temp.speciality;
                temp = temp.right;
                i++;
            }
        }
        return a;
    }
}
