package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.mobads.sdk.internal.bw;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/b.class */
public class b implements a {
    private static b d;
    private static DataReportResult e;

    /* renamed from: a  reason: collision with root package name */
    private w f4714a;
    private BugTrackMessageService b;

    /* renamed from: c  reason: collision with root package name */
    private DataReportService f4715c;

    private b(Context context, String str) {
        this.f4714a = null;
        this.b = null;
        this.f4715c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f4714a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f4715c = (DataReportService) this.f4714a.a(DataReportService.class, aaVar);
    }

    public static b a(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            try {
                if (d == null) {
                    d = new b(context, str);
                }
                bVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f4715c != null) {
            e = null;
            new Thread(new c(this, dataReportRequest)).start();
            int i = 300000;
            while (true) {
                int i2 = i;
                if (e != null || i2 < 0) {
                    break;
                }
                Thread.sleep(50L);
                i = i2 - 50;
            }
        }
        return e;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public boolean a(String str) {
        String str2;
        if (com.alipay.security.mobile.module.a.a.a(str)) {
            return false;
        }
        BugTrackMessageService bugTrackMessageService = this.b;
        boolean z = false;
        if (bugTrackMessageService != null) {
            try {
                str2 = bugTrackMessageService.logCollect(com.alipay.security.mobile.module.a.a.f(str));
            } catch (Throwable th) {
                str2 = null;
            }
            z = false;
            if (!com.alipay.security.mobile.module.a.a.a(str2)) {
                z = ((Boolean) new JSONObject(str2).get(bw.o)).booleanValue();
            }
        }
        return z;
    }
}
