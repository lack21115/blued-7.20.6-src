package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsDrawAd;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATDrawAd.class */
public class KSATDrawAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    Context f8981a;
    KsDrawAd b;

    /* renamed from: c  reason: collision with root package name */
    View f8982c;

    public KSATDrawAd(Context context, KsDrawAd ksDrawAd) {
        this.f8981a = context;
        this.b = ksDrawAd;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsDrawAd ksDrawAd = this.b;
        if (ksDrawAd != null) {
            ksDrawAd.setAdInteractionListener(null);
            this.b = null;
        }
        this.f8981a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.f8982c == null) {
                this.f8982c = this.b.getDrawView(this.f8981a);
            }
            return this.f8982c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        this.b.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATDrawAd.1
            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdClicked() {
                KSATDrawAd.this.notifyAdClicked();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdShow() {
                KSATInitManager.getInstance().a(KSATDrawAd.this.getShowId(), new WeakReference(KSATDrawAd.this.b));
                KSATDrawAd.this.notifyAdImpression();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                KSATDrawAd.this.notifyAdVideoEnd();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayError() {
                KSATDrawAd.this.notifyAdVideoVideoPlayFail("", "KS Native Video Play Error");
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayStart() {
                KSATDrawAd.this.notifyAdVideoStart();
            }
        });
    }
}
