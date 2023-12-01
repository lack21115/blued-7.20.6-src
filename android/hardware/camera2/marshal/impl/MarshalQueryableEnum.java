package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalHelpers;
import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.util.Log;
import java.lang.Enum;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableEnum.class */
public class MarshalQueryableEnum<T extends Enum<T>> implements MarshalQueryable<T> {
    private static final int UINT8_MASK = 255;
    private static final int UINT8_MAX = 255;
    private static final int UINT8_MIN = 0;
    private static final String TAG = MarshalQueryableEnum.class.getSimpleName();
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private static final HashMap<Class<? extends Enum>, int[]> sEnumValues = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableEnum$MarshalerEnum.class */
    private class MarshalerEnum extends Marshaler<T> {
        private final Class<T> mClass;

        protected MarshalerEnum(TypeReference<T> typeReference, int i) {
            super(MarshalQueryableEnum.this, typeReference, i);
            this.mClass = (Class<? super T>) typeReference.getRawType();
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return MarshalHelpers.getPrimitiveTypeSize(this.mNativeType);
        }

        public void marshal(T t, ByteBuffer byteBuffer) {
            int enumValue = MarshalQueryableEnum.getEnumValue(t);
            if (this.mNativeType == 1) {
                byteBuffer.putInt(enumValue);
            } else if (this.mNativeType != 0) {
                throw new AssertionError();
            } else {
                if (enumValue < 0 || enumValue > 255) {
                    throw new UnsupportedOperationException(String.format("Enum value %x too large to fit into unsigned byte", Integer.valueOf(enumValue)));
                }
                byteBuffer.put((byte) enumValue);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.hardware.camera2.marshal.Marshaler
        public /* bridge */ /* synthetic */ void marshal(Object obj, ByteBuffer byteBuffer) {
            marshal((MarshalerEnum) ((Enum) obj), byteBuffer);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public T unmarshal(ByteBuffer byteBuffer) {
            int i;
            switch (this.mNativeType) {
                case 0:
                    i = byteBuffer.get() & 255;
                    break;
                case 1:
                    i = byteBuffer.getInt();
                    break;
                default:
                    throw new AssertionError("Unexpected native type; impossible since its not supported");
            }
            return (T) MarshalQueryableEnum.getEnumFromValue(this.mClass, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Enum<T>> T getEnumFromValue(Class<T> cls, int i) {
        int i2;
        boolean z = true;
        int[] iArr = sEnumValues.get(cls);
        if (iArr != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i2 = -1;
                if (i4 >= iArr.length) {
                    break;
                } else if (iArr[i4] == i) {
                    i2 = i4;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
        } else {
            i2 = i;
        }
        T[] enumConstants = cls.getEnumConstants();
        if (i2 < 0 || i2 >= enumConstants.length) {
            if (iArr == null) {
                z = false;
            }
            throw new IllegalArgumentException(String.format("Argument 'value' (%d) was not a valid enum value for type %s (registered? %b)", Integer.valueOf(i), cls, Boolean.valueOf(z)));
        }
        return enumConstants[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Enum<T>> int getEnumValue(T t) {
        int[] iArr = sEnumValues.get(t.getClass());
        int ordinal = t.ordinal();
        int i = ordinal;
        if (iArr != null) {
            i = iArr[ordinal];
        }
        return i;
    }

    public static <T extends Enum<T>> void registerEnumValues(Class<T> cls, int[] iArr) {
        if (cls.getEnumConstants().length != iArr.length) {
            throw new IllegalArgumentException("Expected values array to be the same size as the enumTypes values " + iArr.length + " for type " + cls);
        }
        if (VERBOSE) {
            Log.v(TAG, "Registered enum values for type " + cls + " values");
        }
        sEnumValues.put(cls, iArr);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<T> createMarshaler(TypeReference<T> typeReference, int i) {
        return new MarshalerEnum(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<T> typeReference, int i) {
        if ((i == 1 || i == 0) && (typeReference.getType() instanceof Class)) {
            Class cls = (Class) typeReference.getType();
            if (cls.isEnum()) {
                if (VERBOSE) {
                    Log.v(TAG, "possible enum detected for " + cls);
                }
                try {
                    cls.getDeclaredConstructor(String.class, Integer.TYPE);
                    return true;
                } catch (NoSuchMethodException e) {
                    Log.e(TAG, "Can't marshal class " + cls + "; no default constructor");
                    return false;
                } catch (SecurityException e2) {
                    Log.e(TAG, "Can't marshal class " + cls + "; not accessible");
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
