package com.anythink.network.directly;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.common.e.aa;
import com.anythink.network.adx.AdxATInterstitialAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/directly/DirectlyATInterstitialAdapter.class */
public class DirectlyATInterstitialAdapter extends AdxATInterstitialAdapter {
    private int d = 0;

    public void fixDirectlyInterstitial() {
        aa d;
        if (this.b == null || (d = this.b.d()) == null) {
            return;
        }
        d.d(this.d == 0 ? 2 : 1);
        aa aaVar = d;
        if (aaVar.Y() == 5 && this.d == 0) {
            aaVar.j(3);
        }
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter
    public String getNetworkName() {
        return "Directly";
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        if (map.containsKey("unit_type") && (obj = map.get("unit_type")) != null) {
            this.d = Integer.parseInt(obj.toString());
        }
        super.loadCustomNetworkAd(context, map, map2);
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        fixDirectlyInterstitial();
        super.show(activity);
    }
}
