package kotlin.time;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/Duration.class */
public final class Duration implements Comparable<Duration> {
    public static final Companion a = new Companion(null);
    private static final long c = s(0);
    private static final long d;
    private static final long e;
    private final long b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/time/Duration$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.c;
        }
    }

    static {
        long d2;
        long d3;
        d2 = DurationKt.d(4611686018427387903L);
        d = d2;
        d3 = DurationKt.d(-4611686018427387903L);
        e = d3;
    }

    public static int a(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.a(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        int i2 = i;
        if (b(j)) {
            i2 = -i;
        }
        return i2;
    }

    public static final long a(long j) {
        long b;
        b = DurationKt.b(-t(j), ((int) j) & 1);
        return b;
    }

    public static final long a(long j, DurationUnit unit) {
        Intrinsics.e(unit, "unit");
        if (j == d) {
            return Long.MAX_VALUE;
        }
        if (j == e) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.a(t(j), w(j), unit);
    }

    private static final void a(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String a2 = StringsKt.a(String.valueOf(i2), i3, '0');
            int length = a2.length() - 1;
            int i4 = -1;
            if (length >= 0) {
                int i5 = length;
                while (true) {
                    i4 = i5;
                    int i6 = i4 - 1;
                    if (a2.charAt(i4) != '0') {
                        break;
                    } else if (i6 < 0) {
                        i4 = -1;
                        break;
                    } else {
                        i5 = i6;
                    }
                }
            }
            int i7 = i4 + 1;
            if (z || i7 >= 3) {
                sb.append((CharSequence) a2, 0, ((i7 + 2) / 3) * 3);
                Intrinsics.c(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) a2, 0, i7);
                Intrinsics.c(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static boolean a(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).a();
    }

    public static final boolean b(long j) {
        return j < 0;
    }

    public static final boolean b(long j, long j2) {
        return j == j2;
    }

    public static final boolean c(long j) {
        return j == d || j == e;
    }

    public static final boolean d(long j) {
        return !c(j);
    }

    public static final long e(long j) {
        long j2 = j;
        if (b(j)) {
            j2 = a(j);
        }
        return j2;
    }

    public static final int g(long j) {
        if (c(j)) {
            return 0;
        }
        return (int) (l(j) % 24);
    }

    public static final int h(long j) {
        if (c(j)) {
            return 0;
        }
        return (int) (m(j) % 60);
    }

    public static final int i(long j) {
        if (c(j)) {
            return 0;
        }
        return (int) (n(j) % 60);
    }

    public static final int j(long j) {
        long t;
        long c2;
        if (c(j)) {
            return 0;
        }
        if (v(j)) {
            c2 = DurationKt.c(t(j) % 1000);
            t = c2;
        } else {
            t = t(j) % 1000000000;
        }
        return (int) t;
    }

    public static final long k(long j) {
        return a(j, DurationUnit.DAYS);
    }

    public static final long l(long j) {
        return a(j, DurationUnit.HOURS);
    }

    public static final long m(long j) {
        return a(j, DurationUnit.MINUTES);
    }

    public static final long n(long j) {
        return a(j, DurationUnit.SECONDS);
    }

    public static final long o(long j) {
        return (v(j) && d(j)) ? t(j) : a(j, DurationUnit.MILLISECONDS);
    }

    @Deprecated
    public static final long p(long j) {
        return o(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
        if (r16 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010c, code lost:
        if (r13 != false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String q(long r9) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.Duration.q(long):java.lang.String");
    }

    public static int r(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static long s(long j) {
        if (DurationJvmKt.a()) {
            boolean z = true;
            if (u(j)) {
                long t = t(j);
                if (-4611686018426999999L > t || t >= 4611686018427000000L) {
                    z = false;
                }
                if (z) {
                    return j;
                }
                throw new AssertionError(t(j) + " ns is out of nanoseconds range");
            }
            long t2 = t(j);
            if (!(-4611686018427387903L <= t2 && t2 < 4611686018427387904L)) {
                throw new AssertionError(t(j) + " ms is out of milliseconds range");
            }
            long t3 = t(j);
            if (-4611686018426L <= t3 && t3 < 4611686018427L) {
                throw new AssertionError(t(j) + " ms is denormalized");
            }
            return j;
        }
        return j;
    }

    private static final long t(long j) {
        return j >> 1;
    }

    private static final boolean u(long j) {
        return (((int) j) & 1) == 0;
    }

    private static final boolean v(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final DurationUnit w(long j) {
        return u(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public final /* synthetic */ long a() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Duration duration) {
        return f(duration.a());
    }

    public boolean equals(Object obj) {
        return a(this.b, obj);
    }

    public int f(long j) {
        return a(this.b, j);
    }

    public int hashCode() {
        return r(this.b);
    }

    public String toString() {
        return q(this.b);
    }
}
