package com.kuaishou.weapon.p0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dg.class */
public class dg {
    public static Object a(Class<?> cls, Object obj, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object a(Class<?> cls, Object obj, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            Class<?>[] clsArr2 = new Class[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                clsArr = clsArr2;
                if (i2 >= objArr.length) {
                    break;
                }
                clsArr2[i2] = objArr[i2].getClass();
                i = i2 + 1;
            }
        } else {
            clsArr = null;
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object a(String str, Object obj, String str2, Object... objArr) {
        return a(Class.forName(str), obj, str2, objArr);
    }

    public static Object a(String str, String str2) {
        return a(Class.forName(str), (Object) null, str2);
    }

    public static Method a(Class cls, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            try {
                Class<?>[] clsArr2 = new Class[objArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    clsArr = clsArr2;
                    if (i2 >= objArr.length) {
                        break;
                    }
                    clsArr2[i2] = objArr[i2].getClass();
                    i = i2 + 1;
                }
            } catch (Exception e) {
                return null;
            }
        } else {
            clsArr = null;
        }
        return cls.getDeclaredMethod(str, clsArr);
    }
}
