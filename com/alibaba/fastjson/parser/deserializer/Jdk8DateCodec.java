package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.class */
public class Jdk8DateCodec implements ObjectDeserializer, ObjectSerializer {
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (type == LocalDateTime.class) {
                return (T) LocalDateTime.parse(stringVal);
            }
            if (type == LocalDate.class) {
                return (T) LocalDate.parse(stringVal);
            }
            if (type == LocalTime.class) {
                return (T) LocalTime.parse(stringVal);
            }
            if (type == ZonedDateTime.class) {
                return (T) ZonedDateTime.parse(stringVal);
            }
            if (type == OffsetDateTime.class) {
                return (T) OffsetDateTime.parse(stringVal);
            }
            if (type == OffsetTime.class) {
                return (T) OffsetTime.parse(stringVal);
            }
            if (type == ZoneId.class) {
                return (T) ZoneId.of(stringVal);
            }
            if (type == Period.class) {
                return (T) Period.parse(stringVal);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(stringVal);
            }
            if (type == Instant.class) {
                return (T) Instant.parse(stringVal);
            }
            return null;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
        } else {
            serializeWriter.writeString(obj.toString());
        }
    }
}
