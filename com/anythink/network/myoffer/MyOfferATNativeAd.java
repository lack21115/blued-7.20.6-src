package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.basead.b;
import com.anythink.basead.e.a;
import com.anythink.basead.f.e;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATNativeAd.class */
public class MyOfferATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    e f9032a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    View f9033c;

    public MyOfferATNativeAd(Context context, e eVar) {
        this.b = context.getApplicationContext();
        this.f9032a = eVar;
        eVar.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATNativeAd.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e detail = MyOfferATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i);
                }
                MyOfferATNativeAd.this.notifyAdClicked();
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                MyOfferATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar2) {
            }
        });
        setNetworkInfoMap(b.a(this.f9032a.e()));
        setAdChoiceIconUrl(this.f9032a.j());
        setTitle(this.f9032a.b());
        setDescriptionText(this.f9032a.f());
        setIconImageUrl(this.f9032a.h());
        setMainImageUrl(this.f9032a.i());
        setCallToActionText(this.f9032a.g());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        e eVar = this.f9032a;
        if (eVar != null) {
            eVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        e eVar = this.f9032a;
        if (eVar != null) {
            eVar.a((a) null);
            this.f9032a.m();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f9033c == null) {
            this.f9033c = e.k();
        }
        return this.f9033c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.f9032a != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.f9032a.a(view);
            } else {
                this.f9032a.a(view, clickViewList);
            }
        }
    }
}
