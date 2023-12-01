package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/a.class */
public final class a extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (r0 == 0) goto L11;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            r0 = r5
            if (r0 == 0) goto Lc2
            r0 = r6
            if (r0 != 0) goto L9
            return
        L9:
            r0 = 0
            r8 = r0
            r0 = r6
            java.lang.String r1 = "openIdNotifyFlag"
            r2 = 0
            int r0 = r0.getIntExtra(r1, r2)
            r7 = r0
            java.lang.String r0 = "shouldUpdateId, notifyFlag : "
            r1 = r7
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            org.repackage.com.meizu.flyme.openidsdk.b.a(r0)
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L3b
            r0 = r6
            java.lang.String r1 = "openIdPackage"
            java.lang.String r0 = r0.getStringExtra(r1)
            r1 = r5
            java.lang.String r1 = r1.getPackageName()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L62
        L35:
            r0 = 1
            r8 = r0
            goto L62
        L3b:
            r0 = r7
            r1 = 2
            if (r0 != r1) goto L5b
            r0 = r6
            java.lang.String r1 = "openIdPackageList"
            java.util.ArrayList r0 = r0.getStringArrayListExtra(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L62
            r0 = r9
            r1 = r5
            java.lang.String r1 = r1.getPackageName()
            boolean r0 = r0.contains(r1)
            r8 = r0
            goto L62
        L5b:
            r0 = r7
            if (r0 != 0) goto L62
            goto L35
        L62:
            r0 = r8
            if (r0 != 0) goto L68
            return
        L68:
            r0 = r6
            java.lang.String r1 = "openIdType"
            java.lang.String r0 = r0.getStringExtra(r1)
            r5 = r0
            org.repackage.com.meizu.flyme.openidsdk.b r0 = org.repackage.com.meizu.flyme.openidsdk.b.a()
            r6 = r0
            java.lang.String r0 = "oaid"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r0 = r6
            org.repackage.com.meizu.flyme.openidsdk.OpenId r0 = r0.b
            r5 = r0
            goto Lb9
        L84:
            java.lang.String r0 = "vaid"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L95
            r0 = r6
            org.repackage.com.meizu.flyme.openidsdk.OpenId r0 = r0.d
            r5 = r0
            goto Lb9
        L95:
            java.lang.String r0 = "aaid"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto La6
            r0 = r6
            org.repackage.com.meizu.flyme.openidsdk.OpenId r0 = r0.f44113c
            r5 = r0
            goto Lb9
        La6:
            java.lang.String r0 = "udid"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb7
            r0 = r6
            org.repackage.com.meizu.flyme.openidsdk.OpenId r0 = r0.f44112a
            r5 = r0
            goto Lb9
        Lb7:
            r0 = 0
            r5 = r0
        Lb9:
            r0 = r5
            if (r0 != 0) goto Lbe
            return
        Lbe:
            r0 = r5
            r0.b()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
