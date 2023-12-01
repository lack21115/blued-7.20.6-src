package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharProgression.class */
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42568a = new Companion(null);
    private final char b;

    /* renamed from: c  reason: collision with root package name */
    private final char f42569c;
    private final int d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharProgression$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c2, char c3, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = c2;
        this.f42569c = (char) ProgressionUtilKt.a((int) c2, (int) c3, i);
        this.d = i;
    }

    public final char a() {
        return this.b;
    }

    public final char b() {
        return this.f42569c;
    }

    @Override // java.lang.Iterable
    /* renamed from: c */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.b, this.f42569c, this.d);
    }

    public boolean d() {
        return this.d > 0 ? Intrinsics.a((int) this.b, (int) this.f42569c) > 0 : Intrinsics.a((int) this.b, (int) this.f42569c) < 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharProgression) {
            if (d() && ((CharProgression) obj).d()) {
                return true;
            }
            CharProgression charProgression = (CharProgression) obj;
            return this.b == charProgression.b && this.f42569c == charProgression.f42569c && this.d == charProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (d()) {
            return -1;
        }
        return (((this.b * 31) + this.f42569c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.f42569c);
            sb.append(" step ");
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.f42569c);
            sb.append(" step ");
            i = -this.d;
        }
        sb.append(i);
        return sb.toString();
    }
}
