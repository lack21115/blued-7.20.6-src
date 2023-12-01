package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b9.class */
public class b9 extends a9 {
    private ArrayList<a9> B;

    public b9(ArrayList<a9> arrayList) {
        this.B = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.a9
    public boolean a(d9 d9Var) {
        if (this.B.isEmpty()) {
            return true;
        }
        Iterator<a9> it = this.B.iterator();
        while (it.hasNext()) {
            it.next().a(d9Var);
        }
        return true;
    }
}
