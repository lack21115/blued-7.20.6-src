package com.tencent.liteav.videobase.utils;

import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private long f36652a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final InterfaceC0937a f36653c;
    private long d;
    private long e = (int) Math.max(1000L, TimeUnit.SECONDS.toMillis(1));
    private String f;

    /* renamed from: com.tencent.liteav.videobase.utils.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/a$a.class */
    public interface InterfaceC0937a {
    }

    public a(String str, InterfaceC0937a interfaceC0937a) {
        this.f = str;
        a();
        this.f36653c = interfaceC0937a;
    }

    public final void a() {
        this.f36652a = 0L;
        this.b = 0L;
        this.d = 0L;
    }
}
