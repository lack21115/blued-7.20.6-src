package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/n.class */
public class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f22852a;
    private m b;

    public n(Context context, m mVar) {
        this.f22852a = context;
        this.b = mVar;
    }

    private static Intent a(Context context, m mVar) {
        Intent intent;
        if (mVar == null) {
            return null;
        }
        Intent b = d.b(context, mVar.d());
        if (mVar.n() != null) {
            try {
                Intent parseUri = Intent.parseUri(mVar.n(), 0);
                parseUri.setSelector(null);
                HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                intent = b;
                if (d.a(context, mVar.d(), parseUri).booleanValue()) {
                    return parseUri;
                }
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
                return b;
            }
        } else {
            intent = b;
            if (mVar.a() != null) {
                Intent intent2 = new Intent(mVar.a());
                intent = b;
                if (d.a(context, mVar.d(), intent2).booleanValue()) {
                    intent = intent2;
                }
            }
            intent.setPackage(mVar.d());
        }
        return intent;
    }

    private boolean a(Context context) {
        return d.c(context, this.b.d());
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.b.i())) {
            return a(context);
        }
        return true;
    }

    private boolean b(Context context, m mVar) {
        if ("cosa".equals(mVar.i()) && a(context, mVar) == null) {
            HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.f22852a) || b(this.f22852a, this.b)) {
                return;
            }
            l.a(this.f22852a, this.b);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }
}
