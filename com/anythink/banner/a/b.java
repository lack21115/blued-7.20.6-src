package com.anythink.banner.a;

import android.content.Context;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.g;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/a/b.class */
public final class b implements CustomBannerEventListener {
    WeakReference<e> a;
    CustomBannerAdapter b;
    boolean c;

    public b(e eVar, CustomBannerAdapter customBannerAdapter, boolean z) {
        this.c = false;
        this.a = new WeakReference<>(eVar);
        this.b = customBannerAdapter;
        this.c = z;
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdClicked() {
        CustomBannerAdapter customBannerAdapter = this.b;
        if (customBannerAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customBannerAdapter.getTrackingInfo();
            com.anythink.core.common.j.a.a(n.a().g()).a(6, trackingInfo);
            g.a(trackingInfo, g.i.d, g.i.f, "");
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.onBannerClicked(this.b);
            }
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdClose() {
        if (this.b != null) {
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.onBannerClose(this.b);
            }
            com.anythink.core.common.e.e trackingInfo = this.b.getTrackingInfo();
            com.anythink.core.common.k.g.a(trackingInfo, g.i.e, g.i.f, "");
            if (trackingInfo != null) {
                com.anythink.core.common.j.c.a(trackingInfo, false);
            }
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdShow() {
        if (this.b != null) {
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.onBannerShow(this.b, this.c);
            }
            com.anythink.core.common.e.e trackingInfo = this.b.getTrackingInfo();
            com.anythink.core.common.k.g.a(trackingInfo, g.i.c, g.i.f, "");
            com.anythink.core.common.j.a.a(n.a().g()).a(4, trackingInfo, this.b.getUnitGroupInfo());
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDeeplinkCallback(boolean z) {
        e eVar = this.a.get();
        if (eVar != null) {
            eVar.onDeeplinkCallback(this.b, z);
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        e eVar = this.a.get();
        if (eVar != null) {
            eVar.onDownloadConfirm(context, this.b, aTNetworkConfirmInfo);
        }
    }
}
