package com.ta.utdid2.device;

import android.Manifest;
import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/device/c.class */
public class c {

    /* renamed from: a  reason: collision with other field name */
    private com.ta.utdid2.b.a.c f25a;

    /* renamed from: a  reason: collision with other field name */
    private d f26a;
    private com.ta.utdid2.b.a.c b;
    private String i;
    private String j;
    private Context mContext;
    private static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private static c f21217a = null;
    private static final String k = ".UTSystemConfig" + File.separator + "Global";
    private String h = null;

    /* renamed from: b  reason: collision with other field name */
    private Pattern f27b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private c(Context context) {
        this.mContext = null;
        this.f26a = null;
        this.i = "xx_utdid_key";
        this.j = "xx_utdid_domain";
        this.f25a = null;
        this.b = null;
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f25a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f26a = new d();
        this.i = String.format("K_%d", Integer.valueOf(g.a(this.i)));
        this.j = String.format("D_%d", Integer.valueOf(g.a(this.j)));
    }

    public static c a(Context context) {
        if (context != null && f21217a == null) {
            synchronized (e) {
                if (f21217a == null) {
                    c cVar = new c(context);
                    f21217a = cVar;
                    cVar.c();
                }
            }
        }
        return f21217a;
    }

    public static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(f.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
    }

    private boolean b(String str) {
        if (str != null) {
            String str2 = str;
            if (str.endsWith("\n")) {
                str2 = str.substring(0, str.length() - 1);
            }
            return 24 == str2.length() && !this.f27b.matcher(str2).find();
        }
        return false;
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            if (g.m6840a(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!g.m6840a(string)) {
                    f(string);
                }
            }
            boolean z = false;
            if (!g.m6840a(this.b.getString("DID"))) {
                this.b.remove("DID");
                z = true;
            }
            if (!g.m6840a(this.b.getString("EI"))) {
                this.b.remove("EI");
                z = true;
            }
            if (!g.m6840a(this.b.getString("SI"))) {
                this.b.remove("SI");
                z = true;
            }
            if (z) {
                this.b.commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m6852c() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.d.getBytes(currentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.d.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.ta.utdid2.a.a.e.a(this.mContext);
        } catch (Exception e2) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(str)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            String str2 = str;
            if (str.endsWith("\n")) {
                str2 = str.substring(0, str.length() - 1);
            }
            if (str2.length() != 24 || (cVar = this.b) == null) {
                return;
            }
            cVar.putString("UTDID2", str2);
            this.b.commit();
        }
    }

    private boolean f() {
        return this.mContext.checkPermission(Manifest.permission.WRITE_SETTINGS, Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }

    private String g() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            String string = cVar.getString("UTDID2");
            if (g.m6840a(string) || this.f26a.c(string) == null) {
                return null;
            }
            return string;
        }
        return null;
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str == null || (cVar = this.f25a) == null || str.equals(cVar.getString(this.i))) {
            return;
        }
        this.f25a.putString(this.i, str);
        this.f25a.commit();
    }

    private void h(String str) {
        if (f() && b(str)) {
            String str2 = str;
            if (str.endsWith("\n")) {
                str2 = str.substring(0, str.length() - 1);
            }
            if (24 == str2.length()) {
                String str3 = null;
                try {
                    str3 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception e2) {
                }
                if (b(str3)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str2);
                } catch (Exception e3) {
                }
            }
        }
    }

    private void i(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception e2) {
            str2 = null;
        }
        if (str.equals(str2)) {
            return;
        }
        try {
            Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception e3) {
        }
    }

    private void j(String str) {
        if (!f() || str == null) {
            return;
        }
        i(str);
    }

    public String getValue() {
        synchronized (this) {
            if (this.h != null) {
                return this.h;
            }
            return h();
        }
    }

    public String h() {
        synchronized (this) {
            String i = i();
            this.h = i;
            if (!TextUtils.isEmpty(i)) {
                return this.h;
            }
            try {
                byte[] m6852c = m6852c();
                if (m6852c != null) {
                    String encodeToString = com.ta.utdid2.a.a.b.encodeToString(m6852c, 2);
                    this.h = encodeToString;
                    f(encodeToString);
                    String c2 = this.f26a.c(m6852c);
                    if (c2 != null) {
                        j(c2);
                        g(c2);
                    }
                    return this.h;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public String i() {
        String str;
        synchronized (this) {
            String str2 = "";
            try {
                str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
            } catch (Exception e2) {
            }
            if (b(str2)) {
                return str2;
            }
            e eVar = new e();
            boolean z = false;
            try {
                str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception e3) {
                str = null;
            }
            if (g.m6840a(str)) {
                z = true;
            } else {
                String e4 = eVar.e(str);
                if (b(e4)) {
                    h(e4);
                    return e4;
                }
                String d = eVar.d(str);
                String str3 = str;
                if (b(d)) {
                    String c2 = this.f26a.c(d);
                    str3 = str;
                    if (!g.m6840a(c2)) {
                        j(c2);
                        try {
                            str3 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                        } catch (Exception e5) {
                            str3 = str;
                        }
                    }
                }
                String d2 = this.f26a.d(str3);
                if (b(d2)) {
                    this.h = d2;
                    f(d2);
                    g(str3);
                    h(this.h);
                    return this.h;
                }
            }
            String g = g();
            if (b(g)) {
                String c3 = this.f26a.c(g);
                if (z) {
                    j(c3);
                }
                h(g);
                g(c3);
                this.h = g;
                return g;
            }
            String string = this.f25a.getString(this.i);
            if (!g.m6840a(string)) {
                String d3 = eVar.d(string);
                String str4 = d3;
                if (!b(d3)) {
                    str4 = this.f26a.d(string);
                }
                if (b(str4)) {
                    String c4 = this.f26a.c(str4);
                    if (!g.m6840a(str4)) {
                        this.h = str4;
                        if (z) {
                            j(c4);
                        }
                        f(this.h);
                        return this.h;
                    }
                }
            }
            return null;
        }
    }
}
