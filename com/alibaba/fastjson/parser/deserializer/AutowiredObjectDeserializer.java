package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/AutowiredObjectDeserializer.class */
public interface AutowiredObjectDeserializer extends ObjectDeserializer {
    Set<Type> getAutowiredFor();
}
