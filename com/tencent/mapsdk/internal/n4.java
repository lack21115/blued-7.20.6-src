package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.view.View;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n4.class */
public abstract class n4 implements p4 {
    public abstract View[] c();

    @Override // com.tencent.mapsdk.internal.p4
    public Rect d() {
        View[] c2 = c();
        Rect rect = new Rect();
        int length = c2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return rect;
            }
            rect.union(g7.a(c2[i2]));
            i = i2 + 1;
        }
    }
}
