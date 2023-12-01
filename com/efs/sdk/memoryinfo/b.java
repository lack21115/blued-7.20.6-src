package com.efs.sdk.memoryinfo;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/b.class */
final class b {

    /* renamed from: a  reason: collision with root package name */
    final EfsReporter f21813a;
    boolean b = false;
    final Context mContext;

    public b(Context context, EfsReporter efsReporter) {
        this.mContext = context.getApplicationContext();
        this.f21813a = efsReporter;
    }

    static /* synthetic */ void a(b bVar, e eVar, String str) {
        c cVar = new c(bVar.mContext);
        EfsJSONLog efsJSONLog = new EfsJSONLog("memperf");
        efsJSONLog.put("w_pgid", str);
        efsJSONLog.put("crver", "0.0.2.umeng");
        efsJSONLog.put("k_st", cVar.bg);
        efsJSONLog.put("w_url", cVar.activity);
        efsJSONLog.put("wl_tpss", Long.valueOf(cVar.n));
        efsJSONLog.put("wl_jpss", Long.valueOf(cVar.o));
        efsJSONLog.put("wl_npss", Long.valueOf(cVar.p));
        efsJSONLog.put("wl_heap", Long.valueOf(cVar.q));
        efsJSONLog.put("wf_heap_used_rate", Float.valueOf(cVar.r));
        efsJSONLog.put("wl_graphics", Long.valueOf(cVar.s));
        efsJSONLog.put("wl_vmsize", Long.valueOf(cVar.t));
        synchronized (e.class) {
            try {
                if (eVar.C) {
                    eVar.a(efsJSONLog);
                } else {
                    eVar.B.add(efsJSONLog);
                }
            } finally {
            }
        }
    }
}
