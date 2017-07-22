import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
class Book 
{   
    String bookName,author;
    int bookId,noOfCopies;
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public int getNoOfCopies() {
        return noOfCopies;
    }
    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

}


class Student
{  
    ArrayList<Book> stubookList=new ArrayList<Book>(5);
    String sname="";
    int sid,nob;
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getNob() {
        return nob;
    }
    public void setNob(int nob) {
        this.nob = nob;
    }
    public void setstubookList(Book b)
   { 
       stubookList.add(b);
   }
    public ArrayList<Book> getstubookList()
   { 
       return stubookList;
   }
}



class Lib
{
    public static void main(String args[])
    {    
  LibraryImpl l1= new LibraryImpl();
        int ch=0;
        
        System.out.println("\t\t\tWelcome to the Library\n");
       
        do
        {

            System.out.println("\t\t\t----------------Menu---------------\n");
            System.out.println("1.-->Add Books");
            System.out.println("2.-->Add Student");        
            System.out.println("3.-->Issue books");
            System.out.println("4.-->Return books");
            System.out.println("5.-->Search book");
            System.out.println("6.-->Student Details\n");  
            System.out.println("7.-->Close the Menu\n");
            System.out.println("Enter ur choice");
            Scanner s=new Scanner(System.in);
            ch=s.nextInt();
            switch(ch)
            {
             
            case 1:
                l1.addbooks();
                break;
            case 2:
                l1.addstudent();
                break;
            case 3:
                l1.issuebooks();
                break;
            case 4:
                l1.returnbooks();
                break;
            case 5:
                l1.searchbooks();
                break;
            case 6:
                l1.studdet();
                break;
             case 7:
                 System.exit(0);   
             default:
                    System.out.println("Wrong choice");
                 
            }

        }while((ch>0) && (ch<8));
    }

}




class LibraryImpl 
{      
     //DECLARING COLLECTION OF BOOKS

    ArrayList<Book> bookList=new ArrayList<Book>();
       
     //COLLECTION OF STUDENTs

    ArrayList<Student> stuList=new ArrayList<Student>();
    //Student s1[]=new Student[15];
    //Book b1[]=new Book[15];
       static int i=0,j=0;
    public void addbooks()
    {      
          
        Book b1=new Book();
        System.out.println("Enter the name of the book");
        Scanner scn=new Scanner(System.in);
        String name=scn.nextLine();
        b1.setBookName(name);
        System.out.println("Enter book id");
        int id=scn.nextInt();
        b1.setBookId(id);
        System.out.println("Enter author");
        String author=scn.next();
        b1.setAuthor(author);
        System.out.println("Enter the  no of copies  of the respective book");
        int copies=scn.nextInt();
        b1.setNoOfCopies(copies); 

        //ADDING BOOKS TO THE THE ARRAY LIST
        
        bookList.add(b1);
        //i++; 
    }

    public void addstudent()
    { 
        Student s1=new Student();  
        
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter the name ");
        String name=sc1.nextLine();
        s1.setSname(name);
        System.out.println("Enter student id");
        int id=sc1.nextInt();
        s1.setSid(id);
        System.out.println("\t\tThe student can issue a maiximum of five books"); 
        s1.setNob(0); 

        //ADDING STUDENT TO THE THE ARRAY LIST 

        stuList.add(s1);
         //j++;      
    }


    public void issuebooks()
    {   
       int l=0,t=0;  
      
        System.out.println("Enter book id");    
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();      
       for(Book b:bookList)
        {
            if(b.getBookId()==id)
            {
                 t++;
                if(b.getNoOfCopies()== 0)//checking the availibilty of book
                   
                System.out.println("Book not available");
               
                  else
                  
                   l=checkStud(b);        
            } 
       if(l!=0)
         break;
}
if(t==0){System.out.println("\tThe Book has not been added to the library");}
}

    public int checkStud(Book obj)
    { 
       
       int cpy,count=0,y=0;
        System.out.println("Enter student id");     
        Scanner sc2=new Scanner(System.in);
        int sid=sc2.nextInt();
        for(Student st1:stuList)
        {
            if(st1.getSid()==sid)
            { 
             y++;
            // System.out.println("Enter the no. of copies u want to issue for this book"); 
            // cpy=sc2.nextInt();   
             if( (st1.getNob()< 5) && (obj.getNoOfCopies() > 0))
                {
                    System.out.println("\t\tBook Issued");
                     st1.setNob(st1.getNob()+1);
                     obj.setNoOfCopies(obj.getNoOfCopies()-1);
                     st1.setstubookList(obj);
                    count++;
                    return count; 
                    }
                else
                    {
               System.out.println("Only 5 books can be issued OR we dont have no. of copies of book you inquired for! \n");
                return 0;
                } 

}
        }
     if(y==0){System.out.println("\tThe Student with the given id has not been registered \n\t If you wish to add , select Option '2' from Menu Thanks !\n ");} return 0 ;
}

    public void returnbooks()
    { 
        int r,b=0;
        Scanner sc3=new Scanner(System.in);
      // System.out.println("\tEnter the number of Books you want to return\n");
      //  int u=sc3.nextInt();
      //  r=u;
      //   while(u>0)
        
        System.out.println("Enter the  book id\t");    
        int id=sc3.nextInt();
        for(Book b2:bookList)
        {
            if(b2.getBookId()==id)
            {   
                b++;
                callStud(b2);
                b2.setNoOfCopies(b2.getNoOfCopies()+1);
                    
            break;
                     }
          }
         // u--;
           if(b==0){System.out.println("\tThe Book has not been added to the library\n");}
     b=0;
        }
    public void callStud(Book b2)
    {
       int v=0;
        System.out.println("Enter the Student's id");     
        Scanner scn=new Scanner(System.in);
        int sid=scn.nextInt();
              
         for(Student st2:stuList)
        {
            if(st2.getSid()==sid)
            {   
                 v++;
                 if(st2.getNob()>0 && (st2.getstubookList()).contains(b2))
                   {
                     System.out.println("Book Returned");
                    st2.setNob(st2.getNob()-1);
                    (st2.getstubookList()).remove(b2);
                    break;
                    }
                    else System.out.println("\tThe Student has not issued any books OR The student has not issued this respective book\n ");
                }
            
            }
     if(v==0)   
     System.out.println("\tThe Student with the given id has not been registered\n");
                   
        }

    public void searchbooks()
    {  
        int f=0,p=0;   
        Scanner sc5=new Scanner(System.in);   
        System.out.println("Do you want to Search the Book by it's Name Or by it's Id\n");
        System.out.println("Press 1 to search by Book Name\n\t2 to search by Book Id\n");
        System.out.println("Enter you choice");
        int ch=sc5.nextInt();
        if(ch==1)
         {
         System.out.println("Enter the Book's Name :");
        String name=sc5.next();
        for(Book b3:bookList)
        {
            if(b3.getBookName().equalsIgnoreCase(name))
            { 
                p++;
                System.out.println("Book ID\t\tAuthor Name\tNo.ofCopies");
                System.out.println(b3.getBookId()+"\t\t"+b3.getAuthor()+"\t\t"+b3.getNoOfCopies());
                break;
                 }
                   }
              if(p==0){System.out.println("\tThe Book has not been added to the library\n\tIf you wish to add , select Option '1' from Menu Thanks !\n");  }       
            }

            else if(ch==2)
            {
              System.out.println("Enter the Book's ID :");
             int ID=sc5.nextInt();
             for(Book b3:bookList)
        {
          if(b3.getBookId()==ID)
             { 
              f++; 
              System.out.println("Book Name\tAuthor Name\tNo.ofCopies");
                System.out.println(b3.getBookName()+"\t\t"+b3.getAuthor()+"\t\t"+b3.getNoOfCopies());
                break;
                 }
                   }
                 if(f==0){System.out.println("\tThe Book has not been added to the library\n\tIf you wish to add , select Option '1' from Menu Thanks !\n");}
              }
            
    }

        public void studdet()
{
    int u=0;
    Scanner nn=new Scanner(System.in); 
   System.out.println("Enter the Student's id");
   int id=nn.nextInt();
    for(Student stud:stuList)
   {
   if(stud.getSid()==id)
    {
    u++;
    System.out.println("Student Name\t\tNo. of Books Issued\t\t Books Issued\n");
   ArrayList<Book> bL=stud.getstubookList();
    System.out.print(stud.getSname()+"\t\t\t\t"+stud.getNob()+"\t\t\t\t");
    bL.forEach((b) -> System.out.print(b.getBookName() + ","));
    System.out.println();
     break;
  }
   }
    if(u==0){System.out.println("\tThe Student with the given id has not been registered \n\t If you wish to add , select Option '2' from Menu Thanks !\n ");}
    }
     }