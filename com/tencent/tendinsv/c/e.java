package com.tencent.tendinsv.c;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.sdk.tencent.base.api.ToolUtils;
import com.tencent.tendinsv.b.i;
import com.tencent.tendinsv.listener.AuthenticationExecuteListener;
import com.tencent.tendinsv.listener.GetPhoneInfoListener;
import com.tencent.tendinsv.listener.InitListener;
import com.tencent.tendinsv.listener.LoginAuthListener;
import com.tencent.tendinsv.listener.TencentCaptchaLitener;
import com.tencent.tendinsv.tool.g;
import com.tencent.tendinsv.tool.h;
import com.tencent.tendinsv.tool.j;
import com.tencent.tendinsv.utils.k;
import com.tencent.tendinsv.utils.l;
import com.tencent.tendinsv.utils.t;
import com.tencent.tendinsv.view.CaptchaActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f39017a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f39018c;
    private ExecutorService d;
    private volatile ArrayList<InitListener> e = new ArrayList<>();
    private volatile ArrayList<GetPhoneInfoListener> f = new ArrayList<>();
    private volatile ArrayList<LoginAuthListener> g = new ArrayList<>();
    private volatile ArrayList<AuthenticationExecuteListener> h = new ArrayList<>();
    private int i = 0;
    private TencentCaptchaLitener j;

    private e() {
    }

    public static e a() {
        if (f39017a == null) {
            synchronized (e.class) {
                try {
                    if (f39017a == null) {
                        f39017a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39017a;
    }

    private void b(final Context context) {
        try {
            if (this.d == null || this.d.isShutdown()) {
                this.d = new ThreadPoolExecutor(8, Integer.MAX_VALUE, 120L, TimeUnit.SECONDS, new LinkedBlockingDeque());
            }
            this.d.execute(new Runnable() { // from class: com.tencent.tendinsv.c.e.6
                @Override // java.lang.Runnable
                public void run() {
                    String b = t.b(context, t.V, (String) null);
                    if (com.tencent.tendinsv.b.o && com.tencent.tendinsv.utils.d.a(b)) {
                        i.a().a(context);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final int i, final int i2, final String str, final String str2, final String str3, final int i3, final int i4, final int i5, final long j, final long j2, final long j3) {
        com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.c.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = e.this.e.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        InitListener initListener = (InitListener) it.next();
                        e.this.i = e.this.e.size();
                        l.a(com.tencent.tendinsv.b.H, "initCallBack--code=", Integer.valueOf(i), "__processName==", Integer.valueOf(i3), "__result==", str, "__operator=", str3);
                        initListener.getInitStatus(i, str);
                        if (e.this.e.size() > 1) {
                            z = true;
                        }
                        g.a().a(i, i2, str, str2, str3, i3, i4, i5, j, j2, j3, z, 1);
                    }
                    e.this.e.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    l.d(com.tencent.tendinsv.b.H, "initCallBack--Exception=", e);
                }
            }
        });
    }

    public void a(int i, Context context, String str, InitListener initListener) {
        try {
            if (com.tencent.tendinsv.utils.e.a(1, context)) {
                this.b = context;
                com.tencent.tendinsv.b.f38998ar = i;
                this.e.add(initListener);
                l.a(com.tencent.tendinsv.b.H, "initialization_VERSION=", com.tencent.tendinsv.b.ao, "__appId=", str, "__packageSign=", h.b(context), "__packageName=", h.a(context));
                if (this.f39018c == null || this.f39018c.isShutdown()) {
                    this.f39018c = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 120L, TimeUnit.SECONDS, new LinkedBlockingDeque());
                }
                b(context);
                j.a().a(context, str, this.f39018c);
                j.a().b();
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "initialization--Exception_e=", e);
        }
    }

    public void a(final int i, final String str) {
        l.a(com.tencent.tendinsv.b.H, "__code==" + i + "__result==" + str + "tl==" + this.j);
        if (this.j != null) {
            com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.j != null) {
                        e.this.j.getCaptchaCallBacks(i, str);
                        e.this.j = null;
                    }
                }
            });
        }
    }

    public void a(Context context) {
        try {
            GenAuthnHelper.getInstance(context).delScrip();
            ToolUtils.clearCache(context);
            t.a(context, t.U, false);
            t.a(context, "number", "");
            t.a(context, "telecom", "");
            t.a(context, t.e, 0L);
            com.tencent.tendinsv.b.W.set(com.tencent.tendinsv.b.S);
            t.a(context, com.tencent.tendinsv.b.w, "");
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.H, "clearScripCache--Exception=", e);
        }
    }

    public void a(Context context, String str, String str2, TencentCaptchaLitener tencentCaptchaLitener) {
        try {
            l.a(com.tencent.tendinsv.b.H, "__startCaptcha==" + str + "__customContent==" + str2);
            this.j = tencentCaptchaLitener;
            Intent intent = new Intent(context, CaptchaActivity.class);
            intent.putExtra("captchaId", str);
            intent.putExtra("customContent", str2);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "startCaptcha--Exception_e=" + e.toString());
            tencentCaptchaLitener.getCaptchaCallBacks(1014, com.tencent.tendinsv.utils.d.a("2", "", str, str2, ""));
        }
    }

    public void a(AuthenticationExecuteListener authenticationExecuteListener) {
        try {
            if (com.tencent.tendinsv.utils.e.a(11, this.b)) {
                this.h.add(authenticationExecuteListener);
                com.tencent.tendinsv.tool.c.a().a(11, System.currentTimeMillis(), SystemClock.uptimeMillis(), SystemClock.uptimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "startAuthentication--Exception_e=", e);
        }
    }

    public void a(GetPhoneInfoListener getPhoneInfoListener) {
        try {
            if (com.tencent.tendinsv.utils.e.a(2, this.b)) {
                this.f.add(getPhoneInfoListener);
                com.tencent.tendinsv.tool.l.a().a(2, (String) null, System.currentTimeMillis(), SystemClock.uptimeMillis(), SystemClock.uptimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getPhoneInfo--Exception_e=", e);
        }
    }

    public void a(LoginAuthListener loginAuthListener) {
        try {
            if (com.tencent.tendinsv.utils.e.a(4, this.b)) {
                this.g.add(loginAuthListener);
                com.tencent.tendinsv.tool.i.a().a(4, System.currentTimeMillis(), SystemClock.uptimeMillis(), SystemClock.uptimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "loginAuth--Exception_e=", e);
        }
    }

    public void a(boolean z) {
        l.a(com.tencent.tendinsv.b.H, "checkProcessesEnable", Boolean.valueOf(z));
        com.tencent.tendinsv.b.aA = z;
    }

    public void b(final int i, final int i2, final String str, final String str2, final String str3, final int i3, final int i4, final int i5, final long j, final long j2, final long j3) {
        com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.c.e.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = e.this.f.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        l.a(com.tencent.tendinsv.b.H, "getPhoneInfoCallBack--code=", Integer.valueOf(i), "__processName==", Integer.valueOf(i3), "__result==", str, "__operator=", str3, "__isAdd==", Boolean.valueOf(z));
                        ((GetPhoneInfoListener) it.next()).getPhoneInfoStatus(i, str);
                        if (e.this.f.size() > 1) {
                            z = true;
                        }
                        g.a().a(i, i2, str, str2, str3, i3, i4, i5, j, j2, j3, z, 1);
                    }
                    e.this.f.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    l.d(com.tencent.tendinsv.b.H, "getPhoneInfoCallBack--Exception=", e);
                }
            }
        });
    }

    public void b(boolean z) {
        l.a(com.tencent.tendinsv.b.H, "setRunningAppProcessesEnable", Boolean.valueOf(z));
        com.tencent.tendinsv.b.aB = z;
    }

    public boolean b() {
        return t.b(this.b, t.U, false);
    }

    public void c(final int i, final int i2, final String str, final String str2, final String str3, final int i3, final int i4, final int i5, final long j, final long j2, final long j3) {
        com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.c.e.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str4 = str;
                    k.a();
                    Iterator it = e.this.g.iterator();
                    while (it.hasNext()) {
                        LoginAuthListener loginAuthListener = (LoginAuthListener) it.next();
                        if (1000 == i) {
                            str4 = com.tencent.tendinsv.b.aw;
                        }
                        l.a(com.tencent.tendinsv.b.H, "getLoginTokenCallBack--code=", Integer.valueOf(i), "__processName==", Integer.valueOf(i3), "__msg==", str, "__operator=", str3);
                        loginAuthListener.getLoginTokenStatus(i, str);
                    }
                    g.a().a(i, i2, str4, str2, str3, i3, i4, i5, j, j2, j3, false, e.this.g.size());
                    e.this.g.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    l.d(com.tencent.tendinsv.b.H, "getLoginTokenCallBack--Exception=", e);
                }
            }
        });
    }

    public void c(boolean z) {
        l.a(com.tencent.tendinsv.b.H, "getIpEnable", Boolean.valueOf(z));
        com.tencent.tendinsv.b.P = z;
    }

    public void d(final int i, final int i2, final String str, final String str2, final String str3, final int i3, final int i4, final int i5, final long j, final long j2, final long j3) {
        com.tencent.tendinsv.utils.e.a(new Runnable() { // from class: com.tencent.tendinsv.c.e.5
            @Override // java.lang.Runnable
            public void run() {
                Exception e;
                String str4;
                Iterator it;
                boolean z;
                String str5 = com.tencent.tendinsv.b.H;
                String str6 = str5;
                try {
                    str4 = str;
                    it = e.this.h.iterator();
                    z = false;
                } catch (Exception e2) {
                    str5 = str6;
                    e = e2;
                }
                while (true) {
                    str6 = str5;
                    if (!it.hasNext()) {
                        e.this.h.clear();
                        return;
                    }
                    AuthenticationExecuteListener authenticationExecuteListener = (AuthenticationExecuteListener) it.next();
                    if (2000 == i) {
                        str4 = com.tencent.tendinsv.b.az;
                    }
                    l.a(str5, "getAuthTokenCallBack--code=", Integer.valueOf(i), "__processName==", Integer.valueOf(i3), "__msg==", str4, "__operator=", str3, "__isAdd==", Boolean.valueOf(z));
                    authenticationExecuteListener.authenticationRespond(i, str);
                    if (e.this.h.size() > 1) {
                        z = true;
                    }
                    try {
                        g.a().a(i, i2, str4, str2, str3, i3, i4, i5, j, j2, j3, z, 1);
                    } catch (Exception e3) {
                        e = e3;
                    }
                    e = e3;
                    e.printStackTrace();
                    l.d(str5, "getAuthTokenCallBack--Exception=", e);
                    return;
                }
            }
        });
    }

    public void d(boolean z) {
        l.a(com.tencent.tendinsv.b.H, "getOaidEnable", Boolean.valueOf(z));
        com.tencent.tendinsv.b.o = z;
    }

    public void e(boolean z) {
        l.a(com.tencent.tendinsv.b.H, "getImeiEnable", Boolean.valueOf(z));
        com.tencent.tendinsv.b.n = z;
    }
}
