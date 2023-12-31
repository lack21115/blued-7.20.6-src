package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/JSONSerializableSerializer.class */
public class JSONSerializableSerializer implements ObjectSerializer {
    public static JSONSerializableSerializer instance = new JSONSerializableSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        ((JSONSerializable) obj).write(jSONSerializer, obj2, type, 0);
    }
}
