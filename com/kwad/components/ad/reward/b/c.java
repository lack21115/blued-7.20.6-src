package com.kwad.components.ad.reward.b;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/c.class */
public final class c {
    public static void a(b bVar, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null || bVar == null) {
            return;
        }
        try {
            rewardAdInteractionListener.onExtraRewardVerify(bVar.getType());
        } catch (Throwable th) {
        }
    }

    public static boolean a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null) {
            return false;
        }
        try {
            Method[] methods = rewardAdInteractionListener.getClass().getMethods();
            int length = methods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if ("onExtraRewardVerify".equals(methods[i2].getName())) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static b gU() {
        return new b(1);
    }
}
