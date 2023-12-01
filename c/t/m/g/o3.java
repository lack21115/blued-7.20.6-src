package c.t.m.g;

import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o3.class */
public class o3 {
    public static Object a(Class<?> cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = m3.c(clsArr) ? cls.getDeclaredMethod(str, new Class[0]) : cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                g3.a();
                return null;
            }
            boolean isAccessible = declaredMethod.isAccessible();
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, objArr);
            declaredMethod.setAccessible(isAccessible);
            return invoke;
        } catch (Throwable th) {
            g3.a();
            return null;
        }
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return a(obj.getClass(), obj, str, clsArr, objArr);
    }
}
