package java.lang.reflect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Proxy.class */
public class Proxy implements Serializable {
    private static final long serialVersionUID = -2222568056686623797L;
    protected InvocationHandler h;
    private static int nextClassNameIndex = 0;
    private static final Comparator<Method> ORDER_BY_SIGNATURE_AND_SUBTYPE = new Comparator<Method>() { // from class: java.lang.reflect.Proxy.1
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            int compare = Method.ORDER_BY_SIGNATURE.compare(method, method2);
            if (compare != 0) {
                return compare;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Class<?> declaringClass2 = method2.getDeclaringClass();
            if (declaringClass == declaringClass2) {
                return 0;
            }
            if (declaringClass.isAssignableFrom(declaringClass2)) {
                return 1;
            }
            return declaringClass2.isAssignableFrom(declaringClass) ? -1 : 0;
        }
    };

    private Proxy() {
    }

    protected Proxy(InvocationHandler invocationHandler) {
        this.h = invocationHandler;
    }

    private static native void constructorPrototype(InvocationHandler invocationHandler);

    private static List<Class<?>[]> deduplicateAndGetExceptions(List<Method> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (i < list.size()) {
            Method method = list.get(i);
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (i <= 0 || Method.ORDER_BY_SIGNATURE.compare(method, list.get(i - 1)) != 0) {
                arrayList.add(exceptionTypes);
                i++;
            } else {
                arrayList.set(i - 1, intersectExceptions((Class[]) arrayList.get(i - 1), exceptionTypes));
                list.remove(i);
            }
        }
        return arrayList;
    }

    private static native Class<?> generateProxy(String str, Class<?>[] clsArr, ClassLoader classLoader, ArtMethod[] artMethodArr, Class<?>[][] clsArr2);

    public static InvocationHandler getInvocationHandler(Object obj) throws IllegalArgumentException {
        if (obj instanceof Proxy) {
            return ((Proxy) obj).h;
        }
        throw new IllegalArgumentException("not a proxy instance");
    }

    private static List<Method> getMethods(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Object.class.getMethod("equals", Object.class));
            arrayList.add(Object.class.getMethod("hashCode", EmptyArray.CLASS));
            arrayList.add(Object.class.getMethod("toString", EmptyArray.CLASS));
            getMethodsRecursive(clsArr, arrayList);
            return arrayList;
        } catch (NoSuchMethodException e) {
            throw new AssertionError();
        }
    }

    private static void getMethodsRecursive(Class<?>[] clsArr, List<Method> list) {
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Class<?> cls = clsArr[i2];
            getMethodsRecursive(cls.getInterfaces(), list);
            Collections.addAll(list, cls.getDeclaredMethods());
            i = i2 + 1;
        }
    }

    public static Class<?> getProxyClass(ClassLoader classLoader, Class<?>... clsArr) throws IllegalArgumentException {
        Class<?> cls;
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        if (clsArr == null) {
            throw new NullPointerException("interfaces == null");
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        Collections.addAll(arrayList, clsArr);
        HashSet hashSet = new HashSet(arrayList);
        if (hashSet.contains(null)) {
            throw new NullPointerException("interface list contains null: " + arrayList);
        }
        if (hashSet.size() != clsArr.length) {
            throw new IllegalArgumentException("duplicate interface in list: " + arrayList);
        }
        synchronized (classLoader2.proxyCache) {
            Class<?> cls2 = classLoader2.proxyCache.get(arrayList);
            if (cls2 != null) {
                return cls2;
            }
            String str = null;
            int length = clsArr.length;
            int i = 0;
            while (i < length) {
                Class<?> cls3 = clsArr[i];
                if (!cls3.isInterface()) {
                    throw new IllegalArgumentException(cls3 + " is not an interface");
                }
                if (!isVisibleToClassLoader(classLoader2, cls3)) {
                    throw new IllegalArgumentException(cls3 + " is not visible from class loader");
                }
                String str2 = str;
                if (!Modifier.isPublic(cls3.getModifiers())) {
                    String packageName$ = cls3.getPackageName$();
                    str2 = packageName$;
                    if (packageName$ == null) {
                        str2 = "";
                    }
                    if (str != null && !str.equals(str2)) {
                        throw new IllegalArgumentException("non-public interfaces must be in the same package");
                    }
                }
                i++;
                str = str2;
            }
            List<Method> methods = getMethods(clsArr);
            Collections.sort(methods, ORDER_BY_SIGNATURE_AND_SUBTYPE);
            validateReturnTypes(methods);
            List<Class<?>[]> deduplicateAndGetExceptions = deduplicateAndGetExceptions(methods);
            ArtMethod[] artMethodArr = new ArtMethod[methods.size()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= artMethodArr.length) {
                    break;
                }
                artMethodArr[i3] = methods.get(i3).getArtMethod();
                i2 = i3 + 1;
            }
            Class[][] clsArr2 = (Class[][]) deduplicateAndGetExceptions.toArray(new Class[deduplicateAndGetExceptions.size()]);
            String str3 = (str == null || str.isEmpty()) ? "$Proxy" : str + ".$Proxy";
            synchronized (classLoader2.proxyCache) {
                Class<?> cls4 = classLoader2.proxyCache.get(arrayList);
                cls = cls4;
                if (cls4 == null) {
                    StringBuilder append = new StringBuilder().append(str3);
                    int i4 = nextClassNameIndex;
                    nextClassNameIndex = i4 + 1;
                    cls = generateProxy(append.append(i4).toString(), clsArr, classLoader2, artMethodArr, clsArr2);
                    classLoader2.proxyCache.put(arrayList, cls);
                }
            }
            return cls;
        }
    }

    private static Class<?>[] intersectExceptions(Class<?>[] clsArr, Class<?>[] clsArr2) {
        Class<?>[] clsArr3;
        if (clsArr.length == 0 || clsArr2.length == 0) {
            clsArr3 = EmptyArray.CLASS;
        } else {
            clsArr3 = clsArr;
            if (!Arrays.equals(clsArr, clsArr2)) {
                HashSet hashSet = new HashSet();
                int length = clsArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
                    }
                    Class<?> cls = clsArr[i2];
                    int length2 = clsArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < length2) {
                            Class<?> cls2 = clsArr2[i4];
                            if (cls.isAssignableFrom(cls2)) {
                                hashSet.add(cls2);
                            } else if (cls2.isAssignableFrom(cls)) {
                                hashSet.add(cls);
                            }
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        return clsArr3;
    }

    static Object invoke(Proxy proxy, ArtMethod artMethod, Object[] objArr) throws Throwable {
        return proxy.h.invoke(proxy, new Method(artMethod), objArr);
    }

    public static boolean isProxyClass(Class<?> cls) {
        return cls.isProxy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r5 == java.lang.Class.forName(r5.getName(), false, r4)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isVisibleToClassLoader(java.lang.ClassLoader r4, java.lang.Class<?> r5) {
        /*
            r0 = 0
            r6 = r0
            r0 = r4
            r1 = r5
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1d
            if (r0 == r1) goto L19
            r0 = r5
            java.lang.String r0 = r0.getName()     // Catch: java.lang.ClassNotFoundException -> L1d
            r1 = 0
            r2 = r4
            java.lang.Class r0 = java.lang.Class.forName(r0, r1, r2)     // Catch: java.lang.ClassNotFoundException -> L1d
            r4 = r0
            r0 = r5
            r1 = r4
            if (r0 != r1) goto L1b
        L19:
            r0 = 1
            r6 = r0
        L1b:
            r0 = r6
            return r0
        L1d:
            r4 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.reflect.Proxy.isVisibleToClassLoader(java.lang.ClassLoader, java.lang.Class):boolean");
    }

    public static Object newProxyInstance(ClassLoader classLoader, Class<?>[] clsArr, InvocationHandler invocationHandler) throws IllegalArgumentException {
        if (invocationHandler == null) {
            throw new NullPointerException("invocationHandler == null");
        }
        try {
            return getProxyClass(classLoader, clsArr).getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            AssertionError assertionError = new AssertionError();
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    private static void validateReturnTypes(List<Method> list) {
        Method method = null;
        for (Method method2 : list) {
            if (method == null || !method.equalNameAndParameters(method2)) {
                method = method2;
            } else {
                Class<?> returnType = method2.getReturnType();
                Class<?> returnType2 = method.getReturnType();
                if (!returnType.isInterface() || !returnType2.isInterface()) {
                    if (returnType2.isAssignableFrom(returnType)) {
                        method = method2;
                    } else if (!returnType.isAssignableFrom(returnType2)) {
                        throw new IllegalArgumentException("proxied interface methods have incompatible return types:\n  " + method + "\n  " + method2);
                    }
                }
            }
        }
    }
}
