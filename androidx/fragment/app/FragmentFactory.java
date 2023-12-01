package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentFactory.class */
public class FragmentFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> f2911a = new SimpleArrayMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(b(classLoader, str));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static Class<?> b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        SimpleArrayMap<String, Class<?>> simpleArrayMap = f2911a.get(classLoader);
        SimpleArrayMap<String, Class<?>> simpleArrayMap2 = simpleArrayMap;
        if (simpleArrayMap == null) {
            simpleArrayMap2 = new SimpleArrayMap<>();
            f2911a.put(classLoader, simpleArrayMap2);
        }
        Class<?> cls = simpleArrayMap2.get(str);
        Class<?> cls2 = cls;
        if (cls == null) {
            cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
        }
        return cls2;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public Fragment instantiate(ClassLoader classLoader, String str) {
        try {
            return loadFragmentClass(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
