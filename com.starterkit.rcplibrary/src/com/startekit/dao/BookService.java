package com.startekit.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookService {
	
	private List<BookDao> bookList;

	public BookService() {
		BookDao book1 = new BookDao(1L, "bookTitle1", "Author1 ");
		BookDao book2 = new BookDao(2L, "bookTitle2", "Author2 ");
		BookDao book3 = new BookDao(3L, "bookTitle3", "Author3 ");
		BookDao book4 = new BookDao(4L, "bookTitle4", "Author4 ");
		BookDao book5 = new BookDao(5L, "bookTitle5", "Author5 ");
		bookList = new ArrayList<BookDao>(Arrays.asList(book1, book2, book3, book4, book5));
	}
	
	public List<BookDao> getAllBooks() {
		return bookList;
	}
	
	public List<BookDao> findBooksByTitle(String part) {
		List newList = new ArrayList<BookDao>();
		if(part.length()==0){
			return bookList;
		}
		for (BookDao book : bookList) {
			if(book.getTitle().contains(part) || book.getAutor().contains(part)){
				newList.add(book);
			}
		}
		
		return bookList;
	}
	
	public void saveBook(Long id, String title, String author) {
		BookDao newBook = new BookDao(id, title, author);
			if(!bookList.contains(newBook)){
				bookList.add(newBook);
			}
	}
	
	public void deleteBook(Long id) {
		for (BookDao book : bookList) {
			if(book.getId()== id){
				bookList.remove(id);
			}
		}
	}

}
