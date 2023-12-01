package sun.misc;

import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: source-2895416-dex2jar.jar:sun/misc/Unsafe.class */
public final class Unsafe {
    private static final Unsafe THE_ONE = new Unsafe();
    private static final Unsafe theUnsafe = THE_ONE;

    private Unsafe() {
    }

    private static native int getArrayBaseOffsetForComponentType(Class cls);

    private static native int getArrayIndexScaleForComponentType(Class cls);

    public static Unsafe getUnsafe() {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        if (callingClassLoader == null || callingClassLoader == Unsafe.class.getClassLoader()) {
            return THE_ONE;
        }
        throw new SecurityException("Unsafe access denied");
    }

    public native Object allocateInstance(Class<?> cls);

    public int arrayBaseOffset(Class cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType == null) {
            throw new IllegalArgumentException("Valid for array classes only: " + cls);
        }
        return getArrayBaseOffsetForComponentType(componentType);
    }

    public int arrayIndexScale(Class cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType == null) {
            throw new IllegalArgumentException("Valid for array classes only: " + cls);
        }
        return getArrayIndexScaleForComponentType(componentType);
    }

    public native boolean compareAndSwapInt(Object obj, long j, int i, int i2);

    public native boolean compareAndSwapLong(Object obj, long j, long j2, long j3);

    public native boolean compareAndSwapObject(Object obj, long j, Object obj2, Object obj3);

    public native int getInt(Object obj, long j);

    public native int getIntVolatile(Object obj, long j);

    public native long getLong(Object obj, long j);

    public native long getLongVolatile(Object obj, long j);

    public native Object getObject(Object obj, long j);

    public native Object getObjectVolatile(Object obj, long j);

    public long objectFieldOffset(Field field) {
        if (Modifier.isStatic(field.getModifiers())) {
            throw new IllegalArgumentException("valid for instance fields only");
        }
        return field.getOffset();
    }

    public void park(boolean z, long j) {
        if (z) {
            Thread.currentThread().parkUntil(j);
        } else {
            Thread.currentThread().parkFor(j);
        }
    }

    public native void putInt(Object obj, long j, int i);

    public native void putIntVolatile(Object obj, long j, int i);

    public native void putLong(Object obj, long j, long j2);

    public native void putLongVolatile(Object obj, long j, long j2);

    public native void putObject(Object obj, long j, Object obj2);

    public native void putObjectVolatile(Object obj, long j, Object obj2);

    public native void putOrderedInt(Object obj, long j, int i);

    public native void putOrderedLong(Object obj, long j, long j2);

    public native void putOrderedObject(Object obj, long j, Object obj2);

    public void unpark(Object obj) {
        if (!(obj instanceof Thread)) {
            throw new IllegalArgumentException("valid for Threads only");
        }
        ((Thread) obj).unpark();
    }
}
