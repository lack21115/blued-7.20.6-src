package com.zx.a.I8b7;

import com.zx.a.I8b7.u2;
import com.zx.module.base.Callback;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z0.class */
public class z0 implements Runnable {

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z0$a.class */
    public class a implements Callback {
        public a(z0 z0Var) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("code") == 0) {
                    g1.b(jSONObject.getJSONObject("data").getString("type"), jSONObject.getJSONObject("data").getString("code"));
                }
            } catch (Throwable th) {
                z1.a(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u2.b.f42214a.b(new JSONObject(), new a(this), 2);
        } catch (Throwable th) {
            z1.a(th);
        }
    }
}
