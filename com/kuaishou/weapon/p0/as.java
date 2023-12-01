package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/as.class */
public class as extends df {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f23730a;

    public as(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(cj.f23783c).intValue();
                String a2 = a(context);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i, a2);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f23730a = new JSONObject(eopq);
            } catch (Throwable th) {
            }
        }
    }

    private String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            h a2 = h.a(context, "re_po_rt");
            sb.append(a2.b(de.Y, 1));
            sb.append(a2.b(de.V, 1));
            sb.append(a2.b(de.T, 1));
            sb.append(a2.b(de.X, 1));
            sb.append(a2.b(de.Z, 1));
            sb.append(a2.b(de.ab, 1));
            sb.append(a2.b(de.W, 1));
            sb.append(a2.b(de.S, 1));
            sb.append(a2.b(de.ae, 1));
            sb.append(a2.b(de.ac, 1));
            sb.append(a2.b(de.ad, 1));
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f23730a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a() {
        return this.f23730a;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f23730a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                String str2 = string;
                if (!TextUtils.isEmpty(string)) {
                    str2 = string.replace("\n", "").replace("\t", " ");
                }
                return str2;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f23730a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                String replaceAll = string.replaceAll("\\n", "");
                if (!TextUtils.isEmpty(replaceAll)) {
                    string = replaceAll;
                }
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 1) {
                    return jSONArray;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f23730a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 2) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.length() > 1) {
                    return jSONObject2;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public String e(String str) {
        JSONObject jSONObject = this.f23730a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                if (string.length() > 2) {
                    return string;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
