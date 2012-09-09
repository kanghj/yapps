package com.vouov.yapps.json.serializer;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: yuml
 * Date: 12-9-9
 * Time: 下午11:50
 */
public class DateSerializer extends JsonSerializer<Date> {
    private static final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if(date==null) jsonGenerator.writeNull();
        else jsonGenerator.writeString(simpleDateFormat.format(date));
    }
}
