package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.opengl.GLES10;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/w.class */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Context context) {
        this.f27546a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            PackageInfo packageInfo = this.f27546a.getPackageManager().getPackageInfo(this.f27546a.getPackageName(), GLES10.GL_SPOT_DIRECTION);
            v.c(this.f27546a);
            v.d(this.f27546a, packageInfo);
            v.c(this.f27546a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
