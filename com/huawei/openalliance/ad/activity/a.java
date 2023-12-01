package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/a.class */
public class a extends Activity implements NotifyCallback {
    protected static final int B = 16;
    protected static final int C = 2;
    public static final String Code = "huawei.permission.CLICK_STATUSBAR_BROADCAST";
    public static final String I = "com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY";
    public static final String V = "com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE";
    protected static final int Z = 36;
    private static final String n = "BaseDialogActivity";
    private static final int o = 40;
    private static final String p = "android.permission.WRITE_SECURE_SETTINGS";
    private static final String q = "com.huawei.intent.action.CLICK_STATUSBAR";
    protected int D;
    protected int F;
    protected int L;
    protected int S;

    /* renamed from: a  reason: collision with root package name */
    protected int[] f22932a;
    protected int[] b;

    /* renamed from: c  reason: collision with root package name */
    protected AdContentData f22933c;
    protected PPSBaseDialogContentView d;
    protected PPSBaseDialogContentView e;
    protected PPSBaseDialogContentView f;
    protected ImageView g;
    protected ImageView h;
    protected ImageView i;
    protected RelativeLayout j;
    protected View k;
    protected View l;
    protected c m;
    private boolean r = false;

    /* renamed from: com.huawei.openalliance.ad.activity.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/a$a.class */
    public static class ViewTreeObserver$OnGlobalLayoutListenerC0429a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<Context> Code;
        private final int[] I;
        private final WeakReference<View> V;

        public ViewTreeObserver$OnGlobalLayoutListenerC0429a(View view, Context context, int[] iArr) {
            this.Code = new WeakReference<>(context);
            this.V = new WeakReference<>(view);
            this.I = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = this.V.get();
                Context context = this.Code.get();
                if (view == null || context == null || this.I == null) {
                    return;
                }
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (iArr[0] == 0 && iArr[1] == 0) {
                    ge.V(a.n, "anchorView onGlobalLayout newLoc[x,y] =0,0");
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else if (this.I[0] == iArr[0] && this.I[1] == iArr[1]) {
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ge.V(a.n, "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.I[0] + "," + this.I[1]);
                    com.huawei.openalliance.ad.msgnotify.b.Code(context, bb.B, new Intent(a.V));
                }
            } catch (Throwable th) {
                ge.I(a.n, "onGlobalLayout error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/a$b.class */
    public static class b implements i {
        WeakReference<a> Code;

        public b(a aVar) {
            this.Code = new WeakReference<>(aVar);
        }

        @Override // com.huawei.openalliance.ad.views.i
        public void Code(int i) {
            a aVar = this.Code.get();
            if (aVar == null || aVar.r) {
                return;
            }
            ge.V(a.n, "got safePadding: %s", Integer.valueOf(i));
            aVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/a$c.class */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                ge.V(a.n, "intent is empty");
                return;
            }
            String action = intent.getAction();
            ge.V(a.n, "FeedbackEventReceiver action = %s", action);
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action) || a.q.equals(action)) {
                a.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i) {
        PPSBaseDialogContentView pPSBaseDialogContentView = this.f;
        if (pPSBaseDialogContentView != null) {
            pPSBaseDialogContentView.Code(i);
        }
        if (this.i != null) {
            this.S += i;
            c();
        }
        this.r = true;
    }

    private boolean Code(int[] iArr) {
        return iArr == null || iArr.length != 2;
    }

    private void D() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.j.setForceDarkAllowed(false);
        }
    }

    private void F() {
        int i;
        if (Code(this.f22932a) || Code(this.b)) {
            ge.I(n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        boolean z = true;
        if (this.f22932a[1] + (this.b[1] >> 1) > (this.D >> 1)) {
            this.e.setVisibility(8);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            this.f = this.d;
            this.i = this.g;
            int e = v.e(this);
            int i2 = e;
            if (dt.Code(this).Code(this)) {
                i2 = Math.max(e, dt.Code(this).Code(this.j));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.setMargins(0, i2, 0, 0);
            this.f.setLayoutParams(layoutParams);
            return;
        }
        this.d.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        this.f = this.e;
        this.i = this.h;
        boolean B2 = l.B(this);
        boolean z2 = l.C(this) && (1 == (i = this.L) || 9 == i);
        if (!l.S(this) || !l.F(this)) {
            z = false;
        }
        if (B2 || z2 || z) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, Math.max(v.V(this, 40.0f), ay.S(this)));
            this.f.setLayoutParams(layoutParams2);
        }
    }

    private void L() {
        try {
            this.m = new c();
            registerReceiver(this.m, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS), "android.permission.WRITE_SECURE_SETTINGS", null);
            IntentFilter intentFilter = new IntentFilter(q);
            if (getBaseContext() != null) {
                registerReceiver(this.m, intentFilter, Code, null);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bb.B, this);
        } catch (Throwable th) {
            ge.I(n, "registerReceiver error: %s", th.getClass().getSimpleName());
        }
    }

    private void S() {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            this.F = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            i = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            this.F = point.x;
            i = point.y;
        }
        this.D = i;
        ge.Code(n, "initDevicesInfo screenWidth: %s, screenHeight: %s", Integer.valueOf(this.F), Integer.valueOf(this.D));
        this.L = ay.c(this);
        this.S = v.V(this, 22.0f);
    }

    private void a() {
        try {
            if (this.m != null) {
                unregisterReceiver(this.m);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bb.B);
        } catch (Throwable th) {
            ge.I(n, "unRegisterFeedbackReceiver: %s", th.getClass().getSimpleName());
        }
    }

    private void b() {
        if (Code(this.f22932a) || Code(this.b)) {
            ge.I(n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.f22932a[0];
            layoutParams2.height = this.f22932a[1];
            this.k.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.l.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.width = this.b[0];
            layoutParams4.height = this.b[1];
            this.l.setLayoutParams(layoutParams4);
        }
    }

    private void c() {
        ImageView imageView;
        float f;
        if (Code(this.f22932a) || Code(this.b)) {
            ge.I(n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        int V2 = v.V(this, 36.0f);
        int i = this.S;
        int i2 = (this.F - i) - V2;
        int i3 = (this.f22932a[0] + (this.b[0] >> 1)) - (V2 >> 1);
        if (i3 >= i) {
            i = i3;
        }
        if (i > i2) {
            i = i2;
        }
        if (ay.I()) {
            imageView = this.i;
            f = -i;
        } else {
            imageView = this.i;
            f = i;
        }
        imageView.setX(f);
    }

    private void d() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B() {
        try {
            this.f22932a = getIntent().getIntArrayExtra(at.ao);
            this.b = getIntent().getIntArrayExtra(at.ap);
            if (!Code(this.f22932a) && !Code(this.b)) {
                if (ay.I()) {
                    this.f22932a[0] = (this.F - this.f22932a[0]) - this.b[0];
                    ge.V(n, "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(this.f22932a[0]), Integer.valueOf(this.f22932a[1]));
                }
                if (Build.VERSION.SDK_INT < 24 || !ay.Code((Activity) this)) {
                    return true;
                }
                int e = ay.e(this);
                this.f22932a[1] = this.f22932a[1] - e;
                ge.Code(n, "windowing mode is freeform");
                ge.Code(n, "initDevicesInfo dragBarHeight: %s", Integer.valueOf(e));
                return true;
            }
            ge.I(n, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return false;
        } catch (Throwable th) {
            ge.I(n, "getIntentExtra error: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        int V2;
        ge.V(n, "getRealOrientation orientation %s", Integer.valueOf(this.L));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        int abs = Math.abs((int) this.i.getX());
        int V3 = v.V(this, 36.0f);
        int i = (V3 >> 1) + abs;
        double d = V3 * 0.5d;
        int viewWidthPercent = (int) ((this.F * (1.0f - this.f.getViewWidthPercent()) * 0.5d) + v.V(this, 16.0f) + d);
        int viewWidthPercent2 = (int) (((this.F * ((this.f.getViewWidthPercent() * 0.5d) + 0.5d)) - v.V(this, 16.0f)) - d);
        ge.Code(n, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        ge.Code(n, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V3), Integer.valueOf(i));
        int i2 = this.L;
        if (1 != i2 && 9 != i2) {
            layoutParams.removeRule(14);
            this.f.setLayoutParams(layoutParams);
            int i3 = this.F;
            if (i >= i3 / 3) {
                if (i < (i3 * 2) / 3) {
                    V2 = i - (this.f.getViewWith() >> 1);
                }
                V2 = ((abs + V3) + v.V(this, 16.0f)) - this.f.getViewWith();
            }
            V2 = abs - v.V(this, 16.0f);
        } else if (i < viewWidthPercent) {
            ge.Code(n, "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.f.setLayoutParams(layoutParams);
            V2 = abs - v.V(this, 16.0f);
        } else if (i <= viewWidthPercent2) {
            ge.Code(n, "locationX =< curImgCenter =< locationX2");
            layoutParams.addRule(14);
            this.f.setLayoutParams(layoutParams);
            ay.Code(this, new b(this));
        } else {
            ge.Code(n, "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.f.setLayoutParams(layoutParams);
            V2 = ((abs + V3) + v.V(this, 16.0f)) - this.f.getViewWith();
        }
        this.f.setPaddingStart(V2);
        ay.Code(this, new b(this));
    }

    protected void Code() {
    }

    protected void I() {
    }

    protected int V() {
        return 0;
    }

    protected void Z() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        ge.V(n, "finish");
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(V());
            S();
            if (!B()) {
                ge.I(n, "getIntentExtra return false");
                Z();
                finish();
                return;
            }
            d();
            getWindow().addFlags(134217728);
            Code();
            D();
            L();
            F();
            b();
            c();
            I();
        } catch (Throwable th) {
            ge.I(n, "onCreate ex: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a();
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            ge.V(n, "msgName or msgData is empty!");
            return;
        }
        ge.Code(n, "onMessageNotify msgName:%s", str);
        try {
            String action = intent.getAction();
            ge.V(n, "FeedbackEventReceiver action = %s", action);
            if (V.equals(action) || I.equals(action)) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.finish();
                    }
                });
            }
        } catch (Throwable th) {
            ge.I(n, "error: " + th.getClass().getSimpleName());
        }
    }
}
