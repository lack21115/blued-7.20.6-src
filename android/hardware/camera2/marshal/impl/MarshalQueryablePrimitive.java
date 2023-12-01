package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalHelpers;
import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.util.Rational;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryablePrimitive.class */
public final class MarshalQueryablePrimitive<T> implements MarshalQueryable<T> {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryablePrimitive$MarshalerPrimitive.class */
    private class MarshalerPrimitive extends Marshaler<T> {
        private final Class<T> mClass;

        protected MarshalerPrimitive(TypeReference<T> typeReference, int i) {
            super(MarshalQueryablePrimitive.this, typeReference, i);
            this.mClass = MarshalHelpers.wrapClassIfPrimitive(typeReference.getRawType());
        }

        private void marshalPrimitive(byte b, ByteBuffer byteBuffer) {
            byteBuffer.put(b);
        }

        private void marshalPrimitive(double d, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(d);
        }

        private void marshalPrimitive(float f, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(f);
        }

        private void marshalPrimitive(int i, ByteBuffer byteBuffer) {
            byteBuffer.putInt(i);
        }

        private void marshalPrimitive(long j, ByteBuffer byteBuffer) {
            byteBuffer.putLong(j);
        }

        private void marshalPrimitive(Rational rational, ByteBuffer byteBuffer) {
            byteBuffer.putInt(rational.getNumerator());
            byteBuffer.putInt(rational.getDenominator());
        }

        private Object unmarshalObject(ByteBuffer byteBuffer) {
            switch (this.mNativeType) {
                case 0:
                    return Byte.valueOf(byteBuffer.get());
                case 1:
                    return Integer.valueOf(byteBuffer.getInt());
                case 2:
                    return Float.valueOf(byteBuffer.getFloat());
                case 3:
                    return Long.valueOf(byteBuffer.getLong());
                case 4:
                    return Double.valueOf(byteBuffer.getDouble());
                case 5:
                    return new Rational(byteBuffer.getInt(), byteBuffer.getInt());
                default:
                    throw new UnsupportedOperationException("Can't unmarshal native type " + this.mNativeType);
            }
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int calculateMarshalSize(T t) {
            return MarshalHelpers.getPrimitiveTypeSize(this.mNativeType);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return MarshalHelpers.getPrimitiveTypeSize(this.mNativeType);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(T t, ByteBuffer byteBuffer) {
            if (t instanceof Integer) {
                MarshalHelpers.checkNativeTypeEquals(1, this.mNativeType);
                marshalPrimitive(((Integer) t).intValue(), byteBuffer);
            } else if (t instanceof Float) {
                MarshalHelpers.checkNativeTypeEquals(2, this.mNativeType);
                marshalPrimitive(((Float) t).floatValue(), byteBuffer);
            } else if (t instanceof Long) {
                MarshalHelpers.checkNativeTypeEquals(3, this.mNativeType);
                marshalPrimitive(((Long) t).longValue(), byteBuffer);
            } else if (t instanceof Rational) {
                MarshalHelpers.checkNativeTypeEquals(5, this.mNativeType);
                marshalPrimitive((Rational) t, byteBuffer);
            } else if (t instanceof Double) {
                MarshalHelpers.checkNativeTypeEquals(4, this.mNativeType);
                marshalPrimitive(((Double) t).doubleValue(), byteBuffer);
            } else if (!(t instanceof Byte)) {
                throw new UnsupportedOperationException("Can't marshal managed type " + this.mTypeReference);
            } else {
                MarshalHelpers.checkNativeTypeEquals(0, this.mNativeType);
                marshalPrimitive(((Byte) t).byteValue(), byteBuffer);
            }
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public T unmarshal(ByteBuffer byteBuffer) {
            return this.mClass.cast(unmarshalObject(byteBuffer));
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<T> createMarshaler(TypeReference<T> typeReference, int i) {
        return new MarshalerPrimitive(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<T> typeReference, int i) {
        if (typeReference.getType() instanceof Class) {
            Class cls = (Class) typeReference.getType();
            return (cls == Byte.TYPE || cls == Byte.class) ? i == 0 : (cls == Integer.TYPE || cls == Integer.class) ? i == 1 : (cls == Float.TYPE || cls == Float.class) ? i == 2 : (cls == Long.TYPE || cls == Long.class) ? i == 3 : (cls == Double.TYPE || cls == Double.class) ? i == 4 : cls == Rational.class && i == 5;
        }
        return false;
    }
}
