package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/TypeReference.class */
public class TypeReference<T> {
    public static final Type LIST_STRING = new TypeReference<List<String>>() { // from class: com.alibaba.fastjson.TypeReference.1
    }.getType();
    protected final Type type;

    public TypeReference() {
        this.type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected TypeReference(Type... typeArr) {
        int i = 0;
        ParameterizedType parameterizedType = (ParameterizedType) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= actualTypeArguments.length) {
                break;
            }
            int i4 = i3;
            if (actualTypeArguments[i] instanceof TypeVariable) {
                i4 = i3 + 1;
                actualTypeArguments[i] = typeArr[i3];
                if (i4 >= typeArr.length) {
                    break;
                }
            }
            i++;
            i2 = i4;
        }
        this.type = new ParameterizedTypeImpl(actualTypeArguments, getClass(), rawType);
    }

    public Type getType() {
        return this.type;
    }
}
