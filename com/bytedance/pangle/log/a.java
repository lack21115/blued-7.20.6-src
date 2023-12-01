package com.bytedance.pangle.log;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/log/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f21436a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f21437c;
    private long d;
    private long e;

    private a(String str, String str2, String str3) {
        this.f21436a = str;
        this.b = str2;
        this.f21437c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.e = currentTimeMillis;
        this.d = currentTimeMillis;
        String str4 = this.f21436a;
        ZeusLogger.i(str4, this.b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a() {
        return System.currentTimeMillis() - this.d;
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.d;
        String str2 = this.f21436a;
        ZeusLogger.i(str2, this.b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f21437c, str, Long.valueOf(currentTimeMillis - j), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }
}
