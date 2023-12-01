package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UShort.class */
public final class UShort implements Comparable<UShort> {
    public static final Companion a = new Companion(null);
    private final short b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UShort$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UShort(short s) {
        this.b = s;
    }

    public static String a(short s) {
        return String.valueOf(s & 65535);
    }

    public static boolean a(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).a();
    }

    public static int b(short s) {
        return s;
    }

    public static short c(short s) {
        return s;
    }

    public static final /* synthetic */ UShort d(short s) {
        return new UShort(s);
    }

    public final /* synthetic */ short a() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.a(a() & 65535, uShort.a() & 65535);
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
