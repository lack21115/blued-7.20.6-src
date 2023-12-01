package com.tencent.tmsqmsp.sdk.g.i;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/i/b.class */
public class b implements com.tencent.tmsqmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    public a f39803a;

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        return this.f39803a.a(0, "");
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39803a = new a(context);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        return null;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean e() {
        return "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
    }
}
