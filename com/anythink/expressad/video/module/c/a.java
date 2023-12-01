package com.anythink.expressad.video.module.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.h.b;
import com.anythink.expressad.foundation.h.j;
import com.anythink.expressad.foundation.h.k;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/c/a.class */
public final class a extends com.anythink.expressad.foundation.g.f.h.a {
    public a(Context context) {
        super(context);
    }

    @Override // com.anythink.expressad.foundation.g.f.h.a
    public final void a(String str, b bVar) {
        super.a(str, bVar);
        bVar.a("platform", "1");
        bVar.a("os_version", Build.VERSION.RELEASE);
        bVar.a("package_name", k.h(this.f5073a));
        bVar.a("app_version_name", k.d(this.f5073a));
        StringBuilder sb = new StringBuilder();
        sb.append(k.c(this.f5073a));
        bVar.a("app_version_code", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(k.b(this.f5073a));
        bVar.a("orientation", sb2.toString());
        bVar.a(com.anythink.expressad.foundation.g.a.P, "");
        bVar.a("sdk_version", com.anythink.expressad.out.b.f5227a);
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        if (com.anythink.expressad.d.b.b() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                String a2 = j.a(jSONObject.toString());
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                bVar.a("dvi", a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
