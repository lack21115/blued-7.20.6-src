package butterknife;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:butterknife/ButterKnife.class */
public final class ButterKnife {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f3672a = new LinkedHashMap();
    private static boolean b = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder a(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (b) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> a2 = a(cls);
        if (a2 == null) {
            return Unbinder.f3679a;
        }
        try {
            return a2.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + a2, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + a2, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unable to create binding instance.", cause);
        }
    }

    private static Constructor<? extends Unbinder> a(Class<?> cls) {
        Constructor<? extends Unbinder> a2;
        Constructor<? extends Unbinder> constructor = f3672a.get(cls);
        if (constructor != null || f3672a.containsKey(cls)) {
            if (b) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            if (b) {
                Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
                return null;
            }
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Constructor<? extends Unbinder> constructor2 = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
            a2 = constructor2;
            if (b) {
                Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
                a2 = constructor2;
            }
        } catch (ClassNotFoundException e) {
            if (b) {
                Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
            }
            a2 = a(cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find binding constructor for " + name, e2);
        }
        f3672a.put(cls, a2);
        return a2;
    }
}
