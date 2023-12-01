package com.ta.utdid2.device;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/device/a.class */
public class a {
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";

    /* renamed from: a  reason: collision with root package name */
    private long f21215a = 0;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f21215a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.f21215a = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f = str;
    }

    public String e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
    }

    public String getDeviceId() {
        return this.f;
    }

    public String getImsi() {
        return this.e;
    }
}
