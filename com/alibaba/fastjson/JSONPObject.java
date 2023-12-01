package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPObject.class */
public class JSONPObject implements JSONSerializable {
    private String function;
    private final List<Object> parameters = new ArrayList();

    public JSONPObject() {
    }

    public JSONPObject(String str) {
        this.function = str;
    }

    public void addParameter(Object obj) {
        this.parameters.add(obj);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String toJSONString() {
        return null;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer jSONSerializer, Object obj, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        serializeWriter.write(this.function);
        serializeWriter.write(40);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.parameters.size()) {
                serializeWriter.write(41);
                return;
            }
            if (i3 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(this.parameters.get(i3));
            i2 = i3 + 1;
        }
    }
}
