package com.kwad.components.ad.splashscreen.b;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/b.class */
public final class b extends e {
    private KsLogoView mLogoView;

    private void h(ViewGroup viewGroup) {
        if (this.Cg.Bz != 0) {
            return;
        }
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.c.kwai.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.ar();
        KsLogoView ksLogoView = (KsLogoView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_logo_container);
        this.mLogoView = ksLogoView;
        h(ksLogoView);
        if (this.Cg.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.Cg.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.mLogoView.setVisibility(8);
            return;
        }
        this.mLogoView.setVisibility(0);
        this.mLogoView.S(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
