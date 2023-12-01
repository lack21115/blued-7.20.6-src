package com.tencent.cloud.huiyansdkface.a.f;

import com.tencent.cloud.huiyansdkface.a.a.a.d;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/f/b.class */
public class b {
    public static final d a(d dVar, d dVar2) {
        int i = dVar2.f21740a;
        int i2 = (int) (dVar.b / (dVar.f21740a / dVar2.f21740a));
        if (i2 <= dVar2.b) {
            return new d(i, i2);
        }
        return new d((int) (i / (i2 / dVar2.b)), dVar2.b);
    }

    public static final d b(d dVar, d dVar2) {
        int i = dVar2.f21740a;
        int i2 = (int) (dVar.b / (dVar.f21740a / dVar2.f21740a));
        if (i2 >= dVar2.b) {
            return new d(i, i2);
        }
        return new d((int) (i / (i2 / dVar2.b)), dVar2.b);
    }
}
