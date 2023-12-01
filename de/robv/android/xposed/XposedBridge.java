package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import com.android.internal.os.RuntimeInit;
import com.android.internal.os.ZygoteInit;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedBridge.class */
public final class XposedBridge {
    static long BOOT_START_TIME = 0;
    private static final int RUNTIME_ART = 2;
    private static final int RUNTIME_DALVIK = 1;
    public static final String TAG = "Xposed";
    @Deprecated
    public static int XPOSED_BRIDGE_VERSION;
    public static final ClassLoader BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
    static boolean isZygote = true;
    private static int runtime = 0;
    static boolean disableHooks = false;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks = new HashMap();
    static final CopyOnWriteSortedSet<XC_LoadPackage> sLoadedPackageCallbacks = new CopyOnWriteSortedSet<>();
    static final CopyOnWriteSortedSet<XC_InitPackageResources> sInitPackageResourcesCallbacks = new CopyOnWriteSortedSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedBridge$AdditionalHookInfo.class */
    public static class AdditionalHookInfo {
        final CopyOnWriteSortedSet<XC_MethodHook> callbacks;
        final Class<?>[] parameterTypes;
        final Class<?> returnType;

        private AdditionalHookInfo(CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet, Class<?>[] clsArr, Class<?> cls) {
            this.callbacks = copyOnWriteSortedSet;
            this.parameterTypes = clsArr;
            this.returnType = cls;
        }
    }

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet.class */
    public static final class CopyOnWriteSortedSet<E> {
        private volatile transient Object[] elements = XposedBridge.EMPTY_ARRAY;

        private int indexOf(Object obj) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.elements.length) {
                    return -1;
                }
                if (obj.equals(this.elements[i2])) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        public boolean add(E e) {
            boolean z = false;
            synchronized (this) {
                if (indexOf(e) < 0) {
                    Object[] objArr = new Object[this.elements.length + 1];
                    System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
                    objArr[this.elements.length] = e;
                    Arrays.sort(objArr);
                    this.elements = objArr;
                    z = true;
                }
            }
            return z;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }

        public boolean remove(E e) {
            boolean z = false;
            synchronized (this) {
                int indexOf = indexOf(e);
                if (indexOf != -1) {
                    Object[] objArr = new Object[this.elements.length - 1];
                    System.arraycopy(this.elements, 0, objArr, 0, indexOf);
                    System.arraycopy(this.elements, indexOf + 1, objArr, indexOf, (this.elements.length - indexOf) - 1);
                    this.elements = objArr;
                    z = true;
                }
            }
            return z;
        }
    }

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedBridge$ToolEntryPoint.class */
    protected static final class ToolEntryPoint {
        protected ToolEntryPoint() {
        }

        protected static void main(String[] strArr) {
            XposedBridge.isZygote = false;
            XposedBridge.main(strArr);
        }
    }

    private XposedBridge() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cloneToSubclass(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isAssignableFrom(cls)) {
            return cloneToSubclassNative(obj, cls);
        }
        throw new ClassCastException(cls + " doesn't extend " + obj.getClass());
    }

    private static native Object cloneToSubclassNative(Object obj, Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void closeFilesBeforeForkNative();

    static native void dumpObjectNative(Object obj);

    @SuppressLint({"SetWorldReadable"})
    private static File ensureSuperDexFile(String str, Class<?> cls, Class<?> cls2) throws IOException {
        removeFinalFlagNative(cls);
        File ensure = DexCreator.ensure(str, cls, cls2);
        ensure.setReadable(true, false);
        return ensure;
    }

    private static native int getRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getStartClassName();

    public static native int getXposedVersion();

    private static native boolean hadInitErrors();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
        throw r8.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
        throw r8.getCause();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object handleHookedMethod(java.lang.reflect.Member r8, int r9, java.lang.Object r10, java.lang.Object r11, java.lang.Object[] r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XposedBridge.handleHookedMethod(java.lang.reflect.Member, int, java.lang.Object, java.lang.Object, java.lang.Object[]):java.lang.Object");
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> cls, XC_MethodHook xC_MethodHook) {
        HashSet hashSet = new HashSet();
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashSet;
            }
            hashSet.add(hookMethod(declaredConstructors[i2], xC_MethodHook));
            i = i2 + 1;
        }
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> cls, String str, XC_MethodHook xC_MethodHook) {
        HashSet hashSet = new HashSet();
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashSet;
            }
            Method method = declaredMethods[i2];
            if (method.getName().equals(str)) {
                hashSet.add(hookMethod(method, xC_MethodHook));
            }
            i = i2 + 1;
        }
    }

    public static void hookInitPackageResources(XC_InitPackageResources xC_InitPackageResources) {
        synchronized (sInitPackageResourcesCallbacks) {
            sInitPackageResourcesCallbacks.add(xC_InitPackageResources);
        }
    }

    public static void hookLoadPackage(XC_LoadPackage xC_LoadPackage) {
        synchronized (sLoadedPackageCallbacks) {
            sLoadedPackageCallbacks.add(xC_LoadPackage);
        }
    }

    public static XC_MethodHook.Unhook hookMethod(Member member, XC_MethodHook xC_MethodHook) {
        CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet;
        int intField;
        Class<?>[] parameterTypes;
        Class<?> cls;
        if ((member instanceof Method) || (member instanceof Constructor)) {
            if (member.getDeclaringClass().isInterface()) {
                throw new IllegalArgumentException("Cannot hook interfaces: " + member.toString());
            }
            if (Modifier.isAbstract(member.getModifiers())) {
                throw new IllegalArgumentException("Cannot hook abstract methods: " + member.toString());
            }
            boolean z = false;
            synchronized (sHookedMethodCallbacks) {
                CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet2 = sHookedMethodCallbacks.get(member);
                copyOnWriteSortedSet = copyOnWriteSortedSet2;
                if (copyOnWriteSortedSet2 == null) {
                    copyOnWriteSortedSet = new CopyOnWriteSortedSet<>();
                    sHookedMethodCallbacks.put(member, copyOnWriteSortedSet);
                    z = true;
                }
            }
            copyOnWriteSortedSet.add(xC_MethodHook);
            if (z) {
                Class<?> declaringClass = member.getDeclaringClass();
                if (runtime == 2) {
                    intField = 0;
                    parameterTypes = null;
                    cls = null;
                } else if (member instanceof Method) {
                    intField = XposedHelpers.getIntField(member, PhoneConstants.SLOT_KEY);
                    parameterTypes = ((Method) member).getParameterTypes();
                    cls = ((Method) member).getReturnType();
                } else {
                    intField = XposedHelpers.getIntField(member, PhoneConstants.SLOT_KEY);
                    parameterTypes = ((Constructor) member).getParameterTypes();
                    cls = null;
                }
                hookMethodNative(member, declaringClass, intField, new AdditionalHookInfo(copyOnWriteSortedSet, parameterTypes, cls));
            }
            xC_MethodHook.getClass();
            return new XC_MethodHook.Unhook(member);
        }
        throw new IllegalArgumentException("Only methods and constructors can be hooked: " + member.toString());
    }

    private static native synchronized void hookMethodNative(Member member, Class<?> cls, int i, Object obj);

    private static void initXResources() throws IOException {
        Resources system = Resources.getSystem();
        File ensureSuperDexFile = ensureSuperDexFile("XResources", system.getClass(), Resources.class);
        Class<?> cls = TypedArray.class;
        try {
            TypedArray obtainTypedArray = system.obtainTypedArray(system.getIdentifier("preloaded_drawables", "array", MsgBackupManager.PLATFORM_ANDROID));
            Class<?> cls2 = obtainTypedArray.getClass();
            cls = cls2;
            obtainTypedArray.recycle();
            cls = cls2;
        } catch (Resources.NotFoundException e) {
            log(e);
        }
        Runtime.getRuntime().gc();
        File ensureSuperDexFile2 = ensureSuperDexFile("XTypedArray", cls, TypedArray.class);
        ClassLoader classLoader = XposedBridge.class.getClassLoader();
        XposedHelpers.setObjectField(classLoader, "parent", new PathClassLoader(ensureSuperDexFile.getAbsolutePath() + File.pathSeparator + ensureSuperDexFile2.getAbsolutePath(), classLoader.getParent()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean initXResourcesNative();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void invalidateCallersNative(Member[] memberArr);

    public static Object invokeOriginalMethod(Member member, Object obj, Object[] objArr) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?>[] parameterTypes;
        Class<?> cls;
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = EMPTY_ARRAY;
        }
        if (runtime == 2 && ((member instanceof Method) || (member instanceof Constructor))) {
            parameterTypes = null;
            cls = null;
        } else if (member instanceof Method) {
            parameterTypes = ((Method) member).getParameterTypes();
            cls = ((Method) member).getReturnType();
        } else if (!(member instanceof Constructor)) {
            throw new IllegalArgumentException("method must be of type Method or Constructor");
        } else {
            parameterTypes = ((Constructor) member).getParameterTypes();
            cls = null;
        }
        return invokeOriginalMethodNative(member, 0, parameterTypes, cls, obj, objArr2);
    }

    private static native Object invokeOriginalMethodNative(Member member, int i, Class<?>[] clsArr, Class<?> cls, Object obj, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static void log(String str) {
        synchronized (XposedBridge.class) {
            try {
                Log.i(TAG, str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void log(Throwable th) {
        synchronized (XposedBridge.class) {
            try {
                Log.e(TAG, Log.getStackTraceString(th));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:8:0x002b). Please submit an issue!!! */
    protected static void main(String[] strArr) {
        try {
            if (hadInitErrors()) {
                Log.e(TAG, "Not initializing Xposed because of previous errors");
            } else {
                initXResources();
                SELinuxHelper.initOnce();
                SELinuxHelper.initForProcess(null);
                runtime = getRuntime();
                XPOSED_BRIDGE_VERSION = getXposedVersion();
                if (isZygote) {
                    XposedInit.hookResources();
                    XposedInit.initForZygote();
                }
                XposedInit.loadModules();
            }
        } catch (Throwable th) {
            Log.e(TAG, "Errors during Xposed initialization", th);
            disableHooks = true;
        }
        if (isZygote) {
            ZygoteInit.main(strArr);
        } else {
            RuntimeInit.main(strArr);
        }
    }

    private static native void removeFinalFlagNative(Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void reopenFilesAfterForkNative();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setObjectClass(Object obj, Class<?> cls) {
        if (cls.isAssignableFrom(obj.getClass())) {
            throw new IllegalArgumentException("Cannot transfer object from " + obj.getClass() + " to " + cls);
        }
        setObjectClassNative(obj, cls);
    }

    private static native void setObjectClassNative(Object obj, Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean startsSystemServer();

    @Deprecated
    public static void unhookMethod(Member member, XC_MethodHook xC_MethodHook) {
        synchronized (sHookedMethodCallbacks) {
            CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet = sHookedMethodCallbacks.get(member);
            if (copyOnWriteSortedSet == null) {
                return;
            }
            copyOnWriteSortedSet.remove(xC_MethodHook);
        }
    }
}
