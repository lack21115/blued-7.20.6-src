package com.opos.cmn.e.a.c.d;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f11102a;
    private com.opos.cmn.e.a.c.b.a b;

    /* renamed from: c  reason: collision with root package name */
    private Toast f11103c;

    public b(Context context, com.opos.cmn.e.a.c.b.a aVar) {
        this.f11102a = context.getApplicationContext();
        this.b = aVar;
        this.f11103c = new Toast(this.f11102a);
    }

    private Object a(Object obj, String str) {
        Field declaredField;
        if (obj != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str) || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                    return null;
                }
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e);
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.WindowManager.LayoutParams a() {
        /*
            r4 = this;
            r0 = r4
            r1 = r4
            android.widget.Toast r1 = r1.f11103c     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "mTN"
            java.lang.Object r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L2a
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L33
            r0 = r4
            r1 = r5
            java.lang.String r2 = "mParams"
            java.lang.Object r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L2a
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L33
            r0 = r5
            boolean r0 = r0 instanceof android.view.WindowManager.LayoutParams     // Catch: java.lang.Exception -> L2a
            if (r0 == 0) goto L33
            r0 = r5
            android.view.WindowManager$LayoutParams r0 = (android.view.WindowManager.LayoutParams) r0     // Catch: java.lang.Exception -> L2a
            r5 = r0
            goto L35
        L2a:
            r5 = move-exception
            java.lang.String r0 = "CustomToast"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L33:
            r0 = 0
            r5 = r0
        L35:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getWindowLayoutParams="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L4d
            r0 = r5
            r6 = r0
            goto L50
        L4d:
            java.lang.String r0 = "null"
            r6 = r0
        L50:
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "CustomToast"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.e.a.c.d.b.a():android.view.WindowManager$LayoutParams");
    }

    public void a(int i) {
        com.opos.cmn.an.f.a.b("CustomToast", "setDuration duration=" + i);
        this.f11103c.setDuration(i);
    }

    public void a(int i, int i2, int i3) {
        com.opos.cmn.an.f.a.b("CustomToast", "setGravity gravity=" + i + ",xOffset=" + i2 + ",yOffset=" + i3);
        this.f11103c.setGravity(i, i2, i3);
    }

    public void a(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("setView view=");
        sb.append(view != null ? view : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("CustomToast", sb.toString());
        if (view != null) {
            this.f11103c.setView(view);
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("CustomToast", "show");
        this.f11103c.show();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("CustomToast", com.anythink.expressad.d.a.b.dO);
        this.f11103c.cancel();
    }
}
