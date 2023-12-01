package com.tencent.qmsp.sdk.g.i;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.qmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/i/b.class */
public class b implements com.tencent.qmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    a f38654a;

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return this.f38654a.a(0, "");
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f38654a = new a(context);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        return null;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        return "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
    }
}
