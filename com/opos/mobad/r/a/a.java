package com.opos.mobad.r.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.exoplayer.core.e.c;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.g.a;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.h.g;
import com.opos.exoplayer.core.h.k;
import com.opos.exoplayer.core.h.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.j;
import com.opos.exoplayer.core.p;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.x;
import com.opos.exoplayer.core.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/r/a/a.class */
class a implements q.b, com.opos.mobad.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private x f27231a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f27232c;
    private com.opos.exoplayer.a.a d;
    private com.opos.exoplayer.a.c e;
    private g.a f;
    private e g;
    private Context h;
    private com.opos.mobad.c.c.b i;
    private int j = 0;
    private long k = 0;
    private View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.r.a.a.3
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            com.opos.exoplayer.a.c cVar = a.this.e;
            if (cVar == null || cVar.isHardwareAccelerated()) {
                return;
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onViewAttachedToWindow switchSurfaceType");
            cVar.a(1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    public a(Context context, com.opos.mobad.c.c.b bVar) {
        this.h = context;
        this.i = bVar;
        j();
    }

    private void c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaSource path=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource path is null!!!");
            } else {
                this.g = new c.a(this.f).a(Uri.parse(str));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    private void j() {
        try {
            k();
            l();
            this.f = new m(this.h, u.a(this.h, this.h.getPackageName()));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    private void k() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayer");
        try {
            x a2 = j.a(this.h, new com.opos.exoplayer.core.g.c(new a.C0665a(new k())));
            this.f27231a = a2;
            a2.a(this);
            this.f27231a.a(true);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    private void l() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayerView");
        try {
            this.b = new RelativeLayout(this.h);
            com.opos.exoplayer.a.c cVar = new com.opos.exoplayer.a.c(this.h);
            this.e = cVar;
            cVar.addOnAttachStateChangeListener(this.l);
            this.e.b(0);
            this.e.a(false);
            this.e.a(this.f27231a);
            this.b.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
            com.opos.exoplayer.a.a aVar = new com.opos.exoplayer.a.a(this.h);
            this.d = aVar;
            aVar.a(0);
            ImageView imageView = new ImageView(this.h);
            this.f27232c = imageView;
            imageView.setVisibility(8);
            this.d.addView(this.f27232c, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.b.addView(this.d, layoutParams);
            this.f27231a.a().a(new com.opos.exoplayer.core.video.e() { // from class: com.opos.mobad.r.a.a.1
                @Override // com.opos.exoplayer.core.video.e
                public void a() {
                    com.opos.mobad.c.c.b bVar = a.this.i;
                    if (bVar != null) {
                        bVar.j();
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
                    if (r6 == 270) goto L19;
                 */
                @Override // com.opos.exoplayer.core.video.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(int r4, int r5, int r6, float r7) {
                    /*
                        r3 = this;
                        r0 = r5
                        if (r0 == 0) goto L15
                        r0 = r4
                        if (r0 == 0) goto L15
                        r0 = r4
                        float r0 = (float) r0
                        r1 = r7
                        float r0 = r0 * r1
                        r1 = r5
                        float r1 = (float) r1
                        float r0 = r0 / r1
                        r7 = r0
                        goto L18
                    L15:
                        r0 = 1065353216(0x3f800000, float:1.0)
                        r7 = r0
                    L18:
                        r0 = r3
                        com.opos.mobad.r.a.a r0 = com.opos.mobad.r.a.a.this
                        com.opos.exoplayer.a.c r0 = com.opos.mobad.r.a.a.a(r0)
                        r9 = r0
                        r0 = r9
                        if (r0 != 0) goto L2e
                        java.lang.String r0 = "ExoVideoPlayer"
                        java.lang.String r1 = "callback but playerView null"
                        com.opos.cmn.an.f.a.c(r0, r1)
                        return
                    L2e:
                        r0 = r9
                        android.view.View r0 = r0.b()
                        r9 = r0
                        r0 = r7
                        r8 = r0
                        r0 = r9
                        if (r0 == 0) goto L61
                        r0 = r7
                        r8 = r0
                        r0 = r9
                        boolean r0 = r0 instanceof android.view.TextureView
                        if (r0 == 0) goto L61
                        r0 = r6
                        r1 = 90
                        if (r0 == r1) goto L5b
                        r0 = r7
                        r8 = r0
                        r0 = r6
                        r1 = 270(0x10e, float:3.78E-43)
                        if (r0 != r1) goto L61
                    L5b:
                        r0 = 1065353216(0x3f800000, float:1.0)
                        r1 = r7
                        float r0 = r0 / r1
                        r8 = r0
                    L61:
                        r0 = r3
                        com.opos.mobad.r.a.a r0 = com.opos.mobad.r.a.a.this
                        com.opos.exoplayer.a.a r0 = com.opos.mobad.r.a.a.b(r0)
                        r1 = r8
                        r0.a(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.r.a.a.AnonymousClass1.a(int, int, int, float):void");
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    private void m() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "playVideo mCurrentState=" + this.j);
        try {
            if (this.g != null) {
                this.j = 1;
                this.f27231a.a(this.g);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    private void n() {
        this.f27232c.setVisibility(8);
    }

    private void o() {
        this.f27232c.setVisibility(0);
        this.f27232c.setImageBitmap(null);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.opos.exoplayer.a.c cVar = this.e;
            if (cVar == null) {
                return;
            }
            View b = cVar.b();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover");
            if (b != null) {
                if (b instanceof TextureView) {
                    this.f27232c.setImageBitmap(((TextureView) b).getBitmap());
                } else if ((b instanceof SurfaceView) && Build.VERSION.SDK_INT >= 25) {
                    final Bitmap createBitmap = Bitmap.createBitmap(((SurfaceView) b).getWidth(), ((SurfaceView) b).getHeight(), Bitmap.Config.ARGB_8888);
                    PixelCopy.request((SurfaceView) b, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.a.2
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i) {
                            a.this.f27232c.setImageBitmap(createBitmap);
                        }
                    }, ((SurfaceView) b).getHandler());
                }
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover end:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "show cover fail");
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(float f) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setVolume =" + f);
        this.f27231a.a(f);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRepeatModeChanged repeatMode=" + i);
    }

    @Override // com.opos.mobad.c.c.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "seekTo position=" + j);
        if (j >= 0) {
            try {
                this.f27231a.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTracksChanged trackGroups=");
        sb.append(mVar != null ? mVar.toString() : com.igexin.push.core.b.l);
        sb.append(",trackSelections=");
        String str = com.igexin.push.core.b.l;
        if (gVar != null) {
            str = gVar.toString();
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerError error=");
        sb.append(hVar != null ? hVar.toString() : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.d("ExoVideoPlayer", sb.toString(), hVar);
        try {
            this.j = -1;
            if (hVar == null) {
                if (this.i != null) {
                    this.i.a(-1, "unknown error.");
                }
            } else if (this.i != null) {
                com.opos.mobad.c.c.b bVar = this.i;
                int i = hVar.f25440a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cause:");
                sb2.append(hVar.getCause() != null ? hVar.getCause() : com.igexin.push.core.b.l);
                sb2.append(",message:");
                String str = com.igexin.push.core.b.l;
                if (hVar.getMessage() != null) {
                    str = hVar.getMessage();
                }
                sb2.append(str);
                bVar.a(i, sb2.toString());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(p pVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlaybackParametersChanged playbackParameters=");
        sb.append(pVar != null ? pVar.toString() : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(y yVar, Object obj, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTimelineChanged timeline=");
        sb.append(yVar != null ? yVar.toString() : com.igexin.push.core.b.l);
        sb.append(",manifest=");
        String str = com.igexin.push.core.b.l;
        if (obj != null) {
            str = obj.toString();
        }
        sb.append(str);
        sb.append(",reason=");
        sb.append(i);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.mobad.c.c.a
    public void a(com.opos.mobad.c.c.b bVar) {
        this.i = bVar;
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVideoPath path=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            c(str);
            m();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str, boolean z) {
        x xVar;
        int i;
        if (z) {
            xVar = this.f27231a;
            i = 2;
        } else {
            xVar = this.f27231a;
            i = 0;
        }
        xVar.a(i);
        a(str);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onLoadingChanged=" + z);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z, int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerStateChanged playWhenReady=" + z + ",playbackState=" + i);
        StringBuilder sb = new StringBuilder();
        sb.append("mCurrentState=");
        sb.append(this.j);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            if (i == 2) {
                if (z && 2 == this.j) {
                    this.k = d();
                    if (this.i != null) {
                        this.i.h();
                    }
                    this.j = 4;
                }
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.j = 5;
                o();
                if (this.i != null) {
                    this.i.e();
                }
            } else if (z) {
                if (1 == this.j) {
                    if (this.i != null) {
                        this.i.c();
                        this.i.d();
                    }
                } else if (4 == this.j && this.i != null) {
                    this.i.i();
                }
                this.j = 2;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public Bitmap b(String str) {
        com.opos.exoplayer.a.c cVar = this.e;
        if (cVar == null) {
            return null;
        }
        return c.a(cVar.b(), str);
    }

    @Override // com.opos.mobad.c.c.a
    public View b() {
        return this.b;
    }

    @Override // com.opos.exoplayer.core.q.b
    public void b(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPositionDiscontinuity reason=" + i);
    }

    @Override // com.opos.mobad.c.c.a
    public long c() {
        long j = 0;
        try {
            long l = this.f27231a.l();
            StringBuilder sb = new StringBuilder();
            sb.append("getDuration=");
            sb.append(l);
            j = l;
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
            return l;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
            return j;
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void c(int i) {
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setResizeMode=" + i);
            if (this.d != null) {
                this.d.a(i);
            }
            com.opos.exoplayer.a.c cVar = this.e;
            if (cVar != null) {
                cVar.b(i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public long d() {
        long j = 0;
        try {
            long m = this.f27231a.m();
            StringBuilder sb = new StringBuilder();
            sb.append("getCurrentPosition=");
            sb.append(m);
            j = m;
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
            return m;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
            return j;
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void d(int i) {
        com.opos.exoplayer.a.c cVar = this.e;
        if (cVar != null) {
            cVar.c(i);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void e() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "start mCurrentState=" + this.j);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void e_() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onSeekProcessed");
    }

    @Override // com.opos.mobad.c.c.a
    public void f() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "pauseVideo mCurrentState=" + this.j);
        try {
            if (1 == this.j || 2 == this.j || 4 == this.j) {
                o();
                this.f27231a.a(false);
                this.k = d();
                if (2 == this.j) {
                    this.j = 3;
                }
                if (this.i != null) {
                    this.i.g();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void g() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "resume mCurrentState=" + this.j);
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "mCurrentState=" + this.j);
            if (1 == this.j || 3 == this.j || 4 == this.j) {
                n();
                a(this.k);
                this.f27231a.a(true);
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "good");
                if (3 == this.j) {
                    this.j = 2;
                }
                if (this.i != null) {
                    this.i.f();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void h() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "releaseExoVideoPlayer mCurrentState=" + this.j);
        try {
            if (this.f27231a != null) {
                this.f27231a.f();
            }
            if (this.e != null) {
                this.e.removeOnAttachStateChangeListener(this.l);
                this.e = null;
            }
            this.b = null;
            if (this.g != null) {
                this.g = null;
            }
            if (this.f != null) {
                this.f = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ExoVideoPlayer", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public int i() {
        return this.j;
    }
}
