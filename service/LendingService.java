package service;

import model.Book;
import model.Patron;
import model.Branch;
import observer.EventManager;

public class LendingService {
    private EventManager eventManager;

    public LendingService(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public boolean checkoutBook(String isbn, Patron patron, Branch branch) {
        Book book = branch.getBook(isbn);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            patron.borrowBook(book);
            eventManager.notify("checkout", "Book checked out: " + book.getTitle());
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, Patron patron, Branch branch) {
        Book book = branch.getBook(isbn);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            patron.returnBook(book);
            eventManager.notify("return", "Book returned: " + book.getTitle());
            return true;
        }
        return false;
    }
}
