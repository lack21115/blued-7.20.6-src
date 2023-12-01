package com.anythink.core.common.e;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/a.class */
public class a {
    public Context a;
    public com.anythink.core.common.j b;
    public String c;
    public String d;
    public int e;
    public long f;
    public long g;
    public long h;
    public List<ai> i;
    public List<ai> j;
    public List<ai> k;
    public String l;
    public boolean m;
    public com.anythink.core.c.d n;
    public String o;
    public String p;
    public Map<String, Object> q;
    public JSONObject r;
    public e s;
    public ai t;
    public int u = 2;
    public double v;
    public al w;
    public Boolean x;

    private a d(List<ai> list) {
        a aVar = new a();
        aVar.a = this.a;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.g = this.g;
        aVar.j = this.j;
        aVar.n = this.n;
        long j = this.f;
        if (j < 0) {
            aVar.f = 10000L;
        } else {
            aVar.f = j;
        }
        aVar.m = this.m;
        aVar.o = this.o;
        aVar.p = this.p;
        aVar.i = list;
        aVar.q = this.q;
        aVar.h = this.h;
        aVar.b = this.b;
        aVar.s = this.s;
        aVar.u = this.u;
        aVar.t = this.t;
        aVar.v = this.v;
        return aVar;
    }

    public final a a(List<ai> list) {
        return d(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fa A[Catch: all -> 0x01dc, TRY_ENTER, TryCatch #0 {all -> 0x01dc, blocks: (B:11:0x00b1, B:17:0x00d2, B:25:0x00fa, B:27:0x011f, B:29:0x0129, B:31:0x0140, B:33:0x015d, B:35:0x0165, B:37:0x0179, B:39:0x018b, B:41:0x0191, B:42:0x01a4, B:44:0x01ac, B:46:0x01b7, B:48:0x01bd, B:50:0x01c7, B:24:0x00ef, B:21:0x00e2), top: B:62:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0140 A[Catch: all -> 0x01dc, TryCatch #0 {all -> 0x01dc, blocks: (B:11:0x00b1, B:17:0x00d2, B:25:0x00fa, B:27:0x011f, B:29:0x0129, B:31:0x0140, B:33:0x015d, B:35:0x0165, B:37:0x0179, B:39:0x018b, B:41:0x0191, B:42:0x01a4, B:44:0x01ac, B:46:0x01b7, B:48:0x01bd, B:50:0x01c7, B:24:0x00ef, B:21:0x00e2), top: B:62:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.core.common.e.a a(java.util.List<com.anythink.core.common.e.ai> r7, java.util.List<com.anythink.core.common.e.ai> r8, java.lang.Boolean r9) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.a.a(java.util.List, java.util.List, java.lang.Boolean):com.anythink.core.common.e.a");
    }

    public final a b(List<ai> list) {
        a d = d(list);
        d.o = this.o;
        d.g = this.g;
        return d;
    }

    public final a c(List<ai> list) {
        a d = d(list);
        d.p = this.p;
        return d;
    }
}
