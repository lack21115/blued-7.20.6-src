package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/AtomicCodec.class */
public class AtomicCodec implements ObjectDeserializer, ObjectSerializer {
    public static final AtomicCodec instance = new AtomicCodec();

    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(jSONArray);
        if (type == AtomicIntegerArray.class) {
            ?? r0 = (T) new AtomicIntegerArray(jSONArray.size());
            for (int i = 0; i < jSONArray.size(); i++) {
                r0.set(i, jSONArray.getInteger(i).intValue());
            }
            return r0;
        }
        ?? r02 = (T) new AtomicLongArray(jSONArray.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.size()) {
                return r02;
            }
            r02.set(i3, jSONArray.getLong(i3).longValue());
            i2 = i3 + 1;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof AtomicInteger) {
            serializeWriter.writeInt(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            serializeWriter.writeLong(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            serializeWriter.append(((AtomicBoolean) obj).get() ? "true" : "false");
        } else if (obj != null) {
            if (obj instanceof AtomicIntegerArray) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                int length = atomicIntegerArray.length();
                serializeWriter.write(91);
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = atomicIntegerArray.get(i2);
                    if (i2 != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeInt(i3);
                }
                serializeWriter.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            serializeWriter.write(91);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    serializeWriter.write(93);
                    return;
                }
                long j = atomicLongArray.get(i5);
                if (i5 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(j);
                i4 = i5 + 1;
            }
        } else if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
            serializeWriter.write("[]");
        } else {
            serializeWriter.writeNull();
        }
    }
}
