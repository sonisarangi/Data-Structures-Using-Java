class DRNODE
{
	String name;
	int regno;
	String speciality;
	String qualific;
	int salary;
	int hrs;
	DRNODE right;
	DRNODE left;
	DRNODE(String s,int i,String sp,String q,int h)
	{
	    name=s;
		regno = i;
		speciality = sp;
		hrs = h;
		qualification = q;
		salary = h*1500*4;
		right = null;
		left = null;
	} 
}
