package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/JavaBeanInfo.class */
public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = this.fields;
        FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
        int i = 0;
        System.arraycopy(fieldInfoArr2, 0, fieldInfoArr3, 0, fieldInfoArr2.length);
        Arrays.sort(fieldInfoArr3);
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr3) ? this.fields : fieldInfoArr3;
        this.defaultConstructorParameterSize = constructor != null ? constructor.getParameterTypes().length : i;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        int i;
        FieldInfo fieldInfo2;
        int size = list.size();
        while (true) {
            i = size - 1;
            if (i < 0) {
                break;
            }
            fieldInfo2 = list.get(i);
            if (!fieldInfo2.name.equals(fieldInfo.name) || (fieldInfo2.getOnly && !fieldInfo.getOnly)) {
                size = i;
            }
        }
        if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
            list.remove(i);
        } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
            return false;
        } else {
            list.remove(i);
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0413, code lost:
        if (r23.length() == 0) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x028a, code lost:
        if (r21.length() == 0) goto L285;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x07cc A[EDGE_INSN: B:299:0x07cc->B:223:0x07cc ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> r14, java.lang.reflect.Type r15) {
        /*
            Method dump skipped, instructions count: 2316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.build(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.util.JavaBeanInfo");
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        Class<?> builder;
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    public static Constructor<?> getCreatorConstructor(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        Constructor<?> constructor = null;
        int i = 0;
        while (i < length) {
            Constructor<?> constructor2 = declaredConstructors[i];
            Constructor<?> constructor3 = constructor;
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor3 = constructor2;
            }
            i++;
            constructor = constructor3;
        }
        return constructor;
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls) {
        Constructor<?> constructor;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            constructor = null;
            if (i2 >= length) {
                break;
            }
            constructor = declaredConstructors[i2];
            if (constructor.getParameterTypes().length == 0) {
                break;
            }
            i = i2 + 1;
        }
        if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            int length2 = declaredConstructors.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                Constructor<?> constructor2 = declaredConstructors[i4];
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor2;
                }
                i3 = i4 + 1;
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr) {
        Method method;
        int length = methodArr.length;
        Method method2 = null;
        int i = 0;
        while (i < length) {
            Method method3 = methodArr[i];
            if (!Modifier.isStatic(method3.getModifiers())) {
                method = method2;
            } else if (cls.isAssignableFrom(method3.getReturnType())) {
                method = method2;
                if (((JSONCreator) method3.getAnnotation(JSONCreator.class)) == null) {
                    continue;
                } else if (method2 != null) {
                    throw new JSONException("multi-JSONCreator");
                } else {
                    method = method3;
                }
            } else {
                method = method2;
            }
            i++;
            method2 = method;
        }
        return method2;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str)) {
                return fieldInfo;
            }
        }
        return null;
    }
}
