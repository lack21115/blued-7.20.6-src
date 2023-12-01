package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/AppendableSerializer.class */
public class AppendableSerializer implements ObjectSerializer {
    public static final AppendableSerializer instance = new AppendableSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj != null) {
            jSONSerializer.write(obj.toString());
            return;
        }
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
            serializeWriter.writeString("");
        } else {
            serializeWriter.writeNull();
        }
    }
}
