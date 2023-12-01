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
    e f6192a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    View f6193c;

    public MyOfferATNativeAd(Context context, e eVar) {
        this.b = context.getApplicationContext();
        this.f6192a = eVar;
        eVar.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATNativeAd.1
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e detail = MyOfferATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i);
                }
                MyOfferATNativeAd.this.notifyAdClicked();
            }

            public final void onAdClosed() {
            }

            public final void onAdShow() {
                MyOfferATNativeAd.this.notifyAdImpression();
            }

            public final void onDeeplinkCallback(boolean z) {
            }

            public final void onShowFailed(com.anythink.basead.c.e eVar2) {
            }
        });
        setNetworkInfoMap(b.a(this.f6192a.e()));
        setAdChoiceIconUrl(this.f6192a.j());
        setTitle(this.f6192a.b());
        setDescriptionText(this.f6192a.f());
        setIconImageUrl(this.f6192a.h());
        setMainImageUrl(this.f6192a.i());
        setCallToActionText(this.f6192a.g());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        e eVar = this.f6192a;
        if (eVar != null) {
            eVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        e eVar = this.f6192a;
        if (eVar != null) {
            eVar.a((a) null);
            this.f6192a.m();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        if (this.f6193c == null) {
            this.f6193c = e.k();
        }
        return this.f6193c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.f6192a != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.f6192a.a(view);
            } else {
                this.f6192a.a(view, clickViewList);
            }
        }
    }
}
