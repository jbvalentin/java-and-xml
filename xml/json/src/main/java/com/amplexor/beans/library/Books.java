package com.amplexor.beans.library;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="books")
public class Books {
	
	private Collection<Book> books;

	@JacksonXmlElementWrapper(useWrapping = true, localName = "list")
	@JacksonXmlProperty(localName = "book")
	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

}
