package com.anythink.expressad.foundation.f;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.f.a.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.FeedBackButton;
import com.anythink.expressad.widget.a.c;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/f/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f4977a = -2;
    public static int b = -2;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f4978c = false;
    private final ConcurrentHashMap<String, com.anythink.expressad.foundation.f.a.a> d;
    private final RelativeLayout.LayoutParams e;
    private com.anythink.expressad.d.a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/f/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f4979a = new b((byte) 0);

        a() {
        }
    }

    private b() {
        this.d = new ConcurrentHashMap<>();
        this.e = new RelativeLayout.LayoutParams(f4977a, b);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (((android.app.Activity) r3).isDestroyed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Activity a(android.content.Context r3) {
        /*
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()
            android.content.Context r0 = r0.g()
            r5 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r6 = r0
            r0 = r5
            boolean r0 = r0 instanceof android.app.Activity     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L1b
            r0 = r5
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L83
            r5 = r0
            goto L1d
        L1b:
            r0 = 0
            r5 = r0
        L1d:
            r0 = r5
            r7 = r0
            r0 = r5
            r6 = r0
            r0 = r3
            boolean r0 = r0 instanceof android.app.Activity     // Catch: java.lang.Exception -> L7d
            if (r0 == 0) goto L4a
            r0 = r5
            r6 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7d
            r1 = 17
            if (r0 < r1) goto L42
            r0 = r5
            r7 = r0
            r0 = r5
            r6 = r0
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L7d
            boolean r0 = r0.isDestroyed()     // Catch: java.lang.Exception -> L7d
            if (r0 != 0) goto L4a
        L42:
            r0 = r5
            r6 = r0
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L7d
            r7 = r0
        L4a:
            r0 = r8
            r3 = r0
            r0 = r7
            if (r0 == 0) goto L8a
            r0 = r7
            r6 = r0
            r0 = r8
            r3 = r0
            r0 = r7
            boolean r0 = r0.isFinishing()     // Catch: java.lang.Exception -> L7d
            if (r0 != 0) goto L8a
            r0 = r7
            r6 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7d
            r1 = 17
            if (r0 < r1) goto L7a
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.isDestroyed()     // Catch: java.lang.Exception -> L7d
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L7a
            r0 = 0
            return r0
        L7a:
            r0 = r7
            return r0
        L7d:
            r5 = move-exception
            r0 = r6
            r3 = r0
            goto L86
        L83:
            r5 = move-exception
            r0 = r6
            r3 = r0
        L86:
            r0 = r5
            r0.printStackTrace()
        L8a:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.f.b.a(android.content.Context):android.app.Activity");
    }

    public static b a() {
        return a.f4979a;
    }

    private void a(String str, int i, int i2, int i3, float f, float f2, float f3, String str2, String str3) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        Context g = n.a().g();
        a2.a(t.b(g, f), t.b(g, f2), t.b(g, i), t.b(g, i2), t.b(g, i3), f3, str2, str3);
    }

    private void a(String str, int i, ViewGroup viewGroup) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        if (a2.c() != null) {
            a2.a(i);
            if (i == 0) {
                a(str, n.a().g(), viewGroup, null, null);
            }
        }
    }

    private void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(str, context, viewGroup, layoutParams, null);
    }

    public static boolean a(Context context, c cVar) {
        if (cVar == null) {
            o.b("", "mbAlertDialog  is null");
            return false;
        }
        return b(context, cVar);
    }

    private static boolean b(Context context, c cVar) {
        Activity a2 = a(context);
        if (a2 == null || cVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !a2.isDestroyed()) {
            try {
                if (cVar.isShowing() || a2.isFinishing()) {
                    return false;
                }
                cVar.show();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private void c(String str, int i) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        if (i == 1) {
            a2.b();
        } else {
            a2.a();
        }
    }

    private com.anythink.expressad.foundation.f.a.a d(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (this.d.containsKey(str2)) {
            return this.d.get(str2);
        }
        return null;
    }

    private void e(String str) {
        a(str).e();
    }

    public final com.anythink.expressad.foundation.f.a.a a(String str) {
        com.anythink.expressad.foundation.f.a.a aVar;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (this.d.containsKey(str2)) {
            aVar = this.d.get(str2);
        } else {
            aVar = new com.anythink.expressad.foundation.f.a.a(str2);
            this.d.put(str2, aVar);
        }
        com.anythink.expressad.foundation.f.a.a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new com.anythink.expressad.foundation.f.a.a(str2);
            this.d.put(str2, aVar2);
        }
        return aVar2;
    }

    public final void a(String str, int i) {
        a(str).b(i);
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.anythink.expressad.foundation.f.a aVar) {
        if (b()) {
            com.anythink.expressad.foundation.f.a.a a2 = a(str);
            if (aVar != null) {
                a2.a(new a.C0073a(str, aVar));
            }
            FeedBackButton c2 = a2.c();
            if (c2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = layoutParams;
                if (layoutParams == null) {
                    int b2 = t.b(n.a().g(), 10.0f);
                    this.e.setMargins(b2, b2, b2, b2);
                    layoutParams2 = this.e;
                }
                ViewGroup viewGroup2 = (ViewGroup) c2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(c2);
                }
                Activity a3 = a(context);
                ViewGroup viewGroup3 = viewGroup;
                if (a3 != null) {
                    viewGroup3 = viewGroup;
                    if (viewGroup == null) {
                        viewGroup3 = (ViewGroup) a3.findViewById(R.id.content);
                    }
                }
                if (viewGroup3 != null) {
                    viewGroup3.removeView(c2);
                    viewGroup3.addView(c2, layoutParams2);
                }
            }
        }
    }

    public final void a(String str, com.anythink.expressad.foundation.d.c cVar) {
        a(str).a(cVar);
    }

    public final void a(String str, com.anythink.expressad.foundation.f.a aVar) {
        a(str).a(new a.C0073a(str, aVar));
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final FeedBackButton b(String str) {
        return a(str).c();
    }

    public final void b(String str, int i) {
        a(str).c(i);
    }

    public final boolean b() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a c2 = com.anythink.expressad.d.b.c();
        this.f = c2;
        return c2.K() != 0;
    }

    public final void c(String str) {
        com.anythink.expressad.foundation.f.a.a aVar = null;
        try {
            String e = TextUtils.isEmpty(str) ? com.anythink.expressad.foundation.b.a.b().e() : str;
            if (this.d.containsKey(e)) {
                aVar = this.d.get(e);
            }
            if (aVar != null) {
                aVar.d();
            }
            this.d.remove(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
