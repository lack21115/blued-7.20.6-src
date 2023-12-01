package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ThirdPartySplashAdView.class */
public class ThirdPartySplashAdView extends AsseblemSplashAdView {
    BaseAd P;

    public ThirdPartySplashAdView(Context context) {
        super(context);
    }

    public ThirdPartySplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar, String str) {
        super(context, jVar, iVar, aVar);
        this.P = com.anythink.basead.d.i.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public final float a(a aVar, int i) {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.AsseblemSplashAdView, com.anythink.basead.ui.BaseSdkSplashAdView
    public final void b() {
        super.b();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.r.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        BaseAd baseAd = this.P;
        if (baseAd == null || baseAd.getAdMediaView(new Object[0]) == null) {
            return;
        }
        View adMediaView = this.P.getAdMediaView(new Object[0]);
        if (adMediaView.getParent() != null) {
            ((ViewGroup) adMediaView.getParent()).removeView(adMediaView);
        }
        frameLayout2.addView(adMediaView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.anythink.basead.ui.AsseblemSplashAdView, com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public final boolean m() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    public final void o() {
        super.o();
        if (this.J != null) {
            this.J.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSdkSplashAdView, com.anythink.basead.ui.BaseSplashAdView
    public final void p() {
    }

    public void registerNativeClickListener(View view) {
        if (this.P != null) {
            if (this.f6049c.m.x() == 0) {
                this.r.add(this);
                this.P.registerListener(view, this.r, null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f6036a);
            this.P.registerListener(view, arrayList, null);
        }
    }
}
