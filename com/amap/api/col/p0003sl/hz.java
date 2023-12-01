package com.amap.api.col.p0003sl;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.hz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hz.class */
public final class hz {
    private static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            iw.c(th, "pu", "gdh");
            str = null;
        }
        String str2 = str;
        if (str == null) {
            str2 = "null";
        }
        return str2;
    }

    private static String a(String str) {
        return ib.c(str);
    }

    public static java.net.Proxy a(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? a(context, new URI("http://restsdk.amap.com")) : b(context);
        } catch (Throwable th) {
            iw.c(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy a(Context context, URI uri) {
        if (c(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                java.net.Proxy proxy = null;
                if (select != null) {
                    proxy = null;
                    if (!select.isEmpty()) {
                        java.net.Proxy proxy2 = select.get(0);
                        proxy = null;
                        if (proxy2 != null) {
                            if (proxy2.type() == Proxy.Type.DIRECT) {
                                return null;
                            }
                            proxy = proxy2;
                        }
                    }
                }
                return proxy;
            } catch (Throwable th) {
                iw.c(th, "pu", "gpsc");
                return null;
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            iw.c(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00c2: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:35:0x00c2 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00ed: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:44:0x00ea */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0310: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:164:0x0310 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00b8: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:33:0x00b8 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00e3: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:42:0x00e1 */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02ee A[Catch: all -> 0x034b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x034b, blocks: (B:151:0x02d5, B:159:0x02ee), top: B:182:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy b(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hz.b(android.content.Context):java.net.Proxy");
    }

    private static boolean c(Context context) {
        return hs.o(context) == 0;
    }
}
