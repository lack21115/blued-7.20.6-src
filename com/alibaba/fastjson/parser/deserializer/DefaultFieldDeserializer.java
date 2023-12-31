package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer.class */
public class DefaultFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        if (this.fieldValueDeserilizer == null) {
            this.fieldValueDeserilizer = defaultJSONParser.getConfig().getDeserializer(this.fieldInfo);
        }
        if (type instanceof ParameterizedType) {
            defaultJSONParser.getContext().type = type;
        }
        Object deserialze = this.fieldValueDeserilizer.deserialze(defaultJSONParser, this.fieldInfo.fieldType, this.fieldInfo.name);
        if (defaultJSONParser.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser.getContext();
            defaultJSONParser.setResolveStatus(0);
        } else if (obj == null) {
            map.put(this.fieldInfo.name, deserialze);
        } else {
            setValue(obj, deserialze);
        }
    }
}
