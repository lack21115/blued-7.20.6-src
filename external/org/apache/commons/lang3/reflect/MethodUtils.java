package external.org.apache.commons.lang3.reflect;

import external.org.apache.commons.lang3.ArrayUtils;
import external.org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/reflect/MethodUtils.class */
public class MethodUtils {
    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        Method method2;
        if (MemberUtils.isAccessible(method)) {
            Class<?> declaringClass = method.getDeclaringClass();
            method2 = method;
            if (!Modifier.isPublic(declaringClass.getModifiers())) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
                method2 = accessibleMethodFromInterfaceNest;
                if (accessibleMethodFromInterfaceNest == null) {
                    return getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes);
                }
            }
        } else {
            method2 = null;
        }
        return method2;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        Class<?> cls2 = cls;
        while (true) {
            Class<?> cls3 = cls2;
            Method method2 = method;
            if (cls3 == null) {
                return method2;
            }
            Class<?>[] interfaces = cls3.getInterfaces();
            int i = 0;
            while (true) {
                int i2 = i;
                method = method2;
                if (i2 >= interfaces.length) {
                    break;
                }
                if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                    try {
                        method2 = interfaces[i2].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException e) {
                    }
                    if (method2 != null) {
                        method = method2;
                        break;
                    }
                    method = getAccessibleMethodFromInterfaceNest(interfaces[i2], str, clsArr);
                    method2 = method;
                    if (method != null) {
                        break;
                    }
                }
                i = i2 + 1;
            }
            cls2 = cls3.getSuperclass();
        }
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Class<? super Object> superclass = cls.getSuperclass();
        while (true) {
            Class<? super Object> cls2 = superclass;
            method = null;
            if (cls2 == null) {
                break;
            } else if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    method = cls2.getMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                    return null;
                }
            } else {
                superclass = cls2.getSuperclass();
            }
        }
        return method;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        try {
            Method method2 = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method2);
            return method2;
        } catch (NoSuchMethodException e) {
            Method method3 = null;
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                method = method3;
                if (i2 >= length) {
                    break;
                }
                Method method4 = methods[i2];
                method3 = method;
                if (method4.getName().equals(str)) {
                    method3 = method;
                    if (ClassUtils.isAssignable(clsArr, method4.getParameterTypes(), true)) {
                        Method accessibleMethod = getAccessibleMethod(method4);
                        method3 = method;
                        if (accessibleMethod != null) {
                            if (method != null) {
                                method3 = method;
                                if (MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method.getParameterTypes(), clsArr) >= 0) {
                                }
                            }
                            method3 = accessibleMethod;
                        }
                    }
                }
                i = i2 + 1;
            }
            if (method != null) {
                MemberUtils.setAccessibleWorkaround(method);
            }
            return method;
        }
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr2.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return invokeExactMethod(obj, str, objArr2, clsArr);
            }
            clsArr[i2] = objArr2[i2].getClass();
            i = i2 + 1;
        }
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr2);
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return accessibleMethod.invoke(obj, objArr2);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr2.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return invokeExactStaticMethod(cls, str, objArr2, clsArr);
            }
            clsArr[i2] = objArr2[i2].getClass();
            i = i2 + 1;
        }
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr2);
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return accessibleMethod.invoke(null, objArr2);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr2.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return invokeMethod(obj, str, objArr2, clsArr);
            }
            clsArr[i2] = objArr2[i2].getClass();
            i = i2 + 1;
        }
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr2);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return matchingAccessibleMethod.invoke(obj, objArr2);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr2.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return invokeStaticMethod(cls, str, objArr2, clsArr);
            }
            clsArr[i2] = objArr2[i2].getClass();
            i = i2 + 1;
        }
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr2);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return matchingAccessibleMethod.invoke(null, objArr2);
    }
}
