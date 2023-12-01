package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/p.class */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36720a;
    private final SnapshotSourceType b;

    /* renamed from: c  reason: collision with root package name */
    private final TakeSnapshotListener f36721c;

    private p(j jVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        this.f36720a = jVar;
        this.b = snapshotSourceType;
        this.f36721c = takeSnapshotListener;
    }

    public static Runnable a(j jVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        return new p(jVar, snapshotSourceType, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36720a;
        SnapshotSourceType snapshotSourceType = this.b;
        final TakeSnapshotListener takeSnapshotListener = this.f36721c;
        String str = jVar.f36705a;
        LiteavLog.i(str, "takeSnapshot: sourceType = " + snapshotSourceType + ", listener = " + takeSnapshotListener);
        if (snapshotSourceType == SnapshotSourceType.STREAM) {
            if (jVar.f != null) {
                final VideoDecodeController videoDecodeController = jVar.f;
                videoDecodeController.a(new Runnable(videoDecodeController, takeSnapshotListener) { // from class: com.tencent.liteav.videoconsumer.decoder.ar

                    /* renamed from: a  reason: collision with root package name */
                    private final VideoDecodeController f36763a;
                    private final TakeSnapshotListener b;

                    {
                        this.f36763a = videoDecodeController;
                        this.b = takeSnapshotListener;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoDecodeController videoDecodeController2 = this.f36763a;
                        TakeSnapshotListener takeSnapshotListener2 = this.b;
                        LiteavLog.i(videoDecodeController2.f36734a, "takeSnapshot ".concat(String.valueOf(takeSnapshotListener2)));
                        videoDecodeController2.p.f36662a = takeSnapshotListener2;
                    }
                });
            }
        } else if (snapshotSourceType == SnapshotSourceType.VIEW) {
            if (jVar.i != null && jVar.d != null) {
                jVar.d.takeSnapshot(takeSnapshotListener);
            } else if (jVar.e != null) {
                jVar.e.takeSnapshot(takeSnapshotListener);
            } else {
                LiteavLog.w(jVar.f36705a, "takeSnapshot return null, no match render.");
                if (takeSnapshotListener != null) {
                    takeSnapshotListener.onComplete(null);
                }
            }
        }
    }
}
