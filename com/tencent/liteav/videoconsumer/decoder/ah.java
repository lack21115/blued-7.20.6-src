package com.tencent.liteav.videoconsumer.decoder;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.aw;
import com.tencent.liteav.videoconsumer.decoder.ay;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ah.class */
final /* synthetic */ class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f23061a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23062c;

    private ah(VideoDecodeController videoDecodeController, long j, long j2) {
        this.f23061a = videoDecodeController;
        this.b = j;
        this.f23062c = j2;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, long j, long j2) {
        return new ah(videoDecodeController, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        VideoDecodeController videoDecodeController = this.f23061a;
        long j2 = this.b;
        long j3 = this.f23062c;
        if (videoDecodeController.j) {
            videoDecodeController.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_FRAME, 0);
            d dVar = videoDecodeController.f23044c;
            if (dVar.q > 0) {
                dVar.q--;
            }
            if (dVar.l == 0) {
                LiteavLog.i(dVar.f23088a, "decode first frame success");
            }
            dVar.l = j2;
            dVar.t = 0;
            videoDecodeController.m.decrementAndGet();
            aw awVar = videoDecodeController.d;
            awVar.e.a();
            aw.a aVar = awVar.f23078c;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j4 = elapsedRealtime - aVar.d;
            aVar.f.add(Long.valueOf(j4));
            aVar.d = elapsedRealtime;
            if (!aVar.e.isEmpty()) {
                aVar.e.removeFirst();
            }
            if (elapsedRealtime - aVar.b >= TimeUnit.SECONDS.toMillis(1L)) {
                aVar.b = elapsedRealtime;
                Iterator<Long> it = aVar.f.iterator();
                long j5 = 0;
                while (true) {
                    j = j5;
                    if (!it.hasNext()) {
                        break;
                    }
                    j5 = j + it.next().longValue();
                }
                aVar.f23080c = j / Math.max(aVar.f.size(), 1);
                aVar.f.clear();
            }
            aw.this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_COST, Long.valueOf(j4));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (aVar.f23079a == 0) {
                aVar.f23079a = elapsedRealtime2;
            }
            if (elapsedRealtime2 >= aVar.f23079a + TimeUnit.SECONDS.toMillis(1L)) {
                aVar.f23079a = elapsedRealtime2;
                long j6 = aVar.f23080c;
                if (aw.this.f == ay.a.HARDWARE) {
                    aw.this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_DECODE_TASK_COST, Long.valueOf(j6));
                } else {
                    aw.this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_SW_DECODE_TASK_COST, Long.valueOf(j6));
                }
            }
            aw.b bVar = awVar.d;
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            if (bVar.b == 0) {
                bVar.b = elapsedRealtime3;
            }
            if (bVar.f23081a == 0) {
                bVar.f23081a = elapsedRealtime3;
            }
            if (elapsedRealtime3 > bVar.f23081a + TimeUnit.SECONDS.toMillis(1L) && elapsedRealtime3 > bVar.b + TimeUnit.SECONDS.toMillis(2L)) {
                LiteavLog.e("DecodeSmoothStatistics", "frame interval [%d] > %d", Long.valueOf(elapsedRealtime3 - bVar.f23081a), Long.valueOf(TimeUnit.SECONDS.toMillis(1L)));
                bVar.b = elapsedRealtime3;
            }
            bVar.f23081a = elapsedRealtime3;
            awVar.b();
            if (!awVar.g) {
                awVar.g = true;
                awVar.b.notifyEvent(h.b.EVT_VIDEO_DECODE_FIRST_FRAME_DECODED, "first frame decoded", new Object[0]);
                LiteavLog.d(awVar.f23077a, "first frame decoded cost time: " + (SystemClock.elapsedRealtime() - awVar.h) + ", before decode first frame received: " + awVar.i);
            }
            PixelFrame a2 = videoDecodeController.n.a();
            if (a2 != null) {
                if (videoDecodeController.i == null || !videoDecodeController.k()) {
                    a2.release();
                    return;
                }
                if (a2.getGLContext() == null) {
                    a2.setGLContext(videoDecodeController.i.d());
                }
                videoDecodeController.p.a(a2.getWidth(), a2.getHeight());
                videoDecodeController.p.a(a2);
                if (videoDecodeController.g != null) {
                    videoDecodeController.g.onDecodeFrame(a2, j3);
                }
                a2.release();
            }
        }
    }
}
