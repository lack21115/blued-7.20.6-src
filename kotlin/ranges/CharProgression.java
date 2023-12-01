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
    public static final Companion a = new Companion(null);
    private final char b;
    private final char c;
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

    public CharProgression(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.b = c;
        this.c = (char) ProgressionUtilKt.a((int) c, (int) c2, i);
        this.d = i;
    }

    public final char a() {
        return this.b;
    }

    public final char b() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* renamed from: c */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.b, this.c, this.d);
    }

    public boolean d() {
        return this.d > 0 ? Intrinsics.a((int) this.b, (int) this.c) > 0 : Intrinsics.a((int) this.b, (int) this.c) < 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharProgression) {
            if (d() && ((CharProgression) obj).d()) {
                return true;
            }
            CharProgression charProgression = (CharProgression) obj;
            return this.b == charProgression.b && this.c == charProgression.c && this.d == charProgression.d;
        }
        return false;
    }

    public int hashCode() {
        if (d()) {
            return -1;
        }
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.c);
            sb.append(" step ");
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.c);
            sb.append(" step ");
            i = -this.d;
        }
        sb.append(i);
        return sb.toString();
    }
}
