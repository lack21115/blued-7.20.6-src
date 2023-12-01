package android.hardware.camera2.marshal.impl;

import android.hardware.camera2.marshal.MarshalQueryable;
import android.hardware.camera2.marshal.Marshaler;
import android.hardware.camera2.utils.TypeReference;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableParcelable.class */
public class MarshalQueryableParcelable<T extends Parcelable> implements MarshalQueryable<T> {
    private static final String FIELD_CREATOR = "CREATOR";
    private static final String TAG = "MarshalParcelable";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/impl/MarshalQueryableParcelable$MarshalerParcelable.class */
    private class MarshalerParcelable extends Marshaler<T> {
        private final Class<T> mClass;
        private final Parcelable.Creator<T> mCreator;

        protected MarshalerParcelable(TypeReference<T> typeReference, int i) {
            super(MarshalQueryableParcelable.this, typeReference, i);
            this.mClass = (Class<? super T>) typeReference.getRawType();
            try {
                try {
                    this.mCreator = (Parcelable.Creator) this.mClass.getDeclaredField(MarshalQueryableParcelable.FIELD_CREATOR).get(null);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (IllegalArgumentException e2) {
                    throw new AssertionError(e2);
                }
            } catch (NoSuchFieldException e3) {
                throw new AssertionError(e3);
            }
        }

        public int calculateMarshalSize(T t) {
            Parcel obtain = Parcel.obtain();
            try {
                t.writeToParcel(obtain, 0);
                int length = obtain.marshall().length;
                if (MarshalQueryableParcelable.VERBOSE) {
                    Log.v(MarshalQueryableParcelable.TAG, "calculateMarshalSize, length when parceling " + t + " is " + length);
                }
                return length;
            } finally {
                obtain.recycle();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.hardware.camera2.marshal.Marshaler
        public /* bridge */ /* synthetic */ int calculateMarshalSize(Object obj) {
            return calculateMarshalSize((MarshalerParcelable) ((Parcelable) obj));
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public int getNativeSize() {
            return NATIVE_SIZE_DYNAMIC;
        }

        public void marshal(T t, ByteBuffer byteBuffer) {
            if (MarshalQueryableParcelable.VERBOSE) {
                Log.v(MarshalQueryableParcelable.TAG, "marshal " + t);
            }
            Parcel obtain = Parcel.obtain();
            try {
                t.writeToParcel(obtain, 0);
                if (obtain.hasFileDescriptors()) {
                    throw new UnsupportedOperationException("Parcelable " + t + " must not have file descriptors");
                }
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                if (marshall.length == 0) {
                    throw new AssertionError("No data marshaled for " + t);
                }
                byteBuffer.put(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.hardware.camera2.marshal.Marshaler
        public /* bridge */ /* synthetic */ void marshal(Object obj, ByteBuffer byteBuffer) {
            marshal((MarshalerParcelable) ((Parcelable) obj), byteBuffer);
        }

        @Override // android.hardware.camera2.marshal.Marshaler
        public T unmarshal(ByteBuffer byteBuffer) {
            if (MarshalQueryableParcelable.VERBOSE) {
                Log.v(MarshalQueryableParcelable.TAG, "unmarshal, buffer remaining " + byteBuffer.remaining());
            }
            byteBuffer.mark();
            Parcel obtain = Parcel.obtain();
            try {
                int remaining = byteBuffer.remaining();
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                obtain.unmarshall(bArr, 0, remaining);
                obtain.setDataPosition(0);
                T createFromParcel = this.mCreator.createFromParcel(obtain);
                int dataPosition = obtain.dataPosition();
                if (dataPosition == 0) {
                    throw new AssertionError("No data marshaled for " + createFromParcel);
                }
                byteBuffer.reset();
                byteBuffer.position(byteBuffer.position() + dataPosition);
                if (MarshalQueryableParcelable.VERBOSE) {
                    Log.v(MarshalQueryableParcelable.TAG, "unmarshal, parcel length was " + dataPosition);
                    Log.v(MarshalQueryableParcelable.TAG, "unmarshal, value is " + createFromParcel);
                }
                return this.mClass.cast(createFromParcel);
            } finally {
                obtain.recycle();
            }
        }
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public Marshaler<T> createMarshaler(TypeReference<T> typeReference, int i) {
        return new MarshalerParcelable(typeReference, i);
    }

    @Override // android.hardware.camera2.marshal.MarshalQueryable
    public boolean isTypeMappingSupported(TypeReference<T> typeReference, int i) {
        return Parcelable.class.isAssignableFrom(typeReference.getRawType());
    }
}
