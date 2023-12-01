package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/model/message/a.class */
public final class a {
    private JSONObject arF = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.arF.put(str, obj);
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
    }

    public final void dD(String str) {
        put(d.arf, str);
    }

    public final void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            b.d("ExceptionCollector", "string value to long ,max is 100");
        } else {
            put(str, str2);
        }
    }

    public final String toString() {
        return this.arF.toString();
    }
}
