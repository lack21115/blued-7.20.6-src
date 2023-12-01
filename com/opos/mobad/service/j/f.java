package com.opos.mobad.service.j;

import com.opos.mobad.service.j.c;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/f.class */
public class f<T extends c> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private List<d<T>> f27392a;

    public f(List<d<T>> list) {
        this.f27392a = list;
    }

    public boolean a(T t) {
        List<d<T>> list = this.f27392a;
        boolean z = true;
        if (list != null) {
            if (list.size() <= 0) {
                return true;
            }
            for (d<T> dVar : this.f27392a) {
                if (dVar.a(t)) {
                    return true;
                }
            }
            z = false;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opos.mobad.service.j.d
    public /* bridge */ /* synthetic */ boolean a(Object obj) {
        return a((f<T>) ((c) obj));
    }
}
