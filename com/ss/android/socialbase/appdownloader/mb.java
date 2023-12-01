package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb.class */
public class mb {
    public String b;
    public String h;
    public String hj;
    public String mb;
    public int ox = -1;

    public static mb mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        mb mbVar = new mb();
        try {
            JSONObject jSONObject = new JSONObject(str);
            mbVar.h = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            mbVar.hj = jSONObject.optString("real_device_plan", null);
            mbVar.b = jSONObject.optString("error_msg", null);
            mbVar.mb = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                mbVar.ox = -1;
                return mbVar;
            }
            mbVar.ox = Integer.parseInt(optString);
            return mbVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return mbVar;
        }
    }

    public String mb() {
        return ox().toString();
    }

    public void mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.mb);
            jSONObject.put("error_code", String.valueOf(this.ox));
            jSONObject.put("error_msg", this.b);
            jSONObject.put("real_device_plan", this.hj);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.h);
        } catch (Throwable th) {
        }
    }

    public JSONObject ox() {
        JSONObject jSONObject = new JSONObject();
        mb(jSONObject);
        return jSONObject;
    }
}
