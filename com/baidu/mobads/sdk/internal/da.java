package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/da.class */
public class da {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6570a = "error_message";
    public static final String b = "error_code";
    private static volatile da d;

    /* renamed from: c  reason: collision with root package name */
    protected final bq f6571c = bq.a();

    private da() {
    }

    public static da a() {
        if (d == null) {
            synchronized (da.class) {
                try {
                    if (d == null) {
                        d = new da();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public String a(bm bmVar, String str) {
        if (bmVar == null) {
            return "";
        }
        return a(bmVar.b() + "", bmVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004a -> B:10:0x003e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 == 0) goto L3e
            r0 = r5
            java.lang.String r1 = "msg"
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Exception -> L4a
            if (r0 == 0) goto L24
            r0 = r4
            r1 = r5
            java.lang.String r2 = "msg"
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Exception -> L4a
            com.baidu.mobads.sdk.internal.bm r1 = (com.baidu.mobads.sdk.internal.bm) r1     // Catch: java.lang.Exception -> L4a
            java.lang.String r2 = ""
            java.lang.String r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L4a
            r5 = r0
            goto L41
        L24:
            r0 = r5
            java.lang.String r1 = "error_message"
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Exception -> L4a
            if (r0 == 0) goto L3e
            r0 = r5
            java.lang.String r1 = "error_message"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L4a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L4a
            r5 = r0
            goto L41
        L3e:
            java.lang.String r0 = ""
            r5 = r0
        L41:
            r0 = r5
            if (r0 != 0) goto L48
            java.lang.String r0 = ""
            return r0
        L48:
            r0 = r5
            return r0
        L4a:
            r5 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.da.a(java.util.Map):java.lang.String");
    }
}
