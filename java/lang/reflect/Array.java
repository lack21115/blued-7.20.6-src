package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Array.class */
public final class Array {
    private Array() {
    }

    private static RuntimeException badArray(Object obj) {
        if (obj == null) {
            throw new NullPointerException("array == null");
        }
        if (obj.getClass().isArray()) {
            throw incompatibleType(obj);
        }
        throw notAnArray(obj);
    }

    private static native Object createMultiArray(Class<?> cls, int[] iArr) throws NegativeArraySizeException;

    private static native Object createObjectArray(Class<?> cls, int i) throws NegativeArraySizeException;

    public static Object get(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof Object[]) {
            return ((Object[]) obj)[i];
        }
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj)[i] ? Boolean.TRUE : Boolean.FALSE;
        } else if (obj instanceof byte[]) {
            return Byte.valueOf(((byte[]) obj)[i]);
        } else {
            if (obj instanceof char[]) {
                return Character.valueOf(((char[]) obj)[i]);
            }
            if (obj instanceof short[]) {
                return Short.valueOf(((short[]) obj)[i]);
            }
            if (obj instanceof int[]) {
                return Integer.valueOf(((int[]) obj)[i]);
            }
            if (obj instanceof long[]) {
                return Long.valueOf(((long[]) obj)[i]);
            }
            if (obj instanceof float[]) {
                return new Float(((float[]) obj)[i]);
            }
            if (obj instanceof double[]) {
                return new Double(((double[]) obj)[i]);
            }
            if (obj == null) {
                throw new NullPointerException("array == null");
            }
            throw notAnArray(obj);
        }
    }

    public static boolean getBoolean(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static byte getByte(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static char getChar(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof char[]) {
            return ((char[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static double getDouble(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof double[]) {
            return ((double[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        if (obj instanceof char[]) {
            return ((char[]) obj)[i];
        }
        if (obj instanceof float[]) {
            return ((float[]) obj)[i];
        }
        if (obj instanceof int[]) {
            return ((int[]) obj)[i];
        }
        if (obj instanceof long[]) {
            return ((long[]) obj)[i];
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static float getFloat(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof float[]) {
            return ((float[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        if (obj instanceof char[]) {
            return ((char[]) obj)[i];
        }
        if (obj instanceof int[]) {
            return ((int[]) obj)[i];
        }
        if (obj instanceof long[]) {
            return (float) ((long[]) obj)[i];
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static int getInt(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof int[]) {
            return ((int[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        if (obj instanceof char[]) {
            return ((char[]) obj)[i];
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static int getLength(Object obj) {
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj).length;
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj).length;
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj instanceof double[]) {
            return ((double[]) obj).length;
        }
        if (obj instanceof float[]) {
            return ((float[]) obj).length;
        }
        if (obj instanceof int[]) {
            return ((int[]) obj).length;
        }
        if (obj instanceof long[]) {
            return ((long[]) obj).length;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj).length;
        }
        throw badArray(obj);
    }

    public static long getLong(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof long[]) {
            return ((long[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        if (obj instanceof char[]) {
            return ((char[]) obj)[i];
        }
        if (obj instanceof int[]) {
            return ((int[]) obj)[i];
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i];
        }
        throw badArray(obj);
    }

    public static short getShort(Object obj, int i) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof short[]) {
            return ((short[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i];
        }
        throw badArray(obj);
    }

    private static IllegalArgumentException incompatibleType(Object obj) {
        throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
    }

    public static Object newInstance(Class<?> cls, int i) throws NegativeArraySizeException {
        if (cls.isPrimitive()) {
            if (cls == Character.TYPE) {
                return new char[i];
            }
            if (cls == Integer.TYPE) {
                return new int[i];
            }
            if (cls == Byte.TYPE) {
                return new byte[i];
            }
            if (cls == Boolean.TYPE) {
                return new boolean[i];
            }
            if (cls == Short.TYPE) {
                return new short[i];
            }
            if (cls == Long.TYPE) {
                return new long[i];
            }
            if (cls == Float.TYPE) {
                return new float[i];
            }
            if (cls == Double.TYPE) {
                return new double[i];
            }
            if (cls == Void.TYPE) {
                throw new IllegalArgumentException("Can't allocate an array of void");
            }
            throw new AssertionError();
        }
        return createObjectArray(cls, i);
    }

    public static Object newInstance(Class<?> cls, int... iArr) throws NegativeArraySizeException, IllegalArgumentException {
        if (iArr.length <= 0 || iArr.length > 255) {
            throw new IllegalArgumentException("Bad number of dimensions: " + iArr.length);
        }
        if (cls == Void.TYPE) {
            throw new IllegalArgumentException("Can't allocate an array of void");
        }
        if (cls == null) {
            throw new NullPointerException("componentType == null");
        }
        return createMultiArray(cls, iArr);
    }

    private static IllegalArgumentException notAnArray(Object obj) {
        throw new IllegalArgumentException("Not an array: " + obj.getClass());
    }

    public static void set(Object obj, int i, Object obj2) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!obj.getClass().isArray()) {
            throw notAnArray(obj);
        }
        if (obj instanceof Object[]) {
            if (obj2 != null && !obj.getClass().getComponentType().isInstance(obj2)) {
                throw incompatibleType(obj);
            }
            ((Object[]) obj)[i] = obj2;
        } else if (obj2 == null) {
            throw new IllegalArgumentException("Primitive array can't take null values.");
        } else {
            if (obj2 instanceof Boolean) {
                setBoolean(obj, i, ((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof Byte) {
                setByte(obj, i, ((Byte) obj2).byteValue());
            } else if (obj2 instanceof Character) {
                setChar(obj, i, ((Character) obj2).charValue());
            } else if (obj2 instanceof Short) {
                setShort(obj, i, ((Short) obj2).shortValue());
            } else if (obj2 instanceof Integer) {
                setInt(obj, i, ((Integer) obj2).intValue());
            } else if (obj2 instanceof Long) {
                setLong(obj, i, ((Long) obj2).longValue());
            } else if (obj2 instanceof Float) {
                setFloat(obj, i, ((Float) obj2).floatValue());
            } else if (obj2 instanceof Double) {
                setDouble(obj, i, ((Double) obj2).doubleValue());
            }
        }
    }

    public static void setBoolean(Object obj, int i, boolean z) {
        if (!(obj instanceof boolean[])) {
            throw badArray(obj);
        }
        ((boolean[]) obj)[i] = z;
    }

    public static void setByte(Object obj, int i, byte b) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = b;
        } else if (obj instanceof double[]) {
            ((double[]) obj)[i] = b;
        } else if (obj instanceof float[]) {
            ((float[]) obj)[i] = b;
        } else if (obj instanceof int[]) {
            ((int[]) obj)[i] = b;
        } else if (obj instanceof long[]) {
            ((long[]) obj)[i] = b;
        } else if (!(obj instanceof short[])) {
            throw badArray(obj);
        } else {
            ((short[]) obj)[i] = b;
        }
    }

    public static void setChar(Object obj, int i, char c2) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof char[]) {
            ((char[]) obj)[i] = c2;
        } else if (obj instanceof double[]) {
            ((double[]) obj)[i] = c2;
        } else if (obj instanceof float[]) {
            ((float[]) obj)[i] = c2;
        } else if (obj instanceof int[]) {
            ((int[]) obj)[i] = c2;
        } else if (!(obj instanceof long[])) {
            throw badArray(obj);
        } else {
            ((long[]) obj)[i] = c2;
        }
    }

    public static void setDouble(Object obj, int i, double d) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!(obj instanceof double[])) {
            throw badArray(obj);
        }
        ((double[]) obj)[i] = d;
    }

    public static void setFloat(Object obj, int i, float f) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof float[]) {
            ((float[]) obj)[i] = f;
        } else if (!(obj instanceof double[])) {
            throw badArray(obj);
        } else {
            ((double[]) obj)[i] = f;
        }
    }

    public static void setInt(Object obj, int i, int i2) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof int[]) {
            ((int[]) obj)[i] = i2;
        } else if (obj instanceof double[]) {
            ((double[]) obj)[i] = i2;
        } else if (obj instanceof float[]) {
            ((float[]) obj)[i] = i2;
        } else if (!(obj instanceof long[])) {
            throw badArray(obj);
        } else {
            ((long[]) obj)[i] = i2;
        }
    }

    public static void setLong(Object obj, int i, long j) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof long[]) {
            ((long[]) obj)[i] = j;
        } else if (obj instanceof double[]) {
            ((double[]) obj)[i] = j;
        } else if (!(obj instanceof float[])) {
            throw badArray(obj);
        } else {
            ((float[]) obj)[i] = (float) j;
        }
    }

    public static void setShort(Object obj, int i, short s) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (obj instanceof short[]) {
            ((short[]) obj)[i] = s;
        } else if (obj instanceof double[]) {
            ((double[]) obj)[i] = s;
        } else if (obj instanceof float[]) {
            ((float[]) obj)[i] = s;
        } else if (obj instanceof int[]) {
            ((int[]) obj)[i] = s;
        } else if (!(obj instanceof long[])) {
            throw badArray(obj);
        } else {
            ((long[]) obj)[i] = s;
        }
    }
}
