package model;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    private String name;
    private Map<String, Book> inventory;

    public Branch(String name) {
        this.name = name;
        this.inventory = new HashMap<String, Book>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        inventory.remove(isbn);
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public Map<String, Book> getInventory() {
        return inventory;
    }

    public String getName() { return name; }
}
