package com.tencent.liteav.videoconsumer.consumer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/s.class */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23034a;
    private final Object b;

    private s(j jVar, Object obj) {
        this.f23034a = jVar;
        this.b = obj;
    }

    public static Runnable a(j jVar, Object obj) {
        return new s(jVar, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23034a;
        Object obj = this.b;
        jVar.u = obj;
        if (jVar.f != null) {
            jVar.f.a(obj);
        }
    }
}
