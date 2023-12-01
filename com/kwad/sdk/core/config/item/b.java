package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/b.class */
public abstract class b<T> {
    private T adT;
    private T adU;
    private String mKey;

    public b(String str, T t) {
        this(str, t, t);
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.adU = t;
        this.adT = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public static String bB(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = com.kwad.sdk.core.kwai.c.bW(str);
        }
        return str2;
    }

    public static String bC(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (com.kwad.sdk.core.kwai.c.bY(str)) {
                str2 = com.kwad.sdk.core.kwai.c.bX(str);
            }
        }
        return str2;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void g(JSONObject jSONObject);

    public final String getKey() {
        return this.mKey;
    }

    public T getValue() {
        return this.adU;
    }

    public final void setValue(T t) {
        this.adU = t;
    }

    public final T uX() {
        return this.adT;
    }
}
