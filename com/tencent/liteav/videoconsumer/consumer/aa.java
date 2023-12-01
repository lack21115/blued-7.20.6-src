package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/aa.class */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23000a;
    private final EncodedVideoFrame b;

    private aa(j jVar, EncodedVideoFrame encodedVideoFrame) {
        this.f23000a = jVar;
        this.b = encodedVideoFrame;
    }

    public static Runnable a(j jVar, EncodedVideoFrame encodedVideoFrame) {
        return new aa(jVar, encodedVideoFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23000a;
        EncodedVideoFrame encodedVideoFrame = this.b;
        if (jVar.p == j.a.STOPPED) {
            LiteavLog.i(jVar.f23014a, "appendNALPacket ignored packet. status is  stoped.");
            return;
        }
        if (!jVar.n) {
            jVar.n = true;
            jVar.f23015c.notifyEvent(h.b.EVT_VIDEO_CONSUMER_RECEIVE_FIRST_FRAME, null, new Object[0]);
        }
        jVar.f23015c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RECEIVED_FRAME, 0);
        jVar.o.a();
        if (jVar.f != null) {
            jVar.f.a(encodedVideoFrame);
        }
    }
}
