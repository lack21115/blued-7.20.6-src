package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UByte.class */
public final class UByte implements Comparable<UByte> {
    public static final Companion a = new Companion(null);
    private final byte b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UByte$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UByte(byte b) {
        this.b = b;
    }

    public static String a(byte b) {
        return String.valueOf(b & 255);
    }

    public static boolean a(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).a();
    }

    public static int b(byte b) {
        return b;
    }

    public static byte c(byte b) {
        return b;
    }

    public static final /* synthetic */ UByte d(byte b) {
        return new UByte(b);
    }

    public final /* synthetic */ byte a() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.a(a() & 255, uByte.a() & 255);
    }

    public boolean equals(Object obj) {
        return a(this.b, obj);
    }

    public int hashCode() {
        return b(this.b);
    }

    public String toString() {
        return a(this.b);
    }
}
