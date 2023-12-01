package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a0.class */
public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<String> f7582a;
    public HashMap<String, HashSet<String>> b;

    public a0(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        this.f7582a = hashSet;
        this.b = hashMap;
    }

    public static final a0 a(Context context, String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            SharedPreferences.Editor edit = e2.a(context, str, 0).edit();
            edit.clear().commit();
            c0 c0Var = null;
            if (jSONObject != null) {
                if (!jSONObject.has("event_list") || (optJSONObject = jSONObject.optJSONObject("event_list")) == null) {
                    return null;
                }
                int optInt = optJSONObject.optInt("is_block", 0);
                edit.putInt("is_block", optInt);
                HashSet hashSet = new HashSet();
                JSONArray optJSONArray = optJSONObject.optJSONArray(com.umeng.analytics.pro.d.f27025ar);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            hashSet.add(optString);
                        }
                        i = i2 + 1;
                    }
                }
                if (hashSet.size() > 0) {
                    edit.putStringSet(com.umeng.analytics.pro.d.f27025ar, hashSet);
                }
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            HashSet hashSet2 = new HashSet();
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray(next);
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= optJSONArray2.length()) {
                                        break;
                                    }
                                    String optString2 = optJSONArray2.optString(i4);
                                    if (!TextUtils.isEmpty(optString2)) {
                                        hashSet2.add(optString2);
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                            if (hashSet2.size() > 0) {
                                hashMap.put(next, hashSet2);
                            }
                        }
                    }
                }
                if (hashMap.size() > 0) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        edit.putStringSet((String) entry.getKey(), (Set) entry.getValue());
                    }
                }
                edit.commit();
                c0Var = optInt > 0 ? new c0(hashSet, hashMap) : new b0(hashSet, hashMap);
            }
            return c0Var;
        } catch (Throwable th) {
            return null;
        }
    }

    public abstract boolean a(String str);

    public final boolean a(String str, String str2) {
        JSONObject jSONObject;
        HashMap<String, HashSet<String>> hashMap;
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet<String> hashSet2 = this.f7582a;
        if (hashSet2 == null || hashSet2.size() <= 0) {
            return true;
        }
        if (a(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject == null || (hashMap = this.b) == null || hashMap.size() <= 0 || !this.b.containsKey(str) || (hashSet = this.b.get(str)) == null || hashSet.size() <= 0) {
            return true;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (a(hashSet, keys.next())) {
                try {
                    keys.remove();
                } catch (Throwable th) {
                }
            }
        }
        return true;
    }

    public abstract boolean a(HashSet<String> hashSet, String str);
}
