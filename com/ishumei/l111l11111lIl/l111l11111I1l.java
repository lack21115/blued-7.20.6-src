package com.ishumei.l111l11111lIl;

import android.os.Build;
import com.ishumei.l1111l111111Il.l11l1111I1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.smantifraud.SmAntiFraud;
import com.umeng.analytics.pro.bh;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111I1l.class */
public final class l111l11111I1l {
    private SmAntiFraud.SmOption l1111l111111Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111I1l$l1111l111111Il.class */
    public static final class l1111l111111Il {
        private static final l111l11111I1l l1111l111111Il = new l111l11111I1l((byte) 0);

        private l1111l111111Il() {
        }
    }

    private l111l11111I1l() {
        this.l1111l111111Il = SmAntiFraud.option;
    }

    /* synthetic */ l111l11111I1l(byte b) {
        this();
    }

    public static l111l11111I1l l1111l111111Il() {
        return l1111l111111Il.l1111l111111Il;
    }

    private com.ishumei.l1111l111111Il.l111l11111I1l l111l11111lIl() {
        com.ishumei.l1111l111111Il.l111l11111I1l l111l11111i1l = new com.ishumei.l1111l111111Il.l111l11111I1l();
        l111l11111i1l.l11l1111I11l("exception");
        l111l11111i1l.l111l1111llIl("android");
        l111l11111i1l.l111l1111lIl("3.0.6");
        l111l11111i1l.l111l1111lI1l(Build.VERSION.RELEASE);
        l111l11111i1l.l11l1111lIIl(Build.MODEL);
        l111l11111i1l.l111l11111Il(this.l1111l111111Il.l11l1111I1ll());
        l111l11111i1l.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
        l111l11111i1l.l111l11111lIl(l11l1111I1l.l1111l111111Il().l111l11111lIl());
        l111l11111i1l.l111l11111I1l(l11l1111I1l.l1111l111111Il().l111l11111I1l());
        l111l11111i1l.l1111l111111Il(l11l1111I1l.l1111l111111Il().l111l11111Il());
        return l111l11111i1l;
    }

    private static String l111l11111lIl(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            do {
                th.printStackTrace(printWriter);
                th = th.getCause();
            } while (th != null);
            printWriter.close();
            String obj = stringWriter.toString();
            String str = obj;
            if (obj.length() > 4096) {
                str = obj.substring(0, 4096);
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public final String l1111l111111Il(Throwable th) {
        try {
            com.ishumei.l1111l111111Il.l111l11111I1l l111l11111i1l = new com.ishumei.l1111l111111Il.l111l11111I1l();
            l111l11111i1l.l11l1111I11l("exception");
            l111l11111i1l.l111l1111llIl("android");
            l111l11111i1l.l111l1111lIl("3.0.6");
            l111l11111i1l.l111l1111lI1l(Build.VERSION.RELEASE);
            l111l11111i1l.l11l1111lIIl(Build.MODEL);
            l111l11111i1l.l111l11111Il(this.l1111l111111Il.l11l1111I1ll());
            l111l11111i1l.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
            l111l11111i1l.l111l11111lIl(l11l1111I1l.l1111l111111Il().l111l11111lIl());
            l111l11111i1l.l111l11111I1l(l11l1111I1l.l1111l111111Il().l111l11111I1l());
            l111l11111i1l.l1111l111111Il(l11l1111I1l.l1111l111111Il().l111l11111Il());
            l111l11111i1l.l11l1111I1l(l111l11111lIl(th));
            String l111l11111lIl = l111l1111lIl.l111l11111lIl(l111l1111lIl.l1111l111111Il(l111l11111i1l).toString().getBytes());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("organization", l111l11111i1l.l1111l111111Il());
            jSONObject.put(bh.x, "android");
            jSONObject.put("appId", this.l1111l111111Il.l11l11IlIIll());
            jSONObject.put("encode", 1);
            jSONObject.put("data", l111l11111lIl);
            jSONObject.put("tn", "");
            jSONObject.put("ep", "");
            return jSONObject.toString();
        } catch (Throwable th2) {
            return th2.toString();
        }
    }
}
