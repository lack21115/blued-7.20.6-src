package com.unikuwei.mianmi.account.shield.tencent;

import android.content.Context;
import android.text.TextUtils;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.unikuwei.mianmi.account.shield.tencent.c.c;
import com.unikuwei.mianmi.account.shield.tencent.e.a;
import com.unikuwei.mianmi.account.shield.tencent.e.g;
import com.unikuwei.mianmi.account.shield.tencent.e.h;
import com.unikuwei.mianmi.account.shield.tencent.e.j;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/UniAccountHelper.class */
public class UniAccountHelper {
    private static volatile UniAccountHelper s_instance;
    private Context mContext;

    private UniAccountHelper() {
    }

    public static UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (UniAccountHelper.class) {
                try {
                    if (s_instance == null) {
                        s_instance = new UniAccountHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return s_instance;
    }

    private void initFail(ResultListener resultListener, String str) {
        g.b(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, 1);
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_MSG, str);
            jSONObject.put(ProcessBridgeProvider.KEY_RESULT_DATA, "");
            jSONObject.put("traceId", "");
            jSONObject.put("operatorType", "CU");
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public String getSdkVersion() {
        return c.b();
    }

    public boolean init(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            g.b("初始化参数不能为空");
            return false;
        } else if (this.mContext != null) {
            g.b("重复初始化");
            return true;
        } else {
            this.mContext = context.getApplicationContext();
            h.a(str);
            h.b(str2);
            c.a().a(this.mContext, str, str2);
            h.f(j.b(this.mContext));
            h.g(a.a(this.mContext));
            return true;
        }
    }

    public void login(int i, ResultListener resultListener) {
        if (this.mContext == null || TextUtils.isEmpty(h.a()) || TextUtils.isEmpty(h.b())) {
            initFail(resultListener, "sdk未初始化");
            return;
        }
        h.a(i);
        c.a().a(this.mContext, i, 1, resultListener);
    }

    public void mobileAuth(int i, ResultListener resultListener) {
        if (this.mContext == null || TextUtils.isEmpty(h.a()) || TextUtils.isEmpty(h.b())) {
            initFail(resultListener, "sdk未初始化");
            return;
        }
        h.a(i);
        c.a().a(this.mContext, i, 2, resultListener);
    }

    public void releaseNetwork() {
        com.unikuwei.mianmi.account.shield.tencent.e.c.a().b();
    }

    public void setLogEnable(boolean z) {
        c.a().a(z);
    }
}
