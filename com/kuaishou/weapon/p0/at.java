package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/at.class */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10123a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10124c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10123a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10123a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i) {
        JSONObject jSONObject = this.f10123a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set a2 = a(i);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    String replace = jSONArray.getString(i3).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                    String str2 = replace;
                    if (replace.startsWith(":")) {
                        str2 = replace.substring(1);
                    }
                    String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                    String packageName = context.getPackageName();
                    if (!str2.contains(packageName) && !packageName.contains(str2) && !a2.contains(substring)) {
                        hashSet.add(str2);
                    }
                    i2 = i3 + 1;
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean a() {
        return this.b;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f10123a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet<Object> hashSet = new HashSet();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    hashSet.add(jSONArray.getString(i2));
                    i = i2 + 1;
                }
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj : hashSet) {
                    jSONArray2.put(obj);
                }
                return jSONArray2;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean b() {
        return this.f10124c;
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f10123a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(optString) || optString.length() <= 3) {
                return null;
            }
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = new JSONArray(optString);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return hashSet;
                }
                hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i2), 16).intValue()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f10123a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP)) {
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jSONArray2.put(jSONArray.getString(i).replaceAll(" ", "").replace("\n", "").replace(SimpleComparison.GREATER_THAN_OPERATION, ""));
                    }
                    return jSONArray2;
                } else if (TextUtils.equals(str, "45")) {
                    String a2 = i.a("aae31bed33c490b6613a", "0701");
                    String a3 = i.a("99e111e83fc4d0a7662b", "0701");
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray3 = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= jSONArray3.length()) {
                            break;
                        }
                        hashSet.add(jSONArray3.getString(i3).replaceAll(" ", "").replace("\n", ""));
                        i2 = i3 + 1;
                    }
                    JSONArray jSONArray4 = new JSONArray();
                    for (Object obj : hashSet) {
                        jSONArray4.put(obj);
                        String str2 = (String) obj;
                        if (str2.contains(a2)) {
                            this.b = true;
                        }
                        if (str2.contains(a3)) {
                            this.f10124c = true;
                        }
                    }
                    return jSONArray4;
                } else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
