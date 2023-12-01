package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/m.class */
public class m {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/m$a.class */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    public static int a(Context context, float f) {
        if (context == null) {
            com.opos.cmn.an.f.a.a("Utils", "compareToScreenRatio but null context");
            return -1;
        }
        float c2 = com.opos.cmn.an.h.f.a.c(context) / com.opos.cmn.an.h.f.a.b(context);
        com.opos.cmn.an.f.a.b("Utils", "ratio = " + c2 + ", targetRatio =" + f);
        if (f > c2) {
            return 1;
        }
        return c2 == f ? 0 : -1;
    }

    public static String a(Context context) {
        boolean z;
        String h = com.opos.cmn.an.h.c.a.h(context);
        int hashCode = h.hashCode();
        if (hashCode == -1068855134) {
            if (h.equals("mobile")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 1653) {
            if (h.equals("2g")) {
                z = false;
            }
            z = true;
        } else if (hashCode == 1684) {
            if (h.equals("3g")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 1715) {
            if (h.equals("4g")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 1746) {
            if (h.equals(NetworkUtil.NETWORK_CLASS_5G)) {
                z = true;
            }
            z = true;
        } else if (hashCode != 3387192) {
            if (hashCode == 3649301 && h.equals("wifi")) {
                z = true;
            }
            z = true;
        } else {
            if (h.equals("none")) {
                z = true;
            }
            z = true;
        }
        return z ? !z ? !z ? !z ? "4G" : "WLAN" : "5G" : "3G" : "2G";
    }

    public static void a(final com.opos.mobad.c.c.a aVar, final String str, final a aVar2) {
        if (aVar2 == null) {
            return;
        }
        if (aVar == null) {
            aVar2.a();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            aVar2.a();
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.c.m.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap b = com.opos.mobad.c.c.a.this.b(str);
                if (b == null) {
                    aVar2.a();
                } else {
                    aVar2.a(b);
                }
            }
        });
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }
}
