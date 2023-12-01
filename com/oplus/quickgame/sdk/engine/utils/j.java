package com.oplus.quickgame.sdk.engine.utils;

import android.app.Activity;
import android.content.ComponentName;
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
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.observer.RequestObserver;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.downloadlib.OrderDownloader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f10731a;
    private static Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static com.oplus.quickgame.sdk.engine.callback.a f10732c = new com.oplus.quickgame.sdk.engine.callback.a();

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j$a.class */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10733a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f10734c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f10733a = context;
            this.b = str;
            this.f10734c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.g(this.f10733a)) {
                j.c(this.b, this.f10733a, this.f10734c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j$b.class */
    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10735a;
        final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f10736c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f10735a = str;
            this.b = context;
            this.f10736c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d(this.f10735a, this.b, this.f10736c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j$c.class */
    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10737a;
        final /* synthetic */ Intent b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f10738c;

        /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j$c$a.class */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.b(c.this.f10738c);
            }
        }

        c(Context context, Intent intent, Callback callback) {
            this.f10737a = context;
            this.b = intent;
            this.f10738c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f10737a.startActivity(this.b);
                j.f10731a.post(new a());
            } catch (Exception e) {
                j.c(this.f10738c, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/j$d.class */
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f10740a;
        final /* synthetic */ Throwable b;

        d(Callback callback, Throwable th) {
            this.f10740a = callback;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d(this.f10740a, this.b);
        }
    }

    private static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        a(contentValues, "req_url", f.a(context, str2, str));
        a(contentValues, "from", "ins_sdk");
        a(contentValues, HttpHeaders.ReferrerPolicyValues.ORIGIN, str3);
        a(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        a(contentValues, "EXTRA_STAT_PARAMS", map3);
        a(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor a(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Uri a(String str, String str2) {
        Uri parse = Uri.parse(str);
        return Uri.parse("content://xgame_" + parse.getScheme() + "_" + parse.getHost() + "/" + str2);
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

    private static void a(Context context, String str) throws com.oplus.quickgame.sdk.engine.a.a {
        if (!n.g(context)) {
            throw new com.oplus.quickgame.sdk.engine.a.a(104, str);
        }
    }

    public static void a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        b();
        f10732c.a(callback);
        f10731a.post(new b(str, context, map2, map, map3, map4));
    }

    private static void a(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setComponent(new ComponentName(com.oplus.quickgame.sdk.engine.utils.c.a("Y29tLmhleXRhcC54Z2FtZQ=="), com.oplus.quickgame.sdk.engine.utils.c.a("Y29tLmhleXRhcC54Z2FtZS5kaXNwYXRjaC5hY3Rpdml0eS5IYXBEaXNwYXRjaGVyQWN0aXZpdHk=")));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            c(callback, exc);
            return;
        }
        if (b == null) {
            b = new Handler(Looper.getMainLooper());
        }
        b.post(new c(context, intent, callback));
    }

    public static void a(Map<String, String> map, int i, QuickGame.Builder builder) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            if (i == 0) {
                builder.putDeepLink(str, map.get(str));
            } else if (i == 1) {
                builder.putPlatform(str, map.get(str));
            } else if (i == 2) {
                builder.putExtra(str, map.get(str));
            } else if (i == 3) {
                builder.putStat(str, map.get(str));
            }
        }
    }

    private static void a(Map<String, String> map, String str) throws com.oplus.quickgame.sdk.engine.a.a {
        if (!map.containsKey(HttpHeaders.ReferrerPolicyValues.ORIGIN)) {
            throw new com.oplus.quickgame.sdk.engine.a.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.quickgame.sdk.engine.a.a(103, str);
        }
    }

    public static boolean a(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && Constant.Scheme.HAP.equals(parse.getScheme()) && OrderDownloader.BizType.GAME.equals(parse.getHost())) {
            return !TextUtils.isEmpty(parse.getPath());
        }
        return false;
    }

    private static Uri b(String str, String str2) {
        Uri parse = Uri.parse(str);
        return Uri.parse("content://xgame_preload_" + parse.getScheme() + "_" + parse.getHost() + "/" + str2);
    }

    private static Map<String, Object> b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("version", Integer.valueOf(n.a()));
        return hashMap;
    }

    private static void b() {
        synchronized (j.class) {
            try {
                if (f10731a == null) {
                    HandlerThread handlerThread = new HandlerThread("xgame-req");
                    handlerThread.start();
                    if (handlerThread.getLooper() != null) {
                        f10731a = new Handler(handlerThread.getLooper());
                    } else {
                        f10731a = new Handler();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        Callback callback2;
        Callback a2;
        String str2;
        synchronized (j.class) {
            try {
                b();
                map4.put("tsf_key", g.a());
                i.a("QgRouterManager", " reqAsync url = " + str);
                if (g.b(context, str, map4)) {
                    a2 = g.a(context, str, callback, map4);
                    map4.put("in_one_task", "1");
                    str2 = " reqAsync in one task";
                } else {
                    callback2 = callback;
                    if (g.a(context, str, map4)) {
                        a2 = g.a(context, str, callback, map4);
                        map4.put("in_tsf", "1");
                        str2 = " reqAsync in deep link";
                    }
                    f10732c.a(callback2);
                    f10731a.post(new a(context, str, map2, map, map3, map4));
                }
                i.a("QgRouterManager", str2);
                callback2 = a2;
                f10732c.a(callback2);
                f10731a.post(new a(context, str, map2, map, map3, map4));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg(bw.o);
        callback.onResponse(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Callback callback, Throwable th) {
        if (l.a()) {
            f10731a.post(new d(callback, th));
        } else {
            d(callback, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        String str2;
        StringBuilder sb;
        String securityException;
        String str3;
        if (str != null) {
            try {
                try {
                    if (str.contains("pkg")) {
                        try {
                            queryParameter = Uri.parse(str).getQueryParameter("pkg");
                        } catch (Exception e) {
                            i.b("QgRouterManager", str + " do jump exception 0: " + e.toString());
                        }
                        a(context, queryParameter);
                        a(map, queryParameter);
                        Map<String, Object> b2 = b(map);
                        String str4 = (String) b2.get("secret");
                        String str5 = (String) b2.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
                        Uri a2 = a(str, f.a(context, str4, a(b2)));
                        ContentValues a3 = a(context, str, map, map2, map3, map4, str4, str5);
                        context.getContentResolver().registerContentObserver(a2, false, new RequestObserver(context, b2, f10732c, a2));
                        context.getContentResolver().insert(a2, a3);
                    }
                } catch (IllegalArgumentException e2) {
                    if (e2.getMessage().contains("Unknown URL content") && str.startsWith("hap://")) {
                        a(e2, context, str, f10732c);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb = sb2;
                        str3 = " do jump exception 1: ";
                    } else {
                        c(f10732c, e2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        str3 = " do jump exception 2: ";
                        sb = sb3;
                    }
                    sb.append(str3);
                    securityException = e2.toString();
                    sb.append(securityException);
                    i.b("QgRouterManager", sb.toString());
                    return;
                } catch (SecurityException e3) {
                    if (e3.getMessage().contains("Failed to find provider xgame_hap_game") && str.startsWith("hap://")) {
                        a(e3, context, str, f10732c);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb = sb4;
                        str2 = " do jump exception 3: ";
                    } else {
                        c(f10732c, e3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        str2 = " do jump exception 4: ";
                        sb = sb5;
                    }
                    sb.append(str2);
                    securityException = e3.toString();
                    sb.append(securityException);
                    i.b("QgRouterManager", sb.toString());
                    return;
                }
            } catch (Throwable th) {
                c(f10732c, th);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(" do jump exception 5: ");
                sb = sb6;
                securityException = th.toString();
                sb.append(securityException);
                i.b("QgRouterManager", sb.toString());
                return;
            }
        }
        queryParameter = "";
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> b22 = b(map);
        String str42 = (String) b22.get("secret");
        String str52 = (String) b22.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
        Uri a22 = a(str, f.a(context, str42, a(b22)));
        ContentValues a32 = a(context, str, map, map2, map3, map4, str42, str52);
        context.getContentResolver().registerContentObserver(a22, false, new RequestObserver(context, b22, f10732c, a22));
        context.getContentResolver().insert(a22, a32);
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
                    Uri b3 = b(str, f.a(context, str2, a(b2)));
                    ContentValues a2 = a(context, str, map, map2, map3, map4, str2, str3);
                    context.getContentResolver().registerContentObserver(b3, false, new RequestObserver(context, b2, f10732c, b3));
                    context.getContentResolver().insert(b3, a2);
                }
            } catch (Throwable th) {
                c(f10732c, th);
                return;
            }
        }
        queryParameter = "";
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> b22 = b(map);
        String str22 = (String) b22.get("secret");
        String str32 = (String) b22.get(HttpHeaders.ReferrerPolicyValues.ORIGIN);
        Uri b32 = b(str, f.a(context, str22, a(b22)));
        ContentValues a22 = a(context, str, map, map2, map3, map4, str22, str32);
        context.getContentResolver().registerContentObserver(b32, false, new RequestObserver(context, b22, f10732c, b32));
        context.getContentResolver().insert(b32, a22);
    }
}
