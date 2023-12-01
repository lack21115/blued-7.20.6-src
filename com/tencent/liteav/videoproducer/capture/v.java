package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final float f36947a;

    private v(float f) {
        this.f36947a = f;
    }

    public static Runnable a(float f) {
        return new v(f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.getInstance().setPercentOfMaxZoomLevel(this.f36947a);
    }
}
