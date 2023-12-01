package com.tencent.liteav.videobase.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f36576a = false;

    public abstract com.tencent.liteav.videobase.frame.d a(long j, com.tencent.liteav.videobase.frame.d dVar);

    public final void a() {
        if (this.f36576a) {
            b();
            this.f36576a = false;
        }
    }

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        if (this.f36576a) {
            return;
        }
        b(eVar);
        this.f36576a = true;
    }

    protected void b() {
    }

    protected void b(com.tencent.liteav.videobase.frame.e eVar) {
    }
}
