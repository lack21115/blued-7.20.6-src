package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.tplayer.a.m;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/n.class */
public class n extends c {
    private boolean i = true;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private m m = new m();

    private void a(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> b = b(j, i, tPGeneralPlayFlowParams).b();
        a("reportVodEndEvent", b);
        b("vod_end", b);
        com.tencent.thumbplayer.common.a.b.a("vod_end", b);
    }

    private void a(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.k) {
            k(new b.C1018b());
            this.k = false;
        }
        if (this.j) {
            i(new b.q());
            this.j = false;
        }
        if (this.l) {
            if (this.m.j > 0) {
                this.m.k += SystemClock.elapsedRealtime() - this.m.j;
                this.m.j = 0L;
            }
            this.l = false;
        }
        TPLogUtil.i("TPVodReporter", "reportPlayerEndEvent playerStopTimeMs:" + j + " errorCode:" + i);
        a(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        a(j, i, tPGeneralPlayFlowParams);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(long j, long j2, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void a(TPDrmInfo tPDrmInfo) {
        Map<String, String> b = b(tPDrmInfo).b();
        a("reportPlayerDrmInfoEvent", b);
        b("vod_drm_authentication", b);
        com.tencent.thumbplayer.common.a.b.a("vod_drm_authentication", b);
    }

    private void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> b = b(tPGeneralPlayFlowParams, tPDynamicStatisticParams).b();
        a("reportVodEndFlowEvent", b);
        b("vod_flow", b);
        com.tencent.thumbplayer.common.a.b.a("vod_flow", b);
    }

    private void a(com.tencent.thumbplayer.tplayer.a.b.b.c cVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        cVar.t(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        cVar.u(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        cVar.v(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        cVar.w(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        cVar.s(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private void a(com.tencent.thumbplayer.tplayer.a.b.b.e eVar, TPDynamicStatisticParams tPDynamicStatisticParams) {
        eVar.u(tPDynamicStatisticParams.mMaxVideoStreamBitrate);
        eVar.v(tPDynamicStatisticParams.mAvgVideoStreamBitrate);
        eVar.w(tPDynamicStatisticParams.mMinVideoStreamBitrate);
        eVar.x(tPDynamicStatisticParams.mMaxVideoDecodeCostTimeMs);
        eVar.y(tPDynamicStatisticParams.mAvgVideoDecodeCostTimeMs);
        eVar.z(tPDynamicStatisticParams.mMinVideoDecodeCostTimeMs);
        eVar.o(tPDynamicStatisticParams.mVideoDecodeFrameCount);
        eVar.p(tPDynamicStatisticParams.mVideoRenderFrameCount);
    }

    private void a(com.tencent.thumbplayer.tplayer.a.b.b.e eVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        eVar.f(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        eVar.g(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        eVar.h(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        eVar.i(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        eVar.j(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        eVar.k(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        eVar.l(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        eVar.m(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        eVar.n(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        eVar.o(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        eVar.q(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        eVar.r(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        eVar.s(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        eVar.t(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private com.tencent.thumbplayer.tplayer.a.b.b.b b(TPDrmInfo tPDrmInfo) {
        com.tencent.thumbplayer.tplayer.a.b.b.b bVar = new com.tencent.thumbplayer.tplayer.a.b.b.b();
        bVar.n(tPDrmInfo.drmAbility);
        bVar.q(tPDrmInfo.drmSupportSecureDecoder);
        bVar.r(tPDrmInfo.drmSupportSecureDecrypt);
        bVar.p(tPDrmInfo.drmSecureLevel);
        bVar.q(tPDrmInfo.drmComponentName);
        bVar.o(tPDrmInfo.drmType);
        bVar.c(tPDrmInfo.drmPrepareStartTimeMs);
        bVar.d(tPDrmInfo.drmPrepareEndTimeMs);
        bVar.e(tPDrmInfo.drmOpenSessionStartTimeMs);
        bVar.f(tPDrmInfo.drmOpenSessionEndTimeMs);
        bVar.g(tPDrmInfo.drmGetProvisionReqStartTimeMs);
        bVar.h(tPDrmInfo.drmGetProvisionReqEndTimeMs);
        bVar.i(tPDrmInfo.drmSendProvisionReqTimeMs);
        bVar.j(tPDrmInfo.drmRecvProvisionRespTimeMs);
        bVar.k(tPDrmInfo.drmProvideProvisionRespStartTimeMs);
        bVar.l(tPDrmInfo.drmProvideProvisionRespEndTimeMs);
        bVar.m(tPDrmInfo.drmGetKeyReqStartTimeMs);
        bVar.n(tPDrmInfo.drmGetKeyReqEndTimeMs);
        bVar.o(tPDrmInfo.drmSendKeyReqTimeMs);
        bVar.p(tPDrmInfo.drmRecvKeyRespTimeMs);
        bVar.q(tPDrmInfo.drmProvideKeyRespStartTimeMs);
        bVar.r(tPDrmInfo.drmProvideKeyRespEndTimeMs);
        this.f.b(this.m.f39365a);
        com.tencent.thumbplayer.tplayer.a.b.a aVar = this.m.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar.a(i);
        bVar.a(this.m.f39365a);
        return bVar;
    }

    private com.tencent.thumbplayer.tplayer.a.b.b.c b(long j, int i, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        com.tencent.thumbplayer.tplayer.a.b.b.c cVar = new com.tencent.thumbplayer.tplayer.a.b.b.c();
        m mVar = this.m;
        mVar.i = j - mVar.g;
        cVar.c(this.m.i);
        cVar.o(i);
        cVar.p(this.m.m);
        cVar.q(this.m.n);
        cVar.d(this.m.o);
        cVar.r(this.m.q);
        cVar.e(this.m.r);
        a(cVar, tPGeneralPlayFlowParams);
        com.tencent.thumbplayer.tplayer.a.b.a aVar = this.m.f39365a;
        int i2 = this.g;
        this.g = i2 + 1;
        aVar.a(i2);
        this.f.b(this.m.f39365a);
        cVar.a(this.m.f39365a);
        return cVar;
    }

    private com.tencent.thumbplayer.tplayer.a.b.b.e b(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        com.tencent.thumbplayer.tplayer.a.b.b.e eVar = new com.tencent.thumbplayer.tplayer.a.b.b.e();
        eVar.c(this.e.f39396a);
        eVar.d(this.e.b);
        eVar.e(this.e.f39397c);
        eVar.p(this.m.f);
        a(eVar, tPGeneralPlayFlowParams);
        a(eVar, tPDynamicStatisticParams);
        this.f.b(this.m.f39365a);
        com.tencent.thumbplayer.tplayer.a.b.a aVar = this.m.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar.a(i);
        eVar.a(this.m.f39365a);
        return eVar;
    }

    private void c() {
        TPLogUtil.i("TPVodReporter", "onAppForeground");
        a(this.m.f39365a.a());
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.o)) {
            TPLogUtil.e("TPVodReporter", "onPrepareDone fail:params is not match");
            return;
        }
        b.o oVar = (b.o) aVar;
        long b = oVar.b() - this.e.f39397c;
        this.m.f = oVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPrepareDone timeMs:".concat(String.valueOf(b)));
        a(this.m);
        com.tencent.thumbplayer.tplayer.a.b.a aVar2 = this.m.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar2.a(i);
        this.f.b(this.m.f39365a);
        b(this.m);
        com.tencent.thumbplayer.tplayer.a.b.b.d dVar = new com.tencent.thumbplayer.tplayer.a.b.b.d();
        dVar.c(b);
        dVar.a(this.m.f39365a);
        Map<String, String> b2 = dVar.b();
        a("onPrepareDone", b2);
        b("vod_first_load", b2);
        com.tencent.thumbplayer.common.a.b.a("vod_first_load", b2);
    }

    private void d() {
        TPLogUtil.i("TPVodReporter", "onAppBackground");
        if (this.i) {
            return;
        }
        a("vod_flow", b(b(), a(false)));
        a("vod_end", b(SystemClock.elapsedRealtime(), 0, b()));
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.m)) {
            TPLogUtil.e("TPVodReporter", "onPlayerStart fail:params is not match");
            return;
        }
        b.m mVar = (b.m) aVar;
        this.i = false;
        this.l = false;
        if (this.m.g == 0) {
            this.m.g = mVar.b();
        }
        this.m.h = mVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPlayerStart timeMs:" + this.m.h);
        if (this.m.j > 0) {
            this.m.k += mVar.b() - this.m.j;
            this.m.j = 0L;
        }
    }

    private void e(b.a aVar) {
        if (!(aVar instanceof b.j)) {
            TPLogUtil.e("TPVodReporter", "onPlayerPause fail:params is not match");
            return;
        }
        b.j jVar = (b.j) aVar;
        if (this.l) {
            TPLogUtil.e("TPVodReporter", "onPlayerPause has been called");
            return;
        }
        this.l = true;
        this.m.j = jVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPlayerPause timeMs:" + this.m.j);
    }

    private void f(b.a aVar) {
        if (this.i) {
            TPLogUtil.e("TPVodReporter", "Player has been called End");
            return;
        }
        this.i = true;
        a(aVar.b(), 0, a(aVar), b(aVar));
        a(this.m.f39365a.a());
    }

    private void g(b.a aVar) {
        if (this.i) {
            TPLogUtil.e("TPVodReporter", "Player has been called End");
            return;
        }
        this.i = true;
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPVodReporter", "onPlayerError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        a(iVar.b(), iVar.e(), a(iVar), b(iVar));
        a(this.m.f39365a.a());
    }

    private void h(b.a aVar) {
        if (!(aVar instanceof b.r)) {
            TPLogUtil.e("TPVodReporter", "onSeekStart fail:params is not match");
            return;
        }
        b.r rVar = (b.r) aVar;
        if (this.k) {
            k(new b.C1018b());
        }
        if (this.j) {
            i(new b.q());
        }
        this.j = true;
        this.m.l = rVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onSeekStart timeMs:" + this.m.l);
    }

    private void i(b.a aVar) {
        m mVar;
        if (!(aVar instanceof b.q)) {
            TPLogUtil.e("TPVodReporter", "onSeekEnd fail:params is not match");
            return;
        }
        this.j = false;
        long b = ((b.q) aVar).b() - this.m.l;
        if (b > 1200) {
            this.m.n++;
            this.m.o = (int) (mVar.o + b);
        }
        this.m.m++;
        TPLogUtil.i("TPVodReporter", "Vod onSeekEnd seekCostTimeMs:" + b + " mSeekTotalCount:" + this.m.m + " mSeekBufferingTotalCount:" + this.m.n + " mSeekBufferingTotalDurationMs:" + this.m.o);
    }

    private void j(b.a aVar) {
        if (!(aVar instanceof b.c)) {
            TPLogUtil.e("TPVodReporter", "onBufferingStart fail:params is not match");
            return;
        }
        b.c cVar = (b.c) aVar;
        this.k = true;
        if (this.j) {
            return;
        }
        this.m.p = cVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onBufferingStart timeMs:" + this.m.p);
    }

    private void k(b.a aVar) {
        m mVar;
        if (!(aVar instanceof b.C1018b)) {
            TPLogUtil.e("TPVodReporter", "onBufferingEnd fail:params is not match");
            return;
        }
        b.C1018b c1018b = (b.C1018b) aVar;
        this.k = false;
        if (this.j) {
            return;
        }
        long b = c1018b.b() - this.m.p;
        TPLogUtil.i("TPVodReporter", "Vod onBufferingEnd bufferingCostTimeMs:".concat(String.valueOf(b)));
        if (b <= 1200) {
            return;
        }
        this.m.q++;
        this.m.r = (int) (mVar.r + b);
        com.tencent.thumbplayer.tplayer.a.b.b.a aVar2 = new com.tencent.thumbplayer.tplayer.a.b.b.a();
        aVar2.b(this.m.s);
        aVar2.c(b);
        this.f.b(this.m.f39365a);
        com.tencent.thumbplayer.tplayer.a.b.a aVar3 = this.m.f39365a;
        int i = this.g;
        this.g = i + 1;
        aVar3.a(i);
        aVar2.a(this.m.f39365a);
        Map<String, String> b2 = aVar2.b();
        a("onBufferingEnd", b2);
        b("vod_second_buffering", b2);
        com.tencent.thumbplayer.common.a.b.a("vod_second_buffering", b2);
    }

    private void l(b.a aVar) {
        if (!(aVar instanceof b.v)) {
            TPLogUtil.e("TPVodReporter", "onSetPlaySpeed fail:params is not match");
            return;
        }
        this.m.s = ((b.v) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onSetPlaySpeed mPlaySpeed:" + this.m.s);
    }

    private void m(b.a aVar) {
        if (!(aVar instanceof b.t)) {
            TPLogUtil.e("TPVodReporter", "onSelectTrackStart fail:params is not match");
            return;
        }
        b.t tVar = (b.t) aVar;
        int d = tVar.d();
        long e = tVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onSelectTrackStart trackId:" + d + " trackUniqueIndex:" + e);
        if (this.m.t.containsKey(Long.valueOf(e))) {
            return;
        }
        m.a aVar2 = new m.a();
        aVar2.f39398a = d;
        aVar2.f39399c = tVar.f();
        aVar2.b = tVar.b();
        this.m.t.put(Long.valueOf(tVar.e()), aVar2);
    }

    private void n(b.a aVar) {
        if (!(aVar instanceof b.s)) {
            TPLogUtil.e("TPVodReporter", "onSelectTrackEnd fail:params is not match");
            return;
        }
        b.s sVar = (b.s) aVar;
        int d = sVar.d();
        long e = sVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onSelectTrackEnd errorCode:" + d + " trackUniqueIndex:" + e);
        a(e, sVar.b(), d);
    }

    private void o(b.a aVar) {
        if (aVar instanceof b.h) {
            a(((b.h) aVar).d());
        } else {
            TPLogUtil.e("TPVodReporter", "onDrmInfo fail:params is not match");
        }
    }

    private void p(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPVodReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d = ((b.e) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d)));
        this.m.b = d;
    }

    private void q(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPVodReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d = dVar.d();
        String e = dVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d + " uIp:" + e);
        this.m.f39366c = d;
        this.m.d = e;
    }

    private void r(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPVodReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d = ((b.f) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d)));
        this.m.e = d;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a() {
        super.a();
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(int i, b.a aVar) {
        if (i == 1001) {
            c();
        } else if (i == 1002) {
            d();
        } else {
            switch (i) {
                case 2:
                    c(aVar);
                    return;
                case 3:
                    d(aVar);
                    return;
                case 4:
                    e(aVar);
                    return;
                case 5:
                    f(aVar);
                    return;
                case 6:
                    g(aVar);
                    return;
                case 7:
                    h(aVar);
                    return;
                case 8:
                    i(aVar);
                    return;
                case 9:
                    j(aVar);
                    return;
                case 10:
                    k(aVar);
                    return;
                case 11:
                    m(aVar);
                    return;
                case 12:
                    n(aVar);
                    return;
                case 13:
                    l(aVar);
                    return;
                case 14:
                    o(aVar);
                    return;
                default:
                    switch (i) {
                        case 100:
                            p(aVar);
                            return;
                        case 101:
                            q(aVar);
                            return;
                        case 102:
                            r(aVar);
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f.a(this.m.f39365a);
    }
}
