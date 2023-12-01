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
    private static volatile AdxATInitManager f5994a;

    public static AdxATInitManager getInstance() {
        if (f5994a == null) {
            synchronized (AdxATInitManager.class) {
                try {
                    if (f5994a == null) {
                        f5994a = new AdxATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5994a;
    }

    public String getNetworkName() {
        return "Adx";
    }

    public String getNetworkSDKClass() {
        return "com.anythink.core.api.ATSDK";
    }

    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("anythink_myoffer_full_screen");
        arrayList.add("anythink_myoffer_splash_ad_layout_asseblem_vertical_port");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
    }
}
