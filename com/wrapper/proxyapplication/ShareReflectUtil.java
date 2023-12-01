package com.wrapper.proxyapplication;

import android.content.Context;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/ShareReflectUtil.class */
public class ShareReflectUtil {
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        findField.set(obj, objArr3);
    }

    public static Constructor<?> findConstructor(Object obj, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> declaredConstructor;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchMethodException("Constructor with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
            }
            try {
                declaredConstructor = cls2.getDeclaredConstructor(clsArr);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchMethodException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredConstructor;
    }

    public static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        Field declaredField;
        Class<?> cls2 = cls;
        while (true) {
            Class<?> cls3 = cls2;
            if (cls3 == null) {
                throw new NoSuchFieldException("Field " + str + " not found in " + cls);
            }
            try {
                declaredField = cls3.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchFieldException e) {
                cls2 = cls3.getSuperclass();
            }
        }
        return declaredField;
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        Field declaredField;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
            }
            try {
                declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchFieldException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredField;
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
            }
            try {
                declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchMethodException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredMethod;
    }

    public static Object getActivityThread(Context context, Class<?> cls) {
        Class<?> cls2 = cls;
        if (cls == null) {
            try {
                cls2 = Class.forName("android.app.ActivityThread");
            } catch (Throwable th) {
                return null;
            }
        }
        Method method = cls2.getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        Object obj = invoke;
        if (invoke == null) {
            obj = invoke;
            if (context != null) {
                Field field = context.getClass().getField("mLoadedApk");
                field.setAccessible(true);
                Object obj2 = field.get(context);
                Field declaredField = obj2.getClass().getDeclaredField("mActivityThread");
                declaredField.setAccessible(true);
                obj = declaredField.get(obj2);
            }
        }
        return obj;
    }

    public static int getValueOfStaticIntField(Class<?> cls, String str, int i) {
        try {
            return findField(cls, str).getInt(null);
        } catch (Throwable th) {
            return i;
        }
    }

    public static void reduceFieldArray(Object obj, String str, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (i <= 0) {
            return;
        }
        Field findField = findField(obj, str);
        Object[] objArr = (Object[]) findField.get(obj);
        int length = objArr.length - i;
        if (length <= 0) {
            return;
        }
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
        System.arraycopy(objArr, i, objArr2, 0, length);
        findField.set(obj, objArr2);
    }
}
