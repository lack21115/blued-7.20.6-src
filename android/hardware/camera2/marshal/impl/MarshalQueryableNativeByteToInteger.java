package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableNativeByteToInteger.class */
public class MarshalQueryableNativeByteToInteger implements MarshalQueryable<Integer> {
    private static final int UINT8_MASK = 255;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableNativeByteToInteger$MarshalerNativeByteToInteger.class */
    private class MarshalerNativeByteToInteger extends Marshaler<Integer> {
        protected MarshalerNativeByteToInteger(TypeReference<Integer> typeReference, int i) {
            super(MarshalQueryableNativeByteToInteger.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 1;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(Integer num, ByteBuffer byteBuffer) {
            byteBuffer.put((byte) num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public Integer unmarshal(ByteBuffer byteBuffer) {
            return Integer.valueOf(byteBuffer.get() & 255);
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<Integer> createMarshaler(TypeReference<Integer> typeReference, int i) {
        return new MarshalerNativeByteToInteger(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<Integer> typeReference, int i) {
        return (Integer.class.equals(typeReference.getType()) || Integer.TYPE.equals(typeReference.getType())) && i == 0;
    }
}
