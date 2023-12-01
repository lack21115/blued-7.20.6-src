package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Method> f23971a = new HashMap<>();
    private final com.meizu.cloud.pushsdk.b.b.a b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23972c;
    private Class<?>[] d;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/b/c$a.class */
    class a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.meizu.cloud.pushsdk.b.b.a aVar, String str, Class<?>... clsArr) {
        this.b = aVar;
        this.f23972c = str;
        this.d = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Class<?> cls2 = cls;
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            cls2 = cls;
            if (Void.TYPE == cls) {
                cls2 = Void.class;
            }
        }
        return cls2;
    }

    private Method a() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> a2 = this.b.a();
        Method[] methods = a2.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < length) {
                Method method = methods[i2];
                if (a(method, this.f23972c, this.d)) {
                    return method;
                }
                i = i2 + 1;
            } else {
                Method[] declaredMethods = a2.getDeclaredMethods();
                int length2 = declaredMethods.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        throw new NoSuchMethodException("No similar method " + this.f23972c + " with params " + Arrays.toString(this.d) + " could be found on type " + a2);
                    }
                    Method method2 = declaredMethods[i4];
                    if (a(method2, this.f23972c, this.d)) {
                        return method2;
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr2.length) {
                return true;
            }
            if (clsArr2[i2] != a.class && !a(clsArr[i2]).isAssignableFrom(a(clsArr2[i2]))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private String b() throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder(this.b.a().getName());
        sb.append(this.f23972c);
        Class<?>[] clsArr = this.d;
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(clsArr[i2].getName());
            i = i2 + 1;
        }
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b = b();
            Method method = f23971a.get(b);
            Method method2 = method;
            if (method == null) {
                if (this.d.length == objArr.length) {
                    method2 = this.b.a().getMethod(this.f23972c, this.d);
                } else {
                    if (objArr.length > 0) {
                        this.d = new Class[objArr.length];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= objArr.length) {
                                break;
                            }
                            this.d[i2] = objArr[i2].getClass();
                            i = i2 + 1;
                        }
                    }
                    method2 = a();
                }
                f23971a.put(b, method2);
            }
            method2.setAccessible(true);
            dVar.b = (T) method2.invoke(obj, objArr);
            dVar.f23973a = true;
            return dVar;
        } catch (Exception e) {
            DebugLogger.d("ReflectMethod", "invoke exception, " + e.getMessage());
            return dVar;
        }
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.b.a(), objArr);
        } catch (ClassNotFoundException e) {
            return new d<>();
        }
    }
}
