package android.hardware.camera2.marshal;

import android.hardware.camera2.utils.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/MarshalRegistry.class */
public class MarshalRegistry {
    private static List<MarshalQueryable<?>> sRegisteredMarshalQueryables = new ArrayList();
    private static HashMap<MarshalToken<?>, Marshaler<?>> sMarshalerMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/marshal/MarshalRegistry$MarshalToken.class */
    public static class MarshalToken<T> {
        private final int hash;
        final int nativeType;
        final TypeReference<T> typeReference;

        public MarshalToken(TypeReference<T> typeReference, int i) {
            this.typeReference = typeReference;
            this.nativeType = i;
            this.hash = typeReference.hashCode() ^ i;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof MarshalToken) {
                MarshalToken marshalToken = (MarshalToken) obj;
                z = false;
                if (this.typeReference.equals(marshalToken.typeReference)) {
                    z = false;
                    if (this.nativeType == marshalToken.nativeType) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    private MarshalRegistry() {
        throw new AssertionError();
    }

    public static <T> Marshaler<T> getMarshaler(TypeReference<T> typeReference, int i) {
        MarshalToken<?> marshalToken = new MarshalToken<>(typeReference, i);
        Marshaler<?> marshaler = sMarshalerMap.get(marshalToken);
        if (sRegisteredMarshalQueryables.size() == 0) {
            throw new AssertionError("No available query marshalers registered");
        }
        Marshaler<?> marshaler2 = marshaler;
        if (marshaler == null) {
            Iterator<MarshalQueryable<?>> it = sRegisteredMarshalQueryables.iterator();
            while (true) {
                marshaler2 = marshaler;
                if (!it.hasNext()) {
                    break;
                }
                MarshalQueryable<?> next = it.next();
                if (next.isTypeMappingSupported(typeReference, i)) {
                    marshaler2 = next.createMarshaler(typeReference, i);
                    break;
                }
            }
            if (marshaler2 == null) {
                throw new UnsupportedOperationException("Could not find marshaler that matches the requested combination of type reference " + typeReference + " and native type " + MarshalHelpers.toStringNativeType(i));
            }
            sMarshalerMap.put(marshalToken, marshaler2);
        }
        return (Marshaler<T>) marshaler2;
    }

    public static <T> void registerMarshalQueryable(MarshalQueryable<T> marshalQueryable) {
        sRegisteredMarshalQueryables.add(marshalQueryable);
    }
}
