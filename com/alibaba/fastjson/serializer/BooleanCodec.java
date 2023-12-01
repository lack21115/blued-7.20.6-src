package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/BooleanCodec.class */
public class BooleanCodec implements ObjectDeserializer, ObjectSerializer {
    public static final BooleanCodec instance = new BooleanCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Boolean castToBoolean;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 6) {
            jSONLexer.nextToken(16);
            castToBoolean = Boolean.TRUE;
        } else if (jSONLexer.token() == 7) {
            jSONLexer.nextToken(16);
            castToBoolean = Boolean.FALSE;
        } else if (jSONLexer.token() == 2) {
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken(16);
            castToBoolean = intValue == 1 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            castToBoolean = TypeUtils.castToBoolean(parse);
        }
        return type == AtomicBoolean.class ? (T) new AtomicBoolean(castToBoolean.booleanValue()) : (T) castToBoolean;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 6;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
                serializeWriter.write("false");
            } else {
                serializeWriter.writeNull();
            }
        } else if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write("false");
        }
    }
}
