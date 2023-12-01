package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.tencent.mapsdk.internal.k2;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/i.class */
public class i {
    public static String a(String str, String str2) {
        String str3 = str;
        if (!str.equals(str2)) {
            str3 = b(str, str2);
        }
        return str3;
    }

    private static String b(String str, String str2) {
        HashSet<String> hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(k2.d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                hashSet.add(jSONArray.getString(i2));
                i = i2 + 1;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray(k2.d);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= jSONArray2.length()) {
                    break;
                }
                hashSet.add(jSONArray2.getString(i4));
                i3 = i4 + 1;
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        for (String str3 : hashSet) {
            jSONArray3.put(str3);
        }
        jSONObject.put(k2.d, jSONArray3);
        return jSONObject.toString();
    }
}
