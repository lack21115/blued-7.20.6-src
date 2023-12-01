package com.anythink.interstitial.api;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.interstitial.a.b;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/api/ATInterstitialAutoAd.class */
public class ATInterstitialAutoAd {
    public static void addPlacementId(String... strArr) {
        b.a();
        b.a(strArr);
    }

    public static ATAdStatusInfo checkAdStatus(String str) {
        return b.a().b(str);
    }

    public static List<ATAdInfo> checkValidAdCaches(String str) {
        b.a();
        return b.c(str);
    }

    public static void entryAdScenario(String str, String str2) {
        b.a();
        b.a(str, str2, (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        b.a();
        b.a(str, str2, map);
    }

    public static void init(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        b.a().a(context, strArr, aTInterstitialAutoLoadListener);
    }

    public static boolean isAdReady(String str) {
        return b.a().a(str);
    }

    public static void removePlacementId(String... strArr) {
        b.a();
        b.b(strArr);
    }

    public static void setLocalExtra(String str, Map<String, Object> map) {
        b.a();
        b.a(str, map);
    }

    public static void show(Activity activity, String str, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        b.a().a(activity, str, "", aTInterstitialAutoEventListener);
    }

    public static void show(Activity activity, String str, String str2, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        b.a().a(activity, str, str2, aTInterstitialAutoEventListener);
    }
}
