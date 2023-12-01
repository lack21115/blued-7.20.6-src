package com.tencent.liteav.base.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected static a f22588a;
    private int b = 60;

    /* renamed from: c  reason: collision with root package name */
    private int f22589c = 70;
    private int d = 80;
    private int e = 50;
    private int f = 10;

    public static a a() {
        if (f22588a == null) {
            synchronized (a.class) {
                try {
                    if (f22588a == null) {
                        f22588a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f22588a;
    }

    public final long a(String str, String str2) {
        int i;
        if ("Video".equals(str)) {
            if ("SWToHWThreshold_CheckCount".equals(str2)) {
                i = this.f;
            } else if ("SWToHWThreshold_CPU".equals(str2)) {
                i = this.b;
            } else if ("SWToHWThreshold_CPU_MAX".equals(str2)) {
                i = this.d;
            } else if ("SWToHWThreshold_FPS".equals(str2)) {
                i = this.f22589c;
            } else if (!"SWToHWThreshold_FPS_MIN".equals(str2)) {
                return 0L;
            } else {
                i = this.e;
            }
            return i;
        }
        return 0L;
    }
}
