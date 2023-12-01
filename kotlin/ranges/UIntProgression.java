package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/UIntProgression.class */
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    public static final Companion a = new Companion(null);
    private final int b;
    private final int c;
    private final int d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/UIntProgression$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UIntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = i;
        this.c = UProgressionUtilKt.a(i, i2, i3);
        this.d = i3;
    }

    public /* synthetic */ UIntProgression(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public boolean c() {
        return this.d > 0 ? UnsignedKt.a(a(), b()) > 0 : UnsignedKt.a(a(), b()) < 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof UIntProgression) {
            if (c() && ((UIntProgression) obj).c()) {
                return true;
            }
            UIntProgression uIntProgression = (UIntProgression) obj;
            return a() == uIntProgression.a() && b() == uIntProgression.b() && this.d == uIntProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (((a() * 31) + b()) * 31) + this.d;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(a(), b(), this.d, null);
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append((Object) UInt.a(a()));
            sb.append("..");
            sb.append((Object) UInt.a(b()));
            sb.append(" step ");
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append((Object) UInt.a(a()));
            sb.append(" downTo ");
            sb.append((Object) UInt.a(b()));
            sb.append(" step ");
            i = -this.d;
        }
        sb.append(i);
        return sb.toString();
    }
}
