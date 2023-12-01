package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dg.class */
public class dg {
    private static final int f = 5;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f9418c;
    private TextView d;
    private CountDownTimer e;
    private dj g;
    private Activity j;
    private Boolean k;

    /* renamed from: a  reason: collision with root package name */
    public final String f9417a = "html5_intersitial";
    private boolean h = false;
    private boolean i = false;
    protected final bq b = bq.a();

    public dg(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.e = new di(this, 6000L, 1000L).start();
        return this.f9418c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f9418c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f9418c.getParent()).removeView(this.f9418c);
        }
        if (this.e != null) {
            this.b.a("cancel countDownTimer before it finished");
            try {
                this.e.cancel();
            } catch (Exception e) {
                this.b.a(e);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i, int i2) {
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.b.a("showInterstitialAdInit");
            if (this.h && !this.i) {
                this.i = true;
                this.h = false;
                this.j = activity;
                a();
                c();
            } else if (this.i) {
                this.b.b("interstitial ad is showing now");
            } else if (this.h) {
            } else {
                this.b.b("interstitial ad is not ready");
            }
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    protected boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Activity activity = this.j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dh(this));
    }

    public boolean d() {
        return this.h;
    }
}
