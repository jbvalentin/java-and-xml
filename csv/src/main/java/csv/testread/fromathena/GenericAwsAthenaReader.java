package csv.testread.fromathena;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class GenericAwsAthenaReader {


    public static void main(String[] args) {
//        https://stackoverflow.com/questions/55185146/get-header-of-csv-using-jackson-dataformat-csv
        CsvFactory cf = new CsvFactory();

        try {
            ObjectMapper om = new ObjectMapper();

            JsonFormatVisitorWrapper v = new JsonFormatVisitorWrapper.Base() {

            };
            om.acceptJsonFormatVisitor(Map.class, v);


            CsvMapper cm = new CsvMapper(cf);

            CsvSchema schema = cm.typedSchemaFor(Map.class)
                .withHeader()
                .withColumnSeparator(',');

            InputStream in = GenericAwsAthenaReader.class.getClassLoader().getResourceAsStream("athena/e708f60a-2fc0-4d23-b8ec-9d59c5365f68.csv");

            List<Object> it = cm.readerFor(Map.class)
                .with(schema)
                .readValues(in)
                .readAll();

            it.forEach(
                d -> {
                    try {
                        // OK, ne pas faire om.writeValue(System.out, d);
                        System.out.println(om.writeValueAsString(d));
                    } catch (Exception e) {
                        System.err.println("err " + e.getMessage());
                    }
                }
            );


//            cm.createParser(in)
//
//            List<?> l = cm.readerFor(CsvLine.class)
//                .with(schema)
//                .readValues(in)
//                .readAll();
//            System.out.println(((CsvLine) l.get(0)).getField1());
//            System.out.println(l.size());

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
