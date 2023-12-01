package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ko;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb.class */
public class mb {
    private static final HashMap<String, ko.mb> mb = new HashMap<>();

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || h.mb() || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static ko.mb mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ko.mb ox = ox(str);
            if (ox != null) {
                return ox;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean mb(org.json.JSONArray r5) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.mb(org.json.JSONArray):boolean");
    }

    public static boolean mb(JSONArray jSONArray, String str) {
        if (jSONArray == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && mb(optJSONObject)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean mb(JSONArray jSONArray, JSONArray jSONArray2, String str, ko.mb mbVar) {
        String ko = mbVar.ko();
        int u = mbVar.u();
        String str2 = u + "_" + ko;
        if (TextUtils.isEmpty(str)) {
            return (jSONArray == null || jSONArray.length() <= 0) ? (jSONArray2 == null || jSONArray2.length() <= 0 || ox(jSONArray2, str2)) ? false : true : ox(jSONArray, str2);
        }
        try {
            String[] split = str.split("[-,]");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split[i2 + 1]);
                if (u >= parseInt && u <= parseInt2) {
                    return true;
                }
                i = i2 + 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS);
        boolean z = false;
        if (ox(jSONObject)) {
            z = false;
            if (mb(optJSONArray)) {
                z = false;
                if (b(jSONObject)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean mb(JSONObject jSONObject, Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null || jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("s");
        try {
            String mb2 = b.mb(jSONObject.optString("az"), optString);
            String mb3 = b.mb(jSONObject.optString("ba"), optString);
            Field declaredField = ContextWrapper.class.getDeclaredField(mb2);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(context);
            Field declaredField2 = obj.getClass().getDeclaredField(mb3);
            declaredField2.setAccessible(true);
            declaredField2.set(obj, str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ko.mb ox(String str) {
        ko.mb mbVar;
        if (mb.containsKey(str)) {
            ko.mb mbVar2 = mb.get(str);
            mbVar = null;
            if (mbVar2 != null) {
                return mbVar2;
            }
        } else {
            ko.mb ox = ko.ox(str);
            mb.put(str, ox);
            mbVar = null;
            if (ox != null) {
                mbVar = ox;
            }
        }
        return mbVar;
    }

    private static boolean ox(JSONArray jSONArray, String str) {
        if (jSONArray == null || str == null) {
            return false;
        }
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean ox(JSONObject jSONObject) {
        boolean z = true;
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(optString)) {
            if (optInt > 0) {
                if (i >= optInt) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        try {
            String[] split = optString.split("[-,]");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= split.length) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split[i3 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
                i2 = i3 + 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
