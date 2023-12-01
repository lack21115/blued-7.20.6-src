package com.meizu.cloud.pushsdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/g.class */
public class g extends h<f> implements f {

    /* renamed from: a  reason: collision with root package name */
    private static g f10380a;
    private boolean b;

    private g(f fVar) {
        super(fVar);
        this.b = false;
    }

    public static g b() {
        if (f10380a == null) {
            synchronized (g.class) {
                try {
                    if (f10380a == null) {
                        f10380a = new g(new b());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10380a;
    }

    public void a(Context context) {
        a(context, (String) null);
    }

    public void a(Context context, String str) {
        if (this.b) {
            return;
        }
        boolean z = true;
        this.b = true;
        if ((context.getApplicationInfo().flags & 2) == 0) {
            z = false;
        }
        b(z);
        String str2 = str;
        if (str == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                str2 = MzSystemUtils.getDocumentsPath(context) + "/pushSdk/" + context.getPackageName();
            } else {
                str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName();
            }
        }
        a(str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str) {
        c().a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2) {
        c().a(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2, Throwable th) {
        c().a(str, str2, th);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        c().a(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return c().a();
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(String str, String str2) {
        c().b(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        c().b(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(String str, String str2) {
        c().c(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(String str, String str2) {
        c().d(str, str2);
    }
}
