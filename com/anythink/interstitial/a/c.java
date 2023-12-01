package com.anythink.interstitial.a;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialExListener;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/c.class */
public final class c implements ATInterstitialExListener {

    /* renamed from: a  reason: collision with root package name */
    ATInterstitialAutoEventListener f5972a;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        this.f5972a = aTInterstitialAutoEventListener;
    }

    @Override // com.anythink.interstitial.api.ATInterstitialExListener
    public final void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onDeeplinkCallback(aTAdInfo, z);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialExListener
    public final void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    ATInterstitialAutoEventListener aTInterstitialAutoEventListener = c.this.f5972a;
                    Context context2 = context;
                    Context context3 = context2;
                    if (context2 == null) {
                        context3 = n.a().E();
                    }
                    aTInterstitialAutoEventListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.7
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.6
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdClose(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdLoadFail(AdError adError) {
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdLoaded() {
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.8
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdShow(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdVideoEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoError(final AdError adError) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.5
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdVideoError(adError);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f5972a != null) {
                    c.this.f5972a.onInterstitialAdVideoStart(aTAdInfo);
                }
            }
        });
    }
}
