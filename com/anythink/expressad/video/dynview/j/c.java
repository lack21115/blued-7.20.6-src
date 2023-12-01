package com.anythink.expressad.video.dynview.j;

import android.content.Context;
import android.view.View;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.c;
import com.anythink.expressad.videocommon.e.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/j/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5560a = "ViewOptionWrapper";
    private static final String b = "\\.xml";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5561c = "\\/xml";

    public static com.anythink.expressad.video.dynview.c a(Context context, com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar == null) {
            return null;
        }
        try {
            return new c.a().a(k.b(context) == 1 ? com.anythink.expressad.video.dynview.a.a.b : com.anythink.expressad.video.dynview.a.a.f5507a).a(4).a(context).b(k.b(context)).b("").e(cVar.k()).d(i).a();
        } catch (Exception e) {
            o.d(f5560a, e.getMessage());
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c a(Context context, List<com.anythink.expressad.foundation.d.c> list) {
        int i;
        String str;
        int i2;
        if (list == null) {
            return null;
        }
        try {
            float f = t.f(n.a().g());
            float e = t.e(n.a().g());
            if (list.size() <= 0 || list.get(0) == null) {
                i = 1;
            } else {
                com.anythink.expressad.foundation.d.c cVar = list.get(0);
                i = (cVar == null || cVar.M() == null) ? 1 : cVar.M().c();
                list.get(0).as();
                list.get(0).aq();
            }
            if (i != 1) {
                str = com.anythink.expressad.video.dynview.a.a.i;
                i2 = i;
                if (i != 2) {
                    if (com.anythink.expressad.video.dynview.i.c.a(context)) {
                        i2 = 2;
                        str = com.anythink.expressad.video.dynview.a.a.i;
                    } else {
                        str = com.anythink.expressad.video.dynview.a.a.j;
                        i2 = 1;
                    }
                }
            } else {
                str = com.anythink.expressad.video.dynview.a.a.j;
                i2 = i;
            }
            return new c.a().a(context).a(str).a(1).a(e).b(f).a(list).b(i2).b("").a();
        } catch (Exception e2) {
            o.d(f5560a, e2.getMessage());
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c a(View view, com.anythink.expressad.foundation.d.c cVar) {
        String str;
        boolean a2;
        String str2;
        String str3;
        if (cVar == null) {
            return null;
        }
        int i = 102;
        int i2 = 0;
        if (cVar != null) {
            try {
                String K = cVar.K();
                if (cVar.M() != null) {
                    i = cVar.M().b();
                    str = cVar.M().e();
                } else {
                    str = "";
                }
                String a3 = a(i);
                a2 = com.anythink.expressad.video.dynview.i.c.a(str);
                str2 = K;
                str3 = a3;
            } catch (Exception e) {
                o.d(f5560a, e.getMessage());
                return null;
            }
        } else {
            str2 = "";
            str3 = str2;
            a2 = false;
        }
        d a4 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str2, false);
        if (a4 != null) {
            i2 = a4.h();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        return new c.a().a(str3).a(i).a(arrayList).a(view.getContext()).a(view).c(i2).b(k.b(view.getContext())).d(i).a(a2).b("").e(cVar.k()).a();
    }

    private static String a(int i) {
        return i != 3 ? i != 302 ? i != 802 ? i != 904 ? "anythink_reward_layer_floor" : com.anythink.expressad.video.dynview.a.a.g : com.anythink.expressad.video.dynview.a.a.f : com.anythink.expressad.video.dynview.a.a.e : com.anythink.expressad.video.dynview.a.a.h;
    }

    public static com.anythink.expressad.video.dynview.c b(Context context, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        try {
            float f = t.f(n.a().g());
            float e = t.e(n.a().g());
            int i = 0;
            if (list.get(0) != null) {
                i = list.get(0).k();
                list.get(0).as();
                list.get(0).aq();
            }
            int b2 = k.b(context);
            return new c.a().a(b2 == 1 ? com.anythink.expressad.video.dynview.a.a.k : com.anythink.expressad.video.dynview.a.a.l).a(5).a(context).a(e).b(f).a(list).b(b2).b("").e(i).d(i).a();
        } catch (Exception e2) {
            o.d(f5560a, e2.getMessage());
            return null;
        }
    }

    public static com.anythink.expressad.video.dynview.c b(View view, com.anythink.expressad.foundation.d.c cVar) {
        String a2;
        if (cVar == null) {
            return null;
        }
        String str = "";
        if (cVar != null) {
            try {
                str = cVar.K();
                a2 = a(3);
            } catch (Exception e) {
                o.d(f5560a, e.getMessage());
                return null;
            }
        } else {
            a2 = "";
        }
        int i = 0;
        d a3 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str, false);
        if (a3 != null) {
            i = a3.h();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        return new c.a().a(a2).a(3).a(arrayList).a(view.getContext()).a(view).c(i).b(k.b(view.getContext())).d(3).a();
    }
}
