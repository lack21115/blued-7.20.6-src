package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/an.class */
public abstract class an {
    private static final String Code = "ReflectAPI";

    public static Class Code(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                return cls;
            }
            return null;
        } catch (ClassNotFoundException e) {
            ge.I(Code, "classNoFound %s", str);
            return null;
        }
    }

    public static Class Code(Field field) {
        int i;
        if (Map.class.isAssignableFrom(field.getType())) {
            i = 1;
        } else if (!List.class.isAssignableFrom(field.getType())) {
            return null;
        } else {
            i = 0;
        }
        return Code(field, i);
    }

    public static Class Code(Field field, int i) {
        Type[] actualTypeArguments;
        StringBuilder sb;
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i) {
            return null;
        }
        try {
            if (actualTypeArguments[i] instanceof Class) {
                return (Class) actualTypeArguments[i];
            }
            String obj = actualTypeArguments[i].toString();
            int indexOf = obj.indexOf("class ");
            int i2 = indexOf;
            if (indexOf < 0) {
                i2 = 0;
            }
            int indexOf2 = obj.indexOf(SimpleComparison.LESS_THAN_OPERATION);
            int i3 = indexOf2;
            if (indexOf2 < 0) {
                i3 = obj.length();
            }
            return Class.forName(obj.substring(i2, i3));
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getType ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getType ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        }
    }

    public static Object Code(Class cls, String str) {
        String str2;
        Field V = V(cls, str);
        if (V == null) {
            return null;
        }
        Code(V, true);
        try {
            return V.get(null);
        } catch (IllegalAccessException e) {
            str2 = "getFieldValue IllegalAccessException";
            ge.I(Code, str2);
            return null;
        } catch (Exception e2) {
            str2 = "getFieldValue " + e2.getClass().getSimpleName();
            ge.I(Code, str2);
            return null;
        }
    }

    public static Object Code(Object obj, Class cls, String str, Class<?>[] clsArr, Object[] objArr) {
        StringBuilder sb;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (NoSuchMethodException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("invokeMethod ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("invokeMethod ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        }
    }

    public static Field Code(Field field, boolean z) {
        field.setAccessible(z);
        return field;
    }

    public static boolean Code(String str, String str2, Class<?>[] clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (ClassNotFoundException e) {
            ge.I(Code, "class not found for %s", str);
            return false;
        } catch (NoSuchMethodException e2) {
            ge.I(Code, "method not found for %s", str2);
            return false;
        } catch (Throwable th) {
            ge.I(Code, "isMethodAvailable %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public static Field[] Code(Class cls) {
        Field[] Code2 = cls.getSuperclass() != null ? Code(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        Field[] fieldArr = declaredFields;
        if (Code2 != null) {
            fieldArr = declaredFields;
            if (Code2.length > 0) {
                fieldArr = new Field[declaredFields.length + Code2.length];
                System.arraycopy(Code2, 0, fieldArr, 0, Code2.length);
                System.arraycopy(declaredFields, 0, fieldArr, Code2.length, declaredFields.length);
            }
        }
        return fieldArr;
    }

    public static boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            ge.I(Code, "class not found for %s", str);
            return false;
        }
    }

    public static Object V(String str) {
        StringBuilder sb;
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                return cls.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        }
    }

    public static Field V(Class cls, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            str2 = "getDeclaredField NoSuchFieldException";
            ge.I(Code, str2);
            return null;
        } catch (SecurityException e2) {
            str2 = "getDeclaredField SecurityException";
            ge.I(Code, str2);
            return null;
        }
    }
}
