package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.ln;
import com.huawei.hms.ads.ls;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PlacementMediaView.class */
public abstract class PlacementMediaView extends AutoScaleSizeRelativeLayout implements hr, ln, ls {
    protected boolean B;
    protected boolean C;
    protected p Code;
    protected String I;
    protected boolean S;
    protected String V;
    private r b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<gu> f23033c;
    private int d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;
    private Handler k;

    public PlacementMediaView(Context context) {
        super(context);
        this.f23033c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((v.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                            return;
                        }
                        PlacementMediaView.this.b();
                        PlacementMediaView.this.k.removeMessages(1);
                        PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                    }
                } catch (IllegalStateException e) {
                    str = "handleMessage IllegalStateException";
                    ge.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    ge.I("PlacementMediaView", str);
                }
            }
        };
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23033c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((v.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                            return;
                        }
                        PlacementMediaView.this.b();
                        PlacementMediaView.this.k.removeMessages(1);
                        PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                    }
                } catch (IllegalStateException e) {
                    str = "handleMessage IllegalStateException";
                    ge.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    ge.I("PlacementMediaView", str);
                }
            }
        };
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23033c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((v.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                            return;
                        }
                        PlacementMediaView.this.b();
                        PlacementMediaView.this.k.removeMessages(1);
                        PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                    }
                } catch (IllegalStateException e) {
                    str = "handleMessage IllegalStateException";
                    ge.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    ge.I("PlacementMediaView", str);
                }
            }
        };
    }

    private void L() {
        this.d = 0;
        this.e = 0L;
        this.g = 0L;
        this.f = 0L;
        this.h = 0L;
        this.i = false;
        this.j = false;
        this.C = false;
        this.B = false;
        this.S = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        for (gu guVar : this.f23033c) {
            guVar.Code(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f <= 0 || this.j) {
            return;
        }
        for (gu guVar : this.f23033c) {
            String str = this.I;
            String str2 = this.V;
            int i = this.d;
            guVar.Code(str, str2, (int) (i / this.f), i);
        }
    }

    private void c() {
        for (gu guVar : this.f23033c) {
            guVar.V(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.i = false;
        for (gu guVar : this.f23033c) {
            guVar.Z(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return ((long) this.d) >= this.f;
    }

    public void B() {
    }

    public void C() {
        this.k.removeMessages(1);
        this.g = v.Code();
        c();
    }

    abstract void Code();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void Code(int i);

    public void Code(long j) {
    }

    public void Code(gn gnVar) {
    }

    public void Code(go goVar) {
    }

    public void Code(gs gsVar) {
    }

    public void Code(gt gtVar) {
    }

    public void Code(gu guVar) {
        if (guVar != null) {
            this.f23033c.add(guVar);
        }
    }

    public void Code(String str) {
    }

    public void Code(boolean z, boolean z2) {
        ge.V("PlacementMediaView", "play, mediaCached: %s, mediaAvalible: %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!PlacementMediaView.this.B) {
                    PlacementMediaView.this.S = true;
                } else if (!PlacementMediaView.this.C) {
                    PlacementMediaView.this.D();
                } else {
                    PlacementMediaView.this.k.removeMessages(1);
                    PlacementMediaView.this.k.sendEmptyMessage(1);
                    PlacementMediaView.this.a();
                    if (0 == PlacementMediaView.this.e) {
                        PlacementMediaView.this.e = v.Code();
                    }
                    if (PlacementMediaView.this.g != 0) {
                        PlacementMediaView.this.h += v.Code() - PlacementMediaView.this.g;
                    }
                }
            }
        }, 1L);
    }

    protected void D() {
        this.i = false;
        this.j = true;
        for (gu guVar : this.f23033c) {
            guVar.Code(this.I, this.V, 0, -1, -1);
        }
    }

    public boolean F() {
        return false;
    }

    public void I() {
    }

    public void I(gu guVar) {
    }

    public void S() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void V();

    public void V(gs gsVar) {
    }

    public void destroyView() {
        this.k.removeMessages(1);
        this.f23033c.clear();
        Code();
    }

    public long getDuration() {
        r S;
        p pVar = this.Code;
        if (pVar == null || (S = pVar.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageView getLastFrame();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.huawei.openalliance.ad.media.c getMediaState();

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public com.huawei.openalliance.ad.inter.data.h getPlacementAd() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
    }

    public void setAudioFocusType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setMediaPlayerReleaseListener(gq gqVar);

    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        String str;
        L();
        if (hVar instanceof p) {
            p pVar = (p) hVar;
            this.Code = pVar;
            r S = pVar.S();
            this.b = S;
            this.f = S.d();
            this.V = this.b.Z();
            str = hVar.D();
        } else {
            this.Code = null;
            this.b = null;
            this.k.removeMessages(1);
            str = "";
            this.V = "";
        }
        this.I = str;
    }

    public void setSoundVolume(float f) {
    }
}
