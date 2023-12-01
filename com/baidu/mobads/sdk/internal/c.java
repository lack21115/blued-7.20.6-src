package com.baidu.mobads.sdk.internal;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f9368a;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/c$a.class */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f9369a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f9368a == null) {
            synchronized (c.class) {
                try {
                    if (f9368a == null) {
                        f9368a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9368a;
    }

    public ao a(String str) {
        return new ao(str);
    }
}
