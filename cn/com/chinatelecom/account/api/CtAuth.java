package cn.com.chinatelecom.account.api;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.b.b;
import cn.com.chinatelecom.account.api.d.c;
import cn.com.chinatelecom.account.api.e.f;
import cn.com.chinatelecom.account.api.e.g;
import cn.com.chinatelecom.account.api.e.j;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/CtAuth.class */
public class CtAuth {
    private static volatile CtAuth instance;
    public static Context mContext;
    public static TraceLogger mTraceLogger;
    private static final String TAG = CtAuth.class.getSimpleName();
    public static String mAppId = "";
    public static String mAppSecret = "";
    public static boolean isInit = false;
    public static Handler mHandler = new Handler(Looper.getMainLooper());

    public static CtAuth getInstance() {
        if (instance == null) {
            synchronized (CtAuth.class) {
                try {
                    if (instance == null) {
                        instance = new CtAuth();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static void info(String str, String str2) {
        if (mTraceLogger != null) {
            mTraceLogger.info("CT_" + str, str2);
        }
    }

    public static void postResultOnMainThread(final String str, final JSONObject jSONObject, final ResultListener resultListener) {
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (ResultListener.this != null) {
                    try {
                        if (str != null) {
                            jSONObject.put("reqId", str);
                        }
                        ResultListener.this.onResult(jSONObject.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f.c(str);
                }
            }
        });
    }

    public static void warn(String str, String str2, Throwable th) {
        if (mTraceLogger != null) {
            mTraceLogger.warn("CT_" + str, str2, th);
        }
    }

    public Context getContext() {
        return mContext;
    }

    public String getOperatorType() {
        Context context = mContext;
        if (context != null) {
            return g.a(context, false);
        }
        throw new IllegalArgumentException("Please call the init method");
    }

    public void getPreCodeParamsByJs(String str, cn.com.chinatelecom.account.api.b.a aVar) {
        info(TAG, "called getPreCodeParamsByJs()");
        if (aVar == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
            aVar.callbackPreCodeParams(j.e().toString());
        } else {
            new b().a(str, aVar);
        }
    }

    public void init(Context context, String str, String str2, TraceLogger traceLogger) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null!");
        }
        if (str == null) {
            throw new IllegalArgumentException("appId must not be null!");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("appSecret must not be null!");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        mContext = context;
        c.a(mContext);
        mAppId = str;
        mAppSecret = str2;
        mTraceLogger = traceLogger;
    }

    public boolean isMobileDataEnabled() {
        Context context = mContext;
        if (context != null) {
            return g.d(context);
        }
        throw new IllegalArgumentException("Please call the init method");
    }

    @Deprecated
    public void requestPreCode(CtSetting ctSetting, ResultListener resultListener) {
        requestPreLogin(ctSetting, resultListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void requestPreCodeByJs(java.lang.String r6, cn.com.chinatelecom.account.api.b.a r7) {
        /*
            r5 = this;
            java.lang.String r0 = cn.com.chinatelecom.account.api.CtAuth.TAG
            java.lang.String r1 = "called requestPreCodeByJs()"
            info(r0, r1)
            r0 = r7
            if (r0 != 0) goto Ld
            return
        Ld:
            android.content.Context r0 = cn.com.chinatelecom.account.api.CtAuth.mContext
            if (r0 == 0) goto Lc2
            java.lang.String r0 = cn.com.chinatelecom.account.api.CtAuth.mAppId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lc2
            java.lang.String r0 = cn.com.chinatelecom.account.api.CtAuth.mAppSecret
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L28
            goto Lc2
        L28:
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = r8
            if (r0 != 0) goto L6c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5a
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.lang.Exception -> L5a
            r6 = r0
            r0 = r6
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Exception -> L5a
            r9 = r0
            r0 = r6
            java.lang.String r1 = "taskId"
            java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Exception -> L52
            r6 = r0
            goto L69
        L52:
            r10 = move-exception
            r0 = r9
            r6 = r0
            goto L5e
        L5a:
            r10 = move-exception
            r0 = 0
            r6 = r0
        L5e:
            r0 = r10
            r0.printStackTrace()
            r0 = r6
            r9 = r0
            r0 = r11
            r6 = r0
        L69:
            goto L6e
        L6c:
            r0 = 0
            r6 = r0
        L6e:
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L85
            org.json.JSONObject r0 = cn.com.chinatelecom.account.api.e.j.f()
            r6 = r0
        L7a:
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.toString()
            r0.callbackPreCode(r1)
            return
        L85:
            android.content.Context r0 = cn.com.chinatelecom.account.api.CtAuth.mContext
            boolean r0 = cn.com.chinatelecom.account.api.e.g.c(r0)
            if (r0 == 0) goto L9d
            cn.com.chinatelecom.account.api.b.b r0 = new cn.com.chinatelecom.account.api.b.b
            r1 = r0
            r1.<init>()
            r1 = r6
            r2 = r9
            r3 = r7
            r0.a(r1, r2, r3)
            return
        L9d:
            android.content.Context r0 = cn.com.chinatelecom.account.api.CtAuth.mContext
            boolean r0 = cn.com.chinatelecom.account.api.e.g.d(r0)
            if (r0 == 0) goto Lb5
            cn.com.chinatelecom.account.api.b.b r0 = new cn.com.chinatelecom.account.api.b.b
            r1 = r0
            r1.<init>()
            r1 = r6
            r2 = r9
            r3 = r7
            r0.b(r1, r2, r3)
            return
        Lb5:
            r0 = r7
            org.json.JSONObject r1 = cn.com.chinatelecom.account.api.e.j.d()
            java.lang.String r1 = r1.toString()
            r0.callbackPreCode(r1)
            return
        Lc2:
            org.json.JSONObject r0 = cn.com.chinatelecom.account.api.e.j.e()
            r6 = r0
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.api.CtAuth.requestPreCodeByJs(java.lang.String, cn.com.chinatelecom.account.api.b.a):void");
    }

    public void requestPreLogin(CtSetting ctSetting, int i, ResultListener resultListener) {
        JSONObject e;
        info(TAG, "called requestPreLogin()");
        if (resultListener == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
            e = j.e();
        } else if (g.b(mContext)) {
            if (g.c(mContext)) {
                new cn.com.chinatelecom.account.api.c.a(mContext, mAppId, mAppSecret).a(d.a(cn.com.chinatelecom.account.api.e.b.e), ctSetting, i, resultListener);
                return;
            } else if (g.d(mContext)) {
                new cn.com.chinatelecom.account.api.c.a(mContext, mAppId, mAppSecret).b(d.a(cn.com.chinatelecom.account.api.e.b.e), ctSetting, i, resultListener);
                return;
            } else {
                postResultOnMainThread(null, j.d(), resultListener);
                return;
            }
        } else {
            e = j.a();
        }
        postResultOnMainThread(null, e, resultListener);
    }

    public void requestPreLogin(CtSetting ctSetting, ResultListener resultListener) {
        requestPreLogin(ctSetting, a.d, resultListener);
    }

    public void setDomainName(String str, String str2, String str3) {
        g.f4097a = str;
        g.b = str2;
        g.f4098c = str3;
    }
}
