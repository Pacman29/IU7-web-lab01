package task_options;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MyNullSerializer extends StdSerializer<Object> {
    public MyNullSerializer() {
        this(null);
    }

    public MyNullSerializer(Class<Object> t) {
        super(t);
    }

    @Override
    public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeFieldName("");
    }
}
