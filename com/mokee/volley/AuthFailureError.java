package com.mokee.volley;

import android.content.Intent;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/AuthFailureError.class */
public class AuthFailureError extends VolleyError {
    private static final String c;
    private Intent a;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
        r7 = r6;
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        r10 = r11;
        r6 = r7;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
        if (r7 > r8) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
        com.mokee.volley.AuthFailureError.c = new java.lang.String(r11).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0083, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
        r5 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        r5 = 'K';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
        r5 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
        r5 = 'k';
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r6 <= 1) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
        r8 = r5;
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        r7 = r0;
        r0 = r10;
        r0 = r0[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
        switch((r8 % 5)) {
            case 0: goto L12;
            case 1: goto L13;
            case 2: goto L14;
            case 3: goto L15;
            default: goto L6;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
        r5 = 'E';
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004b, code lost:
        r0[r7] = (char) (r5 ^ r0);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (r6 != 0) goto L10;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0071 -> B:4:0x001a). Please submit an issue!!! */
    static {
        /*
            java.lang.String r0 = "\u00018R\u0019e:.R\u000f6t?XKm&.\u001e\u000e+ .EK&&.S\u000e+ \"V\u00076z"
            char[] r0 = r0.toCharArray()
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r5 = r0
            r0 = r10
            r11 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = 1
            if (r0 > r1) goto L67
        L1a:
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
        L1e:
            r0 = r10
            r11 = r0
            r0 = r11
            r1 = r7
            char r0 = r0[r1]
            r9 = r0
            r0 = r8
            r1 = 5
            int r0 = r0 % r1
            switch(r0) {
                case 0: goto L84;
                case 1: goto L8a;
                case 2: goto L90;
                case 3: goto L96;
                default: goto L48;
            }
        L48:
            r0 = 69
            r5 = r0
        L4b:
            r0 = r11
            r1 = r7
            r2 = r5
            r3 = r9
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r6
            if (r0 != 0) goto L61
            r0 = r6
            r7 = r0
            goto L1e
        L61:
            r0 = r6
            r7 = r0
            r0 = r10
            r11 = r0
        L67:
            r0 = r11
            r10 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r1 = r8
            if (r0 > r1) goto L1a
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            java.lang.String r0 = r0.intern()
            com.mokee.volley.AuthFailureError.c = r0
            return
        L84:
            r0 = 84
            r5 = r0
            goto L4b
        L8a:
            r0 = 75
            r5 = r0
            goto L4b
        L90:
            r0 = 55
            r5 = r0
            goto L4b
        L96:
            r0 = 107(0x6b, float:1.5E-43)
            r5 = r0
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.AuthFailureError.m11276clinit():void");
    }

    public AuthFailureError() {
    }

    public AuthFailureError(Intent intent) {
        this.a = intent;
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    public AuthFailureError(String str, Exception exc) {
        super(str, exc);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.a != null ? c : super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.a;
    }
}
