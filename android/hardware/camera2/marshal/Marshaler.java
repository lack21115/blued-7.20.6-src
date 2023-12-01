package android.hardware.camera2.marshal;

import android.hardware.camera2.utils.TypeReference;
import com.android.internal.util.Preconditions;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/Marshaler.class */
public abstract class Marshaler<T> {
    public static int NATIVE_SIZE_DYNAMIC = -1;
    protected final int mNativeType;
    protected final TypeReference<T> mTypeReference;

    /* JADX INFO: Access modifiers changed from: protected */
    public Marshaler(MarshalQueryable<T> marshalQueryable, TypeReference<T> typeReference, int i) {
        this.mTypeReference = (TypeReference) Preconditions.checkNotNull(typeReference, "typeReference must not be null");
        this.mNativeType = MarshalHelpers.checkNativeType(i);
        if (!marshalQueryable.isTypeMappingSupported(typeReference, i)) {
            throw new UnsupportedOperationException("Unsupported type marshaling for managed type " + typeReference + " and native type " + MarshalHelpers.toStringNativeType(i));
        }
    }

    public int calculateMarshalSize(T t) {
        int nativeSize = getNativeSize();
        if (nativeSize == NATIVE_SIZE_DYNAMIC) {
            throw new AssertionError("Override this function for dynamically-sized objects");
        }
        return nativeSize;
    }

    public abstract int getNativeSize();

    public int getNativeType() {
        return this.mNativeType;
    }

    public TypeReference<T> getTypeReference() {
        return this.mTypeReference;
    }

    public abstract void marshal(T t, ByteBuffer byteBuffer);

    public abstract T unmarshal(ByteBuffer byteBuffer);
}
