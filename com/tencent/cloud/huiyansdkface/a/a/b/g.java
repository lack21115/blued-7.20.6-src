package com.tencent.cloud.huiyansdkface.a.a.b;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/b/g.class */
public class g<T> implements com.tencent.cloud.huiyansdkface.a.a.g<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f35434a;

    public g(T t) {
        this.f35434a = t;
        if (t == null) {
            throw new IllegalArgumentException("target cannot be null");
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    public T b(List<T> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (T t : list) {
            if (this.f35434a.equals(t)) {
                return this.f35434a;
            }
        }
        return null;
    }
}
