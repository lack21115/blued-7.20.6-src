package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ia;
import com.amap.api.col.p0003sl.jh;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.jf  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jf.class */
public final class jf {
    private Context a;
    private ia b;
    private boolean c = true;
    private String d = "40C27E38DCAD404B5465362914090908";
    private na e = new na("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            ia a = new ia.a(str, str2, str).a(strArr).a(str3).a();
            if (context == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.b = a;
            this.c = z;
            this.e.a(applicationContext, a);
        } catch (hn e) {
        }
    }

    public final void a(String str, String str2) {
        List<ia> a = this.e.a(this.a);
        jh jhVar = jh.a.a;
        jh.a(this.a, str, str2, a, this.c, this.b);
    }
}
