package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/a/a/a.class */
public final class a implements i, j {
    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        Object[] objArr = (Object[]) obj;
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            arrayList.add(f.b(objArr[i2]));
            i = i2 + 1;
        }
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        if (type instanceof GenericArrayType) {
            throw new IllegalArgumentException("Does not support generic array!");
        }
        Class<?> componentType = ((Class) type).getComponentType();
        int a2 = aVar.a();
        Object newInstance = Array.newInstance(componentType, a2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2) {
                return newInstance;
            }
            Array.set(newInstance, i2, e.a(aVar.a(i2), componentType));
            i = i2 + 1;
        }
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
