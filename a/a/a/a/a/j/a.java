package a.a.a.a.a.j;

import a.a.a.a.a.k.d.e;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/j/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f1391a;
    public int b;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/j/a$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1392a = new a();
    }

    public a() {
        this.b = 0;
    }

    public static a a() {
        return b.f1392a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(Context context) {
        if (context != null) {
            this.f1391a = context.getApplicationContext();
        } else {
            this.f1391a = null;
        }
    }

    public void a(Intent intent) {
        if (this.f1391a == null) {
            return;
        }
        if ("pldroid-qos-filter".equals(intent.getAction()) && intent.getIntExtra("pldroid-qos-msg-type", -1) == 161) {
            intent.putExtra("videoFilterTime", this.b);
        }
        a.a.a.a.a.k.a.a().a(intent);
    }

    public int b() {
        return e.a();
    }
}
