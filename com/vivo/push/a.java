package com.vivo.push;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f27339a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27340c;

    public a(String str, String str2, Bundle bundle) {
        this.b = str;
        this.f27340c = str2;
        this.f27339a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (android.text.TextUtils.isEmpty(r7) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.a a(android.content.Intent r6) {
        /*
            r0 = 0
            r9 = r0
            r0 = r6
            if (r0 != 0) goto L10
            java.lang.String r0 = "BundleWapper"
            java.lang.String r1 = "create error : intent is null"
            int r0 = com.vivo.push.util.p.a(r0, r1)
            r0 = 0
            return r0
        L10:
            r0 = r6
            android.os.Bundle r0 = r0.getExtras()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L2d
            r0 = r11
            java.lang.String r1 = "client_pkgname"
            java.lang.String r0 = r0.getString(r1)
            r7 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            goto L2f
        L2d:
            r0 = 0
            r7 = r0
        L2f:
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L3e
            java.lang.String r0 = "BundleWapper"
            java.lang.String r1 = "create warning: pkgName is null"
            int r0 = com.vivo.push.util.p.b(r0, r1)
        L3e:
            r0 = r6
            java.lang.String r0 = r0.getPackage()
            r10 = r0
            r0 = r10
            r8 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L74
            r0 = r6
            android.content.ComponentName r0 = r0.getComponent()
            if (r0 != 0) goto L5b
            r0 = r9
            r6 = r0
            goto L63
        L5b:
            r0 = r6
            android.content.ComponentName r0 = r0.getComponent()
            java.lang.String r0 = r0.getPackageName()
            r6 = r0
        L63:
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L72
            java.lang.String r0 = "BundleWapper"
            java.lang.String r1 = "create warning: targetPkgName is null"
            int r0 = com.vivo.push.util.p.b(r0, r1)
        L72:
            r0 = r6
            r8 = r0
        L74:
            com.vivo.push.a r0 = new com.vivo.push.a
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r11
            r1.<init>(r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.a.a(android.content.Intent):com.vivo.push.a");
    }

    public final String a() {
        return this.b;
    }

    public final String a(String str) {
        Bundle bundle = this.f27339a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final void a(String str, int i) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putLong(str, j);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putSerializable(str, serializable);
    }

    public final void a(String str, String str2) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putString(str, str2);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putStringArrayList(str, arrayList);
    }

    public final void a(String str, boolean z) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putBoolean(str, z);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f27339a == null) {
            this.f27339a = new Bundle();
        }
        this.f27339a.putByteArray(str, bArr);
    }

    public final int b(String str, int i) {
        Bundle bundle = this.f27339a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public final long b(String str, long j) {
        Bundle bundle = this.f27339a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final Bundle b() {
        return this.f27339a;
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f27339a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f27339a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f27339a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f27339a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }
}
