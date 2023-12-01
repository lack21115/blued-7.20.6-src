package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.d.h;
import com.anythink.basead.e.a;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.e.e;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATNativeAd.class */
public class OnlineApiATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    h f6215a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    View f6216c;

    public OnlineApiATNativeAd(Context context, h hVar) {
        this.b = context.getApplicationContext();
        this.f6215a = hVar;
        hVar.a(new a() { // from class: com.anythink.network.onlineapi.OnlineApiATNativeAd.1
            public final void onAdClick(int i) {
                e detail = OnlineApiATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i);
                }
                OnlineApiATNativeAd.this.notifyAdClicked();
            }

            public final void onAdClosed() {
            }

            public final void onAdShow() {
                OnlineApiATNativeAd.this.notifyAdImpression();
            }

            public final void onDeeplinkCallback(boolean z) {
                OnlineApiATNativeAd.this.notifyDeeplinkCallback(z);
            }

            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
        setNetworkInfoMap(b.a(this.f6215a.a()));
        setAdChoiceIconUrl(this.f6215a.g());
        setTitle(this.f6215a.b());
        setDescriptionText(this.f6215a.c());
        setIconImageUrl(this.f6215a.e());
        setMainImageUrl(this.f6215a.f());
        setCallToActionText(this.f6215a.d());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        h hVar = this.f6215a;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        h hVar = this.f6215a;
        if (hVar != null) {
            hVar.a((a) null);
            this.f6215a.j();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        if (this.f6216c == null) {
            this.f6216c = this.f6215a.a(this.b, false, false, (BaseMediaAdView.a) null);
        }
        return this.f6216c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public ViewGroup getCustomAdContainer() {
        if (this.f6215a != null) {
            return new OwnNativeAdView(this.b);
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.f6215a != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.f6215a.a(view);
            } else {
                this.f6215a.a(view, clickViewList);
            }
        }
    }
}
