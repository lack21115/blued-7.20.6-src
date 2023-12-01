package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.params.BlackLevelPattern;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableBlackLevelPattern.class */
public class MarshalQueryableBlackLevelPattern implements MarshalQueryable<BlackLevelPattern> {
    private static final int SIZE = 16;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableBlackLevelPattern$MarshalerBlackLevelPattern.class */
    private class MarshalerBlackLevelPattern extends Marshaler<BlackLevelPattern> {
        protected MarshalerBlackLevelPattern(TypeReference<BlackLevelPattern> typeReference, int i) {
            super(MarshalQueryableBlackLevelPattern.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 16;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(BlackLevelPattern blackLevelPattern, ByteBuffer byteBuffer) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < 2) {
                        byteBuffer.putInt(blackLevelPattern.getOffsetForIndex(i4, i2));
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public BlackLevelPattern unmarshal(ByteBuffer byteBuffer) {
            int[] iArr = new int[4];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    return new BlackLevelPattern(iArr);
                }
                iArr[i2] = byteBuffer.getInt();
                i = i2 + 1;
            }
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<BlackLevelPattern> createMarshaler(TypeReference<BlackLevelPattern> typeReference, int i) {
        return new MarshalerBlackLevelPattern(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<BlackLevelPattern> typeReference, int i) {
        return i == 1 && BlackLevelPattern.class.equals(typeReference.getType());
    }
}
