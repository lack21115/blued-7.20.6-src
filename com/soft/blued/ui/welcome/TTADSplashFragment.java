package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.ui.TimeoutFragment;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.utils.third.TTADUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TTADSplashFragment.class */
public class TTADSplashFragment extends TimeoutFragment {
    public static boolean m = false;
    public Context n;
    public View o;
    public long p;
    public boolean q = false;
    private String[] r;
    private String[] s;
    private String[] t;
    private FrameLayout u;
    private View v;
    private View w;
    private String x;

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
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

    public void a(TTSplashAd tTSplashAd) {
        if (tTSplashAd == null) {
            return;
        }
        View splashView = tTSplashAd.getSplashView();
        FragmentActivity activity = getActivity();
        if (splashView == null || this.u == null || activity == null || activity.isFinishing()) {
            k();
        } else {
            this.u.removeAllViews();
            this.u.addView(splashView);
        }
        tTSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.soft.blued.ui.welcome.TTADSplashFragment.2
            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdClicked(View view, int i) {
                FindHttpUtils.b(TTADSplashFragment.this.s);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdShow(View view, int i) {
                TTADSplashFragment.this.a();
                TTADSplashFragment.this.q = true;
                TTADSplashFragment.this.p = System.currentTimeMillis();
                FindHttpUtils.b(TTADSplashFragment.this.r);
                TTADSplashFragment.this.w.setBackgroundColor(TTADSplashFragment.this.n.getResources().getColor(2131102478));
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdSkip() {
                FindHttpUtils.b(TTADSplashFragment.this.t);
                TTADSplashFragment.this.k();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdTimeOver() {
                TTADSplashFragment.this.k();
            }
        });
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void g() {
        k();
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public View h() {
        return this.o;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j() {
        getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.n, R.drawable.app_loading_bg));
        this.u = (FrameLayout) this.o.findViewById(R.id.fl_ad_content);
        View findViewById = this.o.findViewById(R.id.ll_click_skip);
        this.v = findViewById;
        findViewById.setVisibility(8);
        View findViewById2 = this.o.findViewById(R.id.view_btm_bar);
        this.w = findViewById2;
        findViewById2.setVisibility(0);
        this.w.setBackgroundColor(this.n.getResources().getColor(2131102388));
        TTADUtils.a(this.n, this.x, new TTADUtils.TTGetSplashAdListener() { // from class: com.soft.blued.ui.welcome.TTADSplashFragment.1
            @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
            public void a() {
                Log.v("drb", "getSplashAD onNoAD");
                TTADSplashFragment.this.q = true;
                TTADSplashFragment.this.k();
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
            public void a(int i, String str) {
                Log.v("drb", "getSplashAD onError");
                TTADSplashFragment.this.k();
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
            public void a(TTSplashAd tTSplashAd) {
                Log.v("drb", "getSplashAD onSuccess");
                TTADSplashFragment.this.a(tTSplashAd);
                TTADSplashFragment.this.f();
            }
        });
        e();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.o;
        if (view == null) {
            if (getArguments() != null) {
                this.r = getArguments().getStringArray("KEY_SHOW_URL");
                this.s = getArguments().getStringArray("KEY_CLICK_URL");
                this.t = getArguments().getStringArray("KEY_HIDDEN_URL");
                this.x = getArguments().getString("SPLASH_ID");
                Log.v("drb", "splash_id:" + this.x);
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
        m = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
