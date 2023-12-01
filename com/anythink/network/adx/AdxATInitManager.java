package com.anythink.network.adx;

import android.content.Context;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATInitManager.class */
public class AdxATInitManager extends ATInitMediation {

    /* renamed from: a  reason: collision with root package name */
    private static volatile AdxATInitManager f8834a;

    public static AdxATInitManager getInstance() {
        if (f8834a == null) {
            synchronized (AdxATInitManager.class) {
                try {
                    if (f8834a == null) {
                        f8834a = new AdxATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8834a;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Adx";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.anythink.core.api.ATSDK";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("anythink_myoffer_full_screen");
        arrayList.add("anythink_myoffer_splash_ad_layout_asseblem_vertical_port");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
    }
}
