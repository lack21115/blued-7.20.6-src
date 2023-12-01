package com.mokee.volley.toolbox;

import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/HttpHeaderParser.class */
public class HttpHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24258a = null;

    static {
        String[] strArr = new String[12];
        throw new VerifyError("bad dex opcode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x007a, code lost:
        if (r0.equals(com.mokee.volley.toolbox.HttpHeaderParser.f24258a[7]) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x008c, code lost:
        if (r0.equals(com.mokee.volley.toolbox.HttpHeaderParser.f24258a[10]) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008f, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0093, code lost:
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
        if (r0.startsWith(com.mokee.volley.toolbox.HttpHeaderParser.f24258a[3]) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a1, code lost:
        r13 = java.lang.Long.parseLong(r0.substring(8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
        r6 = r7 + 1;
        r17 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        r7 = r6;
        r11 = r17;
        r15 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c3, code lost:
        if (r6 < r0.length) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c6, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010c, code lost:
        if (r0 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x016d, code lost:
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0173, code lost:
        if (r0 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0185, code lost:
        if (r0.equals(com.mokee.volley.toolbox.HttpHeaderParser.f24258a[11]) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0188, code lost:
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0197, code lost:
        if (r0.equals(com.mokee.volley.toolbox.HttpHeaderParser.f24258a[6]) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x019d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x019f, code lost:
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01a0, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01a2, code lost:
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01bc, code lost:
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0063, code lost:
        if (r0 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0066, code lost:
        r0 = r0[r7].trim();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c3 -> B:9:0x0066). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mokee.volley.Cache.Entry parseCacheHeaders(com.mokee.volley.NetworkResponse r5) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.HttpHeaderParser.parseCacheHeaders(com.mokee.volley.NetworkResponse):com.mokee.volley.Cache$Entry");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        if (r5 < r0.length) goto L6;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0055 -> B:7:0x0024). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String parseCharset(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h
            r7 = r0
            r0 = r4
            java.lang.String[] r1 = com.mokee.volley.toolbox.HttpHeaderParser.f24258a
            r2 = 2
            r1 = r1[r2]
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L58
            r0 = r4
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            r4 = r0
            r0 = r7
            if (r0 == 0) goto L5e
            r0 = 1
            r6 = r0
        L24:
            r0 = r4
            r1 = r6
            r0 = r0[r1]
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = "="
            java.lang.String[] r0 = r0.split(r1)
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r1 = 2
            if (r0 != r1) goto L4c
            r0 = r8
            r1 = 0
            r0 = r0[r1]
            java.lang.String[] r1 = com.mokee.volley.toolbox.HttpHeaderParser.f24258a
            r2 = 1
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4c
            r0 = r8
            r1 = 1
            r0 = r0[r1]
            return r0
        L4c:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L50:
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = r4
            int r1 = r1.length
            if (r0 < r1) goto L24
        L58:
            java.lang.String[] r0 = com.mokee.volley.toolbox.HttpHeaderParser.f24258a
            r1 = 0
            r0 = r0[r1]
            return r0
        L5e:
            r0 = 1
            r5 = r0
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.HttpHeaderParser.parseCharset(java.util.Map):java.lang.String");
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }
}
