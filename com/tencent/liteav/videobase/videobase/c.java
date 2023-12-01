package com.tencent.liteav.videobase.videobase;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DisplayTarget f22980a;

    private c(DisplayTarget displayTarget) {
        this.f22980a = displayTarget;
    }

    public static Runnable a(DisplayTarget displayTarget) {
        return new c(displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        DisplayTarget.lambda$addVideoView$1(this.f22980a);
    }
}
