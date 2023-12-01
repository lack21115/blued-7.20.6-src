package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/ULong.class */
public final class ULong implements Comparable<ULong> {
    public static final Companion a = new Companion(null);
    private final long b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ULong$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ ULong(long j) {
        this.b = j;
    }

    public static String a(long j) {
        return UnsignedKt.a(j);
    }

    public static boolean a(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).a();
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static long c(long j) {
        return j;
    }

    public static final /* synthetic */ ULong d(long j) {
        return new ULong(j);
    }

    public final /* synthetic */ long a() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.a(a(), uLong.a());
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
