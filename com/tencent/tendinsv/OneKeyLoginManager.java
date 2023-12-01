package com.tencent.tendinsv;

import android.content.Context;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.tencent.tendinsv.c.e;
import com.tencent.tendinsv.listener.AuthenticationExecuteListener;
import com.tencent.tendinsv.listener.GetPhoneInfoListener;
import com.tencent.tendinsv.listener.InitListener;
import com.tencent.tendinsv.listener.LoginAuthListener;
import com.tencent.tendinsv.listener.TencentCaptchaLitener;
import com.tencent.tendinsv.tool.CheckAuthTool;
import com.tencent.tendinsv.tool.d;
import com.tencent.tendinsv.utils.l;
import com.unikuwei.mianmi.account.shield.tencent.UniAccountHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/OneKeyLoginManager.class */
public class OneKeyLoginManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile OneKeyLoginManager f25294a;

    private OneKeyLoginManager() {
    }

    public static OneKeyLoginManager getInstance() {
        if (f25294a == null) {
            synchronized (OneKeyLoginManager.class) {
                try {
                    if (f25294a == null) {
                        f25294a = new OneKeyLoginManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25294a;
    }

    public void checkProcessesEnable(boolean z) {
        e.a().a(z);
    }

    public void clearScripCache(Context context) {
        e.a().a(context);
    }

    public int currentSimCounts(Context context) {
        return new CheckAuthTool().currentSimCounts(context);
    }

    public void getIEnable(boolean z) {
        e.a().c(z);
    }

    public void getImEnable(boolean z) {
        e.a().e(z);
    }

    public void getOaidEnable(boolean z) {
        e.a().d(z);
    }

    public String getOperatorType(Context context) {
        l.a(b.H, "getOperatorType");
        return d.a().a(context);
    }

    public void getPhoneInfo(GetPhoneInfoListener getPhoneInfoListener) {
        e.a().a(getPhoneInfoListener);
    }

    public boolean getPreIntStatus() {
        return e.a().b();
    }

    public void init(Context context, String str, InitListener initListener) {
        e.a().a(0, context.getApplicationContext(), str, initListener);
    }

    public void loginAuth(LoginAuthListener loginAuthListener) {
        e.a().a(loginAuthListener);
    }

    public void sdkInit(Context context, String str, InitListener initListener) {
        e.a().a(1, context.getApplicationContext(), str, initListener);
    }

    public void setActivityLifecycleCallbacksEnable(boolean z) {
        e.a().b(z);
    }

    public void setDebug(boolean z) {
        b.D = z;
        SDKManager.setDebug(z);
        GenAuthnHelper.setDebugMode(z);
        UniAccountHelper.getInstance().setLogEnable(z);
    }

    public void setFullReport(boolean z) {
        l.a(b.H, "setFullReport", Boolean.valueOf(z));
        b.av = z;
    }

    @Deprecated
    public void setInitDebug(boolean z) {
        b.E = z;
    }

    public void setTimeOutForPreLogin(int i) {
        l.a(b.H, "timeOutForPreLogin", Integer.valueOf(i));
        b.ai = i;
    }

    public void startAuthentication(AuthenticationExecuteListener authenticationExecuteListener) {
        e.a().a(authenticationExecuteListener);
    }

    public void startCaptcha(Context context, String str, String str2, TencentCaptchaLitener tencentCaptchaLitener) {
        e.a().a(context, str, str2, tencentCaptchaLitener);
    }
}
