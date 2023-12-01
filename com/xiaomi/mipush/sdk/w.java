package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/w.class */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Context context) {
        this.f41237a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            PackageInfo packageInfo = this.f41237a.getPackageManager().getPackageInfo(this.f41237a.getPackageName(), 4612);
            v.c(this.f41237a);
            v.d(this.f41237a, packageInfo);
            v.c(this.f41237a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
