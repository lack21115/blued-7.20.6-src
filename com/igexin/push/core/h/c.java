package com.igexin.push.core.h;

import android.util.Base64;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.a;
import com.igexin.push.core.a.b.h;
import com.igexin.push.core.e.f;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/h/c.class */
public final class c extends com.igexin.push.e.a.d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9948a = "GetIDCConfigHttpPlugin";
    public static JSONArray b;

    public c(String str, JSONArray jSONArray) {
        super(str);
        b = jSONArray;
    }

    private static void a(JSONArray jSONArray) {
        b = jSONArray;
    }

    @Override // com.igexin.push.e.a.d
    public final void a(Exception exc) {
        f.a().b(System.currentTimeMillis());
        com.igexin.c.a.c.a.a(exc);
    }

    @Override // com.igexin.push.e.a.d
    public final void a(byte[] bArr) throws Exception {
        if (bArr != null) {
            try {
                String str = new String(com.igexin.c.b.a.c(Base64.decode(bArr, 0)));
                com.igexin.c.a.c.a.a("->get idc config server resp data : ".concat(str), new Object[0]);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass7(str), true, false);
                com.igexin.push.config.f.a(str, true);
                f.a().b(0L);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass6(b.toString()), true, false);
                SDKUrlConfig.setIdcConfigUrl(h.a(b));
            } catch (Exception e) {
                f.a().b(System.currentTimeMillis());
                throw e;
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}
