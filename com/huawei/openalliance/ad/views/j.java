package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bd;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/j.class */
public class j implements gn, go, gr, BaseVideoView.g, e {
    private static final String Z = j.class.getSimpleName();
    private VideoView B;
    private NativeVideoControlPanel C;
    private View D;
    private ImageView F;
    private ImageView L;
    private ImageView S;

    /* renamed from: a  reason: collision with root package name */
    private View f9440a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f9441c;
    private boolean f;
    private int h;
    private boolean i;
    private View.OnClickListener j;
    private a k;
    private int l;
    private v n;
    private final String d = "hPlT" + hashCode();
    private final String e = "aPT" + hashCode();
    private boolean g = true;
    private boolean m = false;
    private int o = 0;
    private Runnable p = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.B == null || !j.this.f) {
                return;
            }
            j.this.V(true);
        }
    };
    private View.OnClickListener q = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            j.this.L(!view.isSelected());
        }
    };
    private Runnable r = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.8
        @Override // java.lang.Runnable
        public void run() {
            j.this.Code(false, true);
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/j$a.class */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void V(boolean z, int i);
    }

    public j(VideoView videoView, NativeVideoControlPanel nativeVideoControlPanel) {
        Code(videoView);
        Code(nativeVideoControlPanel);
    }

    private void Code(int i, boolean z, boolean z2) {
        NativeVideoControlPanel nativeVideoControlPanel;
        C();
        if (z2) {
            i = 0;
        }
        this.h = i;
        ba.Code(this.d);
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.V() != 0) {
            this.S.setImageResource(this.C.V());
            ay.Code(this.S);
        }
        if (!z) {
            f();
            a(false);
        }
        View view = this.b;
        if (view == null || view.getVisibility() != 0) {
            Code(true, true);
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, boolean z2) {
        boolean Code;
        View view = this.f9440a;
        if (z2) {
            Code = bd.Code(view, z ? 0 : 8);
        } else {
            Code = bd.Code(view, z);
        }
        if (Code) {
            if (z) {
                c(z2);
            } else {
                d(z2);
            }
        }
    }

    private void D(boolean z) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.Code(z);
        }
    }

    private void I(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView B = nativeVideoControlPanel.B();
        this.F = B;
        if (B != null) {
            B.setOnClickListener(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        String str = Z;
        ge.V(str, "switchSound: " + z);
        VideoView videoView = this.B;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
        ba.Code(this.d);
        if (this.B.a()) {
            r();
        }
    }

    private void V(NativeVideoControlPanel nativeVideoControlPanel) {
        View D = nativeVideoControlPanel.D();
        this.f9441c = D;
        if (D != null) {
            D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    j.this.e();
                }
            });
        }
    }

    private void Z(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView Code = nativeVideoControlPanel.Code();
        this.S = Code;
        if (Code != null) {
            Code.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (j.this.k != null) {
                        j.this.k.Code();
                    }
                    if (j.this.o != 10) {
                        j.this.m();
                        return;
                    }
                    String str = j.Z;
                    ge.Code(str, "linkedVideoMode is " + j.this.o);
                    j.this.p();
                }
            });
            if (nativeVideoControlPanel.V() > 0) {
                this.S.setImageResource(nativeVideoControlPanel.V());
                ay.Code(this.S);
            }
        }
    }

    private void a(boolean z) {
        this.g = !z;
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.Code(z);
        }
    }

    private void b(boolean z) {
        if (this.B == null) {
            return;
        }
        if (z || this.l == 1 || this.m) {
            s();
        } else {
            t();
        }
    }

    private void c(boolean z) {
        VideoView videoView;
        a aVar = this.k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.Code(z, videoView.getCurrentState().V());
    }

    private void d() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel == null) {
            return;
        }
        this.D = nativeVideoControlPanel.C();
        this.f9440a = this.C.L();
        View F = this.C.F();
        this.b = F;
        if (F != null) {
            F.setClickable(true);
        }
        ImageView S = this.C.S();
        this.L = S;
        if (S != null) {
            S.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    j.this.n();
                }
            });
        }
        I(this.C);
        j();
        h();
        a(false);
        F();
    }

    private void d(boolean z) {
        VideoView videoView;
        a aVar = this.k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.V(z, videoView.getCurrentState().V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ba.Code(this.e);
        h();
        if (this.o == 10) {
            p();
        }
        VideoView videoView = this.B;
        if (videoView != null && !videoView.getCurrentState().Code()) {
            f();
        }
        V(false);
    }

    private void f() {
        if (this.L == null) {
            return;
        }
        ge.Code(Z, "showPreviewView");
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bd.Code((View) this.L, true);
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    private void g() {
        VideoView videoView;
        ge.Code(Z, "hidePreviewView");
        bd.Code(this.L, 8, 300, 300);
        if (this.L == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    private void h() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void i() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void j() {
        k();
        Z(this.C);
        V(this.C);
        if (this.o == 10) {
            l();
        }
    }

    private void k() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.Code((gr) this);
            this.B.Code((gn) this);
            this.B.Code((go) this);
            this.B.Code((e) this);
            this.B.setSurfaceListener(this);
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    j.this.o();
                }
            });
        }
    }

    private void l() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    j.this.p();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.B == null) {
            return;
        }
        ba.Code(this.e);
        if (this.B.a()) {
            ba.Code(this.d);
            this.B.L();
        } else if (!ai.Z(this.B.getContext())) {
            Toast.makeText(this.B.getContext(), R.string.hiad_network_no_available, 0).show();
        } else if (this.m || this.l == 1 || ai.I(this.B.getContext())) {
            V(false);
            r();
        } else {
            ge.V(Z, "non wifi, show alert");
            this.B.L();
            i();
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View.OnClickListener onClickListener;
        VideoView videoView = this.B;
        if (videoView == null || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(videoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        View.OnClickListener onClickListener;
        if (this.B == null || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(this.C);
    }

    private void q() {
        Code(false, false);
    }

    private void r() {
        ba.Code(this.d);
        ba.Code(this.r, this.d, m.ag);
    }

    private void s() {
        if (this.B == null) {
            return;
        }
        h();
        if (!this.B.getCurrentState().Code()) {
            f();
        }
        if (this.f && !this.i) {
            V(true);
        } else if (this.B.a()) {
        } else {
            F();
        }
    }

    private void t() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if ((!videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PREPARING) && !this.B.a()) || this.m || this.l == 1) {
                return;
            }
            this.B.D();
            if (this.b != null) {
                i();
                q();
            }
        }
    }

    private void u() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if (videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PREPARING) || this.B.a()) {
                this.B.L();
            }
        }
    }

    public void B() {
        ge.Code(Z, "setForImageOnly");
        Code((VideoView) null);
        Code(false, false);
        a(false);
    }

    public void B(int i) {
        String str = Z;
        ge.Code(str, "linkedVideoMode is " + i);
        this.o = i;
    }

    public void B(boolean z) {
        String str = Z;
        ge.V(str, "setMuteBtn: " + z);
        ImageView B = this.C.B();
        if (B != null) {
            B.setSelected(!z);
        }
    }

    public void C() {
        ba.Code(this.e);
    }

    public void C(boolean z) {
        if (ge.Code()) {
            ge.Code(Z, "setPlayBtn: %s", Boolean.valueOf(z));
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    @Override // com.huawei.hms.ads.gn
    public void Code() {
        View view = this.D;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.D.setVisibility(0);
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @Override // com.huawei.hms.ads.gn
    public void Code(int i) {
    }

    @Override // com.huawei.hms.ads.gr
    public void Code(int i, int i2) {
        v vVar;
        if (i2 <= 0 || (vVar = this.n) == null) {
            return;
        }
        vVar.Code(i2);
    }

    public void Code(long j) {
        VideoView videoView;
        ge.V(Z, "autoPlay - delayMs: %d", Long.valueOf(j));
        ba.Code(this.e);
        if (!this.f || (videoView = this.B) == null) {
            return;
        }
        if (videoView.a()) {
            ge.Code(Z, "autoPlay - video is playing");
            V(true);
            return;
        }
        ge.Code(Z, "autoPlay - start delay runnable");
        this.B.e();
        ba.Code(this.p, this.e, j);
    }

    public void Code(Bitmap bitmap) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void Code(Drawable drawable) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void Code(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void Code(v vVar) {
        this.n = vVar;
    }

    @Override // com.huawei.hms.ads.gr
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
        NativeVideoControlPanel nativeVideoControlPanel;
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.I() != 0) {
            this.S.setImageResource(this.C.I());
        }
        g();
        if (this.g) {
            Code(false, false);
        } else {
            r();
        }
        a(true);
    }

    @Override // com.huawei.hms.ads.go
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
        Code(i, false, false);
    }

    public void Code(NativeVideoControlPanel nativeVideoControlPanel) {
        this.C = nativeVideoControlPanel;
        d();
    }

    public void Code(VideoView videoView) {
        this.B = videoView;
    }

    public void Code(a aVar) {
        this.k = aVar;
    }

    public void Code(String str) {
        VideoView videoView;
        if (this.C == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setVideoFileUrl(str);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Code(boolean z) {
        b(z);
    }

    public void D() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.L();
        }
    }

    public void F() {
        Code(true, false);
    }

    public void F(boolean z) {
        this.m = z;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.g
    public void I() {
        f();
        a(false);
    }

    public void I(int i) {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setDefaultDuration(i);
        }
    }

    @Override // com.huawei.hms.ads.gr
    public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
        Code(i, false, false);
    }

    public void I(boolean z) {
        this.f = z;
    }

    public void L() {
        this.i = true;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    public void S() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.D();
        }
        h();
        a(false);
        F();
        f();
    }

    public void S(boolean z) {
        if (z) {
            Code((String) null);
            V(0);
            I(0);
            Code((Bitmap) null);
        }
        f();
        F();
    }

    @Override // com.huawei.hms.ads.gn
    public void V() {
        View view = this.D;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.D.setVisibility(8);
    }

    public void V(int i) {
        String str = Z;
        ge.Code(str, "setPreferStartPlayTime " + i);
        this.h = i;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setPreferStartPlayTime(i);
        }
    }

    @Override // com.huawei.hms.ads.gr
    public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
        Code(i, true, false);
    }

    public void V(boolean z) {
        if (this.B != null) {
            D(z);
            this.B.setPreferStartPlayTime(this.h);
            this.B.Code(z);
        }
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Z() {
        u();
    }

    public void Z(int i) {
        this.l = i;
    }

    @Override // com.huawei.hms.ads.gr
    public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
        Code(i, false, true);
    }

    public void Z(boolean z) {
        String str = Z;
        ge.V(str, "toggleMute: " + z);
        if (this.B == null || this.C == null) {
            return;
        }
        B(z);
        if (z) {
            this.B.b();
        } else {
            this.B.c();
        }
    }

    public void a() {
        this.i = false;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.resumeView();
        }
    }
}
