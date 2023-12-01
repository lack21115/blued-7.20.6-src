package com.oplus.quickgame.sdk.engine.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.observer.RequestObserver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f10726a = "xgame_hap_game_cache_manage";
    public static String b = "action_game_cache";

    /* renamed from: c  reason: collision with root package name */
    public static String f10727c = "action_query_game_cache";
    public static String d = "action_delete_game_cache";
    public static String e = "action_query_game_pkg_list";
    public static String f = "action_delete_one_game_cache";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/g$a.class */
    public static final class a extends Callback {
        a() {
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            i.a("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/g$b.class */
    public static class b extends Callback {

        /* renamed from: a  reason: collision with root package name */
        private Callback f10728a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private String f10729c;
        private Map<String, String> d;

        public b(Context context, String str, Callback callback, Map<String, String> map) {
            this.f10728a = callback;
            this.b = context;
            this.f10729c = str;
            this.d = map;
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            Callback.Response response2 = response;
            if (response != null) {
                response2 = response;
                if (response.getCode() == 1) {
                    try {
                        i.b("GameUtil", "wrapper onResponse " + response);
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), c.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                        intent.putExtra("req_uri", this.f10729c);
                        intent.putExtra("tsf_key", this.d.get("tsf_key"));
                        if (this.b instanceof Activity) {
                            Activity activity = (Activity) this.b;
                            i.b("task_info", "router task id is " + activity.getTaskId());
                        } else {
                            intent.addFlags(268435456);
                        }
                        if (this.d.containsKey("in_one_task") && "1".equals(this.d.get("in_one_task"))) {
                            intent.putExtra("in_one_task", this.d.get("in_one_task"));
                        } else if (!this.d.containsKey("in_tsf") || !"1".equals(this.d.get("in_tsf"))) {
                            throw new IllegalArgumentException("invalid launch mode.");
                        } else {
                            intent.putExtra("in_tsf", this.d.get("in_tsf"));
                        }
                        this.b.startActivity(intent);
                        response2 = response;
                    } catch (Exception e) {
                        i.b("GameUtil", "wrapper onResponse ex:" + e.getMessage());
                        response2 = new Callback.Response();
                        response2.setCode(-4);
                        response2.setMsg("start transform page failed");
                    }
                }
            }
            Callback callback = this.f10728a;
            if (callback != null) {
                callback.onResponse(response2);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback, Map<String, String> map) {
        a aVar = callback;
        if (callback == null) {
            aVar = new a();
        }
        return new b(context, str, aVar, map);
    }

    public static String a() {
        return System.currentTimeMillis() + "_" + new Random().nextInt();
    }

    public static void a(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f10726a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
                contentValues.put(b, d);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                int i = -4;
                try {
                    if (th.getMessage().contains("Failed to find provider")) {
                        i = -16;
                    }
                    a(callback, th, i);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void a(Context context, Callback callback, String str, String str2, String str3) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f10726a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
                contentValues.put(b, f);
                contentValues.put("game_cache_pkg_name", str3);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                int i = -4;
                try {
                    if (th.getMessage().contains("Failed to find provider")) {
                        i = -16;
                    }
                    a(callback, th, i);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static void a(Callback callback, Throwable th, int i) {
        Callback.Response response = new Callback.Response();
        response.setCode(i);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    public static boolean a(Context context, String str, Map<String, String> map) {
        return str != null && str.startsWith("hap://game") && n.d(context) >= 1003;
    }

    public static void b(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f10726a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
                contentValues.put(b, f10727c);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                int i = -4;
                try {
                    if (th.getMessage().contains("Failed to find provider")) {
                        i = -16;
                    }
                    a(callback, th, i);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static boolean b(Context context, String str, Map<String, String> map) {
        if (str == null || !str.startsWith("hap://game") || n.d(context) < 1001) {
            return false;
        }
        if (map == null || !"1".equals(map.get("in_one_task"))) {
            try {
                return "1".equals(Uri.parse(str).getQueryParameter("in_one_task"));
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static void c(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f10726a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
                contentValues.put(b, e);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                int i = -4;
                try {
                    if (th.getMessage().contains("Failed to find provider")) {
                        i = -16;
                    }
                    a(callback, th, i);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void d(Context context, Callback callback, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        Uri parse = Uri.parse("content://" + f10726a);
        contentValues.put("req_url", f.a(context, str2, parse.toString()));
        contentValues.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
        contentValues.put(b, "action_upload_error_log");
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String replaceAll = new SimpleDateFormat("HH:mm:ss").format(new Date(currentTimeMillis)).replaceAll(":", "");
            jSONObject.put("id", "xgame_test_report_" + replaceAll);
            jSONObject.put("startTime", currentTimeMillis - 600000);
            jSONObject.put("endTime", currentTimeMillis);
            jSONObject.put("useWifi", false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        contentValues.put("action_game_cache_params", jSONObject.toString());
        context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
        context.getContentResolver().insert(parse, contentValues);
    }
}
