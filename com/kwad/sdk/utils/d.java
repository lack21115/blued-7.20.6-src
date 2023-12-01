package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/d.class */
public final class d {
    private static final Map<String, String> ayQ;

    static {
        HashMap hashMap = new HashMap();
        ayQ = hashMap;
        hashMap.put("HUAWEI", com.huawei.openalliance.ad.constant.t.W);
        ayQ.put(com.tencent.tendinsv.utils.r.d, "com.oppo.market");
        ayQ.put(AssistUtils.BRAND_VIVO, "com.bbk.appstore");
        ayQ.put(AssistUtils.BRAND_XIAOMI, "com.xiaomi.market");
        ayQ.put("OnePlus", "com.oppo.market");
        ayQ.put("Meizu", "com.meizu.mstore");
        ayQ.put("samsung", "com.sec.android.app.samsungapps");
        ayQ.put(com.tencent.tendinsv.utils.r.e, "com.smartisanos.appstore");
        ayQ.put("Realme", "com.oppo.market");
        ayQ.put("HONOR", com.huawei.openalliance.ad.constant.t.W);
    }

    private static boolean C(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        if (!as.DR() || adTemplate.mAdScene == null || adTemplate.mAdScene.adStyle == 4 || com.kwad.sdk.core.download.kwai.b.g(context, str) != 1) {
            return false;
        }
        adTemplate.mXiaomiAppStoreDetailViewOpen = true;
        return true;
    }

    private static boolean a(ResolveInfo resolveInfo) {
        return resolveInfo == null || resolveInfo.activityInfo == null || TextUtils.isEmpty(resolveInfo.activityInfo.packageName);
    }

    private static boolean et(String str) {
        return com.tencent.tendinsv.utils.r.d.equals(Build.BRAND) && com.cdo.oaps.ad.af.e.equals(str);
    }

    public static boolean f(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("samsung".equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = ayQ.get(Build.BRAND);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (!a(resolveInfo)) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    if (str4.equals(str3) || et(str4)) {
                        intent.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                        context.startActivity(intent);
                        return true;
                    }
                }
            }
            return C(context, str);
        } catch (Exception e) {
            return C(context, str);
        }
    }
}
