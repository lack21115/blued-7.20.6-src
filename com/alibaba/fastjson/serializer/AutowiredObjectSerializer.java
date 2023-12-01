package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/AutowiredObjectSerializer.class */
public interface AutowiredObjectSerializer extends ObjectSerializer {
    Set<Type> getAutowiredFor();
}
