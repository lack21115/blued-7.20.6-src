package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.params.ReprocessFormatsMap;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableReprocessFormatsMap.class */
public class MarshalQueryableReprocessFormatsMap implements MarshalQueryable<ReprocessFormatsMap> {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableReprocessFormatsMap$MarshalerReprocessFormatsMap.class */
    private class MarshalerReprocessFormatsMap extends Marshaler<ReprocessFormatsMap> {
        protected MarshalerReprocessFormatsMap(TypeReference<ReprocessFormatsMap> typeReference, int i) {
            super(MarshalQueryableReprocessFormatsMap.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int calculateMarshalSize(ReprocessFormatsMap reprocessFormatsMap) {
            int i = 0;
            int[] inputs = reprocessFormatsMap.getInputs();
            int length = inputs.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return i * 4;
                }
                i = i + 1 + 1 + reprocessFormatsMap.getOutputs(inputs[i3]).length;
                i2 = i3 + 1;
            }
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return NATIVE_SIZE_DYNAMIC;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(ReprocessFormatsMap reprocessFormatsMap, ByteBuffer byteBuffer) {
            int[] imageFormatToInternal = StreamConfigurationMap.imageFormatToInternal(reprocessFormatsMap.getInputs());
            int length = imageFormatToInternal.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                int i3 = imageFormatToInternal[i2];
                byteBuffer.putInt(i3);
                int[] imageFormatToInternal2 = StreamConfigurationMap.imageFormatToInternal(reprocessFormatsMap.getOutputs(i3));
                byteBuffer.putInt(imageFormatToInternal2.length);
                int length2 = imageFormatToInternal2.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < length2) {
                        byteBuffer.putInt(imageFormatToInternal2[i5]);
                        i4 = i5 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public ReprocessFormatsMap unmarshal(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining() / 4;
            if (byteBuffer.remaining() % 4 != 0) {
                throw new AssertionError("ReprocessFormatsMap was not TYPE_INT32");
            }
            int[] iArr = new int[remaining];
            byteBuffer.asIntBuffer().get(iArr);
            return new ReprocessFormatsMap(iArr);
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<ReprocessFormatsMap> createMarshaler(TypeReference<ReprocessFormatsMap> typeReference, int i) {
        return new MarshalerReprocessFormatsMap(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<ReprocessFormatsMap> typeReference, int i) {
        return i == 1 && typeReference.getType().equals(ReprocessFormatsMap.class);
    }
}
