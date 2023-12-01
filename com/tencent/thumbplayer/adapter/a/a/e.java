package com.tencent.thumbplayer.adapter.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.anythink.core.common.g.g;
import com.tencent.thumbplayer.adapter.a.a.a;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.api.TPAudioAttributes;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.core.common.TPGeneralError;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e.class */
public class e implements com.tencent.thumbplayer.adapter.a.b {
    private c.l A;
    private c.m B;
    private volatile MediaPlayer C;
    private com.tencent.thumbplayer.a.c E;
    private Object F;
    private a J;
    private volatile EnumC1011e Q;
    private volatile EnumC1011e R;

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.thumbplayer.e.a f39146a;
    private com.tencent.thumbplayer.adapter.a.a.a af;
    private Context b;
    private String f;
    private FileDescriptor g;
    private AssetFileDescriptor h;
    private Map<String, String> l;
    private c.i u;
    private c.InterfaceC1013c v;
    private c.h w;
    private c.f x;
    private c.j y;
    private c.p z;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39147c = false;
    private long d = 0;
    private long e = 0;
    private boolean i = false;
    private float j = 1.0f;
    private float k = 1.0f;
    private int m = 0;
    private long n = -1;
    private boolean o = false;
    private long p = -1;
    private int q = -1;
    private int r = -1;
    private TPAudioAttributes s = null;
    private boolean t = true;
    private Future<?> G = null;
    private final Object H = new Object();
    private long I = 25000;
    private final Object K = new Object();
    private int L = 3;
    private int M = 30;
    private final Object N = new Object();
    private Future<?> O = null;
    private boolean P = false;
    private boolean S = false;
    private long T = 0;
    private long U = -1;
    private int V = 0;
    private int W = 0;
    private volatile boolean X = false;
    private int Y = 0;
    private int Z = -1;
    private int aa = 0;
    private int ab = -1;
    private int ac = -1;
    private List<b> ad = new ArrayList();
    private List<b> ae = new ArrayList();
    private long ag = 0;
    private f ah = null;
    private MediaPlayer.OnTimedTextListener ai = new MediaPlayer.OnTimedTextListener() { // from class: com.tencent.thumbplayer.adapter.a.a.e.8
        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (e.this.A != null) {
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = timedText != null ? timedText.getText() : "";
                tPSubtitleData.trackIndex = e.this.Z;
                tPSubtitleData.startPositionMs = e.this.n();
                e.this.A.a(tPSubtitleData);
            }
        }
    };
    private d D = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f39156a;
        Future<?> b;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TPTrackInfo f39157a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public List<TPOptionalParam> f39158c;
        public Map<String, String> d;

        private b() {
            this.b = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$c.class */
    public static class c implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Handler f39159a;

        c(Handler handler) {
            this.f39159a = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                this.f39159a.handleMessage(message);
                return true;
            } catch (Exception e) {
                TPLogUtil.e("TPSystemMediaPlayer", "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(e));
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$d.class */
    public class d implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private d() {
        }

        private int a(int i) {
            if (e.this.r > 0) {
                i = e.this.r;
            }
            return i;
        }

        private int b(int i) {
            if (e.this.q > 0) {
                i = e.this.q;
            }
            return i;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (e.this.o) {
                e.this.f39146a.d("onCompletion, unknown err.");
                return;
            }
            e.this.f39146a.c("onCompletion.");
            e.this.R = EnumC1011e.COMPLETE;
            e.this.C();
            c.InterfaceC1013c interfaceC1013c = e.this.v;
            if (interfaceC1013c != null) {
                interfaceC1013c.b();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00c8, code lost:
            if (r10 == 100) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // android.media.MediaPlayer.OnErrorListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onError(android.media.MediaPlayer r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.adapter.a.a.e.d.onError(android.media.MediaPlayer, int, int):boolean");
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            int i3;
            e.this.f39146a.c("mediaplayer, onInfo. what:" + i + ", extra:" + i2);
            if (i != 3) {
                if (i == 801) {
                    e.this.P = true;
                } else if (i == 701) {
                    i3 = 200;
                } else if (i == 702) {
                    i3 = 201;
                }
                i3 = -1;
            } else {
                i3 = 106;
            }
            if (i3 != -1) {
                if (200 == i3 || 201 == i3) {
                    if (!e.this.G()) {
                        e eVar = e.this;
                        if (200 == i3) {
                            eVar.X = true;
                            e.this.E();
                        } else {
                            eVar.X = false;
                            e.this.F();
                        }
                        if (e.this.w != null) {
                            e.this.w.a(i3, 0L, 0L, null);
                        }
                    }
                } else if (e.this.w != null) {
                    e.this.w.a(106, 0L, 0L, null);
                }
            }
            if (i3 == 106) {
                int a2 = a(mediaPlayer.getVideoWidth());
                int b = b(mediaPlayer.getVideoHeight());
                if (!(b == e.this.W && a2 == e.this.V) && b > 0 && a2 > 0) {
                    e.this.W = b;
                    e.this.V = a2;
                    if (e.this.z != null) {
                        e.this.z.a(e.this.V, e.this.W);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (e.this.Q != EnumC1011e.PREPARING) {
                e.this.f39146a.c("onPrepared() is called in a wrong situation, mState = " + e.this.Q);
                return;
            }
            e.this.R = EnumC1011e.PREPARED;
            long duration = e.this.C.getDuration();
            if (duration <= 0) {
                e.this.P = true;
            }
            e.this.f39146a.c("onPrepared() , mStartPositionMs=" + e.this.m + ", duration:" + duration + ", mIsLive:" + e.this.o);
            e.this.A();
            e.this.w();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (e.this.C == null) {
                return;
            }
            e.this.f39146a.c("onSeekComplete().");
            if (e.this.Q == EnumC1011e.STARTED && e.this.R == EnumC1011e.COMPLETE) {
                e.this.Q = EnumC1011e.STARTED;
                e.this.R = EnumC1011e.STARTED;
                e.this.C.start();
            }
            if (EnumC1011e.PREPARED == e.this.Q || e.this.y == null) {
                return;
            }
            e.this.y.c();
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 0 || i2 == 0) {
                com.tencent.thumbplayer.e.a aVar = e.this.f39146a;
                aVar.e("onVideoSizeChanged() size error, width:" + i + " height:" + i2);
                return;
            }
            int a2 = a(i);
            int b = b(i2);
            try {
                if ((a2 != e.this.V || b != e.this.W) && b > 0 && a2 > 0) {
                    e.this.z.a(a2, b);
                }
            } catch (Exception e) {
                e.this.f39146a.d(e.toString());
            }
            e.this.V = a2;
            e.this.W = b;
            com.tencent.thumbplayer.e.a aVar2 = e.this.f39146a;
            aVar2.c("onVideoSizeChanged(), width:" + a2 + " height:" + b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.adapter.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$e.class */
    public enum EnumC1011e {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        COMPLETE,
        ERROR,
        RELEASE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/e$f.class */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        int f39163a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f39164c;
        int d;
        int e;
        int f;
        String g;
        EnumC1011e h;

        private f() {
        }
    }

    public e(Context context, com.tencent.thumbplayer.e.b bVar) {
        this.f39146a = new com.tencent.thumbplayer.e.a(bVar, "TPSystemMediaPlayer");
        this.b = context;
        b bVar2 = new b();
        bVar2.f39157a = new TPTrackInfo();
        bVar2.f39157a.isSelected = true;
        bVar2.f39157a.name = "audio_1";
        this.ad.add(bVar2);
        b();
        com.tencent.thumbplayer.adapter.a.a.c cVar = new com.tencent.thumbplayer.adapter.a.a.c();
        this.af = cVar;
        cVar.a(new a.InterfaceC1010a() { // from class: com.tencent.thumbplayer.adapter.a.a.e.1
            @Override // com.tencent.thumbplayer.adapter.a.a.a.InterfaceC1010a
            public void a(a.e eVar) {
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = eVar.f39136a;
                c.l lVar = e.this.A;
                if (lVar != null) {
                    lVar.a(tPSubtitleData);
                }
            }

            @Override // com.tencent.thumbplayer.adapter.a.a.a.InterfaceC1010a
            public void a(TPSubtitleFrame tPSubtitleFrame) {
                TPSubtitleFrameBuffer a2 = com.tencent.thumbplayer.adapter.a.b.c.a(tPSubtitleFrame);
                c.m mVar = e.this.B;
                if (mVar != null) {
                    mVar.a(a2);
                }
            }

            @Override // com.tencent.thumbplayer.adapter.a.a.a.InterfaceC1010a
            public void a(String str) {
                e.this.f39146a.c("onSubtitleNote, ".concat(String.valueOf(str)));
                c.h hVar = e.this.w;
                if (hVar != null) {
                    hVar.a(506, 0L, 0L, str);
                }
            }
        });
        this.af.a(new a.d() { // from class: com.tencent.thumbplayer.adapter.a.a.e.2
            @Override // com.tencent.thumbplayer.adapter.a.a.a.d
            public long a() {
                if (e.this.Q == EnumC1011e.PAUSED || e.this.Q == EnumC1011e.STARTED) {
                    return e.this.n();
                }
                return -1L;
            }
        });
        this.af.a(new a.c() { // from class: com.tencent.thumbplayer.adapter.a.a.e.3
            @Override // com.tencent.thumbplayer.adapter.a.a.a.c
            public void a(int i, long j) {
                if (e.this.w != null) {
                    e.this.w.a(4, 2000L, e.g(i), Long.valueOf(j));
                }
            }

            @Override // com.tencent.thumbplayer.adapter.a.a.a.c
            public void a(long j) {
                if (e.this.Q == EnumC1011e.STARTED) {
                    e.this.af.b();
                }
                if (e.this.w != null) {
                    e.this.w.a(4, 1000L, 0L, Long.valueOf(j));
                }
            }
        });
        this.af.a(new a.b() { // from class: com.tencent.thumbplayer.adapter.a.a.e.4
            @Override // com.tencent.thumbplayer.adapter.a.a.a.b
            public void a(int i, int i2) {
                if (e.this.w != null) {
                    e.this.w.a(254, i, i2, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        synchronized (this) {
            synchronized (this.H) {
                if (this.G != null) {
                    this.G.cancel(true);
                    this.G = null;
                }
            }
        }
    }

    private void B() {
        synchronized (this.K) {
            if (!G()) {
                this.f39146a.c("startCheckBufferingTimer, forbidden check buffer by position");
                return;
            }
            if (this.J == null) {
                final a aVar = new a();
                this.J = aVar;
                aVar.f39156a = false;
                this.J.b = o.a().e().schedule(new Runnable() { // from class: com.tencent.thumbplayer.adapter.a.a.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        while (!aVar.f39156a) {
                            e.this.D();
                            try {
                                Thread.sleep(400L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        synchronized (this) {
            synchronized (this.K) {
                if (this.J != null) {
                    this.J.f39156a = true;
                    if (this.J.b != null) {
                        this.J.b.cancel(true);
                    }
                    this.J.b = null;
                    this.J = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        long n = n();
        long j = this.U;
        this.U = n;
        if (this.Q != EnumC1011e.STARTED) {
            if (this.Q == EnumC1011e.PAUSED && this.X) {
                this.f39146a.c("checkBuffingEvent, pause state and send end buffering");
                this.X = false;
                this.Y = 0;
                c.h hVar = this.w;
                if (hVar != null) {
                    hVar.a(201, 0L, 0L, null);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f39147c) {
            long j2 = this.e;
            if (j2 > 0 && n >= j2 && !this.P) {
                this.f39146a.c("checkBuffingEvent, loopback skip end, curPosition:" + n + ", mLoopStartPositionMs:" + this.d);
                this.C.seekTo((int) this.d);
            }
        } else if (this.n > 0 && n >= m() - this.n) {
            this.f39146a.c("checkBuffingEvent, skip end, mBaseDuration: " + this.T + ", curPosition:" + n + ", mSkipEndMilsec:" + this.n);
            this.Q = EnumC1011e.COMPLETE;
            e();
            C();
            c.InterfaceC1013c interfaceC1013c = this.v;
            if (interfaceC1013c != null) {
                interfaceC1013c.b();
                return;
            }
            return;
        }
        int i = (n > j ? 1 : (n == j ? 0 : -1));
        if (i != 0) {
            this.ag++;
        }
        if (i != 0 || n <= 0) {
            if (this.X) {
                this.f39146a.c("checkBuffingEvent, position change, send end buffering");
                c.h hVar2 = this.w;
                if (hVar2 != null) {
                    hVar2.a(201, n, this.T, Long.valueOf(this.ag));
                }
            }
            this.X = false;
            this.Y = 0;
            return;
        }
        int i2 = this.Y + 1;
        this.Y = i2;
        if (i2 >= this.L && !this.X) {
            this.X = true;
            this.f39146a.c("checkBuffingEvent, position no change,send start buffering");
            c.h hVar3 = this.w;
            if (hVar3 != null) {
                hVar3.a(200, n, this.T, Long.valueOf(this.ag));
            }
        }
        if (this.Y >= this.M) {
            this.f39146a.e("checkBuffingEvent post error");
            this.Q = EnumC1011e.ERROR;
            e();
            this.X = false;
            C();
            c.f fVar = this.x;
            if (fVar != null) {
                fVar.a(2001, g(-110), 0L, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        synchronized (this.N) {
            if (this.O == null) {
                this.O = o.a().e().schedule(new Runnable() { // from class: com.tencent.thumbplayer.adapter.a.a.e.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.Q == EnumC1011e.PAUSED || !e.this.X) {
                            return;
                        }
                        e.this.f39146a.e("startCheckBufferTimeOutByInfo, buffer last too long");
                        e.this.Q = EnumC1011e.ERROR;
                        e.this.e();
                        e.this.X = false;
                        e.this.F();
                        c.f fVar = e.this.x;
                        if (fVar != null) {
                            fVar.a(2001, e.g(-110), 0L, 0L);
                        }
                    }
                }, this.M * 400, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        synchronized (this) {
            synchronized (this.N) {
                if (this.O != null) {
                    this.O.cancel(true);
                    this.O = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        if (this.o) {
            return false;
        }
        return this.t;
    }

    private MediaPlayer a() {
        com.tencent.thumbplayer.adapter.a.a.b bVar = new com.tencent.thumbplayer.adapter.a.a.b();
        if (Build.VERSION.SDK_INT <= 19) {
            a(bVar);
        }
        bVar.setOnPreparedListener(this.D);
        bVar.setOnCompletionListener(this.D);
        bVar.setOnErrorListener(this.D);
        bVar.setOnInfoListener(this.D);
        bVar.setOnBufferingUpdateListener(this.D);
        bVar.setOnSeekCompleteListener(this.D);
        bVar.setOnVideoSizeChangedListener(this.D);
        if (Build.VERSION.SDK_INT >= 16) {
            bVar.setOnTimedTextListener(this.ai);
        }
        return bVar;
    }

    private void a(MediaPlayer mediaPlayer) {
        try {
            Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(mediaPlayer);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            if (((Handler.Callback) declaredField2.get(handler)) == null) {
                declaredField2.set(handler, new c(handler));
            }
        } catch (Exception e) {
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.e("mediaPlayerExceptionHook, " + Log.getStackTraceString(e));
        }
    }

    private void a(MediaPlayer mediaPlayer, int i, @TPCommonEnum.TPSeekMode int i2) {
        int i3;
        if (Build.VERSION.SDK_INT < 26) {
            this.f39146a.c("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
            mediaPlayer.seekTo(i);
            return;
        }
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = 1;
                } else if (i2 == 3) {
                    i3 = 2;
                }
                mediaPlayer.seekTo(i, i3);
                return;
            }
            mediaPlayer.seekTo(i, i3);
            return;
        } catch (Exception e) {
            this.f39146a.a(e);
            try {
                if (this.R == EnumC1011e.COMPLETE) {
                    this.Q = EnumC1011e.STARTED;
                }
                mediaPlayer.seekTo(i);
                return;
            } catch (Exception e2) {
                this.f39146a.a(e2);
                return;
            }
        }
        i3 = 0;
    }

    private void a(f fVar) {
        synchronized (this) {
            String str = fVar.g;
            fVar.f39164c = n();
            fVar.h = this.Q;
            fVar.e = this.ac;
            fVar.f = this.Z;
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("playerResetStart, pos:" + fVar.f39164c + ", state:" + fVar.h);
            this.S = true;
            v();
            this.R = EnumC1011e.IDLE;
            if (this.g != null) {
                this.C.setDataSource(this.g);
            } else if (this.h != null) {
                b(this.h);
            } else {
                e(fVar.d);
                if (this.l == null || this.l.isEmpty()) {
                    this.C.setDataSource(str);
                } else {
                    this.C.setDataSource(this.b, Uri.parse(str), this.l);
                }
            }
            this.R = EnumC1011e.INITIALIZED;
            if (this.F == null) {
                this.C.setDisplay(null);
            } else if (this.F instanceof SurfaceHolder) {
                this.C.setDisplay((SurfaceHolder) this.F);
            } else if (this.F instanceof Surface) {
                this.C.setSurface((Surface) this.F);
            }
            f fVar2 = this.ah;
            if (fVar2 != null && fVar2.f39163a != fVar.f39163a) {
                c.h hVar = this.w;
                int i = fVar2.f39163a == 1 ? 3 : 4;
                if (hVar != null) {
                    hVar.a(i, fVar2.b, 0L, null);
                }
                fVar.h = fVar2.h;
                fVar.f39164c = fVar2.f39164c;
            }
            this.ah = fVar;
            if (fVar.h == EnumC1011e.PREPARING || fVar.h == EnumC1011e.PREPARED || fVar.h == EnumC1011e.STARTED || fVar.h == EnumC1011e.PAUSED) {
                g();
            }
        }
    }

    private void a(TPAudioAttributes tPAudioAttributes) {
        if (tPAudioAttributes == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.C.setAudioAttributes(this.s.toAndroidMediaAudioAttributes());
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("set audio attributes into MediaPlayer, API:" + Build.VERSION.SDK_INT + ">=21, " + this.s.toString());
            return;
        }
        int usageToAndroidMediaStreamType = TPAudioAttributes.usageToAndroidMediaStreamType(tPAudioAttributes.getUsage());
        this.C.setAudioStreamType(usageToAndroidMediaStreamType);
        com.tencent.thumbplayer.e.a aVar2 = this.f39146a;
        aVar2.c("set audio attributes into MediaPlayer, API:" + Build.VERSION.SDK_INT + "<21, Usage:" + tPAudioAttributes.getUsage() + "=>StreamType:" + usageToAndroidMediaStreamType);
    }

    private boolean a(EnumC1011e enumC1011e) {
        return enumC1011e == EnumC1011e.PREPARED || enumC1011e == EnumC1011e.STARTED || enumC1011e == EnumC1011e.PAUSED;
    }

    private void b() {
        this.C = a();
        this.Q = EnumC1011e.IDLE;
        this.R = EnumC1011e.IDLE;
    }

    private void b(AssetFileDescriptor assetFileDescriptor) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.C.setDataSource(assetFileDescriptor);
        } else {
            this.C.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    private boolean b(EnumC1011e enumC1011e) {
        return enumC1011e != EnumC1011e.RELEASE;
    }

    private void c() {
        if (a(this.R)) {
            this.R = EnumC1011e.STOPPED;
            this.f39146a.c("MediaPlayer stop.");
            this.C.stop();
        }
    }

    private void d() {
        if (b(this.R)) {
            this.R = EnumC1011e.RELEASE;
            this.f39146a.c("MediaPlayer release.");
            this.C.release();
        }
    }

    private void d(int i, long j) {
        f fVar = new f();
        fVar.b = j;
        fVar.d = i;
        fVar.f39163a = 2;
        fVar.g = this.f;
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        y();
        c();
        d();
    }

    private void e(int i) {
        if (i <= 0) {
            return;
        }
        b bVar = this.ad.get(i);
        c.h hVar = this.w;
        if (hVar != null) {
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
            tPAudioTrackInfo.audioTrackUrl = bVar.b;
            tPAudioTrackInfo.paramData = bVar.f39158c;
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("handleDataSource, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl);
            hVar.a(1011, 0L, 0L, tPAudioTrackInfo);
        }
    }

    private void e(int i, long j) {
        this.af.e();
        b bVar = this.ae.get(i);
        this.af.a(bVar.b, bVar.d, j);
        this.af.a();
    }

    private int f(int i) {
        if (2 == i) {
            return 2;
        }
        if (1 == i) {
            return 1;
        }
        return 4 == i ? 3 : 0;
    }

    private void f(int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("deselectSubTrack, trackIndex:" + i + ", opaque:" + j);
        this.af.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int i) {
        long j = i;
        long j2 = i < 0 ? 10000000 - j : 10000000 + j;
        long j3 = j2;
        if (j2 >= 2147483647L) {
            j3 = 2147483647L;
        }
        return (int) j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.adapter.a.a.e.v():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        synchronized (this) {
            f fVar = this.ah;
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("playerResetEnd, actionInfo:" + fVar + ", mSuspend:" + this.S);
            if (fVar == null || !this.S) {
                if (this.m > 0 && !this.P) {
                    com.tencent.thumbplayer.e.a aVar2 = this.f39146a;
                    aVar2.c("onPrepared(), and seekto:" + this.m);
                    try {
                        this.C.seekTo(this.m);
                    } catch (Exception e) {
                        this.f39146a.a(e);
                    }
                }
                this.Q = EnumC1011e.PREPARED;
                c.i iVar = this.u;
                if (iVar != null) {
                    iVar.a();
                }
                return;
            }
            c.h hVar = this.w;
            int i = fVar.f39163a == 1 ? 3 : 4;
            if (hVar != null) {
                hVar.a(i, 1000L, 0L, Long.valueOf(fVar.b));
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (fVar.e > 0) {
                    this.C.selectTrack(fVar.e);
                }
                if (fVar.f > 0) {
                    this.C.selectTrack(fVar.f);
                }
            }
            if (fVar.f39164c > 0 && !this.P) {
                com.tencent.thumbplayer.e.a aVar3 = this.f39146a;
                aVar3.c("playerResetEnd, onPrepared(), and seek to:" + fVar.f39164c);
                try {
                    this.C.seekTo((int) fVar.f39164c);
                } catch (Exception e2) {
                    this.f39146a.a(e2);
                }
            }
            com.tencent.thumbplayer.e.a aVar4 = this.f39146a;
            aVar4.c("playerResetEnd, restore state:" + fVar.h);
            if (fVar.h != EnumC1011e.IDLE && fVar.h != EnumC1011e.INITIALIZED && fVar.h != EnumC1011e.PREPARING) {
                if (fVar.h != EnumC1011e.PREPARED && fVar.h != EnumC1011e.PAUSED) {
                    if (fVar.h == EnumC1011e.STARTED) {
                        this.f39146a.c("playerResetEnd,  MediaPlayer.start().");
                        this.C.start();
                        this.Q = fVar.h;
                        this.R = EnumC1011e.STARTED;
                        B();
                    } else {
                        com.tencent.thumbplayer.e.a aVar5 = this.f39146a;
                        aVar5.e("illegal state, state:" + fVar.h);
                        this.Q = EnumC1011e.ERROR;
                        e();
                        c.f fVar2 = this.x;
                        if (fVar2 != null) {
                            fVar2.a(2000, g(-10004), 0L, 0L);
                        }
                    }
                    this.S = false;
                    this.ah = null;
                    return;
                }
                this.Q = fVar.h;
                this.S = false;
                this.ah = null;
                return;
            }
            this.Q = EnumC1011e.PREPARED;
            c.i iVar2 = this.u;
            if (iVar2 != null) {
                iVar2.a();
            }
            this.S = false;
            this.ah = null;
            return;
        }
    }

    private void x() {
        a(this.s);
    }

    private void y() {
        this.C.setOnPreparedListener(null);
        this.C.setOnCompletionListener(null);
        this.C.setOnErrorListener(null);
        this.C.setOnInfoListener(null);
        this.C.setOnBufferingUpdateListener(null);
        this.C.setOnSeekCompleteListener(null);
        this.C.setOnVideoSizeChangedListener(null);
    }

    private void z() {
        this.f39146a.c("startCheckPrepareTimeoutTimer");
        synchronized (this.H) {
            if (this.G == null) {
                this.G = o.a().e().schedule(new Runnable() { // from class: com.tencent.thumbplayer.adapter.a.a.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.Q == EnumC1011e.PREPARING) {
                            e.this.f39146a.e("startCheckPrepareTimeoutTimer, post error");
                            e.this.Q = EnumC1011e.ERROR;
                            e.this.e();
                            e.this.A();
                            c.f fVar = e.this.x;
                            if (fVar != null) {
                                fVar.a(2001, e.g(-110), 0L, 0L);
                            }
                        }
                    }
                }, this.I, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(float f2) {
        this.f39146a.c("setAudioGainRatio, : ".concat(String.valueOf(f2)));
        this.j = f2;
        try {
            if (this.C != null) {
                this.C.setVolume(this.j, this.j);
            }
        } catch (IllegalStateException e) {
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("setAudioGainRatio ex : " + e.toString());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i) {
        this.f39146a.c("seekTo, position: ".concat(String.valueOf(i)));
        if (this.P) {
            this.f39146a.c("current media is not seekable, ignore");
        } else if (!this.S) {
            if (this.R == EnumC1011e.COMPLETE) {
                this.Q = EnumC1011e.STARTED;
            }
            this.C.seekTo(i);
        } else {
            f fVar = this.ah;
            if (fVar != null) {
                fVar.f39164c = i;
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, @TPCommonEnum.TPSeekMode int i2) {
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("seekTo, position: " + i + ", mode: " + i2);
        if (this.P) {
            this.f39146a.c("current media is not seekable, ignore");
        } else if (!this.S) {
            a(this.C, i, i2);
        } else {
            f fVar = this.ah;
            if (fVar != null) {
                fVar.f39164c = i;
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, long j) {
        this.f39146a.c("selectTrack, trackID:" + i + ", opaque:" + j);
        int size = this.ad.size();
        int size2 = this.ae.size();
        this.ad.size();
        c.h hVar = this.w;
        if (i >= 0 && i < size) {
            try {
                d(i, j);
                this.ad.get(this.aa).f39157a.isSelected = false;
                this.ad.get(i).f39157a.isSelected = true;
                this.aa = i;
            } catch (Exception e) {
                this.f39146a.a(e);
                if (hVar != null) {
                    hVar.a(4, 2000L, g(-10000), Long.valueOf(j));
                }
            }
        } else if (i >= size && i < size + size2) {
            int i2 = i - size;
            try {
                e(i2, j);
            } catch (Exception e2) {
                this.f39146a.a(e2);
                if (hVar != null) {
                    hVar.a(4, 2000L, g(-10000), Long.valueOf(j));
                }
            }
            int i3 = this.ab;
            if (i3 >= 0 && i3 < size2) {
                this.ae.get(i3).f39157a.isSelected = false;
            }
            this.ae.get(i2).f39157a.isSelected = true;
            this.ab = i;
        } else {
            int i4 = i - (size + size2);
            if (Build.VERSION.SDK_INT < 16) {
                this.f39146a.e("selectTrack, android mediaplayer not support ");
                if (hVar != null) {
                    hVar.a(4, 2000L, g((int) g.j), Long.valueOf(j));
                }
            } else if (this.Q != EnumC1011e.PREPARED && this.Q != EnumC1011e.STARTED && this.Q != EnumC1011e.PAUSED) {
                this.f39146a.e("selectTrack, illegal state:" + this.Q);
            } else {
                MediaPlayer.TrackInfo[] trackInfoArr = null;
                try {
                    trackInfoArr = this.C.getTrackInfo();
                } catch (Exception e3) {
                    this.f39146a.e("getTrackInfo, android getTrackInfo crash");
                }
                if (trackInfoArr == null || trackInfoArr.length <= i4) {
                    if (hVar != null) {
                        hVar.a(4, 2000L, g((int) g.k), Long.valueOf(j));
                        return;
                    }
                    return;
                }
                MediaPlayer.TrackInfo trackInfo = trackInfoArr[i4];
                if (trackInfo.getTrackType() == 2) {
                    this.ac = i4;
                } else if (trackInfo.getTrackType() != 4) {
                    if (hVar != null) {
                        hVar.a(4, 2000L, g(-10003), Long.valueOf(j));
                        return;
                    }
                    return;
                } else {
                    this.Z = i4;
                }
                this.C.selectTrack(i4);
                if (hVar != null) {
                    hVar.a(4, 1000L, 0L, Long.valueOf(j));
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            this.f39146a.c("setDataSource afd is null ");
            throw new IllegalArgumentException("afd is null");
        }
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("setDataSource afd， afd: " + assetFileDescriptor.toString());
        this.h = assetFileDescriptor;
        b(assetFileDescriptor);
        this.E = new com.tencent.thumbplayer.a.c(assetFileDescriptor);
        this.Q = EnumC1011e.INITIALIZED;
        this.R = EnumC1011e.INITIALIZED;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            this.f39146a.c("setDataSource pfd is null ");
            throw new IllegalArgumentException("pfd is null");
        }
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("setDataSource pfd， pfd: " + parcelFileDescriptor.toString());
        this.g = parcelFileDescriptor.getFileDescriptor();
        this.C.setDataSource(parcelFileDescriptor.getFileDescriptor());
        this.E = new com.tencent.thumbplayer.a.c(parcelFileDescriptor.getFileDescriptor());
        this.Q = EnumC1011e.INITIALIZED;
        this.R = EnumC1011e.INITIALIZED;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(Surface surface) {
        this.f39146a.c("setSurface, surface: ".concat(String.valueOf(surface)));
        this.F = surface;
        this.C.setSurface(surface);
        this.f39146a.c("setSurface over, surface: ".concat(String.valueOf(surface)));
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(SurfaceHolder surfaceHolder) {
        this.f39146a.c("setSurfaceHolder, sh: ".concat(String.valueOf(surfaceHolder)));
        this.F = surfaceHolder;
        this.C.setDisplay(surfaceHolder);
        this.f39146a.c("setSurfaceHolder over, sh: ".concat(String.valueOf(surfaceHolder)));
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
    public void a(c.InterfaceC1013c interfaceC1013c) {
        this.v = interfaceC1013c;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.d dVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.e eVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.f fVar) {
        this.x = fVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.g gVar) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.h hVar) {
        this.w = hVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.i iVar) {
        this.u = iVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.j jVar) {
        this.y = jVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.l lVar) {
        this.A = lVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.m mVar) {
        this.B = mVar;
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
        this.z = pVar;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        if (this.E == null) {
            tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
            return;
        }
        TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
        tPImageGeneratorParams.width = tPCaptureParams.width;
        tPImageGeneratorParams.height = tPCaptureParams.height;
        tPImageGeneratorParams.format = tPCaptureParams.format;
        tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
        tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
        this.E.a(n(), tPImageGeneratorParams, tPCaptureCallBack);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPOptionalParam tPOptionalParam) {
        int key = tPOptionalParam.getKey();
        if (key == 1) {
            this.p = tPOptionalParam.getParamLong().value;
        } else if (key == 2) {
            this.r = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("setPlayerOptionalParam, video width:" + this.r);
        } else if (key == 3) {
            this.q = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.e.a aVar2 = this.f39146a;
            aVar2.c("setPlayerOptionalParam, video height:" + this.q);
        } else if (key == 4) {
            this.o = tPOptionalParam.getParamBoolean().value;
            this.P = true;
            com.tencent.thumbplayer.e.a aVar3 = this.f39146a;
            aVar3.c("setPlayerOptionalParam, is live:" + this.o);
        } else if (key == 5) {
            this.t = tPOptionalParam.getParamBoolean().value;
        } else if (key == 7) {
            this.L = (int) (tPOptionalParam.getParamLong().value / 400);
            com.tencent.thumbplayer.e.a aVar4 = this.f39146a;
            aVar4.c("setPlayerOptionalParam, on buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
        } else if (key == 100) {
            this.m = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.e.a aVar5 = this.f39146a;
            aVar5.c("setPlayerOptionalParam, start position:" + this.m);
        } else if (key == 107) {
            this.M = (int) ((tPOptionalParam.getParamLong().value + 400) / 400);
            com.tencent.thumbplayer.e.a aVar6 = this.f39146a;
            aVar6.c("setPlayerOptionalParam, buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
        } else if (key == 128) {
            this.I = tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.e.a aVar7 = this.f39146a;
            aVar7.c("setPlayerOptionalParam, prepare timeout:" + this.I + "(ms)");
        } else if (key == 414) {
            this.s = (TPAudioAttributes) tPOptionalParam.getParamObject().objectValue;
            com.tencent.thumbplayer.e.a aVar8 = this.f39146a;
            aVar8.c("setPlayerOptionalParam, " + this.s.toString());
        } else if (key == 450) {
            int i = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.adapter.a.a.a aVar9 = this.af;
            if (aVar9 != null) {
                aVar9.a(i);
            }
            TPLogUtil.i("TPSystemMediaPlayer", "setPlayerOptionalParam, subtitle type:" + tPOptionalParam.getParamLong().value);
        } else if (key == 500) {
            this.n = tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.e.a aVar10 = this.f39146a;
            aVar10.c("setPlayerOptionalParam, skip end position:" + this.n);
        } else if (key != 507) {
        } else {
            TPSubtitleRenderModel tPSubtitleRenderModel = (TPSubtitleRenderModel) tPOptionalParam.getParamObject().objectValue;
            com.tencent.thumbplayer.adapter.a.a.a aVar11 = this.af;
            if (aVar11 != null) {
                aVar11.a(tPSubtitleRenderModel);
            }
            TPLogUtil.i("TPSystemMediaPlayer", "setPlayerOptionalParam, subtitle render model");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset) {
        throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i, long j) {
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(com.tencent.thumbplayer.e.b bVar) {
        this.f39146a.a(new com.tencent.thumbplayer.e.b(bVar, "TPSystemMediaPlayer"));
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str) {
        this.f39146a.c("setAudioNormalizeVolumeParams not supported.");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        this.f39146a.c("switchDefinition, defUrl: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            this.f39146a.c("switchDefinition, defUrl is null");
            return;
        }
        this.f = str;
        f fVar = new f();
        fVar.b = j;
        fVar.d = this.aa;
        fVar.f39163a = 1;
        fVar.g = str;
        try {
            a(fVar);
        } catch (Exception e) {
            throw new IllegalStateException("playerResetStart");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map) {
        this.f39146a.c("setDataSource httpHeader, url: ".concat(String.valueOf(str)));
        this.f = str;
        this.l = map;
        this.C.setDataSource(this.b, Uri.parse(str), this.l);
        this.E = new com.tencent.thumbplayer.a.c(str);
        this.Q = EnumC1011e.INITIALIZED;
        this.R = EnumC1011e.INITIALIZED;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        this.f39146a.c("switchDefinition, defUrl: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            this.f39146a.c("switchDefinition, defUrl is null");
            return;
        }
        this.f = str;
        f fVar = new f();
        fVar.b = j;
        fVar.d = this.aa;
        fVar.f39163a = 1;
        fVar.g = str;
        try {
            a(fVar);
        } catch (Exception e) {
            throw new IllegalStateException("playerResetStart");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            this.f39146a.e("addSubtitleSource, illegal argument.");
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str3;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 3;
        b bVar = new b();
        bVar.f39157a = tPTrackInfo;
        bVar.b = str;
        bVar.d = map;
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("addSubtitleSource, name:" + tPTrackInfo.name + ", url:" + str3);
        this.ae.add(bVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f39146a.e("addAudioTrackSource, illegal argument.");
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str2;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 2;
        b bVar = new b();
        bVar.f39157a = tPTrackInfo;
        bVar.b = str;
        bVar.d = map;
        bVar.f39158c = list;
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("addAudioTrackSource, name:" + tPTrackInfo.name + ", url:" + str2);
        this.ad.add(bVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z) {
        this.f39146a.c("setOutputMute, : ".concat(String.valueOf(z)));
        this.i = z;
        try {
            if (z) {
                this.C.setVolume(0.0f, 0.0f);
                this.f39146a.c("setOutputMute, true");
                return;
            }
            this.C.setVolume(this.j, this.j);
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("setOutputMute, false, mAudioGain: " + this.j);
        } catch (Exception e) {
            com.tencent.thumbplayer.e.a aVar2 = this.f39146a;
            aVar2.c("setOutputMute, Exception: " + e.toString());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z, long j, long j2) {
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("setLoopback, : " + z + ", loopStart: " + j + ", loopEnd: " + j2);
        if (j >= 0) {
            long j3 = this.T;
            if (j <= j3 && j2 <= j3) {
                this.f39147c = z;
                this.d = j;
                this.e = j2;
                this.C.setLooping(z);
                return;
            }
        }
        throw new IllegalArgumentException("position error, must more than 0 and less than duration");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long b(int i) {
        return -1L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(float f2) {
        this.f39146a.c("setPlaySpeedRatio, : ".concat(String.valueOf(f2)));
        if (Build.VERSION.SDK_INT < 23) {
            com.tencent.thumbplayer.e.a aVar = this.f39146a;
            aVar.c("os version is too low: " + Build.VERSION.SDK_INT);
            return;
        }
        this.k = f2;
        this.f39146a.c("setPlaySpeedRatio play speed:".concat(String.valueOf(f2)));
        try {
            PlaybackParams playbackParams = this.C.getPlaybackParams();
            if (playbackParams.getSpeed() != f2) {
                playbackParams.setSpeed(f2);
                this.C.setPlaybackParams(playbackParams);
            }
        } catch (Exception e) {
            this.f39146a.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(int i, long j) {
        this.f39146a.c("deselectTrack, trackID ".concat(String.valueOf(i)));
        int size = this.ad.size();
        int size2 = this.ae.size();
        if (i < size || i >= size2 + size) {
            if (Build.VERSION.SDK_INT < 16) {
                this.f39146a.e("deselectTrack, android mediaplayer not support ");
                return;
            } else {
                this.C.deselectTrack(i);
                return;
            }
        }
        int i2 = i - size;
        try {
            f(i2, j);
        } catch (Exception e) {
            this.f39146a.a(e);
        }
        this.ae.get(i2).f39157a.isSelected = false;
        this.ab = -1;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(boolean z) {
        this.f39146a.c("setLoopback, : ".concat(String.valueOf(z)));
        this.f39147c = z;
        this.C.setLooping(z);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPDynamicStatisticParams c(boolean z) {
        return null;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public String c(int i) {
        return null;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void c(int i, long j) {
        this.f39146a.e("selectProgram, android mediaplayer not support");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void f() {
        if (this.R == EnumC1011e.COMPLETE) {
            this.f39146a.d("call prepare() on mMediaPlayerState==COMPLETE");
            return;
        }
        x();
        this.f39146a.c("prepare ");
        this.Q = EnumC1011e.PREPARING;
        this.R = EnumC1011e.PREPARING;
        this.C.prepare();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void g() {
        x();
        this.f39146a.c("prepareAsync ");
        this.Q = EnumC1011e.PREPARING;
        this.R = EnumC1011e.PREPARING;
        this.C.prepareAsync();
        z();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void h() {
        com.tencent.thumbplayer.e.a aVar;
        String str;
        this.f39146a.c("start ");
        if (this.S) {
            f fVar = this.ah;
            if (fVar != null) {
                fVar.h = EnumC1011e.STARTED;
            }
            aVar = this.f39146a;
            str = "system player is busy.";
        } else if (this.Q == EnumC1011e.PREPARED || this.Q == EnumC1011e.PAUSED) {
            com.tencent.thumbplayer.adapter.a.a.a aVar2 = this.af;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.C.start();
            this.Q = EnumC1011e.STARTED;
            this.R = EnumC1011e.STARTED;
            float f2 = this.k;
            if (f2 != 1.0d) {
                b(f2);
            }
            B();
            return;
        } else {
            aVar = this.f39146a;
            str = "start(), illegal state, state:" + this.Q;
        }
        aVar.d(str);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void i() {
        synchronized (this) {
            this.f39146a.c("pause ");
            if (this.S) {
                if (this.ah != null) {
                    this.ah.h = EnumC1011e.PAUSED;
                }
                this.f39146a.d("system player is busy.");
                return;
            }
            if (this.af != null) {
                this.af.c();
            }
            this.C.pause();
            this.Q = EnumC1011e.PAUSED;
            this.R = EnumC1011e.PAUSED;
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void j() {
        synchronized (this) {
            this.f39146a.c("stop ");
            A();
            C();
            F();
            this.Q = EnumC1011e.STOPPED;
            c();
            this.aa = 0;
            this.ab = -1;
            this.ah = null;
            this.Z = -1;
            this.ac = -1;
            this.af.d();
            this.ag = 0L;
            this.f39146a.c("stop over.");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void k() {
        synchronized (this) {
            this.f39146a.c("reset ");
            this.Q = EnumC1011e.IDLE;
            this.R = EnumC1011e.IDLE;
            this.af.e();
            this.C.reset();
            this.m = 0;
            this.n = -1L;
            this.o = false;
            this.p = -1L;
            this.q = -1;
            this.r = -1;
            this.s = null;
            A();
            C();
            F();
            this.f39146a.c("reset over.");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void l() {
        synchronized (this) {
            this.f39146a.c("release ");
            this.af.f();
            A();
            C();
            F();
            this.Q = EnumC1011e.RELEASE;
            e();
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.F = null;
            this.f39146a.c("release over.");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long m() {
        if (this.o) {
            return 0L;
        }
        if (this.S) {
            return this.T;
        }
        if (this.Q == EnumC1011e.PREPARED || this.Q == EnumC1011e.STARTED || this.Q == EnumC1011e.PAUSED) {
            if (this.T <= 0) {
                this.T = this.C.getDuration();
            }
            long j = this.p;
            if (j > 0) {
                long j2 = this.T;
                if (j2 <= 0) {
                    this.T = j;
                } else {
                    long abs = Math.abs(j - j2);
                    long j3 = this.p;
                    if ((abs * 100) / j3 > 1) {
                        this.T = j3;
                    }
                }
            }
            return this.T;
        }
        return -1L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long n() {
        int i;
        if (this.o) {
            return 0L;
        }
        if (this.S || this.Q == EnumC1011e.ERROR) {
            long j = this.U;
            if (j != -1) {
                return j;
            }
        } else if (this.Q != EnumC1011e.IDLE && this.Q != EnumC1011e.INITIALIZED && this.Q != EnumC1011e.PREPARING && this.Q != EnumC1011e.STOPPED && this.Q != EnumC1011e.PREPARED) {
            i = this.C.getCurrentPosition();
            return i;
        }
        i = this.m;
        return i;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long o() {
        return 0L;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int p() {
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("getVideoWidth, width:" + this.V);
        return this.V;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int q() {
        com.tencent.thumbplayer.e.a aVar = this.f39146a;
        aVar.c("getVideoHeight, height:" + this.W);
        return this.W;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[LOOP:0: B:26:0x009e->B:28:0x00a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5 A[LOOP:1: B:30:0x00cb->B:32:0x00d5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0 A[EDGE_INSN: B:49:0x00c0->B:29:0x00c0 ?: BREAK  , SYNTHETIC] */
    @Override // com.tencent.thumbplayer.adapter.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.thumbplayer.api.TPTrackInfo[] r() {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.adapter.a.a.e.r():com.tencent.thumbplayer.api.TPTrackInfo[]");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPProgramInfo[] s() {
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
