package com.anythink.core.common.k.a;

import android.view.View;
import com.anythink.core.common.k.a.f;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final f f6783a;
    private final Map<View, b> b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<View, d<b>> f6784c;
    private final f.b d;
    private f.d e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c() {
        /*
            r6 = this;
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r1 = r0
            r1.<init>()
            r7 = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r1 = r0
            r1.<init>()
            r8 = r0
            com.anythink.core.common.k.a.f$b r0 = new com.anythink.core.common.k.a.f$b
            r1 = r0
            r1.<init>()
            r9 = r0
            com.anythink.core.common.k.a.f r0 = new com.anythink.core.common.k.a.f
            r1 = r0
            r1.<init>()
            r10 = r0
            android.os.Handler r0 = new android.os.Handler
            r1 = r0
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.a.c.<init>():void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(int r7) {
        /*
            r6 = this;
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r1 = r0
            r1.<init>()
            r8 = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r1 = r0
            r1.<init>()
            r9 = r0
            com.anythink.core.common.k.a.f$b r0 = new com.anythink.core.common.k.a.f$b
            r1 = r0
            r1.<init>()
            r10 = r0
            com.anythink.core.common.k.a.f r0 = new com.anythink.core.common.k.a.f
            r1 = r0
            r2 = r7
            r1.<init>(r2)
            r11 = r0
            android.os.Handler r0 = new android.os.Handler
            r1 = r0
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.a.c.<init>(int):void");
    }

    private c(Map<View, b> map, Map<View, d<b>> map2, f.b bVar, f fVar) {
        this.b = map;
        this.f6784c = map2;
        this.d = bVar;
        this.f6783a = fVar;
        f.d dVar = new f.d() { // from class: com.anythink.core.common.k.a.c.1
            @Override // com.anythink.core.common.k.a.f.d
            public final void a(List<View> list) {
                for (View view : list) {
                    b bVar2 = (b) c.this.b.get(view);
                    if (bVar2 == null) {
                        c.this.a(view);
                    } else {
                        bVar2.recordImpression(view);
                        bVar2.setImpressionRecorded();
                    }
                }
            }
        };
        this.e = dVar;
        this.f6783a.a(dVar);
    }

    private void b(View view) {
        this.f6784c.remove(view);
    }

    @Deprecated
    private f.d c() {
        return this.e;
    }

    public final void a() {
        this.b.clear();
        this.f6784c.clear();
        this.f6783a.a();
    }

    public final void a(View view) {
        this.b.remove(view);
        b(view);
        this.f6783a.a(view);
    }

    public final void a(View view, b bVar) {
        if (this.b.get(view) == bVar) {
            return;
        }
        a(view);
        if (bVar.isImpressionRecorded()) {
            return;
        }
        this.b.put(view, bVar);
        f fVar = this.f6783a;
        int impressionMinPercentageViewed = bVar.getImpressionMinPercentageViewed();
        fVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bVar.getImpressionMinVisiblePx());
    }

    public final void b() {
        a();
        this.f6783a.b();
        this.e = null;
    }
}
