package com.tencent.thumbplayer.adapter;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.adapter.c;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.f.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/d.class */
public class d implements com.tencent.thumbplayer.adapter.a, c.k {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.thumbplayer.e.b f39198a;
    private com.tencent.thumbplayer.e.a b;

    /* renamed from: c  reason: collision with root package name */
    private Context f39199c;
    private com.tencent.thumbplayer.adapter.a.b d;
    private TPPlayerState e;
    private boolean f;
    private g g;
    private a h;
    private c i;
    private i j;
    private com.tencent.thumbplayer.adapter.strategy.a k;
    private b l;
    private int m;
    private com.tencent.thumbplayer.f.a n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/d$a.class */
    public class a implements c.a, c.b, c.InterfaceC1013c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.l, c.m, c.n, c.o, c.p {
        private a() {
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.o
        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.a(tPPostProcessFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.d
        public TPRemoteSdpInfo a(String str, int i) {
            return d.this.a(str, i);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.i
        public void a() {
            d.this.v();
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.f
        public void a(int i, int i2, long j, long j2) {
            d.this.a(i, i2, j, j2);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.h
        public void a(int i, long j, long j2, Object obj) {
            d.this.a(i, j, j2, obj);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.p
        public void a(long j, long j2) {
            d.this.a(j, j2);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.a
        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            d.this.a(tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.g
        public void a(TPDrmInfo tPDrmInfo) {
            d.this.a(tPDrmInfo);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.e
        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            d.this.a(tPPlayerDetailInfo);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.l
        public void a(TPSubtitleData tPSubtitleData) {
            d.this.a(tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.m
        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            d.this.a(tPSubtitleFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.n
        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            d.this.a(tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.b
        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.b(tPPostProcessFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.InterfaceC1013c
        public void b() {
            d.this.x();
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.j
        public void c() {
            d.this.y();
        }
    }

    public d(Context context, com.tencent.thumbplayer.e.b bVar) {
        com.tencent.thumbplayer.e.b bVar2 = new com.tencent.thumbplayer.e.b(bVar, "TPPlayerAdapter");
        this.f39198a = bVar2;
        this.b = new com.tencent.thumbplayer.e.a(bVar2);
        this.f39199c = context;
        TPPlayerState tPPlayerState = new TPPlayerState();
        this.e = tPPlayerState;
        tPPlayerState.setOnPlayerStateChangeListener(this);
        this.i = new c();
        this.h = new a();
        this.g = new g(this.f39198a.a());
        this.j = new i(this.e);
        this.l = new b();
    }

    private boolean A() {
        int i = this.m;
        return i == 2 || i == 3;
    }

    private com.tencent.thumbplayer.adapter.a.b a(int i, com.tencent.thumbplayer.e.b bVar) {
        com.tencent.thumbplayer.adapter.a.b bVar2;
        Context context;
        try {
        } catch (Exception e) {
            this.b.c("to create Player," + e.toString());
        }
        if (i == 1) {
            this.b.c("to create androidPlayer");
            bVar2 = com.tencent.thumbplayer.adapter.a.d.a(this.f39199c, this.i.p(), bVar);
        } else {
            if (i == 2) {
                this.b.c("to create thumbPlayer");
                context = this.f39199c;
            } else if (i == 3) {
                this.b.c("to create thumbPlayer software dec");
                context = this.f39199c;
            } else {
                this.b.c("to create no Player");
                bVar2 = null;
            }
            bVar2 = com.tencent.thumbplayer.adapter.a.d.a(context, bVar);
        }
        if (bVar2 == null) {
            this.b.c("play is null!");
            return null;
        }
        this.m = i;
        b(bVar2);
        return bVar2;
    }

    private com.tencent.thumbplayer.adapter.strategy.a a(c cVar) {
        com.tencent.thumbplayer.adapter.strategy.a.a aVar;
        try {
            aVar = new com.tencent.thumbplayer.adapter.strategy.a.a(cVar);
        } catch (IllegalArgumentException e) {
            aVar = new com.tencent.thumbplayer.adapter.strategy.a.a(null);
        }
        return com.tencent.thumbplayer.adapter.strategy.e.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (this.j.b(7)) {
            return this.g.a(tPPostProcessFrameBuffer);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPRemoteSdpInfo a(String str, int i) {
        return this.g.a(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, long j, long j2) {
        if (this.j.b(4)) {
            com.tencent.thumbplayer.adapter.strategy.a aVar = this.k;
            b bVar = this.l;
            int a2 = aVar.a(bVar, new com.tencent.thumbplayer.adapter.strategy.a.b(this.m, i, i2, bVar.d()));
            if (a2 != 0) {
                try {
                    e(a2);
                    return;
                } catch (IOException | IllegalStateException e) {
                    this.b.a(e);
                }
            }
            this.e.changeState(10);
            this.g.a(i, i2, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, long j2, Object obj) {
        b bVar;
        if (this.f) {
            this.b.c("handleOnInfo, mIsRetrying");
            return;
        }
        if (i == 152 && (bVar = this.l) != null) {
            bVar.f(((int) j) + 1);
        }
        this.g.a(i, j, j2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (!this.j.b(6)) {
            this.b.c("handleOnVideoSizeChange, invalid state");
            return;
        }
        this.l.b(j2);
        this.l.a(j);
        this.g.a(j, j2);
    }

    private void a(com.tencent.thumbplayer.adapter.a.b bVar) {
        TPProgramInfo l;
        TPProgramInfo[] s = s();
        if (s == null || (l = this.i.l()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= s.length) {
                return;
            }
            if (!TextUtils.isEmpty(l.url) && s[i2] != null && l.url.equals(s[i2].url)) {
                bVar.c(i2, -1L);
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        if (this.j.b(7)) {
            this.g.a(tPAudioFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPDrmInfo tPDrmInfo) {
        this.g.a(tPDrmInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.g.a(tPPlayerDetailInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPSubtitleData tPSubtitleData) {
        if (this.j.b(7)) {
            this.g.a(tPSubtitleData);
        } else {
            this.b.c("handleOnSubtitleData, invalid state");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        if (this.j.b(7)) {
            this.g.a(tPSubtitleFrameBuffer);
        } else {
            this.b.c("handleOnSubtitleFrameOut, invalid state");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        if (this.j.b(7)) {
            this.g.a(tPVideoFrameBuffer);
        } else {
            this.b.c("handleOnVideoFrameOut, invalid state");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (this.j.b(7)) {
            return this.g.b(tPPostProcessFrameBuffer);
        }
        return null;
    }

    private void b(com.tencent.thumbplayer.adapter.a.b bVar) {
        String a2;
        bVar.a((c.h) this.h);
        bVar.a((c.i) this.h);
        bVar.a((c.InterfaceC1013c) this.h);
        bVar.a((c.f) this.h);
        bVar.a((c.j) this.h);
        bVar.a((c.p) this.h);
        bVar.a((c.l) this.h);
        bVar.a((c.m) this.h);
        bVar.a((c.e) this.h);
        bVar.a((c.g) this.h);
        bVar.a((c.d) this.h);
        if (A()) {
            bVar.a((c.n) this.h);
            bVar.a((c.a) this.h);
            bVar.a((c.o) this.h);
            bVar.a((c.b) this.h);
        }
        if (1 == this.i.e().g()) {
            bVar.a(this.i.e().c());
        } else if (4 == this.i.e().g()) {
            bVar.a(this.i.e().d());
        } else if (3 == this.i.e().g()) {
            int i = this.m;
            if (i == 2) {
                a2 = this.i.e().f().b();
            } else if (i == 1) {
                a2 = this.i.e().f().a();
            }
            bVar.a(a2, this.i.e().b());
        } else if (2 == this.i.e().g()) {
            bVar.a(this.i.e().e());
        }
        for (TPOptionalParam tPOptionalParam : this.i.o()) {
            bVar.a(tPOptionalParam);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i.b().size()) {
                break;
            }
            TPTrackInfo tPTrackInfo = this.i.b().get(i3);
            if (tPTrackInfo.trackType == 3) {
                Iterator<c.d> it = this.i.m().iterator();
                while (true) {
                    if (it.hasNext()) {
                        c.d next = it.next();
                        if (!TextUtils.isEmpty(next.f39197c) && next.f39197c.equals(tPTrackInfo.name)) {
                            bVar.a(next.f39196a, next.d, next.b, next.f39197c);
                            break;
                        }
                    }
                }
            } else if (tPTrackInfo.trackType == 2) {
                Iterator<c.a> it2 = this.i.n().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        c.a next2 = it2.next();
                        if (!TextUtils.isEmpty(next2.b) && next2.b.equals(tPTrackInfo.name)) {
                            bVar.a(next2.f39190a, next2.d, next2.b, next2.f39191c);
                            break;
                        }
                    }
                }
            }
            i2 = i3 + 1;
        }
        Iterator<c.C1014c> it3 = this.i.c().iterator();
        while (it3.hasNext()) {
            c.C1014c next3 = it3.next();
            if (next3.f39195c.isSelected) {
                TPTrackInfo[] r = bVar.r();
                if (r == null) {
                    this.b.e("playerTrackInfoList is null.");
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < r.length) {
                            if (next3.f39195c.name.equals(r[i5].name)) {
                                bVar.a(i5, next3.b);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            }
        }
        if (this.i.k() != null) {
            bVar.a(this.i.k().f39192a, this.i.k().b, this.i.k().f39193c);
        }
        bVar.a(this.i.g());
        if (this.i.h() != 0.0f) {
            bVar.a(this.i.h());
        }
        if (this.i.j() != 0.0f) {
            bVar.b(this.i.j());
        }
        if (!"".equals(this.i.i())) {
            bVar.a(this.i.i());
        }
        if (this.i.d() instanceof SurfaceHolder) {
            bVar.a((SurfaceHolder) this.i.d());
        } else if (this.i.d() instanceof Surface) {
            bVar.a((Surface) this.i.d());
        }
        bVar.a(new TPOptionalParam().buildQueueInt(204, this.k.a()));
    }

    private void d(int i) {
        if (i != 5) {
            return;
        }
        try {
            this.d.h();
            this.e.changeState(5);
        } catch (IllegalStateException e) {
            this.b.a(e);
        }
    }

    private void e(int i) {
        this.g.a(1013, i, 0L, (Object) null);
        TPPlayerState tPPlayerState = this.e;
        tPPlayerState.setLastState(tPPlayerState.state());
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            long n = bVar.n();
            this.b.c("switchPlayer, current position:".concat(String.valueOf(n)));
            this.l.f(n);
            this.l.i(this.d.o());
            this.d.k();
            this.d.l();
        }
        com.tencent.thumbplayer.adapter.a.b a2 = a(i, this.f39198a);
        this.d = a2;
        if (a2 == null) {
            throw new RuntimeException("error , create player failed");
        }
        this.f = true;
        com.tencent.thumbplayer.e.a aVar = this.b;
        aVar.c("switch player to type:" + this.m);
        if (this.l != null) {
            this.d.a(new TPOptionalParam().buildLong(100, this.l.h()));
        }
        this.e.setInnerPlayStateState(3);
        this.d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.g.a(1000, this.m, 0L, (Object) null);
        if (this.f) {
            if (this.e.innerPlayState() != 3) {
                this.b.d("handleOnPrepared, invalid state, mIsRetrying.");
                return;
            }
        } else if (!this.j.b(1)) {
            this.b.c("handleOnPrepared, invalid state");
            return;
        }
        w();
        a(this.d);
        if (!this.f) {
            this.e.setInnerPlayStateState(4);
            this.e.changeState(4);
            this.g.a();
            return;
        }
        this.f = false;
        com.tencent.thumbplayer.e.a aVar = this.b;
        aVar.c("handleOnPrepared, mIsRetrying, recoverState, state:" + this.e.state());
        int state = this.e.state();
        this.e.changeState(4);
        if (this.e.lastState() == 3) {
            this.g.a();
        }
        this.g.a(1014, 0L, 0L, (Object) null);
        d(state);
    }

    private void w() {
        if (A()) {
            b a2 = b.a(c(0));
            this.l = a2;
            a2.e((int) this.d.b(204));
            this.l.a((int) this.d.b(203));
            this.l.c((int) this.d.b(102));
            this.l.g((int) this.d.b(201));
            this.l.b((int) this.d.b(210));
        }
        if (this.l == null) {
            this.l = new b();
        }
        this.l.h(this.d.m());
        TPOptionalParam b = this.i.b(100);
        if (b != null) {
            this.l.f(b.getParamLong().value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.j.b(2)) {
            this.b.c("handleOnComplete, invalid state");
            return;
        }
        this.e.changeState(7);
        this.g.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.j.b(5)) {
            this.g.c();
        }
    }

    private int z() {
        if (this.k == null) {
            this.k = a(this.i);
        }
        return this.k.a(this.l);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public int a() {
        b bVar = this.l;
        if (bVar != null) {
            return bVar.l();
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(float f) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(f);
        } else {
            this.b.c("setAudioGainRatio, mPlayerBase = null!");
        }
        this.i.a(f);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i) {
        if (!this.j.a(9)) {
            throw new IllegalStateException("error , seek to , state invalid , current state :" + this.e);
        } else if (this.d == null) {
            this.b.d("seekTo, mPlayerBase = null!");
        } else {
            if (this.e.state() == 7) {
                this.e.changeState(5);
            }
            this.d.a(i);
            com.tencent.thumbplayer.f.a aVar = this.n;
            if (aVar != null) {
                try {
                    aVar.a(i);
                } catch (Exception e) {
                    this.b.d("seekTo, rich media processor seek err.");
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, @TPCommonEnum.TPSeekMode int i2) {
        if (!this.j.a(9)) {
            throw new IllegalStateException("error , seek to , state invalid , current state :" + this.e);
        } else if (this.d == null) {
            this.b.d("seekTo, mPlayerBase = null!");
        } else {
            if (this.e.state() == 7) {
                this.e.changeState(5);
            }
            this.d.a(i, i2);
            com.tencent.thumbplayer.f.a aVar = this.n;
            if (aVar != null) {
                try {
                    aVar.a(i);
                } catch (Exception e) {
                    this.b.d("seekTo, rich media processor seek err.");
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, long j) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error : selectTrack , state invalid");
        }
        TPTrackInfo[] r = r();
        if (r == null) {
            this.b.e("fatal err, tpTrackInfos is null");
        } else if (i < 0 || i > r.length - 1) {
            throw new IllegalArgumentException("error : track not found");
        } else {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.a(i, j);
            }
            this.i.a(i, j, r[i]);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (!this.j.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        }
        if (assetFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , afd invalid");
        }
        this.i.a(assetFileDescriptor);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (!this.j.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        }
        if (parcelFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , pfd invalid");
        }
        this.i.a(parcelFileDescriptor);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(Surface surface) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(surface);
        }
        this.i.a(surface);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(surfaceHolder);
        }
        this.i.a(surfaceHolder);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.a aVar) {
        this.g.a(aVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.b bVar) {
        this.g.a(bVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.InterfaceC1013c interfaceC1013c) {
        this.g.a(interfaceC1013c);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.d dVar) {
        this.g.a(dVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.e eVar) {
        this.g.a(eVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.f fVar) {
        this.g.a(fVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.g gVar) {
        this.g.a(gVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.h hVar) {
        this.g.a(hVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.i iVar) {
        this.g.a(iVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.j jVar) {
        this.g.a(jVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(c.k kVar) {
        this.g.a(kVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.l lVar) {
        this.g.a(lVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.m mVar) {
        this.g.a(mVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.n nVar) {
        this.g.a(nVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.o oVar) {
        this.g.a(oVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.p pVar) {
        this.g.a(pVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(com.tencent.thumbplayer.adapter.a.e eVar) {
        a(eVar, (Map<String, String>) null);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(com.tencent.thumbplayer.adapter.a.e eVar, int i, long j) {
        if (!this.j.a(17)) {
            throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.e);
        }
        this.i.a(eVar, (Map<String, String>) null);
        if (this.d == null) {
            this.b.d("switchDefinition, mPlayerBase = null!");
            return;
        }
        int i2 = this.m;
        this.d.a(i2 == 2 ? eVar.b() : i2 == 1 ? eVar.a() : "", i, j);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(com.tencent.thumbplayer.adapter.a.e eVar, Map<String, String> map) {
        if (!this.j.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        }
        this.i.a(eVar, map);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(com.tencent.thumbplayer.adapter.a.e eVar, Map<String, String> map, int i, long j) {
        if (!this.j.a(17)) {
            throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.e);
        }
        this.i.a(eVar, map);
        if (this.d == null) {
            this.b.d("switchDefinition, mPlayerBase = null!");
            return;
        }
        int i2 = this.m;
        this.d.a(i2 == 2 ? eVar.b() : i2 == 1 ? eVar.a() : "", map, i, j);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(tPCaptureParams, tPCaptureCallBack);
            return;
        }
        throw new IllegalStateException("error , no player for capture :" + this.e);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPOptionalParam tPOptionalParam) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("setPlayerOptionalParam , state invalid");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(tPOptionalParam);
        }
        this.i.a(tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(TPVideoInfo tPVideoInfo) {
        if (!this.j.a(2)) {
            this.b.e("setVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.l.b(tPVideoInfo.getHeight());
            this.l.a(tPVideoInfo.getWidth());
            this.l.c(tPVideoInfo.getDefinition());
            this.l.g(tPVideoInfo.getVideoCodecId());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset) {
        if (!this.j.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        }
        if (iTPMediaAsset == null) {
            throw new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
        }
        this.i.a(iTPMediaAsset);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        if (!this.j.a(17)) {
            throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.e);
        }
        this.i.a(iTPMediaAsset);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(iTPMediaAsset, i, j);
        } else {
            this.b.d("switchDefinition, mPlayerBase = null!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        if (iTPRichMediaSynchronizer == null) {
            com.tencent.thumbplayer.f.a aVar = this.n;
            if (aVar != null) {
                aVar.a((a.InterfaceC1019a) null);
            }
            this.n = null;
        } else if (iTPRichMediaSynchronizer instanceof com.tencent.thumbplayer.f.a) {
            com.tencent.thumbplayer.f.a aVar2 = (com.tencent.thumbplayer.f.a) iTPRichMediaSynchronizer;
            this.n = aVar2;
            aVar2.a(new a.InterfaceC1019a() { // from class: com.tencent.thumbplayer.adapter.d.1
                @Override // com.tencent.thumbplayer.f.a.InterfaceC1019a
                public long a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer2) {
                    return d.this.n();
                }
            });
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(com.tencent.thumbplayer.e.b bVar) {
        this.f39198a.a(bVar, "TPPlayerAdapter");
        this.b.a(this.f39198a);
        this.g.a(this.f39198a.a());
        com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
        if (bVar2 != null) {
            bVar2.a(this.f39198a);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str);
        } else {
            this.b.c("setAudioGainRatio, mPlayerBase = null!");
        }
        this.i.a(str);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i, long j) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, int i, long j) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error : addSubtitleSource, state invalid");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, map, str2, str3);
        }
        this.i.a(str, map, str2, str3);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error : addAudioTrackSource, state invalid");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, map, str2, list);
        }
        this.i.a(str, map, str2, list);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(z);
        } else {
            this.b.c("setOutputMute, mPlayerBase = null!");
        }
        this.i.a(z);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z, long j, long j2) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(z, j, j2);
        } else {
            this.b.c("setLoopback, mPlayerBase = null!");
        }
        this.i.a(z, j, j2);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public int b() {
        return this.e.state();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long b(int i) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            return bVar.b(i);
        }
        this.b.d("getPropertyLong, mPlayerBase = null, return !");
        return -1L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(float f) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.b(f);
        } else {
            this.b.c("setPlaySpeedRatio, mPlayerBase = null!");
        }
        this.i.b(f);
        com.tencent.thumbplayer.f.a aVar = this.n;
        if (aVar != null) {
            try {
                aVar.a(f);
            } catch (Exception e) {
                this.b.d("setPlaySpeedRatio, rich media processor setPlaySpeedRatio err.");
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.c.k
    public void b(int i, int i2) {
        this.g.b(i, i2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(int i, long j) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error : deselectTrack , state invalid");
        }
        TPTrackInfo[] r = r();
        if (r == null) {
            this.b.e("fatal err, tpTrackInfos is null");
        } else if (i < 0 || i > r.length - 1) {
            throw new IllegalArgumentException("error : track not found");
        } else {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.b(i, j);
            }
            this.i.b(i, j, r[i]);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public void b(TPVideoInfo tPVideoInfo) {
        if (!this.j.a(3)) {
            this.b.e("updateVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.l.b(tPVideoInfo.getHeight());
            this.l.a(tPVideoInfo.getWidth());
            this.l.c(tPVideoInfo.getDefinition());
            this.l.g(tPVideoInfo.getVideoCodecId());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(boolean z) {
        if (!this.j.a(3)) {
            throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.b(z);
        } else {
            this.b.c("setLoopback, mPlayerBase = null!");
        }
        this.i.b(z);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPDynamicStatisticParams c(boolean z) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar == null) {
            return null;
        }
        return bVar.c(z);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public String c(int i) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            return bVar.c(i);
        }
        this.b.d("getPropertyString, mPlayerBase = null, return !");
        return "";
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void c(int i, long j) {
        if (!this.j.a(18)) {
            throw new IllegalStateException("error : selectProgram , state invalid");
        }
        TPProgramInfo[] s = s();
        TPProgramInfo[] tPProgramInfoArr = s;
        if (s == null) {
            tPProgramInfoArr = new TPProgramInfo[0];
        }
        if (i < 0 || i > tPProgramInfoArr.length - 1) {
            throw new IllegalArgumentException("error : program index not found");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.c(i, j);
        }
        this.i.a(tPProgramInfoArr[i]);
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public boolean c() {
        TPPlayerState tPPlayerState = this.e;
        return tPPlayerState != null && tPPlayerState.state() == 5;
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public int d() {
        return this.m;
    }

    @Override // com.tencent.thumbplayer.adapter.a
    public b e() {
        return this.l;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void f() {
        if (!this.j.a(1)) {
            throw new IllegalStateException("error , prepare , state invalid , current state :" + this.e);
        } else if (!this.i.f()) {
            throw new IOException("error , prepare , data source invalid");
        } else {
            com.tencent.thumbplayer.adapter.a.b a2 = a(z(), this.f39198a);
            this.d = a2;
            if (a2 == null) {
                throw new RuntimeException("error , create player failed");
            }
            this.e.setInnerPlayStateState(3);
            this.e.changeState(3);
            this.d.f();
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void g() {
        if (!this.j.a(1)) {
            throw new IllegalStateException("error , prepare , state invalid , current state :" + this.e);
        } else if (!this.i.f()) {
            throw new IllegalStateException("error , prepare , state invalid , data source invalid");
        } else {
            com.tencent.thumbplayer.adapter.a.b a2 = a(z(), this.f39198a);
            this.d = a2;
            if (a2 == null) {
                throw new RuntimeException("error , create player failed");
            }
            this.e.setInnerPlayStateState(3);
            this.e.changeState(3);
            this.d.g();
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void h() {
        if (!this.j.a(5)) {
            throw new IllegalStateException("error , start , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar == null) {
            throw new IllegalStateException("error , start , player is null");
        }
        try {
            bVar.h();
            this.e.changeState(5);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("error , start ,state invalid");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void i() {
        if (!this.j.a(6)) {
            throw new IllegalStateException("error , pause , state invalid , current state :" + this.e);
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar == null) {
            throw new IllegalStateException("error , pause , player is null");
        }
        if (this.f) {
            this.e.changeState(6);
            return;
        }
        try {
            bVar.i();
            this.e.changeState(6);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("error , pause ,state invalid");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void j() {
        if (!this.j.a(7)) {
            throw new IllegalStateException("error , stop , state invalid , current state :" + this.e);
        } else if (this.d == null) {
            throw new IllegalStateException("error , stop , player is null");
        } else {
            try {
                try {
                    this.e.changeState(8);
                    this.d.j();
                    this.e.changeState(9);
                } catch (IllegalStateException e) {
                    throw new IllegalStateException("error , stop ,state invalid");
                }
            } catch (Throwable th) {
                this.e.changeState(9);
                throw th;
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void k() {
        com.tencent.thumbplayer.e.a aVar = this.b;
        aVar.c("reset, current state :" + this.e);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.k();
            this.d.l();
            this.d = null;
        }
        this.i.a();
        this.l.n();
        this.k = null;
        this.f = false;
        this.e.changeState(1);
        this.e.setLastState(1);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void l() {
        com.tencent.thumbplayer.e.a aVar = this.b;
        aVar.c("release, current state :" + this.e);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.l();
            this.d = null;
        }
        this.i.a();
        this.g.d();
        this.k = null;
        this.f = false;
        this.e.changeState(11);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long m() {
        b bVar = this.l;
        if (bVar == null || bVar.j() <= 0) {
            if (this.j.a(11)) {
                com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
                if (bVar2 == null) {
                    this.b.d("getDurationMs, mPlayerBase = null, return 0!");
                    return 0L;
                }
                long m = bVar2.m();
                b bVar3 = this.l;
                if (bVar3 != null) {
                    bVar3.h(m);
                }
                return m;
            }
            return 0L;
        }
        return this.l.j();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long n() {
        if (!this.j.a(12)) {
            b bVar = this.l;
            if (bVar != null) {
                return bVar.h();
            }
            return 0L;
        }
        com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
        if (bVar2 == null) {
            this.b.d("getCurrentPositionMs, mPlayerBase = null, return 0!");
            return 0L;
        }
        long n = bVar2.n();
        b bVar3 = this.l;
        if (bVar3 != null) {
            bVar3.f(n);
        }
        return n;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long o() {
        if (this.j.a(12)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar == null) {
                this.b.d("getBufferedDurationMs, mPlayerBase = null, return 0!");
                return 0L;
            }
            long o = bVar.o();
            b bVar2 = this.l;
            if (bVar2 != null) {
                bVar2.i(o);
            }
            return o;
        }
        return 0L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int p() {
        b bVar = this.l;
        if (bVar == null || bVar.a() <= 0) {
            if (!this.j.a(13)) {
                this.b.d("getVideoWidth, state error!");
                return 0;
            }
            com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
            if (bVar2 == null) {
                this.b.d("getVideoWidth, mPlayerBase = null, return 0!");
                return 0;
            }
            int p = bVar2.p();
            b bVar3 = this.l;
            if (bVar3 != null) {
                bVar3.a(p);
            }
            return p;
        }
        return (int) this.l.a();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int q() {
        b bVar = this.l;
        if (bVar == null || bVar.b() <= 0) {
            if (!this.j.a(13)) {
                this.b.d("getVideoHeight, state error!");
                return 0;
            }
            com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
            if (bVar2 == null) {
                this.b.d("getVideoHeight, mPlayerBase = null, return 0!");
                return 0;
            }
            int q = bVar2.q();
            b bVar3 = this.l;
            if (bVar3 != null) {
                bVar3.b(q);
            }
            return q;
        }
        return (int) this.l.b();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPTrackInfo[] r() {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        return bVar != null ? bVar.r() : (TPTrackInfo[]) this.i.b().toArray(new TPTrackInfo[0]);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPProgramInfo[] s() {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        return (bVar == null || bVar.s() == null) ? new TPProgramInfo[0] : this.d.s();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long t() {
        if (!this.j.a(19)) {
            b bVar = this.l;
            if (bVar != null) {
                return bVar.i();
            }
            return -1L;
        }
        com.tencent.thumbplayer.adapter.a.b bVar2 = this.d;
        if (bVar2 == null) {
            this.b.d("getDemuxerOffsetInFile, mPlayerBase = null, return 0!");
            return -1L;
        }
        long t = bVar2.t();
        b bVar3 = this.l;
        if (bVar3 != null) {
            bVar3.g(t);
        }
        return t;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPGeneralPlayFlowParams u() {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar == null) {
            return null;
        }
        return bVar.u();
    }
}
