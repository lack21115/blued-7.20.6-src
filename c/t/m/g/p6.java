package c.t.m.g;

import android.content.Context;
import java.io.File;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p6.class */
public class p6 {

    /* renamed from: a  reason: collision with root package name */
    public r6 f3935a;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p6$a.class */
    public class a implements x1 {
        public a(p6 p6Var) {
        }

        @Override // c.t.m.g.x1
        public void a(int i, String str, String str2) {
            r6.a(str, str2);
        }
    }

    public p6() {
        r6.a("2.2.0_20210909");
    }

    public void a() {
        r6 r6Var = this.f3935a;
        if (r6Var != null) {
            r6Var.c();
            this.f3935a = null;
        }
    }

    public void a(Context context) {
        b();
        File externalFilesDir = context.getExternalFilesDir("data");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        new File(externalFilesDir, "DrDebugLog");
        w1.a(new a(this));
    }

    public final void b() {
        r6 h = r6.h();
        this.f3935a = h;
        if (h != null) {
            h.a(true);
            this.f3935a.e();
        }
        r6.h().a(5000L);
    }
}
