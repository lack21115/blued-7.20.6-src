package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/s.class */
public class s {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f22857c = {"url", "app", "cosa", "rp"};

    /* renamed from: a  reason: collision with root package name */
    private Context f22858a;
    private m b;

    public s(Context context, m mVar) {
        this.f22858a = context;
        this.b = mVar;
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.b.d());
            if (d.c(this.f22858a, this.b.d())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }

    public static boolean a(String str) {
        String[] strArr = f22857c;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void b() {
        Intent intent;
        boolean z;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.b.d() + ",and msg.intentUri is " + this.b.n());
            Intent b = d.b(this.f22858a, this.b.d());
            if (this.b.n() != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.b.n(), 0);
                    parseUri.setSelector(null);
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                    boolean booleanValue = d.a(this.f22858a, this.b.d(), parseUri).booleanValue();
                    intent = b;
                    z = booleanValue;
                    if (booleanValue) {
                        intent = parseUri;
                        z = booleanValue;
                    }
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());
                    intent = b;
                    z = false;
                }
            } else {
                intent = b;
                z = false;
                if (this.b.a() != null) {
                    Intent intent2 = new Intent(this.b.a());
                    intent = b;
                    z = false;
                    if (d.a(this.f22858a, this.b.d(), intent2).booleanValue()) {
                        intent = intent2;
                        z = false;
                    }
                }
            }
            if (intent == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intent.setPackage(this.b.d());
            if (z) {
                intent.addFlags(268435456);
            } else {
                intent.setFlags(805437440);
            }
            this.f22858a.startActivity(intent);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() {
        m mVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f22858a == null || (mVar = this.b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(mVar.i())) {
            a();
        } else if ("cosa".equals(this.b.i())) {
            b();
        } else if ("rp".equals(this.b.i())) {
            HMSLog.w("PushSelfShowLog", this.b.i() + " not support rich message.");
        } else if ("url".equals(this.b.i())) {
            HMSLog.w("PushSelfShowLog", this.b.i() + " not support URL.");
        } else {
            HMSLog.d("PushSelfShowLog", this.b.i() + " is not exist in hShowType");
        }
    }
}
