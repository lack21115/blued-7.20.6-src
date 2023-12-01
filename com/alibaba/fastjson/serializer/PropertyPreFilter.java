package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/PropertyPreFilter.class */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
