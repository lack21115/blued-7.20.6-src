package com.efs.sdk.base.core.config.a;

import com.efs.sdk.base.core.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f8149a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);

    private static void a(Map<String, String> map, JSONArray jSONArray) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                if (jSONObject != null && jSONObject.length() >= 2) {
                    String optString = jSONObject.optString("opt");
                    Object opt = jSONObject.opt("set");
                    if (optString != null && opt != null) {
                        String optString2 = jSONObject.optString("lt", null);
                        String optString3 = jSONObject.optString(TKDownloadReason.KSAD_TK_NET, null);
                        String str = optString;
                        if (optString2 != null) {
                            str = optString + "_" + optString2;
                        }
                        String str2 = str;
                        if (optString3 != null) {
                            str2 = str + "_" + optString3;
                        }
                        map.put(str2, String.valueOf(opt));
                    }
                }
                i = i2 + 1;
            } catch (Throwable th) {
                Log.e("efs.config", "updateConfigCond error", th);
                return;
            }
        }
    }

    public static boolean a(String str, b bVar) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.igexin.push.core.b.U);
            int i = jSONObject.getInt("cver");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject2.optString(next, ""));
                    }
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("app_configs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("conditions");
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(AssistPushConsts.MSG_TYPE_ACTIONS);
                            if (optJSONArray2 != null && optJSONArray3 != null && optJSONArray3.length() > 0) {
                                a(hashMap, optJSONArray3);
                            }
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            bVar.a(hashMap);
            bVar.f8143a = i;
            return true;
        } catch (Throwable th) {
            Log.e("efs.config", "parseConfig error, data is ".concat(String.valueOf(str)), th);
            return false;
        }
    }
}
