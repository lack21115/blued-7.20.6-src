package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m3.class */
public final class m3 implements s3 {
    public static final f3<Boolean> b = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f21261a;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m3$a.class */
    public static final class a extends f3<Boolean> {
        @Override // com.bytedance.bdtracker.f3
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(j1.b((Context) objArr[0]));
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m3$b.class */
    public static class b extends s3.a {

        /* renamed from: c  reason: collision with root package name */
        public long f21262c = 0;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return b.b(context).booleanValue();
    }

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        int i;
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    bVar.f21305a = string;
                    bVar.b = Boolean.parseBoolean(string2);
                    bVar.f21262c = 202003021704L;
                    return bVar;
                }
            } catch (Throwable th) {
                z2.a(th);
            }
        }
        Pair pair = TextUtils.isEmpty(this.f21261a) ? null : (Pair) new a4(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.f21261a), new n3(this)).a();
        if (pair != null) {
            bVar.f21305a = (String) pair.first;
            bVar.b = ((Boolean) pair.second).booleanValue();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f21261a, 0);
                i = 0;
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e) {
                z2.a(e);
                i = 0;
            }
            bVar.f21262c = i;
        }
        return bVar;
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        return c(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r0.getPackageInfo("com.huawei.hms", 0) != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(android.content.Context r5) {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r5
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L49
            r5 = r0
            r0 = r5
            java.lang.String r1 = "com.huawei.hwid"
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L20
            r0 = r4
            java.lang.String r1 = "com.huawei.hwid"
            r0.f21261a = r1     // Catch: java.lang.Throwable -> L49
            goto L45
        L20:
            r0 = r5
            java.lang.String r1 = "com.huawei.hwid.tv"
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L33
            r0 = r4
            java.lang.String r1 = "com.huawei.hwid.tv"
            r0.f21261a = r1     // Catch: java.lang.Throwable -> L49
            goto L45
        L33:
            r0 = r4
            java.lang.String r1 = "com.huawei.hms"
            r0.f21261a = r1     // Catch: java.lang.Throwable -> L49
            r0 = r5
            java.lang.String r1 = "com.huawei.hms"
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> L49
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L47
        L45:
            r0 = 1
            r6 = r0
        L47:
            r0 = r6
            return r0
        L49:
            r5 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.m3.c(android.content.Context):boolean");
    }
}
