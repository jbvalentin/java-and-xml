package model.library;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Shelf {

    private String name;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Book> book;
}
