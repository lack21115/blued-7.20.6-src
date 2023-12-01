package com.opos.acs.st;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.utils.b;
import com.opos.acs.st.utils.c;
import com.opos.acs.st.utils.d;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.g;
import com.opos.acs.st.utils.h;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/STManager.class */
public final class STManager {
    public static final String KEY_AD_ID = "adId";
    public static final String KEY_AD_POS_ID = "adposId";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_CATEGORY_ID = "categoryId";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_DATA_TYPE = "dataType";
    public static final String KEY_DOWN_X = "downX";
    public static final String KEY_DOWN_Y = "downY";
    public static final String KEY_ENTER_ID = "enterId";
    public static final String KEY_EVT_TRACE_ID = "evtTraceId";
    public static final String KEY_EXPOSE_DURATION = "exposeDur";
    public static final String KEY_EXT_CHANNEL = "extChannel";
    public static final String KEY_INSTALL_PKG_NAME = "installPkgName";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_MODULE_ID = "moduleId";
    public static final String KEY_PAR_MODULE_ID = "parModuleId";
    public static final String KEY_PAR_POS_ID = "parPosId";
    public static final String KEY_PAR_TAB_ID = "parTabId";
    public static final String KEY_SCAN_PKG_NAME = "scanPkgName";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_SSO_ID = "ssoid";
    public static final String KEY_TAB_ID = "tabId";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String KEY_UP_X = "upX";
    public static final String KEY_UP_Y = "upY";
    public static final int NO_NEED_UPLOAD = 3;
    public static final int PARAM_ERROR = 4;
    public static final String REGION_OF_CN = "CN";
    public static final String REGION_OF_ID = "ID";
    public static final String REGION_OF_IN = "IN";
    public static final String REGION_OF_MY = "MY";
    public static final String REGION_OF_PH = "PH";
    public static final String REGION_OF_TH = "TH";
    public static final String REGION_OF_TW = "TW";
    public static final String REGION_OF_VN = "VN";
    public static final int REPORT_FINISH = 7;
    public static final int REPORT_NO_STCONFIG = 6;
    private static final long REPORT_TIME_OUT = 1000;
    public static final int SAVED_ON_DB = 5;
    private static final String TAG = "STManager";
    public static final int UPLOAD_FAILURE = 2;
    public static final int UPLOAD_OK = 1;
    private static volatile STManager sInstance;
    private Context mContext = null;
    private static final byte[] LOCK = new byte[0];
    public static final String BRAND_OF_O = b.f24458a;
    public static final String BRAND_OF_P = b.b;
    public static final String BRAND_OF_R = b.f24459c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/STManager$EventListener.class */
    public interface EventListener {
        void onEventReturn(int i);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/STManager$ExitListener.class */
    public interface ExitListener {
        void onFinish(boolean z);
    }

    private void checkInit(Context context) throws Exception {
        if (h.f(context)) {
            throw new Exception("Please init st sdk at first!");
        }
    }

    private Context getContext(Context context) {
        Context context2 = this.mContext;
        if (context2 != null) {
            return context2;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static STManager getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new STManager();
                }
            }
        }
        return sInstance;
    }

    public static String getSdkVersion() {
        return "3.3.0";
    }

    public static boolean isReleaseServer() {
        return com.opos.acs.st.utils.a.f24457a;
    }

    public static Map<String, String> jsonObject2Map(JSONObject jSONObject) {
        if (jSONObject != null) {
            return com.opos.acs.st.b.a.a(jSONObject);
        }
        return null;
    }

    public static Map<String, String> jsonString2Map(String str) {
        if (h.a(str)) {
            return null;
        }
        return com.opos.acs.st.b.a.a(str.trim());
    }

    public static void setLogBuriedPointSwitch(boolean z) {
        com.opos.cmn.an.f.a.a(z);
    }

    public static void setTouristModeSwitch(Context context, boolean z) {
        com.opos.cmn.an.f.a.a(context, z);
    }

    public final void enableDebugLog() {
        if (d.f24462a) {
            return;
        }
        d.f24462a = true;
        d.a();
    }

    public final int getSdkVerCode() {
        return 330;
    }

    public final void init(Context context, String str, String str2) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().build());
    }

    public final void init(Context context, String str, String str2, InitParams initParams) throws NullPointerException {
        if (!c.b()) {
            c.a();
            if (initParams == null || context == null) {
                throw new NullPointerException("initParams or context is null.");
            }
            this.mContext = context.getApplicationContext();
            if (initParams.getIsLoganInit()) {
                d.a(this.mContext);
            }
            d.a(TAG, "init start.");
            if (!EncryptUtils.isSoEnabled()) {
                d.b(TAG, "Init failed,miss so lib！");
                if (h.e(context)) {
                    throw new IllegalStateException("Init failed,miss so lib!");
                }
            }
            c.a(initParams.getIsTablet());
            c.b(this.mContext, str);
            c.a(this.mContext, str2);
            c.c(this.mContext);
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.b("lshxjtu", "init startReportTimer now!!!");
                    h.g(STManager.this.mContext);
                    e.a(STManager.this.mContext).a();
                }
            });
        }
        if (!com.opos.cmn.an.h.c.a.d(this.mContext)) {
            d.a(TAG, "no net!");
        } else if (TextUtils.isEmpty(initParams.getPkgName())) {
            g.a(this.mContext);
        } else {
            g.a(this.mContext, initParams.getPkgName());
        }
    }

    public final void init(Context context, String str, String str2, String str3) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().setPkgName(str3).build());
    }

    public final String onEvent(Context context, String str, Map<String, String> map) throws Exception {
        return onEvent(context, str, map, (EventListener) null);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener) throws Exception {
        checkInit(context);
        if (h.a(str) || map == null) {
            d.a(TAG, "jsonString is null or eventMap is null.");
        } else {
            d.a(TAG, str);
            Map<String, String> a2 = com.opos.acs.st.b.a.a(str.trim());
            if (a2 != null) {
                try {
                    map.putAll(a2);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d(TAG, "onEvent", e);
                }
            }
        }
        return onEvent(context, map, eventListener);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener, String str2, String str3) throws Exception {
        checkInit(context);
        if (h.a(str) || map == null) {
            d.a(TAG, "jsonString is null or eventMap is null.");
        } else {
            d.a(TAG, str);
            Map<String, String> a2 = com.opos.acs.st.b.a.a(str.trim());
            if (a2 != null) {
                try {
                    map.putAll(a2);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d(TAG, "onEvent", e);
                }
            }
        }
        return onEvent(context, map, eventListener, str2, str3);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, String str2, String str3) throws Exception {
        return onEvent(context, str, map, null, str2, str3);
    }

    public final String onEvent(Context context, Map<String, String> map) throws Exception {
        return onEvent(context, map, (EventListener) null);
    }

    public final String onEvent(Context context, Map<String, String> map, EventListener eventListener) throws Exception {
        return onEvent(context, map, eventListener, (String) null, (String) null);
    }

    public final String onEvent(Context context, final Map<String, String> map, final EventListener eventListener, String str, String str2) throws Exception {
        String str3;
        checkInit(context);
        final Context context2 = getContext(context);
        if (context2 == null || map == null) {
            if (eventListener != null) {
                eventListener.onEventReturn(4);
                return null;
            }
            return null;
        } else if (h.f(context2)) {
            throw new Exception("Please init st sdk at first!");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (map.containsKey("traceId")) {
                str3 = map.get("traceId");
            } else {
                String str4 = h.a(map.get("adId")) ? "0" : map.get("adId");
                String str5 = str;
                if (h.a(str)) {
                    str5 = "0";
                }
                String str6 = str2;
                if (h.a(str2)) {
                    str6 = "0";
                }
                str3 = "0-" + str4 + "-" + currentTimeMillis + "-" + str5 + "-" + str6;
            }
            d.a(TAG, "traceId=".concat(String.valueOf(str3)));
            map.put("evtId", String.valueOf(currentTimeMillis));
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.2
                @Override // java.lang.Runnable
                public final void run() {
                    h.a(context2, map, eventListener);
                    d.a(STManager.TAG, "record data Context is :" + context2);
                }
            });
            return str3;
        }
    }

    public final String onEvent(Context context, Map<String, String> map, String str, String str2) throws Exception {
        return onEvent(context, map, (EventListener) null, str, str2);
    }

    public final void onExit(Context context, final ExitListener exitListener) throws NullPointerException {
        final Context context2 = getContext(context);
        if (context2 == null || exitListener == null) {
            throw new NullPointerException("context or exitListener is null.");
        }
        new Thread(new Runnable() { // from class: com.opos.acs.st.STManager.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    STManager.this.reportDataOnExit(context2);
                    h.a();
                    exitListener.onFinish(true);
                } catch (Throwable th) {
                    h.a();
                    exitListener.onFinish(true);
                    throw th;
                }
            }
        }).start();
    }

    public final void pause(Context context) {
        final Context context2 = getContext(context);
        if (context2 != null) {
            new Thread(new Runnable() { // from class: com.opos.acs.st.STManager.5
                @Override // java.lang.Runnable
                public final void run() {
                    STManager.this.reportDataOnExit(context2);
                    h.a();
                }
            }).start();
        }
    }

    public final void reportDataOnExit(Context context) {
        Context context2 = getContext(context);
        if (context2 != null) {
            if (!com.opos.cmn.an.h.c.a.d(context2)) {
                d.a(TAG, "has no net,do nothing and  application exit.");
                return;
            }
            d.a(TAG, "has net,report all data before application exit.");
            h.b(context2);
        }
    }

    public final void resume(Context context) {
        final Context context2 = getContext(context);
        if (context2 != null) {
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.4
                @Override // java.lang.Runnable
                public final void run() {
                    d.b("lshxjtu", "resume startReportTimer now!!!");
                    h.c(context2);
                }
            });
        }
    }
}
