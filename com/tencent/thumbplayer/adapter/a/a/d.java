package com.tencent.thumbplayer.adapter.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.adapter.c;
import com.tencent.thumbplayer.adapter.g;
import com.tencent.thumbplayer.adapter.i;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.b.h;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/d.class */
public class d implements com.tencent.thumbplayer.adapter.a.b {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.thumbplayer.e.a f25452a;
    private com.tencent.thumbplayer.e.b b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25453c;
    private com.tencent.thumbplayer.adapter.a.b d;
    private TPPlayerState e;
    private g f;
    private a g;
    private com.tencent.thumbplayer.adapter.c h;
    private i i;
    private com.tencent.thumbplayer.adapter.b j;
    private List<ITPMediaTrackClip> k;
    private int l = 0;
    private boolean m;
    private boolean n;
    private LinkedList<Long> o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/d$a.class */
    public class a implements c.a, c.b, c.InterfaceC0843c, c.f, c.h, c.i, c.j, c.l, c.n, c.o, c.p {
        private a() {
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.o
        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.a(tPPostProcessFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.i
        public void a() {
            d.this.a();
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

        @Override // com.tencent.thumbplayer.adapter.a.c.l
        public void a(TPSubtitleData tPSubtitleData) {
            d.this.a(tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.n
        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            d.this.a(tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.b
        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.b(tPPostProcessFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.InterfaceC0843c
        public void b() {
            d.this.b();
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.j
        public void c() {
            d.this.d();
        }
    }

    public d(Context context, com.tencent.thumbplayer.e.b bVar) {
        com.tencent.thumbplayer.e.b bVar2 = new com.tencent.thumbplayer.e.b(bVar, "TPSystemClipPlayer");
        this.b = bVar2;
        this.f25452a = new com.tencent.thumbplayer.e.a(bVar2);
        this.f25453c = context;
        this.e = new TPPlayerState();
        this.h = new com.tencent.thumbplayer.adapter.c();
        this.g = new a();
        this.f = new g(this.f25452a.b());
        this.i = new i(this.e);
        this.k = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (this.i.b(7)) {
            return this.f.a(tPPostProcessFrameBuffer);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        g gVar = this.f;
        if (gVar != null) {
            gVar.a(152, this.l, 0L, (Object) null);
        }
        if (!this.m) {
            if (this.i.b(1)) {
                this.e.changeState(4);
                g gVar2 = this.f;
                if (gVar2 != null) {
                    gVar2.a();
                }
                b(this.d);
                return;
            }
            return;
        }
        h();
        if (!this.n || this.f == null || com.tencent.thumbplayer.utils.b.a(this.o)) {
            return;
        }
        Long poll = this.o.poll();
        if (poll != null) {
            this.f.a(3, poll.longValue(), 0L, (Object) null);
        }
        this.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, long j, long j2) {
        if (this.i.b(4)) {
            this.f.a(i, i2, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, long j2, Object obj) {
        if (this.i.b(3)) {
            this.f.a(i, j, j2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (this.i.b(6)) {
            this.j.b(j2);
            this.j.a(j);
            this.f.a(j, j2);
        }
    }

    private void a(com.tencent.thumbplayer.adapter.a.b bVar) {
        if (1 == this.h.e().g()) {
            bVar.a(this.h.e().c());
        } else if (4 == this.h.e().g()) {
            bVar.a(this.h.e().d());
        }
        if (this.h.e().g() == 0) {
            bVar.a(this.h.e().a(), this.h.e().b());
        }
        for (TPOptionalParam tPOptionalParam : this.h.o()) {
            bVar.a(tPOptionalParam);
        }
        for (c.d dVar : this.h.m()) {
            bVar.a(dVar.f25505a, dVar.d, dVar.b, dVar.f25506c);
        }
        for (c.a aVar : this.h.n()) {
            bVar.a(aVar.f25499a, aVar.d, aVar.b, aVar.f25500c);
        }
        if (this.h.k() != null) {
            bVar.a(this.h.k().f25501a, this.h.k().b, this.h.k().f25502c);
        }
        bVar.a(this.h.g());
        if (this.h.h() != 0.0f) {
            bVar.a(this.h.h());
        }
        if (this.h.j() != 0.0f) {
            bVar.b(this.h.j());
        }
        if (this.h.d() instanceof SurfaceHolder) {
            bVar.a((SurfaceHolder) this.h.d());
        } else if (this.h.d() instanceof Surface) {
            bVar.a((Surface) this.h.d());
        }
        bVar.a((c.h) this.g);
        bVar.a((c.i) this.g);
        bVar.a((c.InterfaceC0843c) this.g);
        bVar.a((c.f) this.g);
        bVar.a((c.j) this.g);
        bVar.a((c.p) this.g);
        bVar.a((c.l) this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        if (this.i.b(7)) {
            this.f.a(tPAudioFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPSubtitleData tPSubtitleData) {
        if (this.i.b(7)) {
            this.f.a(tPSubtitleData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        if (this.i.b(7)) {
            this.f.a(tPVideoFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (this.i.b(7)) {
            return this.f.b(tPPostProcessFrameBuffer);
        }
        return null;
    }

    private List<ITPMediaTrackClip> b(ITPMediaAsset iTPMediaAsset) {
        ArrayList arrayList;
        boolean z = iTPMediaAsset instanceof com.tencent.thumbplayer.b.e;
        if (z || (iTPMediaAsset instanceof com.tencent.thumbplayer.b.g) || (iTPMediaAsset instanceof h)) {
            ArrayList arrayList2 = new ArrayList();
            if (z) {
                List<ITPMediaTrack> allAVTracks = ((com.tencent.thumbplayer.b.e) iTPMediaAsset).getAllAVTracks();
                if (com.tencent.thumbplayer.utils.b.a(allAVTracks) || allAVTracks.get(0) == null) {
                    throw new IllegalStateException("empty av tracks when set data source!");
                }
                arrayList = allAVTracks.get(0).getAllTrackClips();
            } else if (iTPMediaAsset instanceof com.tencent.thumbplayer.b.g) {
                arrayList = ((com.tencent.thumbplayer.b.g) iTPMediaAsset).getAllTrackClips();
            } else {
                arrayList2.add((ITPMediaTrackClip) iTPMediaAsset);
                arrayList = arrayList2;
            }
            long j = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                ((ITPMediaTrackClip) arrayList.get(i)).setStartPositionMs(j);
                j += ((ITPMediaTrackClip) arrayList.get(i)).getOriginalDurationMs();
            }
            return arrayList;
        }
        throw new IllegalStateException("system mediaPlayer : media asset is illegal source!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.i.b(2)) {
            if (this.l >= this.k.size() - 1) {
                this.e.changeState(7);
                this.f.b();
                return;
            }
            try {
                d(this.l + 1, 0L);
            } catch (IOException e) {
                com.tencent.thumbplayer.e.a aVar = this.f25452a;
                aVar.c("handleOnComplete:" + e.toString());
            }
        }
    }

    private void b(com.tencent.thumbplayer.adapter.a.b bVar) {
        TPTrackInfo[] r = r();
        if (r == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= r.length) {
                return;
            }
            if (r[i2].equals(this.h.a(r[i2].getTrackType()))) {
                bVar.a(i2, -1L);
            }
            i = i2 + 1;
        }
    }

    private ITPMediaTrackClip c() {
        return this.k.get(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.i.b(5)) {
            if (this.e.is(7)) {
                h();
            }
            this.f.c();
        }
    }

    private void d(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.k.size()) {
                return;
            }
            long j = i;
            if (this.k.get(i3).getStartPositionMs() <= j && j <= this.k.get(i3).getStartPositionMs() + this.k.get(i3).getOriginalDurationMs()) {
                try {
                    d(i3, j - this.k.get(i3).getStartPositionMs());
                } catch (IOException e) {
                    this.f25452a.c("selectClipPlayer:" + e.toString());
                }
            }
            i2 = i3 + 1;
        }
    }

    private void d(int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.f25452a;
        aVar.b("switchPlayer: clipNo:" + i + "   startPostion:" + j);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.l();
        }
        this.m = true;
        this.l = i;
        this.h.b(this.k.get(i).getFilePath());
        com.tencent.thumbplayer.adapter.a.b e = e();
        this.d = e;
        if (e == null) {
            throw new RuntimeException("error , create player failed");
        }
        this.d.a(new TPOptionalParam().buildLong(100, j));
        this.d.f();
    }

    private com.tencent.thumbplayer.adapter.a.b e() {
        e eVar = new e(this.f25453c, this.b);
        if (this.j == null) {
            this.j = new com.tencent.thumbplayer.adapter.b();
        }
        a(eVar);
        return eVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(float f) {
        if (this.i.a(3)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.a(f);
            }
            this.h.a(f);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i) {
        if (this.i.a(9)) {
            long j = i;
            if (j < c().getStartPositionMs() || j > c().getStartPositionMs() + c().getOriginalDurationMs()) {
                d(i);
            } else if (this.d != null) {
                this.f25452a.b("seek to:".concat(String.valueOf(i)));
                this.d.a((int) (j - c().getStartPositionMs()));
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, @TPCommonEnum.TPSeekMode int i2) {
        if (this.i.a(9)) {
            long j = i;
            if (j < c().getStartPositionMs() || j > c().getStartPositionMs() + c().getOriginalDurationMs()) {
                d(i);
            } else if (this.d != null) {
                this.f25452a.b("seek to:" + i + "/mode=" + i2);
                this.d.a((int) (j - c().getStartPositionMs()), i2);
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, long j) {
        this.f25452a.e("selectTrack not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.h.a(assetFileDescriptor);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.h.a(parcelFileDescriptor);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(Surface surface) {
        if (!this.i.a(4)) {
            throw new IllegalStateException("setSurface , state invalid");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(surface);
        }
        this.h.a(surface);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(SurfaceHolder surfaceHolder) {
        if (!this.i.a(4)) {
            throw new IllegalStateException("setSurfaceHolder , state invalid");
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(surfaceHolder);
        }
        this.h.a(surfaceHolder);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.a aVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.b bVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.InterfaceC0843c interfaceC0843c) {
        this.f.a(interfaceC0843c);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.d dVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.e eVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.f fVar) {
        this.f.a(fVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.g gVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.h hVar) {
        this.f.a(hVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.i iVar) {
        this.f.a(iVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.j jVar) {
        this.f.a(jVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.l lVar) {
        this.f.a(lVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.m mVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.n nVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video frame out");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.o oVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.p pVar) {
        this.f.a(pVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(tPCaptureParams, tPCaptureCallBack);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam.getKey() == 100) {
            int i = (int) tPOptionalParam.getParamLong().value;
            this.f25452a.b("start position:".concat(String.valueOf(i)));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.k.size()) {
                    break;
                }
                long j = i;
                if (this.k.get(i3).getStartPositionMs() <= j && j <= this.k.get(i3).getStartPositionMs() + this.k.get(i3).getOriginalDurationMs()) {
                    this.l = i3;
                    this.h.b(this.k.get(i3).getFilePath());
                    tPOptionalParam.getParamLong().value = j - this.k.get(i3).getStartPositionMs();
                }
                i2 = i3 + 1;
            }
        }
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(tPOptionalParam);
        }
        this.h.a(tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset) {
        List<ITPMediaTrackClip> b = b(iTPMediaAsset);
        try {
            this.k = b;
            this.h.b(b.get(this.l).getFilePath());
            this.e.changeState(2);
        } catch (Exception e) {
            this.f25452a.a(e);
            throw new IllegalStateException("exception when system clip player set data source!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        List<ITPMediaTrackClip> b = b(iTPMediaAsset);
        if (com.tencent.thumbplayer.utils.b.a(b)) {
            throw new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
        }
        long n = n();
        try {
            this.k = b;
            this.n = true;
            if (com.tencent.thumbplayer.utils.b.a(this.o)) {
                this.o = new LinkedList<>();
            }
            this.o.offer(Long.valueOf(j));
            com.tencent.thumbplayer.e.a aVar = this.f25452a;
            aVar.c("try to switch definition with system clip player, current clipNo:" + this.l);
            d((int) n);
        } catch (Exception e) {
            this.f25452a.a(e);
            throw new IllegalStateException("exception when system clip player switch definition!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(com.tencent.thumbplayer.e.b bVar) {
        this.f25452a.a(new com.tencent.thumbplayer.e.b(bVar, "TPSystemClipPlayer"));
        g gVar = this.f;
        if (gVar == null || bVar == null) {
            return;
        }
        gVar.a(this.f25452a.a().a());
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i, long j) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map) {
        this.h.a(str, map);
        this.e.changeState(2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i, long j) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, String str3) {
        this.f25452a.e("addSubtitleSource not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        this.f25452a.e("addAudioTrackSource not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z) {
        if (this.i.a(3)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.a(z);
            }
            this.h.a(z);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z, long j, long j2) {
        if (this.i.a(3)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.a(z, j, j2);
            }
            this.h.a(z, j, j2);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long b(int i) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            return bVar.b(i);
        }
        return -1L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(float f) {
        if (this.i.a(3)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.b(f);
            }
            this.h.b(f);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(int i, long j) {
        this.f25452a.e("deselectTrack not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(boolean z) {
        if (this.i.a(3)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar != null) {
                bVar.b(z);
            }
            this.h.b(z);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPDynamicStatisticParams c(boolean z) {
        return null;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public String c(int i) {
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        return bVar != null ? bVar.c(i) : "";
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void c(int i, long j) {
        this.f25452a.e("selectProgram not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void f() {
        if (this.i.a(1)) {
            if (!this.h.f()) {
                throw new IOException("error , prepare , data source invalid");
            }
            com.tencent.thumbplayer.adapter.a.b e = e();
            this.d = e;
            if (e == null) {
                throw new RuntimeException("error , create player failed");
            }
            this.e.changeState(3);
            this.d.f();
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void g() {
        if (this.i.a(1)) {
            if (!this.h.f()) {
                throw new IllegalStateException("error , prepare , state invalid , data source invalid");
            }
            com.tencent.thumbplayer.adapter.a.b e = e();
            this.d = e;
            if (e == null) {
                throw new RuntimeException("error , create player failed");
            }
            this.e.changeState(3);
            this.d.g();
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void h() {
        if (this.i.a(5)) {
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
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void i() {
        if (this.i.a(6)) {
            com.tencent.thumbplayer.adapter.a.b bVar = this.d;
            if (bVar == null) {
                throw new IllegalStateException("error , pause , player is null");
            }
            try {
                bVar.i();
                this.e.changeState(6);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("error , pause ,state invalid");
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void j() {
        if (this.i.a(7)) {
            try {
                if (this.d == null) {
                    throw new IllegalStateException("error , stop , player is null");
                }
                try {
                    this.e.changeState(8);
                    this.d.j();
                    this.e.changeState(9);
                } catch (IllegalStateException e) {
                    throw new IllegalStateException("error , pause ,state invalid");
                }
            } catch (Throwable th) {
                this.e.changeState(9);
                throw th;
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void k() {
        com.tencent.thumbplayer.e.a aVar = this.f25452a;
        aVar.c("reset, current state:" + this.e);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.k();
        }
        this.h.a();
        this.f.d();
        this.e.changeState(1);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void l() {
        com.tencent.thumbplayer.e.a aVar = this.f25452a;
        aVar.c("release, current state:" + this.e);
        com.tencent.thumbplayer.adapter.a.b bVar = this.d;
        if (bVar != null) {
            bVar.l();
            this.d = null;
        }
        this.h.a();
        this.f.d();
        this.e.changeState(11);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long m() {
        Iterator<ITPMediaTrackClip> it = this.k.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().getOriginalDurationMs();
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long n() {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size() || i2 >= this.l) {
                break;
            }
            j += this.k.get(i2).getOriginalDurationMs();
            i = i2 + 1;
        }
        return !this.i.a(12) ? j : j + this.d.n();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long o() {
        if (this.i.a(15)) {
            return this.d.o();
        }
        com.tencent.thumbplayer.adapter.b bVar = this.j;
        if (bVar != null) {
            return bVar.k();
        }
        return 0L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int p() {
        com.tencent.thumbplayer.adapter.b bVar = this.j;
        if (bVar == null) {
            return 0;
        }
        if (bVar.a() <= 0) {
            if (!this.i.a(13)) {
                return 0;
            }
            this.j.a(this.d.p());
        }
        return (int) this.j.a();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int q() {
        com.tencent.thumbplayer.adapter.b bVar = this.j;
        if (bVar == null) {
            return 0;
        }
        if (bVar.b() <= 0) {
            if (!this.i.a(13)) {
                return 0;
            }
            this.j.b(this.d.q());
        }
        return (int) this.j.b();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPTrackInfo[] r() {
        this.f25452a.e("getTrackInfo not supported.");
        return new TPTrackInfo[0];
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPProgramInfo[] s() {
        this.f25452a.e("getProgramInfo not supported.");
        return new TPProgramInfo[0];
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long t() {
        return -1L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPGeneralPlayFlowParams u() {
        return null;
    }
}
