package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/b.class */
public final class b {
    private static final String[] aDV = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    public static String O(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static boolean fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }
}
