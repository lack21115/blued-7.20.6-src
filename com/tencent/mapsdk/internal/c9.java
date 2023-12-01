package com.tencent.mapsdk.internal;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c9.class */
public class c9 extends a9 {
    private ArrayList<a9> B;

    public c9(ArrayList<a9> arrayList) {
        this.B = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.a9
    public boolean a(d9 d9Var) {
        if (this.B.isEmpty()) {
            return true;
        }
        a9 a9Var = this.B.get(0);
        if (a9Var.a(d9Var)) {
            a9Var.c();
            this.B.remove(a9Var);
        }
        return this.B.isEmpty();
    }
}
