package com.tencent.thumbplayer.utils;

import com.sobot.chat.widget.zxing.util.Intents;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<a> f39443a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/n$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f39444a;
        Map<Integer, Method> b;

        private a() {
        }
    }

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/n$b.class */
    public @interface b {
        boolean a() default false;

        boolean b() default false;

        boolean c() default false;
    }

    public static Method a(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        for (Map.Entry<Integer, Method> entry : b2.entrySet()) {
            Method value = entry.getValue();
            if (value != null && str.equals(value.getName()) && a(value, objArr)) {
                return value;
            }
        }
        return null;
    }

    private static boolean a(Class<?> cls) {
        Iterator<a> it = f39443a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f39444a != null && next.f39444a.equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class<?> cls, int i) {
        HashMap hashMap;
        synchronized (n.class) {
            try {
                if (a(cls)) {
                    return true;
                }
                hashMap = new HashMap();
                Method[] methods = cls.getMethods();
                int length = methods.length;
                int i2 = i;
                int i3 = 0;
                while (i3 < length) {
                    Method method = methods[i3];
                    int i4 = i2;
                    if (((b) method.getAnnotation(b.class)) != null) {
                        hashMap.put(Integer.valueOf(i2), method);
                        i4 = i2 + 1;
                    }
                    i3++;
                    i2 = i4;
                }
                a aVar = new a();
                aVar.f39444a = cls.getName();
                aVar.b = hashMap;
                f39443a.add(aVar);
                return true;
            } catch (Exception e) {
                hashMap.clear();
                return false;
            } finally {
            }
        }
    }

    private static boolean a(Class<?> cls, Object obj) {
        if (cls.isPrimitive()) {
            try {
                return obj.getClass().getField(Intents.WifiConnect.TYPE).get(null).equals(cls);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private static boolean a(Method method, Object[] objArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (objArr == null || objArr.length == 0) {
            return parameterTypes.length == 0;
        } else if (parameterTypes.length != objArr.length) {
            return false;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= parameterTypes.length) {
                    return true;
                }
                Class<?> cls = parameterTypes[i2];
                if (objArr[i2] == null) {
                    if (cls.isPrimitive()) {
                        return false;
                    }
                } else if (!cls.isAssignableFrom(objArr[i2].getClass()) && !a(cls, objArr[i2])) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    }

    public static int b(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null) {
            return -1;
        }
        for (Map.Entry<Integer, Method> entry : b2.entrySet()) {
            Method value = entry.getValue();
            if (value != null && str.equals(value.getName()) && a(value, objArr)) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public static String b(Class<?> cls, int i) {
        Method method;
        Map<Integer, Method> b2 = b(cls);
        return (b2 == null || (method = b2.get(Integer.valueOf(i))) == null) ? "unknown" : method.getName();
    }

    private static Map<Integer, Method> b(Class<?> cls) {
        Iterator<a> it = f39443a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f39444a != null && next.f39444a.equals(cls.getName())) {
                return next.b;
            }
        }
        return null;
    }

    public static boolean c(Class<?> cls, int i) {
        Method method;
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null || (method = b2.get(Integer.valueOf(i))) == null) {
            return false;
        }
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (exceptionTypes == null || exceptionTypes.length <= 0) {
            b bVar = (b) method.getAnnotation(b.class);
            if (bVar != null) {
                return bVar.a();
            }
            return false;
        }
        return true;
    }

    public static boolean d(Class<?> cls, int i) {
        Method method;
        b bVar;
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null || (method = b2.get(Integer.valueOf(i))) == null || (bVar = (b) method.getAnnotation(b.class)) == null) {
            return false;
        }
        return bVar.b();
    }

    public static boolean e(Class<?> cls, int i) {
        Method method;
        b bVar;
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null || (method = b2.get(Integer.valueOf(i))) == null || (bVar = (b) method.getAnnotation(b.class)) == null) {
            return false;
        }
        return bVar.c();
    }

    public static Method f(Class<?> cls, int i) {
        Map<Integer, Method> b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        return b2.get(Integer.valueOf(i));
    }
}
