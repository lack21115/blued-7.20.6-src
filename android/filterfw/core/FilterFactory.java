package android.filterfw.core;

import android.util.Log;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterFactory.class */
public class FilterFactory {
    private static FilterFactory mSharedFactory;
    private HashSet<String> mPackages = new HashSet<>();
    private static ClassLoader mCurrentClassLoader = Thread.currentThread().getContextClassLoader();
    private static HashSet<String> mLibraries = new HashSet<>();
    private static Object mClassLoaderGuard = new Object();
    private static final String TAG = "FilterFactory";
    private static boolean mLogVerbose = Log.isLoggable(TAG, 2);

    public static void addFilterLibrary(String str) {
        if (mLogVerbose) {
            Log.v(TAG, "Adding filter library " + str);
        }
        synchronized (mClassLoaderGuard) {
            if (mLibraries.contains(str)) {
                if (mLogVerbose) {
                    Log.v(TAG, "Library already added");
                }
                return;
            }
            mLibraries.add(str);
            mCurrentClassLoader = new PathClassLoader(str, mCurrentClassLoader);
        }
    }

    public static FilterFactory sharedFactory() {
        if (mSharedFactory == null) {
            mSharedFactory = new FilterFactory();
        }
        return mSharedFactory;
    }

    public void addPackage(String str) {
        if (mLogVerbose) {
            Log.v(TAG, "Adding package " + str);
        }
        this.mPackages.add(str);
    }

    public Filter createFilterByClass(Class cls, String str) {
        try {
            cls.asSubclass(Filter.class);
            try {
                Constructor constructor = cls.getConstructor(String.class);
                Filter filter = null;
                try {
                    filter = (Filter) constructor.newInstance(str);
                } catch (Throwable th) {
                }
                if (filter == null) {
                    throw new IllegalArgumentException("Could not construct the filter '" + str + "'!");
                }
                return filter;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("The filter class '" + cls + "' does not have a constructor of the form <init>(String name)!");
            }
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("Attempting to allocate class '" + cls + "' which is not a subclass of Filter!");
        }
    }

    public Filter createFilterByClassName(String str, String str2) {
        Class<?> cls;
        if (mLogVerbose) {
            Log.v(TAG, "Looking up class " + str);
        }
        Class<?> cls2 = null;
        Iterator<String> it = this.mPackages.iterator();
        while (true) {
            cls = cls2;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            try {
                if (mLogVerbose) {
                    Class<?> cls3 = cls2;
                    Log.v(TAG, "Trying " + next + "." + str);
                }
                Class<?> cls4 = cls2;
                Class<?> cls5 = cls2;
                synchronized (mClassLoaderGuard) {
                    cls = mCurrentClassLoader.loadClass(next + "." + str);
                }
                cls2 = cls;
            } catch (ClassNotFoundException e) {
                cls2 = cls2;
            }
            if (cls != null) {
                break;
            }
        }
        if (cls == null) {
            throw new IllegalArgumentException("Unknown filter class '" + str + "'!");
        }
        return createFilterByClass(cls, str2);
    }
}
