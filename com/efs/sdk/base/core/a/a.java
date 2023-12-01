package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/a.class */
public final class a {
    private static volatile long b = -1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f8113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.efs.sdk.base.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/a$a.class */
    public static final class C0162a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f8114a = new a((byte) 0);
    }

    private a() {
        this.f8113a = true;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0162a.f8114a;
    }

    public static String a(String str, c cVar) {
        byte b2 = cVar.g;
        String str2 = b2 != 1 ? b2 != 2 ? b2 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs";
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String optString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(optString);
            if (!"0".equals(optString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j - b()) > 1500000) {
                b = j - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }

    public static long b() {
        return b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + b;
    }

    public final HttpResponse a(String str, c cVar, File file, boolean z) {
        String b2 = cVar.b();
        String a2 = a(str, cVar);
        if (this.f8113a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(a2)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b2);
        com.efs.sdk.base.core.util.a.d a3 = new com.efs.sdk.base.core.util.a.d(a2).a(hashMap);
        a3.f8185a.d = file;
        com.efs.sdk.base.core.util.a.d a4 = a3.a("type", cVar.h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.m);
        return a4.a(OapsKey.KEY_SIZE, sb.toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }
}
