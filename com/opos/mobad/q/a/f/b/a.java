package com.opos.mobad.q.a.f.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.c.a;
import com.opos.mobad.d.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.h.f;
import com.opos.mobad.q.a.f.a.b;
import com.opos.mobad.q.a.f.a.c;
import com.opos.mobad.q.a.f.a.e;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13510a;
    private com.opos.mobad.c.a b = new com.opos.mobad.c.a() { // from class: com.opos.mobad.q.a.f.b.a.1
        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i, int i2, a.InterfaceC0506a interfaceC0506a) {
            d.a().a(str, str2, i, i2, interfaceC0506a);
        }
    };

    private a() {
    }

    public static int a(Context context, AdItemData adItemData) {
        int i = 0;
        if (context != null) {
            i = 0;
            if (adItemData != null) {
                i = 0;
                if (adItemData.i() != null) {
                    MaterialData materialData = adItemData.i().get(0);
                    i = 0;
                    if (materialData != null) {
                        FloatLayerData U = materialData.U();
                        if (U == null) {
                            return 0;
                        }
                        int af = materialData.af();
                        if (a(U, af) || b(U, af)) {
                            return a(context, adItemData, af);
                        }
                        i = materialData.af();
                    }
                }
            }
        }
        return i;
    }

    private static int a(Context context, AdItemData adItemData, int i) {
        int F = adItemData.F();
        boolean a2 = F != 0 ? F != 1 : a(context);
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "check float endPage but material unused " + i);
        return a2 ? 1 : 2;
    }

    public static final a a() {
        a aVar;
        a aVar2 = f13510a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            try {
                a aVar3 = f13510a;
                aVar = aVar3;
                if (aVar3 == null) {
                    aVar = new a();
                    f13510a = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static boolean a(Context context) {
        int i;
        return context == null || (i = com.opos.cmn.an.h.f.a.i(context)) == 0 || i == 180;
    }

    public static final boolean a(FloatLayerData floatLayerData) {
        boolean z = true;
        if (floatLayerData.e() != null) {
            z = true;
            if (floatLayerData.e().size() > 0) {
                z = true;
                if (floatLayerData.e().get(0) != null) {
                    if (TextUtils.isEmpty(floatLayerData.e().get(0).a())) {
                        return true;
                    }
                    try {
                        z = true ^ new File(floatLayerData.e().get(0).a()).exists();
                    } catch (Exception e) {
                        return true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean a(FloatLayerData floatLayerData, int i) {
        return (i == 4 || i == 3) && b(floatLayerData);
    }

    private static final boolean b(FloatLayerData floatLayerData) {
        boolean z = true;
        if (floatLayerData.d() != null) {
            z = true;
            if (floatLayerData.d().size() > 0) {
                z = true;
                if (floatLayerData.d().get(0) != null) {
                    if (TextUtils.isEmpty(floatLayerData.d().get(0).a())) {
                        return true;
                    }
                    try {
                        z = true ^ new File(floatLayerData.d().get(0).a()).exists();
                    } catch (Exception e) {
                        return true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(FloatLayerData floatLayerData, int i) {
        return i == 5 && a(floatLayerData);
    }

    public com.opos.mobad.n.a a(Context context, int i, a.InterfaceC0538a interfaceC0538a) {
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        return new b(context, i, interfaceC0538a);
                    }
                    f a2 = f.a(context, this.b, i);
                    a2.a(interfaceC0538a);
                    return a2;
                }
                return new c(context, i, interfaceC0538a);
            }
            return new com.opos.mobad.q.a.f.a.d(context, i, interfaceC0538a);
        }
        return new e(context, i, interfaceC0538a);
    }

    public com.opos.mobad.n.a a(Context context, AdItemData adItemData, a.InterfaceC0538a interfaceC0538a) {
        return a(context, a(context, adItemData), interfaceC0538a);
    }
}
