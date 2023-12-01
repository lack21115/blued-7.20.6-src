package com.tencent.rtmp.ui;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCloudVideoView f24998a;

    private c(TXCloudVideoView tXCloudVideoView) {
        this.f24998a = tXCloudVideoView;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView) {
        return new c(tXCloudVideoView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24998a.hideIndicatorView();
    }
}
