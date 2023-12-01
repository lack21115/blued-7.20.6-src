package com.tencent.open.b;

import com.tencent.open.utils.Util;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected static d f24556a;

    protected d() {
    }

    public static d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f24556a == null) {
                    f24556a = new d();
                }
                dVar = f24556a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0 < 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Long r16, int r17, int r18, java.lang.String r19) {
        /*
            r10 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            r1 = r16
            long r1 = r1.longValue()
            long r0 = r0 - r1
            r22 = r0
            r0 = r16
            long r0 = r0.longValue()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L20
            r0 = r22
            r20 = r0
            r0 = r22
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L23
        L20:
            r0 = 0
            r20 = r0
        L23:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = r0
            java.lang.String r2 = "http://c.isdspeed.qq.com/code.cgi"
            r1.<init>(r2)
            r16 = r0
            r0 = r16
            java.lang.String r1 = "?domain=mobile.opensdk.com&cgi=opensdk&type="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            r1 = r11
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            java.lang.String r1 = "&code="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            r1 = r17
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            java.lang.String r1 = "&time="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            r1 = r20
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            java.lang.String r1 = "&rate="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            r1 = r18
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            java.lang.String r1 = "&uin="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            r1 = r13
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r16
            java.lang.String r1 = "&data="
            java.lang.StringBuffer r0 = r0.append(r1)
            r0 = r11
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1 = r17
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2 = r20
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = r18
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r19
            android.os.Bundle r0 = com.tencent.open.utils.Util.composeHaboCgiReportParams(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r12 = r0
            com.tencent.open.b.g r0 = com.tencent.open.b.g.a()
            r1 = r16
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "GET"
            r3 = r12
            r4 = 1
            r0.a(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.d.a(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, int, int, java.lang.String):void");
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        g.a().a(Util.composeViaReportParams(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g.a().a(Util.composeViaReportParams(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        g.a().a(Util.composeViaReportParams(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}
