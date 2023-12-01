package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.c.c;
import cn.com.chinatelecom.account.api.d.g;
import cn.com.chinatelecom.account.api.e.e;
import cn.com.chinatelecom.account.api.e.f;
import cn.com.chinatelecom.account.api.e.j;
import com.sobot.chat.camera.StCameraView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/b/b.class */
public class b {
    private c g;
    private static final String f = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4093a = {122, 99, 122, 102};
    public static final byte[] b = {44, 104, 120, 99, 109, 75, 122, 122, 55};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f4094c = {44, 121, 126, 55};
    public static final byte[] d = {44, 104, 126, 55};
    public static final byte[] e = {44, 107, Byte.MAX_VALUE, 126, 98, 94, 115, 122, 111, 55};

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Context context, String str, String str2, Network network, String str3, String str4) {
        try {
            g.a aVar = new g.a();
            aVar.a(str4);
            aVar.a(false, cn.com.chinatelecom.account.api.d.c.a(), d.a(cn.com.chinatelecom.account.api.e.b.f));
            aVar.b(str3);
            aVar.a(network);
            aVar.a(CtSetting.getConnTimeout(null));
            aVar.b(CtSetting.getReadTimeout(null));
            HashMap hashMap = new HashMap();
            hashMap.put(d.a(f4093a), Helper.dnprecohdjs());
            aVar.a(hashMap);
            JSONObject a2 = cn.com.chinatelecom.account.api.e.a.a(context, new cn.com.chinatelecom.account.api.d.b(context).a(str2, "", 0, aVar.a()), str, network, true, str3);
            f.b(str3, a2, str2);
            return a2;
        } catch (Throwable th) {
            JSONObject g = j.g();
            e a3 = f.a(str3);
            a3.g("gpm ：" + th.getMessage()).a(80102).e(d.a(j.k));
            CtAuth.warn(f, "GPM Throwable", th);
            return g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, long j, String str3, a aVar) {
        f.a(str2).a(i).e(str).b(j).g(str3);
        f.c(str2);
        String a2 = j.a(i, str, str2);
        if (aVar != null) {
            aVar.callbackPreCode(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final String str, final String str2, final Network network, long j, final String str3, final String str4, final a aVar) {
        new cn.com.chinatelecom.account.api.c.d().a(new cn.com.chinatelecom.account.api.c.e(j) { // from class: cn.com.chinatelecom.account.api.b.b.3
            @Override // cn.com.chinatelecom.account.api.c.e
            public void a() {
                JSONObject a2 = b.this.a(context, str, str2, network, str3, str4);
                synchronized (this) {
                    if (!c()) {
                        a(true);
                        d();
                        if (aVar != null) {
                            try {
                                a2.put("reqId", str3);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            aVar.callbackPreCode(a2.toString());
                        }
                        f.c(str3);
                    }
                }
                if (network != null) {
                    b.this.a();
                }
            }

            @Override // cn.com.chinatelecom.account.api.c.e
            public void b() {
                super.b();
                synchronized (this) {
                    if (!c()) {
                        a(true);
                        b.this.a((int) StCameraView.MEDIA_QUALITY_SORRY, d.a(j.f4148a), str3, 0L, "", aVar);
                    }
                }
                if (network != null) {
                    b.this.a();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r6, cn.com.chinatelecom.account.api.b.a r7) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.api.b.b.a(java.lang.String, cn.com.chinatelecom.account.api.b.a):void");
    }

    public void a(String str, String str2, a aVar) {
        Context context = CtAuth.getInstance().getContext();
        int totalTimeout = CtSetting.getTotalTimeout(null);
        String a2 = cn.com.chinatelecom.account.api.e.d.a();
        f.a(a2).a(cn.com.chinatelecom.account.api.e.d.a(context)).c("preCodeByJs").b(cn.com.chinatelecom.account.api.e.g.e(context)).f(cn.com.chinatelecom.account.api.e.g.i(context));
        a(context, str, str2, null, totalTimeout, a2, "preCodeByJs", aVar);
    }

    public void b(final String str, final String str2, final a aVar) {
        final Context context = CtAuth.getInstance().getContext();
        final int totalTimeout = CtSetting.getTotalTimeout(null);
        final String a2 = cn.com.chinatelecom.account.api.e.d.a();
        f.a(a2).a(cn.com.chinatelecom.account.api.e.d.a(context)).c("preCodeByJs").b("BOTH").f(cn.com.chinatelecom.account.api.e.g.i(context));
        if (Build.VERSION.SDK_INT >= 21) {
            c cVar = new c(context);
            this.g = cVar;
            cVar.a(new cn.com.chinatelecom.account.api.c.b() { // from class: cn.com.chinatelecom.account.api.b.b.1
                @Override // cn.com.chinatelecom.account.api.c.b
                public void a() {
                    b.this.a();
                    b.this.a(80800, d.a(j.o), a2, 2500L, "", aVar);
                }

                @Override // cn.com.chinatelecom.account.api.c.b
                public void a(long j) {
                    b.this.a();
                    b.this.a(80801, d.a(j.p), a2, j, "", aVar);
                }

                @Override // cn.com.chinatelecom.account.api.c.b
                public void a(Network network, long j) {
                    f.a(a2).b(j);
                    long j2 = totalTimeout - j;
                    if (j2 > 100) {
                        b.this.a(context, str, str2, network, j2, a2, "preCodeByJs", aVar);
                        return;
                    }
                    b.this.a();
                    b.this.a((int) StCameraView.MEDIA_QUALITY_SORRY, d.a(j.f4148a), a2, j, "", aVar);
                }
            });
            return;
        }
        c cVar2 = new c(context);
        this.g = cVar2;
        cVar2.a(new cn.com.chinatelecom.account.api.c.b() { // from class: cn.com.chinatelecom.account.api.b.b.2
            @Override // cn.com.chinatelecom.account.api.c.b
            public void a() {
                b.this.a(80800, d.a(j.o), a2, 2500L, "Switching network timeout (4.x)", aVar);
            }

            @Override // cn.com.chinatelecom.account.api.c.b
            public void a(long j) {
                b.this.a(80801, d.a(j.p), a2, j, "Switching network failed (4.x)", aVar);
            }

            @Override // cn.com.chinatelecom.account.api.c.b
            public void a(Network network, long j) {
                f.a(a2).b(j);
                long j2 = totalTimeout - j;
                if (j2 > 100) {
                    b.this.a(context, str, str2, network, j2, a2, "preCodeByJs", aVar);
                } else {
                    b.this.a((int) StCameraView.MEDIA_QUALITY_SORRY, d.a(j.f4148a), a2, j, "", aVar);
                }
            }
        }, str2);
    }
}
