package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.params.HighSpeedVideoConfiguration;
import android.hardware.camera2.utils.TypeReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableHighSpeedVideoConfiguration.class */
public class MarshalQueryableHighSpeedVideoConfiguration implements MarshalQueryable<HighSpeedVideoConfiguration> {
    private static final int SIZE = 16;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableHighSpeedVideoConfiguration$MarshalerHighSpeedVideoConfiguration.class */
    private class MarshalerHighSpeedVideoConfiguration extends Marshaler<HighSpeedVideoConfiguration> {
        protected MarshalerHighSpeedVideoConfiguration(TypeReference<HighSpeedVideoConfiguration> typeReference, int i) {
            super(MarshalQueryableHighSpeedVideoConfiguration.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return 16;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(HighSpeedVideoConfiguration highSpeedVideoConfiguration, ByteBuffer byteBuffer) {
            byteBuffer.putInt(highSpeedVideoConfiguration.getWidth());
            byteBuffer.putInt(highSpeedVideoConfiguration.getHeight());
            byteBuffer.putInt(highSpeedVideoConfiguration.getFpsMin());
            byteBuffer.putInt(highSpeedVideoConfiguration.getFpsMax());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.hardware.camera2.marshal.Marshaler
        public HighSpeedVideoConfiguration unmarshal(ByteBuffer byteBuffer) {
            return new HighSpeedVideoConfiguration(byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<HighSpeedVideoConfiguration> createMarshaler(TypeReference<HighSpeedVideoConfiguration> typeReference, int i) {
        return new MarshalerHighSpeedVideoConfiguration(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<HighSpeedVideoConfiguration> typeReference, int i) {
        return i == 1 && typeReference.getType().equals(HighSpeedVideoConfiguration.class);
    }
}
