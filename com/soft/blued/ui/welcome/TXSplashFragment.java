package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.ui.TimeoutFragment;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TXSplashFragment.class */
public class TXSplashFragment extends TimeoutFragment implements SplashADListener {
    public static boolean p = false;
    public Context m;
    public View n;
    public long q;
    private FrameLayout s;
    private View t;
    private SplashAD u;
    private String[] w;
    private String[] x;
    private View y;
    private String z;
    public boolean o = false;
    private int v = 500;
    public boolean r = false;
    private long A = 0;
    private Handler B = new Handler(Looper.getMainLooper());

    private void k() {
        this.A = System.currentTimeMillis();
        Log.v("drb", "getPosId():" + this.z);
        SplashAD splashAD = new SplashAD(getActivity(), this.z, this);
        this.u = splashAD;
        splashAD.fetchAndShowIn(this.s);
        e();
    }

    private void l() {
        Log.v("drb", "next:" + this.o);
        if (this.o) {
            m();
        } else {
            this.o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            p = false;
            Intent intent = new Intent();
            long j = this.q;
            long j2 = j;
            if (j == 0) {
                j2 = System.currentTimeMillis();
            }
            intent.putExtra("THIRD_UNVALID_DURATION", j2);
            intent.putExtra("THIRD_HAS_CALL_BACK", this.r);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void g() {
        m();
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public View h() {
        return this.n;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j() {
        getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.m, R.drawable.app_loading_bg));
        this.s = (FrameLayout) this.n.findViewById(R.id.fl_ad_content);
        this.t = this.n.findViewById(R.id.ll_click_skip);
        View findViewById = this.n.findViewById(R.id.view_btm_bar);
        this.y = findViewById;
        findViewById.setVisibility(0);
        this.y.setBackgroundColor(this.m.getResources().getColor(2131102388));
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        FindHttpUtils.b(this.x);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        Logger.b("AD_DEMO", "SplashADDismissed");
        Log.v("drb", "onADDismissed next");
        l();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        Logger.b("AD_DEMO", "SplashADExposure");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
        this.q = System.currentTimeMillis();
        this.r = true;
        Logger.b("AD_DEMO", "SplashADPresent");
        this.t.setVisibility(0);
        FindHttpUtils.b(this.w);
        a();
        f();
        this.y.setBackgroundColor(this.m.getResources().getColor(2131102478));
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        Logger.b("AD_DEMO", "SplashADTick " + j + "ms");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.m = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.n;
        if (view == null) {
            if (getArguments() != null) {
                this.w = getArguments().getStringArray("KEY_SHOW_URL");
                this.x = getArguments().getStringArray("KEY_CLICK_URL");
                this.z = getArguments().getString("SPLASH_ID");
                getArguments().getStringArray("KEY_HIDDEN_URL");
            }
            this.n = layoutInflater.inflate(R.layout.fragment_tx_splash, viewGroup, false);
            j();
            k();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        return this.n;
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.B.removeCallbacksAndMessages(null);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        this.r = true;
        Logger.b("AD_DEMO", String.format("LoadSplashADFail, eCode=%d, errorMsg=%s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg()));
        long currentTimeMillis = System.currentTimeMillis() - this.A;
        int i = this.v;
        this.B.postDelayed(new Runnable() { // from class: com.soft.blued.ui.welcome.TXSplashFragment.1
            @Override // java.lang.Runnable
            public void run() {
                Log.v("drb", "onNoAD finish");
                TXSplashFragment.this.m();
            }
        }, currentTimeMillis > ((long) i) ? 0L : i - currentTimeMillis);
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.o = false;
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.v("drb", "onResume canJump:" + this.o);
        if (this.o) {
            l();
        }
        this.o = true;
    }
}
