package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer.class */
public abstract class ASMJavaBeanDeserializer implements ObjectDeserializer {
    private JavaBeanDeserializer serializer;

    public ASMJavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this.serializer = new JavaBeanDeserializer(parserConfig, cls, cls);
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        return parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser) {
        JavaBeanDeserializer javaBeanDeserializer = this.serializer;
        return javaBeanDeserializer.createInstance(defaultJSONParser, javaBeanDeserializer.clazz);
    }

    public abstract Object createInstance(DefaultJSONParser defaultJSONParser, Type type);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) this.serializer.deserialze(defaultJSONParser, type, obj);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        return (T) this.serializer.deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return this.serializer.getFastMatchToken();
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return this.serializer.getFieldDeserializer(str);
    }

    public Type getFieldType(int i) {
        return this.serializer.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public JavaBeanDeserializer getInnterSerializer() {
        return this.serializer;
    }

    public boolean isSupportArrayToBean(JSONLexer jSONLexer) {
        return this.serializer.isSupportArrayToBean(jSONLexer);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        return this.serializer.deserialze(defaultJSONParser, type, obj, obj2);
    }
}
