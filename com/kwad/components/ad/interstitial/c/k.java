package com.kwad.components.ad.interstitial.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/k.class */
public final class k extends com.kwad.components.ad.interstitial.c.b {
    private static int lu = 4;
    private c jt;
    private a ls = new a();
    private b lt = new b();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/k$a.class */
    public static final class a {
        private ImageView lv;
        private TextView lw;
        private TextView lx;
        private KsPriceView ly;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/k$b.class */
    public static final class b {
        private String appIconUrl;
        private CharSequence lA;
        private String lB;
        private String lC;
        private String lz;
        private String price;

        b() {
        }

        public final void A(String str) {
            this.price = str;
        }

        public final void B(String str) {
            this.lC = str;
        }

        public final void a(CharSequence charSequence) {
            this.lA = charSequence;
        }

        public final String ej() {
            return this.lz;
        }

        public final CharSequence ek() {
            return this.lA;
        }

        public final String el() {
            return this.lB;
        }

        public final String em() {
            return this.lC;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void x(String str) {
            this.appIconUrl = str;
        }

        public final void y(String str) {
            this.lz = str;
        }

        public final void z(String str) {
            this.lB = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.lv;
        if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.a.a.ci(adInfo)) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, lu);
            }
        }
        aVar.lw.setText(bVar.ej());
        if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            aVar.ly.d(bVar.getPrice(), bVar.el(), true);
            aVar.ly.setVisibility(0);
            aVar.lx.setVisibility(8);
            ei();
        } else {
            aVar.lx.setText(bVar.ek());
        }
        this.jt.ju.h(bVar.em(), 0);
    }

    private void e(AdInfo adInfo) {
        b bVar;
        String string;
        b bVar2;
        String string2;
        if (com.kwad.sdk.core.response.a.a.ci(adInfo)) {
            this.lt.x(com.kwad.sdk.core.response.a.a.cn(adInfo));
            this.lt.y(com.kwad.sdk.core.response.a.a.bL(adInfo));
            CharSequence e = com.kwad.sdk.core.response.a.a.e(adInfo, com.kwad.components.core.widget.e.WZ);
            CharSequence charSequence = e;
            if (TextUtils.isEmpty(e)) {
                charSequence = com.kwad.sdk.core.response.a.a.cm(adInfo);
            }
            this.lt.a(charSequence);
            if (com.kwad.sdk.core.response.a.a.cj(adInfo)) {
                this.lt.B(com.kwad.components.ad.c.b.ah());
            } else {
                this.lt.B(com.kwad.components.ad.c.b.ak());
            }
        } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            this.lt.x(ct.icon);
            this.lt.y(ct.name);
            this.lt.z(ct.originPrice);
            this.lt.A(ct.price);
            this.lt.B(com.kwad.components.ad.c.b.ai());
        } else if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            this.lt.x(com.kwad.sdk.core.response.a.a.bM(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ao(adInfo))) {
                bVar2 = this.lt;
                string2 = com.kwad.sdk.core.response.a.a.ao(adInfo);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                bVar2 = this.lt;
                string2 = getContext().getString(R.string.ksad_ad_default_username_normal);
            } else {
                bVar2 = this.lt;
                string2 = adInfo.advertiserInfo.adAuthorText;
            }
            bVar2.y(string2);
            this.lt.a(com.kwad.sdk.core.response.a.a.an(adInfo));
            this.lt.B(com.kwad.sdk.core.response.a.a.aw(adInfo));
        } else {
            this.lt.x(com.kwad.sdk.core.response.a.a.bM(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ap(adInfo))) {
                bVar = this.lt;
                string = com.kwad.sdk.core.response.a.a.ap(adInfo);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                bVar = this.lt;
                string = getContext().getString(R.string.ksad_ad_default_username_normal);
            } else {
                bVar = this.lt;
                string = adInfo.advertiserInfo.adAuthorText;
            }
            bVar.y(string);
            this.lt.a(com.kwad.sdk.core.response.a.a.an(adInfo));
            this.lt.B(com.kwad.sdk.core.response.a.a.aw(adInfo));
        }
    }

    private void ei() {
        View findViewById = this.jt.ju.findViewById(R.id.ksad_ad_desc_layout);
        View findViewById2 = this.jt.ju.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.jt.mAdTemplate);
        this.ls.lv = (ImageView) this.jt.ju.findViewById(R.id.ksad_app_icon);
        this.ls.lw = (TextView) this.jt.ju.findViewById(R.id.ksad_app_title);
        this.ls.lx = (TextView) this.jt.ju.findViewById(R.id.ksad_app_desc);
        this.ls.ly = (KsPriceView) this.jt.ju.findViewById(R.id.ksad_product_price);
        e(this.mAdInfo);
        a(this.ls, this.lt, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
