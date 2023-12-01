package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/ValueFilter.class */
public interface ValueFilter extends SerializeFilter {
    Object process(Object obj, String str, Object obj2);
}
