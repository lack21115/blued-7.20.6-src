package android.hardware.camera2.marshal.impl;

import android.graphics.Rect;
import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableRect.class */
public class MarshalQueryableRect implements MarshalQueryable<Rect> {
    private static final int SIZE = 16;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableRect$MarshalerRect.class */
    private class MarshalerRect extends Marshaler<Rect> {
        protected MarshalerRect(TypeReference<Rect> typeReference, int i) {
            super(MarshalQueryableRect.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 16;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(Rect rect, ByteBuffer byteBuffer) {
            byteBuffer.putInt(rect.left);
            byteBuffer.putInt(rect.top);
            byteBuffer.putInt(rect.width());
            byteBuffer.putInt(rect.height());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public Rect unmarshal(ByteBuffer byteBuffer) {
            int i = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            return new Rect(i, i2, i + byteBuffer.getInt(), i2 + byteBuffer.getInt());
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<Rect> createMarshaler(TypeReference<Rect> typeReference, int i) {
        return new MarshalerRect(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<Rect> typeReference, int i) {
        return i == 1 && Rect.class.equals(typeReference.getType());
    }
}
