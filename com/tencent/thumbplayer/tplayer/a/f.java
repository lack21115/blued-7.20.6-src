package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/f.class */
public class f extends c {
    private b i = new b();

    private void c() {
        if (this.b == null) {
            TPLogUtil.e("TPPrepareFailReporter", "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        TPGeneralPlayFlowParams a2 = this.b.a();
        this.i.f39365a.a(this.e.i);
        this.i.f39365a.f(this.e.g);
        this.i.f39365a.j(this.e.e);
        this.i.f39365a.l(TPDownloadProxyHelper.getNativeLibVersion());
        this.i.f39365a.k(this.i.b);
        this.i.f39365a.o(this.i.e);
        this.i.f39365a.m(this.i.d);
        this.i.f39365a.n(this.i.f39366c);
        this.i.f39365a.l(this.e.h);
        this.h.put("buffermintotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.h.put("buffermaxtotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.h.put("preloadtotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.h.put("minbufferingdurationms", Long.valueOf(a2.mPlayerConfigParams.mMinBufferingDurationMs));
        this.h.put("minbufferingtimems", Long.valueOf(a2.mPlayerConfigParams.mMinBufferingTimeMs));
        this.h.put("maxbufferingtimems", Long.valueOf(a2.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.h.put("reducelatencyaction", Integer.valueOf(a2.mPlayerConfigParams.mReduceLatencyAction));
        this.h.put("reducelatencyspeed", Float.valueOf(a2.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.h.put("buffertype", Integer.valueOf(a2.mPlayerConfigParams.mBufferType));
        try {
            this.i.f39365a.p(new JSONObject(this.h).toString());
        } catch (NullPointerException e) {
            TPLogUtil.e("TPPrepareFailReporter", e);
        }
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPPrepareFailReporter", "onPrepareError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        int d = iVar.d();
        int e = iVar.e();
        TPLogUtil.i("TPPrepareFailReporter", "onPrepareError errorType:" + d + " errorCode:" + e);
        com.tencent.thumbplayer.tplayer.a.b.b bVar = new com.tencent.thumbplayer.tplayer.a.b.b();
        bVar.o(e);
        c();
        b(this.i);
        this.f.b(this.i.f39365a);
        bVar.a(this.i.f39365a);
        Map<String, String> b = bVar.b();
        a("onPrepareError", b);
        b("prepare_fail", b);
        com.tencent.thumbplayer.common.a.b.a("prepare_fail", b);
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d = ((b.e) aVar).d();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d)));
        this.i.b = d;
    }

    private void e(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d = dVar.d();
        String e = dVar.e();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d + " uIp:" + e);
        this.i.f39366c = d;
        this.i.d = e;
    }

    private void f(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d = ((b.f) aVar).d();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d)));
        this.i.e = d;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a() {
        super.a();
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(int i, b.a aVar) {
        if (i == 6) {
            c(aVar);
            return;
        }
        switch (i) {
            case 100:
                d(aVar);
                return;
            case 101:
                e(aVar);
                return;
            case 102:
                f(aVar);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.a.c, com.tencent.thumbplayer.tplayer.a.a
    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f.a(this.i.f39365a);
    }
}
