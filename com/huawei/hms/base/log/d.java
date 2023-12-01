package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/base/log/d.class */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final HMSExtLogger f9007a;
    public b b;

    public d(HMSExtLogger hMSExtLogger) {
        this.f9007a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f9007a;
        if (hMSExtLogger != null) {
            if (i == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
