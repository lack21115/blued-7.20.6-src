package com.huawei.hms.hatool;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public k f22768a;
    public k b;

    /* renamed from: c  reason: collision with root package name */
    public k f22769c;
    public k d;

    public m(String str) {
    }

    public k a() {
        return this.f22769c;
    }

    public k a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        z.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(k kVar) {
        this.f22768a = kVar;
    }

    public k b() {
        return this.f22768a;
    }

    public void b(k kVar) {
        this.b = kVar;
    }

    public k c() {
        return this.b;
    }

    public k d() {
        return this.d;
    }
}
