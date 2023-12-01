package com.oplus.instant.router.g;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import com.cdo.oaps.ad.OapsKey;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.instant.router.callback.Callback;
import com.oplus.quickgame.sdk.hall.Constant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f10611a;
    private static Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static com.oplus.instant.router.callback.a f10612c = new com.oplus.instant.router.callback.a();

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e$a.class */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10613a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f10614c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f10613a = context;
            this.b = str;
            this.f10614c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.c(this.f10613a) < 1100) {
                e.c(e.f10612c, new Exception("platform not found"));
            } else {
                e.c(this.b, this.f10613a, this.f10614c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e$b.class */
    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10615a;
        final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f10616c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f10615a = str;
            this.b = context;
            this.f10616c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(this.f10615a, this.b, this.f10616c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e$c.class */
    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10617a;
        final /* synthetic */ Intent b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f10618c;

        /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e$c$a.class */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.b(c.this.f10618c);
            }
        }

        c(Context context, Intent intent, Callback callback) {
            this.f10617a = context;
            this.b = intent;
            this.f10618c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!(this.f10617a instanceof Activity)) {
                    this.b.addFlags(268435456);
                }
                this.f10617a.startActivity(this.b);
                e.f10611a.post(new a());
            } catch (Exception e) {
                e.c(this.f10618c, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/e$d.class */
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f10620a;
        final /* synthetic */ Throwable b;

        d(Callback callback, Throwable th) {
            this.f10620a = callback;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(this.f10620a, this.b);
        }
    }

    private static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        a(contentValues, "req_url", com.oplus.instant.router.g.b.a(context, str2, str));
        a(contentValues, "from", "ins_sdk");
        a(contentValues, HttpHeaders.ReferrerPolicyValues.ORIGIN, str3);
        a(contentValues, "encrypt", 1);
        a(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        a(contentValues, "EXTRA_STAT_PARAMS", map3);
        a(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor a(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            com.oplus.instant.router.g.d.a("RequestUtil", th);
            return null;
        }
    }

    private static Uri a(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri parse = Uri.parse(str);
        if (com.oplus.instant.router.a.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.";
        } else {
            sb = new StringBuilder();
            str3 = "content://";
        }
        sb.append(str3);
        sb.append(parse.getScheme());
        sb.append("_");
        sb.append(parse.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    private static String a(Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        return sb.toString();
    }

    private static void a(ContentValues contentValues, String str, int i) {
        contentValues.put(str, Integer.valueOf(i));
    }

    private static void a(ContentValues contentValues, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        contentValues.put(str, str2);
    }

    private static void a(ContentValues contentValues, String str, Map<String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        contentValues.put(str, a(map));
    }

    private static void a(Context context, String str) throws com.oplus.instant.router.c.a {
        if (!h.b(context)) {
            throw new com.oplus.instant.router.c.a(104, str);
        }
    }

    public static void a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        synchronized (e.class) {
            try {
                c();
                Context applicationContext = context.getApplicationContext();
                Callback callback2 = callback;
                if (com.oplus.instant.router.g.c.a(applicationContext, str, map4)) {
                    callback2 = com.oplus.instant.router.g.c.a(context, str, callback);
                }
                com.oplus.instant.router.callback.c cVar = callback2;
                if (str.startsWith("hap://app/")) {
                    cVar = callback2;
                    if (map4 != null) {
                        cVar = callback2;
                        if ("1".equals(map4.get("in_one_task"))) {
                            cVar = new com.oplus.instant.router.callback.c(context, str, callback2);
                        }
                    }
                }
                f10612c.a(cVar);
                f10611a.post(new a(applicationContext, str, map2, map, map3, map4));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            c(callback, exc);
            return;
        }
        if (b == null) {
            b = new Handler(Looper.getMainLooper());
        }
        b.post(new c(context, intent, callback));
    }

    private static void a(Map<String, String> map, String str) throws com.oplus.instant.router.c.a {
        if (!map.containsKey(HttpHeaders.ReferrerPolicyValues.ORIGIN)) {
            throw new com.oplus.instant.router.c.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.instant.router.c.a(103, str);
        }
    }

    public static boolean a(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        if ("oaps".equals(parse.getScheme()) || Constant.Scheme.HAP.equals(parse.getScheme())) {
            if (!"oaps".equals(parse.getScheme()) || "instant".equals(parse.getHost())) {
                return !TextUtils.isEmpty(parse.getPath());
            }
            return false;
        }
        return false;
    }

    private static Uri b(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri parse = Uri.parse(str);
        if (com.oplus.instant.router.a.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.preload_";
        } else {
            sb = new StringBuilder();
            str3 = "content://preload_";
        }
        sb.append(str3);
        sb.append(parse.getScheme());
        sb.append("_");
        sb.append(parse.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    private static Map<String, Object> b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("version", h.a());
        return hashMap;
    }

    public static void b(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        c();
        f10612c.a(callback);
        f10611a.post(new b(str, context, map2, map, map3, map4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg(bw.o);
        callback.onResponse(response);
    }

    private static void c() {
        synchronized (e.class) {
            try {
                Handler handler = f10611a;
                if (handler == null || handler.getLooper() == null) {
                    HandlerThread handlerThread = new HandlerThread("instant-req");
                    handlerThread.start();
                    if (handlerThread.getLooper() != null) {
                        f10611a = new Handler(handlerThread.getLooper());
                    } else {
                        f10611a = new Handler();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Callback callback, Throwable th) {
        if (g.a()) {
            f10611a.post(new d(callback, th));
        } else {
            d(callback, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bf, code lost:
        if (r9.startsWith("hap://") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00de, code lost:
        if (r9.startsWith("hap://") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e1, code lost:
        a(r12, r10, r9, com.oplus.instant.router.g.e.f10612c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ea, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.String> r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.instant.router.g.e.c(java.lang.String, android.content.Context, java.util.Map, java.util.Map, java.util.Map, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Callback callback, Throwable th) {
        Callback.Response response = new Callback.Response();
        response.setCode(-8);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                if (str.contains("pkg")) {
                    try {
                        queryParameter = Uri.parse(str).getQueryParameter("pkg");
                    } catch (Exception e) {
                    }
                    a(context, queryParameter);
                    a(map, queryParameter);
                    Map<String, Object> b2 = b(map);
                    String str2 = (String) b2.get("secret");
                    String str3 = (String) b2.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
                    Uri b3 = b(str, com.oplus.instant.router.g.b.a(context, str2, a(b2)));
                    ContentValues a2 = a(context, str, map, map2, map3, map4, str2, str3);
                    context.getContentResolver().registerContentObserver(b3, false, new com.oplus.instant.router.e.a(context, b2, f10612c, b3));
                    context.getContentResolver().insert(b3, a2);
                }
            } catch (Throwable th) {
                c(f10612c, th);
                return;
            }
        }
        queryParameter = "";
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> b22 = b(map);
        String str22 = (String) b22.get("secret");
        String str32 = (String) b22.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
        Uri b32 = b(str, com.oplus.instant.router.g.b.a(context, str22, a(b22)));
        ContentValues a22 = a(context, str, map, map2, map3, map4, str22, str32);
        context.getContentResolver().registerContentObserver(b32, false, new com.oplus.instant.router.e.a(context, b22, f10612c, b32));
        context.getContentResolver().insert(b32, a22);
    }
}
