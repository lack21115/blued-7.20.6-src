package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.MarshalRegistry;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.util.Pair;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryablePair.class */
public class MarshalQueryablePair<T1, T2> implements MarshalQueryable<Pair<T1, T2>> {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryablePair$MarshalerPair.class */
    private class MarshalerPair extends Marshaler<Pair<T1, T2>> {
        private final Class<? super Pair<T1, T2>> mClass;
        private final Constructor<Pair<T1, T2>> mConstructor;
        private final Marshaler<T1> mNestedTypeMarshalerFirst;
        private final Marshaler<T2> mNestedTypeMarshalerSecond;

        protected MarshalerPair(TypeReference<Pair<T1, T2>> typeReference, int i) {
            super(MarshalQueryablePair.this, typeReference, i);
            this.mClass = typeReference.getRawType();
            try {
                ParameterizedType parameterizedType = (ParameterizedType) typeReference.getType();
                this.mNestedTypeMarshalerFirst = MarshalRegistry.getMarshaler(TypeReference.createSpecializedTypeReference(parameterizedType.getActualTypeArguments()[0]), this.mNativeType);
                this.mNestedTypeMarshalerSecond = MarshalRegistry.getMarshaler(TypeReference.createSpecializedTypeReference(parameterizedType.getActualTypeArguments()[1]), this.mNativeType);
                try {
                    this.mConstructor = (Constructor<? super Pair<T1, T2>>) this.mClass.getConstructor(Object.class, Object.class);
                } catch (NoSuchMethodException e) {
                    throw new AssertionError(e);
                }
            } catch (ClassCastException e2) {
                throw new AssertionError("Raw use of Pair is not supported", e2);
            }
        }

        public int calculateMarshalSize(Pair<T1, T2> pair) {
            int nativeSize = getNativeSize();
            return nativeSize != NATIVE_SIZE_DYNAMIC ? nativeSize : this.mNestedTypeMarshalerFirst.calculateMarshalSize(pair.first) + this.mNestedTypeMarshalerSecond.calculateMarshalSize(pair.second);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public /* bridge */ /* synthetic */ int calculateMarshalSize(Object obj) {
            return calculateMarshalSize((Pair) ((Pair) obj));
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            int nativeSize = this.mNestedTypeMarshalerFirst.getNativeSize();
            int nativeSize2 = this.mNestedTypeMarshalerSecond.getNativeSize();
            return (nativeSize == NATIVE_SIZE_DYNAMIC || nativeSize2 == NATIVE_SIZE_DYNAMIC) ? NATIVE_SIZE_DYNAMIC : nativeSize + nativeSize2;
        }

        public void marshal(Pair<T1, T2> pair, ByteBuffer byteBuffer) {
            if (pair.first == null) {
                throw new UnsupportedOperationException("Pair#first must not be null");
            }
            if (pair.second == null) {
                throw new UnsupportedOperationException("Pair#second must not be null");
            }
            this.mNestedTypeMarshalerFirst.marshal(pair.first, byteBuffer);
            this.mNestedTypeMarshalerSecond.marshal(pair.second, byteBuffer);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public /* bridge */ /* synthetic */ void marshal(Object obj, ByteBuffer byteBuffer) {
            marshal((Pair) ((Pair) obj), byteBuffer);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public Pair<T1, T2> unmarshal(ByteBuffer byteBuffer) {
            try {
                return this.mConstructor.newInstance(this.mNestedTypeMarshalerFirst.unmarshal(byteBuffer), this.mNestedTypeMarshalerSecond.unmarshal(byteBuffer));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalArgumentException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<Pair<T1, T2>> createMarshaler(TypeReference<Pair<T1, T2>> typeReference, int i) {
        return new MarshalerPair(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<Pair<T1, T2>> typeReference, int i) {
        return Pair.class.equals(typeReference.getRawType());
    }
}
