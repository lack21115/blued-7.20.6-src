package com.alibaba.fastjson.serializer;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/ContextValueFilter.class */
public interface ContextValueFilter extends SerializeFilter {
    Object process(BeanContext beanContext, Object obj, String str, Object obj2);
}
