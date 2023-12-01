package com.tencent.rtmp.ui;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCloudVideoView f24999a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25000c;
    private final int d;
    private final int e;

    private d(TXCloudVideoView tXCloudVideoView, int i, int i2, int i3, int i4) {
        this.f24999a = tXCloudVideoView;
        this.b = i;
        this.f25000c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i, int i2, int i3, int i4) {
        return new d(tXCloudVideoView, i, i2, i3, i4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24999a.showFocusViewInternal(this.b, this.f25000c, this.d, this.e);
    }
}
