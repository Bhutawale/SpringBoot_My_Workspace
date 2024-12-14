package com.example.bookproject.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookproject.Entity.Book;

@Service
public class BookService 
{
		List<Book> booklist =new ArrayList<Book> (Arrays.asList(
				new Book(101, "Java", 1000, "ABC"),
				new Book(102, "Oracle", 2000, "PQR"),
				new Book(103, "Hibernate", 3000, "XYZ"),
				new Book(104, "SQL", 4000, "LMN")));
	
		public List<Book> getAllBooks()
		{
			return booklist;
		}
		
		public Book getBookById(int bid)
		{
			Book bookbyid=null;
			try
			{
			 bookbyid=booklist
						.stream()
						.filter(book->book.getBid()==bid)
							.findFirst()
								.get();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return bookbyid;
		}
		
		public void	addBook(Book b)
		{
			booklist.add(b);
			System.out.println("Book Added Successfully!");
		}
		
		public void deleteBook(int id)
		{
			Book remove_book = booklist.
					stream().
					filter(book->book.getBid()==id)
					.findFirst()
					.get();
			
			booklist.remove(remove_book);
			
			System.out.println("Book Deleted Successfully!");
		}
		
		public void updateBook(Book book,int id)
		{
			Book update_book = booklist
					.stream()
					.filter(b->b.getBid()==id)
					.findFirst()
					.get();
			
			update_book.setBname(book.getBname());
			update_book.setBauthor(book.getBauthor());
			update_book.setBprice(book.getBprice());
			
			System.out.println("Book Updated Successfully!");
		}
}	
