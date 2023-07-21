package model.db.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Period;

public class PeriodSerializer extends JsonSerializer<Period> {

    @Override
    public void serialize(Period period, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(Integer.toString(period.getDays()));
    }
}
