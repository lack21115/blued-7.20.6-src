package com.huawei.openalliance.ad.utils;

import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/q.class */
public class q {
    private static final String Code = "HagUtil";
    private static String I = "startAbilityByAbilityInfo";
    private static final String V = "com.huawei.hag.abilitykit.api.KitSdkManager";

    public static boolean Code() {
        return an.I(V);
    }

    public static boolean V() {
        if (Code()) {
            try {
                boolean canIUseApi = KitSdkManager.getInstance().canIUseApi(I);
                ge.V(Code, "can use api is %s", Boolean.valueOf(canIUseApi));
                return canIUseApi;
            } catch (Throwable th) {
                ge.V(Code, "isSupportFaApi exception %s", th.getClass().getSimpleName());
                return false;
            }
        }
        return false;
    }
}
