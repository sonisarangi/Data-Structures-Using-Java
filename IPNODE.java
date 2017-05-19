import java.util.*;
class IPNODE
{
	String name;
	int ipid;
	String disorder;
	String department;
	int amount;
	DRNODE doc;
	String joining;
	int room;
	int hrsinICU;
	IPNODE right;
	IPNODE left;
   	IPNODE(String s,String t,int id,DRNODE dc,String j,int hrs,int rm)
	{
	    name=s;
       disaorder=t;
       ipid=id;
       doc=dc;
		 joining=j;
		 hrsinICU = hrs;
		 room = rm;
		 amount =  room*100+ hrs*100+ dc.salary/100;
		right = null;
		left = null;
	}
}
