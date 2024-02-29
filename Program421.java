// Customised Database Management System

class node
{
    private static int Counter = 1;
    public Integer Rno;
    public String Name;
    public String City;
    public Integer Marks;

    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter++;
       
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    // Display
    // select * from student
    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }
    //select * from student where city = 'pune';
     public void SelectStarFromWhereCity(String str)
    {
        System.out.println("Data from the student table is  where city is : "+str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(str.equals(temp.City))
            {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }
    //select Count(marks) from student
    public void SelectCount()
    {
        node temp = first;
        int icnt = 0;

        while(temp != null)
        {
            temp = temp.next;
            icnt++;
        }
        System.out.println("Number of Records in the table :"+icnt);
    }
    //select Sum(marks) from student
    public void SelectSum()
    {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }
        System.out.println("Summation of Marks Column is :"+iSum);
    }
    ////select Avg(marks) from student
    public void SelectAvg()
    {
        node temp = first;

        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Average of Marks Column is :"+(float)((float)iSum/(float)iCnt));
    }
    ////select Min(marks) from student
    public void SelectMinMarks()
    {
        node temp = first;
        int iMin = temp.Marks;

        while(temp != null)
        {
            if(temp.Marks < iMin)
            {
                iMin = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Minimum Marks are :"+iMin);
    }
    //select Max(marks) from student
    public void SelectMaxMarks()
    {
        node temp = first;
        int iMax= temp.Marks;

        if(temp != null)
        {
            iMax = temp.Marks;
        }
        while(temp != null)
        {
            if(temp.Marks > iMax )
            {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Maximum Marks are :"+iMax);
    }
    //select * from student where name = "______";
    public void  SelectStarFromName(String str)
    {
        node temp = first;
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Information of all the students with the name :"+str);
        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);

            }
            temp = temp.next;
        }
         System.out.println("-------------------------------------------------------------------");

    }
     //update student set city = "_____" where Rno = _____;
     public void UpdateCity(int No , String str)
     {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == No)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        //SelectStarFrom();

        System.out.println("Record Gets Updated...");
     }

     public void Describe()
    {

        System.out.println("-------------------------------------------------------------");
        System.out.println("Column Name \t datatype");
        System.out.println("Rno"+"\t\t"+first.Rno.getClass().getSimpleName());
        System.out.println("Name"+"\t\t"+first.Name.getClass().getSimpleName());
        System.out.println("City"+"\t\t"+first.City.getClass().getSimpleName());
        System.out.println("Marks"+"\t\t"+first.Marks.getClass().getSimpleName());
        System.out.println("--------------------------------------------------------------");
    }
    //delete from student where Rno = "______";
    public void DeleteFrom(int no)
    {
        node temp = first;
       
        //if linkedlis is empty
        if(temp == null)
        {
            return;
        }
        //if first node is the targeted node
        if(temp.Rno == no)
        {
            first = first.next;
            return;
        }
        while(temp.next != null)
        {
            if(temp.next.Rno == no)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record Deleted Successfully!!");

    }

     public void MarksBetween(int iNo1 , int iNo2)
    {
        node temp = first;
        System.out.println("----------------------------------------------------------");
        System.out.println("Record Between the range\t"+iNo1+"and\t"+iNo2+"\tis:");
        System.out.println("Name\tMarks");
        while(temp != null)
        {
            if(temp.Marks >= iNo1 && temp.Marks <= iNo2)
            {
              //  System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks+"\t");
              
              System.out.println(temp.Name+"\t"+temp.Marks+"\t");
            }
            temp = temp.next;
        }
         System.out.println("----------------------------------------------------------");
    }
     public void In(String str1 , String str2)
    {
        node temp = first;
        System.out.println("----------------------------------------------------------");
        System.out.println("Records From\t" +str1+ "\tand\t" +str2+ "\tare :");
         System.out.println("Rno\tName");
        while(temp != null)
        {
            if((temp.City == "Pune")||(temp.City == "Mumbai"))
            {
               
                System.out.println(temp.Rno+"\t"+temp.Name+"\t");   
            }
            temp = temp.next;
        }
        System.out.println("----------------------------------------------------------");


    }

    


}
class Program421
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Gauri","Pune",90);
        obj.InsertIntoTable("Amit","Nagar",81);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);

        obj.SelectStarFrom();

        obj.SelectStarFromWhereCity("Pune");

        obj.SelectCount();

        obj.SelectSum();

        obj.SelectAvg();

        obj.SelectMinMarks();

        obj.SelectMaxMarks();

        obj.SelectStarFromName("Amit");

        obj.UpdateCity(3,"Nashik");

        obj.SelectStarFrom();

        obj.DeleteFrom(5);

        obj.SelectStarFrom();

        obj.InsertIntoTable("Rukhmini","Kolhapur",77);

        obj.SelectStarFrom();

        obj.Describe();

        obj.MarksBetween();

        obj.In();
    }
}




/*
Supported Queries

1 : Insert into Student values('amit','pune',78);
2 : select * from student;
3 : select * from student where city = '______';
4 : select count(Marks) from student;
5 : select
6 :
7: 
8 :
9 : select * from student where name = "______";
10 : update student set city = "_____" where Rno = _____;
11 : delete from student where Rno = "______";
*/ 