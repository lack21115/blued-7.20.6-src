package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/uh.class */
public class uh {

    /* renamed from: a  reason: collision with root package name */
    private final String f24362a = "_night";
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24363c;
    private final List<ai> d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/uh$a.class */
    public class a implements Comparator<ai> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ai aiVar, ai aiVar2) {
            return aiVar2.d() - aiVar.d();
        }
    }

    public uh(int i, int i2, List<ai> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = i;
        this.f24363c = i2;
        copyOnWriteArrayList.addAll(list);
        Collections.sort(list, new a());
    }

    public int a() {
        return this.f24363c;
    }

    public Object[] a(w5 w5Var, boolean z) {
        for (ai aiVar : this.d) {
            if (aiVar.c(w5Var)) {
                Bitmap a2 = aiVar.a(z);
                StringBuilder sb = new StringBuilder();
                sb.append(aiVar.a());
                sb.append(z ? "_night" : "");
                String sb2 = sb.toString();
                return (!z || aiVar.b() == null || aiVar.b().length() <= 0) ? new Object[]{sb2, aiVar.c(), a2} : new Object[]{sb2, aiVar.b(), a2};
            }
        }
        return null;
    }

    public int b() {
        return this.b;
    }
}
