package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ap.class */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10119a;

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.g).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10119a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f10119a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                return new JSONObject(string);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f10119a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                if (string.contains("{}")) {
                    return null;
                }
                return string;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
