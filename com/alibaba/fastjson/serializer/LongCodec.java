package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/LongCodec.class */
public class LongCodec implements ObjectDeserializer, ObjectSerializer {
    public static LongCodec instance = new LongCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object castToLong;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            castToLong = Long.valueOf(longValue);
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            castToLong = TypeUtils.castToLong(parse);
        }
        Object obj2 = castToLong;
        if (type == AtomicLong.class) {
            obj2 = new AtomicLong(castToLong.longValue());
        }
        return (T) obj2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        long longValue = ((Long) obj).longValue();
        serializeWriter.writeLong(longValue);
        if (!serializeWriter.writeClassName || longValue > 2147483647L || longValue < -2147483648L || type == Long.class) {
            return;
        }
        serializeWriter.write(76);
    }
}
