package com.soft.blued.ui.find.manager;

import android.content.Context;
import android.util.Log;
import com.anythink.banner.api.ATBannerExListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/NearbyTopBannerManager.class */
public class NearbyTopBannerManager {

    /* renamed from: a  reason: collision with root package name */
    private static NearbyTopBannerManager f30602a;
    private HashMap<Long, ATBannerView> b = new HashMap<>();

    /* renamed from: com.soft.blued.ui.find.manager.NearbyTopBannerManager$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/NearbyTopBannerManager$1.class */
    class AnonymousClass1 implements ATBannerExListener {
        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshFail(AdError adError) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClicked(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClose(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerFailed(AdError adError) {
            Log.v("anythink", "put onBannerFailed:" + adError.toString());
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerLoaded() {
            Log.v("anythink", "onBannerLoaded");
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerShow(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerExListener
        public void onDeeplinkCallback(boolean z, ATAdInfo aTAdInfo, boolean z2) {
        }

        @Override // com.anythink.banner.api.ATBannerExListener
        public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        }
    }

    private NearbyTopBannerManager() {
    }

    public static NearbyTopBannerManager a() {
        if (f30602a == null) {
            synchronized (NearbyTopBannerManager.class) {
                try {
                    if (f30602a == null) {
                        f30602a = new NearbyTopBannerManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f30602a;
    }

    public ATBannerView a(long j) {
        Log.v("anythink", "get bannerView key:" + j + " -- " + this.b.get(Long.valueOf(j)));
        return this.b.get(Long.valueOf(j));
    }

    public void a(Long l, ATBannerView aTBannerView) {
        this.b.put(l, aTBannerView);
    }
}
