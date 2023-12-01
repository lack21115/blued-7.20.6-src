package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashAdListener;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.ui.TimeoutFragment;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TopSplashFragment.class */
public class TopSplashFragment extends TimeoutFragment implements ATSplashAdListener {
    public static boolean m = false;
    public Context n;
    public View o;
    public long p;
    public boolean q = false;
    boolean r = false;
    private String[] s;
    private String[] t;
    private String[] u;
    private FrameLayout v;
    private View w;
    private View x;
    private String y;
    private ATSplashAd z;

    private void l() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            m = false;
            Intent intent = new Intent();
            long j = this.p;
            long j2 = j;
            if (j == 0) {
                j2 = System.currentTimeMillis();
            }
            intent.putExtra("THIRD_UNVALID_DURATION", j2);
            intent.putExtra("THIRD_HAS_CALL_BACK", this.q);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void g() {
        Log.v("anythink", "onTimeoutFinish");
        l();
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public View h() {
        return this.o;
    }

    public void j() {
        getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.n, R.drawable.app_loading_bg));
        this.v = (FrameLayout) this.o.findViewById(R.id.fl_ad_content);
        View findViewById = this.o.findViewById(R.id.ll_click_skip);
        this.w = findViewById;
        findViewById.setVisibility(8);
        View findViewById2 = this.o.findViewById(R.id.view_btm_bar);
        this.x = findViewById2;
        findViewById2.setVisibility(0);
        this.x.setBackgroundColor(this.n.getResources().getColor(2131102388));
        ATSplashAd aTSplashAd = new ATSplashAd(this.n, this.y, this);
        this.z = aTSplashAd;
        if (aTSplashAd.isAdReady()) {
            Log.i("anythink", "SplashAd is ready to show.");
            this.z.show(getActivity(), this.v);
        } else {
            Log.i("anythink", "SplashAd isn't ready to show, start to request.");
            this.z.loadAd();
        }
        e();
    }

    public void k() {
        if (this.r) {
            return;
        }
        this.r = true;
        l();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdClick(ATAdInfo aTAdInfo) {
        Log.i("anythink", "onAdClick:" + aTAdInfo.toString());
        FindHttpUtils.b(this.t);
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
        k();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdLoadTimeout() {
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdLoaded(boolean z) {
        Log.i("anythink", "onAdLoaded---------");
        this.f18740c.removeCallbacks(this.b);
        a();
        f();
        if (getActivity() != null) {
            this.z.show(getActivity(), this.v);
        }
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdShow(ATAdInfo aTAdInfo) {
        Log.i("anythink", "onAdShow:" + aTAdInfo.toString());
        this.q = true;
        this.p = System.currentTimeMillis();
        FindHttpUtils.b(this.s);
        this.x.setBackgroundColor(this.n.getResources().getColor(2131102478));
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.o;
        if (view == null) {
            if (getArguments() != null) {
                this.s = getArguments().getStringArray("KEY_SHOW_URL");
                this.t = getArguments().getStringArray("KEY_CLICK_URL");
                this.u = getArguments().getStringArray("KEY_HIDDEN_URL");
                this.y = getArguments().getString("SPLASH_ID");
                Log.v("drb", "topon showEntity.third_id:" + this.y);
            }
            this.o = layoutInflater.inflate(R.layout.fragment_tx_splash, viewGroup, false);
            j();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        return this.o;
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ATSplashAd aTSplashAd = this.z;
        if (aTSplashAd != null) {
            aTSplashAd.onDestory();
        }
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onNoAdError(AdError adError) {
        Log.i("anythink", "onNoAdError---------:" + adError.getFullErrorInfo());
        k();
    }
}
