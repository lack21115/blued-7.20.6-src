package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/DefaultJSONParser.class */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask.class */
    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }

        public ParseContext getContext() {
            return this.context;
        }

        public FieldDeserializer getFieldDeserializer() {
            return this.fieldDeserializer;
        }

        public ParseContext getOwnerContext() {
            return this.ownerContext;
        }

        public String getReferenceValue() {
            return this.referenceValue;
        }

        public void setFieldDeserializer(FieldDeserializer fieldDeserializer) {
            this.fieldDeserializer = fieldDeserializer;
        }

        public void setOwnerContext(ParseContext parseContext) {
            this.ownerContext = parseContext;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        primitiveClasses = hashSet;
        hashSet.add(Boolean.TYPE);
        primitiveClasses.add(Byte.TYPE);
        primitiveClasses.add(Short.TYPE);
        primitiveClasses.add(Integer.TYPE);
        primitiveClasses.add(Long.TYPE);
        primitiveClasses.add(Float.TYPE);
        primitiveClasses.add(Double.TYPE);
        primitiveClasses.add(Boolean.class);
        primitiveClasses.add(Byte.class);
        primitiveClasses.add(Short.class);
        primitiveClasses.add(Integer.class);
        primitiveClasses.add(Long.class);
        primitiveClasses.add(Float.class);
        primitiveClasses.add(Double.class);
        primitiveClasses.add(BigInteger.class);
        primitiveClasses.add(BigDecimal.class);
        primitiveClasses.add(String.class);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        jSONLexer.nextToken(12);
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (!str.equals(jSONLexer.stringVal())) {
            throw new JSONException("type not match error");
        }
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken();
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (!(collection instanceof List)) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(collection);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            int size = collection.size();
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size - 1);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        return obj instanceof char[] ? new String((char[]) this.input) : obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.contextArrayIndex) {
                return null;
            }
            if (str.equals(this.contextArray[i2].toString())) {
                return this.contextArray[i2].object;
            }
            i = i2 + 1;
        }
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ResolveTask resolveTask = this.resolveTaskList.get(i2);
            String str = resolveTask.referenceValue;
            Object obj2 = null;
            if (resolveTask.ownerContext != null) {
                obj2 = resolveTask.ownerContext.object;
            }
            Object object = str.startsWith("$") ? getObject(str) : resolveTask.context.object;
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj2, object);
            }
            i = i2 + 1;
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    return jSONScanner.scanISO8601DateIfMatch() ? jSONScanner.getCalendar().getTime() : stringVal;
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i != 12) {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            }
            switch (i) {
                case 6:
                    jSONLexer.nextToken();
                    return Boolean.TRUE;
                case 7:
                    jSONLexer.nextToken();
                    return Boolean.FALSE;
                case 8:
                    jSONLexer.nextToken();
                    return null;
                case 9:
                    jSONLexer.nextToken(18);
                    if (jSONLexer.token() == 18) {
                        jSONLexer.nextToken(10);
                        accept(10);
                        long longValue = jSONLexer.integerValue().longValue();
                        accept(2);
                        accept(11);
                        return new Date(longValue);
                    }
                    throw new JSONException("syntax error");
                default:
                    switch (i) {
                        case 20:
                            if (jSONLexer.isBlankInput()) {
                                return null;
                            }
                            throw new JSONException("unterminated json string, pos " + jSONLexer.getBufferPosition());
                        case 21:
                            jSONLexer.nextToken();
                            HashSet hashSet = new HashSet();
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            jSONLexer.nextToken();
                            TreeSet treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            jSONLexer.nextToken();
                            return null;
                        default:
                            throw new JSONException("syntax error, pos " + jSONLexer.getBufferPosition());
                    }
            }
        } else {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        IntegerCodec deserializer;
        Object deserialze;
        if (this.lexer.token() == 21 || this.lexer.token() == 22) {
            this.lexer.nextToken();
        }
        if (this.lexer.token() != 14) {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token()) + ", " + this.lexer.info());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
        }
        ParseContext parseContext = this.context;
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (this.lexer.token() == 16) {
                        this.lexer.nextToken();
                    }
                }
                if (this.lexer.token() == 15) {
                    setContext(parseContext);
                    this.lexer.nextToken(16);
                    return;
                }
                String str = null;
                if (Integer.TYPE == type) {
                    collection.add(IntegerCodec.instance.deserialze(this, null, null));
                } else if (String.class == type) {
                    if (this.lexer.token() == 4) {
                        str = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        Object parse = parse();
                        if (parse != null) {
                            str = parse.toString();
                        }
                    }
                    collection.add(str);
                } else {
                    if (this.lexer.token() == 8) {
                        this.lexer.nextToken();
                        deserialze = null;
                    } else {
                        deserialze = deserializer.deserialze(this, type, Integer.valueOf(i2));
                    }
                    collection.add(deserialze);
                    checkListResolve(collection);
                }
                if (this.lexer.token() == 16) {
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
                i = i2 + 1;
            } catch (Throwable th) {
                setContext(parseContext);
                throw th;
            }
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos());
        }
        jSONLexer.nextToken(4);
        ParseContext parseContext = this.context;
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                int i3 = jSONLexer.token();
                Object[] objArr = null;
                if (i3 == 2) {
                    objArr = jSONLexer.integerValue();
                    jSONLexer.nextToken(16);
                } else if (i3 == 3) {
                    objArr = jSONLexer.isEnabled(Feature.UseBigDecimal) ? jSONLexer.decimalValue(true) : jSONLexer.decimalValue(false);
                    jSONLexer.nextToken(16);
                } else if (i3 == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextToken(16);
                    objArr = stringVal;
                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                        JSONScanner jSONScanner = new JSONScanner(stringVal);
                        objArr = stringVal;
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            objArr = jSONScanner.getCalendar().getTime();
                        }
                        jSONScanner.close();
                    }
                } else if (i3 == 6) {
                    objArr = Boolean.TRUE;
                    jSONLexer.nextToken(16);
                } else if (i3 == 7) {
                    objArr = Boolean.FALSE;
                    jSONLexer.nextToken(16);
                } else if (i3 == 8) {
                    jSONLexer.nextToken(4);
                } else if (i3 == 12) {
                    objArr = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i2));
                } else if (i3 == 20) {
                    throw new JSONException("unclosed jsonArray");
                } else {
                    if (i3 == 23) {
                        jSONLexer.nextToken(4);
                    } else if (i3 == 14) {
                        JSONArray jSONArray = new JSONArray();
                        parseArray(jSONArray, Integer.valueOf(i2));
                        objArr = jSONArray;
                        if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                            objArr = jSONArray.toArray();
                        }
                    } else if (i3 == 15) {
                        jSONLexer.nextToken(16);
                        return;
                    } else {
                        objArr = parse();
                    }
                }
                collection.add(objArr);
                checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
                i = i2 + 1;
            } finally {
                setContext(parseContext);
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        String cast;
        Class<?> cls;
        boolean z;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        } else if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= typeArr.length) {
                    break;
                }
                if (this.lexer.token() == 8) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i2];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            cast = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i2 == typeArr.length - 1 && (type instanceof Class)) {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        } else {
                            cls = null;
                            z = false;
                        }
                        if (!z || this.lexer.token() == 14) {
                            cast = this.config.getDeserializer(type).deserialze(this, type, null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            cast = TypeUtils.cast(arrayList, type, this.config);
                        }
                    } else if (this.lexer.token() == 4) {
                        cast = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i2] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() != 16) {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                } else {
                    if (i2 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i = i2 + 1;
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class) type2, (Collection) arrayList);
            return arrayList;
        } else if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class) type3, (Collection) arrayList2);
                return arrayList2;
            } else if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            } else {
                throw new JSONException("not support type : " + type);
            }
        } else {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length != 1) {
                    throw new JSONException("not support : " + typeVariable);
                }
                Type type4 = bounds[0];
                if (type4 instanceof Class) {
                    ArrayList arrayList3 = new ArrayList();
                    parseArray((Class) type4, (Collection) arrayList3);
                    return arrayList3;
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                ArrayList arrayList4 = new ArrayList();
                parseArray(parameterizedType, arrayList4);
                return arrayList4;
            }
            throw new JSONException("TODO : " + type);
        }
    }

    public void parseExtra(Object obj, String str) {
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            Type type2 = null;
            while (true) {
                type = type2;
                if (!it.hasNext()) {
                    break;
                }
                type2 = it.next().getExtraType(obj, str);
            }
        }
        Object parse = type == null ? parse() : parseObject(type);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parse);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor extraProcessor : list2) {
                extraProcessor.processExtra(obj, str, parse);
            }
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type type2 = type;
        if (this.lexer.token() == 4) {
            Type unwrap = TypeUtils.unwrap(type);
            if (unwrap == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            type2 = unwrap;
            if (unwrap == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type2).deserialze(this, type2, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x0427, code lost:
        r0.nextToken(16);
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x043d, code lost:
        if (r0.token() != 13) goto L488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0440, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0444, code lost:
        r0.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x044f, code lost:
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0451, code lost:
        r0 = r6.config.getDeserializer(r0);
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0463, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer) == false) goto L477;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0466, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x046a, code lost:
        r7 = ((com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer) r0).createInstance(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0480, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L483;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0483, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0487, code lost:
        r7 = ((com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0).createInstance(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0495, code lost:
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0498, code lost:
        if (r7 != null) goto L474;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x04a0, code lost:
        if (r0 != java.lang.Cloneable.class) goto L466;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04a7, code lost:
        r8 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x04be, code lost:
        if ("java.util.Collections$EmptyMap".equals(r0) == false) goto L472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04c1, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x04c5, code lost:
        r8 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x04d0, code lost:
        r8 = r0.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x04d7, code lost:
        setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04dd, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x04de, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04ee, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04ef, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x04f3, code lost:
        setResolveStatus(2);
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0500, code lost:
        if (r6.context == null) goto L501;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0503, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x050b, code lost:
        if ((r8 instanceof java.lang.Integer) != false) goto L501;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x050e, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0512, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0516, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0520, code lost:
        if (r7.size() <= 0) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0523, code lost:
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0527, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r7, (java.lang.Class<java.lang.Object>) r0, r6.config);
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0536, code lost:
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0542, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0561, code lost:
        return r6.config.getDeserializer(r0).deserialze(r6, r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x0c92, code lost:
        r7 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0a66  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0aa6  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0abb  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0acf  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0b09  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x0ca5  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0562 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:663:0x0888 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0aec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 3302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer innterSerializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : deserializer instanceof ASMJavaBeanDeserializer ? ((ASMJavaBeanDeserializer) deserializer).getInnterSerializer() : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = innterSerializer != null ? innterSerializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer != null) {
                Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                Type type = fieldDeserializer.fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            } else if (!this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
            } else {
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            }
        }
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }
}
