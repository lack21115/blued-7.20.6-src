package com.tencent.qimei.o;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qimei.upload.BuildConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f38371a;
    public boolean b = false;

    public static e a() {
        if (f38371a == null) {
            synchronized (e.class) {
                try {
                    if (f38371a == null) {
                        f38371a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f38371a;
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.b || context == null) {
                return;
            }
            if (!com.tencent.qimei.c.a.i()) {
                this.b = true;
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("BuglySdkInfos", 0);
            String string = sharedPreferences.getString("4ef223fde6", "");
            if (string == null || !string.equals(BuildConfig.SDK_VERSION)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("4ef223fde6", BuildConfig.SDK_VERSION);
                edit.apply();
            }
            this.b = true;
        }
    }
}
