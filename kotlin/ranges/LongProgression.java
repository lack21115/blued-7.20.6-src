package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/LongProgression.class */
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42581a = new Companion(null);
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f42582c;
    private final long d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/LongProgression$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = j;
        this.f42582c = ProgressionUtilKt.a(j, j2, j3);
        this.d = j3;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.f42582c;
    }

    @Override // java.lang.Iterable
    /* renamed from: c */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.b, this.f42582c, this.d);
    }

    public boolean d() {
        long j = this.d;
        long j2 = this.b;
        long j3 = this.f42582c;
        return j > 0 ? j2 > j3 : j2 < j3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongProgression) {
            if (d() && ((LongProgression) obj).d()) {
                return true;
            }
            LongProgression longProgression = (LongProgression) obj;
            return this.b == longProgression.b && this.f42582c == longProgression.f42582c && this.d == longProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (d()) {
            return -1;
        }
        long j = 31;
        long j2 = this.b;
        long j3 = this.f42582c;
        long j4 = this.d;
        return (int) ((j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)))) + (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.f42582c);
            sb.append(" step ");
            j = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.f42582c);
            sb.append(" step ");
            j = -this.d;
        }
        sb.append(j);
        return sb.toString();
    }
}
