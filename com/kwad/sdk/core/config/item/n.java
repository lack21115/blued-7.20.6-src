package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/n.class */
public final class n extends b<String> {
    private static volatile String[] aea;

    public n(String str, String str2) {
        super(str, str2);
        aea = null;
    }

    public static boolean D(long j) {
        if (aea == null) {
            return false;
        }
        String[] strArr = aea;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String str = strArr[i2];
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static void bD(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aea = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), uX());
        setValue(string);
        bD(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(uX());
            return;
        }
        String optString = jSONObject.optString(getKey(), uX());
        setValue(optString);
        bD(optString);
    }
}
