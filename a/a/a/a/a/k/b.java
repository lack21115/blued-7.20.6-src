package a.a.a.a.a.k;

import a.a.a.a.a.e.h;
import a.a.a.a.a.k.d.d;
import a.a.a.a.a.k.e.c;
import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1399a = false;

    public static void a(Context context) {
        if (f1399a || context == null) {
            return;
        }
        f1399a = true;
        a.a.a.a.a.j.a.a().a(context);
        a.a().a(context.getApplicationContext());
        a.a().a(true);
        c.a().a(context.getApplicationContext());
        d.a().a(context.getApplicationContext());
        String[] strArr = a.a.a.a.a.e.d.f1358a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            if (h.h(context).contains(strArr[i2])) {
                a.a().a(false);
                break;
            }
            i = i2 + 1;
        }
        a.a.a.a.a.c.a.a().a(context.getApplicationContext());
    }

    public static boolean a() {
        return f1399a;
    }

    public static void b() {
        d.a().b((Context) null);
        a.a().b();
        a.a.a.a.a.k.c.a.g();
        f1399a = false;
    }
}
