import observer.*;
import java.util.logging.Logger;

import factory.BookFactory;
import model.Book;
import model.Branch;
import model.Patron;
import observer.EventManager;
import service.BookService;
import service.BranchService;
import service.LendingService;
import service.PatronService;
import util.LoggerUtil;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerUtil.getLogger("LibraryLogger");

        Branch branchA = new Branch("Central");
        Branch branchB = new Branch("East");

        Book book1 = BookFactory.createBook("Java Basics", "Maahi Kotha", "ISBN001", 2010);
        Book book2 = BookFactory.createBook("OOP Concepts", "Pranay Kumar", "ISBN002", 2012);
        
        BookService bookService = new BookService();
        bookService.addBookToBranch(book1, branchA);
        bookService.addBookToBranch(book2, branchA);
        
        logger.info("Books in branchA:" + branchA.getInventory());
        logger.info("Books in branchB:" + branchB.getInventory());

        Patron patron = new Patron("Alice", "P001");
        PatronService patronService = new PatronService();
        patronService.addPatron(patron);

        EventManager eventManager = new EventManager("checkout", "return");
        EventListener eventListener = new EventListener() {
            public void update(String eventType, String message) {
                logger.info("EVENT [" + eventType + "]: " + message);
            }
        };
        eventManager.subscribe("checkout", eventListener);

        LendingService lendingService = new LendingService(eventManager);
        lendingService.checkoutBook("ISBN001", patron, branchA);
        lendingService.returnBook("ISBN001", patron, branchA);

        BranchService branchService = new BranchService();
        branchService.transferBook("ISBN002", branchA, branchB);
        
        logger.info("Books in branchA:" + branchA.getInventory());
        logger.info("Books in branchB:" + branchB.getInventory());
    }
}
