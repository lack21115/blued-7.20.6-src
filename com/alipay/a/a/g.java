package com.alipay.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/a/a/g.class */
public final class g implements i, j {
    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            Field[] declaredFields = cls2.getDeclaredFields();
            if (cls2.equals(Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        Field field = declaredFields[i2];
                        Object obj2 = null;
                        if (field != null) {
                            if (obj == null) {
                                obj2 = null;
                            } else if ("this$0".equals(field.getName())) {
                                obj2 = null;
                            } else {
                                boolean isAccessible = field.isAccessible();
                                field.setAccessible(true);
                                Object obj3 = field.get(obj);
                                if (obj3 == null) {
                                    obj2 = null;
                                } else {
                                    field.setAccessible(isAccessible);
                                    obj2 = f.b(obj3);
                                }
                            }
                        }
                        if (obj2 != null) {
                            treeMap.put(field.getName(), obj2);
                        }
                        i = i2 + 1;
                    }
                }
            }
            cls = cls2.getSuperclass();
        }
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(org.json.alipay.b.class)) {
            org.json.alipay.b bVar = (org.json.alipay.b) obj;
            Class cls = (Class) type;
            Object newInstance = cls.newInstance();
            while (!cls.equals(Object.class)) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    int length = declaredFields.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < length) {
                            Field field = declaredFields[i2];
                            String name = field.getName();
                            Type genericType = field.getGenericType();
                            if (bVar.b(name)) {
                                field.setAccessible(true);
                                field.set(newInstance, e.a(bVar.a(name), genericType));
                            }
                            i = i2 + 1;
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return newInstance;
        }
        return null;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        return true;
    }
}
