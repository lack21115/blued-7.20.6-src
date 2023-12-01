package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/EnumSerializer.class */
public class EnumSerializer implements ObjectSerializer {
    public static final EnumSerializer instance = new EnumSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Enum r0 = (Enum) obj;
        if (serializeWriter.writeEnumUsingName && !serializeWriter.writeEnumUsingToString) {
            jSONSerializer.write(r0.name());
        } else if (serializeWriter.writeEnumUsingToString) {
            jSONSerializer.write(r0.toString());
        } else {
            serializeWriter.writeInt(r0.ordinal());
        }
    }
}
