package com.tencent.liteav.videobase.utils;

import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private long f22961a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final InterfaceC0767a f22962c;
    private long d;
    private long e = (int) Math.max(1000L, TimeUnit.SECONDS.toMillis(1));
    private String f;

    /* renamed from: com.tencent.liteav.videobase.utils.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/a$a.class */
    public interface InterfaceC0767a {
    }

    public a(String str, InterfaceC0767a interfaceC0767a) {
        this.f = str;
        a();
        this.f22962c = interfaceC0767a;
    }

    public final void a() {
        this.f22961a = 0L;
        this.b = 0L;
        this.d = 0L;
    }
}
