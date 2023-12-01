package com.yxcorp.kuaishou.addfp.android.b;

import android.accounts.AccountManager;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/b/c.class */
class c {

    /* renamed from: a  reason: collision with root package name */
    boolean f28165a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    boolean f28166c;
    String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f28165a = true;
        if (TextUtils.isEmpty(str)) {
            this.f28165a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt(AccountManager.KEY_ERROR_CODE, 2);
            this.f28166c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e) {
            this.f28165a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (this.f28165a) {
            if (z != this.f28166c) {
                return "KWE_NPN";
            }
            int i = this.b;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.d) ? this.d : "KWE_N";
        }
        return "KWE_OTHER";
    }
}
