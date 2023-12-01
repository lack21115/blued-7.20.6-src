package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/m.class */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f36834a;
    private final DisplayTarget b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36835c;

    private m(g gVar, DisplayTarget displayTarget, boolean z) {
        this.f36834a = gVar;
        this.b = displayTarget;
        this.f36835c = z;
    }

    public static Runnable a(g gVar, DisplayTarget displayTarget, boolean z) {
        return new m(gVar, displayTarget, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f36834a, this.b, this.f36835c);
    }
}
