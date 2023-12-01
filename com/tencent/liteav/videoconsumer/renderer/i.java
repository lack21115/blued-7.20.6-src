package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/i.class */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f23137a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23138c;
    private final TakeSnapshotListener d;

    private i(ByteBuffer byteBuffer, int i, int i2, TakeSnapshotListener takeSnapshotListener) {
        this.f23137a = byteBuffer;
        this.b = i;
        this.f23138c = i2;
        this.d = takeSnapshotListener;
    }

    public static Runnable a(ByteBuffer byteBuffer, int i, int i2, TakeSnapshotListener takeSnapshotListener) {
        return new i(byteBuffer, i, i2, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f23137a, this.b, this.f23138c, this.d);
    }
}
