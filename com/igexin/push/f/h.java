package com.igexin.push.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.config.SDKUrlConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10042a = 10000;
    private static final String b = "ErrorReport";

    /* renamed from: com.igexin.push.f.h$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/h$1.class */
    public static final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10043a;
        final /* synthetic */ a b;

        public AnonymousClass1(Context context, a aVar) {
            this.f10043a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = false;
            try {
                if (h.a()) {
                    com.igexin.push.core.d.d.a().a("s", Long.valueOf(System.currentTimeMillis()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", "25");
                    jSONObject.put("cid", "0");
                    jSONObject.put("BIData", new String(com.igexin.c.a.b.g.c(h.a(this.f10043a).getBytes()), "UTF-8"));
                    byte[] a2 = r.a(SDKUrlConfig.getBiUploadServiceUrl(), com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                    if (a2 != null) {
                        new String(a2);
                    }
                    z = true;
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a("ErrorReport|report 25 ex = " + th.toString(), new Object[0]);
                z = false;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/h$a.class */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        String str;
        String packageName = context.getPackageName();
        String str2 = null;
        try {
            ApplicationInfo b2 = n.b(context);
            str = null;
            if (b2 != null) {
                str = null;
                if (b2.metaData != null) {
                    String a2 = d.a(b2);
                    String str3 = a2;
                    if (TextUtils.isEmpty(a2)) {
                        str3 = b2.metaData.getString(com.igexin.push.core.b.b);
                    }
                    String str4 = str3;
                    str = str3;
                    if (TextUtils.isEmpty(str3)) {
                        str2 = str3;
                        str = b2.metaData.getString("GETUI_APPID");
                    }
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            str = str2;
        }
        String str5 = Build.VERSION.SDK;
        String str6 = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        sb.append("|");
        sb.append(str);
        sb.append("|");
        sb.append("3.2.14.0");
        sb.append("|");
        sb.append(true);
        sb.append("|");
        sb.append(n.g() == null ? "" : n.g());
        sb.append("|");
        sb.append(n.e());
        sb.append("|");
        sb.append(str5);
        sb.append("|");
        sb.append(str6);
        sb.append("|");
        sb.append(n.a(context));
        sb.append("|");
        sb.append(n.l());
        sb.append("|");
        sb.append(packageName);
        if (g.d != null) {
            sb.append("|");
            sb.append(g.d);
        }
        com.igexin.c.a.c.a.a("ErrorReport|" + sb.toString(), new Object[0]);
        return sb.toString();
    }

    private static void a(a aVar, Context context) {
        com.igexin.b.a.a().f9586a.execute(new AnonymousClass1(context, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        boolean z = false;
        try {
            if (System.currentTimeMillis() - com.igexin.push.core.d.d.a().c("s") > 86400000) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }
}
