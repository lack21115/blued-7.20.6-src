package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10128a;

    public ax(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f10175c).intValue(), 2, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10128a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10128a;
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
        return this.f10128a;
    }
}
