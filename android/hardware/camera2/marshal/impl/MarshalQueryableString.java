package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableString.class */
public class MarshalQueryableString implements MarshalQueryable<String> {
    private static final byte NUL = 0;
    private static final String TAG = MarshalQueryableString.class.getSimpleName();
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableString$MarshalerString.class */
    private class MarshalerString extends Marshaler<String> {
        protected MarshalerString(TypeReference<String> typeReference, int i) {
            super(MarshalQueryableString.this, typeReference, i);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int calculateMarshalSize(String str) {
            return str.getBytes(MarshalQueryableString.UTF8_CHARSET).length + 1;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return NATIVE_SIZE_DYNAMIC;
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public void marshal(String str, ByteBuffer byteBuffer) {
            byteBuffer.put(str.getBytes(MarshalQueryableString.UTF8_CHARSET));
            byteBuffer.put((byte) 0);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public String unmarshal(ByteBuffer byteBuffer) {
            int i;
            boolean z;
            byteBuffer.mark();
            int i2 = 0;
            while (true) {
                i = i2;
                z = false;
                if (!byteBuffer.hasRemaining()) {
                    break;
                } else if (byteBuffer.get() == 0) {
                    z = true;
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            if (MarshalQueryableString.VERBOSE) {
                Log.v(MarshalQueryableString.TAG, "unmarshal - scanned " + i + " characters; found null? " + z);
            }
            if (z) {
                byteBuffer.reset();
                byte[] bArr = new byte[i + 1];
                byteBuffer.get(bArr, 0, i + 1);
                return new String(bArr, 0, i, MarshalQueryableString.UTF8_CHARSET);
            }
            throw new UnsupportedOperationException("Strings must be null-terminated");
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<String> createMarshaler(TypeReference<String> typeReference, int i) {
        return new MarshalerString(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<String> typeReference, int i) {
        return i == 0 && String.class.equals(typeReference.getType());
    }
}
