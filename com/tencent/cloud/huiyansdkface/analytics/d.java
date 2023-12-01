package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.push.AttributionReporter;
import com.tencent.cloud.huiyansdkface.analytics.EventSender;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/d.class */
public class d {
    String i;
    private int j;
    private String k;
    private String l;
    private float m;
    private String n;
    private String o;
    private volatile Handler t;

    /* renamed from: a  reason: collision with root package name */
    static final String f35503a = d.class.getSimpleName();
    private static String q = "subAppId";

    /* renamed from: c  reason: collision with root package name */
    static String f35504c = "ecifNo";
    static String d = "unionId";
    static String e = "openId";
    private static String r = AttributionReporter.APP_VERSION;
    static String f = "filedY0";
    static Context g = null;
    WBSAParam b = new WBSAParam();
    private a p = new a();
    private volatile boolean s = false;
    volatile boolean h = true;

    private static Context a(Context context) {
        if (context != null) {
            Context context2 = context;
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            }
            return context2;
        }
        return g;
    }

    static /* synthetic */ void a(d dVar, Context context) {
        dVar.b.setAppBundleId(c.a(context));
        dVar.b.setWaName("WBSimpleAnalytics SDK");
        dVar.b.setWaVersion("v1.2.18");
    }

    static /* synthetic */ void a(d dVar, WBSAEvent wBSAEvent, final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wBSAEvent);
        final b a2 = b.a();
        final WBSAParam wBSAParam = dVar.b;
        EventSender.requestExec(a2.f35496a, wBSAParam, str, arrayList, new WeReq.Callback<EventSender.sendEventResponse>() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.2
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str2, IOException iOException) {
                WBSLogger.d("ReportWBAEvents", "WBCF onFailed:" + errType + "," + i + "," + str2, new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onFinish() {
                WBSLogger.d("ReportWBAEvents", "onFinish", new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onStart(WeReq weReq) {
                WBSLogger.d("ReportWBAEvents", "onStart", new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final /* synthetic */ void onSuccess(WeReq weReq, Object obj) {
                EventSender.sendEventResponse sendeventresponse = (EventSender.sendEventResponse) obj;
                if (sendeventresponse != null) {
                    String str2 = sendeventresponse.code;
                    if ("10000".equals(str2)) {
                        return;
                    }
                    WBSLogger.w("ReportWBAEvents", "onSuccess requestFailExec errorCode" + sendeventresponse.code, new Object[0]);
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    EventSender.RequestFailParam requestFailParam = new EventSender.RequestFailParam();
                    requestFailParam.errorCode = str2;
                    requestFailParam.errorMsg = sendeventresponse.msg;
                    requestFailParam.subAppId = wBSAParam.app_id;
                    requestFailParam.account = wBSAParam.sub_app_id;
                    requestFailParam.createTime = System.currentTimeMillis();
                    requestFailParam.appVersion = wBSAParam.app_version;
                    requestFailParam.waVersion = wBSAParam.getWaVersion();
                    requestFailParam.deviceId = wBSAParam.wba_device_id;
                    requestFailParam.deviceInfo = wBSAParam.getAppBundleId() + "|" + wBSAParam.getWaName() + "|" + wBSAParam.getMetricsDevice() + "|" + wBSAParam.getMetricsOsVersion();
                    WBSLogger.w("ReportWBAEvents", "requestFailExec paramJson".concat(String.valueOf(new WeJson().toJson(requestFailParam))), new Object[0]);
                    String[] split = str.split("/rcrm-codcs/");
                    if (split != null) {
                        String str3 = split[0];
                        WBSLogger.w("ReportWBAEvents", "requestFailExec baseUrl=" + str3 + "/rcrm-codcs/fail-msg", new Object[0]);
                        WeOkHttp weOkHttp = a2.f35496a;
                        EventSender.requestFailExec(weOkHttp, requestFailParam, str3 + "/rcrm-codcs/fail-msg", new BaseCallback<EventSender.sendEventResponse>() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.2.1
                            {
                                AnonymousClass2.this = this;
                            }

                            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                            public final void onFailed(WeReq weReq2, WeReq.ErrType errType, int i, String str4, IOException iOException) {
                                WBSLogger.e("ReportWBAEvents", "requestFailExec onFailed msg=".concat(String.valueOf(str4)), new Object[0]);
                            }

                            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                            public final /* synthetic */ void onSuccess(WeReq weReq2, Object obj2) {
                                EventSender.sendEventResponse sendeventresponse2 = (EventSender.sendEventResponse) obj2;
                                if (sendeventresponse2 != null) {
                                    WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess code" + sendeventresponse2.code, new Object[0]);
                                    WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess msg" + sendeventresponse2.msg, new Object[0]);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private Handler b(Context context) {
        if (this.t == null) {
            synchronized (d.class) {
                try {
                    if (this.t == null) {
                        c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            WBSLogger.d(f35503a, "initWBASdk null == eventHandler", new Object[0]);
        }
        return this.t;
    }

    static /* synthetic */ void b(d dVar, Context context) {
        dVar.b.setMetricsOs("Android");
        dVar.j = Build.VERSION.SDK_INT;
        dVar.k = Build.MODEL;
        int i = c.c(context).widthPixels;
        int i2 = c.c(context).heightPixels;
        float f2 = c.c(context).density;
        dVar.l = i + "x" + i2;
        dVar.m = f2;
        dVar.n = c.d(context);
        dVar.o = c.a();
    }

    private void c(final Context context) {
        synchronized (this) {
            WBSLogger.d(f35503a, "initWBASdk WBAService!", new Object[0]);
            if (this.t != null) {
                WBSLogger.e(f35503a, "initWBASdk already has eventHandler,return!", new Object[0]);
                return;
            }
            this.p.a();
            if (context != null) {
                if (context.getApplicationContext() != null) {
                    g = context.getApplicationContext();
                } else {
                    g = context;
                }
            }
            final Context a2 = a(context);
            HandlerThread handlerThread = new HandlerThread("WBAService");
            handlerThread.start();
            this.t = new Handler(handlerThread.getLooper());
            this.t.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.analytics.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.a(d.this, a2);
                    d.b(d.this, a2);
                    b.a();
                    WBSLogger.d(d.f35503a, "initWBASdk Init WBAService success!", new Object[0]);
                    Properties properties = new Properties();
                    properties.put("metrics_device", d.this.k);
                    properties.put("metrics_os_version", Integer.valueOf(d.this.j));
                    properties.put("metrics_locale", d.this.n);
                    properties.put("metrics_density", Float.valueOf(d.this.m));
                    properties.put("metrics_resolution", d.this.l);
                    properties.put("timezone", d.this.o);
                    d.this.a(context, "autotrack", "device_info", properties, false);
                }
            });
        }
    }

    public final void a(Context context, final String str, final String str2, final Properties properties, final boolean z) {
        if (this.h) {
            Context a2 = a(context);
            if (a2 == null) {
                WBSLogger.e(f35503a, "The Context of StatService.trackCustomKVEvent() can not be null!", new Object[0]);
                return;
            }
            if (!this.s) {
                WBSLogger.w(f35503a, "sdk未初始化，调用了trackCustomKVEvent", new Object[0]);
                SharedPreferences sharedPreferences = a2.getSharedPreferences(this.b.getAppId(), 0);
                if (sharedPreferences == null) {
                    WBSLogger.e(f35503a, "hasInit false,wbwaconfig null", new Object[0]);
                    return;
                }
                String string = sharedPreferences.getString(q, null);
                if (TextUtils.isEmpty(string)) {
                    WBSLogger.e(f35503a, "hasInit false,wbwaconfig subAppId  null", new Object[0]);
                    return;
                }
                WBSLogger.w(f35503a, "hasInit false,wbwaconfig true", new Object[0]);
                String string2 = sharedPreferences.getString(f35504c, null);
                String string3 = sharedPreferences.getString(d, null);
                String string4 = sharedPreferences.getString(e, null);
                String string5 = sharedPreferences.getString(r, null);
                String string6 = sharedPreferences.getString(f, null);
                this.b.setSubAppId(string);
                this.b.setEcifNo(string2);
                this.b.setUnionId(string3);
                this.b.setOpenId(string4);
                this.b.setAppVersion(string5);
                this.b.setField_y_0(string6);
                this.s = true;
            }
            if (c.a(str, str2, properties)) {
                WBSLogger.e(f35503a, "The length of event_id/properties for StatService.trackCustomKVEvent() exceeds the limit:61440", new Object[0]);
            }
            if (b(a2) != null) {
                this.t.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.analytics.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            d.a(d.this, WBSAEvent.customEvent(str, str2, properties, Boolean.valueOf(z), d.this.p), d.this.i);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            WBSLogger.e(d.f35503a, th.getMessage(), new Object[0]);
                        }
                    }
                });
            }
        }
    }

    public final boolean a(Context context, WBSimpleStartParam wBSimpleStartParam) {
        WBSAParam wBSAParam;
        String b;
        try {
            if (!wBSimpleStartParam.isEnableService()) {
                WBSLogger.e(f35503a, "WBAService is disable.", new Object[0]);
                this.h = false;
                return false;
            } else if (context != null) {
                if (TextUtils.isEmpty(wBSimpleStartParam.getAppId())) {
                    throw new WBSASDKException("valid appId is required, but was provided either 'null' or empty String");
                }
                if (TextUtils.isEmpty(wBSimpleStartParam.getSubAppId())) {
                    throw new WBSASDKException("valid subAppId is required, but was provided either 'null' or empty String");
                }
                if (TextUtils.isEmpty(wBSimpleStartParam.getBaseUrl())) {
                    throw new WBSASDKException("valid baseUrl is required, but was provided either 'null' or empty String");
                }
                String appId = wBSimpleStartParam.getAppId();
                String subAppId = wBSimpleStartParam.getSubAppId();
                this.i = wBSimpleStartParam.getBaseUrl();
                String ecifNo = wBSimpleStartParam.getEcifNo();
                String unionId = wBSimpleStartParam.getUnionId();
                String openId = wBSimpleStartParam.getOpenId();
                String customFiled = wBSimpleStartParam.getCustomFiled();
                this.b.setAppId(appId);
                this.b.setSubAppId(subAppId);
                this.b.setEcifNo(ecifNo);
                this.b.setUnionId(unionId);
                this.b.setOpenId(openId);
                this.b.setField_y_0(customFiled);
                if (TextUtils.isEmpty(wBSimpleStartParam.getAppVersion())) {
                    wBSAParam = this.b;
                    b = c.b(context);
                } else {
                    wBSAParam = this.b;
                    b = wBSimpleStartParam.getAppVersion();
                }
                wBSAParam.setAppVersion(b);
                SharedPreferences.Editor edit = context.getSharedPreferences(this.b.getAppId(), 0).edit();
                edit.putString(q, subAppId);
                edit.putString(f35504c, ecifNo);
                edit.putString(d, unionId);
                edit.putString(e, openId);
                edit.putString(r, this.b.getAppVersion());
                edit.putString(f, customFiled);
                edit.commit();
                if (wBSimpleStartParam.isLogEnable()) {
                    WBSLogger.setLogLevel(3);
                } else {
                    WBSLogger.setLogLevel(7);
                }
                if (b(context) != null) {
                    this.s = true;
                    this.h = true;
                    return true;
                }
                WBSLogger.e(f35503a, "Context or sdkVersion in StatService.startStatService() is null, please check it!", new Object[0]);
                this.h = false;
                return false;
            } else {
                throw new WBSASDKException("context must not be null");
            }
        } catch (Throwable th) {
            WBSLogger.e(f35503a, th.getMessage(), new Object[0]);
            this.h = false;
            return false;
        }
    }
}
