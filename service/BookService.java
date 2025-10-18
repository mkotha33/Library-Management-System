package service;

import model.Book;
import model.Branch;
import java.util.*;

public class BookService {
    public void addBookToBranch(Book book, Branch branch) {
        branch.addBook(book);
    }

    public void removeBookFromBranch(String isbn, Branch branch) {
        branch.removeBook(isbn);
    }

    public Book searchBookByISBN(String isbn, Branch branch) {
        return branch.getBook(isbn);
    }

    public List<Book> searchBooksByTitle(String title, Branch branch) {
        List<Book> result = new ArrayList<Book>();
        for (Book book : branch.getInventory().values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
}
