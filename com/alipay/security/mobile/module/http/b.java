package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/b.class */
public class b implements a {
    private static b d;
    private static DataReportResult e;
    private w a;
    private BugTrackMessageService b;
    private DataReportService c;

    private b(Context context, String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.c = (DataReportService) this.a.a(DataReportService.class, aaVar);
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
        if (this.c != null) {
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
                z = ((Boolean) new JSONObject(str2).get("success")).booleanValue();
            }
        }
        return z;
    }
}
