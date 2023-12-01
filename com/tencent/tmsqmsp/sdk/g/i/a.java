package com.tencent.tmsqmsp.sdk.g.i;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f39802a;

    public a(Context context) {
        this.f39802a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            r12 = r0
            r0 = r8
            if (r0 == 0) goto L48
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L25
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L16
            r0 = 0
            r9 = r0
            goto L50
        L16:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r10 = r0
            goto L31
        L25:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r10 = r0
        L31:
            r0 = r11
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r0 = r0.toString()
            r9 = r0
            goto L4b
        L48:
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            r9 = r0
        L4b:
            r0 = r9
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r9 = r0
        L50:
            r0 = r7
            android.content.Context r0 = r0.f39802a
            android.content.ContentResolver r0 = r0.getContentResolver()
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L6b
            java.lang.String r0 = "return cursor is null,return"
            com.tencent.tmsqmsp.sdk.base.c.b(r0)
            r0 = 0
            return r0
        L6b:
            r0 = r12
            r9 = r0
            r0 = r10
            boolean r0 = r0.moveToNext()
            if (r0 == 0) goto L86
            r0 = r10
            r1 = r10
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)
            java.lang.String r0 = r0.getString(r1)
            r9 = r0
        L86:
            r0 = r10
            r0.close()
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.g.i.a.a(int, java.lang.String):java.lang.String");
    }
}
