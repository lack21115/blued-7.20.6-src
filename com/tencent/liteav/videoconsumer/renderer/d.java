package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36818a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36819c;

    private d(a aVar, int i, int i2) {
        this.f36818a = aVar;
        this.b = i;
        this.f36819c = i2;
    }

    public static Runnable a(a aVar, int i, int i2) {
        return new d(aVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f36818a;
        int i = this.b;
        int i2 = this.f36819c;
        aVar.d.f36340a = i;
        aVar.d.b = i2;
        if (aVar.f36813a != null) {
            aVar.f36813a.a(aVar.b, aVar.d.f36340a, aVar.d.b, false);
        }
    }
}
