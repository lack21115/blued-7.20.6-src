package com.baidu.mobads.sdk.internal;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f6528a;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/c$a.class */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6529a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f6528a == null) {
            synchronized (c.class) {
                try {
                    if (f6528a == null) {
                        f6528a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6528a;
    }

    public ao a(String str) {
        return new ao(str);
    }
}
