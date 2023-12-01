package external.org.apache.commons.lang3;

import com.alipay.sdk.util.i;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/ClassUtils.class */
public class ClassUtils {
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map<String, String> abbreviationMap;
    private static final Map<String, String> reverseAbbreviationMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap();

    static {
        primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        Iterator<Class<?>> it = primitiveWrapperMap.keySet().iterator();
        if (it.hasNext()) {
            primitiveWrapperMap.get(it.next());
            throw new VerifyError("bad dex opcode");
        }
        abbreviationMap = new HashMap();
        reverseAbbreviationMap = new HashMap();
        addAbbreviation("int", "I");
        addAbbreviation("boolean", "Z");
        addAbbreviation("float", "F");
        addAbbreviation("long", "J");
        addAbbreviation("short", "S");
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation("char", "C");
    }

    private static void addAbbreviation(String str, String str2) {
        abbreviationMap.put(str, str2);
        reverseAbbreviationMap.put(str2, str);
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        ArrayList arrayList;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                try {
                    arrayList2.add(Class.forName(it.next()));
                } catch (Exception e) {
                    arrayList2.add(null);
                }
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        ArrayList arrayList;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<Class<?>> it = list.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                Class<?> next = it.next();
                if (next == null) {
                    arrayList2.add(null);
                } else {
                    arrayList2.add(next.getName());
                }
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Class<?> cls2 = interfaces[i2];
                    if (hashSet.add(cls2)) {
                        getAllInterfaces(cls2, hashSet);
                    }
                    i = i2 + 1;
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        ArrayList arrayList;
        if (cls != null) {
            ArrayList arrayList2 = new ArrayList();
            Class<? super Object> superclass = cls.getSuperclass();
            while (true) {
                Class<? super Object> cls2 = superclass;
                arrayList = arrayList2;
                if (cls2 == null) {
                    break;
                }
                arrayList2.add(cls2);
                superclass = cls2.getSuperclass();
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private static String getCanonicalName(String str) {
        String str2;
        String str3;
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            str2 = null;
        } else {
            int i = 0;
            while (deleteWhitespace.startsWith("[")) {
                i++;
                deleteWhitespace = deleteWhitespace.substring(1);
            }
            str2 = deleteWhitespace;
            if (i >= 1) {
                if (deleteWhitespace.startsWith("L")) {
                    str3 = deleteWhitespace.substring(1, deleteWhitespace.endsWith(i.b) ? deleteWhitespace.length() - 1 : deleteWhitespace.length());
                } else {
                    str3 = deleteWhitespace;
                    if (deleteWhitespace.length() > 0) {
                        str3 = reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
                    }
                }
                StringBuilder sb = new StringBuilder(str3);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        return sb.toString();
                    }
                    sb.append("[]");
                    i2 = i3 + 1;
                }
            }
        }
        return str2;
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        try {
            return abbreviationMap.containsKey(str) ? Class.forName("[" + abbreviationMap.get(str), z, classLoader).getComponentType() : Class.forName(toCanonicalName(str), z, classLoader);
        } catch (ClassNotFoundException e) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return getClass(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z);
                } catch (ClassNotFoundException e2) {
                    throw e;
                }
            }
            throw e;
        }
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static Class<?> getClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(Class<?> cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    public static String getPackageName(String str) {
        if (str != null) {
            String str2 = str;
            if (str.length() == 0) {
                return "";
            }
            while (str2.charAt(0) == '[') {
                str2 = str2.substring(1);
            }
            String str3 = str2;
            if (str2.charAt(0) == 'L') {
                str3 = str2;
                if (str2.charAt(str2.length() - 1) == ';') {
                    str3 = str2.substring(1);
                }
            }
            int lastIndexOf = str3.lastIndexOf(46);
            return lastIndexOf == -1 ? "" : str3.substring(0, lastIndexOf);
        }
        return "";
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException, NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException e) {
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + str + " " + ArrayUtils.toString(clsArr));
    }

    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(Class<?> cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static String getShortClassName(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append("[]");
            }
            str2 = str;
            if (str.charAt(0) == 'L') {
                str2 = str;
                if (str.charAt(str.length() - 1) == ';') {
                    str2 = str.substring(1, str.length() - 1);
                }
            }
        }
        String str3 = str2;
        if (reverseAbbreviationMap.containsKey(str2)) {
            str3 = reverseAbbreviationMap.get(str2);
        }
        int lastIndexOf = str3.lastIndexOf(46);
        if (lastIndexOf != -1) {
            i = lastIndexOf + 1;
        }
        int indexOf = str3.indexOf(36, i);
        String substring = str3.substring(lastIndexOf + 1);
        String str4 = substring;
        if (indexOf != -1) {
            str4 = substring.replace('$', '.');
        }
        return str4 + ((Object) sb);
    }

    public static String getSimpleName(Class<?> cls) {
        return cls == null ? "" : cls.getSimpleName();
    }

    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : getSimpleName(obj.getClass());
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        Class<?> cls3 = cls;
        if (z) {
            Class<?> cls4 = cls;
            if (cls.isPrimitive()) {
                cls4 = cls;
                if (!cls2.isPrimitive()) {
                    cls4 = primitiveToWrapper(cls);
                    if (cls4 == null) {
                        return false;
                    }
                }
            }
            cls3 = cls4;
            if (cls2.isPrimitive()) {
                cls3 = cls4;
                if (!cls4.isPrimitive()) {
                    cls3 = wrapperToPrimitive(cls4);
                    if (cls3 == null) {
                        return false;
                    }
                }
            }
        }
        if (cls3.equals(cls2)) {
            return true;
        }
        if (cls3.isPrimitive()) {
            if (cls2.isPrimitive()) {
                if (Integer.TYPE.equals(cls3)) {
                    return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                } else if (Long.TYPE.equals(cls3)) {
                    return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                } else if (Boolean.TYPE.equals(cls3) || Double.TYPE.equals(cls3)) {
                    return false;
                } else {
                    if (Float.TYPE.equals(cls3)) {
                        return Double.TYPE.equals(cls2);
                    }
                    if (Character.TYPE.equals(cls3)) {
                        return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Short.TYPE.equals(cls3)) {
                        return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Byte.TYPE.equals(cls3)) {
                        return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
        return cls2.isAssignableFrom(cls3);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ArrayUtils.isSameLength(clsArr, clsArr2)) {
            return false;
        }
        Class<?>[] clsArr3 = clsArr;
        if (clsArr == null) {
            clsArr3 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr4 = clsArr2;
        if (clsArr2 == null) {
            clsArr4 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr3.length) {
                return true;
            }
            if (!isAssignable(clsArr3[i2], clsArr4[i2], z)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return wrapperPrimitiveMap.containsKey(cls);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        Class<?> cls2 = cls;
        if (cls != null) {
            cls2 = cls;
            if (cls.isPrimitive()) {
                cls2 = primitiveWrapperMap.get(cls);
            }
        }
        return cls2;
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        Class<?>[] clsArr2;
        if (clsArr == null) {
            clsArr2 = null;
        } else {
            clsArr2 = clsArr;
            if (clsArr.length != 0) {
                Class<?>[] clsArr3 = new Class[clsArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= clsArr.length) {
                        return clsArr3;
                    }
                    clsArr3[i2] = primitiveToWrapper(clsArr[i2]);
                    i = i2 + 1;
                }
            }
        }
        return clsArr2;
    }

    private static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            throw new NullPointerException("className must not be null.");
        }
        String str2 = deleteWhitespace;
        if (deleteWhitespace.endsWith("[]")) {
            StringBuilder sb = new StringBuilder();
            while (deleteWhitespace.endsWith("[]")) {
                deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                sb.append("[");
            }
            String str3 = abbreviationMap.get(deleteWhitespace);
            if (str3 != null) {
                sb.append(str3);
            } else {
                sb.append("L").append(deleteWhitespace).append(i.b);
            }
            str2 = sb.toString();
        }
        return str2;
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
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

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        Class<?>[] clsArr2;
        if (clsArr == null) {
            clsArr2 = null;
        } else {
            clsArr2 = clsArr;
            if (clsArr.length != 0) {
                Class<?>[] clsArr3 = new Class[clsArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= clsArr.length) {
                        return clsArr3;
                    }
                    clsArr3[i2] = wrapperToPrimitive(clsArr[i2]);
                    i = i2 + 1;
                }
            }
        }
        return clsArr2;
    }
}
