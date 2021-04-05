package google;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookMain {

	
		public static HashMap<String, Book> books = new HashMap<String, Book>();
							//key,    value
		public static int key = 2;

		public static void main(String[] args) 
		{
			
			
			Scanner s=new Scanner(System.in);
			while(true)
				{
				System.out.println("options");
				System.out.println("1.add");
				System.out.println("2.update");
				System.out.println("3.delete");
				System.out.println("4.view all");
				System.out.println("5. Exit");
				
				System.out.println("enter the option");
				int option=s.nextInt();
				
				switch(option)
				{
					case 1:
						addNewBook();
						break;
					case 2:
						updateBook();
						break;
					case 4:
						viewAllBooks();
						break;
					case 3:removeBook();
							break;
					case 5:
						System.exit(0);
						break;
					case 6:findAuthor();
							break;
					
					
				}
			}

		}
		
		public static void prefillData() {
			String author = "Arasu";//No I18N
			int price = 100;
			int publishYear = 2010;
			int noOfPages = 10;
			int edition = 1;
			String subject = "test";//No I18N

			Book book = new Book(author, price, publishYear, noOfPages, edition, subject);
			books.put("1", book);
		}
		public static void findAuthor()
		{			
			
				
		}
		public static void viewAllBooks() {
			 for (Map.Entry<String, Book> entry : books.entrySet()) {
				 String bookId = entry.getKey();
				 Book book = entry.getValue();
				 printBook(bookId, book);
			 }
		}

		public static void addNewBook()
		{
			//Values from user - Scanner
			Scanner s=new Scanner(System.in);
			String author = s.next();//No I18N
			int price = s.nextInt();
			int publishYear = s.nextInt();
			int noOfPages = s.nextInt();
			int edition = s.nextInt();
			String subject = s.nextLine();//No I18N

			Book book = new Book(author, price, publishYear, noOfPages, edition, subject);
			books.put(String.valueOf(key), book);
			key++;			
		}
		public static void  removeBook()
		{
			viewAllBooks();
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the book id to delete");
			int bookid = s.nextInt();
			Book book = books.get(String.valueOf(bookid));
			books.remove(String.valueOf(bookid));
			System.out.println("Sucessfully removed ");			
		}
		public static void updateBook()
		{
			viewAllBooks();
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the book id to update");
			int bookid = s.nextInt();
			Book book = books.get(String.valueOf(bookid));
			
			System.out.println("1. Author");
			System.out.println("2. Price");
			System.out.println("3. Year");
			System.out.println("4. Pages");
			System.out.println("5. Edition");
			
			System.out.println("Enter the id to update the deail");
			int option = s.nextInt();
			System.out.println("Enter the new value");
			switch(option) {
				case 1:
					String newAuthor = s.next();
					book.setAuthor(newAuthor);
					break;
				case 2:
					int price = s.nextInt();
					book.setPrice(price);
					break;
				case 3:
					int year = s.nextInt();
					book.setYear(year);
					break;
				case 4:
					int pages = s.nextInt();
					book.setPages(pages);
					break;
				case 5:
					int edition = s.nextInt();
					book.setEdition(edition);
					break;
			}			
			printBook(String.valueOf(bookid), book);
			/*viewAllBooks();
			books.remove(String.valueOf(bookid));
			System.out.println("Book removed " + bookid);
			books.put(String.valueOf(bookid), book);
			System.out.println("Book added " + bookid);
			viewAllBooks();*/			
		}
		public static void printBook(String key, Book book){
			System.out.println("-------------------------------");
			System.out.println("Key: " + key);
			System.out.println("Author: " + book.author);
			System.out.println("Price: " + book.price);
			System.out.println("Year: " + book.publishYear);
			System.out.println("Pages: " + book.noOfPages);
			System.out.println("Edition: " + book.edition);
			System.out.println("-------------------------------");
		}	
	}
