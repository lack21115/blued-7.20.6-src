package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/m0.class */
public class m0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public l0 f25960a;

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        return this.f25960a.a(0, "");
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f25960a = new l0(context);
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        return null;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        return "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        return true;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
    }
}
