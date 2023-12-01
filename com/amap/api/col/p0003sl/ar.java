package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.aq;

/* renamed from: com.amap.api.col.3sl.ar  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ar.class */
public final class ar extends aq {

    /* renamed from: com.amap.api.col.3sl.ar$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ar$a.class */
    public static abstract class a implements aq.a {
        @Override // com.amap.api.col.p0003sl.aq.a
        public final boolean a(aq aqVar) {
            return a((ar) aqVar);
        }

        public abstract boolean a(ar arVar);

        @Override // com.amap.api.col.p0003sl.aq.a
        public final boolean b(aq aqVar) {
            return b((ar) aqVar);
        }

        public abstract boolean b(ar arVar);

        @Override // com.amap.api.col.p0003sl.aq.a
        public final void c(aq aqVar) {
            c((ar) aqVar);
        }

        public abstract void c(ar arVar);
    }

    public ar(Context context, a aVar) {
        super(context, aVar);
    }

    public final float j() {
        return (float) (((Math.atan2(g(), f()) - Math.atan2(e(), d())) * 180.0d) / 3.141592653589793d);
    }
}
