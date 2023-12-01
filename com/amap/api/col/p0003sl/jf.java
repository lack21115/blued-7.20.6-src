package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ia;
import com.amap.api.col.p0003sl.jh;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.jf  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jf.class */
public final class jf {

    /* renamed from: a  reason: collision with root package name */
    private Context f5206a;
    private ia b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5207c = true;
    private String d = "40C27E38DCAD404B5465362914090908";
    private na e = new na("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            ia a2 = new ia.a(str, str2, str).a(strArr).a(str3).a();
            if (context == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.f5206a = applicationContext;
            this.b = a2;
            this.f5207c = z;
            this.e.a(applicationContext, a2);
        } catch (hn e) {
        }
    }

    public final void a(String str, String str2) {
        List<ia> a2 = this.e.a(this.f5206a);
        jh jhVar = jh.a.f5209a;
        jh.a(this.f5206a, str, str2, a2, this.f5207c, this.b);
    }
}
