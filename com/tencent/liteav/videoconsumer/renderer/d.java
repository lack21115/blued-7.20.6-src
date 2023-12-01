package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23127a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23128c;

    private d(a aVar, int i, int i2) {
        this.f23127a = aVar;
        this.b = i;
        this.f23128c = i2;
    }

    public static Runnable a(a aVar, int i, int i2) {
        return new d(aVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f23127a;
        int i = this.b;
        int i2 = this.f23128c;
        aVar.d.f22649a = i;
        aVar.d.b = i2;
        if (aVar.f23122a != null) {
            aVar.f23122a.a(aVar.b, aVar.d.f22649a, aVar.d.b, false);
        }
    }
}
