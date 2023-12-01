package com.anythink.network.onlineapi;

import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.d.e;
import com.anythink.core.common.e.j;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATAdapter.class */
public class OnlineApiATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f6203a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    String f6204c;

    private void a(Context context, Map<String, Object> map) {
        this.f6204c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (j) map.get("basead_params");
        this.f6203a = new e(context, b.a.b, this.b);
    }

    public void destory() {
        if (this.f6203a != null) {
            this.f6203a = null;
        }
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkPlacementId() {
        return this.f6204c;
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
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
