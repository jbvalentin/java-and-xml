package gson;

import com.google.gson.Gson;
import model.library.Book;
import model.library.Books;
import model.library.LibraryHelper;


public class DemoWithGson {

    public static void main(String[] args) {
        Books bookList = LibraryHelper.buildSampleLibrary();
        System.out.println(new Gson().toJson(bookList));
        Gson gson = new Gson();
        Book b = gson.fromJson("{\"title\":\"Un titre\"}", Book.class);

        System.out.println(b.getTitle());


    }
}
