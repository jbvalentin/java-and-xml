package model.library;

import java.util.Arrays;

public class LibraryHelper {

    public static Books buildSampleLibrary() {
        Books bks = new Books();
        Book b1 = new Book();
        b1.setAuthor("author 1");
        b1.setTitle("title 1");

        Book b2 = new Book();
        b2.setAuthor("author 2");
        b2.setTitle("title 2");

        bks.setBooks(Arrays.asList(b1, b2));
        return bks;
    }

}
