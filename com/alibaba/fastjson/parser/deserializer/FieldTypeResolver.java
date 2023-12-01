package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/FieldTypeResolver.class */
public interface FieldTypeResolver extends ParseProcess {
    Type resolve(Object obj, String str);
}
