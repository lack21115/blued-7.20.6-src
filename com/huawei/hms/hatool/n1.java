package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/n1.class */
public class n1 {

    /* renamed from: a  reason: collision with root package name */
    public k f22775a;
    public k b;

    /* renamed from: c  reason: collision with root package name */
    public Context f22776c;
    public String d;

    public n1(Context context) {
        if (context != null) {
            this.f22776c = context.getApplicationContext();
        }
        this.f22775a = new k();
        this.b = new k();
    }

    public n1 a(int i, String str) {
        k kVar;
        z.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        String str2 = str;
        if (!w0.b(str)) {
            str2 = "";
        }
        if (i == 0) {
            kVar = this.f22775a;
        } else if (i != 1) {
            z.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            kVar = this.b;
        }
        kVar.b(str2);
        return this;
    }

    public n1 a(String str) {
        z.c("hmsSdk", "Builder.setAppID is execute");
        this.d = str;
        return this;
    }

    @Deprecated
    public n1 a(boolean z) {
        z.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f22775a.j().a(z);
        this.b.j().a(z);
        return this;
    }

    public void a() {
        if (this.f22776c == null) {
            z.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        z.c("hmsSdk", "Builder.create() is execute.");
        k1 k1Var = new k1("_hms_config_tag");
        k1Var.b(new k(this.f22775a));
        k1Var.a(new k(this.b));
        i1.a().a(this.f22776c);
        j1.a().a(this.f22776c);
        p1.c().a(k1Var);
        i1.a().a(this.d);
    }

    @Deprecated
    public n1 b(boolean z) {
        z.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f22775a.j().b(z);
        this.b.j().b(z);
        return this;
    }

    @Deprecated
    public n1 c(boolean z) {
        z.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f22775a.j().c(z);
        this.b.j().c(z);
        return this;
    }
}
