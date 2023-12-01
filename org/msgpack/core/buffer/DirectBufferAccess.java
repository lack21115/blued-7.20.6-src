package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/DirectBufferAccess.class */
public class DirectBufferAccess {
    static Constructor byteBufferConstructor;
    static DirectBufferConstructorType directBufferConstructorType;
    static Class<?> directByteBufferClass;
    static Method mClean;
    static Method mCleaner;
    static Method mGetAddress;
    static Method memoryBlockWrapFromJni;

    /* renamed from: org.msgpack.core.buffer.DirectBufferAccess$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/DirectBufferAccess$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[DirectBufferConstructorType.values().length];
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType = iArr;
            try {
                iArr[DirectBufferConstructorType.ARGS_LONG_INT_REF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_LONG_INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_INT_INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_MB_INT_INT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/DirectBufferAccess$DirectBufferConstructorType.class */
    enum DirectBufferConstructorType {
        ARGS_LONG_INT_REF,
        ARGS_LONG_INT,
        ARGS_INT_INT,
        ARGS_MB_INT_INT
    }

    static {
        Constructor<?> declaredConstructor;
        DirectBufferConstructorType directBufferConstructorType2;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("java.nio.DirectByteBuffer");
            directByteBufferClass = loadClass;
            Method method = null;
            try {
                declaredConstructor = loadClass.getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                directBufferConstructorType2 = DirectBufferConstructorType.ARGS_LONG_INT_REF;
            } catch (NoSuchMethodException e) {
                try {
                    declaredConstructor = directByteBufferClass.getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                    directBufferConstructorType2 = DirectBufferConstructorType.ARGS_LONG_INT;
                } catch (NoSuchMethodException e2) {
                    try {
                        declaredConstructor = directByteBufferClass.getDeclaredConstructor(Integer.TYPE, Integer.TYPE);
                        directBufferConstructorType2 = DirectBufferConstructorType.ARGS_INT_INT;
                    } catch (NoSuchMethodException e3) {
                        Class<?> cls = Class.forName("java.nio.MemoryBlock");
                        method = cls.getDeclaredMethod("wrapFromJni", Integer.TYPE, Long.TYPE);
                        method.setAccessible(true);
                        declaredConstructor = directByteBufferClass.getDeclaredConstructor(cls, Integer.TYPE, Integer.TYPE);
                        directBufferConstructorType2 = DirectBufferConstructorType.ARGS_MB_INT_INT;
                    }
                }
            }
            byteBufferConstructor = declaredConstructor;
            directBufferConstructorType = directBufferConstructorType2;
            memoryBlockWrapFromJni = method;
            if (declaredConstructor == null) {
                throw new RuntimeException("Constructor of DirectByteBuffer is not found");
            }
            declaredConstructor.setAccessible(true);
            Method declaredMethod = directByteBufferClass.getDeclaredMethod("address", new Class[0]);
            mGetAddress = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = directByteBufferClass.getDeclaredMethod("cleaner", new Class[0]);
            mCleaner = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = mCleaner.getReturnType().getDeclaredMethod("clean", new Class[0]);
            mClean = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    private DirectBufferAccess() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clean(Object obj) {
        try {
            mClean.invoke(mCleaner.invoke(obj, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getAddress(Object obj) {
        try {
            return ((Long) mGetAddress.invoke(obj, new Object[0])).longValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDirectByteBufferInstance(Object obj) {
        return directByteBufferClass.isInstance(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer newByteBuffer(long j, int i, int i2, ByteBuffer byteBuffer) {
        try {
            int i3 = AnonymousClass1.$SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[directBufferConstructorType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return (ByteBuffer) byteBufferConstructor.newInstance(memoryBlockWrapFromJni.invoke(null, Long.valueOf(j + i), Integer.valueOf(i2)), Integer.valueOf(i2), 0);
                        }
                        throw new IllegalStateException("Unexpected value");
                    }
                    return (ByteBuffer) byteBufferConstructor.newInstance(Integer.valueOf(((int) j) + i), Integer.valueOf(i2));
                }
                return (ByteBuffer) byteBufferConstructor.newInstance(Long.valueOf(j + i), Integer.valueOf(i2));
            }
            return (ByteBuffer) byteBufferConstructor.newInstance(Long.valueOf(j + i), Integer.valueOf(i2), byteBuffer);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
