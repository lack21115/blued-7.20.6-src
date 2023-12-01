package com.opos.mobad.service;

import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f27375a = 1;
    private JSONObject b;

    /* renamed from: c  reason: collision with root package name */
    private long f27376c;
    private long d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.e = str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.d = elapsedRealtime;
        this.f27376c = elapsedRealtime;
        this.b = new JSONObject();
    }

    private String a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(this.e);
            sb.append("-");
        }
        sb.append(i);
        if (!TextUtils.isEmpty(str)) {
            sb.append("-");
            sb.append(str);
        }
        return sb.toString();
    }

    private JSONObject a() {
        try {
            this.b.put(a(0, "all"), SystemClock.elapsedRealtime() - this.f27376c);
        } catch (JSONException e) {
        }
        return this.b;
    }

    public String toString() {
        return a().toString();
    }
}
