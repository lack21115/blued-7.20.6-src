package com.alibaba.fastjson.serializer;

import com.igexin.push.core.b;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/ListSerializer.class */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        boolean z = jSONSerializer.out.writeClassName;
        SerializeWriter serializeWriter = jSONSerializer.out;
        Type type2 = (z && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        if (obj == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            if (serializeWriter.prettyFormat) {
                serializeWriter.append('[');
                jSONSerializer.incrementIndent();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        jSONSerializer.decrementIdent();
                        jSONSerializer.println();
                        serializeWriter.append(']');
                        return;
                    }
                    Object next = it.next();
                    if (i3 != 0) {
                        serializeWriter.append(',');
                    }
                    jSONSerializer.println();
                    if (next == null) {
                        jSONSerializer.out.writeNull();
                    } else if (jSONSerializer.containsReference(next)) {
                        jSONSerializer.writeReference(next);
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(next.getClass());
                        jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                        objectWriter.write(jSONSerializer, next, Integer.valueOf(i3), type2, 0);
                    }
                    i2 = i3 + 1;
                }
            } else {
                serializeWriter.append('[');
                int size = list.size();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= size) {
                        serializeWriter.append(']');
                        return;
                    }
                    Object obj3 = list.get(i5);
                    if (i5 != 0) {
                        serializeWriter.append(',');
                    }
                    if (obj3 == null) {
                        serializeWriter.append((CharSequence) b.l);
                    } else {
                        Class<?> cls = obj3.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj3).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj3).longValue();
                            if (z) {
                                serializeWriter.writeLongAndChar(longValue, 'L');
                            } else {
                                serializeWriter.writeLong(longValue);
                            }
                        } else {
                            if (!serializeWriter.disableCircularReferenceDetect) {
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            }
                            if (jSONSerializer.containsReference(obj3)) {
                                jSONSerializer.writeReference(obj3);
                            } else {
                                jSONSerializer.getObjectWriter(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i5), type2, 0);
                            }
                        }
                    }
                    i4 = i5 + 1;
                }
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
