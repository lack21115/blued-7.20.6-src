package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v0.class */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public b f3969a;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v0$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3970a;
        public final /* synthetic */ Context b;

        public a(String str, Context context) {
            this.f3970a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("ASUS".equals(this.f3970a)) {
                    new u0(this.b).a(v0.this.f3969a);
                } else if ("HUAWEI".equals(this.f3970a)) {
                    new w0(this.b).a(v0.this.f3969a);
                } else if (com.tencent.tendinsv.utils.r.d.equals(this.f3970a)) {
                    new b1(this.b).a(v0.this.f3969a);
                } else if ("ONEPLUS".equals(this.f3970a)) {
                    new a1(this.b).a(v0.this.f3969a);
                } else if ("ZTE".equals(this.f3970a)) {
                    new e1(this.b).a(v0.this.f3969a);
                } else if ("FERRMEOS".equals(this.f3970a) || v0.this.b()) {
                    new e1(this.b).a(v0.this.f3969a);
                } else if ("SSUI".equals(this.f3970a) || v0.this.c()) {
                    new e1(this.b).a(v0.this.f3969a);
                }
            } catch (Exception e) {
                String str = "getIDFromNewThead error: " + e;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v0$b.class */
    public interface b {
        void a(String str, boolean z);
    }

    public v0(b bVar) {
        this.f3969a = bVar;
    }

    public final String a() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.v0.a(android.content.Context):void");
    }

    public final void a(Context context, String str) {
        new Thread(new a(str, context)).start();
    }

    public boolean b() {
        String a2 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    public boolean c() {
        String a2 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a2) || a2.equalsIgnoreCase("unknown")) ? false : true;
    }

    public final void d() {
        b bVar = this.f3969a;
        if (bVar != null) {
            bVar.a(null, false);
        }
    }
}
