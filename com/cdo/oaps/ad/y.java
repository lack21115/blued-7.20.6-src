package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/y.class */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7945a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";
    public static final String b = "b3Bwby9sYXVuY2g=";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7946c = "scheme";
    public static final String d = "host";
    public static final String e = "params";
    public static final String f = "gb";
    public static final String g = "gamecenter";

    private static int a(String str, int i) {
        int i2 = i;
        if (!TextUtils.isEmpty(str)) {
            try {
                i2 = Integer.parseInt(str.trim());
            } catch (NumberFormatException e2) {
                return i;
            }
        }
        return i2;
    }

    private static Intent a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.addCategory(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str3)) {
                intent.setData(Uri.parse(str3));
            }
            if (!TextUtils.isEmpty(str4)) {
                intent.setType(str4);
            }
        } else {
            intent.setDataAndType(Uri.parse(str3), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.setPackage(str5);
        }
        return intent;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String str = map.get("scheme");
        String str2 = map.get("host");
        String str3 = map.get("params");
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            str4 = null;
            if (!TextUtils.isEmpty(str2)) {
                str4 = null;
                if (map.containsKey("params")) {
                    int i = 0;
                    if (map.containsKey(f)) {
                        i = a(map.get(f), 0);
                    }
                    str4 = str + "://" + str2 + "?params=" + str3 + ContainerUtils.FIELD_DELIMITER + f + "=" + i;
                }
            }
        }
        return str4;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = false;
        if (a(str)) {
            String a2 = a(b(str));
            PackageManager packageManager = context.getPackageManager();
            String str2 = null;
            Intent a3 = a(a.b(f7945a), str2, a2, a.b(b), str2);
            z = false;
            if (!TextUtils.isEmpty(a2)) {
                z = false;
                if (packageManager != null) {
                    z = false;
                    if (a(packageManager, a3)) {
                        z = a(context, a3);
                    }
                }
            }
        }
        return z;
    }

    private static boolean a(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 32);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean a(PackageManager packageManager, String str) {
        String str2 = b(str).get("scheme");
        String str3 = null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a(a.b(f7945a), str3, str2 + "://", a.b(b), str3), 160);
        boolean z = false;
        if (queryIntentActivities != null) {
            z = false;
            if (queryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo != null && next.activityInfo.metaData != null) {
                        z = false;
                        if (next.activityInfo.metaData.getFloat("gcsdk_launcher_version", -1.0f) > 0.0f) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private static boolean a(String str) {
        return str.contains("scheme") && str.contains("host") && str.contains("params");
    }

    public static float b(PackageManager packageManager, String str) {
        String str2 = b(str).get("scheme");
        String str3 = null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a(a.b(f7945a), str3, str2 + "://", a.b(b), str3), 160);
        float f2 = -1.0f;
        if (queryIntentActivities != null) {
            f2 = -1.0f;
            if (queryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    f2 = -1.0f;
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo != null && next.activityInfo.metaData != null) {
                        f2 = next.activityInfo.metaData.getFloat("gcsdk_launcher_version", -1.0f);
                        break;
                    }
                }
            }
        }
        return f2;
    }

    private static Map<String, String> b(String str) {
        int indexOf;
        String substring;
        String[] split;
        int indexOf2 = str.indexOf("?");
        if (indexOf2 == -1) {
            return null;
        }
        String substring2 = str.substring(indexOf2 + 1);
        HashMap hashMap = new HashMap();
        if (substring2 == null || substring2.length() <= 0) {
            return hashMap;
        }
        int i = 0;
        do {
            indexOf = substring2.indexOf(ContainerUtils.FIELD_DELIMITER, i) + 1;
            if (indexOf > 0) {
                substring = substring2.substring(i, indexOf - 1);
                i = indexOf;
            } else {
                substring = substring2.substring(i);
            }
            if (substring != null && (split = substring.split("=")) != null && split.length >= 1) {
                String str2 = split[0];
                String str3 = str2;
                if (str2 != null) {
                    str3 = str2.trim();
                }
                String str4 = split.length == 1 ? "" : split[1];
                String str5 = str4;
                if (str4 != null) {
                    str5 = str4.trim();
                }
                hashMap.put(str3, str5);
            }
        } while (indexOf > 0);
        return hashMap;
    }
}
