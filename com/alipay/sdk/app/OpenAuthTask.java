package com.alipay.sdk.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/OpenAuthTask.class */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    private static final Map<String, Callback> a = new ConcurrentHashMap();
    private static long b = -1;
    private static final int c = 122;
    private final Activity e;
    private Callback f;
    private volatile boolean d = false;
    private final Handler g = new Handler(Looper.getMainLooper());

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/OpenAuthTask$BizType.class */
    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        private String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/OpenAuthTask$Callback.class */
    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/OpenAuthTask$a.class */
    public final class a implements Runnable {
        final int a;
        final String b;
        final Bundle c;

        private a(int i, String str, Bundle bundle) {
            this.a = i;
            this.b = str;
            this.c = bundle;
        }

        /* synthetic */ a(OpenAuthTask openAuthTask, int i, String str, Bundle bundle, e eVar) {
            this(i, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.f != null) {
                OpenAuthTask.this.f.onResult(this.a, this.b, this.c);
            }
        }
    }

    public OpenAuthTask(Activity activity) {
        this.e = activity;
        com.alipay.sdk.sys.b.a().a(activity);
    }

    private String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put("package", this.e.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.7.4");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    private String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", bizType.appId);
            if (e.a[bizType.ordinal()] == 1) {
                appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return appendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i, String str2, Bundle bundle) {
        Callback remove = a.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
        if (r0 == null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.alipay.sdk.sys.a r10, java.lang.String r11, com.alipay.sdk.app.OpenAuthTask.BizType r12, java.util.Map<java.lang.String, java.lang.String> r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.OpenAuthTask.a(com.alipay.sdk.sys.a, java.lang.String, com.alipay.sdk.app.OpenAuthTask$BizType, java.util.Map, boolean):boolean");
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        Activity activity = this.e;
        String valueOf = String.valueOf(map);
        com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(activity, valueOf, "oa-" + bizType);
        this.f = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.app.statistic.a.b(this.e, aVar, "", aVar.p);
        }
    }
}
