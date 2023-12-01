package com.ss.android.download.api.b;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/b/ox.class */
public class ox {
    public static long mb(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static String mb(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "";
            }
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            i = i2 + 1;
        }
    }

    public static JSONObject mb(JSONObject jSONObject) {
        return mb(jSONObject, new JSONObject());
    }

    public static JSONObject mb(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static JSONObject mb(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null) {
            if (jSONObjectArr.length != 0) {
                int length = jSONObjectArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONObjectArr[i2];
                    if (jSONObject2 != null) {
                        mb(jSONObject2, jSONObject);
                    }
                    i = i2 + 1;
                }
            } else {
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public static boolean mb(DownloadSetting downloadSetting, String str) {
        if (downloadSetting == null || downloadSetting.optInt("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }
}
