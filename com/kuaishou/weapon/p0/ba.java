package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ba.class */
public class ba {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10133a;
    private int b;

    public ba(Context context, int i, String str, boolean z) {
        if (Engine.loadSuccess && z) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f).intValue(), 0, i, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10133a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, "android.permission.READ_EXTERNAL_STORAGE") != -1;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int a() {
        return this.b;
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10133a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject b() {
        return this.f10133a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0124, code lost:
        if (r7 == null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject c() {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ba.c():org.json.JSONObject");
    }
}
