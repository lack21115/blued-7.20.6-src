package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.class */
public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final Type itemType;

    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        if (fieldInfo.fieldType instanceof ParameterizedType) {
            this.itemType = ((ParameterizedType) fieldInfo.fieldType).getActualTypeArguments()[0];
        } else {
            this.itemType = Object.class;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        int i;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        Type type3 = type2;
        ObjectDeserializer objectDeserializer2 = objectDeserializer;
        if (type2 instanceof TypeVariable) {
            type3 = type2;
            objectDeserializer2 = objectDeserializer;
            if (type instanceof ParameterizedType) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = null;
                if (parameterizedType.getRawType() instanceof Class) {
                    cls = (Class) parameterizedType.getRawType();
                }
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= length) {
                            break;
                        } else if (cls.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i2 = i + 1;
                        }
                    }
                }
                i = -1;
                type3 = type2;
                objectDeserializer2 = objectDeserializer;
                if (i != -1) {
                    Type type4 = parameterizedType.getActualTypeArguments()[i];
                    type3 = type4;
                    objectDeserializer2 = objectDeserializer;
                    if (!type4.equals(this.itemType)) {
                        objectDeserializer2 = defaultJSONParser.getConfig().getDeserializer(type4);
                        type3 = type4;
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token());
            String str2 = str;
            if (type != null) {
                str2 = str + ", type : " + type;
            }
            throw new JSONException(str2);
        }
        ObjectDeserializer objectDeserializer3 = objectDeserializer2;
        if (objectDeserializer2 == null) {
            objectDeserializer3 = defaultJSONParser.getConfig().getDeserializer(type3);
            this.deserializer = objectDeserializer3;
            this.itemFastMatchToken = objectDeserializer3.getFastMatchToken();
        }
        jSONLexer.nextToken(this.itemFastMatchToken);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                while (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                }
            }
            if (jSONLexer.token() == 15) {
                jSONLexer.nextToken(16);
                return;
            }
            collection.add(objectDeserializer3.deserialze(defaultJSONParser, type3, Integer.valueOf(i4)));
            defaultJSONParser.checkListResolve(collection);
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(this.itemFastMatchToken);
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        if (defaultJSONParser.lexer.token() == 8) {
            setValue(obj, (String) null);
            return;
        }
        Collection arrayList = new ArrayList();
        ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(context);
        if (obj == null) {
            map.put(this.fieldInfo.name, arrayList);
        } else {
            setValue(obj, arrayList);
        }
    }
}
