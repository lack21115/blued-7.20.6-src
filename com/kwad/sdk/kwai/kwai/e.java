package com.kwad.sdk.kwai.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/e.class */
public final class e implements View.OnClickListener {
    private final boolean YW;
    private final boolean YX;
    private View YY;
    private ImageView YZ;
    private TextView Za;
    private Button Zb;
    private int Zc;
    private int Zd;
    private boolean Ze;
    private final AdInfo mAdInfo;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private View mRootView = th();

    public e(Context context, AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.YW = z;
        this.YX = z2;
        this.Ze = z3;
        lb();
    }

    private void b(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.Zc = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.Zc);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void c(FrameLayout frameLayout) {
        int screenWidth = bd.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.Zd = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.Zd);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void lb() {
        this.Zb.setText(this.YW ? "安装" : "打开");
        this.YY.setOnClickListener(this);
        this.Zb.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.YZ, com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)), this.mAdTemplate, 8);
        String ao = com.kwad.sdk.core.response.a.a.ao(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        String str = ao;
        if (ao.length() >= 8) {
            str = ao.substring(0, 7) + "...";
        }
        this.Za.setText(this.mContext.getString(this.YW ? R.string.ksad_install_tips : R.string.ksad_launch_tips, str));
    }

    private void show() {
        ObjectAnimator ofFloat = (this.YW && this.YX) ? ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_X, this.Zd, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_Y, -this.Zc, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private View th() {
        Context context;
        int i;
        if (this.YW && this.YX) {
            context = this.mContext;
            i = R.layout.ksad_install_tips_bottom;
        } else {
            context = this.mContext;
            i = R.layout.ksad_install_tips;
        }
        this.mRootView = k.inflate(context, i, null);
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.YY = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.YZ = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.Za = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.Zb = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private Animator z(View view) {
        ObjectAnimator ofFloat = (this.YW && this.YX) ? ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f, this.Zd) : ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f, -this.Zc);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    public final void a(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.YW && this.YX) {
            c(frameLayout);
        } else {
            b(frameLayout);
        }
        this.mRootView.postDelayed(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.dismiss();
            }
        }, 10000L);
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator z = z(this.mRootView);
        z.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.kwai.kwai.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        z.start();
        c.sZ().te();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        dismiss();
        if (view.getId() != R.id.ksad_install_tips_install) {
            if (view.getId() == R.id.ksad_install_tips_close) {
                if (!this.YW) {
                    com.kwad.sdk.core.report.a.o(this.mAdTemplate, 48);
                } else if (!this.Ze) {
                    com.kwad.sdk.core.report.a.p(this.mAdTemplate, 46);
                } else {
                    i iVar = new i();
                    iVar.bl(69);
                    iVar.bp(23);
                    iVar.bt(1);
                    com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar);
                }
            }
        } else if (!this.YW) {
            if (ak.aj(this.mContext, com.kwad.sdk.core.response.a.a.aq(this.mAdInfo))) {
                com.kwad.sdk.core.report.a.as(this.mAdTemplate);
            }
            com.kwad.sdk.core.report.a.o(this.mAdTemplate, 47);
        } else {
            if (this.Ze) {
                i iVar2 = new i();
                iVar2.bl(29);
                iVar2.bp(23);
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar2);
            } else {
                com.kwad.sdk.core.report.a.p(this.mAdTemplate, 45);
            }
            if (ak.ak(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), this.mAdInfo.downloadFilePath)) {
                com.kwad.sdk.core.report.a.i(this.mAdTemplate, 1);
            }
        }
    }
}
