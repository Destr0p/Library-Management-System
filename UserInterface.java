import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    
    public class UserInterface {
    	public static void main(String [] args)
    	{
    
    	    Scanner sc=new Scanner(System.in);
    		BookUtility ans = new BookUtility();
    		System.out.println("Enter the number of entries");
    		int a = Integer.parseInt(sc.nextLine());
    		System.out.println("Enter the bookId/bookName/bookType/bookCategory/bookEdition");
    		String []x=new String[a];
    		List<Book> clm= new ArrayList<Book>();
    		boolean flag=false;
    		for(int j=0;j<a;j++){
    		    x[j]=sc.nextLine();
    		    String[] p=x[j].split("/");
    		    Book cd=new Book();
    		    cd.setBookId(p[0]);
    		    cd.setBookName(p[1]);
    		    cd.setBookType(p[2]);
    		    cd.setBookCategory(p[3]);
    		    cd.setBookEdition(p[4]);
    		    try{
    		        ans.toValidateBookType(cd);
    		        clm.add(cd);
    		    }catch(InvalidBookException e){
    		        flag=true;
   		        System.out.println(e.getMessage());}
    		}if(flag==false){
    		    ans.setBookList(clm);
    		    System.out.println("Print the book details");
    		    for(int y=0;y<clm.size();y++){
    		        System.out.println("bookId="+clm.get(y).getBookId()+", bookName="+clm.get(y).getBookName()+", bookType="+clm.get(y).getBookType());
    		    }
    		    System.out.println("Enter book name to search");
    		    String hh=sc.nextLine();
    		    ans.setSearchBookName(hh);
    		    Thread myThread=new Thread(ans);
    		    myThread.run();
    		}
    	}
    }
    
