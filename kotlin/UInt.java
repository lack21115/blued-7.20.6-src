package kotlin;

import android.widget.ExpandableListView;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UInt.class */
public final class UInt implements Comparable<UInt> {
    public static final Companion a = new Companion(null);
    private final int b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UInt$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UInt(int i) {
        this.b = i;
    }

    public static String a(int i) {
        return String.valueOf(i & ExpandableListView.PACKED_POSITION_VALUE_NULL);
    }

    public static boolean a(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).a();
    }

    public static int b(int i) {
        return i;
    }

    public static int c(int i) {
        return i;
    }

    public static final /* synthetic */ UInt d(int i) {
        return new UInt(i);
    }

    public final /* synthetic */ int a() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.a(a(), uInt.a());
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
