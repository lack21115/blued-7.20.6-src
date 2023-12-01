package com.tencent.liteav.videobase.videobase;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DisplayTarget f22981a;

    private d(DisplayTarget displayTarget) {
        this.f22981a = displayTarget;
    }

    public static Runnable a(DisplayTarget displayTarget) {
        return new d(displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        DisplayTarget.lambda$removeVideoView$2(this.f22981a);
    }
}
