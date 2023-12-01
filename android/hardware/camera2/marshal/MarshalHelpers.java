package android.hardware.camera2.marshal;

import android.util.Rational;
import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/MarshalHelpers.class */
public final class MarshalHelpers {
    public static final int SIZEOF_BYTE = 1;
    public static final int SIZEOF_DOUBLE = 8;
    public static final int SIZEOF_FLOAT = 4;
    public static final int SIZEOF_INT32 = 4;
    public static final int SIZEOF_INT64 = 8;
    public static final int SIZEOF_RATIONAL = 8;

    private MarshalHelpers() {
        throw new AssertionError();
    }

    public static int checkNativeType(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return i;
            default:
                throw new UnsupportedOperationException("Unknown nativeType " + i);
        }
    }

    public static int checkNativeTypeEquals(int i, int i2) {
        if (i != i2) {
            throw new UnsupportedOperationException(String.format("Expected native type %d, but got %d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return i2;
    }

    public static <T> Class<T> checkPrimitiveClass(Class<T> cls) {
        Preconditions.checkNotNull(cls, "klass must not be null");
        if (isPrimitiveClass(cls)) {
            return cls;
        }
        throw new UnsupportedOperationException("Unsupported class '" + cls + "'; expected a metadata primitive class");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getPrimitiveTypeSize(int i) {
        int i2 = 4;
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                break;
            case 3:
                return 8;
            case 4:
                return 8;
            case 5:
                return 8;
            default:
                throw new UnsupportedOperationException("Unknown type, can't get size for " + i);
        }
        return i2;
    }

    public static <T> boolean isPrimitiveClass(Class<T> cls) {
        if (cls == null) {
            return false;
        }
        return cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Float.TYPE || cls == Float.class || cls == Long.TYPE || cls == Long.class || cls == Double.TYPE || cls == Double.class || cls == Rational.class;
    }

    public static String toStringNativeType(int i) {
        switch (i) {
            case 0:
                return "TYPE_BYTE";
            case 1:
                return "TYPE_INT32";
            case 2:
                return "TYPE_FLOAT";
            case 3:
                return "TYPE_INT64";
            case 4:
                return "TYPE_DOUBLE";
            case 5:
                return "TYPE_RATIONAL";
            default:
                return "UNKNOWN(" + i + ")";
        }
    }

    public static <T> Class<T> wrapClassIfPrimitive(Class<T> cls) {
        Class<T> cls2;
        if (cls == Byte.TYPE) {
            cls2 = Byte.class;
        } else if (cls == Integer.TYPE) {
            return Integer.class;
        } else {
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            cls2 = cls;
            if (cls == Double.TYPE) {
                return Double.class;
            }
        }
        return cls2;
    }
}
