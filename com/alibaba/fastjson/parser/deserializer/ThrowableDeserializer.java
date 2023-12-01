package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/ThrowableDeserializer.class */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        Constructor<?> constructor3;
        Constructor<?>[] constructors = cls.getConstructors();
        int length = constructors.length;
        Constructor<?> constructor4 = null;
        Constructor<?> constructor5 = null;
        int i = 0;
        Constructor<?> constructor6 = null;
        while (i < length) {
            Constructor<?> constructor7 = constructors[i];
            Class<?>[] parameterTypes = constructor7.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor = constructor4;
                constructor2 = constructor6;
                constructor3 = constructor7;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor = constructor4;
                constructor2 = constructor7;
                constructor3 = constructor5;
            } else {
                constructor = constructor4;
                constructor2 = constructor6;
                constructor3 = constructor5;
                if (parameterTypes.length == 2) {
                    constructor = constructor4;
                    constructor2 = constructor6;
                    constructor3 = constructor5;
                    if (parameterTypes[0] == String.class) {
                        constructor = constructor4;
                        constructor2 = constructor6;
                        constructor3 = constructor5;
                        if (parameterTypes[1] == Throwable.class) {
                            constructor3 = constructor5;
                            constructor2 = constructor6;
                            constructor = constructor7;
                        }
                    }
                }
            }
            i++;
            constructor4 = constructor;
            constructor6 = constructor2;
            constructor5 = constructor3;
        }
        if (constructor4 != null) {
            return (Throwable) constructor4.newInstance(str, th);
        }
        if (constructor6 != null) {
            return (Throwable) constructor6.newInstance(str);
        }
        if (constructor5 != null) {
            return (Throwable) constructor5.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r7) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e3, code lost:
        if (r7 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e6, code lost:
        r6 = new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f5, code lost:
        r0 = createException(r10, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0200, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0202, code lost:
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0205, code lost:
        r6 = new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0212, code lost:
        if (r8 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0215, code lost:
        r6.setStackTrace(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x021b, code lost:
        return (T) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x021c, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0227, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r6);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r6, java.lang.reflect.Type r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
