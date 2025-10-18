package service;

import model.Patron;
import java.util.*;

public class PatronService {
    private Map<String, Patron> patrons = new HashMap<String, Patron>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public void updatePatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }
}
