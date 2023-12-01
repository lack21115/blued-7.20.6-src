package com.tencent.qimei.o;

import android.content.Context;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/t.class */
public class t implements IAsyncQimeiListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f24705a;

    public t(u uVar) {
        this.f24705a = uVar;
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        String str;
        Context context;
        String str2;
        String str3;
        com.tencent.qimei.g.b a2 = com.tencent.qimei.g.b.a();
        str = this.f24705a.g;
        a2.a(str);
        com.tencent.qimei.g.b a3 = com.tencent.qimei.g.b.a();
        context = this.f24705a.h;
        a3.b(context);
        com.tencent.qimei.m.b a4 = com.tencent.qimei.m.b.a();
        str2 = this.f24705a.g;
        a4.a(str2);
        str3 = this.f24705a.g;
        com.tencent.qimei.q.a a5 = com.tencent.qimei.q.a.a(str3);
        if (a5.a()) {
            int i = a5.e ? 2 : a5.d ? 1 : 0;
            com.tencent.qimei.k.a.b(com.tencent.qimei.q.a.f24712a, "clone status: ByTime %b, ByAID %b", Boolean.valueOf(a5.d), Boolean.valueOf(a5.e));
            String str4 = a5.f24713c;
            if (a5.f == null) {
                a5.f = new Qimei();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("o16", a5.f.getQimei16());
            hashMap.put("o36", a5.f.getQimei36());
            com.tencent.qimei.u.a aVar = new com.tencent.qimei.u.a(a5.f24713c);
            hashMap.put("n16", aVar.N());
            hashMap.put("n36", aVar.H());
            com.tencent.qimei.k.a.b("CloneDetect", "克隆事件上报: appKey: %s，上报参数： %s", str4, hashMap.toString());
            com.tencent.qimei.n.c a6 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_CLONE_CACHE_Q16.K, hashMap.get("o16")).a(com.tencent.qimei.n.e.REPORT_CLONE_CACHE_Q36.K, hashMap.get("o36")).a(com.tencent.qimei.n.e.REPORT_CLONE_CACHE_NEW_Q16.K, hashMap.get("n16")).a(com.tencent.qimei.n.e.REPORT_CLONE_CACHE_NEW_Q36.K, hashMap.get("n36")).a(com.tencent.qimei.n.e.REPORT_CLONE_DETECT_TYPE.K, Integer.valueOf(i));
            a6.f24665a = str4;
            a6.f24666c = "/report";
            a6.a("v7");
            com.tencent.qimei.k.a.b("CloneDetect", "%s可能被克隆，检测方式：%d", com.tencent.qimei.c.a.d(), Integer.valueOf(i));
        }
    }
}
