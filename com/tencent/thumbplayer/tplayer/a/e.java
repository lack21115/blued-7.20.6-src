package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.thumbplayer.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/e.class */
public class e extends c {
    private boolean i = true;
    private boolean j = false;
    private d k = new d();
    private final Object l = new Object();
    private Future<?> m = null;
    private Runnable n = new Runnable() { // from class: com.tencent.thumbplayer.tplayer.a.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.i) {
                e.this.g();
                return;
            }
            TPLogUtil.i("TPLiveReporter", "Period Timer Exit because play done.");
            e.this.m.cancel(true);
            e.this.m = null;
        }
    };

    private void a(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> b = b(j, i, tPGeneralPlayFlowParams).b();
        a("reportLiveEndEvent", b);
        b("live_end", b);
        com.tencent.thumbplayer.common.a.b.a("live_end", b);
    }

    private void a(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.j) {
            h(new b.C1018b());
            this.j = false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.k.h;
        this.k.m += elapsedRealtime - j2;
        d();
        TPLogUtil.i("TPLiveReporter", "reportPlayerEndEvent playerStopTimeMs:" + j + " errorCode:" + i);
        a(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        a(j, i, tPGeneralPlayFlowParams);
    }

    private void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> b = b(tPGeneralPlayFlowParams, tPDynamicStatisticParams).b();
        a("reportLiveEndFlowEvent", b);
        b("live_flow", b);
        com.tencent.thumbplayer.common.a.b.a("live_flow", b);
    }

    private void a(com.tencent.thumbplayer.tplayer.a.b.a.a aVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        aVar.q(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        aVar.r(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        aVar.s(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        aVar.t(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        aVar.p(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private void a(com.tencent.thumbplayer.tplayer.a.b.a.d dVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        dVar.f(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        dVar.g(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        dVar.h(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        dVar.i(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        dVar.j(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        dVar.k(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        dVar.l(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        dVar.m(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        dVar.n(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        dVar.o(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        dVar.q(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        dVar.r(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        dVar.s(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        dVar.t(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private com.tencent.thumbplayer.tplayer.a.b.a.a b(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        com.tencent.thumbplayer.tplayer.a.b.a.a aVar = new com.tencent.thumbplayer.tplayer.a.b.a.a();
        this.k.i += j - this.k.g;
        aVar.c(this.k.i);
        aVar.o(i);
        a(aVar, tPGeneralPlayFlowParams);
        com.tencent.thumbplayer.tplayer.a.b.a aVar2 = this.k.f39365a;
        int i2 = this.g;
        this.g = i2 + 1;
        aVar2.a(i2);
        this.f.b(this.k.f39365a);
        aVar.a(this.k.f39365a);
        return aVar;
    }

    private com.tencent.thumbplayer.tplayer.a.b.a.d b(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        com.tencent.thumbplayer.tplayer.a.b.a.d dVar = new com.tencent.thumbplayer.tplayer.a.b.a.d();
        dVar.c(this.e.f39396a);
        dVar.d(this.e.b);
        dVar.e(this.e.f39397c);
        dVar.p(this.k.f);
        a(dVar, tPGeneralPlayFlowParams);
        com.tencent.thumbplayer.tplayer.a.b.a aVar = this.k.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar.a(i);
        this.f.b(this.k.f39365a);
        dVar.a(this.k.f39365a);
        return dVar;
    }

    private void c() {
        TPLogUtil.i("TPLiveReporter", "startPeriodReportTimer");
        synchronized (this.l) {
            if (this.m == null) {
                this.m = o.a().e().scheduleAtFixedRate(this.n, 0L, 60000L, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.o)) {
            TPLogUtil.e("TPLiveReporter", "onPrepareDone fail:params is not match");
            return;
        }
        b.o oVar = (b.o) aVar;
        long b = oVar.b() - this.e.f39397c;
        this.k.f = oVar.b();
        TPLogUtil.i("TPLiveReporter", "Live onPrepareDone timeMs:".concat(String.valueOf(b)));
        a(this.k);
        com.tencent.thumbplayer.tplayer.a.b.a aVar2 = this.k.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar2.a(i);
        this.f.b(this.k.f39365a);
        b(this.k);
        com.tencent.thumbplayer.tplayer.a.b.a.b bVar = new com.tencent.thumbplayer.tplayer.a.b.a.b();
        bVar.c(b);
        bVar.a(this.k.f39365a);
        Map<String, String> b2 = bVar.b();
        a("onPrepareDone", b2);
        b("live_first_load", b2);
        com.tencent.thumbplayer.common.a.b.a("live_first_load", b2);
    }

    private void c(b bVar) {
        ITPReportInfoGetter iTPReportInfoGetter = this.f39387a;
        if (iTPReportInfoGetter == null) {
            return;
        }
        Map<String, String> periodExtendReportInfo = iTPReportInfoGetter.getPeriodExtendReportInfo();
        if (periodExtendReportInfo == null) {
            TPLogUtil.e("TPLiveReporter", "fillPeriodExtReportInfoToCommonParams fail, period ExtendReportInfo is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a(periodExtendReportInfo, hashMap, hashMap2);
        bVar.f39365a.c(hashMap);
        bVar.f39365a.d(hashMap2);
    }

    private void d() {
        synchronized (this) {
            TPLogUtil.i("TPLiveReporter", "destroyPeriodReportTimer");
            synchronized (this.l) {
                if (this.m != null) {
                    this.m.cancel(true);
                    this.m = null;
                }
            }
        }
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.m)) {
            TPLogUtil.e("TPLiveReporter", "onPlayerStart fail:params is not match");
            return;
        }
        b.m mVar = (b.m) aVar;
        this.i = false;
        if (this.k.g == 0) {
            this.k.g = mVar.b();
        }
        this.k.h = mVar.b();
        TPLogUtil.i("TPLiveReporter", "Live onPlayerStart FirstStartTimeMs:" + this.k.g + " mPlayerStartOccurElapsedTimeMs:" + this.k.h);
        c();
    }

    private void e() {
        TPLogUtil.i("TPLiveReporter", "onAppForeground");
        a(this.k.f39365a.a());
    }

    private void e(b.a aVar) {
        if (this.i) {
            TPLogUtil.e("TPLiveReporter", "Player has been called End");
            return;
        }
        this.i = true;
        a(aVar.b(), 0, a(aVar), b(aVar));
        a(this.k.f39365a.a());
    }

    private void f() {
        TPLogUtil.i("TPLiveReporter", "onAppBackground");
        if (this.i) {
            return;
        }
        a("live_flow", b(b(), a(false)));
        a("live_end", b(SystemClock.elapsedRealtime(), 0, b()));
    }

    private void f(b.a aVar) {
        if (this.i) {
            TPLogUtil.e("TPLiveReporter", "Player has been called End");
            return;
        }
        this.i = true;
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPLiveReporter", "onPlayerError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        a(iVar.b(), iVar.e(), a(iVar), b(iVar));
        a(this.k.f39365a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TPLogUtil.i("TPLiveReporter", "periodReportEvent enter.");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.k.h;
        this.k.m += elapsedRealtime - j;
        this.k.h = SystemClock.elapsedRealtime();
        com.tencent.thumbplayer.tplayer.a.b.a.c cVar = new com.tencent.thumbplayer.tplayer.a.b.a.c();
        cVar.o(this.k.l);
        cVar.c(this.k.k);
        cVar.d(this.k.m);
        TPDynamicStatisticParams a2 = this.b.a(true);
        cVar.e(a2.mMaxVideoStreamBitrate);
        cVar.f(a2.mAvgVideoStreamBitrate);
        cVar.g(a2.mMinVideoStreamBitrate);
        cVar.h(a2.mMaxVideoDecodeCostTimeMs);
        cVar.i(a2.mAvgVideoDecodeCostTimeMs);
        cVar.j(a2.mMinVideoDecodeCostTimeMs);
        cVar.r(a2.mMaxVideoGopSize);
        cVar.q(a2.mAvgVideoGopSize);
        cVar.p(a2.mMinVideoGopSize);
        cVar.s(a2.mVideoDecodeFrameCount);
        cVar.t(a2.mVideoRenderFrameCount);
        cVar.k(a2.mVideoBufferedDurationMs);
        cVar.l(a2.mAudioBufferedDurationMs);
        c(this.k);
        com.tencent.thumbplayer.tplayer.a.b.a aVar = this.k.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar.a(i);
        this.f.b(this.k.f39365a);
        cVar.a(this.k.f39365a);
        Map<String, String> b = cVar.b();
        a("periodReportEvent", b);
        b("live_period_report", b);
        com.tencent.thumbplayer.common.a.b.a("live_period_report", b);
        this.k.l = 0;
        this.k.k = 0L;
        this.k.m = 0L;
        this.k.f39365a.c((Map<String, String>) null);
        this.k.f39365a.d((Map<String, String>) null);
    }

    private void g(b.a aVar) {
        if (!(aVar instanceof b.c)) {
            TPLogUtil.e("TPLiveReporter", "onBufferingStart fail:params is not match");
            return;
        }
        this.j = true;
        this.k.j = ((b.c) aVar).b();
        TPLogUtil.i("TPLiveReporter", "Live onBufferingStart timeMs:" + this.k.j);
        long j = this.k.j;
        long j2 = this.k.h;
        this.k.m += j - j2;
    }

    private void h(b.a aVar) {
        if (!(aVar instanceof b.C1018b)) {
            TPLogUtil.e("TPLiveReporter", "onBufferingEnd fail:params is not match");
            return;
        }
        this.j = false;
        long b = ((b.C1018b) aVar).b() - this.k.j;
        this.k.h = SystemClock.elapsedRealtime();
        TPLogUtil.i("TPLiveReporter", "Live onBufferingEnd bufferingCostTimeMs:".concat(String.valueOf(b)));
        if (b <= 1200) {
            return;
        }
        this.k.l++;
        this.k.k += b;
        this.k.j = 0L;
    }

    private void i(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPLiveReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d = ((b.e) aVar).d();
        TPLogUtil.i("TPLiveReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d)));
        this.k.b = d;
    }

    private void j(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPLiveReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d = dVar.d();
        String e = dVar.e();
        TPLogUtil.i("TPLiveReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d + " uIp:" + e);
        this.k.f39366c = d;
        this.k.d = e;
    }

    private void k(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPLiveReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d = ((b.f) aVar).d();
        TPLogUtil.i("TPLiveReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d)));
        this.k.e = d;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a() {
        super.a();
        d();
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(int i, b.a aVar) {
        if (i == 2) {
            c(aVar);
        } else if (i == 3) {
            d(aVar);
        } else if (i == 5) {
            e(aVar);
        } else if (i == 6) {
            f(aVar);
        } else if (i == 9) {
            g(aVar);
        } else if (i == 10) {
            h(aVar);
        } else if (i == 1001) {
            e();
        } else if (i == 1002) {
            f();
        } else {
            switch (i) {
                case 100:
                    i(aVar);
                    return;
                case 101:
                    j(aVar);
                    return;
                case 102:
                    k(aVar);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f.a(this.k.f39365a);
    }
}
