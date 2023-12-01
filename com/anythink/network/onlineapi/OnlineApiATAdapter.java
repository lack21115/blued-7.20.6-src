package com.anythink.network.onlineapi;

import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.d.e;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATAdapter.class */
public class OnlineApiATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f9043a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    String f9044c;

    private void a(Context context, Map<String, Object> map) {
        this.f9044c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (j) map.get(g.k.f6515a);
        this.f9043a = new e(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.f9043a != null) {
            this.f9043a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f9044c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
    @Override // com.anythink.core.api.ATBaseAdAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadCustomNetworkAd(android.content.Context r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.onlineapi.OnlineApiATAdapter.loadCustomNetworkAd(android.content.Context, java.util.Map, java.util.Map):void");
    }
}
