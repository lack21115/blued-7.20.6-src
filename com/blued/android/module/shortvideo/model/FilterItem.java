package com.blued.android.module.shortvideo.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/FilterItem.class */
public class FilterItem implements Serializable {
    public BluedFilterType.FILER a;
    public int b;
    public int c;

    public FilterItem(BluedFilterType.FILER filer, int i, int i2) {
        this.b = -1;
        this.c = -1;
        this.a = filer;
        this.c = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public BluedFilterType.FILER b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }
}
