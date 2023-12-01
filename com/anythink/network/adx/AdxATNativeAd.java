package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.h;
import com.anythink.basead.e.a;
import com.anythink.basead.e.e;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.d.b;
import com.anythink.core.common.d.c;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATNativeAd.class */
public class AdxATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    h f5998a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    boolean f5999c;
    boolean d;
    View e;

    public AdxATNativeAd(final Context context, h hVar, boolean z, boolean z2) {
        this.b = context.getApplicationContext();
        this.f5998a = hVar;
        hVar.a(new e(hVar.a()) { // from class: com.anythink.network.adx.AdxATNativeAd.1
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e detail = AdxATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i);
                }
                AdxATNativeAd.this.notifyAdClicked();
                if (AdxATNativeAd.this.f5998a.a().n() == 67) {
                    if (AdxATNativeAd.this.f5998a.a(true, false)) {
                        c.a(context).a(AdxATNativeAd.this.f5998a.a().p(), 1, 0);
                    }
                    if (AdxATNativeAd.this.f5998a.a(false, false)) {
                        b.a(context).a(AdxATNativeAd.this.f5998a.a().p(), 1, 0);
                    }
                }
            }

            public final void onAdClosed() {
                AdxATNativeAd.this.notifyAdDislikeClick();
            }

            public final void onAdShow() {
                super.onAdShow();
                AdxATNativeAd.this.notifyAdImpression();
                if (AdxATNativeAd.this.f5998a.a().n() == 67) {
                    if (AdxATNativeAd.this.f5998a.a(true, true)) {
                        c.a(context).a(AdxATNativeAd.this.f5998a.a().p(), 0, 1);
                    }
                    if (AdxATNativeAd.this.f5998a.a(false, true)) {
                        b.a(context).a(AdxATNativeAd.this.f5998a.a().p(), 0, 1);
                    }
                }
            }

            public final void onDeeplinkCallback(boolean z3) {
                AdxATNativeAd.this.notifyDeeplinkCallback(z3);
            }

            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
        this.f5999c = z;
        this.d = z2;
        if (z || this.f5998a.h()) {
            return;
        }
        setNetworkInfoMap(com.anythink.basead.b.a(this.f5998a.a()));
        setAdChoiceIconUrl(this.f5998a.g());
        setTitle(this.f5998a.b());
        setDescriptionText(this.f5998a.c());
        setIconImageUrl(this.f5998a.e());
        setMainImageUrl(this.f5998a.f());
        setCallToActionText(this.f5998a.d());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        h hVar = this.f5998a;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        h hVar = this.f5998a;
        if (hVar != null) {
            hVar.a((a) null);
            this.f5998a.j();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        if (this.e == null) {
            this.e = this.f5998a.a(this.b, this.f5999c, this.d, new BaseMediaAdView.a() { // from class: com.anythink.network.adx.AdxATNativeAd.2
                public final void onClickCloseView() {
                    AdxATNativeAd.this.notifyAdDislikeClick();
                }
            });
        }
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public ViewGroup getCustomAdContainer() {
        if (this.f5998a == null || this.f5999c) {
            return null;
        }
        return new OwnNativeAdView(this.b);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return this.f5999c || this.f5998a.h();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        h hVar = this.f5998a;
        if (hVar != null) {
            hVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        h hVar = this.f5998a;
        if (hVar != null) {
            hVar.k();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        this.f5998a.k();
        if (this.f5999c || this.f5998a == null) {
            return;
        }
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() <= 0) {
            this.f5998a.a(view);
        } else {
            this.f5998a.a(view, clickViewList);
        }
    }
}
