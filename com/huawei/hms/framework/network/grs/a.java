package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/a.class */
public class a {
    private static final String e = "a";

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f9066a;
    private com.huawei.hms.framework.network.grs.e.a b;

    /* renamed from: c  reason: collision with root package name */
    private h f9067c;
    private com.huawei.hms.framework.network.grs.e.c d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/a$a.class */
    static class C0257a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a  reason: collision with root package name */
        String f9068a;
        Map<String, String> b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlsCallBack f9069c;
        Context d;
        GrsBaseInfo e;
        com.huawei.hms.framework.network.grs.e.a f;

        C0257a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f9068a = str;
            this.b = map;
            this.f9069c = iQueryUrlsCallBack;
            this.d = context;
            this.e = grsBaseInfo;
            this.f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f9068a, StringUtils.anonymizeMessage(new JSONObject(this.b).toString()));
                this.f9069c.onCallBackSuccess(this.b);
            } else if (this.b != null) {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f9068a);
                this.f9069c.onCallBackFail(-3);
            } else {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                ConcurrentHashMap a2 = com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.f9068a, true);
                if (a2 == null || a2.isEmpty()) {
                    Logger.e(a.e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f9068a);
                }
                if (a2 == null) {
                    a2 = new ConcurrentHashMap();
                }
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f9068a, StringUtils.anonymizeMessage(new JSONObject(a2).toString()));
                this.f9069c.onCallBackSuccess(a2);
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String j = dVar.j();
            Map<String, String> a2 = a.a(j, this.f9068a);
            if (a2.isEmpty()) {
                Map<String, String> map = this.b;
                if (map == null || map.isEmpty()) {
                    if (this.b != null) {
                        Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f9068a);
                        this.f9069c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(j)) {
                        Logger.e(a.e, "The serviceName[%s] is not configured on the GRS server.", this.f9068a);
                    }
                    Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    ConcurrentHashMap a3 = com.huawei.hms.framework.network.grs.f.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.f9068a, true);
                    if (a3 == null || a3.isEmpty()) {
                        Logger.e(a.e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f9068a);
                    }
                    if (a3 == null) {
                        a3 = new ConcurrentHashMap();
                    }
                    Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f9068a, StringUtils.anonymizeMessage(new JSONObject(a3).toString()));
                    this.f9069c.onCallBackSuccess(a3);
                    return;
                }
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f9068a, StringUtils.anonymizeMessage(new JSONObject(this.b).toString()));
                iQueryUrlsCallBack = this.f9069c;
                a2 = this.b;
            } else {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f9068a, StringUtils.anonymizeMessage(new JSONObject(a2).toString()));
                iQueryUrlsCallBack = this.f9069c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(a2);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/a$b.class */
    static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a  reason: collision with root package name */
        String f9070a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlCallBack f9071c;
        String d;
        Context e;
        GrsBaseInfo f;
        com.huawei.hms.framework.network.grs.e.a g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f9070a = str;
            this.b = str2;
            this.f9071c = iQueryUrlCallBack;
            this.d = str3;
            this.e = context;
            this.f = grsBaseInfo;
            this.g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.d)) {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f9070a, this.b, StringUtils.anonymizeMessage(this.d));
                this.f9071c.onCallBackSuccess(this.d);
            } else if (!TextUtils.isEmpty(this.d)) {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f9070a, this.b);
                this.f9071c.onCallBackFail(-3);
            } else {
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a2 = com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.f9070a, this.b, true);
                if (a2 == null || a2.isEmpty()) {
                    Logger.e(a.e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f9070a, this.b);
                }
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f9070a, this.b, StringUtils.anonymizeMessage(a2));
                this.f9071c.onCallBackSuccess(a2);
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String j = dVar.j();
            Map<String, String> a2 = a.a(j, this.f9070a);
            if (a2.containsKey(this.b)) {
                String str2 = a.e;
                String str3 = this.f9070a;
                String str4 = this.b;
                Logger.i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(a2.get(str4)));
                iQueryUrlCallBack = this.f9071c;
                str = a2.get(this.b);
            } else if (TextUtils.isEmpty(this.d)) {
                if (!TextUtils.isEmpty(this.d)) {
                    Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f9070a, this.b);
                    this.f9071c.onCallBackFail(-5);
                    return;
                }
                if (!TextUtils.isEmpty(j)) {
                    Logger.e(a.e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f9070a, this.b);
                }
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a3 = com.huawei.hms.framework.network.grs.f.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.f9070a, this.b, true);
                if (a3 == null || a3.isEmpty()) {
                    Logger.e(a.e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f9070a, this.b);
                }
                Logger.i(a.e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f9070a, this.b, StringUtils.anonymizeMessage(a3));
                this.f9071c.onCallBackSuccess(a3);
                return;
            } else {
                String str5 = a.e;
                String str6 = this.f9070a;
                String str7 = this.b;
                Logger.i(str5, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", str6, str7, StringUtils.anonymizeMessage(a2.get(str7)));
                iQueryUrlCallBack = this.f9071c;
                str = this.d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.f9066a = grsBaseInfo;
        this.b = aVar;
        this.f9067c = hVar;
        this.d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a2 = this.b.a(this.f9066a, str, bVar, context);
        if (a2 != null && !a2.isEmpty()) {
            Logger.i(e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return a2;
        }
        Map<String, String> a3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.f9066a).a(context, this.b, this.f9066a, str, false);
        Logger.i(e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return a3 != null ? a3 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e2) {
            Logger.w(e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str) {
        com.huawei.hms.framework.network.grs.g.d a2 = this.f9067c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f9066a, context), str, this.d);
        return a2 == null ? "" : a2.m() ? this.b.a().a(this.f9066a.getGrsParasKey(true, true, context), "") : a2.j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e1, code lost:
        if (r0.isEmpty() != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r9, java.lang.String r10, android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.a.a(java.lang.String, java.lang.String, android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d5, code lost:
        if (r0.isEmpty() != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> a(java.lang.String r10, android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.a.a(java.lang.String, android.content.Context):java.util.Map");
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a2 = a(str, bVar, context);
        if (!bVar.a()) {
            this.f9067c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f9066a, context), new C0257a(str, a2, iQueryUrlsCallBack, context, this.f9066a, this.b), str, this.d);
        } else if (a2.isEmpty()) {
            Logger.i(e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            Logger.i(e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a2).toString()));
            Logger.i(e, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a2).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(a2);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f9067c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f9066a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f9066a, this.b), str, this.d);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
