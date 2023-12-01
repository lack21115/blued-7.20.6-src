package com.igexin.push.core.b;

import android.text.TextUtils;
import com.igexin.push.extension.mod.BaseActionBean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/b/o.class */
public final class o extends BaseActionBean {

    /* renamed from: a  reason: collision with root package name */
    private long f23454a;

    private long a() {
        return this.f23454a;
    }

    private static o a(String str) throws JSONException {
        long j;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        o oVar = new o();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("actionid")) {
            oVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has("type")) {
            oVar.setType(jSONObject.getString("type"));
        }
        if (jSONObject.has(com.anythink.expressad.foundation.d.d.s)) {
            oVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.s));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            if (d > 0.0d) {
                j = (long) (d * 1000.0d);
                oVar.f23454a = j;
                return oVar;
            }
        }
        j = 200;
        oVar.f23454a = j;
        return oVar;
    }

    private void a(long j) {
        this.f23454a = j;
    }
}
