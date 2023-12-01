package de.robv.android.xposed;

import android.content.res.Resources;
import com.anythink.core.common.k.f;
import dalvik.system.DexFile;
import de.robv.android.xposed.XC_MethodHook;
import external.org.apache.commons.lang3.ClassUtils;
import external.org.apache.commons.lang3.reflect.MemberUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipFile;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedHelpers.class */
public final class XposedHelpers {
    private static final HashMap<String, Field> fieldCache = new HashMap<>();
    private static final HashMap<String, Method> methodCache = new HashMap<>();
    private static final HashMap<String, Constructor<?>> constructorCache = new HashMap<>();
    private static final WeakHashMap<Object, HashMap<String, Object>> additionalFields = new WeakHashMap<>();
    private static final HashMap<String, ThreadLocal<AtomicInteger>> sMethodDepth = new HashMap<>();

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedHelpers$ClassNotFoundError.class */
    public static final class ClassNotFoundError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public ClassNotFoundError(String str, Throwable th) {
            super(str, th);
        }

        public ClassNotFoundError(Throwable th) {
            super(th);
        }
    }

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedHelpers$InvocationTargetError.class */
    public static final class InvocationTargetError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public InvocationTargetError(Throwable th) {
            super(th);
        }
    }

    private XposedHelpers() {
    }

    public static byte[] assetAsByteArray(Resources resources, String str) throws IOException {
        return inputStreamToByteArray(resources.getAssets().open(str));
    }

    public static Object callMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, clsArr, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callMethod(Object obj, String str, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, clsArr, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(DexFile dexFile) {
        if (dexFile != null) {
            try {
                dexFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static int decrementMethodDepth(String str) {
        return getMethodDepthCounter(str).get().decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean fileContains(File file, String str) throws IOException {
        BufferedReader bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        closeSilently(bufferedReader);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeSilently(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains(str));
            closeSilently(bufferedReader);
            return true;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> cls, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        return XposedBridge.hookMethod(findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(String str, ClassLoader classLoader, Object... objArr) {
        return findAndHookConstructor(findClass(str, classLoader), objArr);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(Class<?> cls, String str, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        return XposedBridge.hookMethod(findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findAndHookMethod(findClass(str, classLoader), str2, objArr);
    }

    public static Class<?> findClass(String str, ClassLoader classLoader) {
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = XposedBridge.BOOTCLASSLOADER;
        }
        try {
            return ClassUtils.getClass(classLoader2, str, false);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundError(e);
        }
    }

    public static Class<?> findClassIfExists(String str, ClassLoader classLoader) {
        try {
            return findClass(str, classLoader);
        } catch (ClassNotFoundError e) {
            return null;
        }
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> cls, Class<?>... clsArr) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        String str = cls.getName() + getParametersString(clsArr) + "#bestmatch";
        if (constructorCache.containsKey(str)) {
            Constructor<?> constructor3 = constructorCache.get(str);
            constructor2 = constructor3;
            if (constructor3 == null) {
                throw new NoSuchMethodError(str);
            }
        } else {
            try {
                Constructor<?> findConstructorExact = findConstructorExact(cls, clsArr);
                constructorCache.put(str, findConstructorExact);
                constructor2 = findConstructorExact;
            } catch (NoSuchMethodError e) {
                Constructor<?> constructor4 = null;
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                int length = declaredConstructors.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    constructor = constructor4;
                    if (i2 >= length) {
                        break;
                    }
                    Constructor<?> constructor5 = declaredConstructors[i2];
                    constructor4 = constructor;
                    if (ClassUtils.isAssignable(clsArr, constructor5.getParameterTypes(), true)) {
                        if (constructor != null) {
                            constructor4 = constructor;
                            if (MemberUtils.compareParameterTypes(constructor5.getParameterTypes(), constructor.getParameterTypes(), clsArr) >= 0) {
                            }
                        }
                        constructor4 = constructor5;
                    }
                    i = i2 + 1;
                }
                if (constructor != null) {
                    constructor.setAccessible(true);
                    constructorCache.put(str, constructor);
                    return constructor;
                }
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError(str);
                constructorCache.put(str, null);
                throw noSuchMethodError;
            }
        }
        return constructor2;
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] clsArr2 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr.length) {
                return findConstructorBestMatch(cls, clsArr);
            }
            if (clsArr[i2] == null) {
                Class<?>[] clsArr3 = clsArr2;
                if (clsArr2 == null) {
                    clsArr3 = getParameterTypes(objArr);
                }
                clsArr[i2] = clsArr3[i2];
                clsArr2 = clsArr3;
            }
            i = i2 + 1;
        }
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> cls, Object... objArr) {
        return findConstructorBestMatch(cls, getParameterTypes(objArr));
    }

    public static Constructor<?> findConstructorExact(Class<?> cls, Class<?>... clsArr) {
        String str = cls.getName() + getParametersString(clsArr) + "#exact";
        if (constructorCache.containsKey(str)) {
            Constructor<?> constructor = constructorCache.get(str);
            if (constructor == null) {
                throw new NoSuchMethodError(str);
            }
            return constructor;
        }
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            constructorCache.put(str, declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            constructorCache.put(str, null);
            throw new NoSuchMethodError(str);
        }
    }

    public static Constructor<?> findConstructorExact(Class<?> cls, Object... objArr) {
        return findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Constructor<?> findConstructorExact(String str, ClassLoader classLoader, Object... objArr) {
        return findConstructorExact(findClass(str, classLoader), getParameterClasses(classLoader, objArr));
    }

    public static Constructor<?> findConstructorExactIfExists(Class<?> cls, Object... objArr) {
        try {
            return findConstructorExact(cls, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Constructor<?> findConstructorExactIfExists(String str, ClassLoader classLoader, Object... objArr) {
        try {
            return findConstructorExact(str, classLoader, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Field findField(Class<?> cls, String str) {
        String str2 = cls.getName() + '#' + str;
        if (fieldCache.containsKey(str2)) {
            Field field = fieldCache.get(str2);
            if (field == null) {
                throw new NoSuchFieldError(str2);
            }
            return field;
        }
        try {
            Field findFieldRecursiveImpl = findFieldRecursiveImpl(cls, str);
            findFieldRecursiveImpl.setAccessible(true);
            fieldCache.put(str2, findFieldRecursiveImpl);
            return findFieldRecursiveImpl;
        } catch (NoSuchFieldException e) {
            fieldCache.put(str2, null);
            throw new NoSuchFieldError(str2);
        }
    }

    public static Field findFieldIfExists(Class<?> cls, String str) {
        try {
            return findField(cls, str);
        } catch (NoSuchFieldError e) {
            return null;
        }
    }

    private static Field findFieldRecursiveImpl(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    return cls.getDeclaredField(str);
                } catch (NoSuchFieldException e2) {
                }
            }
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        r0 = r9.getSuperclass();
        r9 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field findFirstFieldByExactType(java.lang.Class<?> r5, java.lang.Class<?> r6) {
        /*
            r0 = r5
            r9 = r0
        L3:
            r0 = r9
            java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r8 = r0
            r0 = 0
            r7 = r0
        L10:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L34
            r0 = r10
            r1 = r7
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            java.lang.Class r0 = r0.getType()
            r1 = r6
            if (r0 != r1) goto L2d
            r0 = r11
            r1 = 1
            r0.setAccessible(r1)
            r0 = r11
            return r0
        L2d:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L10
        L34:
            r0 = r9
            java.lang.Class r0 = r0.getSuperclass()
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            if (r0 != 0) goto L3
            java.lang.NoSuchFieldError r0 = new java.lang.NoSuchFieldError
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Field of type "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " in class "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XposedHelpers.findFirstFieldByExactType(java.lang.Class, java.lang.Class):java.lang.reflect.Field");
    }

    public static Method findMethodBestMatch(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Class<? super Object> superclass;
        Method method2;
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#bestmatch";
        if (methodCache.containsKey(str2)) {
            Method method3 = methodCache.get(str2);
            method2 = method3;
            if (method3 == null) {
                throw new NoSuchMethodError(str2);
            }
        } else {
            try {
                Method findMethodExact = findMethodExact(cls, str, clsArr);
                methodCache.put(str2, findMethodExact);
                method2 = findMethodExact;
            } catch (NoSuchMethodError e) {
                Method method4 = null;
                boolean z = true;
                do {
                    Method[] declaredMethods = cls.getDeclaredMethods();
                    int length = declaredMethods.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        method = method4;
                        if (i2 >= length) {
                            break;
                        }
                        Method method5 = declaredMethods[i2];
                        if (z || !Modifier.isPrivate(method5.getModifiers())) {
                            method4 = method;
                            if (method5.getName().equals(str)) {
                                method4 = method;
                                if (ClassUtils.isAssignable(clsArr, method5.getParameterTypes(), true)) {
                                    if (method != null) {
                                        method4 = method;
                                        if (MemberUtils.compareParameterTypes(method5.getParameterTypes(), method.getParameterTypes(), clsArr) >= 0) {
                                        }
                                    }
                                    method4 = method5;
                                }
                            }
                        } else {
                            method4 = method;
                        }
                        i = i2 + 1;
                    }
                    z = false;
                    superclass = cls.getSuperclass();
                    method4 = method;
                    cls = superclass;
                } while (superclass != null);
                if (method != null) {
                    method.setAccessible(true);
                    methodCache.put(str2, method);
                    return method;
                }
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError(str2);
                methodCache.put(str2, null);
                throw noSuchMethodError;
            }
        }
        return method2;
    }

    public static Method findMethodBestMatch(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] clsArr2 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr.length) {
                return findMethodBestMatch(cls, str, clsArr);
            }
            if (clsArr[i2] == null) {
                Class<?>[] clsArr3 = clsArr2;
                if (clsArr2 == null) {
                    clsArr3 = getParameterTypes(objArr);
                }
                clsArr[i2] = clsArr3[i2];
                clsArr2 = clsArr3;
            }
            i = i2 + 1;
        }
    }

    public static Method findMethodBestMatch(Class<?> cls, String str, Object... objArr) {
        return findMethodBestMatch(cls, str, getParameterTypes(objArr));
    }

    public static Method findMethodExact(Class<?> cls, String str, Class<?>... clsArr) {
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#exact";
        if (methodCache.containsKey(str2)) {
            Method method = methodCache.get(str2);
            if (method == null) {
                throw new NoSuchMethodError(str2);
            }
            return method;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            methodCache.put(str2, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            methodCache.put(str2, null);
            throw new NoSuchMethodError(str2);
        }
    }

    public static Method findMethodExact(Class<?> cls, String str, Object... objArr) {
        return findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Method findMethodExact(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findMethodExact(findClass(str, classLoader), str2, getParameterClasses(classLoader, objArr));
    }

    public static Method findMethodExactIfExists(Class<?> cls, String str, Object... objArr) {
        try {
            return findMethodExact(cls, str, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Method findMethodExactIfExists(String str, ClassLoader classLoader, String str2, Object... objArr) {
        try {
            return findMethodExact(str, classLoader, str2, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Method[] findMethodsByExactParameters(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (Method[]) linkedList.toArray(new Method[linkedList.size()]);
            }
            Method method = declaredMethods[i2];
            if (cls2 == null || cls2 == method.getReturnType()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (clsArr.length == parameterTypes.length) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        z = true;
                        if (i4 >= clsArr.length) {
                            break;
                        } else if (clsArr[i4] != parameterTypes[i4]) {
                            z = false;
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    if (z) {
                        method.setAccessible(true);
                        linkedList.add(method);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public static Object getAdditionalInstanceField(Object obj, String str) {
        Object obj2;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            HashMap<String, Object> hashMap = additionalFields.get(obj);
            if (hashMap == null) {
                return null;
            }
            synchronized (hashMap) {
                obj2 = hashMap.get(str);
            }
            return obj2;
        }
    }

    public static Object getAdditionalStaticField(Class<?> cls, String str) {
        return getAdditionalInstanceField(cls, str);
    }

    public static Object getAdditionalStaticField(Object obj, String str) {
        return getAdditionalInstanceField(obj.getClass(), str);
    }

    public static boolean getBooleanField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getBoolean(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static byte getByteField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getByte(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static char getCharField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getChar(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Class<?>[] getClassesAsArray(Class<?>... clsArr) {
        return clsArr;
    }

    public static double getDoubleField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getDouble(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getFirstParameterIndexByType(Member member, Class<?> cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= parameterTypes.length) {
                throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
            }
            if (parameterTypes[i2] == cls) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static float getFloatField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getFloat(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getIntField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getInt(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static long getLongField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getLong(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static String getMD5Sum(String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(f.a);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static int getMethodDepth(String str) {
        return getMethodDepthCounter(str).get().get();
    }

    private static ThreadLocal<AtomicInteger> getMethodDepthCounter(String str) {
        ThreadLocal<AtomicInteger> threadLocal;
        synchronized (sMethodDepth) {
            ThreadLocal<AtomicInteger> threadLocal2 = sMethodDepth.get(str);
            threadLocal = threadLocal2;
            if (threadLocal2 == null) {
                threadLocal = new ThreadLocal<AtomicInteger>() { // from class: de.robv.android.xposed.XposedHelpers.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // java.lang.ThreadLocal
                    public AtomicInteger initialValue() {
                        return new AtomicInteger();
                    }
                };
                sMethodDepth.put(str, threadLocal);
            }
        }
        return threadLocal;
    }

    public static Object getObjectField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).get(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    static Method getOverriddenMethod(Method method) {
        Method method2;
        int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isPrivate(modifiers)) {
            method2 = null;
        } else {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<? super Object> superclass = method.getDeclaringClass().getSuperclass();
            while (true) {
                Class<? super Object> cls = superclass;
                if (cls == null) {
                    return null;
                }
                try {
                    Method declaredMethod = cls.getDeclaredMethod(name, parameterTypes);
                    int modifiers2 = declaredMethod.getModifiers();
                    if (Modifier.isPrivate(modifiers2)) {
                        return null;
                    }
                    method2 = declaredMethod;
                    if (Modifier.isAbstract(modifiers2)) {
                        return null;
                    }
                } catch (NoSuchMethodException e) {
                    superclass = cls.getSuperclass();
                }
            }
        }
        return method2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Method> getOverriddenMethods(Class<?> cls) {
        HashSet hashSet = new HashSet();
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashSet;
            }
            Method overriddenMethod = getOverriddenMethod(declaredMethods[i2]);
            if (overriddenMethod != null) {
                hashSet.add(overriddenMethod);
            }
            i = i2 + 1;
        }
    }

    private static Class<?>[] getParameterClasses(ClassLoader classLoader, Object[] objArr) {
        Class<?>[] clsArr = null;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                Class<?>[] clsArr2 = clsArr;
                if (clsArr == null) {
                    clsArr2 = new Class[0];
                }
                return clsArr2;
            }
            Object obj = objArr[i];
            if (obj == null) {
                throw new ClassNotFoundError("parameter type must not be null", null);
            }
            if (!(obj instanceof XC_MethodHook)) {
                Class<?>[] clsArr3 = clsArr;
                if (clsArr == null) {
                    clsArr3 = new Class[i + 1];
                }
                if (obj instanceof Class) {
                    clsArr3[i] = (Class) obj;
                    clsArr = clsArr3;
                } else if (!(obj instanceof String)) {
                    throw new ClassNotFoundError("parameter type must either be specified as Class or String", null);
                } else {
                    clsArr3[i] = findClass((String) obj, classLoader);
                    clsArr = clsArr3;
                }
            }
            length = i;
        }
    }

    public static int getParameterIndexByType(Member member, Class<?> cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        int i = -1;
        int i2 = 0;
        while (i2 < parameterTypes.length) {
            int i3 = i;
            if (parameterTypes[i2] == cls) {
                if (i != -1) {
                    throw new NoSuchFieldError("More than one parameter of type " + cls + " found in " + member);
                }
                i3 = i2;
            }
            i2++;
            i = i3;
        }
        if (i != -1) {
            return i;
        }
        throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
    }

    public static Class<?>[] getParameterTypes(Object... objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return clsArr;
            }
            clsArr[i2] = objArr[i2] != null ? objArr[i2].getClass() : null;
            i = i2 + 1;
        }
    }

    private static String getParametersString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = true;
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(")");
                return sb.toString();
            }
            Class<?> cls = clsArr[i2];
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
            i = i2 + 1;
        }
    }

    public static short getShortField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getShort(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static boolean getStaticBooleanField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getBoolean(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static byte getStaticByteField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getByte(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static char getStaticCharField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getChar(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static double getStaticDoubleField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getDouble(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static float getStaticFloatField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getFloat(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getStaticIntField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getInt(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static long getStaticLongField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getLong(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Object getStaticObjectField(Class<?> cls, String str) {
        try {
            return findField(cls, str).get(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static short getStaticShortField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getShort(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Object getSurroundingThis(Object obj) {
        return getObjectField(obj, "this$0");
    }

    public static int incrementMethodDepth(String str) {
        return getMethodDepthCounter(str).get().incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Object newInstance(Class<?> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, clsArr, objArr).newInstance(objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InstantiationException e3) {
            throw new InstantiationError(e3.getMessage());
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object newInstance(Class<?> cls, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, objArr).newInstance(objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InstantiationException e3) {
            throw new InstantiationError(e3.getMessage());
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object removeAdditionalInstanceField(Object obj, String str) {
        Object remove;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            HashMap<String, Object> hashMap = additionalFields.get(obj);
            if (hashMap == null) {
                return null;
            }
            synchronized (hashMap) {
                remove = hashMap.remove(str);
            }
            return remove;
        }
    }

    public static Object removeAdditionalStaticField(Class<?> cls, String str) {
        return removeAdditionalInstanceField(cls, str);
    }

    public static Object removeAdditionalStaticField(Object obj, String str) {
        return removeAdditionalInstanceField(obj.getClass(), str);
    }

    public static Object setAdditionalInstanceField(Object obj, String str, Object obj2) {
        HashMap<String, Object> hashMap;
        Object put;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            HashMap<String, Object> hashMap2 = additionalFields.get(obj);
            hashMap = hashMap2;
            if (hashMap2 == null) {
                hashMap = new HashMap<>();
                additionalFields.put(obj, hashMap);
            }
        }
        synchronized (hashMap) {
            try {
                put = hashMap.put(str, obj2);
            } catch (Throwable th) {
                HashMap<String, Object> hashMap3 = hashMap;
                throw th;
            }
        }
        return put;
    }

    public static Object setAdditionalStaticField(Class<?> cls, String str, Object obj) {
        return setAdditionalInstanceField(cls, str, obj);
    }

    public static Object setAdditionalStaticField(Object obj, String str, Object obj2) {
        return setAdditionalInstanceField(obj.getClass(), str, obj2);
    }

    public static void setBooleanField(Object obj, String str, boolean z) {
        try {
            findField(obj.getClass(), str).setBoolean(obj, z);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setByteField(Object obj, String str, byte b) {
        try {
            findField(obj.getClass(), str).setByte(obj, b);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setCharField(Object obj, String str, char c) {
        try {
            findField(obj.getClass(), str).setChar(obj, c);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setDoubleField(Object obj, String str, double d) {
        try {
            findField(obj.getClass(), str).setDouble(obj, d);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setFloatField(Object obj, String str, float f) {
        try {
            findField(obj.getClass(), str).setFloat(obj, f);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setIntField(Object obj, String str, int i) {
        try {
            findField(obj.getClass(), str).setInt(obj, i);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setLongField(Object obj, String str, long j) {
        try {
            findField(obj.getClass(), str).setLong(obj, j);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setObjectField(Object obj, String str, Object obj2) {
        try {
            findField(obj.getClass(), str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setShortField(Object obj, String str, short s) {
        try {
            findField(obj.getClass(), str).setShort(obj, s);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticBooleanField(Class<?> cls, String str, boolean z) {
        try {
            findField(cls, str).setBoolean(null, z);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticByteField(Class<?> cls, String str, byte b) {
        try {
            findField(cls, str).setByte(null, b);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticCharField(Class<?> cls, String str, char c) {
        try {
            findField(cls, str).setChar(null, c);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticDoubleField(Class<?> cls, String str, double d) {
        try {
            findField(cls, str).setDouble(null, d);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticFloatField(Class<?> cls, String str, float f) {
        try {
            findField(cls, str).setFloat(null, f);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticIntField(Class<?> cls, String str, int i) {
        try {
            findField(cls, str).setInt(null, i);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticLongField(Class<?> cls, String str, long j) {
        try {
            findField(cls, str).setLong(null, j);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticObjectField(Class<?> cls, String str, Object obj) {
        try {
            findField(cls, str).set(null, obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticShortField(Class<?> cls, String str, short s) {
        try {
            findField(cls, str).setShort(null, s);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }
}
