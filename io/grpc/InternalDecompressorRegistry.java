package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/InternalDecompressorRegistry.class */
public final class InternalDecompressorRegistry {
    private InternalDecompressorRegistry() {
    }

    public static byte[] getRawAdvertisedMessageEncodings(DecompressorRegistry decompressorRegistry) {
        return decompressorRegistry.getRawAdvertisedMessageEncodings();
    }
}
