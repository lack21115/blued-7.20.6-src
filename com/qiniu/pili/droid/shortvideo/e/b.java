package com.qiniu.pili.droid.shortvideo.e;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/e/b.class */
public class b implements SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnCompletionListener, GLSurfaceView.Renderer {
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<GLSurfaceView> f13952a;
    private MediaPlayer b;

    /* renamed from: c  reason: collision with root package name */
    private int f13953c;
    private int d;
    private Surface g;
    private SurfaceTexture h;
    private int i;
    private String k;
    private com.qiniu.pili.droid.shortvideo.gl.c.a o;
    private PLVideoFilterListener q;
    private MediaPlayer.OnCompletionListener r;
    private volatile boolean t;
    private volatile boolean u;
    private int v;
    private int w;
    private volatile boolean x;
    private float e = 1.0f;
    private double f = 1.0d;
    private float[] j = new float[16];
    private boolean l = true;
    private boolean m = false;
    private long n = -1;
    private g p = new g();
    private PLDisplayMode s = PLDisplayMode.FIT;
    private int y = 0;
    private Object z = new Object();
    private Queue<Runnable> A = new LinkedList();

    public b(GLSurfaceView gLSurfaceView) {
        this.f13952a = new WeakReference<>(gLSurfaceView);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(this);
        gLSurfaceView.setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        synchronized (this.z) {
            if (this.b != null) {
                g gVar = new g();
                this.p = gVar;
                gVar.a(this.v, this.w);
                int i3 = i;
                if (i == 0) {
                    i3 = q() ? this.b.getVideoHeight() : this.b.getVideoWidth();
                }
                int i4 = i2;
                if (i2 == 0) {
                    i4 = q() ? this.b.getVideoWidth() : this.b.getVideoHeight();
                }
                this.p.a(i3, i4, this.s);
            }
        }
    }

    private void c(int i, int i2) {
        this.f13953c = i;
        this.d = i2;
        this.o.a(i, i2);
        e eVar = e.k;
        eVar.c("FilterVideoPlayer", "video size: " + i + "x" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.b.stop();
        this.b.release();
        this.b = null;
    }

    private void l() {
        this.i = d.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i);
        this.h = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
        this.o = aVar;
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        n();
        SurfaceTexture surfaceTexture = this.h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.h = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
            this.o = null;
        }
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.p.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (this.z) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.b = mediaPlayer;
            mediaPlayer.setOnCompletionListener(this);
            this.b.setSurface(p());
            this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.qiniu.pili.droid.shortvideo.e.b.5
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    if (b.this.B) {
                        b.this.b.seekTo(1);
                    }
                }
            });
            try {
                this.b.setDataSource(this.k);
                this.b.prepare();
                a(this.e);
                c(q() ? this.b.getVideoHeight() : this.b.getVideoWidth(), q() ? this.b.getVideoWidth() : this.b.getVideoHeight());
                this.n = -1L;
                if (this.u) {
                    this.u = false;
                    this.b.start();
                    a(this.f);
                }
            } catch (Exception e) {
                e.k.e("FilterVideoPlayer", "init or start media player failed, set to null.");
                this.b = null;
            }
        }
    }

    private Surface p() {
        if (this.g == null && this.h != null) {
            this.g = new Surface(this.h);
        }
        return this.g;
    }

    private boolean q() {
        int i = this.y;
        return i == 90 || i == 270;
    }

    public void a() {
        e.k.c("FilterVideoPlayer", "start +");
        if (this.x) {
            d();
        }
        synchronized (this.z) {
            if (this.b != null) {
                if (this.b.isPlaying()) {
                    e.k.d("FilterVideoPlayer", "already started !");
                } else {
                    this.b.start();
                }
                return;
            }
            this.u = true;
            GLSurfaceView gLSurfaceView = this.f13952a.get();
            if (gLSurfaceView == null) {
                e.k.d("FilterVideoPlayer", "glSurfaceView released !");
                return;
            }
            gLSurfaceView.onResume();
            e.k.c("FilterVideoPlayer", "start -");
        }
    }

    public void a(double d) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = new PlaybackParams();
            playbackParams.setSpeed((float) d);
            try {
                this.b.setPlaybackParams(playbackParams);
                this.f = d;
            } catch (Exception e) {
                e eVar = e.k;
                eVar.e("FilterVideoPlayer", "the player can't support this params : speed is " + d);
                e.k.e("FilterVideoPlayer", e.getMessage());
            }
            e eVar2 = e.k;
            eVar2.c("FilterVideoPlayer", "setSpeed " + d);
        }
    }

    public void a(float f) {
        synchronized (this.z) {
            this.e = f;
            if (this.b == null) {
                e.k.d("FilterVideoPlayer", "not playing !");
                return;
            }
            this.b.setVolume(f, f);
            e eVar = e.k;
            eVar.b("FilterVideoPlayer", "set volume: " + f);
        }
    }

    public void a(int i) {
        this.y = i;
        int videoHeight = q() ? this.b.getVideoHeight() : this.b.getVideoWidth();
        int videoWidth = q() ? this.b.getVideoWidth() : this.b.getVideoHeight();
        f();
        a(videoHeight, videoWidth);
        a();
    }

    public void a(final int i, final int i2) {
        this.A.add(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.e.b.4
            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.k;
                eVar.c("FilterVideoPlayer", "content resize width: " + i + " height: " + i2);
                b.this.n();
                b.this.b(i, i2);
            }
        });
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.r = onCompletionListener;
    }

    public void a(PLDisplayMode pLDisplayMode) {
        this.s = pLDisplayMode;
    }

    public void a(PLVideoFilterListener pLVideoFilterListener) {
        this.q = pLVideoFilterListener;
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public void b() {
        e.k.c("FilterVideoPlayer", "pause +");
        synchronized (this.z) {
            if (this.b != null && this.b.isPlaying()) {
                this.b.pause();
                e.k.c("FilterVideoPlayer", "pause -");
                return;
            }
            e.k.d("FilterVideoPlayer", "not playing !");
        }
    }

    public void b(int i) {
        e.k.c("FilterVideoPlayer", "seekTo +");
        synchronized (this.z) {
            if (this.b == null) {
                e.k.d("FilterVideoPlayer", "not playing !");
                return;
            }
            this.m = true;
            if (Build.VERSION.SDK_INT < 26) {
                this.b.seekTo(i);
            } else {
                this.b.seekTo(i, 3);
            }
            e.k.c("FilterVideoPlayer", "seekTo -");
        }
    }

    public void b(String str) {
        e.k.c("FilterVideoPlayer", "resetDataSource");
        this.k = str;
        synchronized (this.z) {
            if (this.b != null) {
                if (this.b.isPlaying()) {
                    this.b.stop();
                }
                this.b.reset();
                try {
                    this.b.setDataSource(this.k);
                    this.b.prepare();
                    this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.qiniu.pili.droid.shortvideo.e.b.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            b.this.a(0, 0);
                            if (b.this.B) {
                                b.this.b.seekTo(1);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.k.e("FilterVideoPlayer", "reset data source error !");
                }
            }
        }
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c() {
        e.k.c("FilterVideoPlayer", "resume +");
        synchronized (this.z) {
            if (this.b != null && !this.b.isPlaying()) {
                this.b.start();
                e.k.c("FilterVideoPlayer", "resume -");
                return;
            }
            e.k.d("FilterVideoPlayer", "not in pause state !");
        }
    }

    public void d() {
        e.k.c("FilterVideoPlayer", "startMediaPlayer");
        GLSurfaceView gLSurfaceView = this.f13952a.get();
        if (gLSurfaceView == null) {
            e.k.d("FilterVideoPlayer", "glSurfaceView released !");
        } else {
            gLSurfaceView.queueEvent(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.h != null) {
                        b.this.h.release();
                        b.this.h = null;
                    }
                    if (b.this.g != null) {
                        b.this.g.release();
                        b.this.g = null;
                    }
                    b.this.i = d.c();
                    b.this.h = new SurfaceTexture(b.this.i);
                    b.this.h.setOnFrameAvailableListener(b.this);
                    b.this.g = new Surface(b.this.h);
                    b.this.u = true;
                    synchronized (b.this.z) {
                        if (b.this.b != null) {
                            b.this.k();
                        }
                        b.this.o();
                    }
                    b.this.x = false;
                }
            });
        }
    }

    public void e() {
        e.k.c("FilterVideoPlayer", "stopMediaPlayer");
        synchronized (this.z) {
            if (this.b != null) {
                k();
                this.x = true;
            }
        }
    }

    public void f() {
        e.k.c("FilterVideoPlayer", "stop +");
        GLSurfaceView gLSurfaceView = this.f13952a.get();
        if (this.x) {
            this.x = false;
        } else {
            synchronized (this.z) {
                if (this.b == null || gLSurfaceView == null) {
                    return;
                }
                k();
            }
        }
        this.f13953c = 0;
        this.d = 0;
        gLSurfaceView.queueEvent(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.e.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.m();
                if (b.this.q != null) {
                    b.this.q.onSurfaceDestroy();
                }
            }
        });
        gLSurfaceView.onPause();
        e.k.c("FilterVideoPlayer", "stop -");
    }

    public int g() {
        return this.p.l();
    }

    public int h() {
        return this.p.m();
    }

    public int i() {
        synchronized (this.z) {
            if (this.b == null) {
                e.k.d("FilterVideoPlayer", "not playing !");
                return -1;
            }
            return this.b.getCurrentPosition();
        }
    }

    public float j() {
        return this.e;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.m = true;
        synchronized (this.z) {
            if (this.l && this.b != null) {
                this.b.start();
            }
        }
        MediaPlayer.OnCompletionListener onCompletionListener = this.r;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            this.h.updateTexImage();
            long timestamp = this.h.getTimestamp();
            int i = 0;
            if (timestamp < this.n) {
                if (!this.m) {
                    e.k.d("FilterVideoPlayer", "timestamp, this frame: " + timestamp + " smaller than last frame: " + this.n + ", dropped.");
                    return;
                }
                this.m = false;
            }
            this.n = timestamp;
            this.h.getTransformMatrix(this.j);
            if (this.t) {
                PLVideoFilterListener pLVideoFilterListener = this.q;
                if (pLVideoFilterListener != null) {
                    i = pLVideoFilterListener.onDrawFrame(this.i, this.f13953c, this.d, timestamp, this.j);
                }
            } else {
                int c2 = this.o.c(this.i, this.j, this.y);
                PLVideoFilterListener pLVideoFilterListener2 = this.q;
                i = c2;
                if (pLVideoFilterListener2 != null) {
                    i = pLVideoFilterListener2.onDrawFrame(c2, this.f13953c, this.d, timestamp, d.f);
                }
            }
            while (!this.A.isEmpty()) {
                this.A.remove().run();
            }
            GLES20.glClear(16384);
            this.p.b(i);
        } catch (Exception e) {
            e.k.e("FilterVideoPlayer", "update surface texture failed !!!");
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        GLSurfaceView gLSurfaceView = this.f13952a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        e eVar = e.k;
        eVar.c("FilterVideoPlayer", "onSurfaceChanged width:" + i + " height:" + i2);
        this.v = i;
        this.w = i2;
        n();
        b(0, 0);
        PLVideoFilterListener pLVideoFilterListener = this.q;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceChanged(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        e.k.c("FilterVideoPlayer", "onSurfaceCreated");
        this.n = -1L;
        l();
        o();
        PLVideoFilterListener pLVideoFilterListener = this.q;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceCreated();
        }
    }
}
