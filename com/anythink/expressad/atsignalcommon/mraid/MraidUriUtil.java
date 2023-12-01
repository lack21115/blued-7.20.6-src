package com.anythink.expressad.atsignalcommon.mraid;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/MraidUriUtil.class */
public class MraidUriUtil {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f4251a = new ConcurrentHashMap<>();
    private static ArrayList<String> b = new ArrayList<>();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r0 == (-1)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Set<java.lang.String> a(android.net.Uri r5) {
        /*
            r0 = r5
            java.lang.String r0 = r0.getEncodedQuery()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto Ld
            java.util.Set r0 = java.util.Collections.emptySet()
            return r0
        Ld:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = 0
            r7 = r0
        L18:
            r0 = r5
            r1 = 38
            r2 = r7
            int r0 = r0.indexOf(r1, r2)
            r8 = r0
            r0 = r8
            r6 = r0
            r0 = r8
            r1 = -1
            if (r0 != r1) goto L2c
            r0 = r5
            int r0 = r0.length()
            r6 = r0
        L2c:
            r0 = r5
            r1 = 61
            r2 = r7
            int r0 = r0.indexOf(r1, r2)
            r9 = r0
            r0 = r9
            r1 = r6
            if (r0 > r1) goto L44
            r0 = r9
            r8 = r0
            r0 = r9
            r1 = -1
            if (r0 != r1) goto L46
        L44:
            r0 = r6
            r8 = r0
        L46:
            r0 = r10
            r1 = r5
            r2 = r7
            r3 = r8
            java.lang.String r1 = r1.substring(r2, r3)
            java.lang.String r1 = android.net.Uri.decode(r1)
            boolean r0 = r0.add(r1)
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r5
            int r1 = r1.length()
            if (r0 < r1) goto L18
            r0 = r10
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil.a(android.net.Uri):java.util.Set");
    }

    private static void a() {
        Method[] declaredMethods = IMraidSignalCommunication.class.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            b.add(declaredMethods[i2].getName());
            i = i2 + 1;
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!f4251a.containsKey(str)) {
            f4251a.put(str, str2);
            return;
        }
        String str3 = f4251a.get(str);
        if (TextUtils.isEmpty(str2) || str3.contains(str2)) {
            return;
        }
        String str4 = str3;
        if (str3.length() > 0) {
            str4 = str3.concat(",");
        }
        f4251a.put(str, str4.concat(str2));
    }

    public static void clearUnSupportMraidMethodMap() {
        if (f4251a.size() > 0) {
            f4251a.clear();
        }
    }

    public static void clearUnSupportMraidMethodMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f4251a.remove(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0158, code lost:
        if (r0 == (-1)) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.atsignalcommon.windvane.a getMraidMethodContext(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil.getMraidMethodContext(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView, java.lang.String):com.anythink.expressad.atsignalcommon.windvane.a");
    }

    public static String getUnSupportMraidMethodString(String str) {
        if (f4251a.containsKey(str)) {
            return f4251a.get(str);
        }
        return null;
    }
}
