package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/e.class */
public class e {
    final List<EfsJSONLog> B = new ArrayList();
    volatile boolean C;

    /* renamed from: a  reason: collision with root package name */
    private final EfsReporter f21816a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(final Context context, EfsReporter efsReporter) {
        this.f21816a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.C = !TextUtils.isEmpty(uMId);
        if (!this.C) {
            ImprintHandler.getImprintService(context).registImprintCallback(bh.g, new UMImprintChangeCallback() { // from class: com.efs.sdk.memoryinfo.e.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if (bh.g.equals(str)) {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put(UMCrash.KEY_HEADER_UMID, str2);
                            e.this.f21816a.addPublicParams(hashMap);
                            synchronized (e.class) {
                                e.b(e.this);
                            }
                            for (EfsJSONLog efsJSONLog : e.this.B) {
                                e.this.a(efsJSONLog);
                            }
                            String str3 = "send cache:" + e.this.B.size();
                            if (a.DEBUG) {
                                Log.d("MemoryCollect", str3);
                            }
                            e.this.B.clear();
                            ImprintHandler.getImprintService(context).unregistImprintCallback(bh.g, this);
                        }
                    } catch (Throwable th) {
                        f.a("umid ", th);
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, uMId);
        this.f21816a.addPublicParams(hashMap);
    }

    static /* synthetic */ boolean b(e eVar) {
        eVar.C = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(EfsJSONLog efsJSONLog) {
        try {
            this.f21816a.send(efsJSONLog);
        } catch (Throwable th) {
            f.a("send", th);
        }
    }
}
