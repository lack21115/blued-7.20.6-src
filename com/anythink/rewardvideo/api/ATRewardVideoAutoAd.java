package com.anythink.rewardvideo.api;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.rewardvideo.a.d;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoAutoAd.class */
public class ATRewardVideoAutoAd {
    public static void addPlacementId(String... strArr) {
        d.a();
        d.a(strArr);
    }

    public static ATAdStatusInfo checkAdStatus(String str) {
        return d.a().b(str);
    }

    public static List<ATAdInfo> checkValidAdCaches(String str) {
        return d.a().c(str);
    }

    public static void entryAdScenario(String str, String str2) {
        d.a();
        d.a(str, str2, (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        d.a();
        d.a(str, str2, map);
    }

    public static void init(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
        d.a().a(context, strArr, aTRewardVideoAutoLoadListener);
    }

    public static boolean isAdReady(String str) {
        return d.a().a(str);
    }

    public static void removePlacementId(String... strArr) {
        d.a();
        d.b(strArr);
    }

    public static void setLocalExtra(String str, Map<String, Object> map) {
        d.a();
        d.a(str, map);
    }

    public static void show(Activity activity, String str, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        d.a().a(activity, str, "", aTRewardVideoAutoEventListener);
    }

    public static void show(Activity activity, String str, String str2, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        d.a().a(activity, str, str2, aTRewardVideoAutoEventListener);
    }
}
