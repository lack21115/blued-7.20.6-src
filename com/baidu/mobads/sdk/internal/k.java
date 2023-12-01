package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private int f9434a;
    private String b;

    private static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        k kVar = null;
        if (optInt != -1) {
            kVar = null;
            if (!TextUtils.isEmpty(optString)) {
                kVar = new k();
                kVar.f9434a = optInt;
                kVar.b = optString;
            }
        }
        return kVar;
    }

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                try {
                    k a2 = a(jSONArray.getJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(new CpuChannelResponse(a2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public int a() {
        return this.f9434a;
    }

    public String b() {
        return this.b;
    }
}
