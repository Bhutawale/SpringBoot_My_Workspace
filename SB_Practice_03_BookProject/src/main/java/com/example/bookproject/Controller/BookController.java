package com.example.bookproject.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookproject.Entity.Book;
import com.example.bookproject.Service.BookService;

@Controller
public class BookController 
{
	@Autowired
	private BookService service;
	
	@GetMapping("/allBooks")
	@ResponseBody
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> allBooks = service.getAllBooks();
		if(allBooks==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else
		{
			return ResponseEntity.of(Optional.of(allBooks));
		}
	}
	 
	@GetMapping("/getBook/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getBookById(@PathVariable("id") int id)
	{
		Book bookById = service.getBookById(id);
		
		Map<String, Object> response=new HashMap<>();
		
		if(bookById==null)
		{
			response.put("message", "Book Not Found");
			response.put("data", null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		else
		{
			response.put("message", "Book Retrieved Successfully");
			response.put("data", bookById);
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping("/addBook")
	@ResponseBody
	public ResponseEntity<Object> addBook(@RequestBody Book b)
	{
		try 
		{
			service.addBook(b);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deleteBook/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id)
	{
		try
		{
			String successmsg="Book with "+id+" has been successfully deleted!!";
			service.deleteBook(id);
			return ResponseEntity.status(HttpStatus.OK).body(successmsg);
		}
		catch(Exception e)
		{
			String errormsg="Their is no such book!!";
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errormsg);
		}
		
	}
	
	@PutMapping("/updateBook/{id}")
	@ResponseBody
	public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		try
		{
			String successmsg="Book with id "+id+" has been successfully updated";
			service.updateBook(book, id);
			return ResponseEntity.status(HttpStatus.OK).body(successmsg);
		}
		catch(Exception e)
		{
			String errormsg="Book does not exist";
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errormsg);
		}
	}
}
