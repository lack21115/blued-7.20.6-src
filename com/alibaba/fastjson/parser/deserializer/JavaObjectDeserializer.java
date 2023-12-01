package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/JavaObjectDeserializer.class */
public class JavaObjectDeserializer implements ObjectDeserializer {
    public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Type type2 = genericComponentType;
            if (genericComponentType instanceof TypeVariable) {
                type2 = ((TypeVariable) genericComponentType).getBounds()[0];
            }
            Collection arrayList = new ArrayList();
            defaultJSONParser.parseArray(type2, arrayList);
            if (type2 instanceof Class) {
                Class<Double> cls = (Class) type2;
                if (cls == Boolean.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) boolean[].class, defaultJSONParser.getConfig());
                }
                if (cls == Short.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) short[].class, defaultJSONParser.getConfig());
                }
                if (cls == Integer.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) int[].class, defaultJSONParser.getConfig());
                }
                if (cls == Long.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) long[].class, defaultJSONParser.getConfig());
                }
                if (cls == Float.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) float[].class, defaultJSONParser.getConfig());
                }
                if (cls == Double.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, (Class<Object>) double[].class, defaultJSONParser.getConfig());
                }
                T t = (T) ((Object[]) Array.newInstance(cls, arrayList.size()));
                arrayList.toArray(t);
                return t;
            }
            return (T) arrayList.toArray();
        }
        return (T) defaultJSONParser.parse(obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
