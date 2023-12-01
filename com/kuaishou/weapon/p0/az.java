package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/az.class */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10130a;

    public az(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f10175c).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10130a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10130a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() <= 0) {
                    return null;
                }
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!a(set, str)) {
                        hashSet.add(str);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str, boolean z) {
        if (this.f10130a != null) {
            try {
                String a2 = a(str);
                if (TextUtils.isEmpty(a2) || a2.length() <= 3) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(a2);
                if (z) {
                    Iterator<String> keys = jSONObject.keys();
                    boolean z2 = false;
                    while (keys.hasNext()) {
                        if (jSONObject.getInt(keys.next()) == 1) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return jSONObject;
                    }
                    return null;
                }
                return jSONObject;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a2 = i.a("da4c6c97b9", "0702");
            String a3 = i.a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(a2);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a3);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() == 3) {
                jSONObject2.put("0", optJSONArray.get(2));
            }
            if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                jSONObject2.put("1", optJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public JSONObject b(String str) {
        if (this.f10130a != null) {
            try {
                String a2 = a(str);
                if (TextUtils.isEmpty(a2) || a2.length() <= 3) {
                    return null;
                }
                return new JSONObject(a2);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f10130a;
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
                Set a2 = a(hashSet);
                if (a2 == null || a2.size() <= 0) {
                    return null;
                }
                return new JSONArray((Collection) a2);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject d(String str) {
        if (this.f10130a != null) {
            try {
                String a2 = a(str);
                if (TextUtils.isEmpty(a2) || a2.length() <= 3) {
                    return null;
                }
                return a(new JSONObject(a2));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
