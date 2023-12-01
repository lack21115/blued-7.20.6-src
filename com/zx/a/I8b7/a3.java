package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.module.base.Listener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a3.class */
public class a3 implements v2 {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f28409a = new AtomicBoolean(false);
    public final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Listener f28410c;

    public static void a(a3 a3Var) throws Throwable {
        a3Var.getClass();
        String str = t2.i;
        if (!t2.m) {
            i.c();
        }
        a1.g();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("data", t2.a());
        String jSONObject2 = jSONObject.toString();
        a3Var.f28410c.onMessage("MESSAGE_ON_ZXID_RECEIVED", jSONObject2);
        if (TextUtils.equals(str, t2.i)) {
            return;
        }
        a3Var.f28410c.onMessage("MESSAGE_ON_ZXID_CHANGED", jSONObject2);
    }
}
