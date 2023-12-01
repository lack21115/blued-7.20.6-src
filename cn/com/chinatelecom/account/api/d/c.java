package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.e.j;
import com.baidu.mobads.sdk.internal.bw;
import java.net.InetAddress;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/d/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4124a = c.class.getSimpleName();
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private static long f4125c = 0;
    private static long d = 1800000;

    public static String a() {
        synchronized (c.class) {
            try {
                if (System.currentTimeMillis() >= f4125c || !cn.com.chinatelecom.account.api.e.d.a(b)) {
                    return null;
                }
                return b;
            } finally {
            }
        }
    }

    public static void a(final Context context) {
        if (b == null && cn.com.chinatelecom.account.api.e.g.a() == null) {
            new cn.com.chinatelecom.account.api.c.d().a(new cn.com.chinatelecom.account.api.c.e() { // from class: cn.com.chinatelecom.account.api.d.c.1
                @Override // cn.com.chinatelecom.account.api.c.e
                public void a() {
                    cn.com.chinatelecom.account.api.e.e a2;
                    String a3;
                    try {
                        String a4 = cn.com.chinatelecom.account.api.e.d.a();
                        cn.com.chinatelecom.account.api.e.f.a(a4).a(cn.com.chinatelecom.account.api.e.d.a(Context.this)).c("dns").b(cn.com.chinatelecom.account.api.e.g.f(Context.this));
                        String a5 = cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.e.b.f);
                        String b2 = c.b(a5, a4, 0);
                        String str = b2;
                        if (TextUtils.isEmpty(b2)) {
                            str = c.b(a5, a4, 1);
                        }
                        synchronized (c.class) {
                            if (TextUtils.isEmpty(str)) {
                                a2 = cn.com.chinatelecom.account.api.e.f.a(a4).a(80011);
                                a3 = cn.com.chinatelecom.account.api.a.d.a(j.q);
                            } else {
                                String unused = c.b = str;
                                long unused2 = c.f4125c = System.currentTimeMillis() + c.d;
                                a2 = cn.com.chinatelecom.account.api.e.f.a(a4).a(0);
                                a3 = bw.o;
                            }
                            a2.e(a3);
                        }
                        cn.com.chinatelecom.account.api.e.f.b(a4);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, int i) {
        StringBuilder sb;
        String str3;
        try {
            cn.com.chinatelecom.account.api.e.f.a(str2).b(i);
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            if (i == 0) {
                sb = new StringBuilder();
                str3 = "first exception: ";
            } else {
                sb = new StringBuilder();
                str3 = "retry exception: ";
            }
            sb.append(str3);
            sb.append(e.getMessage());
            cn.com.chinatelecom.account.api.e.f.a(str2).g(sb.toString());
            return null;
        }
    }
}
