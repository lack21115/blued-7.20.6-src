package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/x0.class */
public class x0 {

    /* renamed from: c  reason: collision with root package name */
    public static x0 f9191c = new x0();

    /* renamed from: a  reason: collision with root package name */
    public boolean f9192a = false;
    public Context b = b.i();

    public static x0 b() {
        return f9191c;
    }

    public boolean a() {
        boolean z;
        if (!this.f9192a) {
            Context context = this.b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.f9192a = false;
                }
            } else {
                z = true;
            }
            this.f9192a = z;
        }
        return this.f9192a;
    }
}
