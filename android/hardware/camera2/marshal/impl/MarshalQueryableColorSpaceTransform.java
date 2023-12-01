package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableColorSpaceTransform.class */
public class MarshalQueryableColorSpaceTransform implements MarshalQueryable<ColorSpaceTransform> {
    private static final int ELEMENTS_INT32 = 18;
    private static final int SIZE = 72;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableColorSpaceTransform$MarshalerColorSpaceTransform.class */
    private class MarshalerColorSpaceTransform extends Marshaler<ColorSpaceTransform> {
        protected MarshalerColorSpaceTransform(TypeReference<ColorSpaceTransform> typeReference, int i) {
            super(MarshalQueryableColorSpaceTransform.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 72;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(ColorSpaceTransform colorSpaceTransform, ByteBuffer byteBuffer) {
            int[] iArr = new int[18];
            colorSpaceTransform.copyElements(iArr, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 18) {
                    return;
                }
                byteBuffer.putInt(iArr[i2]);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public ColorSpaceTransform unmarshal(ByteBuffer byteBuffer) {
            int[] iArr = new int[18];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 18) {
                    return new ColorSpaceTransform(iArr);
                }
                iArr[i2] = byteBuffer.getInt();
                i = i2 + 1;
            }
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<ColorSpaceTransform> createMarshaler(TypeReference<ColorSpaceTransform> typeReference, int i) {
        return new MarshalerColorSpaceTransform(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<ColorSpaceTransform> typeReference, int i) {
        return i == 5 && ColorSpaceTransform.class.equals(typeReference.getType());
    }
}
