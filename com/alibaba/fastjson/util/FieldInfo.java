package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/FieldInfo.class */
public class FieldInfo implements Comparable<FieldInfo> {
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final boolean getOnly;
    public final boolean isEnum;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final char[] name_chars;
    private int ordinal;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.ordinal = 0;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.isEnum = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || this.method == null;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        this.label = "";
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        this.getOnly = false;
    }

    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, JSONField jSONField, JSONField jSONField2, String str2) {
        Class<?> type2;
        Type type3;
        boolean z;
        Type inheritGenericType;
        this.ordinal = 0;
        String str3 = str;
        if (field != null) {
            String name = field.getName();
            str3 = str;
            if (name.equals(str)) {
                str3 = name;
            }
        }
        this.name = str3;
        this.method = method;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = jSONField2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || method == null;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        if (str2 == null || str2.length() <= 0) {
            this.label = "";
        } else {
            this.label = str2;
        }
        this.name_chars = genFieldNameChars();
        if (method != null) {
            TypeUtils.setAccessible(method);
        }
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                type2 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
                z = false;
            } else {
                type2 = method.getReturnType();
                type3 = method.getGenericReturnType();
                z = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            type2 = field.getType();
            Type genericType = field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            type3 = genericType;
            z = false;
        }
        this.getOnly = z;
        if (cls != null && type2 == Object.class && (type3 instanceof TypeVariable) && (inheritGenericType = getInheritGenericType(cls, (TypeVariable) type3)) != null) {
            this.fieldClass = TypeUtils.getClass(inheritGenericType);
            this.fieldType = inheritGenericType;
            this.isEnum = type2.isEnum();
            return;
        }
        Class<?> cls2 = type2;
        Type type4 = type3;
        if (!(type3 instanceof Class)) {
            type4 = getFieldType(cls, type, type3);
            cls2 = type2;
            if (type4 != type3) {
                if (type4 instanceof ParameterizedType) {
                    cls2 = TypeUtils.getClass(type4);
                } else {
                    cls2 = type2;
                    if (type4 instanceof Class) {
                        cls2 = TypeUtils.getClass(type4);
                    }
                }
            }
        }
        this.fieldType = type4;
        this.fieldClass = cls2;
        this.isEnum = cls2.isEnum();
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        boolean z;
        if (cls != null) {
            if (type == null) {
                return type2;
            }
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= typeParameters.length) {
                            break;
                        } else if (typeParameters[i2].getName().equals(typeVariable.getName())) {
                            return parameterizedType.getActualTypeArguments()[i2];
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                    TypeVariable<Class<?>>[] typeVariableArr = null;
                    Type[] typeArr = null;
                    int i3 = 0;
                    boolean z2 = false;
                    while (true) {
                        z = z2;
                        if (i3 >= actualTypeArguments.length) {
                            break;
                        }
                        Type type3 = actualTypeArguments[i3];
                        TypeVariable<Class<?>>[] typeVariableArr2 = typeVariableArr;
                        Type[] typeArr2 = typeArr;
                        boolean z3 = z;
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            typeVariableArr2 = typeVariableArr;
                            typeArr2 = typeArr;
                            z3 = z;
                            if (type instanceof ParameterizedType) {
                                TypeVariable<Class<?>>[] typeVariableArr3 = typeVariableArr;
                                if (typeVariableArr == null) {
                                    typeVariableArr3 = cls.getTypeParameters();
                                }
                                int i4 = 0;
                                while (true) {
                                    typeVariableArr2 = typeVariableArr3;
                                    typeArr2 = typeArr;
                                    z3 = z;
                                    if (i4 < typeVariableArr3.length) {
                                        Type[] typeArr3 = typeArr;
                                        if (typeVariableArr3[i4].getName().equals(typeVariable2.getName())) {
                                            typeArr3 = typeArr;
                                            if (typeArr == null) {
                                                typeArr3 = ((ParameterizedType) type).getActualTypeArguments();
                                            }
                                            actualTypeArguments[i3] = typeArr3[i4];
                                            z = true;
                                        }
                                        i4++;
                                        typeArr = typeArr3;
                                    }
                                }
                            }
                        }
                        i3++;
                        typeVariableArr = typeVariableArr2;
                        typeArr = typeArr2;
                        z2 = z3;
                    }
                    if (z) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.reflect.GenericDeclaration] */
    public static Type getInheritGenericType(Class<?> cls, TypeVariable<?> typeVariable) {
        Type genericSuperclass;
        ?? genericDeclaration = typeVariable.getGenericDeclaration();
        do {
            genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= typeParameters.length) {
                            return null;
                        }
                        if (typeParameters[i2] == typeVariable) {
                            return actualTypeArguments[i2];
                        }
                        i = i2 + 1;
                    }
                }
            }
            cls = TypeUtils.getClass(genericSuperclass);
        } while (genericSuperclass != null);
        return null;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int compareTo = this.name.compareTo(fieldInfo.name);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> declaredClass = getDeclaredClass();
        Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
        if (declaredClass != null && declaredClass2 != null && declaredClass != declaredClass2) {
            if (declaredClass.isAssignableFrom(declaredClass2)) {
                return -1;
            }
            if (declaredClass2.isAssignableFrom(declaredClass)) {
                return 1;
            }
        }
        Field field = this.field;
        boolean z = field != null && field.getType() == this.fieldClass;
        Field field2 = fieldInfo.field;
        boolean z2 = false;
        if (field2 != null) {
            z2 = false;
            if (field2.getType() == fieldInfo.fieldClass) {
                z2 = true;
            }
        }
        if (!z || z2) {
            if (!z2 || z) {
                if (!fieldInfo.fieldClass.isPrimitive() || this.fieldClass.isPrimitive()) {
                    if (!this.fieldClass.isPrimitive() || fieldInfo.fieldClass.isPrimitive()) {
                        if (!fieldInfo.fieldClass.getName().startsWith("java.") || this.fieldClass.getName().startsWith("java.")) {
                            if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
                                return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
                            }
                            return -1;
                        }
                        return 1;
                    }
                    return -1;
                }
                return 1;
            }
            return -1;
        }
        return 1;
    }

    protected char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[length + 3];
        String str = this.name;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        return method != null ? method.invoke(obj, new Object[0]) : this.field.get(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.annotation.Annotation] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.annotation.Annotation] */
    public <T extends Annotation> T getAnnation(Class<T> cls) {
        if (cls == JSONField.class) {
            return getAnnotation();
        }
        T t = null;
        Method method = this.method;
        if (method != null) {
            t = method.getAnnotation(cls);
        }
        T t2 = t;
        if (t == null) {
            Field field = this.field;
            t2 = t;
            if (field == null) {
                t2 = field.getAnnotation(cls);
            }
        }
        return t2;
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    protected Class<?> getDeclaredClass() {
        Method method = this.method;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.field;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String getFormat() {
        JSONField annotation = getAnnotation();
        String str = null;
        if (annotation != null) {
            str = annotation.format();
            if (str.trim().length() == 0) {
                return null;
            }
        }
        return str;
    }

    public Member getMember() {
        Method method = this.method;
        return method != null ? method : this.field;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public void setAccessible() throws SecurityException {
        Method method = this.method;
        if (method != null) {
            TypeUtils.setAccessible(method);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }

    public String toString() {
        return this.name;
    }
}
