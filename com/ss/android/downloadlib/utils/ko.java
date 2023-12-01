package com.ss.android.downloadlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.umeng.analytics.pro.at;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/ko.class */
public class ko {
    private static OpenAppResult b(Context context, com.ss.android.downloadlib.addownload.model.h hVar, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", hVar.mb);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new OpenAppResult(7, OpenAppResult.Source.AM_KLLK2);
        } catch (Throwable th) {
            ox(hVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void h(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
                String optString = lz.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                jb.mb(jSONObject2, "t", "v");
                jb.mb(jSONObject2, "p", String.this);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.x.hj().mb(mb, com.ss.android.downloadlib.addownload.x.e().mb(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new l() { // from class: com.ss.android.downloadlib.utils.ko.3.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        ko.ox(context, String.this, str2, hVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        Context context2 = context;
                        com.ss.android.downloadlib.ox.mb.mb(ko.mb(context2, Uri.parse(BaseConstants.MARKET_PREFIX + String.this)), hVar, true);
                        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_MESSAGE, th != null ? th.getMessage() : com.igexin.push.core.b.l);
                        com.ss.android.downloadlib.addownload.model.h hVar2 = hVar;
                        JSONObject jSONObject3 = jSONObject;
                        ko.ox(hVar2, jSONObject3, 7, 5, BaseConstants.MARKET_PREFIX + String.this);
                    }
                });
            }
        });
    }

    private static boolean h(Context context, String str) {
        Context context2 = context;
        if (context == null) {
            context2 = com.ss.android.downloadlib.addownload.x.getContext();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context2 instanceof Activity)) {
            intent.addFlags(268435456);
            if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String lz = com.ss.android.socialbase.appdownloader.u.hj.lz();
        if (jb.hj(com.ss.android.downloadlib.addownload.x.getContext(), lz)) {
            intent.setPackage(lz);
        }
        if (jb.mb(com.ss.android.downloadlib.addownload.x.getContext(), intent)) {
            try {
                context2.startActivity(intent);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private static OpenAppResult hj(Context context, String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new OpenAppResult(5);
        } catch (Exception e) {
            return new OpenAppResult(6, 14);
        }
    }

    private static void hj(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.2
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = Context.this;
                com.ss.android.downloadlib.ox.mb.mb(ko.mb(context2, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
                    Thread.sleep(lz.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.mb.ox.mb.mb().mb(Context.this, true);
                    com.ss.android.downloadlib.mb.ox.ox oxVar = new com.ss.android.downloadlib.mb.ox.ox();
                    oxVar.mb = 1;
                    oxVar.ox = 0;
                    String mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("v"), lz.optString("s"));
                    oxVar.b = String.format(mb, str);
                    com.ss.android.downloadlib.mb.ox.mb.mb().mb(oxVar, (com.ss.android.downloadlib.mb.ox.hj) null);
                    com.ss.android.downloadlib.mb.ox.mb.mb().ox();
                    ko.ox(hVar, jSONObject, -1, 2, String.format(mb, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.downloadlib.addownload.model.h hVar2 = hVar;
                    ko.ox(hVar2, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    public static Uri mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        String h = hVar.h();
        Uri.Builder builder = new Uri.Builder();
        JSONObject jSONObject = new JSONObject();
        JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
        String mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString(at.t), lz.optString("s"));
        builder.scheme("market").authority("details").appendQueryParameter("id", h);
        if (!TextUtils.isEmpty(mb)) {
            builder.appendPath(mb);
        }
        Uri build = builder.build();
        ox(hVar, jSONObject, -1, 6, build.toString());
        return build;
    }

    public static OpenAppResult mb(Context context, Uri uri) {
        if (context == null || uri == null || !"market".equals(uri.getScheme())) {
            return new OpenAppResult(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (jb.mb(context, intent)) {
                String lz = com.ss.android.socialbase.appdownloader.u.hj.lz();
                if (jb.hj(context, lz) && !com.ss.android.socialbase.appdownloader.u.hj.u()) {
                    intent.setPackage(lz);
                }
                if (DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                    com.ss.android.downloadlib.exception.b.mb().mb(false, "jump market error");
                    return new OpenAppResult(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return new OpenAppResult(5);
            }
            return new OpenAppResult(6, 13);
        } catch (Exception e) {
            return new OpenAppResult(6, 14);
        }
    }

    public static OpenAppResult mb(Context context, com.ss.android.downloadlib.addownload.model.h hVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new OpenAppResult(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.u.hj.u() && jb.hj(context, "com.sec.android.app.samsungapps")) {
            return hj(context, str);
        }
        if (!hVar.ox.isAd() || !hVar.hj.enableAM()) {
            return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        JSONArray optJSONArray = com.ss.android.downloadlib.addownload.x.lz().optJSONArray("am_plans");
        if (com.ss.android.socialbase.appdownloader.u.hj.ox() && com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONArray, "am_0")) {
            ox(context, hVar, str);
            return new OpenAppResult(7, OpenAppResult.Source.AM_M1);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONArray, "am_3")) {
            return b(context, hVar, str);
        } else {
            if (com.ss.android.socialbase.appdownloader.u.hj.h() && com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONArray, "am_2")) {
                hj(context, hVar, str);
                return new OpenAppResult(7, OpenAppResult.Source.AM_M2);
            } else if (com.ss.android.socialbase.appdownloader.u.hj.ox() && com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONArray, "am_6")) {
                return mb(context, mb(hVar));
            } else {
                if (com.ss.android.socialbase.appdownloader.u.hj.b() && com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONArray, "am_5")) {
                    h(context, hVar, str);
                    return new OpenAppResult(7, OpenAppResult.Source.AM_V1);
                }
                return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
        }
    }

    public static OpenAppResult mb(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new OpenAppResult(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.u.hj.u() && jb.hj(context, "com.sec.android.app.samsungapps")) {
            return hj(context, str);
        }
        return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenAppResult mb(Context context, String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent u = jb.u(context, str);
        if (u == null) {
            return new OpenAppResult(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.x.lz().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.x.jb() != null && com.ss.android.downloadlib.addownload.x.jb().mb() && mbVar.e()) {
            TTDelegateActivity.ox(str, mbVar);
            return new OpenAppResult(3);
        }
        u.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(u);
            return new OpenAppResult(3);
        } catch (Exception e) {
            return new OpenAppResult(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenAppResult mb(com.ss.android.downloadad.api.mb.ox oxVar, String str, String str2) {
        OpenAppResult ox = ox(str, oxVar);
        if (com.ss.android.downloadlib.ox.u.mb(oxVar)) {
            OpenAppResult openAppResult = ox;
            if (ox.getType() == 2) {
                openAppResult = mb(str2, oxVar);
            }
            return openAppResult;
        }
        return ox;
    }

    static OpenAppResult mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        return mb(com.ss.android.downloadlib.addownload.x.getContext(), str, mbVar);
    }

    private static String mb(String str, JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String mb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObject.optString("g"), str2);
        String mb2 = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObject.optString("h"), str2);
        String str3 = str;
        if (!TextUtils.isEmpty(mb)) {
            str3 = str;
            if (!TextUtils.isEmpty(mb2)) {
                str3 = str.replace(mb, mb2);
            }
        }
        return str3;
    }

    public static void mb(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.model.h h = com.ss.android.downloadlib.addownload.model.u.mb().h(j);
        try {
            JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
            boolean mb = com.ss.android.socialbase.appdownloader.u.mb.mb(lz, activity, com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString(OapsKey.KEY_BG), lz.optString("s")));
            HashMap<String, String> ox = jb.ox(new JSONObject(str2));
            if (mb && !ox.isEmpty() && mb(activity, str, ox)) {
                ox(h, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_V1, jSONObject, h, true);
                return;
            }
            int i = mb ? ox.isEmpty() ? 1 : 2 : 3;
            ox(h, jSONObject, i, 5, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.ox.mb.mb(mb(activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), h, true);
        } catch (Exception e2) {
            Context context = com.ss.android.downloadlib.addownload.x.getContext();
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), h, true);
            ox(h, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void mb(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.model.h h = com.ss.android.downloadlib.addownload.model.u.mb().h(j);
        try {
            JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
            String optString = lz.optString("s");
            String mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString(com.anythink.expressad.d.a.b.w), optString);
            String mb2 = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("ac"), optString);
            String mb3 = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("af"), optString);
            boolean mb4 = com.ss.android.socialbase.appdownloader.u.mb.mb(lz, context, mb2);
            StringBuilder sb = new StringBuilder(String.format(mb, str, mb3, mb2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String lz2 = com.ss.android.socialbase.appdownloader.u.hj.lz();
            if (jb.hj(context, lz2)) {
                intent.setPackage(lz2);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            jb.mb(jSONObject, "mf", Boolean.valueOf(mb4));
            jb.mb(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_KLLK2, jSONObject, h, true);
            if (mb4) {
                ox(h, jSONObject, -1, 3, sb.toString());
            } else {
                ox(h, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception e) {
            Context context2 = com.ss.android.downloadlib.addownload.x.getContext();
            com.ss.android.downloadlib.ox.mb.mb(mb(context2, Uri.parse(BaseConstants.MARKET_PREFIX + str)), h, true);
            ox(h, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean mb(Activity activity, String str, HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, hashMap);
        String lz = com.ss.android.socialbase.appdownloader.u.hj.lz();
        if (jb.hj(com.ss.android.downloadlib.addownload.x.getContext(), lz)) {
            intent.setPackage(lz);
        }
        if (jb.mb(com.ss.android.downloadlib.addownload.x.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.ss.android.downloadlib.exception.b.mb().mb(e, "start v1");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenAppResult ox(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new OpenAppResult(4, 11);
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.ss.android.downloadlib.addownload.x.getContext();
        }
        Intent u = jb.u(context2, str);
        if (u == null) {
            return new OpenAppResult(4, 22);
        }
        u.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context2.startActivity(u);
            return new OpenAppResult(3);
        } catch (Exception e) {
            return new OpenAppResult(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenAppResult ox(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        if (TextUtils.isEmpty(str)) {
            return new OpenAppResult(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.x.getContext();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (jb.ox(context, intent)) {
            if (com.ss.android.downloadlib.addownload.x.lz().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.x.jb() != null && com.ss.android.downloadlib.addownload.x.jb().mb() && Build.VERSION.SDK_INT >= 26 && mbVar.e()) {
                TTDelegateActivity.mb(str, mbVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.x.getContext().startActivity(intent);
                } catch (Exception e) {
                    return new OpenAppResult(2);
                }
            }
            return new OpenAppResult(1);
        }
        return new OpenAppResult(2, 24);
    }

    private static void ox(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.1
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject lz = com.ss.android.downloadlib.addownload.x.lz();
                final String optString = lz.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                jb.mb(jSONObject2, "p", String.this);
                jb.mb(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                jb.mb(jSONObject2, "m", Build.MODEL);
                jb.mb(jSONObject2, "im", com.ss.android.downloadlib.mb.mb.ox.mb(context));
                jb.mb(jSONObject2, "d", com.ss.android.downloadlib.mb.mb.ox.ox(context));
                jb.mb(jSONObject2, "t", "m");
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.x.hj().mb(mb, com.ss.android.downloadlib.addownload.x.e().mb(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new l() { // from class: com.ss.android.downloadlib.utils.ko.1.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        ko.ox(context, String.this, str2, hVar, jSONObject, lz, optString);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        Context context2 = context;
                        com.ss.android.downloadlib.ox.mb.mb(ko.mb(context2, Uri.parse(BaseConstants.MARKET_PREFIX + String.this)), hVar, true);
                        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_MESSAGE, th != null ? th.getMessage() : com.igexin.push.core.b.l);
                        com.ss.android.downloadlib.addownload.model.h hVar2 = hVar;
                        JSONObject jSONObject3 = jSONObject;
                        ko.ox(hVar2, jSONObject3, 4, 1, BaseConstants.MARKET_PREFIX + String.this);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(Context context, String str, String str2, com.ss.android.downloadlib.addownload.model.h hVar, JSONObject jSONObject) {
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 5);
        try {
            String mb = com.ss.android.socialbase.appdownloader.u.b.mb(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(mb)) {
                TTDelegateActivity.mb(str, hVar.mb, mb, jSONObject);
                return;
            }
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
        } catch (Exception e) {
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(Context context, String str, String str2, com.ss.android.downloadlib.addownload.model.h hVar, JSONObject jSONObject, JSONObject jSONObject2, String str3) {
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 1);
        try {
            String mb = mb(com.ss.android.socialbase.appdownloader.u.b.mb(new JSONObject(str2).optString("a")), jSONObject2, str3);
            jb.mb(jSONObject, EventConstants.ExtraJson.OPEN_URL, mb);
            if (h(context, mb)) {
                ox(hVar, jSONObject, -1, 1, mb);
                com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_M1, jSONObject, hVar, true);
                return;
            }
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 2, 1, BaseConstants.MARKET_PREFIX + str);
        } catch (Exception e) {
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 3, 1, BaseConstants.MARKET_PREFIX + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(com.ss.android.downloadlib.addownload.model.h hVar, JSONObject jSONObject, int i, int i2, String str) {
        jb.mb(jSONObject, "error_code", Integer.valueOf(i));
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, Integer.valueOf(i2));
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_REAL_MARKET_URL, str);
        jb.mb(jSONObject, com.ss.android.socialbase.appdownloader.u.hj.lz(), Integer.valueOf(jb.ox(com.ss.android.downloadlib.addownload.x.getContext(), com.ss.android.socialbase.appdownloader.u.hj.lz())));
        AdEventHandler.mb().ox(EventConstants.Label.ANTI_MARKET_RESULT, jSONObject, hVar);
    }
}
