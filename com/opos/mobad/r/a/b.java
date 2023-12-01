package com.opos.mobad.r.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.cmn.j.a;
import com.opos.libs.a.a;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/r/a/b.class */
public class b implements com.opos.mobad.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27236a;
    private com.opos.mobad.c.c.b b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f27237c;
    private RelativeLayout d;
    private View e;
    private com.opos.libs.a.a f;
    private com.opos.exoplayer.a.a g;
    private float h;
    private SurfaceView i;
    private TextureView j;
    private Surface k;
    private ImageView l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Handler q;

    public b(Context context, com.opos.mobad.c.c.b bVar) {
        this(context, bVar, true);
    }

    public b(Context context, com.opos.mobad.c.c.b bVar, boolean z) {
        this.h = 1.0f;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.r.a.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.opos.mobad.c.c.b bVar2;
                int i = message.what;
                if (i == 1) {
                    b.this.m = true;
                    b.this.f.a(1);
                    if (b.this.b != null) {
                        b.this.b.c();
                    }
                } else if (i != 2) {
                    if (i == 3) {
                        if (b.this.b != null) {
                            b.this.b.h();
                            return;
                        }
                        return;
                    } else if (i == 4) {
                        if (b.this.b != null) {
                            b.this.b.i();
                            return;
                        }
                        return;
                    } else if (i == 5 && (bVar2 = b.this.b) != null) {
                        bVar2.j();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.p();
            }
        };
        this.f27236a = context;
        this.b = bVar;
        this.n = z;
        a();
        this.f = new a.C0668a(0).a(0, 7, 6).a(7, 1, 3, 2, 0, 6).a(1, 3, 2, 5, 0, 6).a(2, 3, 5, 0, 6).a(3, 2, 0, 6).a(5, 2, 0, 6).a();
    }

    private void a() {
        this.d = new RelativeLayout(this.f27236a);
        View view = new View(this.f27236a);
        this.e = view;
        view.setBackgroundColor(-16777216);
        this.d.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        this.g = new com.opos.exoplayer.a.a(this.f27236a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.d.addView(this.g, layoutParams);
        this.g.setId(View.generateViewId());
        this.l = new ImageView(this.f27236a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, this.g.getId());
        layoutParams2.addRule(8, this.g.getId());
        layoutParams2.addRule(7, this.g.getId());
        layoutParams2.addRule(5, this.g.getId());
        this.d.addView(this.l, layoutParams2);
        this.l.setVisibility(8);
        com.opos.cmn.j.a aVar = new com.opos.cmn.j.a(this.f27236a);
        this.d.addView(aVar, new ViewGroup.LayoutParams(0, 0));
        aVar.a(new a.InterfaceC0646a() { // from class: com.opos.mobad.r.a.b.11
            @Override // com.opos.cmn.j.a.InterfaceC0646a
            public void a() {
            }

            @Override // com.opos.cmn.j.a.InterfaceC0646a
            public void b() {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "view attach to window");
                if (b.this.f.a() == 6 || b.this.d.isHardwareAccelerated()) {
                    return;
                }
                b.this.k();
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.g.a(i / i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface) {
        if (this.f.a() == 6) {
            return;
        }
        this.k = surface;
        this.q.obtainMessage(2).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) throws Exception {
        this.m = false;
        MediaPlayer mediaPlayer = this.f27237c;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        } else {
            this.f27237c = new MediaPlayer();
        }
        this.f27237c.setDataSource(this.f27236a, Uri.parse(str), (Map<String, String>) null);
        this.f27237c.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.opos.mobad.r.a.b.6
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                b.this.a(i, i2);
            }
        });
        this.f27237c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.opos.mobad.r.a.b.7
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                b.this.f.a(5);
                b.this.m();
                if (b.this.b != null) {
                    b.this.b.e();
                }
            }
        });
        this.f27237c.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.opos.mobad.r.a.b.8
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play fail:" + i + "," + i2 + ",state:" + b.this.f.a());
                if (-38 == i) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "ignore error");
                    return true;
                } else if (b.this.f.a() == 0 || 6 == b.this.f.a()) {
                    return true;
                } else {
                    b.this.f.a(0);
                    if (b.this.b != null) {
                        com.opos.mobad.c.c.b bVar = b.this.b;
                        bVar.a(2, "code:" + i + ",extra:" + i2);
                        return true;
                    }
                    return true;
                }
            }
        });
        this.f27237c.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.opos.mobad.r.a.b.9
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                Handler handler;
                int i3;
                Message message;
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play info:" + i + "," + i2);
                if (i == 3) {
                    handler = b.this.q;
                    i3 = 5;
                } else if (i == 701) {
                    message = b.this.q.obtainMessage(3);
                    message.sendToTarget();
                    return false;
                } else if (i != 702) {
                    return false;
                } else {
                    handler = b.this.q;
                    i3 = 4;
                }
                message = handler.obtainMessage(i3);
                message.sendToTarget();
                return false;
            }
        });
        this.f27237c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.opos.mobad.r.a.b.10
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "player prepared duration:" + mediaPlayer2.getDuration() + "," + b.this.k);
                b.this.a(mediaPlayer2.getVideoWidth(), mediaPlayer2.getVideoHeight());
                b.this.q.obtainMessage(1).sendToTarget();
            }
        });
        MediaPlayer mediaPlayer2 = this.f27237c;
        float f = this.h;
        mediaPlayer2.setVolume(f, f);
        if (this.o) {
            this.f27237c.setLooping(true);
        }
        this.f27237c.prepareAsync();
    }

    private void j() {
        TextureView textureView = new TextureView(this.f27236a);
        this.j = textureView;
        this.g.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        this.j.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.opos.mobad.r.a.b.12
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureAvailable");
                b.this.a(new Surface(surfaceTexture));
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureDestroyed");
                b.this.n();
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "reset surface");
        this.g.removeAllViews();
        if (this.k != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            this.k.release();
        }
        this.j = null;
        SurfaceView surfaceView = new SurfaceView(this.f27236a);
        this.i = surfaceView;
        this.g.addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        this.i.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.opos.mobad.r.a.b.13
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceCreated");
                b.this.a(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceDestroyed");
                b.this.n();
            }
        });
    }

    private void l() {
        this.l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l.setVisibility(0);
        this.l.setImageBitmap(null);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover");
            if (this.j != null) {
                this.l.setImageBitmap(this.j.getBitmap());
            } else if (this.i != null && Build.VERSION.SDK_INT >= 25) {
                final Bitmap createBitmap = Bitmap.createBitmap(this.i.getWidth(), this.i.getHeight(), Bitmap.Config.ARGB_8888);
                PixelCopy.request(this.i, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.b.16
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public void onPixelCopyFinished(int i) {
                        b.this.l.setImageBitmap(createBitmap);
                    }
                }, this.i.getHandler());
            }
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover end:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Surface surface = this.k;
        if (surface != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            surface.release();
        }
        this.k = null;
    }

    private void o() {
        this.f.a(0, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (b.this.f27237c != null) {
                    b.this.f27237c.reset();
                    b.this.f27237c = null;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start :" + this.f.a());
        if (this.f.a() == 2) {
            if (q()) {
                this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.p = true;
                        if (b.this.b != null) {
                            b.this.b.d();
                        }
                    }
                });
            }
        } else if (this.f.a() == 1 && this.n) {
            this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    boolean z;
                    if (b.this.q()) {
                        b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.p = true;
                                if (b.this.b != null) {
                                    b.this.b.d();
                                }
                            }
                        });
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.k == null || !this.m) {
            return false;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "check to start");
        this.f27237c.setSurface(this.k);
        this.f27237c.start();
        this.e.setVisibility(8);
        l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k == null || !this.m) {
            return;
        }
        this.f27237c.pause();
    }

    @Override // com.opos.mobad.c.c.a
    public void a(float f) {
        this.h = f;
        MediaPlayer mediaPlayer = this.f27237c;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "seekTo");
        int a2 = this.f.a();
        if (2 == a2 || 4 == a2 || 3 == a2 || 5 == a2) {
            this.f27237c.seekTo((int) j);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(com.opos.mobad.c.c.b bVar) {
        this.b = bVar;
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str) {
        a(str, false);
    }

    @Override // com.opos.mobad.c.c.a
    public void a(final String str, boolean z) {
        this.o = z;
        o();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start video path:" + str);
        this.f.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                boolean z2;
                try {
                    b.this.c(str);
                    z2 = true;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "init fail", e);
                    if (b.this.b != null) {
                        b.this.b.a(-1, "");
                    }
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public Bitmap b(String str) {
        KeyEvent.Callback callback = this.j;
        if (callback == null) {
            callback = this.i;
        }
        return c.a(callback, str);
    }

    @Override // com.opos.mobad.c.c.a
    public View b() {
        return this.d;
    }

    @Override // com.opos.mobad.c.c.a
    public long c() {
        MediaPlayer mediaPlayer = this.f27237c;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.opos.mobad.c.c.a
    public void c(int i) {
        this.g.a(i);
    }

    @Override // com.opos.mobad.c.c.a
    public long d() {
        if (this.f27237c != null) {
            return this.f.a() == 5 ? this.f27237c.getDuration() : this.f27237c.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.opos.mobad.c.c.a
    public void d(int i) {
        this.e.setBackgroundColor(i);
    }

    @Override // com.opos.mobad.c.c.a
    public void e() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start");
        this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.14
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.q();
                return true;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void f() {
        this.f.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.15
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.r();
                b.this.m();
                b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.b != null) {
                            b.this.b.g();
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void g() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "resume");
        this.f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.17
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.q();
                b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.b != null) {
                            if (!b.this.p) {
                                b.this.p = true;
                                b.this.b.d();
                            }
                            b.this.b.f();
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void h() {
        this.f.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.18
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (b.this.f27237c != null) {
                    b.this.f27237c.release();
                    b.this.f27237c = null;
                }
                b.this.n();
                return true;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public int i() {
        return this.f.a();
    }
}
