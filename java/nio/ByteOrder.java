package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteOrder.class */
public final class ByteOrder {
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteOrder LITTLE_ENDIAN;
    private static final ByteOrder NATIVE_ORDER;
    private final String name;
    public final boolean needsSwap;

    static {
        boolean isLittleEndian = isLittleEndian();
        BIG_ENDIAN = new ByteOrder("BIG_ENDIAN", isLittleEndian);
        LITTLE_ENDIAN = new ByteOrder("LITTLE_ENDIAN", !isLittleEndian);
        NATIVE_ORDER = isLittleEndian ? LITTLE_ENDIAN : BIG_ENDIAN;
    }

    private ByteOrder(String str, boolean z) {
        this.name = str;
        this.needsSwap = z;
    }

    private static native boolean isLittleEndian();

    public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }

    public String toString() {
        return this.name;
    }
}
