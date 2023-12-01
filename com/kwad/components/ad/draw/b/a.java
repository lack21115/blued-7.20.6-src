package com.kwad.components.ad.draw.b;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/b/a.class */
public final class a extends com.kwad.components.ad.h.a {
    private long dh;
    private com.kwad.sdk.contentalliance.kwai.kwai.a di;
    private boolean dj;
    private final c dk;
    private Context mContext;
    private b mViewVisibleHelper;

    public a(AdTemplate adTemplate, b bVar, DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.dk = new c() { // from class: com.kwad.components.ad.draw.b.a.2
            @Override // com.kwad.sdk.core.g.c
            public final void onPageInvisible() {
                a.this.pause();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void onPageVisible() {
                if (a.this.di == null) {
                    a aVar = a.this;
                    aVar.di = com.kwad.sdk.contentalliance.kwai.kwai.a.ak(aVar.mAdTemplate);
                    a.this.Gj.a(a.this.di);
                }
                if (a.this.dj) {
                    return;
                }
                a.this.resume();
            }
        };
        this.dh = com.kwad.sdk.core.response.a.a.S(d.cb(this.mAdTemplate));
        this.mViewVisibleHelper = bVar;
        this.mContext = detailVideoView.getContext();
        aT();
        this.Gj.a(new c.e() { // from class: com.kwad.components.ad.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                a.this.start(l.cx(a.this.mAdTemplate));
            }
        });
    }

    private void aT() {
        this.Gj.a(new b.a(this.mAdTemplate).bs(d.cd(this.mAdTemplate)).bt(f.b(d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).tR(), this.mDetailVideoView);
        this.Gj.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.mViewVisibleHelper.et()) {
            this.Gj.a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, j));
            this.Gj.start();
        }
    }

    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.c(iVar);
    }

    public final void aR() {
        long cx = l.cx(this.mAdTemplate);
        if (this.Gj.qe() == null) {
            aT();
        }
        start(cx);
        this.mViewVisibleHelper.a(this.dk);
    }

    public final void aS() {
        this.di = null;
        this.mViewVisibleHelper.b(this.dk);
        this.Gj.release();
    }

    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.d(iVar);
    }

    public final void f(boolean z) {
        this.dj = z;
    }

    public final void pause() {
        this.Gj.pause();
    }

    @Override // com.kwad.components.ad.h.a
    public final void release() {
        super.release();
        if (this.Gj != null) {
            this.Gj.clear();
            this.Gj.release();
        }
    }

    public final void resume() {
        this.Gj.resume();
        com.kwad.components.core.r.a.aj(this.mContext).aL(false);
    }
}
