package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.tencent.mapsdk.internal.k2;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/f/d.class */
public class d extends a {
    public d(Context context, String str, boolean z) {
        this.e = z;
        if (a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.d = true;
        }
    }

    public d(boolean z, boolean z2) {
        this.e = z2;
        this.d = z;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        this.f9082a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f9082a.b(jSONObject.getString("name"));
            JSONArray jSONArray = jSONObject.getJSONArray(k2.d);
            if (jSONArray == null || jSONArray.length() == 0) {
                return -1;
            }
            if (jSONObject.has("customservices")) {
                b(jSONObject.getJSONArray("customservices"));
                return 0;
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return 0;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(jSONObject2.getString("id"));
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray2 = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 == null || jSONArray2.length() == 0) {
                    return -1;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray2.length()) {
                        break;
                    }
                    hashSet.add((String) jSONArray2.get(i4));
                    i3 = i4 + 1;
                }
                bVar.a(hashSet);
                this.b.add(bVar);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int e(String str) {
        return d(str);
    }
}
