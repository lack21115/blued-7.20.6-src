package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/MethodUtils.class */
public class MethodUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    private static Map<String, Method> sMethodCache = new HashMap();
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        sPrimitiveToWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        sPrimitiveToWrapperMap.put(Byte.TYPE, Byte.class);
        sPrimitiveToWrapperMap.put(Character.TYPE, Character.class);
        sPrimitiveToWrapperMap.put(Short.TYPE, Short.class);
        sPrimitiveToWrapperMap.put(Integer.TYPE, Integer.class);
        sPrimitiveToWrapperMap.put(Long.TYPE, Long.class);
        sPrimitiveToWrapperMap.put(Double.TYPE, Double.class);
        sPrimitiveToWrapperMap.put(Float.TYPE, Float.class);
        sPrimitiveToWrapperMap.put(Void.TYPE, Void.class);
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method method2;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        Method method3 = method;
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                method2 = cls2.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                method2 = method3;
            }
            method3 = method2;
            if (method2 == null) {
                method3 = method2;
                try {
                    Method[] declaredMethods = cls2.getDeclaredMethods();
                    Method method4 = method2;
                    int length = declaredMethods.length;
                    int i = 0;
                    while (true) {
                        method3 = method2;
                        if (i >= length) {
                            break;
                        }
                        Method method5 = declaredMethods[i];
                        Method method6 = method2;
                        if (method5 != null) {
                            method6 = method2;
                            if (TextUtils.equals(method5.getName(), str)) {
                                Method method7 = method2;
                                Class<?>[] parameterTypes = method5.getParameterTypes();
                                method6 = method2;
                                if (clsArr != null) {
                                    method6 = method2;
                                    if (parameterTypes != null) {
                                        method6 = method2;
                                        if (clsArr.length == parameterTypes.length) {
                                            boolean z = true;
                                            for (int i2 = 0; i2 < clsArr.length; i2++) {
                                                Method method8 = method2;
                                                if (!isAssignableFrom(clsArr[i2], parameterTypes[i2])) {
                                                    z = false;
                                                }
                                            }
                                            method6 = method2;
                                            if (z) {
                                                method6 = method5;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                        method2 = method6;
                    }
                } catch (Throwable th) {
                }
            }
            if (method3 != null) {
                method3.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method3);
                }
                return method3;
            }
        }
        return null;
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr != null && clsArr.length > 0) {
            int length = clsArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(clsArr[i2].toString());
                sb.append("#");
                i = i2 + 1;
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
        if (matchingAccessibleConstructor != null) {
            return (T) matchingAccessibleConstructor.newInstance(objArr);
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        return invokeMethod(obj, str, objArr, toClass(objArr));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) {
        return invokeStaticMethod(cls, str, objArr, toClass(objArr));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) {
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArr);
        }
        return null;
    }

    public static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        Class<?> cls3 = cls;
        if (cls.isPrimitive()) {
            cls3 = cls;
            if (!cls2.isPrimitive()) {
                cls3 = sPrimitiveToWrapperMap.get(cls);
            }
        }
        Class<?> cls4 = cls2;
        if (cls2.isPrimitive()) {
            cls4 = cls2;
            if (!cls3.isPrimitive()) {
                cls4 = sPrimitiveToWrapperMap.get(cls2);
            }
        }
        return cls4.isAssignableFrom(cls3);
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return clsArr;
            }
            clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
            i = i2 + 1;
        }
    }
}
