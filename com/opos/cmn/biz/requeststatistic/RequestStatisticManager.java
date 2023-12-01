package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.pd.ExHandler;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.cmn.biz.a.d;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.a.a;
import com.opos.cmn.biz.requeststatistic.a.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/RequestStatisticManager.class */
public class RequestStatisticManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10977a = RequestStatisticManager.class.getSimpleName();
    private static RequestStatisticManager b;

    /* renamed from: c  reason: collision with root package name */
    private Context f10978c;
    private InitParams d;

    private RequestStatisticManager() {
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || TextUtils.isEmpty(activeNetworkInfo.getTypeName())) ? "" : "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName()) ? activeNetworkInfo.getTypeName() : !TextUtils.isEmpty(activeNetworkInfo.getSubtypeName()) ? activeNetworkInfo.getSubtypeName() : "";
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b(f10977a, "net access fail", e);
                return "";
            }
        }
        return "";
    }

    static /* synthetic */ JSONObject a(RequestStatisticManager requestStatisticManager, StatisticEvent statisticEvent) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chn", statisticEvent.channel);
        jSONObject2.put(ExHandler.JSON_REQUEST_IMEI, "");
        jSONObject2.put("pkg", requestStatisticManager.f10978c.getPackageName());
        jSONObject2.put("svc", TextUtils.isEmpty(statisticEvent.sdkVersion) ? 202 : statisticEvent.sdkVersion);
        jSONObject2.put("evtId", statisticEvent.eventId);
        String str = Build.MODEL;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        jSONObject2.put("model", str2);
        jSONObject2.put(TKDownloadReason.KSAD_TK_NET, a(requestStatisticManager.f10978c));
        boolean a2 = com.opos.cmn.biz.c.b.a.a();
        com.opos.cmn.an.f.a.b("Utils", "isOverseas=".concat(String.valueOf(a2)));
        if (a2) {
            jSONObject2.put("gaId", com.opos.cmn.g.a.b.g(requestStatisticManager.f10978c));
        }
        jSONObject2.put(com.anythink.expressad.foundation.g.a.L, com.opos.cmn.biz.a.b.a(requestStatisticManager.f10978c));
        jSONObject2.put("rn", d.a(requestStatisticManager.f10978c));
        jSONObject2.put("duId", "");
        jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(requestStatisticManager.f10978c));
        jSONObject2.put("guId", "");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(com.anythink.expressad.d.a.b.dx, statisticEvent.currentTime);
        jSONObject3.put("url", statisticEvent.url);
        jSONObject3.put("ret", statisticEvent.ret);
        jSONObject3.put("rt", statisticEvent.resolveTime);
        jSONObject3.put("mt", statisticEvent.maxResolveTime);
        jSONObject3.put("ext", statisticEvent.ext);
        jSONObject.put("h", jSONObject2);
        jSONObject.put("b", jSONObject3);
        return jSONObject;
    }

    private boolean b() {
        return (this.f10978c == null || this.d == null) ? false : true;
    }

    public static RequestStatisticManager getInstance() {
        RequestStatisticManager requestStatisticManager;
        RequestStatisticManager requestStatisticManager2 = b;
        if (requestStatisticManager2 != null) {
            return requestStatisticManager2;
        }
        synchronized (RequestStatisticManager.class) {
            try {
                if (b == null) {
                    b = new RequestStatisticManager();
                }
                requestStatisticManager = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return requestStatisticManager;
    }

    public void init(Context context, InitParams initParams) {
        this.f10978c = context.getApplicationContext();
        final com.opos.cmn.biz.requeststatistic.a.d a2 = com.opos.cmn.biz.requeststatistic.a.d.a();
        if (a2.b == null) {
            a2.b = context;
            a2.f10992c = new com.opos.cmn.biz.requeststatistic.a.b(context);
            a2.e = new com.opos.cmn.biz.requeststatistic.a.a(new a.b() { // from class: com.opos.cmn.biz.requeststatistic.a.d.1
                @Override // com.opos.cmn.biz.requeststatistic.a.a.b
                public final void a(a.InterfaceC0461a interfaceC0461a) {
                    d.a(d.this, interfaceC0461a);
                }
            });
            a2.f = new com.opos.cmn.biz.requeststatistic.a.a(new a.b() { // from class: com.opos.cmn.biz.requeststatistic.a.d.2
                @Override // com.opos.cmn.biz.requeststatistic.a.a.b
                public final void a(a.InterfaceC0461a interfaceC0461a) {
                    d.b(d.this, interfaceC0461a);
                }
            }, 1800000);
        }
        this.d = initParams;
    }

    public void report(final StatisticEvent statisticEvent) {
        com.opos.cmn.an.f.a.b(f10977a, "report:".concat(String.valueOf(statisticEvent)));
        if (!b()) {
            throw new IllegalStateException("had not init yet ");
        }
        if (statisticEvent == null) {
            throw new IllegalArgumentException("event can not be null");
        }
        if (com.opos.cmn.an.f.a.a(this.f10978c)) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject a2 = RequestStatisticManager.a(RequestStatisticManager.this, statisticEvent);
                        String jSONObject = a2.toString();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(a2);
                        String jSONArray2 = jSONArray.toString();
                        com.opos.cmn.an.f.a.b(RequestStatisticManager.f10977a, "send data:".concat(String.valueOf(jSONArray2)));
                        final c cVar = new c(jSONObject, System.currentTimeMillis());
                        com.opos.cmn.biz.requeststatistic.a.d a3 = com.opos.cmn.biz.requeststatistic.a.d.a();
                        String str = com.opos.cmn.biz.requeststatistic.a.d.f10991a;
                        com.opos.cmn.an.f.a.b(str, "add cache with data:" + cVar.b);
                        a3.d.offer(cVar);
                        if (a3.e != null) {
                            a3.e.a();
                        }
                        a.a(RequestStatisticManager.this.f10978c, jSONArray2, new a.InterfaceC0460a() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1.1
                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0460a
                            public void onFail() {
                                com.opos.cmn.an.f.a.b(RequestStatisticManager.f10977a, "report request fail");
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0460a
                            public void onSuccess() {
                                final com.opos.cmn.biz.requeststatistic.a.d a4 = com.opos.cmn.biz.requeststatistic.a.d.a();
                                final c cVar2 = cVar;
                                String str2 = com.opos.cmn.biz.requeststatistic.a.d.f10991a;
                                com.opos.cmn.an.f.a.b(str2, "delete cache with id:" + cVar2.f10989a);
                                if (!a4.d.remove(cVar2)) {
                                    String str3 = com.opos.cmn.biz.requeststatistic.a.d.f10991a;
                                    com.opos.cmn.an.f.a.b(str3, "remove from db:" + cVar2.f10989a);
                                    com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.4
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            d.this.h.writeLock().lock();
                                            try {
                                                try {
                                                    b bVar = d.this.f10992c;
                                                    c cVar3 = cVar2;
                                                    long j = cVar3.f10989a;
                                                    if (j < 0) {
                                                        com.opos.cmn.an.f.a.c(b.f10988a, "delete data by id had not init");
                                                        bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar3.b});
                                                    } else {
                                                        bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j)});
                                                    }
                                                } catch (Exception e) {
                                                    com.opos.cmn.an.f.a.b(d.f10991a, "delete fail", e);
                                                }
                                            } finally {
                                                d.this.h.writeLock().unlock();
                                            }
                                        }
                                    });
                                }
                                com.opos.cmn.biz.requeststatistic.a.d.a().b();
                            }
                        });
                    } catch (JSONException e) {
                        com.opos.cmn.an.f.a.d(RequestStatisticManager.f10977a, "request parse json fail", e);
                    }
                }
            });
        } else {
            com.opos.cmn.an.f.a.b(f10977a, "log buried point switch is closed, cannot upload log buried point");
        }
    }

    public void reportCacheIfNeed() {
        String str;
        String str2;
        if (!b()) {
            str = f10977a;
            str2 = "reportCacheIfNeed, but had not init yet";
        } else if (com.opos.cmn.an.f.a.a(this.f10978c)) {
            com.opos.cmn.biz.requeststatistic.a.d.a().b();
            return;
        } else {
            str = f10977a;
            str2 = "log buried point switch is closed, cannot upload log buried point";
        }
        com.opos.cmn.an.f.a.b(str, str2);
    }
}
