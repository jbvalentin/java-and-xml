package com.amplexor.csv.testread;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ReadCSVNoFields {

	public static void main(String[] args) {
		
		
		
		try {
			CsvFactory cf = new CsvFactory();
			CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',');
			CsvMapper cm = new CsvMapper(cf);
			
			InputStream in = ReadCSVNoFields.class.getClassLoader().getResourceAsStream("test1/Triathlon-Results.csv");
			
			
			MappingIterator<TriathlonResult> mi = cm.reader().forType(TriathlonResult.class).with(schema).readValues(new InputStreamReader(in, Charset.forName("cp1252")));
			while (mi.hasNext()) {
				System.out.println(" . " + mi.next());
			}
			
			//System.out.println(cm.readerFor(TypeFactory.unknownType()).readTree(new InputStreamReader(in, Charset.forName("cp1252"))));
			
			//System.out.println(cm.reader(JsonNodeFactory.instance).readTree(in).asText());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
