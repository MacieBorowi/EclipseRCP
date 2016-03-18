package com.startekit.dao;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
	INSTANCE;

	private List<BookDao> bookList;

	private ModelProvider() {
		bookList = new ArrayList<BookDao>();		
		bookList.add(new BookDao(1L, "bookTitle1", "Author1 ", "Subiect1", "Description1"));
		bookList.add(new BookDao(2L, "bookTitlee2", "Author2 ", "Subiect2", "Description2"));
		bookList.add(new BookDao(3L, "bookTitlee3", "Author3 ", "Subiect3", "Description3"));
		bookList.add(new BookDao(4L, "bookTitle4", "Author4 ", "Subiect4", "Description4"));
		bookList.add(new BookDao(5L, "bookTitle5", "Author5 ", "Subiect5", "Description5"));	
	}

	public List<BookDao> getPersons() {
		return bookList;
	}

	public List<BookDao> findBooksByTitle(String part) {
		List<BookDao> newList = new ArrayList<BookDao>();
		if(part.length()==0){
			return bookList;
		}
		for (BookDao book : bookList) {
			if(book.getTitle().contains(part) || book.getAutor().contains(part)){
				newList.add(book);
			}
		}
		
		return newList;
	}
	
	public void saveBook(Long id, String title, String author , String subject, String description) {
		BookDao newBook = new BookDao(id, title, author, subject, description);
			if(!bookList.contains(newBook)){
				bookList.add(newBook);
			}
	}
	
	public void deleteBook(Long id) {
		for (int i = 0 ; i < bookList.size();i++) {
			if(bookList.get(i).getId()== id){
				bookList.remove(i);
			}
		}
	}
}
