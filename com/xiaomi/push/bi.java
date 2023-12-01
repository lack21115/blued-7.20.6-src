package com.xiaomi.push;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bi.class */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f27591a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bi$a.class */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f27592a;

        /* renamed from: a  reason: collision with other field name */
        public final T f172a;
    }

    static {
        HashMap hashMap = new HashMap();
        f27591a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f27591a.put(Byte.class, Byte.TYPE);
        f27591a.put(Character.class, Character.TYPE);
        f27591a.put(Short.class, Short.TYPE);
        f27591a.put(Integer.class, Integer.TYPE);
        f27591a.put(Float.class, Float.TYPE);
        f27591a.put(Long.class, Long.TYPE);
        f27591a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f27591a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f27591a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f27591a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f27591a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f27591a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f27591a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f27591a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f27591a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static <T> T a(Class<? extends Object> cls, Object obj, String str) {
        Class<? extends Object> cls2 = cls;
        Field field = null;
        while (field == null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                field = declaredField;
            } catch (NoSuchFieldException e) {
                cls2 = cls2.getSuperclass();
            }
            if (cls2 == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        try {
            return (T) a(cls, (Object) null, str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls != null ? cls.getSimpleName() : "");
            sb.append(", ");
            sb.append(e);
            Log.w("JavaCalls", sb.toString());
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        return (T) a(cls, str, a(objArr)).invoke(null, m8490a(objArr));
    }

    public static <T> T a(Object obj, String str) {
        try {
            return (T) a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    public static <T> T a(String str, String str2) {
        try {
            return (T) a((Class<? extends Object>) r.a(null, str), (Object) null, str2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) a(r.a(null, str), str2, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methodArr[i2];
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
            i = i2 + 1;
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= clsArr.length) {
                    return true;
                }
                if (clsArr2[i2] != null && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!f27591a.containsKey(clsArr[i2]) || !f27591a.get(clsArr[i2]).equals(f27591a.get(clsArr2[i2])))) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    }

    private static Class<?>[] a(Object... objArr) {
        Class<?>[] clsArr = null;
        if (objArr != null) {
            clsArr = null;
            if (objArr.length > 0) {
                Class<?>[] clsArr2 = new Class[objArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        break;
                    }
                    Object obj = objArr[i2];
                    clsArr2[i2] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).f27592a;
                    i = i2 + 1;
                }
                clsArr = clsArr2;
            }
        }
        return clsArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static Object[] m8490a(Object... objArr) {
        Object[] objArr2;
        if (objArr != null && objArr.length > 0) {
            Object[] objArr3 = new Object[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                objArr2 = objArr3;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if (obj == null || !(obj instanceof a)) {
                    objArr3[i2] = obj;
                } else {
                    objArr3[i2] = ((a) obj).f172a;
                }
                i = i2 + 1;
            }
        } else {
            objArr2 = null;
        }
        return objArr2;
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        return (T) a(obj.getClass(), str, a(objArr)).invoke(obj, m8490a(objArr));
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<? super Object> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }
}
