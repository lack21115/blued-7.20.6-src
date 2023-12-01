package com.anythink.basead.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.a.b.g;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.core.common.k.h;
import com.anythink.expressad.exoplayer.ad;
import com.anythink.expressad.exoplayer.d;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.i;
import com.anythink.expressad.exoplayer.i.c;
import com.anythink.expressad.exoplayer.l.g;
import com.anythink.expressad.exoplayer.w;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PlayerView.class */
public class PlayerView extends RelativeLayout {
    public static final String TAG = PlayerView.class.getSimpleName();
    private Handler A;
    private boolean B;
    private Thread C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private View H;
    private w.c I;
    private g J;

    /* renamed from: a */
    int f6155a;
    int b;

    /* renamed from: c */
    int f6156c;
    boolean d;
    String e;
    private ad f;
    private s g;
    private TextureView h;
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private a z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PlayerView$2 */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PlayerView$2.class */
    public final class AnonymousClass2 extends w.a {
        AnonymousClass2() {
            PlayerView.this = r4;
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
            boolean z;
            long j;
            String str;
            super.onPlayerError(gVar);
            String str2 = "Play error and ExoPlayer have not message.";
            if (gVar != null) {
                int i = gVar.d;
                boolean z2 = true;
                if (i != 0) {
                    if (i == 1) {
                        str2 = "Play error, because have a RendererException.";
                    } else if (i == 2) {
                        str2 = "Play error, because have a UnexpectedException.";
                    }
                    z2 = false;
                    str = str2;
                } else {
                    str = "Play error, because have a SourceException.";
                }
                str2 = str;
                z = z2;
                if (gVar.getCause() != null) {
                    str2 = str;
                    z = z2;
                    if (!TextUtils.isEmpty(gVar.getCause().getMessage())) {
                        str2 = str + ",eception:" + gVar.getCause().getMessage();
                        z = z2;
                    }
                }
            } else {
                z = false;
            }
            if (PlayerView.this.d && z) {
                String str3 = PlayerView.TAG;
                StringBuilder sb = new StringBuilder("ExoPlayer onPlayerError()...error:");
                sb.append(str2);
                sb.append(",and rePrepareVideoSourceAgain");
                PlayerView.this.d = false;
                PlayerView.p(PlayerView.this);
                return;
            }
            String str4 = PlayerView.TAG;
            PlayerView.this.e();
            if (PlayerView.this.z != null) {
                try {
                    j = PlayerView.this.f.t();
                } catch (Throwable th) {
                    j = 0;
                }
                String str5 = j <= 0 ? f.o : f.k;
                String str6 = "videoUrl:" + PlayerView.this.j + ",readyRate:" + PlayerView.this.f6156c + ",cdRate:" + PlayerView.this.b + ",play process:" + j + ",errorMessage:" + str2;
                if (PlayerView.this.x) {
                    PlayerView.this.z.a(f.a(str5, f.C.concat(String.valueOf(str6))));
                } else {
                    PlayerView.this.z.a(f.a(str5, f.K.concat(String.valueOf(str6))));
                }
            }
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerStateChanged(boolean z, int i) {
            PlayerView playerView;
            PlayerView playerView2;
            PlayerView playerView3;
            PlayerView playerView4;
            super.onPlayerStateChanged(z, i);
            String str = PlayerView.TAG;
            if (i == 2) {
                if (PlayerView.this.y) {
                    return;
                }
                PlayerView.this.y = true;
                PlayerView.v(PlayerView.this);
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                PlayerView.this.e();
                PlayerView.y(PlayerView.this);
                PlayerView playerView5 = PlayerView.this;
                playerView5.m = playerView5.n;
                if (PlayerView.this.z != null) {
                    PlayerView.this.z.c();
                }
            } else {
                if (!PlayerView.this.x) {
                    PlayerView.w(PlayerView.this);
                    PlayerView.this.y = false;
                    PlayerView playerView6 = PlayerView.this;
                    playerView6.n = (int) playerView6.f.s();
                    if (PlayerView.this.z != null) {
                        PlayerView.this.z.c(PlayerView.this.n);
                    }
                    PlayerView.this.o = Math.round(playerView.n * 0.25f);
                    PlayerView.this.p = Math.round(playerView2.n * 0.5f);
                    PlayerView.this.q = Math.round(playerView3.n * 0.75f);
                    if (PlayerView.this.f6156c <= 0 || PlayerView.this.f6156c >= 100) {
                        PlayerView.this.G = false;
                    } else {
                        if (PlayerView.this.b > PlayerView.this.f6156c) {
                            PlayerView playerView7 = PlayerView.this;
                            playerView7.b = playerView7.f6156c / 2;
                        }
                        PlayerView.this.f6155a = Math.round(((playerView4.b * 1.0f) / 100.0f) * PlayerView.this.n);
                        PlayerView.this.f6155a -= 2000;
                        PlayerView.this.G = true;
                    }
                }
                if (PlayerView.this.m <= 0 || PlayerView.this.m == PlayerView.this.f.t()) {
                    return;
                }
                PlayerView.this.f.a(PlayerView.this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.PlayerView$3 */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PlayerView$3.class */
    public final class AnonymousClass3 implements g {
        AnonymousClass3() {
            PlayerView.this = r4;
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a(int i, int i2) {
            PlayerView playerView = PlayerView.this;
            playerView.autoFitVideoSize(i, i2, playerView.h);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PlayerView$a.class */
    public interface a {
        void a();

        void a(int i);

        void a(e eVar);

        void b();

        void b(int i);

        void c();

        void c(int i);

        void d();

        void e();

        void f();

        void g();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/PlayerView$b.class */
    static final class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.anythink.basead.ui.PlayerView.b.1
            private static b a(Parcel parcel) {
                return new b(parcel);
            }

            private static b[] a(int i) {
                return new b[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ b[] newArray(int i) {
                return new b[i];
            }
        };

        /* renamed from: a */
        int f6160a;
        boolean b;

        /* renamed from: c */
        boolean f6161c;
        boolean d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;

        public b(Parcel parcel) {
            super(parcel);
            this.f6160a = parcel.readInt();
            boolean[] zArr = new boolean[7];
            parcel.readBooleanArray(zArr);
            this.b = zArr[0];
            this.f6161c = zArr[1];
            this.d = zArr[2];
            this.e = zArr[3];
            this.f = zArr[4];
            this.g = zArr[5];
            this.h = zArr[6];
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        public final String a() {
            return "SavedState(\nsavePosition - " + this.f6160a + "\nsaveVideoPlay25 - " + this.b + "\nsaveVideoPlay50 - " + this.f6161c + "\nsaveVideoPlay75 - " + this.d + "\nsaveIsVideoStart - " + this.e + "\nsaveIsVideoPlayCompletion - " + this.f + "\nsaveIsMute - " + this.g + "\nsaveVideoNeedResumeByCdRate - " + this.h + "\n)";
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6160a);
            parcel.writeBooleanArray(new boolean[]{this.b, this.f6161c, this.d, this.e, this.f, this.g, this.h});
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = "";
        this.j = "";
        this.m = -1;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.b = 0;
        this.f6156c = 0;
        this.d = false;
        this.e = "";
        setSaveEnabled(true);
        this.A = new Handler(Looper.getMainLooper()) { // from class: com.anythink.basead.ui.PlayerView.1
            {
                PlayerView.this = this;
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                PlayerView.this.m = message.what;
                if (PlayerView.this.m <= 0) {
                    return;
                }
                if (!PlayerView.this.v && !PlayerView.this.w) {
                    PlayerView.d(PlayerView.this);
                    if (PlayerView.this.z != null) {
                        PlayerView.this.z.a();
                    }
                }
                if (PlayerView.this.z != null) {
                    PlayerView.this.z.a(PlayerView.this.m);
                }
                if (!PlayerView.this.r && PlayerView.this.m >= PlayerView.this.o) {
                    PlayerView.h(PlayerView.this);
                    if (PlayerView.this.z != null) {
                        PlayerView.this.z.b(25);
                    }
                } else if (!PlayerView.this.s && PlayerView.this.m >= PlayerView.this.p) {
                    PlayerView.k(PlayerView.this);
                    if (PlayerView.this.z != null) {
                        PlayerView.this.z.b(50);
                    }
                } else if (!PlayerView.this.t && PlayerView.this.m >= PlayerView.this.q) {
                    PlayerView.n(PlayerView.this);
                    if (PlayerView.this.z != null) {
                        PlayerView.this.z.b(75);
                    }
                }
                if (!PlayerView.this.G || PlayerView.this.m < PlayerView.this.f6155a || PlayerView.this.z == null) {
                    return;
                }
                PlayerView.this.G = false;
                PlayerView.this.z.g();
            }
        };
        setBackgroundColor(-16777216);
    }

    private void a() {
        if (this.k == 0 || this.l == 0) {
            try {
                String g = g();
                int i = this.D;
                int i2 = this.E;
                g.a a2 = com.anythink.basead.a.b.g.a(g);
                if (a2 == null) {
                    a2 = null;
                } else {
                    float f = (a2.f5851a * 1.0f) / a2.b;
                    if (f < (i * 1.0f) / i2) {
                        a2.b = i2;
                        a2.f5851a = (int) (a2.b * f);
                    } else {
                        a2.f5851a = i;
                        a2.b = (int) (a2.f5851a / f);
                    }
                }
                if (a2 != null) {
                    this.k = a2.f5851a;
                    this.l = a2.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.k);
                sb.append(", ");
                sb.append(this.l);
                if (this.D == this.k) {
                    if (this.E - this.l <= h.a(getContext(), 1.0f)) {
                        this.l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.l);
                    }
                } else if (this.E != this.l || this.D - this.k > h.a(getContext(), 1.0f)) {
                } else {
                    this.k = this.D;
                    new StringBuilder("computeVideoSize: update width -> ").append(this.k);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.PlayerView.a(java.lang.String, boolean):void");
    }

    private void a(boolean z) {
        boolean z2;
        if (new File(this.i).exists() || !TextUtils.isEmpty(this.j)) {
            this.F = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a aVar = this.z;
            if (aVar != null) {
                aVar.a(f.a(f.k, f.J));
                return;
            }
            return;
        }
        float f = 1.0f;
        if (this.k == 0 || this.l == 0) {
            try {
                String g = g();
                int i = this.D;
                int i2 = this.E;
                g.a a2 = com.anythink.basead.a.b.g.a(g);
                if (a2 == null) {
                    a2 = null;
                } else {
                    float f2 = (a2.f5851a * 1.0f) / a2.b;
                    if (f2 < (i * 1.0f) / i2) {
                        a2.b = i2;
                        a2.f5851a = (int) (a2.b * f2);
                    } else {
                        a2.f5851a = i;
                        a2.b = (int) (a2.f5851a / f2);
                    }
                }
                if (a2 != null) {
                    this.k = a2.f5851a;
                    this.l = a2.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.k);
                sb.append(", ");
                sb.append(this.l);
                if (this.D == this.k) {
                    if (this.E - this.l <= h.a(getContext(), 1.0f)) {
                        this.l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.l);
                    }
                } else if (this.E == this.l && this.D - this.k <= h.a(getContext(), 1.0f)) {
                    this.k = this.D;
                    new StringBuilder("computeVideoSize: update width -> ").append(this.k);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.h == null) {
            TextureView textureView = new TextureView(getContext());
            this.h = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i3 = this.k;
            if (i3 != 0 && this.l != 0) {
                layoutParams.width = i3;
                layoutParams.height = this.l;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.h, layoutParams);
        }
        if (this.f == null) {
            this.f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new c(), new d());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            this.I = anonymousClass2;
            this.f.a(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            this.J = anonymousClass3;
            this.f.a(anonymousClass3);
            ad adVar = this.f;
            if (this.B) {
                f = 0.0f;
            }
            adVar.a(f);
            this.f.a(z);
            a(g(), false);
        }
        setOnClickListener(new $$Lambda$PlayerView$uY09yVSBg64vhdOq_fVJ0Ufvngc(this));
    }

    private void b() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void b(boolean z) {
        if (this.f == null) {
            this.f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new c(), new d());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            this.I = anonymousClass2;
            this.f.a(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            this.J = anonymousClass3;
            this.f.a(anonymousClass3);
            this.f.a(this.B ? 0.0f : 1.0f);
            this.f.a(z);
            a(g(), false);
        }
    }

    private void c() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void d() {
        if (this.C != null) {
            return;
        }
        this.u = true;
        Thread thread = new Thread(new $$Lambda$PlayerView$UDhH8DXgbDJrP3YZ4zNkcObshZQ(this));
        this.C = thread;
        thread.start();
    }

    static /* synthetic */ boolean d(PlayerView playerView) {
        playerView.v = true;
        return true;
    }

    public void e() {
        this.u = false;
        this.C = null;
    }

    private boolean f() {
        if (new File(this.i).exists() || !TextUtils.isEmpty(this.j)) {
            this.F = true;
            return false;
        }
        return true;
    }

    private String g() {
        return new File(this.i).exists() ? this.i : this.j;
    }

    private void h() {
        if (this.h == null) {
            TextureView textureView = new TextureView(getContext());
            this.h = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i = this.k;
            if (i != 0 && this.l != 0) {
                layoutParams.width = i;
                layoutParams.height = this.l;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.h, layoutParams);
        }
    }

    static /* synthetic */ boolean h(PlayerView playerView) {
        playerView.r = true;
        return true;
    }

    private void i() {
        a aVar = this.z;
        if (aVar != null) {
            aVar.g();
        }
        this.f.a(this.g);
    }

    public /* synthetic */ void j() {
        Handler handler;
        while (this.u) {
            if (this.w || !isPlaying() || (handler = this.A) == null) {
                try {
                    Thread.sleep(10L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    handler.sendEmptyMessage((int) this.f.t());
                } catch (Throwable th2) {
                }
                try {
                    Thread.sleep(200L);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ boolean k(PlayerView playerView) {
        playerView.s = true;
        return true;
    }

    static /* synthetic */ boolean n(PlayerView playerView) {
        playerView.t = true;
        return true;
    }

    static /* synthetic */ void p(PlayerView playerView) {
        a aVar = playerView.z;
        if (aVar != null) {
            aVar.g();
        }
        playerView.f.a(playerView.g);
    }

    static /* synthetic */ void v(PlayerView playerView) {
        View view = playerView.H;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    static /* synthetic */ boolean w(PlayerView playerView) {
        playerView.x = true;
        return true;
    }

    static /* synthetic */ boolean y(PlayerView playerView) {
        playerView.w = true;
        return true;
    }

    public void autoFitVideoSize(int i, int i2, View view) {
        float f;
        float f2;
        float max = Math.max(i / view.getMeasuredWidth(), i2 / view.getMeasuredHeight());
        int ceil = (int) Math.ceil(f / max);
        int ceil2 = (int) Math.ceil(f2 / max);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = ceil;
        layoutParams.height = ceil2;
        view.setLayoutParams(layoutParams);
    }

    public int getCurrentPosition() {
        return Math.max(this.m, 0);
    }

    public int getVideoLength() {
        return this.n;
    }

    public boolean hasVideo() {
        return this.F;
    }

    public void initMuteStatus(boolean z) {
        this.B = z;
    }

    public boolean isComplete() {
        return this.w;
    }

    public boolean isMute() {
        return this.B;
    }

    public boolean isPlaying() {
        ad adVar = this.f;
        return adVar != null && adVar.J();
    }

    public void load(String str, boolean z) {
        boolean z2;
        this.j = str;
        com.anythink.basead.a.f.a();
        this.i = com.anythink.basead.a.f.a(4, str);
        if (new File(this.i).exists() || !TextUtils.isEmpty(this.j)) {
            this.F = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a aVar = this.z;
            if (aVar != null) {
                aVar.a(f.a(f.k, f.J));
                return;
            }
            return;
        }
        float f = 1.0f;
        if (this.k == 0 || this.l == 0) {
            try {
                String g = g();
                int i = this.D;
                int i2 = this.E;
                g.a a2 = com.anythink.basead.a.b.g.a(g);
                if (a2 == null) {
                    a2 = null;
                } else {
                    float f2 = (a2.f5851a * 1.0f) / a2.b;
                    if (f2 < (i * 1.0f) / i2) {
                        a2.b = i2;
                        a2.f5851a = (int) (a2.b * f2);
                    } else {
                        a2.f5851a = i;
                        a2.b = (int) (a2.f5851a / f2);
                    }
                }
                if (a2 != null) {
                    this.k = a2.f5851a;
                    this.l = a2.b;
                }
                StringBuilder sb = new StringBuilder("computeVideoSize: ");
                sb.append(this.D);
                sb.append(", ");
                sb.append(this.E);
                sb.append(", ");
                sb.append(this.k);
                sb.append(", ");
                sb.append(this.l);
                if (this.D == this.k) {
                    if (this.E - this.l <= h.a(getContext(), 1.0f)) {
                        this.l = this.E;
                        new StringBuilder("computeVideoSize: update height -> ").append(this.l);
                    }
                } else if (this.E == this.l && this.D - this.k <= h.a(getContext(), 1.0f)) {
                    this.k = this.D;
                    new StringBuilder("computeVideoSize: update width -> ").append(this.k);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.h == null) {
            TextureView textureView = new TextureView(getContext());
            this.h = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i3 = this.k;
            if (i3 != 0 && this.l != 0) {
                layoutParams.width = i3;
                layoutParams.height = this.l;
            }
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.h, layoutParams);
        }
        if (this.f == null) {
            this.f = i.a(new com.anythink.expressad.exoplayer.f(getContext()), new c(), new d());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            this.I = anonymousClass2;
            this.f.a(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            this.J = anonymousClass3;
            this.f.a(anonymousClass3);
            ad adVar = this.f;
            if (this.B) {
                f = 0.0f;
            }
            adVar.a(f);
            this.f.a(z);
            a(g(), false);
        }
        setOnClickListener(new $$Lambda$PlayerView$uY09yVSBg64vhdOq_fVJ0Ufvngc(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        new StringBuilder("onRestoreInstanceState...").append(bVar.a());
        super.onRestoreInstanceState(bVar.getSuperState());
        this.m = bVar.f6160a;
        this.r = bVar.b;
        this.s = bVar.f6161c;
        this.t = bVar.d;
        this.v = bVar.e;
        this.w = bVar.f;
        this.B = bVar.g;
        this.G = bVar.h;
        ad adVar = this.f;
        if (adVar != null) {
            adVar.a(this.B ? 0.0f : 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f6160a = this.m;
        bVar.b = this.r;
        bVar.f6161c = this.s;
        bVar.d = this.t;
        bVar.e = this.v;
        bVar.f = this.w;
        bVar.g = this.B;
        bVar.h = this.G;
        new StringBuilder("onSaveInstanceState...").append(bVar.a());
        return bVar;
    }

    public void pause() {
        e();
        ad adVar = this.f;
        if (adVar != null) {
            adVar.a(false);
        }
    }

    public void release() {
        e();
        if (this.x) {
            ad adVar = this.f;
            if (adVar != null) {
                if (adVar.J()) {
                    this.f.m();
                }
                w.c cVar = this.I;
                if (cVar != null) {
                    this.f.b(cVar);
                }
                com.anythink.expressad.exoplayer.l.g gVar = this.J;
                if (gVar != null) {
                    this.f.b(gVar);
                }
                this.f.n();
                this.f = null;
            }
            Handler handler = this.A;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.x = false;
        }
    }

    public void setListener(a aVar) {
        this.z = aVar;
    }

    public void setLoadingView(View view) {
        this.H = view;
    }

    public void setMute(boolean z) {
        this.B = z;
        if (z) {
            ad adVar = this.f;
            if (adVar != null) {
                adVar.a(0.0f);
            }
            a aVar = this.z;
            if (aVar != null) {
                aVar.e();
                return;
            }
            return;
        }
        ad adVar2 = this.f;
        if (adVar2 != null) {
            adVar2.a(1.0f);
        }
        a aVar2 = this.z;
        if (aVar2 != null) {
            aVar2.f();
        }
    }

    public void setVideoRateConfig(int i, int i2) {
        this.f6156c = i;
        this.b = i2;
    }

    public void setVideoSize(int i, int i2) {
        this.D = i;
        this.E = i2;
    }

    public void start() {
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        ad adVar = this.f;
        if (adVar != null) {
            adVar.a(true);
        }
        if (this.C == null) {
            this.u = true;
            Thread thread = new Thread(new $$Lambda$PlayerView$UDhH8DXgbDJrP3YZ4zNkcObshZQ(this));
            this.C = thread;
            thread.start();
        }
    }

    public void stop() {
        ad adVar = this.f;
        if (adVar != null) {
            adVar.m();
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.b();
        }
    }
}
