package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.d.h;
import com.anythink.basead.e.a;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.e.e;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATNativeAd.class */
public class OnlineApiATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    h f9055a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    View f9056c;

    public OnlineApiATNativeAd(Context context, h hVar) {
        this.b = context.getApplicationContext();
        this.f9055a = hVar;
        hVar.a(new a() { // from class: com.anythink.network.onlineapi.OnlineApiATNativeAd.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i) {
                e detail = OnlineApiATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i);
                }
                OnlineApiATNativeAd.this.notifyAdClicked();
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                OnlineApiATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z) {
                OnlineApiATNativeAd.this.notifyDeeplinkCallback(z);
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
        setNetworkInfoMap(b.a(this.f9055a.a()));
        setAdChoiceIconUrl(this.f9055a.g());
        setTitle(this.f9055a.b());
        setDescriptionText(this.f9055a.c());
        setIconImageUrl(this.f9055a.e());
        setMainImageUrl(this.f9055a.f());
        setCallToActionText(this.f9055a.d());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        h hVar = this.f9055a;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        h hVar = this.f9055a;
        if (hVar != null) {
            hVar.a((a) null);
            this.f9055a.j();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f9056c == null) {
            this.f9056c = this.f9055a.a(this.b, false, false, null);
        }
        return this.f9056c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.f9055a != null) {
            return new OwnNativeAdView(this.b);
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.f9055a != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.f9055a.a(view);
            } else {
                this.f9055a.a(view, clickViewList);
            }
        }
    }
}
