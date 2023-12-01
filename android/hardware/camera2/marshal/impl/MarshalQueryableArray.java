package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.MarshalRegistry;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.util.Log;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableArray.class */
public class MarshalQueryableArray<T> implements MarshalQueryable<T> {
    private static final String TAG = MarshalQueryableArray.class.getSimpleName();
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableArray$MarshalerArray.class */
    private class MarshalerArray extends Marshaler<T> {
        private final Class<T> mClass;
        private final Class<?> mComponentClass;
        private final Marshaler<?> mComponentMarshaler;

        protected MarshalerArray(TypeReference<T> typeReference, int i) {
            super(MarshalQueryableArray.this, typeReference, i);
            this.mClass = (Class<? super T>) typeReference.getRawType();
            TypeReference<?> componentType = typeReference.getComponentType();
            this.mComponentMarshaler = MarshalRegistry.getMarshaler(componentType, this.mNativeType);
            this.mComponentClass = componentType.getRawType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <TElem> int calculateElementMarshalSize(Marshaler<TElem> marshaler, Object obj, int i) {
            return marshaler.calculateMarshalSize(Array.get(obj, i));
        }

        private Object copyListToArray(ArrayList<?> arrayList, Object obj) {
            return arrayList.toArray((Object[]) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <TElem> void marshalArrayElement(Marshaler<TElem> marshaler, ByteBuffer byteBuffer, Object obj, int i) {
            marshaler.marshal(Array.get(obj, i), byteBuffer);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int calculateMarshalSize(T t) {
            int i;
            int nativeSize = this.mComponentMarshaler.getNativeSize();
            int length = Array.getLength(t);
            if (nativeSize == Marshaler.NATIVE_SIZE_DYNAMIC) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    i = i2;
                    if (i4 >= length) {
                        break;
                    }
                    i2 += calculateElementMarshalSize(this.mComponentMarshaler, t, i4);
                    i3 = i4 + 1;
                }
            } else {
                i = nativeSize * length;
            }
            return i;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return NATIVE_SIZE_DYNAMIC;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(T t, ByteBuffer byteBuffer) {
            int length = Array.getLength(t);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                marshalArrayElement(this.mComponentMarshaler, byteBuffer, t, i2);
                i = i2 + 1;
            }
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public T unmarshal(ByteBuffer byteBuffer) {
            Object copyListToArray;
            int nativeSize = this.mComponentMarshaler.getNativeSize();
            if (nativeSize != Marshaler.NATIVE_SIZE_DYNAMIC) {
                int remaining = byteBuffer.remaining();
                int i = remaining / nativeSize;
                if (remaining % nativeSize == 0) {
                    if (MarshalQueryableArray.VERBOSE) {
                        Log.v(MarshalQueryableArray.TAG, String.format("Attempting to unpack array (count = %d, element size = %d, bytes remaining = %d) for type %s", Integer.valueOf(i), Integer.valueOf(nativeSize), Integer.valueOf(remaining), this.mClass));
                    }
                    Object newInstance = Array.newInstance(this.mComponentClass, i);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        copyListToArray = newInstance;
                        if (i3 >= i) {
                            break;
                        }
                        Array.set(newInstance, i3, this.mComponentMarshaler.unmarshal(byteBuffer));
                        i2 = i3 + 1;
                    }
                } else {
                    throw new UnsupportedOperationException("Arrays for " + this.mTypeReference + " must be packed tighly into a multiple of " + nativeSize + "; but there are " + (remaining % nativeSize) + " left over bytes");
                }
            } else {
                ArrayList<?> arrayList = new ArrayList<>();
                while (byteBuffer.hasRemaining()) {
                    arrayList.add(this.mComponentMarshaler.unmarshal(byteBuffer));
                }
                copyListToArray = copyListToArray(arrayList, Array.newInstance(this.mComponentClass, arrayList.size()));
            }
            if (byteBuffer.remaining() != 0) {
                Log.e(MarshalQueryableArray.TAG, "Trailing bytes (" + byteBuffer.remaining() + ") left over after unpacking " + this.mClass);
            }
            return this.mClass.cast(copyListToArray);
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<T> createMarshaler(TypeReference<T> typeReference, int i) {
        return new MarshalerArray(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<T> typeReference, int i) {
        return typeReference.getRawType().isArray();
    }
}
