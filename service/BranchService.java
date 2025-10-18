package service;

import model.Book;
import model.Branch;

public class BranchService {
    public void transferBook(String isbn, Branch fromBranch, Branch toBranch) {
        Book book = fromBranch.getBook(isbn);
        if (book != null) {
            fromBranch.removeBook(isbn);
            toBranch.addBook(book);
        }
    }
}
