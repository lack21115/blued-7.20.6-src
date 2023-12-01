package com.igexin.push.c.a;

import com.igexin.c.a.b.d;
import com.igexin.c.a.d.a.e;
import com.igexin.push.c.c.f;
import com.igexin.push.c.c.h;
import com.igexin.push.c.c.k;
import com.igexin.push.c.c.m;
import com.igexin.push.c.c.n;
import com.igexin.push.c.c.p;
import com.igexin.push.c.c.q;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/a/a.class */
public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23321a = "CommandFilter";

    public a(String str, d dVar) {
        super(str, (byte) 0);
        a(dVar);
    }

    private static boolean a(com.igexin.push.c.c.a aVar, com.igexin.push.c.c.c cVar) {
        String string;
        if (aVar.b != 26) {
            return false;
        }
        n nVar = (n) cVar;
        if (!nVar.d() || nVar.f == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) nVar.f);
            if (!jSONObject.has("action") || (string = jSONObject.getString("action")) == null) {
                return false;
            }
            return string.equals(com.igexin.push.core.b.C);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("CommandFilter|" + e.toString(), new Object[0]);
            return false;
        }
    }

    private static e c(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        com.igexin.push.c.c.a aVar = (com.igexin.push.c.c.a) obj;
        byte b = aVar.b;
        com.igexin.push.c.c.c hVar = b != 0 ? b != 5 ? b != 9 ? b != 20 ? b != 26 ? b != 37 ? b != 97 ? null : new h() : new m() : new n() : new q() : new p() : new k() : new f();
        if ((aVar.f == 1 || aVar.f == 7) && hVar != null) {
            hVar.a(aVar.e);
            if (aVar.f != 7) {
                if (a(aVar, hVar)) {
                    return hVar;
                }
                return null;
            } else if (aVar.g != 32 || a(aVar, hVar)) {
                return hVar;
            } else {
                com.igexin.c.a.c.a.a(f23321a, "version = 7 and enc type = 0x20, redirect = false");
                return null;
            }
        }
        return null;
    }

    @Override // com.igexin.c.a.b.d
    public final Object a(Object obj) throws Exception {
        if (obj instanceof com.igexin.push.c.c.c) {
            com.igexin.push.c.c.c cVar = (com.igexin.push.c.c.c) obj;
            com.igexin.push.c.c.a aVar = new com.igexin.push.c.c.a();
            aVar.b = (byte) cVar.m;
            aVar.a(cVar.b());
            aVar.f23330c = cVar.n;
            aVar.d = cVar.o;
            return aVar;
        } else if (!(obj instanceof com.igexin.push.c.c.c[])) {
            return null;
        } else {
            com.igexin.push.c.c.c[] cVarArr = (com.igexin.push.c.c.c[]) obj;
            com.igexin.push.c.c.a[] aVarArr = new com.igexin.push.c.c.a[cVarArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVarArr.length) {
                    return aVarArr;
                }
                aVarArr[i2] = new com.igexin.push.c.c.a();
                aVarArr[i2].b = (byte) cVarArr[i2].m;
                aVarArr[i2].a(cVarArr[i2].b());
                i = i2 + 1;
            }
        }
    }

    @Override // com.igexin.c.a.b.d
    public final /* synthetic */ Object b(Object obj) throws Exception {
        return c(obj);
    }
}
