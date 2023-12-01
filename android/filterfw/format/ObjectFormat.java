package android.filterfw.format;

import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.NativeBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/format/ObjectFormat.class */
public class ObjectFormat {
    private static int bytesPerSampleForClass(Class cls, int i) {
        if (i == 2) {
            if (NativeBuffer.class.isAssignableFrom(cls)) {
                try {
                    return ((NativeBuffer) cls.newInstance()).getElementSize();
                } catch (Exception e) {
                    throw new RuntimeException("Could not determine the size of an element in a native object-based frame of type " + cls + "! Perhaps it is missing a default constructor?");
                }
            }
            throw new IllegalArgumentException("Native object-based formats must be of a NativeBuffer subclass! (Received class: " + cls + ").");
        }
        return 1;
    }

    public static MutableFrameFormat fromClass(Class cls, int i) {
        return fromClass(cls, 0, i);
    }

    public static MutableFrameFormat fromClass(Class cls, int i, int i2) {
        MutableFrameFormat mutableFrameFormat = new MutableFrameFormat(8, i2);
        mutableFrameFormat.setObjectClass(getBoxedClass(cls));
        if (i != 0) {
            mutableFrameFormat.setDimensions(i);
        }
        mutableFrameFormat.setBytesPerSample(bytesPerSampleForClass(cls, i2));
        return mutableFrameFormat;
    }

    public static MutableFrameFormat fromObject(Object obj, int i) {
        return obj == null ? new MutableFrameFormat(8, i) : fromClass(obj.getClass(), 0, i);
    }

    public static MutableFrameFormat fromObject(Object obj, int i, int i2) {
        return obj == null ? new MutableFrameFormat(8, i2) : fromClass(obj.getClass(), i, i2);
    }

    private static Class getBoxedClass(Class cls) {
        Class cls2 = cls;
        if (cls.isPrimitive()) {
            if (cls != Boolean.TYPE) {
                if (cls == Byte.TYPE) {
                    return Byte.class;
                }
                if (cls == Character.TYPE) {
                    return Character.class;
                }
                if (cls == Short.TYPE) {
                    return Short.class;
                }
                if (cls == Integer.TYPE) {
                    return Integer.class;
                }
                if (cls == Long.TYPE) {
                    return Long.class;
                }
                if (cls == Float.TYPE) {
                    return Float.class;
                }
                if (cls == Double.TYPE) {
                    return Double.class;
                }
                throw new IllegalArgumentException("Unknown primitive type: " + cls.getSimpleName() + "!");
            }
            cls2 = Boolean.class;
        }
        return cls2;
    }
}
