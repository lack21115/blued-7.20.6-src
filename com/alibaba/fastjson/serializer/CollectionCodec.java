package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/CollectionCodec.class */
public class CollectionCodec implements ObjectDeserializer, ObjectSerializer {
    public static final CollectionCodec instance = new CollectionCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [com.alibaba.fastjson.JSONArray, T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class cls;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            ?? r0 = (T) new JSONArray();
            defaultJSONParser.parseArray((Collection) r0);
            return r0;
        } else {
            ?? r02 = (T) TypeUtils.createCollection(type);
            if (type instanceof ParameterizedType) {
                cls = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                Type type2 = null;
                if (type instanceof Class) {
                    Class cls2 = (Class) type;
                    type2 = null;
                    if (!cls2.getName().startsWith("java.")) {
                        Type genericSuperclass = cls2.getGenericSuperclass();
                        type2 = null;
                        if (genericSuperclass instanceof ParameterizedType) {
                            type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                        }
                    }
                }
                cls = type2 == null ? Object.class : type2;
            }
            defaultJSONParser.parseArray(cls, r02, obj);
            return r02;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int i2 = 0;
        Type type2 = null;
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            type2 = null;
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
        }
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            if (HashSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.append('[');
            for (Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    serializeWriter.append(',');
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.getObjectWriter(cls).write(jSONSerializer, obj3, Integer.valueOf(i3 - 1), type2, 0);
                    }
                }
                i2 = i3;
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
