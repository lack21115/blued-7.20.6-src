package com.anythink.expressad.video.module.a.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/d.class */
public class d extends k {
    public d(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i, z);
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        if (this.W) {
            if (i == 122) {
                a();
                return;
            }
            switch (i) {
                case 109:
                    b(2);
                    a(2);
                    return;
                case 110:
                    if (this.X != null && this.X.k() == 5) {
                        a(obj.toString());
                    }
                    b(1);
                    a(1);
                    return;
                case 111:
                    a(1);
                    return;
                default:
                    return;
            }
        }
    }
}
