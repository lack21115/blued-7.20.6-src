package com.blued.android.module.common.utils.freedom;

import android.content.Context;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/freedom/FreedomItem.class */
public abstract class FreedomItem implements Serializable {
    public BaseViewHolder a;

    protected abstract int a();

    public int a(int i) {
        int d = d();
        int i2 = d;
        if (d <= 0) {
            i2 = (int) (i * c());
        }
        int i3 = i2;
        if (i2 <= 0) {
            i3 = 1;
        }
        return i3;
    }

    public abstract void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i);

    public void a(BaseViewHolder baseViewHolder) {
        this.a = baseViewHolder;
    }

    public int b() {
        return a();
    }

    protected float c() {
        return 0.0f;
    }

    protected int d() {
        return 0;
    }
}
