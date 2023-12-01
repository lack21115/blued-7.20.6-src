package com.qiniu.android.storage;

import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.utils.UrlSafeBase64;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/UpToken.class */
public final class UpToken {
    public static UpToken NULL = new UpToken("", "", "");
    public final String accessKey;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.accessKey = str3;
    }

    public static boolean isInvalid(UpToken upToken) {
        return upToken == null || upToken == NULL;
    }

    public static UpToken parse(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return NULL;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (!jSONObject.optString("scope").equals("") && jSONObject.optInt("deadline") != 0) {
                    return new UpToken(jSONObject.optString("returnUrl"), str, split[0]);
                }
                return NULL;
            } catch (JSONException e) {
                return NULL;
            }
        } catch (Exception e2) {
            return NULL;
        }
    }

    public static void setCurrent_region_id(LogHandler logHandler, String str) {
        if (str == null || str == "") {
            return;
        }
        String[] split = str.split("//");
        String str2 = split.length > 1 ? split[1] : split[0];
        if (Arrays.asList(FixedZone.arrayzone0).contains(str2)) {
            if (logHandler != null) {
                logHandler.send("current_region_id", "z0");
            }
        } else if (Arrays.asList(FixedZone.arrayzone1).contains(str2)) {
            if (logHandler != null) {
                logHandler.send("current_region_id", "z1");
            }
        } else if (Arrays.asList(FixedZone.arrayzone2).contains(str2)) {
            if (logHandler != null) {
                logHandler.send("current_region_id", "z2");
            }
        } else if (Arrays.asList(FixedZone.arrayzoneNa0).contains(str2)) {
            if (logHandler != null) {
                logHandler.send("current_region_id", "na0");
            }
        } else if (!Arrays.asList(FixedZone.arrayZoneAs0).contains(str2) || logHandler == null) {
        } else {
            logHandler.send("current_region_id", "as0");
        }
    }

    public boolean hasReturnUrl() {
        return !this.returnUrl.equals("");
    }

    public String toString() {
        return this.token;
    }
}
