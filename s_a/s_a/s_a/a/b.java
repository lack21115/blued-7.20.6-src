package s_a.s_a.s_a.a;

import android.content.Context;
import com.anythink.core.common.b.g;
import java.util.HashMap;
import s_a.s_a.s_a.a.c;
import s_a.s_a.s_a.a.g;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/b.class */
public class b {
    public static b a;
    public HashMap<String, e> b;
    public boolean c = false;

    public b() {
        this.b = null;
        this.b = new HashMap<>();
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                try {
                    if (a == null) {
                        a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r0 == "") goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0216 A[Catch: all -> 0x0259, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:8:0x0026, B:10:0x002d, B:12:0x0044, B:13:0x0047, B:18:0x0066, B:20:0x0071, B:23:0x00ac, B:24:0x00b0, B:26:0x00ed, B:30:0x00fa, B:34:0x0108, B:38:0x0116, B:42:0x0124, B:46:0x0132, B:61:0x01ec, B:52:0x0160, B:63:0x020f, B:65:0x0216, B:66:0x0220, B:67:0x0225, B:76:0x024f, B:59:0x01d1, B:57:0x01b6, B:55:0x018c, B:53:0x0169, B:50:0x0140, B:21:0x008f, B:11:0x003a, B:69:0x0227, B:71:0x022d, B:74:0x0246), top: B:108:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0220 A[Catch: all -> 0x0259, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0002, B:8:0x0026, B:10:0x002d, B:12:0x0044, B:13:0x0047, B:18:0x0066, B:20:0x0071, B:23:0x00ac, B:24:0x00b0, B:26:0x00ed, B:30:0x00fa, B:34:0x0108, B:38:0x0116, B:42:0x0124, B:46:0x0132, B:61:0x01ec, B:52:0x0160, B:63:0x020f, B:65:0x0216, B:66:0x0220, B:67:0x0225, B:76:0x024f, B:59:0x01d1, B:57:0x01b6, B:55:0x018c, B:53:0x0169, B:50:0x0140, B:21:0x008f, B:11:0x003a, B:69:0x0227, B:71:0x022d, B:74:0x0246), top: B:108:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s_a.s_a.s_a.a.b.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public void b(Context context, String str) {
        if (!this.b.containsKey(str)) {
            if (str.equals("OUID") || str.equals("OUID_STATUS") || str == "OUID" || str == "OUID_STATUS") {
                String a2 = this.c ? c.b.a.a(context, str) : g.b.a.a(context, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (a2.equals("") || a2 == "") {
                    return;
                }
                this.b.put(str, new e(a2, currentTimeMillis + g.e.a));
                return;
            }
            return;
        }
        e eVar = this.b.get(str);
        if (eVar.a(str)) {
            return;
        }
        String a3 = this.c ? c.b.a.a(context, str) : g.b.a.a(context, str);
        long currentTimeMillis2 = System.currentTimeMillis();
        long b = a.b(str);
        if (a3.equals("") || a3 == "") {
            return;
        }
        eVar.a = a3;
        eVar.b = currentTimeMillis2 + b;
        a.a(context, eVar, str);
    }
}
