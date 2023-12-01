package android.hardware.camera2.marshal;

import android.hardware.camera2.utils.TypeReference;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/MarshalQueryable.class */
public interface MarshalQueryable<T> {
    Marshaler<T> createMarshaler(TypeReference<T> typeReference, int i);

    boolean isTypeMappingSupported(TypeReference<T> typeReference, int i);
}
