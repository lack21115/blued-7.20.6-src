package com.tencent.thumbplayer.adapter;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/g.class */
public class g implements c.a, c.b, c.InterfaceC1013c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p {

    /* renamed from: a  reason: collision with root package name */
    private c.i f39205a;
    private c.InterfaceC1013c b;

    /* renamed from: c  reason: collision with root package name */
    private c.h f39206c;
    private c.f d;
    private c.j e;
    private c.p f;
    private c.l g;
    private c.n h;
    private c.a i;
    private c.m j;
    private c.o k;
    private c.b l;
    private c.k m;
    private c.e n;
    private c.g o;
    private c.d p;
    private a q;
    private String r = "TPPlayerListenerS";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/g$a.class */
    public static class a implements c.a, c.b, c.InterfaceC1013c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p {

        /* renamed from: a  reason: collision with root package name */
        private String f39207a;

        public a(String str) {
            this.f39207a = str;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.o
        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onVideoProcessFrameOut");
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.d
        public TPRemoteSdpInfo a(String str, int i) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onSdpExchange");
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.i
        public void a() {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onPrepared");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.f
        public void a(int i, int i2, long j, long j2) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onError");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.h
        public void a(int i, long j, long j2, Object obj) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onInfo");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.p
        public void a(long j, long j2) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onVideoSizeChanged");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.a
        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onAudioFrameOut");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.g
        public void a(TPDrmInfo tPDrmInfo) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onEventRecord");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.e
        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onDetailInfo");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.l
        public void a(TPSubtitleData tPSubtitleData) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onSubtitleData");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.m
        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , TPSubtitleFrameBuffer");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.n
        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onVideoFrameOut");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.b
        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onAudioProcessFrameOut");
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.InterfaceC1013c
        public void b() {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onCompletion");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.k
        public void b(int i, int i2) {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onStateChange");
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.j
        public void c() {
            TPLogUtil.i(this.f39207a, " empty base listener , notify , onSeekComplete");
        }
    }

    public g(String str) {
        a(str);
        a aVar = new a(this.r);
        this.q = aVar;
        this.f39205a = aVar;
        this.b = aVar;
        this.f39206c = aVar;
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.k = aVar;
        this.l = aVar;
        this.m = aVar;
        this.n = aVar;
        this.o = aVar;
        this.p = aVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.o
    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.k.a(tPPostProcessFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.d
    public TPRemoteSdpInfo a(String str, int i) {
        return this.p.a(str, i);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.i
    public void a() {
        this.f39205a.a();
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.f
    public void a(@TPCommonEnum.TPErrorType int i, int i2, long j, long j2) {
        this.d.a(i, i2, j, j2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.h
    public void a(int i, long j, long j2, Object obj) {
        this.f39206c.a(i, j, j2, obj);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.p
    public void a(long j, long j2) {
        this.f.a(j, j2);
    }

    public void a(c.a aVar) {
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = this.q;
        }
        this.i = aVar2;
    }

    public void a(c.b bVar) {
        a aVar = bVar;
        if (bVar == null) {
            aVar = this.q;
        }
        this.l = aVar;
    }

    public void a(c.InterfaceC1013c interfaceC1013c) {
        a aVar = interfaceC1013c;
        if (interfaceC1013c == null) {
            aVar = this.q;
        }
        this.b = aVar;
    }

    public void a(c.d dVar) {
        a aVar = dVar;
        if (dVar == null) {
            aVar = this.q;
        }
        this.p = aVar;
    }

    public void a(c.e eVar) {
        a aVar = eVar;
        if (eVar == null) {
            aVar = this.q;
        }
        this.n = aVar;
    }

    public void a(c.f fVar) {
        a aVar = fVar;
        if (fVar == null) {
            aVar = this.q;
        }
        this.d = aVar;
    }

    public void a(c.g gVar) {
        a aVar = gVar;
        if (gVar == null) {
            aVar = this.q;
        }
        this.o = aVar;
    }

    public void a(c.h hVar) {
        a aVar = hVar;
        if (hVar == null) {
            aVar = this.q;
        }
        this.f39206c = aVar;
    }

    public void a(c.i iVar) {
        a aVar = iVar;
        if (iVar == null) {
            aVar = this.q;
        }
        this.f39205a = aVar;
    }

    public void a(c.j jVar) {
        a aVar = jVar;
        if (jVar == null) {
            aVar = this.q;
        }
        this.e = aVar;
    }

    public void a(c.k kVar) {
        a aVar = kVar;
        if (kVar == null) {
            aVar = this.q;
        }
        this.m = aVar;
    }

    public void a(c.l lVar) {
        a aVar = lVar;
        if (lVar == null) {
            aVar = this.q;
        }
        this.g = aVar;
    }

    public void a(c.m mVar) {
        a aVar = mVar;
        if (mVar == null) {
            aVar = this.q;
        }
        this.j = aVar;
    }

    public void a(c.n nVar) {
        a aVar = nVar;
        if (nVar == null) {
            aVar = this.q;
        }
        this.h = aVar;
    }

    public void a(c.o oVar) {
        a aVar = oVar;
        if (oVar == null) {
            aVar = this.q;
        }
        this.k = aVar;
    }

    public void a(c.p pVar) {
        a aVar = pVar;
        if (pVar == null) {
            aVar = this.q;
        }
        this.f = aVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.a
    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        this.i.a(tPAudioFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.g
    public void a(TPDrmInfo tPDrmInfo) {
        this.o.a(tPDrmInfo);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.e
    public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.n.a(tPPlayerDetailInfo);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.l
    public void a(TPSubtitleData tPSubtitleData) {
        this.g.a(tPSubtitleData);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.m
    public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        this.j.a(tPSubtitleFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.n
    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.h.a(tPVideoFrameBuffer);
    }

    public void a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "TPPlayerListenerS";
        }
        this.r = str2;
        a aVar = this.q;
        if (aVar != null) {
            aVar.f39207a = this.r;
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.b
    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.l.b(tPPostProcessFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.InterfaceC1013c
    public void b() {
        this.b.b();
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.k
    public void b(int i, int i2) {
        this.m.b(i, i2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.j
    public void c() {
        this.e.c();
    }

    public void d() {
        a aVar = this.q;
        this.f39205a = aVar;
        this.b = aVar;
        this.f39206c = aVar;
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.m = aVar;
        this.k = aVar;
        this.l = aVar;
        this.n = aVar;
        this.o = aVar;
        this.p = aVar;
    }
}
