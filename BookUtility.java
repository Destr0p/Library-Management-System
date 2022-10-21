import java.util.ArrayList;
     import java.util.List;
     
     public class BookUtility implements Runnable{
     	private List<Book> bookList = new ArrayList<Book>();
     	private String searchbookName;
     	private int counter;
         public List<Book> getBookList(){return this.bookList;}
         public String getSearchBookName(){return this.searchbookName;}
        public int getCounter(){return this.counter;}
        void setBookList(List<Book> bookList){this.bookList=bookList;}
        void setSearchBookName(String searchbookName){this.searchbookName=searchbookName;}
        void setCounter(int counter){this.counter=counter;}
    	
    	public void toValidateBookType(Book obj)throws InvalidBookException{
    		    if(obj.getBookType().compareToIgnoreCase("Engineering")==0){
    		        bookList.add(obj);
    		    }else{
    		        throw new InvalidBookException("Book type Invalid");
    		    }
    		}
    		public void run(){
    		    int count=0;
    		    for(int j=0;j<bookList.size();j++){
    		        if(bookList.get(j).getBookName().compareToIgnoreCase(searchbookName)==0){
    		            count=count+1;
    		        }
    		    }
    		    if(count==0)
    		    {System.out.println("No Books found");}
   		    else{
    		        System.out.println("Count of books in the library with the book name "+searchbookName.toUpperCase()+" is "+count);
   		}
    	}
    }
