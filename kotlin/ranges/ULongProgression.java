package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ULongProgression.class */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42591a = new Companion(null);
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f42592c;
    private final long d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ULongProgression$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = j;
        this.f42592c = UProgressionUtilKt.a(j, j2, j3);
        this.d = j3;
    }

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.f42592c;
    }

    public boolean c() {
        long j = this.d;
        int a2 = UnsignedKt.a(a(), b());
        return j > 0 ? a2 > 0 : a2 < 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ULongProgression) {
            if (c() && ((ULongProgression) obj).c()) {
                return true;
            }
            ULongProgression uLongProgression = (ULongProgression) obj;
            return a() == uLongProgression.a() && b() == uLongProgression.b() && this.d == uLongProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        int c2 = (int) ULong.c(a() ^ ULong.c(a() >>> 32));
        int c3 = (int) ULong.c(b() ^ ULong.c(b() >>> 32));
        long j = this.d;
        return ((int) (j ^ (j >>> 32))) + (((c2 * 31) + c3) * 31);
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(a(), b(), this.d, null);
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append((Object) ULong.a(a()));
            sb.append("..");
            sb.append((Object) ULong.a(b()));
            sb.append(" step ");
            j = this.d;
        } else {
            sb = new StringBuilder();
            sb.append((Object) ULong.a(a()));
            sb.append(" downTo ");
            sb.append((Object) ULong.a(b()));
            sb.append(" step ");
            j = -this.d;
        }
        sb.append(j);
        return sb.toString();
    }
}
