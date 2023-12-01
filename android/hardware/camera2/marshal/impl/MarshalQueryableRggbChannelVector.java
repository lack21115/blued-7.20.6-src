package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.params.RggbChannelVector;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableRggbChannelVector.class */
public class MarshalQueryableRggbChannelVector implements MarshalQueryable<RggbChannelVector> {
    private static final int SIZE = 16;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableRggbChannelVector$MarshalerRggbChannelVector.class */
    private class MarshalerRggbChannelVector extends Marshaler<RggbChannelVector> {
        protected MarshalerRggbChannelVector(TypeReference<RggbChannelVector> typeReference, int i) {
            super(MarshalQueryableRggbChannelVector.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 16;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(RggbChannelVector rggbChannelVector, ByteBuffer byteBuffer) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    return;
                }
                byteBuffer.putFloat(rggbChannelVector.getComponent(i2));
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public RggbChannelVector unmarshal(ByteBuffer byteBuffer) {
            return new RggbChannelVector(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<RggbChannelVector> createMarshaler(TypeReference<RggbChannelVector> typeReference, int i) {
        return new MarshalerRggbChannelVector(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<RggbChannelVector> typeReference, int i) {
        return i == 2 && RggbChannelVector.class.equals(typeReference.getType());
    }
}
