package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/a.class */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig dZ;
    private final KsInterstitialAd.AdInteractionListener hN;
    private final com.kwad.components.ad.interstitial.d hU;
    private final boolean hV;
    private b hW;
    private InterfaceC0480a hX;
    private final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/a$a.class */
    public interface InterfaceC0480a {
        void cs();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/a$b.class */
    public interface b {
        void a(com.kwad.components.ad.interstitial.e.c cVar, int i);
    }

    public a(AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hU = dVar;
        this.dZ = ksAdVideoPlayConfig;
        this.hN = adInteractionListener;
        this.hV = com.kwad.sdk.core.response.a.a.bZ(com.kwad.sdk.core.response.a.d.cb(adTemplate)) != 1 ? false : true;
    }

    public final void a(InterfaceC0480a interfaceC0480a) {
        this.hX = interfaceC0480a;
    }

    public final void a(b bVar) {
        this.hW = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        com.kwad.components.ad.interstitial.e.c cVar = new com.kwad.components.ad.interstitial.e.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i > 0);
        if (i == 0) {
            cVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                @Override // com.kwad.components.ad.interstitial.c.c.a
                public final void cr() {
                    if (a.this.hX != null) {
                        a.this.hX.cs();
                    }
                }
            });
        }
        if (i > 0) {
            int i2 = 7;
            if (i == 1) {
                i2 = 7;
                if (this.hV) {
                    i2 = 8;
                }
            }
            cVar.setAggregateShowTriggerType(i2);
        }
        cVar.a(this.mAdTemplateList.get(i), this.hU, this.dZ, this.hN);
        b bVar = this.hW;
        if (bVar != null) {
            bVar.a(cVar, i);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }
}
