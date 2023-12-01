package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.class */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private final FieldDeserializer[] fieldDeserializers;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this.clazz = cls;
        JavaBeanInfo build = JavaBeanInfo.build(cls, type);
        this.beanInfo = build;
        this.sortedFieldDeserializers = new FieldDeserializer[build.sortedFields.length];
        int length = this.beanInfo.sortedFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.sortedFieldDeserializers[i2] = parserConfig.createFieldDeserializer(parserConfig, this.beanInfo, this.beanInfo.sortedFields[i2]);
            i = i2 + 1;
        }
        this.fieldDeserializers = new FieldDeserializer[this.beanInfo.fields.length];
        int length2 = this.beanInfo.fields.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            this.fieldDeserializers[i4] = getFieldDeserializer(this.beanInfo.fields[i4].name);
            i3 = i4 + 1;
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        FieldInfo[] fieldInfoArr;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        if (this.beanInfo.defaultConstructor == null) {
            return null;
        }
        try {
            Constructor<?> constructor = this.beanInfo.defaultConstructor;
            Object newInstance = this.beanInfo.defaultConstructorParameterSize == 0 ? constructor.newInstance(new Object[0]) : constructor.newInstance(defaultJSONParser.getContext().object);
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(newInstance, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return newInstance;
        } catch (Exception e2) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (this.beanInfo.creatorConstructor == null && this.beanInfo.buildMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                FieldDeserializer fieldDeserializer = getFieldDeserializer(key);
                if (fieldDeserializer != null) {
                    Method method = fieldDeserializer.fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        fieldDeserializer.fieldInfo.field.set(createInstance, TypeUtils.cast(value, fieldDeserializer.fieldInfo.fieldType, parserConfig));
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = this.beanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = map.get(fieldInfoArr[i].name);
        }
        if (this.beanInfo.creatorConstructor != null) {
            try {
                return this.beanInfo.creatorConstructor.newInstance(objArr);
            } catch (Exception e) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e);
            }
        } else if (this.beanInfo.factoryMethod != null) {
            try {
                return this.beanInfo.factoryMethod.invoke(null, objArr);
            } catch (Exception e2) {
                throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e2);
            }
        } else {
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0762, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r8.getConfig().getDefaultClassLoader());
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0777, code lost:
        r0 = (T) r8.getConfig().getDeserializer(r0).deserialze(r8, r0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x078a, code lost:
        if (r18 == null) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x078d, code lost:
        r18.object = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0794, code lost:
        r8.setContext(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x079b, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x08ed, code lost:
        r18 = r17;
        r17 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x0aee, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r0.token()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:204:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[Catch: all -> 0x007b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x007b, blocks: (B:18:0x0059, B:20:0x0065, B:28:0x008d, B:30:0x009e, B:35:0x00b1, B:42:0x00d1, B:48:0x00eb, B:50:0x00f6, B:53:0x0103, B:55:0x0136, B:56:0x0144, B:56:0x0144, B:57:0x0147, B:58:0x014f, B:63:0x015c), top: B:529:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08a0 A[Catch: all -> 0x0aef, TRY_ENTER, TryCatch #8 {all -> 0x0aef, blocks: (B:391:0x08cd, B:394:0x08da, B:396:0x08e4, B:481:0x0aa8, B:483:0x0ab2, B:487:0x0ac6, B:488:0x0aee, B:385:0x08a0, B:387:0x08af, B:389:0x08b9), top: B:533:0x08cd }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x08da A[Catch: all -> 0x0aef, TRY_ENTER, TryCatch #8 {all -> 0x0aef, blocks: (B:391:0x08cd, B:394:0x08da, B:396:0x08e4, B:481:0x0aa8, B:483:0x0ab2, B:487:0x0ac6, B:488:0x0aee, B:385:0x08a0, B:387:0x08af, B:389:0x08b9), top: B:533:0x08cd }] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0b09  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0b69  */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r8, java.lang.reflect.Type r9, java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 2963
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T t = (T) createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (i < length) {
                char c = i == length - 1 ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    fieldDeserializer.setValue(t, jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c));
                } else {
                    jSONLexer.nextToken(14);
                    fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
                    if (c == ']') {
                        if (jSONLexer.token() != 15) {
                            throw new JSONException("syntax error");
                        }
                        jSONLexer.nextToken(16);
                    } else if (c == ',' && jSONLexer.token() != 16) {
                        throw new JSONException("syntax error");
                    }
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return t;
        }
        throw new JSONException("error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedFieldDeserializers[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public final boolean isSupportArrayToBean(JSONLexer jSONLexer) {
        return Feature.isEnabled(this.beanInfo.parserFeatures, Feature.SupportArrayToBean) || jSONLexer.isEnabled(Feature.SupportArrayToBean);
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer smartMatch = smartMatch(str);
        if (smartMatch != null) {
            jSONLexer.nextTokenWithColon(smartMatch.getFastMatchToken());
            smartMatch.parseField(defaultJSONParser, obj, type, map);
            return true;
        } else if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
            defaultJSONParser.parseExtra(obj, str);
            return false;
        } else {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
    }

    public FieldDeserializer smartMatch(String str) {
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        FieldDeserializer fieldDeserializer2 = fieldDeserializer;
        if (fieldDeserializer == null) {
            boolean startsWith = str.startsWith("is");
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            int length = fieldDeserializerArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                fieldDeserializer2 = fieldDeserializer;
                if (i2 >= length) {
                    break;
                }
                fieldDeserializer2 = fieldDeserializerArr[i2];
                FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                Class<?> cls = fieldInfo.fieldClass;
                String str2 = fieldInfo.name;
                if (str2.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str2.equalsIgnoreCase(str.substring(2))))) {
                    break;
                }
                i = i2 + 1;
            }
        }
        FieldDeserializer fieldDeserializer3 = fieldDeserializer2;
        if (fieldDeserializer2 == null) {
            fieldDeserializer3 = fieldDeserializer2;
            if (str.indexOf(95) != -1) {
                String replaceAll = str.replaceAll(BridgeUtil.UNDERLINE_STR, "");
                FieldDeserializer fieldDeserializer4 = getFieldDeserializer(replaceAll);
                fieldDeserializer3 = fieldDeserializer4;
                if (fieldDeserializer4 == null) {
                    FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                    int length2 = fieldDeserializerArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        fieldDeserializer3 = fieldDeserializer4;
                        if (i4 >= length2) {
                            break;
                        }
                        FieldDeserializer fieldDeserializer5 = fieldDeserializerArr2[i4];
                        if (fieldDeserializer5.fieldInfo.name.equalsIgnoreCase(replaceAll)) {
                            return fieldDeserializer5;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
        }
        return fieldDeserializer3;
    }
}
