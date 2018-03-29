package com.amplexor.beans.library;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ListBooksJson {
	/**
	 * Regex to parse the filename
	 */
	//private final static String PARSE_FILENAME = "(?:(.*?)\\s+-\\s+)?(.*?)(?:\\s+\\((.*)\\))?(?:\\s+\\[(.*)\\])?(?:\\s+ISBN\\s+(.*))?\\.(\\w*)$";
	private final static String PARSE_FILENAME = "(?:(.*?)\\s+-\\s+)?(.*?)(?:\\s+\\((.*)\\))?(?:\\s+\\[(.*)\\])?(?:\\s+ISBN\\s+(.*))?\\.(pdf|djvu|epub)$";

	public static void main(String[] args) {
		
		
		String pathToDocs = "C:\\Temp\\documentation\\books\\";
		Path rootFolder = Paths.get(pathToDocs);
		
		Pattern p = Pattern.compile(PARSE_FILENAME, Pattern.CASE_INSENSITIVE);
		
		List<Book> library = new ArrayList<>();
		
		try {
			
			Files.walkFileTree(rootFolder, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					String shelf = file.getParent().getFileName().toString();
					
					Matcher m = p.matcher(file.getFileName().toString());
					if (m.matches()) {
						Book b  = new Book();
						b.setShelf(shelf);
						b.setAuthor(m.group(1));
						b.setTitle(m.group(2));
						b.setPublisher(m.group(3));
						b.setEdition(m.group(4));
						b.setIsbn(m.group(5));
						b.setFormat(m.group(6));
						library.add(b);
						System.out.println("(v) OK : " + file.getFileName().toString());
					} else {
						System.out.println("(x) Rejected : " + file.getFileName().toString());
					}
					
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}
				
			});
			
			String result = new ObjectMapper().writeValueAsString(library);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
