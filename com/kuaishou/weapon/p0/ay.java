package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ay.class */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10129a;

    public ay(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f10175c).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10129a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f10129a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str) {
        try {
            String b = b(str);
            if (TextUtils.isEmpty(b)) {
                return null;
            }
            return new JSONObject(b);
        } catch (Exception e) {
            return null;
        }
    }
}
