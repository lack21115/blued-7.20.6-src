package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.d.g;
import cn.com.chinatelecom.account.api.e.f;
import cn.com.chinatelecom.account.api.e.g;
import cn.com.chinatelecom.account.api.e.h;
import cn.com.chinatelecom.account.api.e.j;
import com.sobot.chat.camera.StCameraView;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4053a = a.class.getSimpleName();
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Context f4054c;
    private String d;
    private String e;
    private c f;

    public a(Context context, String str, String str2) {
        this.f4054c = context;
        this.d = str;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Context context, String str, String str2, String str3, CtSetting ctSetting, Network network, String str4, String str5, int i) {
        String b;
        String str6;
        boolean z;
        try {
            long a2 = cn.com.chinatelecom.account.api.e.a.a(context);
            if (i == cn.com.chinatelecom.account.api.a.d) {
                String a3 = h.a();
                b = h.a(context, str, str2, str3, a2, "");
                str6 = a3;
            } else {
                String b2 = h.b();
                b = h.b(context, str, str2, str3, a2, "");
                str6 = b2;
            }
            String str7 = str6;
            if (g.a() != null) {
                str7 = str6.replace(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.e.b.f), g.a());
            }
            JSONObject jSONObject = new JSONObject(b);
            String optString = jSONObject.optString("p");
            String optString2 = jSONObject.optString("k");
            g.a aVar = new g.a();
            aVar.a(str5);
            aVar.a(false, cn.com.chinatelecom.account.api.d.c.a(), cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.e.b.f));
            aVar.b(str4);
            aVar.a(network);
            aVar.a(CtSetting.getConnTimeout(ctSetting));
            aVar.b(CtSetting.getReadTimeout(ctSetting));
            cn.com.chinatelecom.account.api.d.g a4 = aVar.a();
            cn.com.chinatelecom.account.api.d.b bVar = new cn.com.chinatelecom.account.api.d.b(context);
            cn.com.chinatelecom.account.api.d.h a5 = bVar.a(str7, optString, 1, a4);
            cn.com.chinatelecom.account.api.d.h hVar = a5;
            if (a5.d) {
                synchronized (this) {
                    z = this.b;
                }
                hVar = a5;
                if (!z) {
                    hVar = bVar.a(str7, optString, 1, aVar.a(true).a(false, "", "").a());
                    f.a(str4).b(1);
                }
            }
            JSONObject a6 = cn.com.chinatelecom.account.api.e.a.a(context, hVar, optString2, network, true, str4);
            f.b(str4, a6, optString);
            return a6;
        } catch (Throwable th) {
            JSONObject g = j.g();
            cn.com.chinatelecom.account.api.e.e a7 = f.a(str4);
            a7.g("gpm ：" + th.getMessage()).a(80102).e(cn.com.chinatelecom.account.api.a.d.a(j.k));
            CtAuth.warn(f4053a, "GPM Throwable", th);
            return g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, long j, String str3, ResultListener resultListener) {
        f.a(str2).a(i).e(str).b(j).g(str3);
        f.c(str2);
        String a2 = j.a(i, str, str2);
        if (resultListener != null) {
            resultListener.onResult(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final CtSetting ctSetting, final Network network, final ResultListener resultListener, long j, final String str2, final String str3, final int i) {
        new d().a(new e(j) { // from class: cn.com.chinatelecom.account.api.c.a.3
            @Override // cn.com.chinatelecom.account.api.c.e
            public void a() {
                a aVar = a.this;
                JSONObject a2 = aVar.a(aVar.f4054c, a.this.d, a.this.e, str, ctSetting, network, str2, str3, i);
                synchronized (this) {
                    if (!c()) {
                        a(true);
                        d();
                        CtAuth.postResultOnMainThread(str2, a2, resultListener);
                    }
                }
                if (network != null) {
                    a.this.a();
                }
            }

            @Override // cn.com.chinatelecom.account.api.c.e
            public void b() {
                super.b();
                synchronized (a.this) {
                    a.this.b = true;
                }
                synchronized (this) {
                    if (!c()) {
                        a(true);
                        a.this.a(StCameraView.MEDIA_QUALITY_SORRY, cn.com.chinatelecom.account.api.a.d.a(j.f4100a), str2, 0L, "", resultListener);
                    }
                }
                if (network != null) {
                    a.this.a();
                }
            }
        });
    }

    public void a(String str, CtSetting ctSetting, int i, ResultListener resultListener) {
        int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        String a2 = cn.com.chinatelecom.account.api.e.d.a();
        String a3 = cn.com.chinatelecom.account.api.e.d.a(this.f4054c);
        String a4 = cn.com.chinatelecom.account.api.e.a.a(i);
        f.a(a2).a(a3).c(a4).b(cn.com.chinatelecom.account.api.e.g.e(this.f4054c)).f(cn.com.chinatelecom.account.api.e.g.i(this.f4054c));
        a(str, ctSetting, null, resultListener, totalTimeout, a2, a4, i);
    }

    public void b(final String str, final CtSetting ctSetting, final int i, final ResultListener resultListener) {
        final int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        final String a2 = cn.com.chinatelecom.account.api.e.d.a();
        String a3 = cn.com.chinatelecom.account.api.e.d.a(this.f4054c);
        final String a4 = cn.com.chinatelecom.account.api.e.a.a(i);
        f.a(a2).a(a3).c(a4).b("BOTH").f(cn.com.chinatelecom.account.api.e.g.i(this.f4054c));
        if (Build.VERSION.SDK_INT >= 21) {
            c cVar = new c(this.f4054c);
            this.f = cVar;
            cVar.a(new b() { // from class: cn.com.chinatelecom.account.api.c.a.1
                @Override // cn.com.chinatelecom.account.api.c.b
                public void a() {
                    a.this.a();
                    a.this.a(80800, cn.com.chinatelecom.account.api.a.d.a(j.o), a2, 2500L, "", resultListener);
                }

                @Override // cn.com.chinatelecom.account.api.c.b
                public void a(long j) {
                    a.this.a();
                    a.this.a(80801, cn.com.chinatelecom.account.api.a.d.a(j.p), a2, j, "", resultListener);
                }

                @Override // cn.com.chinatelecom.account.api.c.b
                public void a(Network network, long j) {
                    long j2 = totalTimeout - j;
                    if (j2 > 100) {
                        a.this.a(str, ctSetting, network, resultListener, j2, a2, a4, i);
                    } else {
                        a.this.a();
                        CtAuth.postResultOnMainThread(a2, j.c(), resultListener);
                    }
                    f.a(a2).b(j);
                }
            });
            return;
        }
        this.f = new c(this.f4054c);
        String a5 = h.a();
        String str2 = a5;
        if (cn.com.chinatelecom.account.api.e.g.a() != null) {
            str2 = a5.replace(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.e.b.f), cn.com.chinatelecom.account.api.e.g.a());
        }
        this.f.a(new b() { // from class: cn.com.chinatelecom.account.api.c.a.2
            @Override // cn.com.chinatelecom.account.api.c.b
            public void a() {
                a.this.a(80800, cn.com.chinatelecom.account.api.a.d.a(j.o), a2, 2500L, "Switching network timeout (4.x)", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.c.b
            public void a(long j) {
                a.this.a(80801, cn.com.chinatelecom.account.api.a.d.a(j.p), a2, j, "Switching network failed (4.x)", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.c.b
            public void a(Network network, long j) {
                long j2 = totalTimeout - j;
                if (j2 > 100) {
                    a.this.a(str, ctSetting, null, resultListener, j2, a2, a4, i);
                } else {
                    CtAuth.postResultOnMainThread(a2, j.c(), resultListener);
                }
                f.a(a2).b(j);
            }
        }, str2);
    }
}
