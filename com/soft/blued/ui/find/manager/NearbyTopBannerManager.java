package com.soft.blued.ui.find.manager;

import android.content.Context;
import android.util.Log;
import com.anythink.banner.api.ATBannerExListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.expressad.d.b;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/NearbyTopBannerManager.class */
public class NearbyTopBannerManager {

    /* renamed from: a  reason: collision with root package name */
    private static NearbyTopBannerManager f16912a;
    private HashMap<Long, ATBannerView> b = new HashMap<>();

    /* renamed from: com.soft.blued.ui.find.manager.NearbyTopBannerManager$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/NearbyTopBannerManager$1.class */
    class AnonymousClass1 implements ATBannerExListener {
        public void onBannerAutoRefreshFail(AdError adError) {
        }

        public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
        }

        public void onBannerClicked(ATAdInfo aTAdInfo) {
        }

        public void onBannerClose(ATAdInfo aTAdInfo) {
        }

        public void onBannerFailed(AdError adError) {
            Log.v(b.f4297c, "put onBannerFailed:" + adError.toString());
        }

        public void onBannerLoaded() {
            Log.v(b.f4297c, "onBannerLoaded");
        }

        public void onBannerShow(ATAdInfo aTAdInfo) {
        }

        public void onDeeplinkCallback(boolean z, ATAdInfo aTAdInfo, boolean z2) {
        }

        public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        }
    }

    private NearbyTopBannerManager() {
    }

    public static NearbyTopBannerManager a() {
        if (f16912a == null) {
            synchronized (NearbyTopBannerManager.class) {
                try {
                    if (f16912a == null) {
                        f16912a = new NearbyTopBannerManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16912a;
    }

    public ATBannerView a(long j) {
        Log.v(b.f4297c, "get bannerView key:" + j + " -- " + this.b.get(Long.valueOf(j)));
        return this.b.get(Long.valueOf(j));
    }

    public void a(Long l, ATBannerView aTBannerView) {
        this.b.put(l, aTBannerView);
    }
}
