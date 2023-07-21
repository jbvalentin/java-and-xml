package model.db.ser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Period;

public class PeriodDeserializer extends JsonDeserializer<Period> {

    @Override
    public Period deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Period.ofDays(Integer.parseInt(jsonParser.getText()));
    }
}
