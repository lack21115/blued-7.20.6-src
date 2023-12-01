package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/KotlinVersion.class */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final Companion a = new Companion(null);
    public static final KotlinVersion b = KotlinVersionCurrentValue.a();
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/KotlinVersion$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = a(i, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a(int r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 1
            r9 = r0
            r0 = r5
            if (r0 < 0) goto L14
            r0 = r5
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L14
            r0 = 1
            r8 = r0
            goto L17
        L14:
            r0 = 0
            r8 = r0
        L17:
            r0 = r8
            if (r0 == 0) goto L55
            r0 = r6
            if (r0 < 0) goto L2d
            r0 = r6
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L2d
            r0 = 1
            r8 = r0
            goto L30
        L2d:
            r0 = 0
            r8 = r0
        L30:
            r0 = r8
            if (r0 == 0) goto L55
            r0 = r7
            if (r0 < 0) goto L46
            r0 = r7
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L46
            r0 = 1
            r8 = r0
            goto L49
        L46:
            r0 = 0
            r8 = r0
        L49:
            r0 = r8
            if (r0 == 0) goto L55
            r0 = r9
            r8 = r0
            goto L58
        L55:
            r0 = 0
            r8 = r0
        L58:
            r0 = r8
            if (r0 == 0) goto L69
            r0 = r5
            r1 = 16
            int r0 = r0 << r1
            r1 = r6
            r2 = 8
            int r1 = r1 << r2
            int r0 = r0 + r1
            r1 = r7
            int r0 = r0 + r1
            return r0
        L69:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "Version components are out of range: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = 46
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = 46
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.KotlinVersion.a(int, int, int):int");
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(KotlinVersion other) {
        Intrinsics.e(other, "other");
        return this.f - other.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.f == kotlinVersion.f;
    }

    public int hashCode() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append('.');
        sb.append(this.d);
        sb.append('.');
        sb.append(this.e);
        return sb.toString();
    }
}
