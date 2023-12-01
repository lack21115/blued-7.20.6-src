package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/df.class */
public class df {
    public JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                    Set a2 = dk.a(jSONArray);
                    Set a3 = dk.a(jSONArray2);
                    if (a2 != null && a3 != null) {
                        a2.removeAll(a3);
                        if (a2.size() > 0) {
                            return new JSONArray((Collection) a2);
                        }
                        return null;
                    }
                }
            } catch (Exception e) {
                return null;
            }
        }
        return jSONArray;
    }

    public JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 2) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    hashSet.add((String) jSONArray.get(i2));
                    i = i2 + 1;
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    String str2 = (String) jSONArray.get(i2);
                    if (str2.contains("frida")) {
                        hashSet.add(str2);
                    }
                    i = i2 + 1;
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    String str2 = (String) jSONArray.get(i2);
                    if (str2.contains("substrate") || str2.contains(ShareConstants.JAR_SUFFIX) || str2.contains("xposed")) {
                        hashSet.add(str2);
                    }
                    i = i2 + 1;
                }
                if (hashSet.size() > 0) {
                    return new JSONArray((Collection) hashSet);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
