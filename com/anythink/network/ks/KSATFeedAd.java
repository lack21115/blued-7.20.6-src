package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsFeedAd;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATFeedAd.class */
public class KSATFeedAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    Context f8984a;
    KsFeedAd b;

    /* renamed from: c  reason: collision with root package name */
    View f8985c;

    /* renamed from: com.anythink.network.ks.KSATFeedAd$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATFeedAd$1.class */
    final class AnonymousClass1 implements KsFeedAd.AdInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdClicked() {
            KSATFeedAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdShow() {
            KSATInitManager.getInstance().a(KSATFeedAd.this.getShowId(), new WeakReference(KSATFeedAd.this.b));
            KSATFeedAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDislikeClicked() {
            KSATFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }
    }

    public KSATFeedAd(Context context, KsFeedAd ksFeedAd, boolean z) {
        this.f8984a = context.getApplicationContext();
        this.b = ksFeedAd;
        try {
            ksFeedAd.setVideoSoundEnable(z);
            setNativeInteractionType(this.b.getInteractionType() == 2 ? 3 : this.b.getInteractionType() == 1 ? 1 : 0);
            if (this.b.getMaterialType() == 1) {
                this.mAdSourceType = "1";
            } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
                this.mAdSourceType = "2";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setAdInteractionListener(new AnonymousClass1());
    }

    private void a(boolean z) {
        try {
            this.b.setVideoSoundEnable(z);
            int i = 0;
            if (this.b.getInteractionType() == 1) {
                i = 1;
            }
            if (this.b.getInteractionType() == 2) {
                i = 3;
            }
            setNativeInteractionType(i);
            if (this.b.getMaterialType() == 1) {
                this.mAdSourceType = "1";
            } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
                this.mAdSourceType = "2";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setAdInteractionListener(new AnonymousClass1());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsFeedAd ksFeedAd = this.b;
        if (ksFeedAd != null) {
            ksFeedAd.setAdInteractionListener(null);
            this.b = null;
        }
        this.f8984a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.f8985c == null) {
                this.f8985c = this.b.getFeedView(this.f8984a);
            }
            return this.f8985c;
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
    }
}
