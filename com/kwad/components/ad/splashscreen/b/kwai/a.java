package com.kwad.components.ad.splashscreen.b.kwai;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/a.class */
public final class a extends com.kwad.components.ad.splashscreen.b.e {
    private ViewGroup DA;
    private AnimatorSet Dx;
    private TextView Dy;
    private ViewGroup Dz;

    private void initView() {
        this.Dy = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.Dz = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.DA = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void lk() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DA, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Dy, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Dz, "scaleX", 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.Dz, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.Dx = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.Dx.setDuration(300L);
        this.Dx.start();
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        lk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.Dx;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
