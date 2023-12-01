package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.aw;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/b.class */
public class b {
    private static final int B = 20;
    private static final int C = 805;
    private static final int F = 2;
    private static final String I = "MediaPlayerAgent";
    private static final int L = 100;
    private static final int S = 300;
    private static final int Z = -10000;

    /* renamed from: a  reason: collision with root package name */
    private static final int f22988a = 0;
    private static final String b = "progress_task";

    /* renamed from: c  reason: collision with root package name */
    private static final int f22989c = 100;
    private static final int d = 200;
    private static final int e = 0;
    private Object A;
    private MediaPlayer D;
    private WeakReference<Surface> E;
    private int G;
    private Context J;
    private volatile String h;
    private boolean i;
    private int n;
    private int o;
    private AudioManager u;
    private static final String Code = "thread_media_player_ctrl";
    private static final s V = new s(Code);
    private int f = 0;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m = 0;
    private final c p = new c();
    private final byte[] q = new byte[0];
    private final byte[] r = new byte[0];
    private final byte[] s = new byte[0];
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private boolean y = false;
    private volatile int z = 0;
    private boolean H = false;
    private final CopyOnWriteArraySet<gr> K = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gn> M = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<go> N = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gs> O = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gp> P = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<MediaPlayer.OnVideoSizeChangedListener> Q = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gt> R = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gq> T = new CopyOnWriteArraySet<>();
    private final MediaPlayer.OnVideoSizeChangedListener U = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.huawei.openalliance.ad.media.b.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b.this.Code(mediaPlayer, i, i2);
        }
    };
    private MediaPlayer.OnCompletionListener W = new MediaPlayer.OnCompletionListener() { // from class: com.huawei.openalliance.ad.media.b.12
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (b.this.p.Code(e.ERROR) || b.this.p.Code(e.PLAYBACK_COMPLETED)) {
                return;
            }
            b.this.p.I(e.PLAYBACK_COMPLETED);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int k = b.this.k();
            ge.V(b.I, "onCompletion " + currentPosition + " duration: " + k);
            int max = Math.max(currentPosition, k);
            b.this.V(100, max);
            b.this.B(max);
            b.this.t();
            b.F(b.this.g);
            b.this.m = 0;
            b.this.t = 0;
        }
    };
    private MediaPlayer.OnInfoListener X = new MediaPlayer.OnInfoListener() { // from class: com.huawei.openalliance.ad.media.b.23
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            ge.V(b.I, "onInfo what: %d extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 3) {
                b.this.r();
            } else if (i == b.C) {
                b.this.a(i2);
                return true;
            } else if (i == 701) {
                b.this.q();
                return true;
            } else if (i != 702) {
                return true;
            }
            b.this.t();
            return true;
        }
    };
    private MediaPlayer.OnPreparedListener Y = new MediaPlayer.OnPreparedListener() { // from class: com.huawei.openalliance.ad.media.b.34
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            ge.V(b.I, "onPrepared");
            b.this.k = false;
            mediaPlayer.setOnInfoListener(b.this.X);
            if (b.this.l || b.this.p.V(e.PREPARING)) {
                b.this.p.I(e.PREPARED);
                b bVar = b.this;
                bVar.L(bVar.k());
                return;
            }
            try {
                b.this.p.I(e.PREPARED);
                mediaPlayer.start();
                b.V(mediaPlayer, b.this.o, 3);
                b.this.p.I(e.PLAYING);
                if (ge.Code()) {
                    ge.Code(b.I, "seek to prefer pos: %d", Integer.valueOf(b.this.o));
                }
                b.this.S(mediaPlayer.getCurrentPosition());
                b.this.L(b.this.k());
                b.this.w();
            } catch (IllegalStateException e2) {
                ge.I(b.I, "onPrepared - IllegalStateException");
                b.this.p.I(e.ERROR);
                b.this.Code(0, -1, -1);
            }
        }
    };
    private MediaPlayer.OnErrorListener aa = new MediaPlayer.OnErrorListener() { // from class: com.huawei.openalliance.ad.media.b.38
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            ge.I(b.I, "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i), Integer.valueOf(i2), b.this.p, b.this);
            b.this.t();
            if (b.this.p.Code(e.ERROR)) {
                return true;
            }
            b.this.p.I(e.ERROR);
            b.this.Code(mediaPlayer.getCurrentPosition(), i, i2);
            return true;
        }
    };
    private MediaPlayer.OnBufferingUpdateListener ab = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.huawei.openalliance.ad.media.b.39
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.this.p.Code()) {
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                int i3 = i2;
                if (i2 > 100) {
                    i3 = 100;
                }
                b.this.C(i3);
            }
        }
    };
    private Callable<Boolean> ac = new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.media.b.7
        @Override // java.util.concurrent.Callable
        /* renamed from: Code */
        public Boolean call() {
            return Boolean.valueOf(b.this.m());
        }
    };
    private Runnable ad = new Runnable() { // from class: com.huawei.openalliance.ad.media.b.30
        @Override // java.lang.Runnable
        public void run() {
            int k;
            b.F(b.this.g);
            if (b.this.p.V(e.PREPARING) && b.this.p.V(e.PLAYING) && b.this.p.V(e.PREPARED)) {
                return;
            }
            int B2 = b.this.B();
            if (b.this.K.size() > 0 && (k = b.this.k()) > 0) {
                int ceil = (int) Math.ceil((B2 * 100.0f) / k);
                int i = ceil;
                if (ceil > 100) {
                    i = 100;
                }
                b.this.V(i, B2);
                if (B2 == k) {
                    b.p(b.this);
                    if (b.this.t > 2) {
                        ge.Code(b.I, "reach end count exceeds");
                        b.this.W.onCompletion(b.this.f());
                        return;
                    }
                }
            }
            if (b.this.i && b.this.M.size() > 0 && b.this.t == 0) {
                if (Math.abs(B2 - b.this.m) < 100) {
                    b.this.q();
                } else {
                    b.this.t();
                    b.this.m = B2;
                }
            }
            b.V(b.this.ad, b.this.g, 200L);
        }
    };
    private AudioManager.OnAudioFocusChangeListener ae = new AudioManager.OnAudioFocusChangeListener() { // from class: com.huawei.openalliance.ad.media.b.36
        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            if (b.this.H) {
                ge.V(b.I, "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + b.this.H);
                V();
                return;
            }
            boolean m = b.this.m();
            ge.V(b.I, "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(m));
            if (m) {
                b.this.Z();
                b.this.v = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            ge.V(b.I, "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + b.this.H);
            if (b.this.H) {
                if (b.this.w) {
                    b.this.p();
                }
            } else if (b.this.x == -2 || b.this.x == -1) {
                if (b.this.v) {
                    b.this.g();
                    b.this.v = false;
                }
            } else if (b.this.x == -3 && b.this.w) {
                b.this.p();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V() {
            ge.V(b.I, "handleAudioFocusLossTransientCanDuck soundMuted: " + b.this.y);
            if (b.this.y) {
                return;
            }
            b.this.o();
            b.this.w = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            b.V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.36.1
                @Override // java.lang.Runnable
                public void run() {
                    ge.V(b.I, "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(b.this.x));
                    int i2 = i;
                    if (i2 == -3) {
                        V();
                    } else if (i2 == -2 || i2 == -1) {
                        Code();
                    } else if (i2 == 1 || i2 == 2) {
                        I();
                    }
                    b.this.x = i;
                }
            });
        }
    };
    private String g = b + hashCode();

    public b(Context context) {
        this.J = context.getApplicationContext();
        this.u = (AudioManager) context.getSystemService("audio");
        V.Code();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        String str;
        try {
            try {
                ge.V(I, "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.u.abandonAudioFocus(this.ae);
                } else {
                    if (this.A instanceof AudioFocusRequest) {
                        this.u.abandonAudioFocusRequest((AudioFocusRequest) this.A);
                    }
                    this.A = null;
                }
            } catch (IllegalStateException e2) {
                str = "abandonAudioFocus IllegalStateException";
                ge.I(I, str);
            } catch (Exception e3) {
                str = "abandonAudioFocus " + e3.getClass().getSimpleName();
                ge.I(I, str);
            }
        } finally {
            this.w = false;
            this.v = false;
            this.x = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i) {
        ge.V(I, "notifyMediaCompletion playTime: %d", Integer.valueOf(i));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.15
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.K.iterator();
                while (it.hasNext()) {
                    gr grVar = (gr) it.next();
                    if (grVar != null) {
                        grVar.Z(b.this, i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final int i) {
        if (this.i) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.16
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = b.this.M.iterator();
                    while (it.hasNext()) {
                        gn gnVar = (gn) it.next();
                        if (gnVar != null) {
                            gnVar.Code(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.END
            boolean r0 = r0.Code(r1)
            if (r0 == 0) goto Le
            return
        Le:
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "setMediaFileUrl: %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.String r5 = com.huawei.openalliance.ad.utils.bc.Code(r5)
            r3[r4] = r5
            com.huawei.hms.ads.ge.Code(r0, r1, r2)
            r0 = r7
            android.media.MediaPlayer r0 = r0.f()
            r9 = r0
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p     // Catch: java.lang.Throwable -> L45 java.lang.IllegalStateException -> Lcc
            boolean r0 = r0.Code()     // Catch: java.lang.Throwable -> L45 java.lang.IllegalStateException -> Lcc
            if (r0 == 0) goto L34
            r0 = r9
            r0.stop()     // Catch: java.lang.Throwable -> L45 java.lang.IllegalStateException -> Lcc
        L34:
            r0 = r9
            r0.reset()
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.IDLE
            r0.I(r1)
            goto L6a
        L45:
            r10 = move-exception
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "setMediaFileUrl exception: %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lbb
            r3 = r2
            r4 = 0
            r5 = r10
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = r5.getSimpleName()     // Catch: java.lang.Throwable -> Lbb
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lbb
            com.huawei.hms.ads.ge.I(r0, r1, r2)     // Catch: java.lang.Throwable -> Lbb
            goto L34
        L5f:
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "setMediaFileUrl stop IllegalStateException"
            com.huawei.hms.ads.ge.I(r0, r1)     // Catch: java.lang.Throwable -> Lbb
            goto L34
        L6a:
            r0 = r7
            r1 = 0
            r0.G = r1
            r0 = r7
            r1 = r8
            r0.h = r1
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L9e
            r0 = r7
            r1 = r8
            r0.S(r1)     // Catch: java.lang.Exception -> Ld0
            return
        L81:
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "setMediaFileUrl Exception"
            com.huawei.hms.ads.ge.I(r0, r1)
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.ERROR
            r0.I(r1)
            com.huawei.hms.ads.ez r0 = new com.huawei.hms.ads.ez
            r1 = r0
            java.lang.String r2 = "setMediaFileUrl Exception"
            r1.<init>(r2)
            throw r0
        L9e:
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "media file url is empty"
            com.huawei.hms.ads.ge.I(r0, r1)
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.ERROR
            r0.I(r1)
            com.huawei.hms.ads.ez r0 = new com.huawei.hms.ads.ez
            r1 = r0
            java.lang.String r2 = "media file url is empty"
            r1.<init>(r2)
            throw r0
        Lbb:
            r8 = move-exception
            r0 = r9
            r0.reset()
            r0 = r7
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.IDLE
            r0.I(r1)
            r0 = r8
            throw r0
        Lcc:
            r10 = move-exception
            goto L5f
        Ld0:
            r8 = move-exception
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.media.b.C(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i, final int i2, final int i3) {
        ge.V(I, "notifyError playTime: %d", Integer.valueOf(i));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.25
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.N.iterator();
                while (it.hasNext()) {
                    go goVar = (go) it.next();
                    if (goVar != null) {
                        goVar.Code(b.this, i, i2, i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayer mediaPlayer, int i, int i2) {
        Iterator<MediaPlayer.OnVideoSizeChangedListener> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(mediaPlayer, i, i2);
        }
    }

    private void D(final int i) {
        ge.V(I, "notifyMediaPause playTime: %d", Integer.valueOf(i));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.24
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.K.iterator();
                while (it.hasNext()) {
                    gr grVar = (gr) it.next();
                    if (grVar != null) {
                        grVar.V(b.this, i);
                    }
                }
            }
        });
    }

    private boolean E() {
        ge.V(I, "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.z), Boolean.valueOf(this.y));
        if (this.z == 0) {
            return true;
        }
        if (this.z == 2) {
            return false;
        }
        return (this.z == 1 && this.y) ? false : true;
    }

    private void F(final int i) {
        ge.V(I, "notifyMediaStop playTime: %d", Integer.valueOf(i));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.22
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.K.iterator();
                while (it.hasNext()) {
                    gr grVar = (gr) it.next();
                    if (grVar != null) {
                        grVar.I(b.this, i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str) {
        V.Code(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(float f) {
        if (this.p.Code(e.END)) {
            return false;
        }
        try {
            f().setVolume(f, f);
            return true;
        } catch (IllegalStateException e2) {
            ge.I(I, "mute IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final int i) {
        ge.V(I, "notifyDurationReady: %d", Integer.valueOf(i));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.28
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.P.iterator();
                while (it.hasNext()) {
                    gp gpVar = (gp) it.next();
                    if (gpVar != null) {
                        gpVar.Code(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i) {
        ge.V(I, "notifyMediaStart playTime: %d", Integer.valueOf(i));
        z();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.21
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.K.iterator();
                while (it.hasNext()) {
                    gr grVar = (gr) it.next();
                    if (grVar != null) {
                        grVar.Code(b.this, i);
                    }
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
        if (r5.startsWith(com.huawei.openalliance.ad.constant.bm.HTTPS.toString()) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void S(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L8
            return
        L8:
            r0 = r4
            android.media.MediaPlayer r0 = r0.f()
            r7 = r0
            r0 = r5
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r0 = r0.getScheme()
            if (r0 != 0) goto L21
            r0 = r5
            r6 = r0
        L19:
            r0 = r7
            r1 = r6
            r0.setDataSource(r1)
            goto L8e
        L21:
            r0 = r5
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.FILE
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L3f
            r0 = r5
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.FILE
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            java.lang.String r0 = r0.substring(r1)
            r6 = r0
            goto L19
        L3f:
            r0 = r5
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.CONTENT
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L68
            r0 = r4
            r1 = r5
            r2 = r7
            boolean r0 = r0.Code(r1, r2)
            if (r0 == 0) goto L58
            goto L8e
        L58:
            java.lang.String r0 = "MediaPlayerAgent"
            java.lang.String r1 = "set remote media fail"
            com.huawei.hms.ads.ge.I(r0, r1)
            com.huawei.hms.ads.ez r0 = new com.huawei.hms.ads.ez
            r1 = r0
            r1.<init>()
            throw r0
        L68:
            r0 = r5
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.HTTP
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L84
            r0 = r5
            r6 = r0
            r0 = r5
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.HTTPS
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L19
        L84:
            r0 = r4
            r1 = 1
            r0.i = r1
            r0 = r5
            r6 = r0
            goto L19
        L8e:
            r0 = r7
            r1 = 1
            r0.setVideoScalingMode(r1)
            r0 = r4
            com.huawei.openalliance.ad.media.c r0 = r0.p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.INITIALIZED
            r0.I(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.media.b.S(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i, final int i2) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.K.iterator();
                while (it.hasNext()) {
                    gr grVar = (gr) it.next();
                    if (grVar != null) {
                        grVar.Code(i, i2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j, int i) {
        MediaPlayer mediaPlayer;
        try {
            ge.V(I, "seekToMillis " + j);
            if (this.p.Code()) {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                V(mediaPlayer, j, i);
                long k = k();
                if (k > 0) {
                    V((int) ((100 * j) / k), (int) j);
                }
            }
        } catch (IllegalStateException e2) {
            ge.I(I, "seekTo IllegalStateException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(MediaPlayer mediaPlayer, long j, int i) {
        if (mediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(j, i);
            } else {
                mediaPlayer.seekTo((int) j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        String str;
        if (this.p.Code(e.END)) {
            return;
        }
        if (surface != null && !surface.isValid()) {
            ge.I(I, "setSurfaceInternal - surface is invalid");
        } else if (surface == n()) {
            ge.V(I, "setSurfaceInternal - pass-in surface is the same as currentSurface");
        } else {
            this.E = new WeakReference<>(surface);
            try {
                ge.V(I, "setSurfaceInternal");
                f().setSurface(surface);
            } catch (IllegalArgumentException e2) {
                str = "setSurface IllegalArgumentException";
                ge.I(I, str);
            } catch (IllegalStateException e3) {
                str = "setSurface IllegalStateException";
                ge.I(I, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable) {
        V.Code(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable, String str, long j) {
        V.Code(runnable, str, j);
    }

    private void V(boolean z) {
        if (this.p.Code(e.END)) {
            return;
        }
        try {
            ge.V(I, "prepareMediaPlayer");
            this.p.I(e.PREPARING);
            this.k = true;
            f().prepareAsync();
            if (z) {
                q();
            }
        } catch (IllegalStateException e2) {
            ge.I(I, "prepareMediaPlayer IllegalStateException");
            this.p.I(e.ERROR);
            Code(0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.w = false;
        if (I(f)) {
            v();
        }
        if (this.z == 1 && m()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        ge.V(I, "notifyVideoPictureNotPlaying");
        if (i < -10000) {
            int i2 = this.G;
            if (i2 < 20) {
                this.G = i2 + 1;
                I();
                Code();
            } else {
                I();
                this.aa.onError(f(), C, i);
            }
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.29
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.P.iterator();
                while (it.hasNext()) {
                    gp gpVar = (gp) it.next();
                    if (gpVar != null) {
                        gpVar.V(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer f() {
        MediaPlayer mediaPlayer;
        synchronized (this.q) {
            if (this.D == null) {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                mediaPlayer2.setOnCompletionListener(this.W);
                mediaPlayer2.setOnPreparedListener(this.Y);
                mediaPlayer2.setOnErrorListener(this.aa);
                mediaPlayer2.setOnBufferingUpdateListener(this.ab);
                mediaPlayer2.setOnVideoSizeChangedListener(this.U);
                mediaPlayer2.setLooping(false);
                mediaPlayer2.setAudioStreamType(3);
                this.D = mediaPlayer2;
            }
            mediaPlayer = this.D;
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.p.Code(e.END)) {
            ge.V(I, "play - current state: %s - agent: %s", this.p, this);
            return;
        }
        ge.Code(I, "play file: %s", bc.Code(this.h));
        this.l = false;
        if (this.p.Code(e.ERROR) || this.p.Code(e.IDLE) || this.p.Code(e.PLAYING)) {
            ge.V(I, "play - current state: %s - agent: %s", this.p, this);
            if (this.p.Code(e.PLAYING)) {
                S(f().getCurrentPosition());
                w();
                return;
            }
            try {
                C(this.h);
                ge.V(I, "play - current state after set file: %s", this.p);
                if (this.p.Code(e.INITIALIZED)) {
                    V(true);
                    return;
                }
                return;
            } catch (ez e2) {
                ge.Code(I, "set media file error:%s", e2.getMessage());
                ge.I(I, "set media file error:" + e2.getClass().getSimpleName());
                this.p.I(e.ERROR);
                Code(0, -1, -1);
                return;
            }
        }
        MediaPlayer f = f();
        ge.V(I, "play - state before play: %s - agent: %s", this.p, this);
        if (this.k || !(this.p.Code(e.PAUSED) || this.p.Code(e.PLAYBACK_COMPLETED) || this.p.Code(e.PREPARED))) {
            try {
                C(this.h);
                if (this.p.Code(e.INITIALIZED)) {
                    V(true);
                }
            } catch (ez e3) {
                ge.Code(I, "set media file error:%s", e3.getMessage());
                ge.I(I, "set media file error:" + e3.getClass().getSimpleName());
                this.p.I(e.ERROR);
                Code(0, -1, -1);
            }
        } else {
            try {
                f.start();
                if (this.p.Code(e.PREPARED)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        f.seekTo(this.o, 3);
                    } else {
                        f.seekTo(this.o);
                    }
                }
                int currentPosition = this.p.Code(e.PLAYBACK_COMPLETED) ? 0 : f.getCurrentPosition();
                this.p.I(e.PLAYING);
                S(currentPosition);
                w();
            } catch (IllegalStateException e4) {
                ge.I(I, "play - start IllegalStateException");
                this.p.I(e.ERROR);
                Code(f.getCurrentPosition(), -100, 0);
                t();
            }
        }
        ge.V(I, "play - current state: %s", this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ge.V(I, "prepareInternal - current state: %s - agent: %s", this.p, this);
        if (this.p.Code(e.END)) {
            return;
        }
        ge.V(I, "prepareInternal - current state after set file: %s", this.p);
        if (this.p.Code(e.INITIALIZED)) {
            this.l = true;
            V(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.p.Code(e.END) || this.p.Code(e.ERROR) || this.p.Code(e.IDLE)) {
            return;
        }
        if (this.p.Code() || this.p.Code(e.PREPARING)) {
            try {
                MediaPlayer f = f();
                int currentPosition = f.getCurrentPosition();
                if (this.p.Code() && !this.k) {
                    f.stop();
                }
                if (this.p.Code(e.PLAYBACK_COMPLETED)) {
                    currentPosition = 0;
                }
                F(currentPosition);
                V(0, 0);
                this.p.I(e.INITIALIZED);
            } catch (IllegalStateException e2) {
                ge.I(I, "stop IllegalStateException");
                this.p.I(e.ERROR);
            }
        }
        this.m = 0;
        this.t = 0;
        t();
        F(this.g);
        ge.V(I, "stop - agent: %s", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ge.V(I, "pauseInternal before State: %s - agent: %s", this.p, this);
        this.v = false;
        if (this.p.Code(e.END) || this.p.Code(e.ERROR) || this.p.Code(e.PAUSED) || this.p.Code(e.INITIALIZED) || this.p.Code(e.IDLE) || this.p.Code(e.PLAYBACK_COMPLETED)) {
            return;
        }
        try {
            MediaPlayer f = f();
            if (f.isPlaying()) {
                f.pause();
            }
            this.p.I(e.PAUSED);
            D(f.getCurrentPosition());
        } catch (IllegalStateException e2) {
            ge.I(I, "pause IllegalStateException");
            this.p.I(e.ERROR);
        }
        t();
        F(this.g);
        ge.V(I, com.anythink.expressad.foundation.d.c.cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        MediaPlayer mediaPlayer;
        if (this.p.Code(e.END)) {
            return 0;
        }
        int l = l();
        if (this.p.Code() && !this.k) {
            try {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                if (mediaPlayer != null) {
                    int duration = mediaPlayer.getDuration();
                    if (duration > 0) {
                        return duration;
                    }
                }
            } catch (IllegalStateException e2) {
                ge.I(I, "getDuration IllegalStateException");
            }
        }
        return l;
    }

    private int l() {
        int i;
        synchronized (this.r) {
            i = this.n;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        MediaPlayer mediaPlayer;
        if (this.p.Code()) {
            try {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                if (mediaPlayer != null) {
                    return mediaPlayer.isPlaying();
                }
                return false;
            } catch (IllegalStateException e2) {
                ge.I(I, "isPlaying IllegalStateException");
                return false;
            }
        }
        return false;
    }

    private Surface n() {
        WeakReference<Surface> weakReference = this.E;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.w = false;
        if (I(0.0f)) {
            u();
        }
        if (this.z == 1 && m()) {
            e();
        }
    }

    static /* synthetic */ int p(b bVar) {
        int i = bVar.t;
        bVar.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.w = false;
        if (I(1.0f)) {
            v();
        }
        if (this.z == 1 && m()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!this.j && this.i && this.M.size() > 0) {
            if (this.p.Code(e.PLAYING) || this.p.Code(e.PREPARING)) {
                ge.V(I, "notifyBufferingStart currentState: %s", this.p);
                this.j = true;
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.17
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = b.this.M.iterator();
                        while (it.hasNext()) {
                            gn gnVar = (gn) it.next();
                            if (gnVar != null) {
                                gnVar.Code();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        CopyOnWriteArraySet<gt> copyOnWriteArraySet = this.R;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        ge.V(I, "notifyRenderStart");
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.18
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.R.iterator();
                while (it.hasNext()) {
                    gt gtVar = (gt) it.next();
                    if (gtVar != null) {
                        gtVar.Code();
                    }
                }
            }
        });
    }

    private void s() {
        CopyOnWriteArraySet<gq> copyOnWriteArraySet = this.T;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        ge.V(I, "notify player release");
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.19
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.T.iterator();
                while (it.hasNext()) {
                    gq gqVar = (gq) it.next();
                    if (gqVar != null) {
                        gqVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.j && this.i) {
            this.j = false;
            ge.V(I, "notifyBufferingEnd currentState: %s", this.p);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.20
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = b.this.M.iterator();
                    while (it.hasNext()) {
                        gn gnVar = (gn) it.next();
                        if (gnVar != null) {
                            gnVar.V();
                        }
                    }
                }
            });
        }
    }

    private void u() {
        if (this.y) {
            ge.V(I, "already muted, don't notify");
            return;
        }
        ge.V(I, "notifyMute");
        this.y = true;
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.26
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.O.iterator();
                while (it.hasNext()) {
                    gs gsVar = (gs) it.next();
                    if (gsVar != null) {
                        gsVar.Code();
                    }
                }
            }
        });
    }

    private void v() {
        if (!this.y) {
            ge.V(I, "already unmuted, don't notify");
            return;
        }
        ge.V(I, "notifyUnmute");
        this.y = false;
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.27
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.O.iterator();
                while (it.hasNext()) {
                    gs gsVar = (gs) it.next();
                    if (gsVar != null) {
                        gsVar.V();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        F(this.g);
        if (this.K.size() > 0) {
            V(this.ad);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        synchronized (this.q) {
            if (this.p.Code(e.END)) {
                return;
            }
            this.p.I(e.END);
            ge.V(I, "release - agent: %s", this);
            V.V();
            y();
            if (this.D != null) {
                try {
                    this.D.setSurface(null);
                    this.D.setOnVideoSizeChangedListener(null);
                    this.D.release();
                    this.D = null;
                    ge.V(I, "release media player");
                } catch (IllegalStateException e2) {
                    ge.I(I, "media player reset surface IllegalStateException");
                    this.D.setOnVideoSizeChangedListener(null);
                    this.D.release();
                    this.D = null;
                    ge.V(I, "release media player");
                }
                s();
            }
            this.K.clear();
            this.M.clear();
            this.N.clear();
            this.O.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        synchronized (this.q) {
            ge.V(I, "resetInternal - agent: %s", this);
            try {
                if (this.D != null) {
                    if (this.p.Code()) {
                        int currentPosition = this.D.getCurrentPosition();
                        this.D.stop();
                        if (this.p.Code(e.PLAYBACK_COMPLETED)) {
                            currentPosition = 0;
                        }
                        F(currentPosition);
                        V(0, 0);
                        C(0);
                    }
                    this.D.reset();
                }
            } catch (IllegalStateException e2) {
                ge.I(I, "media player reset IllegalStateException");
            } catch (Throwable th) {
                ge.I(I, "media player reset exception: %s", th.getClass().getSimpleName());
            }
            this.m = 0;
            this.t = 0;
            this.k = false;
            this.w = false;
            this.v = false;
            this.x = 0;
            this.G = 0;
            this.p.I(e.IDLE);
            t();
            F(this.g);
        }
    }

    private void z() {
        String str;
        if (!E()) {
            ge.I(I, "audio focus is not needed");
            return;
        }
        try {
            ge.V(I, "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.u.requestAudioFocus(this.ae, 3, 2);
                return;
            }
            AudioFocusRequest build = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.ae).build();
            this.A = build;
            this.u.requestAudioFocus(build);
        } catch (IllegalStateException e2) {
            str = "requestAudioFocus IllegalStateException";
            ge.I(I, str);
        } catch (Exception e3) {
            str = "requestAudioFocus " + e3.getClass().getSimpleName();
            ge.I(I, str);
        }
    }

    public int B() {
        MediaPlayer mediaPlayer;
        if (this.p.Code(e.END) || this.p.Code(e.ERROR) || this.p.Code(e.IDLE)) {
            return 0;
        }
        try {
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            if (mediaPlayer != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0;
        } catch (IllegalStateException e2) {
            ge.I(I, "getCurrentPlayPosition IllegalStateException");
            return 0;
        }
    }

    public c C() {
        return this.p;
    }

    public void Code() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.40
            @Override // java.lang.Runnable
            public void run() {
                b.this.g();
            }
        });
    }

    public void Code(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.13
            @Override // java.lang.Runnable
            public void run() {
                ge.Code(b.I, "setSoundVolume %f result: %s", Float.valueOf(f), Boolean.valueOf(b.this.I(f)));
            }
        });
    }

    public void Code(int i) {
        int i2 = Build.VERSION.SDK_INT;
        Code(i, 0);
    }

    public void Code(int i, int i2) {
        MediaPlayer mediaPlayer;
        try {
            if (!this.p.Code() || this.k) {
                return;
            }
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            int k = (k() * i) / 100;
            V(mediaPlayer, k, i2);
            V(i, k);
        } catch (IllegalStateException e2) {
            ge.I(I, "seekTo IllegalStateException");
        }
    }

    public void Code(final long j, final int i) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.V(j, i);
            }
        });
    }

    public void Code(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        V(onVideoSizeChangedListener);
    }

    public void Code(final Surface surface) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.V(surface);
            }
        });
    }

    public void Code(gn gnVar) {
        if (gnVar == null) {
            return;
        }
        this.M.add(gnVar);
    }

    public void Code(go goVar) {
        if (goVar == null) {
            return;
        }
        this.N.add(goVar);
    }

    public void Code(gp gpVar) {
        if (gpVar == null) {
            return;
        }
        this.P.add(gpVar);
    }

    public void Code(gq gqVar) {
        V(gqVar);
    }

    public void Code(gr grVar) {
        if (grVar == null) {
            return;
        }
        this.K.add(grVar);
    }

    public void Code(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        this.O.add(gsVar);
    }

    public void Code(gt gtVar) {
        V(gtVar);
    }

    public void Code(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.41
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.h)) {
                    ge.V(b.I, "playWhenUrlMatchs - url not match");
                } else {
                    b.this.g();
                }
            }
        });
    }

    public void Code(boolean z) {
        this.H = z;
    }

    boolean Code(String str, MediaPlayer mediaPlayer) {
        AssetFileDescriptor openTypedAssetFileDescriptor = this.J.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "*/*", null);
        if (openTypedAssetFileDescriptor == null) {
            at.Code(openTypedAssetFileDescriptor);
            return false;
        }
        try {
            if (openTypedAssetFileDescriptor.getDeclaredLength() < 0) {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor(), openTypedAssetFileDescriptor.getStartOffset(), openTypedAssetFileDescriptor.getDeclaredLength());
            }
            at.Code(openTypedAssetFileDescriptor);
            return true;
        } catch (Throwable th) {
            at.Code(openTypedAssetFileDescriptor);
            throw th;
        }
    }

    public void D() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
            }
        });
    }

    public String F() {
        return this.h;
    }

    public void I() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        });
    }

    public void I(int i) {
        ge.Code(I, "setPreferStartPlayTime %s", Integer.valueOf(i));
        this.o = i;
    }

    public void I(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.Q.remove(onVideoSizeChangedListener);
    }

    public void I(gq gqVar) {
        if (gqVar == null) {
            return;
        }
        this.T.remove(gqVar);
    }

    public void I(gt gtVar) {
        if (gtVar == null) {
            return;
        }
        this.R.remove(gtVar);
    }

    public void I(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.5
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.h)) {
                    return;
                }
                b.this.j();
            }
        });
    }

    public void L() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.p();
            }
        });
    }

    public boolean S() {
        if (this.p.Code(e.END)) {
            return false;
        }
        return ((Boolean) aw.Code(this.ac, 300L, Boolean.valueOf(this.p.Code(e.PLAYING)))).booleanValue();
    }

    public void V() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.42
            @Override // java.lang.Runnable
            public void run() {
                b.this.h();
            }
        });
    }

    public void V(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.37
            @Override // java.lang.Runnable
            public void run() {
                b.this.Z(f);
            }
        });
    }

    public void V(int i) {
        synchronized (this.r) {
            this.n = i;
        }
    }

    public void V(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.Q.add(onVideoSizeChangedListener);
    }

    public void V(gn gnVar) {
        if (gnVar == null) {
            return;
        }
        this.M.remove(gnVar);
    }

    public void V(go goVar) {
        if (goVar == null) {
            return;
        }
        this.N.remove(goVar);
    }

    public void V(gp gpVar) {
        if (gpVar == null) {
            return;
        }
        this.P.remove(gpVar);
    }

    public void V(gq gqVar) {
        if (gqVar == null) {
            return;
        }
        this.T.add(gqVar);
    }

    public void V(gr grVar) {
        if (grVar == null) {
            return;
        }
        this.K.remove(grVar);
    }

    public void V(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        this.O.remove(gsVar);
    }

    public void V(gt gtVar) {
        if (gtVar == null) {
            return;
        }
        this.R.add(gtVar);
    }

    public void V(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.h)) {
                    return;
                }
                b.this.i();
            }
        });
    }

    public void Z() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.j();
            }
        });
    }

    public void Z(int i) {
        this.z = i;
    }

    public void Z(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.C(str);
                } catch (ez e2) {
                    ge.Code(b.I, "set media file error:%s", e2.getMessage());
                    ge.I(b.I, "set media file error:" + e2.getClass().getSimpleName());
                }
            }
        });
    }

    public void a() {
        synchronized (this.s) {
            int i = this.f - 1;
            this.f = i;
            if (i < 0) {
                this.f = 0;
            }
            if (ge.Code()) {
                ge.Code(I, "release - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
            }
            if (this.f == 0) {
                V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.31
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.x();
                    }
                });
            }
        }
    }

    public void b() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.33
            @Override // java.lang.Runnable
            public void run() {
                b.this.y();
            }
        });
    }

    public void c() {
        synchronized (this.s) {
            this.f++;
            if (ge.Code()) {
                ge.Code(I, "acquire - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
            }
        }
    }

    public int d() {
        int i;
        synchronized (this.s) {
            i = this.f;
        }
        return i;
    }

    public void e() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.35
            @Override // java.lang.Runnable
            public void run() {
                b.this.A();
            }
        });
    }

    protected void finalize() {
        super.finalize();
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.32
            @Override // java.lang.Runnable
            public void run() {
                b.this.x();
            }
        });
    }

    public String toString() {
        return "MediaPlayerAgent@" + Integer.toHexString(hashCode()) + " [" + bc.Code(this.h) + "]";
    }
}
