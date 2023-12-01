package com.alibaba.fastjson.serializer;

@Deprecated
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/JSONSerializerMap.class */
public class JSONSerializerMap extends SerializeConfig {
    public final boolean put(Class<?> cls, ObjectSerializer objectSerializer) {
        return super.put((JSONSerializerMap) cls, (Class<?>) objectSerializer);
    }
}
