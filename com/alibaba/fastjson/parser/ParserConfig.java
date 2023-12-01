package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CharsetCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.CurrencyCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/ParserConfig.class */
public class ParserConfig {
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    protected ClassLoader defaultClassLoader;
    private String[] denyList;
    private final IdentityHashMap<Type, ObjectDeserializer> derializers;
    public final SymbolTable symbolTable;
    public static ParserConfig global = new ParserConfig();
    private static boolean awtError = false;
    private static boolean jdk8Error = false;

    public ParserConfig() {
        this(null, null);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, null);
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader) {
        this.derializers = new IdentityHashMap<>();
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.denyList = new String[]{"java.lang.Thread"};
        ASMDeserializerFactory aSMDeserializerFactory2 = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            aSMDeserializerFactory2 = aSMDeserializerFactory;
            if (!ASMUtils.IS_ANDROID) {
                try {
                    aSMDeserializerFactory2 = classLoader == null ? new ASMDeserializerFactory(new ASMClassLoader()) : new ASMDeserializerFactory(classLoader);
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException e) {
                    aSMDeserializerFactory2 = aSMDeserializerFactory;
                }
            }
        }
        this.asmFactory = aSMDeserializerFactory2;
        if (aSMDeserializerFactory2 == null) {
            this.asmEnable = false;
        }
        this.derializers.put(SimpleDateFormat.class, MiscCodec.instance);
        this.derializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.derializers.put(Date.class, SqlDateDeserializer.instance);
        this.derializers.put(Time.class, TimeDeserializer.instance);
        this.derializers.put(java.util.Date.class, DateCodec.instance);
        this.derializers.put(Calendar.class, CalendarCodec.instance);
        this.derializers.put(JSONObject.class, MapDeserializer.instance);
        this.derializers.put(JSONArray.class, CollectionCodec.instance);
        this.derializers.put(Map.class, MapDeserializer.instance);
        this.derializers.put(HashMap.class, MapDeserializer.instance);
        this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.derializers.put(TreeMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.derializers.put(Collection.class, CollectionCodec.instance);
        this.derializers.put(List.class, CollectionCodec.instance);
        this.derializers.put(ArrayList.class, CollectionCodec.instance);
        this.derializers.put(Object.class, JavaObjectDeserializer.instance);
        this.derializers.put(String.class, StringCodec.instance);
        this.derializers.put(StringBuffer.class, StringCodec.instance);
        this.derializers.put(StringBuilder.class, StringCodec.instance);
        this.derializers.put(Character.TYPE, CharacterCodec.instance);
        this.derializers.put(Character.class, CharacterCodec.instance);
        this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
        this.derializers.put(Byte.class, NumberDeserializer.instance);
        this.derializers.put(Short.TYPE, NumberDeserializer.instance);
        this.derializers.put(Short.class, NumberDeserializer.instance);
        this.derializers.put(Integer.TYPE, IntegerCodec.instance);
        this.derializers.put(Integer.class, IntegerCodec.instance);
        this.derializers.put(Long.TYPE, LongCodec.instance);
        this.derializers.put(Long.class, LongCodec.instance);
        this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.derializers.put(Float.TYPE, FloatCodec.instance);
        this.derializers.put(Float.class, FloatCodec.instance);
        this.derializers.put(Double.TYPE, NumberDeserializer.instance);
        this.derializers.put(Double.class, NumberDeserializer.instance);
        this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
        this.derializers.put(Boolean.class, BooleanCodec.instance);
        this.derializers.put(Class.class, MiscCodec.instance);
        this.derializers.put(char[].class, CharArrayCodec.instance);
        this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
        this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.derializers.put(AtomicLong.class, LongCodec.instance);
        this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
        this.derializers.put(WeakReference.class, ReferenceCodec.instance);
        this.derializers.put(SoftReference.class, ReferenceCodec.instance);
        this.derializers.put(UUID.class, MiscCodec.instance);
        this.derializers.put(TimeZone.class, MiscCodec.instance);
        this.derializers.put(Locale.class, MiscCodec.instance);
        this.derializers.put(Currency.class, CurrencyCodec.instance);
        this.derializers.put(InetAddress.class, MiscCodec.instance);
        this.derializers.put(Inet4Address.class, MiscCodec.instance);
        this.derializers.put(Inet6Address.class, MiscCodec.instance);
        this.derializers.put(InetSocketAddress.class, MiscCodec.instance);
        this.derializers.put(File.class, MiscCodec.instance);
        this.derializers.put(URI.class, MiscCodec.instance);
        this.derializers.put(URL.class, MiscCodec.instance);
        this.derializers.put(Pattern.class, MiscCodec.instance);
        this.derializers.put(Charset.class, CharsetCodec.instance);
        this.derializers.put(Number.class, NumberDeserializer.instance);
        this.derializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
        this.derializers.put(AtomicLongArray.class, AtomicCodec.instance);
        this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
        if (!awtError) {
            try {
                this.derializers.put(Class.forName("java.awt.Point"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Font"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Color"), AwtCodec.instance);
            } catch (Throwable th) {
                awtError = true;
            }
        }
        if (!jdk8Error) {
            try {
                this.derializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
                this.derializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
                this.derializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
                this.derializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
                this.derializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
            } catch (Throwable th2) {
                jdk8Error = true;
            }
        }
        addDeny("java.lang.Thread");
        configFromPropety(System.getProperties());
    }

    public ParserConfig(ClassLoader classLoader) {
        this(null, classLoader);
    }

    public static Field getField(Class<?> cls, String str) {
        Field field0 = getField0(cls, str);
        Field field = field0;
        if (field0 == null) {
            field = getField0(cls, BridgeUtil.UNDERLINE_STR + str);
        }
        Field field2 = field;
        if (field == null) {
            field2 = getField0(cls, "m_" + str);
        }
        return field2;
    }

    private static Field getField0(Class<?> cls, String str) {
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
                    return null;
                }
                return getField(cls.getSuperclass(), str);
            }
            Field field = declaredFields[i2];
            if (str.equals(field.getName())) {
                return field;
            }
            i = i2 + 1;
        }
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public void addDeny(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArr = this.denyList;
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        this.denyList = strArr2;
    }

    public void configFromPropety(Properties properties) {
        String property = properties.getProperty(DENY_PROPERTY);
        if (property == null || property.length() <= 0) {
            return;
        }
        String[] split = property.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            addDeny(split[i2]);
            i = i2 + 1;
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        return (cls2 == List.class || cls2 == ArrayList.class) ? new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo) : new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        boolean z = this.asmEnable;
        boolean z2 = z;
        if (z) {
            JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
            boolean z3 = z;
            if (jSONType != null) {
                z3 = z;
                if (!jSONType.asm()) {
                    z3 = false;
                }
            }
            z2 = z3;
            if (z3) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(jSONType);
                Class<?> cls2 = builderClass;
                if (builderClass == null) {
                    cls2 = cls;
                }
                while (true) {
                    if (!Modifier.isPublic(cls2.getModifiers())) {
                        z2 = false;
                        break;
                    }
                    Class<? super Object> superclass = cls2.getSuperclass();
                    z2 = z3;
                    if (superclass == Object.class) {
                        break;
                    }
                    cls2 = superclass;
                    if (superclass == null) {
                        z2 = z3;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if (z2) {
            ASMDeserializerFactory aSMDeserializerFactory = this.asmFactory;
            z4 = z2;
            if (aSMDeserializerFactory != null) {
                z4 = z2;
                if (aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
                    z4 = false;
                }
            }
        }
        boolean z5 = z4;
        if (z4) {
            z5 = ASMUtils.checkName(cls.getName());
        }
        boolean z6 = z5;
        if (z5) {
            boolean z7 = z5;
            if (cls.isInterface()) {
                z7 = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type);
            boolean z8 = z7;
            if (z7) {
                z8 = z7;
                if (build.fields.length > 200) {
                    z8 = false;
                }
            }
            Constructor<?> constructor = build.defaultConstructor;
            boolean z9 = z8;
            if (z8) {
                z9 = z8;
                if (constructor == null) {
                    z9 = z8;
                    if (!cls.isInterface()) {
                        z9 = false;
                    }
                }
            }
            FieldInfo[] fieldInfoArr = build.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z6 = z9;
                if (i2 >= length) {
                    break;
                }
                FieldInfo fieldInfo = fieldInfoArr[i2];
                if (!fieldInfo.getOnly) {
                    Class<?> cls3 = fieldInfo.fieldClass;
                    if (!Modifier.isPublic(cls3.getModifiers()) || ((cls3.isMemberClass() && !Modifier.isStatic(cls3.getModifiers())) || ((fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) || (((annotation = fieldInfo.getAnnotation()) != null && !ASMUtils.checkName(annotation.name())) || (cls3.isEnum() && !(getDeserializer(cls3) instanceof EnumDeserializer)))))) {
                        break;
                    }
                    i = i2 + 1;
                } else {
                    break;
                }
            }
            z6 = false;
        }
        if (z6 && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z6 = false;
        }
        if (z6) {
            try {
                return this.asmFactory.createJavaBeanDeserializer(this, cls, type);
            } catch (JSONException e) {
                return new JavaBeanDeserializer(this, cls, type);
            } catch (NoSuchMethodException e2) {
                return new JavaBeanDeserializer(this, cls, type);
            } catch (Exception e3) {
                throw new JSONException("create asm deserializer error, " + cls.getName(), e3);
            }
        }
        return new JavaBeanDeserializer(this, cls, type);
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.derializers;
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        Type type2 = type;
        if (type == null) {
            type2 = cls;
        }
        ObjectDeserializer objectDeserializer2 = this.derializers.get(type2);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            objectDeserializer2 = this.derializers.get(cls);
        }
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.denyList;
            if (i2 >= strArr.length) {
                try {
                    for (AutowiredObjectDeserializer autowiredObjectDeserializer : ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                        for (Type type3 : autowiredObjectDeserializer.getAutowiredFor()) {
                            this.derializers.put(type3, autowiredObjectDeserializer);
                        }
                    }
                } catch (Exception e) {
                }
                ObjectDeserializer objectDeserializer3 = this.derializers.get(type2);
                if (objectDeserializer3 != null) {
                    return objectDeserializer3;
                }
                ObjectDeserializer enumDeserializer = cls.isEnum() ? new EnumDeserializer(cls) : cls.isArray() ? ObjectArrayCodec.instance : (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) ? CollectionCodec.instance : Collection.class.isAssignableFrom(cls) ? CollectionCodec.instance : Map.class.isAssignableFrom(cls) ? MapDeserializer.instance : Throwable.class.isAssignableFrom(cls) ? new ThrowableDeserializer(this, cls) : createJavaBeanDeserializer(cls, type2);
                putDeserializer(type2, enumDeserializer);
                return enumDeserializer;
            }
            String str = strArr[i2];
            String replace = cls.getName().replace('$', '.');
            if (replace.startsWith(str)) {
                throw new JSONException("parser deny : " + replace);
            }
            i = i2 + 1;
        }
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? getDeserializer((Class) rawType, type) : getDeserializer(rawType);
        }
        return JavaObjectDeserializer.instance;
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.derializers.put(type, objectDeserializer);
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }
}
