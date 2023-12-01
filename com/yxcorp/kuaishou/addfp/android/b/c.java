package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    boolean f41856a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    boolean f41857c;
    String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f41856a = true;
        if (TextUtils.isEmpty(str)) {
            this.f41856a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("errorCode", 2);
            this.f41857c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e) {
            this.f41856a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (this.f41856a) {
            if (z != this.f41857c) {
                return "KWE_NPN";
            }
            int i = this.b;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.d) ? this.d : "KWE_N";
        }
        return "KWE_OTHER";
    }
}
