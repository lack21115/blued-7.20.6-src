package com.blued.android.module.live_china.manager;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.activity.LiveFloatDialogActivity;
import com.blued.android.module.live_china.fragment.LivePlaySettingDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.AudioManagerUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.player.live.manager.LiveMediaPlayerManager;
import com.blued.android.module.player.live.manager.OnMediaPlayerListener;
import com.blued.android.module.player.live.view.BLVideoView;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager.class */
public class LiveFloatManager implements LiveChatInfoListener, AudioManagerUtils.AudioFocusCallback {
    private static volatile LiveFloatManager i;
    private boolean C;
    private WindowManager.LayoutParams E;
    private WindowManager F;
    private FrameLayout G;
    private View H;
    private View I;
    private View J;
    private View K;
    private View L;
    private ImageView M;
    private ImageView N;
    private float T;
    private float U;
    private float V;
    private float W;
    private float X;
    private float Y;
    public SurfaceView a;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private int aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private boolean ap;
    private boolean aq;
    private boolean at;
    private int au;
    private boolean ay;
    public BlLiveView b;
    public CardView c;
    public CardView d;
    PlayingOnliveFragment f;
    public LiveRoomCloseReason g;
    private String k;
    private String n;
    private String o;
    private OnMediaPlayerConnectListener p;
    private long y;
    private short l = 4;
    private long m = -1;
    private int q = 1;
    private Reconnect r = new Reconnect(this, null);
    private EnterLiveResult s = new EnterLiveResult(this, null);
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int z = -1;
    private boolean A = false;
    private boolean B = false;
    private boolean D = true;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private float Z = 0.0f;
    private float aa = 0.0f;
    private boolean ao = true;
    public boolean e = false;
    private int ar = 105;
    private int as = 187;
    private int av = -1;
    Handler h = new Handler(Looper.getMainLooper());
    private OnMediaPlayerListener aw = new AnonymousClass1();
    private SurfaceHolder.Callback ax = new SurfaceHolder.Callback() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.2
        int a;
        int b;

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            if (this.b != i4 || this.a != i3) {
                this.b = i4;
                this.a = i3;
                LiveFloatManager.this.j.j();
            }
            Log.v("ddrb", "surfaceChanged");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Logger.b("ddrb", "surfaceCreated");
            if (surfaceHolder != null) {
                this.b = LiveFloatManager.this.aj;
                this.a = LiveFloatManager.this.ai;
                LiveFloatManager.this.b();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LiveFloatManager.this.o();
            Log.v("ddrb", "surfaceDestroyed");
        }
    };
    private LiveMediaPlayerManager j = new LiveMediaPlayerManager();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.manager.LiveFloatManager$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager$1.class */
    public class AnonymousClass1 implements OnMediaPlayerListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (LiveFloatManager.this.f != null) {
                ViewParent parent = LiveFloatManager.this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.removeView(LiveFloatManager.this.b);
                    viewGroup.addView(LiveFloatManager.this.b);
                }
                if (LiveFloatManager.this.a == null || LiveFloatManager.this.a.getHolder() == null) {
                    LiveFloatManager.this.b();
                } else {
                    LiveFloatManager.this.a.getHolder().addCallback(LiveFloatManager.this.ax);
                }
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a() {
            LiveFloatManager.this.Q();
            if (LiveFloatManager.this.p != null) {
                LiveFloatManager.this.p.a();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a(int i, int i2) {
            if (LiveFloatManager.this.ag == i && LiveFloatManager.this.ah == i2) {
                return;
            }
            LiveFloatManager.this.ag = i;
            LiveFloatManager.this.ah = i2;
            LiveFloatManager.this.K();
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a(Bitmap bitmap) {
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void b() {
            LiveFloatManager.this.S();
            if (LiveFloatManager.this.p != null) {
                LiveFloatManager.this.p.b();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void c() {
            if (Build.VERSION.SDK_INT >= 26) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveFloatManager$1$PJKM35--bYcEbfJC3ZGsVUkxWeg
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveFloatManager.AnonymousClass1.this.f();
                    }
                });
            }
            LiveFloatManager.this.S();
            if (LiveFloatManager.this.p != null) {
                LiveFloatManager.this.p.c();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void d() {
            if (LiveFloatManager.this.v) {
                return;
            }
            LiveFloatManager.this.d();
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void e() {
            if (LiveFloatManager.this.v) {
                return;
            }
            LiveFloatManager.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.manager.LiveFloatManager$5  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager$5.class */
    public class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            if (LiveFloatManager.this.G != null && LiveRoomPreferences.N()) {
                if (LiveRoomInfo.a().H() != null) {
                    new LivePlaySettingDialogFragment(LiveRoomInfo.a().H(), 2).show();
                }
                LiveRoomPreferences.O();
            }
            LiveFloatManager.this.m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:117:0x055e A[Catch: Exception -> 0x05ad, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x05ad, blocks: (B:2:0x0000, B:11:0x001c, B:16:0x0077, B:26:0x00d0, B:31:0x00eb, B:41:0x014b, B:43:0x016d, B:45:0x018e, B:47:0x01a0, B:49:0x01b1, B:51:0x01d3, B:53:0x01f4, B:55:0x020e, B:57:0x0227, B:59:0x025d, B:61:0x0267, B:32:0x00f8, B:34:0x010e, B:36:0x012c, B:39:0x0140, B:17:0x0084, B:19:0x0092, B:21:0x00b0, B:24:0x00c4, B:63:0x027d, B:65:0x0292, B:67:0x02a7, B:69:0x02b1, B:71:0x02bb, B:73:0x02c8, B:75:0x02d1, B:77:0x02fc, B:79:0x0332, B:90:0x0416, B:101:0x04e8, B:103:0x0512, B:105:0x051c, B:107:0x0531, B:80:0x035c, B:82:0x036a, B:84:0x0380, B:86:0x0392, B:87:0x03b4, B:88:0x03e6, B:109:0x053f, B:111:0x0545, B:117:0x055e, B:92:0x042b, B:94:0x043d, B:96:0x0489, B:98:0x049b), top: B:129:0x0000, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ boolean a(final android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 1468
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.manager.LiveFloatManager.AnonymousClass5.a(android.view.View, android.view.MotionEvent):boolean");
        }

        @Override // java.lang.Runnable
        public void run() {
            Context d = AppInfo.d();
            boolean z = LiveFloatManager.this.z == 1;
            LiveFloatManager liveFloatManager = LiveFloatManager.this;
            liveFloatManager.ak = DensityUtils.a(d, z ? liveFloatManager.as : liveFloatManager.ar);
            LiveFloatManager liveFloatManager2 = LiveFloatManager.this;
            liveFloatManager2.al = DensityUtils.a(d, z ? liveFloatManager2.ar : liveFloatManager2.as);
            LiveFloatManager.this.am = (int) d.getResources().getDimension(z ? R.dimen.live_window_land_distance_bottom : R.dimen.live_window_distance_bottom);
            LiveFloatManager.this.an = (int) d.getResources().getDimension(z ? R.dimen.live_window_land_edge : R.dimen.live_window_edge);
            LiveFloatManager liveFloatManager3 = LiveFloatManager.this;
            liveFloatManager3.ae = z ? liveFloatManager3.ad : liveFloatManager3.ac;
            LiveFloatManager liveFloatManager4 = LiveFloatManager.this;
            liveFloatManager4.af = z ? liveFloatManager4.ac : liveFloatManager4.ad;
            LiveFloatManager.this.L();
            LiveFloatManager.this.G = (FrameLayout) LayoutInflater.from(d).inflate(z ? R.layout.live_float_land_window : R.layout.live_float_window, (ViewGroup) null);
            LiveFloatManager liveFloatManager5 = LiveFloatManager.this;
            liveFloatManager5.d = liveFloatManager5.G.findViewById(R.id.lay_container_parent);
            LiveFloatManager liveFloatManager6 = LiveFloatManager.this;
            liveFloatManager6.c = liveFloatManager6.G.findViewById(R.id.lay_container);
            LiveFloatManager liveFloatManager7 = LiveFloatManager.this;
            liveFloatManager7.H = liveFloatManager7.G.findViewById(R.id.tv_live_loading);
            LiveFloatManager liveFloatManager8 = LiveFloatManager.this;
            liveFloatManager8.I = liveFloatManager8.G.findViewById(R.id.av_live_loading);
            LiveFloatManager liveFloatManager9 = LiveFloatManager.this;
            liveFloatManager9.J = liveFloatManager9.G.findViewById(R.id.tv_live_load_fail);
            LiveFloatManager liveFloatManager10 = LiveFloatManager.this;
            liveFloatManager10.K = liveFloatManager10.G.findViewById(R.id.tv_live_load_over);
            LiveFloatManager liveFloatManager11 = LiveFloatManager.this;
            liveFloatManager11.L = liveFloatManager11.G.findViewById(R.id.img_live_load_fail);
            LiveFloatManager liveFloatManager12 = LiveFloatManager.this;
            liveFloatManager12.M = (ImageView) liveFloatManager12.G.findViewById(R.id.img_live_load_over);
            try {
                LiveFloatManager.this.N = (ImageView) LiveFloatManager.this.G.findViewById(R.id.img_header_bg);
            } catch (ClassCastException e) {
                Logger.b("ddrb", "AutoAttachRecyclingImageView classCastException so readd view");
                LiveFloatManager.this.N = new ImageView(AppInfo.d());
                ((ViewGroup) LiveFloatManager.this.G.findViewById(R.id.lay_load_status)).addView(LiveFloatManager.this.N, -1);
                e.printStackTrace();
            }
            LiveFloatManager.this.G.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveFloatManager$5$x9KKU1M4DhKWBtu54q3szTdlX8U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveFloatManager.AnonymousClass5.this.a(view);
                }
            });
            LiveFloatManager.this.G.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveFloatManager$5$dompYSg7HIxM5YqMewTMmVpEEcc
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean a;
                    a = LiveFloatManager.AnonymousClass5.this.a(view, motionEvent);
                    return a;
                }
            });
            LiveFloatManager.this.at = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager$EnterLiveResult.class */
    public class EnterLiveResult implements Runnable {
        private EnterLiveResult() {
        }

        /* synthetic */ EnterLiveResult(LiveFloatManager liveFloatManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!LiveRoomCloseReason.isCloseByNormal(LiveFloatManager.this.g)) {
                LiveFloatManager.this.W();
            } else if (LiveFloatManager.this.u || LiveFloatManager.this.w) {
            } else {
                LiveFloatManager.this.W();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager$OnMediaPlayerConnectListener.class */
    public interface OnMediaPlayerConnectListener {
        void a();

        void a(LiveRoomCloseReason liveRoomCloseReason);

        void a(boolean z);

        void b();

        void b(LiveRoomCloseReason liveRoomCloseReason);

        void c();

        void d();

        void e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveFloatManager$Reconnect.class */
    public class Reconnect implements Runnable {
        private Reconnect() {
        }

        /* synthetic */ Reconnect(LiveFloatManager liveFloatManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveFloatManager.this.j.b();
        }
    }

    private LiveFloatManager() {
    }

    public static boolean U() {
        return "Xiaomi".equals(Build.MANUFACTURER);
    }

    private void V() {
        LiveMsgSendManager.a().b(this.l, this.m, this);
        LiveMsgSendManager.a().a(this.l, this.m, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        j();
        if (LiveRoomCloseReason.isCloseByNormal(this.g)) {
            T();
        } else {
            R();
        }
        OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
        if (onMediaPlayerConnectListener != null) {
            this.v = true;
            onMediaPlayerConnectListener.a(this.g);
        }
    }

    private void X() {
        LiveRoomInfo.a().x();
        VideoPlayConfig.c(1);
        this.b.a();
        if (VideoPlayConfig.c() == 1) {
            b();
            return;
        }
        if (this.a == null && (this.b.getChildAt(0) instanceof SurfaceView)) {
            this.a = (SurfaceView) this.b.getChildAt(0);
        }
        SurfaceView surfaceView = this.a;
        if (surfaceView == null || surfaceView.getHolder() == null) {
            return;
        }
        this.a.getHolder().addCallback(this.ax);
    }

    private void Y() {
        synchronized (this) {
            this.h.post(new AnonymousClass5());
        }
    }

    private void Z() {
        O();
        Y();
        if (this.e) {
            a(LiveRoomManager.a().p() != null ? LiveRoomManager.a().p().elapse_time : 0L, this.av);
        } else if (this.p != null) {
            M();
        }
    }

    public static LiveFloatManager a() {
        if (i == null) {
            synchronized (LiveFloatManager.class) {
                try {
                    if (i == null) {
                        i = new LiveFloatManager();
                        i.J();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 19 ? a(context, 24) : (context.getApplicationInfo().flags & 134217728) == 134217728;
    }

    public static boolean a(Context context, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            Logger.d("xpf", "Below API 19 cannot invoke!");
            return false;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class.forName(appOpsManager.getClass().getName());
            int intValue = ((Integer) appOpsManager.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
            Logger.d("xpf", " invoke property:", Integer.valueOf(intValue));
            return intValue == 0;
        } catch (Exception e) {
            Logger.d("xpf", e.getMessage());
            return false;
        }
    }

    private void aa() {
        synchronized (this) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.6
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveFloatManager.this.b != null) {
                        FrameLayout.LayoutParams layoutParams = LiveFloatManager.this.b.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(LiveFloatManager.this.ai, LiveFloatManager.this.aj);
                        } else {
                            layoutParams.width = LiveFloatManager.this.ai;
                            layoutParams.height = LiveFloatManager.this.aj;
                        }
                        LiveFloatManager.this.b.setLayoutParams(layoutParams);
                        Log.v("pk", "setSurfaceParams");
                    }
                }
            });
        }
    }

    private void ab() {
        try {
            if (LiveRoomInfo.a().b(AppInfo.d())) {
                Point point = new Point();
                ((WindowManager) AppInfo.d().getSystemService("window")).getDefaultDisplay().getSize(point);
                this.ac = point.x;
                int i2 = point.y;
                this.ad = i2;
                this.ae = this.ac;
                this.af = i2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ float g(LiveFloatManager liveFloatManager, float f) {
        float f2 = liveFloatManager.X + f;
        liveFloatManager.X = f2;
        return f2;
    }

    static /* synthetic */ float h(LiveFloatManager liveFloatManager, float f) {
        float f2 = liveFloatManager.Y + f;
        liveFloatManager.Y = f2;
        return f2;
    }

    public boolean A() {
        return this.u;
    }

    public boolean B() {
        return this.v;
    }

    public boolean C() {
        return this.A;
    }

    public String D() {
        return this.n;
    }

    public int E() {
        return this.ac;
    }

    public int F() {
        return this.ad;
    }

    public boolean G() {
        return this.B;
    }

    public boolean H() {
        return this.C;
    }

    public void I() {
        this.ap = true;
    }

    public void J() {
        try {
            Context d = AppInfo.d();
            if (this.E != null) {
                return;
            }
            this.E = new WindowManager.LayoutParams();
            this.F = (WindowManager) d.getSystemService("window");
            Logger.b("ddrb", "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT));
            if (Build.VERSION.SDK_INT >= 26) {
                this.E.type = 2038;
            } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 23) {
                this.E.type = 2003;
            } else {
                this.E.type = 2005;
            }
            this.E.format = 1;
            this.E.flags = 8;
            this.E.gravity = 51;
            this.E.width = -2;
            this.E.height = -2;
            View inflate = LayoutInflater.from(d).inflate(R.layout.live_float_surface_view, (ViewGroup) null);
            LiveRoomInfo.a().x();
            VideoPlayConfig.c(1);
            BlLiveView blLiveView = (BlLiveView) inflate.findViewById(R.id.live_float_player_live_view);
            this.b = blLiveView;
            blLiveView.a();
            if (this.b.getChildAt(0) != null && (this.b.getChildAt(0) instanceof SurfaceView)) {
                this.a = (SurfaceView) this.b.getChildAt(0);
            }
            if (this.a != null) {
                this.a.getHolder().addCallback(this.ax);
            } else {
                b();
            }
            ab();
            Y();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void K() {
        float min;
        synchronized (this) {
            if (this.ag != 0 && this.ah != 0 && this.ai != 0 && this.aj != 0) {
                Logger.b("ddrb", "111111 data: mVideoWidth:", Integer.valueOf(this.ag), "   mVideoHeight:", Integer.valueOf(this.ah), " mSurfaceWidth:", Integer.valueOf(this.ai), "   mSurfaceHeight:", Integer.valueOf(this.aj));
                float f = this.ag / this.ai;
                float f2 = this.ah / this.aj;
                if (this.O) {
                    min = f;
                    if (this.ai > this.aj) {
                        min = f2;
                    }
                } else if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().live_type != 1) {
                    min = Math.min(f, f2);
                    Logger.b("ddrb", "Math.min: ratio =", Float.valueOf(min));
                } else {
                    min = f;
                    if (this.A) {
                        min = Math.max(f, f2);
                    }
                }
                Logger.b("ddrb", "before data: mVideoWidth:", Integer.valueOf(this.ag), "   mVideoHeight:", Integer.valueOf(this.ah), " mSurfaceWidth:", Integer.valueOf(this.ai), "   mSurfaceHeight:", Integer.valueOf(this.aj), "   ratio = ", Float.valueOf(min));
                Logger.b("ddrb", "====ratio:", Float.valueOf(min));
                this.ai = (int) Math.ceil(this.ag / min);
                this.aj = (int) Math.ceil(this.ah / min);
            }
            Logger.b("ddrb", "after data: mVideoWidth:", Integer.valueOf(this.ag), "   mVideoHeight:", Integer.valueOf(this.ah), " mSurfaceWidth:", Integer.valueOf(this.ai), "   mSurfaceHeight:", Integer.valueOf(this.aj));
            aa();
        }
    }

    public int L() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.ab = AppInfo.d().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.ab;
    }

    public void M() {
        synchronized (this) {
            this.Q = true;
            this.e = false;
            this.R = false;
            O();
            this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.7
                @Override // java.lang.Runnable
                public void run() {
                    LiveFloatManager liveFloatManager = LiveFloatManager.this;
                    liveFloatManager.ai = liveFloatManager.ae;
                    LiveFloatManager liveFloatManager2 = LiveFloatManager.this;
                    liveFloatManager2.aj = liveFloatManager2.af;
                    LiveFloatManager.this.K();
                }
            });
        }
    }

    public void N() {
        synchronized (this) {
            this.h.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LiveFloatManager.this.O || !LiveFloatManager.this.e) {
                            return;
                        }
                        LiveFloatManager.this.F.addView(LiveFloatManager.this.G, LiveFloatManager.this.E);
                        LiveFloatManager.this.O = true;
                        LiveFloatManager.this.ai = LiveFloatManager.this.ak;
                        LiveFloatManager.this.aj = LiveFloatManager.this.al;
                        LiveFloatManager.this.K();
                        if (LiveFloatManager.this.ao) {
                            LiveFloatManager.this.E.x = (LiveFloatManager.this.ac - LiveFloatManager.this.an) - LiveFloatManager.this.ai;
                            LiveFloatManager.this.E.y = ((LiveFloatManager.this.ad - LiveFloatManager.this.ab) - LiveFloatManager.this.aj) - LiveFloatManager.this.am;
                            LiveFloatManager.this.Z = LiveFloatManager.this.E.x;
                            LiveFloatManager.this.aa = LiveFloatManager.this.E.y;
                            LiveFloatManager.this.ao = false;
                        } else {
                            float f = LiveFloatManager.this.Z;
                            float f2 = LiveFloatManager.this.ai / 2;
                            float f3 = LiveFloatManager.this.aa + (LiveFloatManager.this.aj / 2);
                            if (f3 <= LiveFloatManager.this.aj) {
                                LiveFloatManager.this.aa = LiveFloatManager.this.an + LiveFloatManager.this.ab;
                            } else if (f3 <= LiveFloatManager.this.aj || f3 >= LiveFloatManager.this.ad - LiveFloatManager.this.aj) {
                                LiveFloatManager.this.aa = (LiveFloatManager.this.ad - LiveFloatManager.this.an) - LiveFloatManager.this.aj;
                            } else if (f + f2 <= LiveFloatManager.this.ac / 2) {
                                LiveFloatManager.this.Z = LiveFloatManager.this.an;
                            } else {
                                LiveFloatManager.this.Z = (LiveFloatManager.this.ac - LiveFloatManager.this.an) - LiveFloatManager.this.ai;
                            }
                            LiveFloatManager.this.E.x = (int) LiveFloatManager.this.Z;
                            LiveFloatManager.this.E.y = (int) (LiveFloatManager.this.aa - LiveFloatManager.this.ab);
                        }
                        LiveFloatManager.this.d.setCardBackgroundColor(LiveRoomInfo.a().h() ? -16777216 : -1);
                        LiveFloatManager.this.c.addView(LiveFloatManager.this.P(), -1);
                        LiveFloatManager.this.c.getParent().requestLayout();
                        if (LiveFloatManager.this.R && LiveFloatManager.this.O) {
                            try {
                                LiveFloatManager.this.F.updateViewLayout(LiveFloatManager.this.G, LiveFloatManager.this.E);
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.v("pk", "requestFocus");
                        LiveFloatManager.this.b.requestFocus();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }, 300L);
        }
    }

    public void O() {
        synchronized (this) {
            this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LiveFloatManager.this.O) {
                            LiveFloatManager.this.F.removeView(LiveFloatManager.this.G);
                            LiveFloatManager.this.O = false;
                            LiveEventBus.get("live_float_dismiss").post("");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public BlLiveView P() {
        BlLiveView blLiveView;
        synchronized (this) {
            if (this.b != null) {
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
            }
            Log.v("pk", "getSurafceView");
            blLiveView = this.b;
        }
        return blLiveView;
    }

    public void Q() {
        synchronized (this) {
            this.w = false;
            this.x = false;
            this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.10
                @Override // java.lang.Runnable
                public void run() {
                    LiveFloatManager.this.H.setVisibility(0);
                    LiveFloatManager.this.I.setVisibility(0);
                    LiveFloatManager.this.J.setVisibility(8);
                    LiveFloatManager.this.L.setVisibility(8);
                    LiveFloatManager.this.K.setVisibility(8);
                    LiveFloatManager.this.M.setVisibility(8);
                    LiveFloatManager.this.N.setVisibility(8);
                }
            });
        }
    }

    public void R() {
        synchronized (this) {
            this.w = false;
            this.x = true;
            this.h.removeCallbacks(this.r);
            this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.11
                @Override // java.lang.Runnable
                public void run() {
                    LiveFloatManager.this.H.setVisibility(8);
                    LiveFloatManager.this.I.setVisibility(8);
                    LiveFloatManager.this.J.setVisibility(0);
                    LiveFloatManager.this.L.setVisibility(0);
                    LiveFloatManager.this.K.setVisibility(8);
                    LiveFloatManager.this.M.setVisibility(8);
                    LiveFloatManager.this.N.setVisibility(8);
                }
            });
        }
    }

    public void S() {
        synchronized (this) {
            if (this.K.getVisibility() != 0 && this.J.getVisibility() != 0) {
                if (!LiveRoomInfo.a().w()) {
                    h();
                }
                this.w = true;
                this.x = false;
                this.q = 1;
                this.h.removeCallbacks(this.s);
                this.h.removeCallbacks(this.r);
                this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.12
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveFloatManager.this.H.setVisibility(8);
                        LiveFloatManager.this.I.setVisibility(8);
                        LiveFloatManager.this.J.setVisibility(8);
                        LiveFloatManager.this.L.setVisibility(8);
                        LiveFloatManager.this.K.setVisibility(8);
                        LiveFloatManager.this.M.setVisibility(8);
                        LiveFloatManager.this.N.setVisibility(8);
                    }
                });
                return;
            }
            h();
        }
    }

    public void T() {
        synchronized (this) {
            this.w = false;
            this.x = false;
            this.h.removeCallbacks(this.r);
            this.h.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.13
                @Override // java.lang.Runnable
                public void run() {
                    LiveFloatManager.this.q();
                    LiveFloatManager.this.H.setVisibility(8);
                    LiveFloatManager.this.I.setVisibility(8);
                    LiveFloatManager.this.J.setVisibility(8);
                    LiveFloatManager.this.L.setVisibility(8);
                    LiveFloatManager.this.K.setVisibility(0);
                    LiveFloatManager.this.M.setVisibility(0);
                    LiveFloatManager.this.N.setVisibility(0);
                    if (LiveRoomManager.a().t() || TextUtils.isEmpty(LiveRoomManager.a().p().profile.avatar)) {
                        return;
                    }
                    ImageLoader.a((IRequestHost) null, LiveRoomManager.a().p().profile.avatar).d().a(new ImageLoadResult(null) { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.13.1
                        @Override // com.blued.android.core.image.ImageLoadResult
                        public void a() {
                            RelativeLayout.LayoutParams layoutParams = LiveFloatManager.this.N.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new RelativeLayout.LayoutParams(LiveFloatManager.this.ai, LiveFloatManager.this.aj);
                            } else {
                                layoutParams.width = LiveFloatManager.this.ai;
                                layoutParams.height = LiveFloatManager.this.aj;
                            }
                            LiveFloatManager.this.N.setLayoutParams(layoutParams);
                        }
                    }).a(LiveFloatManager.this.N);
                }
            });
        }
    }

    @Override // com.blued.android.module.live_china.manager.AudioManagerUtils.AudioFocusCallback
    public void a(int i2) {
        if (i2 == -2) {
            Log.i("==xpm", "AUDIOFOCUS_LOSS_TRANSIENT");
            if (this.C) {
                j();
            }
            this.ay = true;
        } else if (i2 == -1) {
            Log.i("==xpm", "AUDIOFOCUS_LOSS");
            if (this.C) {
                h();
            }
        } else if (i2 != 1) {
        } else {
            Log.i("==xpm", "AUDIOFOCUS_GAIN:" + this.ay);
            if (this.ay && this.C) {
                AudioManagerUtils.a().b();
                i();
                this.ay = false;
            }
        }
    }

    public void a(int i2, int i3) {
        this.ai = i2;
        this.aj = i3;
        Logger.a("drb", "setSurfaceWidthHeight width = ", Integer.valueOf(i2), " -- height = ", Integer.valueOf(i3));
        K();
    }

    public void a(long j) {
        synchronized (this) {
            a((PlayingOnliveFragment) null);
            a((OnMediaPlayerConnectListener) null);
            if (LiveRoomManager.a().p() != null) {
                LiveRoomManager.a().p().elapse_time = j;
            }
            this.y = System.currentTimeMillis();
            N();
            if (LiveRoomPreferences.s() == 0 && U() && !a(AppInfo.d())) {
                Intent intent = new Intent(AppInfo.d(), LiveFloatDialogActivity.class);
                intent.putExtra("flag", 1);
                intent.addFlags(268435456);
                AppInfo.d().startActivity(intent);
                LiveRoomPreferences.d(1);
            }
        }
    }

    public void a(long j, int i2) {
        synchronized (this) {
            this.av = i2;
            this.e = true;
            this.R = true;
            this.Q = false;
            if (Build.VERSION.SDK_INT < 23) {
                a(j);
            } else if (Settings.canDrawOverlays(AppInfo.d())) {
                a(j);
            } else {
                if (AppMethods.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + AppInfo.d().getPackageManager())))) {
                    Intent intent = new Intent(AppInfo.d(), LiveFloatDialogActivity.class);
                    intent.putExtra("flag", 2);
                    intent.putExtra("timer", j);
                    intent.addFlags(268435456);
                    AppInfo.d().startActivity(intent);
                } else {
                    n();
                    AppMethods.d(R.string.live_float_toast);
                }
            }
        }
    }

    public void a(PlayingOnliveFragment playingOnliveFragment) {
        this.f = playingOnliveFragment;
        if (playingOnliveFragment != null) {
            this.ap = false;
        }
    }

    public void a(OnMediaPlayerConnectListener onMediaPlayerConnectListener) {
        this.p = onMediaPlayerConnectListener;
        if (onMediaPlayerConnectListener != null) {
            if (this.v) {
                r();
            } else if (this.t) {
                if (!this.u || LiveRoomManager.a().p() == null) {
                    r();
                } else {
                    this.p.a(false);
                }
            }
        }
    }

    public void a(String str, short s, long j, String str2, int i2) {
        synchronized (this) {
            this.z = i2;
            if (this.ac == 0) {
                ab();
            }
            if (this.z == 1) {
                this.A = true;
                if (this.ak < this.al) {
                    Z();
                }
            } else {
                this.A = false;
                if (this.ak > this.al) {
                    Z();
                }
            }
            if (TextUtils.equals(this.k, str)) {
                return;
            }
            if (this.j.a()) {
                n();
            }
            this.k = str;
            this.q = 1;
            this.w = false;
            this.x = false;
            this.v = false;
            this.R = true;
            this.S = false;
            this.h.removeCallbacks(this.r);
            X();
            Q();
            V();
            this.ay = false;
            AudioManagerUtils.a().a(this);
            AudioManagerUtils.a().b();
        }
    }

    public void a(final short s, final long j, String str, final int i2) {
        Logger.b("rrrb", "enterLiveChat start");
        this.au = i2;
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomData> bluedEntityA) {
                Logger.b("rrrb", "enterLiveChat success:", Long.valueOf(j));
                if (!LiveFloatManager.this.C) {
                    Logger.b("rrrb", "live room has close");
                } else if (LiveRoomManager.a().d() != j) {
                } else {
                    LiveUploadTimerManager.a(LiveRoomManager.a().e());
                    LiveRoomData singleData = bluedEntityA.getSingleData();
                    if (TextUtils.isEmpty(LiveFloatManager.this.k) && singleData != null && singleData.screen_pattern == 1) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    LiveFloatManager.this.t = true;
                    if (singleData == null) {
                        LiveFloatManager.this.u = false;
                        LiveFloatManager.this.g = new LiveRoomCloseReason(0, "");
                        LiveFloatManager.this.r();
                        Logger.b("rrrb", "mLiveRoomData null");
                    } else {
                        Logger.a("rrrb", "enterLiveChat videoPath = ", LiveFloatManager.this.k);
                        singleData.lid = j;
                        if (LiveRoomManager.a().p() != null) {
                            singleData.rankingExtra = LiveRoomManager.a().p().rankingExtra;
                            singleData.isFollow = LiveRoomManager.a().p().isFollow;
                            singleData.relationship = LiveRoomManager.a().p().relationship;
                            singleData.comeCode = LiveRoomManager.a().p().comeCode;
                            singleData.liveOneKissModel = LiveRoomManager.a().p().liveOneKissModel;
                            singleData.liveProp = i2;
                        }
                        if (LiveFloatManager.this.f != null) {
                            singleData.recommendType = LiveFloatManager.this.f.ck;
                            singleData.liveFrom = LiveFloatManager.this.f.cl;
                            singleData.livePosition = LiveFloatManager.this.f.cm;
                        }
                        LiveRoomManager.a().a(singleData);
                        if (TextUtils.isEmpty(LiveFloatManager.this.k) || LiveFloatManager.this.m != j) {
                            if (LiveFloatManager.this.f == null) {
                                return;
                            }
                            Logger.a("rrrb", "enterLiveChat videoPath = ", LiveFloatManager.this.k);
                            LiveFloatManager.this.a(singleData.live_url, s, j, LiveFloatManager.this.n, singleData.screen_pattern);
                            Log.v("onInfo", "onEnterSuccess");
                            LiveFloatManager.this.b();
                        }
                        LiveFloatManager.this.u = true;
                    }
                    if (LiveFloatManager.this.p != null) {
                        LiveFloatManager.this.p.a(true);
                    } else {
                        LiveFloatManager.this.B = true;
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str2) {
                Logger.b("ddrb", "enterLiveChat failed:", Long.valueOf(j));
                if (!LiveFloatManager.this.C) {
                    Logger.b("ddrb", "live room has close");
                    return true;
                } else if (LiveRoomManager.a().d() != j) {
                    return true;
                } else {
                    LiveFloatManager.this.g = new LiveRoomCloseReason(i3, str2);
                    LiveFloatManager.this.t = true;
                    LiveFloatManager.this.u = false;
                    LiveFloatManager.this.r();
                    if (LiveFloatManager.this.p != null) {
                        LiveFloatManager.this.p.b(LiveFloatManager.this.g);
                        return true;
                    }
                    return true;
                }
            }
        }, j, str, 1, i2);
    }

    public void a(short s, long j, String str, int i2, String str2, int i3) {
        this.C = true;
        this.n = str;
        this.au = i3;
        this.o = str2;
        this.m = j;
        if (LiveRoomManager.a().p() != null) {
            String str3 = LiveRoomManager.a().p().live_url;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    a(AesCrypto.e(str3), s, j, this.n, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        LiveEventBus.get("live_open_close").post(true);
    }

    public void a(boolean z) {
        this.aq = z;
    }

    public void b() {
        synchronized (this) {
            Logger.b("rrrb", "prepare mVideoPath = ", this.k);
            if (TextUtils.isEmpty(this.k)) {
                Logger.b("rrrb", "prepare mVideoPath empty");
                return;
            }
            try {
                LiveRoomInfo.a().x();
                VideoPlayConfig.c(1);
                this.j.a(this.k, this.b);
                this.j.a(this.aw);
                Log.v("pk", "prepare prepareAsync");
            } catch (Exception e) {
                n();
                e.printStackTrace();
            }
        }
    }

    public void b(boolean z) {
        this.Q = z;
    }

    public void c() {
        if (this.j.a()) {
            this.q = 1;
            V();
            LiveRoomHttpUtils.a(String.valueOf(this.m), this.n);
            a(this.l, this.m, this.n, this.au);
            d();
            return;
        }
        Q();
        OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
        if (onMediaPlayerConnectListener != null) {
            onMediaPlayerConnectListener.d();
        }
    }

    public void c(boolean z) {
        this.P = z;
    }

    public void d() {
        Q();
        OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
        if (onMediaPlayerConnectListener != null) {
            onMediaPlayerConnectListener.d();
        }
        int i2 = this.q;
        if (i2 < 10) {
            this.q = i2 + 1;
            e();
            return;
        }
        R();
        OnMediaPlayerConnectListener onMediaPlayerConnectListener2 = this.p;
        if (onMediaPlayerConnectListener2 != null) {
            onMediaPlayerConnectListener2.e();
        }
    }

    public void d(boolean z) {
        this.A = z;
        BLVideoView.a = z;
        if (LiveDataManager.a().f() != z) {
            LiveDataManager.a().a(z);
            LiveEventBus.get("screen_orientation_changed").post(true);
        }
    }

    public void e() {
        this.h.removeCallbacks(this.r);
        this.h.postDelayed(this.r, 3000L);
    }

    public void e(boolean z) {
        this.B = z;
    }

    public void f() {
        synchronized (this) {
            this.j.c();
        }
    }

    public void g() {
        if (Build.VERSION.SDK_INT >= 26) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveFloatManager.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = LiveFloatManager.this.b.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.removeView(LiveFloatManager.this.b);
                        viewGroup.addView(LiveFloatManager.this.b);
                    }
                    if (LiveFloatManager.this.a == null || LiveFloatManager.this.a.getHolder() == null) {
                        LiveFloatManager.this.b.a();
                    } else {
                        LiveFloatManager.this.a.getHolder().addCallback(LiveFloatManager.this.ax);
                    }
                }
            }, 500L);
        }
    }

    public void h() {
        synchronized (this) {
            this.j.d();
        }
    }

    public void i() {
        this.j.e();
        this.j.c();
    }

    public void j() {
        this.j.f();
    }

    public void k() {
        synchronized (this) {
            if (this.at) {
                LiveUploadTimerManager.d();
                Logger.a("ddrb", "startAndShowFloatWindow mIsLiveRoomInit = ", Boolean.valueOf(this.C), "-- mIsInterruptLiveClose = ", Boolean.valueOf(this.ap));
                if (this.C && (this.ap || this.f != null || this.e)) {
                    i();
                    AudioManagerUtils.a().b();
                    N();
                } else {
                    m();
                }
            }
        }
    }

    public void l() {
        synchronized (this) {
            if (this.at) {
                LiveUploadTimerManager.c();
                if (this.C) {
                    if (this.f != null && this.f.aR) {
                        return;
                    }
                    if (!LiveRoomManager.a().F()) {
                        h();
                        AudioManagerUtils.a().a(false);
                    }
                    O();
                }
            }
        }
    }

    public void m() {
        synchronized (this) {
            Logger.a("ddrb", "closeFloatWindow");
            this.Q = false;
            O();
            n();
        }
    }

    public void n() {
        synchronized (this) {
            Logger.a("ddrb", LoaderConstants.CLOSE);
            p();
            AudioManagerUtils.a().a((AudioManagerUtils.AudioFocusCallback) null);
            AudioManagerUtils.a().a(false);
        }
    }

    public void o() {
        synchronized (this) {
            this.j.g();
        }
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onClose(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        this.v = true;
        this.g = new LiveRoomCloseReason(LiveRoomCloseReason.REASON.NORMAL, "");
        T();
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onJoinLive(JoinLiveResult joinLiveResult, String str, String str2, String str3) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onRecvNewMsg(ChattingModel chattingModel) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerDataChanged(long j, List<ProfileData> list) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerEntrance(EntranceData entranceData, long j) {
    }

    public void p() {
        synchronized (this) {
            if (this.at && this.m != -1) {
                LiveUploadTimerManager.b();
                q();
                LiveMsgSendManager.a().b(this.l, this.m, this);
                LiveRoomHttpUtils.a(String.valueOf(this.m), this.n);
                this.h.removeCallbacks(this.r);
                a((OnMediaPlayerConnectListener) null);
                Q();
                this.g = null;
                this.j.h();
                LiveRoomManager.a().o();
                this.n = null;
                this.au = 0;
                this.m = -1L;
                this.aq = false;
                this.q = 1;
                this.w = false;
                this.x = false;
                this.u = false;
                this.t = false;
                this.v = false;
                this.R = true;
                this.S = false;
                this.B = false;
                this.z = -1;
                this.A = false;
                this.e = false;
                this.k = null;
                this.ag = 0;
                this.ah = 0;
                this.ap = false;
                this.C = false;
                if (this.f != null) {
                    if (this.f.getActivity() != null) {
                        this.f.getActivity().finish();
                    }
                    this.f = null;
                }
                LiveEventBus.get("live_open_close").post(false);
            }
        }
    }

    public void q() {
        synchronized (this) {
            this.j.i();
        }
    }

    public void r() {
        synchronized (this) {
            Logger.b("ddrb", "live miss reason:", this.g);
            if (!this.v && LiveRoomCloseReason.isCloseByNormal(this.g)) {
                this.h.removeCallbacks(this.s);
                this.h.postDelayed(this.s, 3000L);
                return;
            }
            W();
        }
    }

    public void s() {
        if (this.j.a() && this.z == 1) {
            Logger.a("ddrb", "PlayingOnliveFragment.show");
            if (LiveRoomManager.a().p() != null) {
                PlayingOnliveFragment.a(AppInfo.d(), LiveRoomManager.a().p(), -1, LiveDataListManager.a().b());
            }
        }
    }

    public boolean t() {
        return this.w;
    }

    public boolean u() {
        return this.x;
    }

    public long v() {
        return this.m;
    }

    public boolean w() {
        return this.aq;
    }

    public boolean x() {
        return this.O;
    }

    public boolean y() {
        return this.P;
    }

    public boolean z() {
        return this.Q;
    }
}
