package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ce.class */
public class ce {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10169a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f10169a = new JSONObject(nop);
            } catch (Exception e) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10169a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f10169a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                try {
                    if (jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String a2 = f.a(jSONObject2.optString("1"));
                            String a3 = f.a(jSONObject2.optString("2"));
                            if (!TextUtils.isEmpty(a2)) {
                                jSONObject2.put("1", a2);
                            }
                            if (!TextUtils.isEmpty(a3)) {
                                jSONObject2.put("2", a3);
                            }
                            i = i2 + 1;
                        }
                    }
                    return jSONArray;
                } catch (Throwable th) {
                    return jSONArray;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
