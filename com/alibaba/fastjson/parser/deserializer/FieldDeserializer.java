package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/FieldDeserializer.class */
public abstract class FieldDeserializer {
    protected final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    public int getFastMatchToken() {
        return 0;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, int i) {
        setValue(obj, Integer.valueOf(i));
    }

    public void setValue(Object obj, long j) {
        setValue(obj, Long.valueOf(j));
    }

    public void setValue(Object obj, Object obj2) {
        Class<?> cls;
        if (obj2 == null && ((cls = this.fieldInfo.fieldClass) == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE || cls == Boolean.TYPE || cls == Character.TYPE)) {
            return;
        }
        Method method = this.fieldInfo.method;
        if (method == null) {
            Field field = this.fieldInfo.field;
            if (field != null) {
                try {
                    field.set(obj, obj2);
                    return;
                } catch (Exception e) {
                    throw new JSONException("set property error, " + this.fieldInfo.name, e);
                }
            }
            return;
        }
        try {
            if (!this.fieldInfo.getOnly) {
                if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
                    return;
                }
                method.invoke(obj, obj2);
            } else if (this.fieldInfo.fieldClass == AtomicInteger.class) {
                AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                if (atomicInteger != null) {
                    atomicInteger.set(((AtomicInteger) obj2).get());
                }
            } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
                AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                if (atomicLong != null) {
                    atomicLong.set(((AtomicLong) obj2).get());
                }
            } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                if (atomicBoolean != null) {
                    atomicBoolean.set(((AtomicBoolean) obj2).get());
                }
            } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                Map map = (Map) method.invoke(obj, new Object[0]);
                if (map != null) {
                    map.putAll((Map) obj2);
                }
            } else {
                Collection collection = (Collection) method.invoke(obj, new Object[0]);
                if (collection != null) {
                    collection.addAll((Collection) obj2);
                }
            }
        } catch (Exception e2) {
            throw new JSONException("set property error, " + this.fieldInfo.name, e2);
        }
    }

    public void setValue(Object obj, String str) {
        setValue(obj, (Object) str);
    }

    public void setValue(Object obj, boolean z) {
        setValue(obj, Boolean.valueOf(z));
    }
}
