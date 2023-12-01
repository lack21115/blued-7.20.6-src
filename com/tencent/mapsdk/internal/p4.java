package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p4.class */
public interface p4 extends i5 {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p4$a.class */
    public enum a {
        LEFT(0),
        RIGHT(1),
        BOTTOM(2),
        TOP(3);
        
        public int b;

        a(int i) {
            this.b = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
            if (r3 >= 4) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final com.tencent.mapsdk.internal.p4.a a(int r3) {
            /*
                r0 = r3
                if (r0 < 0) goto Lf
                com.tencent.mapsdk.internal.p4$a[] r0 = values()
                r0 = r3
                r4 = r0
                r0 = r3
                r1 = 4
                if (r0 < r1) goto L11
            Lf:
                r0 = 0
                r4 = r0
            L11:
                com.tencent.mapsdk.internal.p4$a[] r0 = values()
                r1 = r4
                r0 = r0[r1]
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.p4.a.a(int):com.tencent.mapsdk.internal.p4$a");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p4$b.class */
    public enum b {
        LEFT_BOTTOM(0),
        CENTER_BOTTOM(4),
        RIGHT_BOTTOM(1),
        LEFT_TOP(3),
        CENTER_TOP(5),
        RIGHT_TOP(2);
        
        public final int b;

        b(int i2) {
            this.b = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
            if (r3 >= 6) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.tencent.mapsdk.internal.p4.b a(int r3) {
            /*
                r0 = 0
                r5 = r0
                r0 = r3
                if (r0 < 0) goto L12
                com.tencent.mapsdk.internal.p4$b[] r0 = values()
                r0 = r3
                r4 = r0
                r0 = r3
                r1 = 6
                if (r0 < r1) goto L14
            L12:
                r0 = 0
                r4 = r0
            L14:
                com.tencent.mapsdk.internal.p4$b r0 = com.tencent.mapsdk.internal.p4.b.LEFT_BOTTOM
                r6 = r0
                com.tencent.mapsdk.internal.p4$b[] r0 = values()
                r7 = r0
                r0 = r5
                r3 = r0
            L1f:
                r0 = r3
                r1 = 6
                if (r0 >= r1) goto L3e
                r0 = r7
                r1 = r3
                r0 = r0[r1]
                r8 = r0
                r0 = r8
                int r0 = r0.b
                r1 = r4
                if (r0 != r1) goto L37
                r0 = r8
                return r0
            L37:
                r0 = r3
                r1 = 1
                int r0 = r0 + r1
                r3 = r0
                goto L1f
            L3e:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.p4.b.a(int):com.tencent.mapsdk.internal.p4$b");
        }
    }

    void a();

    void a(b bVar);

    boolean a(ViewGroup viewGroup, Bundle bundle);

    Rect d();

    b getPosition();
}
