package com.anythink.expressad.video.module.a.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/h.class */
public final class h extends k {
    public h(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i, z);
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, Object obj) {
        if (i == 100) {
            e();
            d();
            c();
            a(2);
        } else if (i == 109) {
            b(2);
        } else if (i == 122) {
            a();
        } else if (i != 129) {
            if (i == 118) {
                String str = "";
                if (obj != null) {
                    str = "";
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                }
                a(3, str);
            } else if (i == 119) {
                String str2 = "";
                if (obj != null) {
                    str2 = "";
                    if (obj instanceof String) {
                        str2 = (String) obj;
                    }
                }
                a(4, str2);
            }
        } else if (this.X != null && this.X.J() == 2) {
            e();
            d();
            c();
            a(1);
        }
        super.a(i, obj);
    }
}
