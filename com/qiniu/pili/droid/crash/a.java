package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/a.class */
class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f27471a = context;
    }

    private boolean a(String str, String str2) {
        int length = str.length() < str2.length() ? str.length() : str2.length();
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 == length) {
                boolean z2 = false;
                if (str.length() > str2.length()) {
                    z2 = true;
                }
                return z2;
            }
            char charAt = str.charAt(i2);
            char charAt2 = str2.charAt(i2);
            if (charAt != charAt2) {
                if (charAt > charAt2) {
                    z = true;
                }
                return z;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        SharedPreferences sharedPreferences = this.f27471a.getSharedPreferences("plcrash", 0);
        if (a("3.1.1", sharedPreferences.getString("lastVersion", "3.1.1"))) {
            f.a().b();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("lastVersion", "3.1.1");
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        new Thread(new Runnable() { // from class: com.qiniu.pili.droid.crash.a.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                File[] e = f.a().e();
                int length = e.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        return;
                    }
                    File file = e[i3];
                    try {
                        i = new g(file).call().intValue();
                    } catch (Exception e2) {
                        file.delete();
                        i = 0;
                    }
                    if (i < 500) {
                        file.delete();
                    }
                    i2 = i3 + 1;
                }
            }
        }).start();
    }
}
