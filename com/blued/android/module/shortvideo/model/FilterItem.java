package com.blued.android.module.shortvideo.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/FilterItem.class */
public class FilterItem implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public BluedFilterType.FILER f15754a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f15755c;

    public FilterItem(BluedFilterType.FILER filer, int i, int i2) {
        this.b = -1;
        this.f15755c = -1;
        this.f15754a = filer;
        this.f15755c = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public BluedFilterType.FILER b() {
        return this.f15754a;
    }

    public int c() {
        return this.f15755c;
    }
}
