package com.amplexor.csv.testread;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ReadCSVWithFields {

	public static void main(String[] args) {
		CsvFactory cf = new CsvFactory();
		
		
		try {
			CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
			CsvMapper cm = new CsvMapper(cf);
			
			InputStream in = ReadCSVWithFields.class.getClassLoader().getResourceAsStream("test1/read1.csv");
			
			List<?> l = cm.readerFor(CsvLine.class).with(schema).readValues(in).readAll();
			System.out.println(((CsvLine)l.get(0)).getField1());
			System.out.println(l.size());
			
//			CsvParser cp = cf.createParser(in);
//			JsonToken j = cp.nextValue();
//			
//			CsvLine cl = cp.readValueAs(CsvLine.class);
//			System.out.println(cl.getField1());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
