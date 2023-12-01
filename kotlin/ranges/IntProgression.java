package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/IntProgression.class */
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42576a = new Companion(null);
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42577c;
    private final int d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/IntProgression$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression a(int i, int i2, int i3) {
            return new IntProgression(i, i2, i3);
        }
    }

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = i;
        this.f42577c = ProgressionUtilKt.a(i, i2, i3);
        this.d = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f42577c;
    }

    public final int c() {
        return this.d;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.b, this.f42577c, this.d);
    }

    public boolean e() {
        return this.d > 0 ? this.b > this.f42577c : this.b < this.f42577c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (e() && ((IntProgression) obj).e()) {
                return true;
            }
            IntProgression intProgression = (IntProgression) obj;
            return this.b == intProgression.b && this.f42577c == intProgression.f42577c && this.d == intProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (((this.b * 31) + this.f42577c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.f42577c);
            sb.append(" step ");
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.f42577c);
            sb.append(" step ");
            i = -this.d;
        }
        sb.append(i);
        return sb.toString();
    }
}
