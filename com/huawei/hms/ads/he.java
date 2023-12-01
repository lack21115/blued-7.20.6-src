package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.ad.inter.HiAd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/he.class */
public abstract class he implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final String Code = "ViewMonitor";
    private static final Map<View, he> V = new ConcurrentHashMap();
    private boolean B;
    private long C;
    private int S;
    private View Z;

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f8884a;
    private String I = Code;
    private Rect F = new Rect();
    private boolean D = true;
    private BroadcastReceiver L = new BroadcastReceiver() { // from class: com.huawei.hms.ads.he.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            ge.V(he.this.I, "receive screen state: %s", action);
            if (TextUtils.equals(Intent.ACTION_SCREEN_ON, action) || TextUtils.equals(Intent.ACTION_SCREEN_OFF, action) || TextUtils.equals("android.intent.action.USER_PRESENT", action)) {
                he.this.Z();
                he.this.C();
            }
        }
    };

    public he(View view) {
        this.Z = view;
        V();
    }

    private void B() {
        ge.V(this.I, "unregisterObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        this.Z.setOnSystemUiVisibilityChangeListener(null);
        if (this.f8884a != null) {
            HiAd.Code(this.Z.getContext()).Code(this.f8884a);
            this.f8884a = null;
        }
        V.remove(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        boolean z = this.D && this.Z.isShown() && this.Z.getLocalVisibleRect(this.F);
        int width = this.Z.getWidth() * this.Z.getHeight();
        if (z && width > 0) {
            int width2 = ((this.F.width() * this.F.height()) * 100) / width;
            if (width2 > this.S) {
                this.S = width2;
            }
            Code(width2);
            if (width2 <= 0) {
                z = false;
            }
        }
        if (z) {
            b();
        } else {
            c();
        }
    }

    private void I() {
        ge.V(this.I, "registerObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        he heVar = V.get(this.Z);
        if (heVar != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(heVar);
            viewTreeObserver.removeOnGlobalLayoutListener(heVar);
        }
        V.put(this.Z, this);
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f8884a = this.L;
        HiAd.Code(this.Z.getContext()).Code(this.f8884a, intentFilter);
        this.D = true;
    }

    private void V() {
        if (this.Z != null) {
            this.I = this.Z.getClass().getSimpleName() + Code;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Context context = this.Z.getContext();
        this.D = com.huawei.openalliance.ad.utils.ay.Code(context) && !com.huawei.openalliance.ad.utils.ay.V(context);
        if (ge.Code()) {
            ge.Code(this.I, "checkScreenState screen available: %s ", Boolean.valueOf(this.D));
        }
    }

    protected void Code() {
    }

    protected void Code(int i) {
    }

    protected void Code(long j, int i) {
    }

    public void D() {
        ge.V(this.I, "onViewAttachedToWindow");
        I();
        C();
    }

    public void L() {
        if (ge.Code()) {
            ge.Code(this.I, "onViewDetachedFromWindow");
        }
        B();
        c();
    }

    public void a() {
        ge.V(this.I, "onViewVisibilityChanged");
        C();
    }

    public void b() {
        if (this.B) {
            return;
        }
        ge.V(this.I, "onViewShown");
        this.B = true;
        this.C = System.currentTimeMillis();
        Code();
    }

    public void c() {
        if (this.B) {
            ge.V(this.I, "onViewHidden");
            this.B = false;
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (ge.Code()) {
                ge.Code(this.I, "max physical visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(currentTimeMillis));
            }
            Code(currentTimeMillis, this.S);
            this.S = 0;
        }
    }

    public boolean d() {
        return this.B && this.Z.isShown();
    }

    public int e() {
        boolean z = this.D && this.Z.isShown() && this.Z.getLocalVisibleRect(this.F);
        int width = this.Z.getWidth() * this.Z.getHeight();
        if (!z || width <= 0) {
            return 0;
        }
        return ((this.F.width() * this.F.height()) * 100) / width;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (ge.Code()) {
            ge.Code(this.I, "onGlobalLayout");
        }
        C();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        if (ge.Code()) {
            ge.Code(this.I, "onScrollChanged");
        }
        C();
    }
}
