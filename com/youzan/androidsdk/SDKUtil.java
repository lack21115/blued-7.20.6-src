package com.youzan.androidsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/SDKUtil.class */
public class SDKUtil {
    public static <T> List<T> jsonToList(JSONObject jSONObject, String str, Class<T> cls) throws JSONException {
        if (jSONObject.has(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    arrayList.add((cls.getPackage() == null || !"java.lang".equals(cls.getPackage().getName())) ? cls.getConstructor(JSONObject.class).newInstance(optJSONArray.get(i2)) : optJSONArray.get(i2));
                    i = i2 + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }

    public static String verifyClientId(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("clientId should not be empty");
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            throw new IllegalArgumentException("clientId should not be empty");
        }
        if (trim.indexOf(32) == -1 && trim.indexOf(9) == -1) {
            return trim;
        }
        throw new IllegalArgumentException("clientId should not contain empty characters");
    }
}
