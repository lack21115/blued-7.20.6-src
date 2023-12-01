package com.tencent.cloud.huiyansdkface.a.a.b;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/b/a.class */
public class a<T> implements com.tencent.cloud.huiyansdkface.a.a.g<T> {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.g<T>[] f21741a;

    public a(com.tencent.cloud.huiyansdkface.a.a.g<T>[] gVarArr) {
        this.f21741a = gVarArr;
        if (gVarArr == null || gVarArr.length == 0) {
            throw new IllegalArgumentException("priorities must 1 element at least");
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    public T b(List<T> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        T b;
        com.tencent.cloud.huiyansdkface.a.a.g<T>[] gVarArr = this.f21741a;
        int length = gVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            com.tencent.cloud.huiyansdkface.a.a.g<T> gVar = gVarArr[i2];
            if (gVar != null && (b = gVar.b(list, dVar)) != null) {
                return b;
            }
            i = i2 + 1;
        }
    }
}
