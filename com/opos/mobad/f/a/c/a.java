package com.opos.mobad.f.a.c;

import android.content.Context;
import android.os.Build;
import com.opos.mobad.service.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f26071a;

    /* renamed from: com.opos.mobad.f.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/c/a$a.class */
    public static final class C0695a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f26074a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f26075c;

        public C0695a(int i, String str) {
            this.f26074a = i == 0;
            this.b = i;
            this.f26075c = str;
        }
    }

    public a(Context context) {
        this.f26071a = context.getApplicationContext();
    }

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 29 || !f.b().c() || com.opos.cmn.an.h.d.a.a(context, "android.permission.READ_PHONE_STATE");
    }

    private boolean b(int i) {
        if (com.opos.mobad.service.f.a.a(com.opos.mobad.service.f.a.a().v()) && c(i)) {
            com.opos.cmn.an.f.a.b("", "checkChannel is child " + i);
            return true;
        }
        return false;
    }

    private boolean c(int i) {
        return i == 2 || i == 3 || i == 6 || i == 7 || i == 8;
    }

    public C0695a a(int i) {
        return !f.b().a(i) ? new C0695a(-5, "") : b(i) ? new C0695a(-8, "") : new C0695a(0, "");
    }

    public C0695a a(String str) {
        return !f.d() ? new C0695a(-4, "no init.") : !a(this.f26071a) ? new C0695a(-3, "read phone state is required.") : !f.c().a(str) ? new C0695a(1035, "inter error request") : new C0695a(0, "");
    }

    public C0695a a(String str, int i) {
        return !f.c().a(str) ? new C0695a(1035, "inter error request") : b(i) ? new C0695a(-8, "inter error request") : new C0695a(0, "");
    }
}
