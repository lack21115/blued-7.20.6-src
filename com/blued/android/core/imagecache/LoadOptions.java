package com.blued.android.core.imagecache;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadOptions.class */
public class LoadOptions implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9592a = false;
    private static boolean n = false;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f9593c;
    public int d;
    public boolean e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    private boolean o;

    public LoadOptions() {
        this.b = 0;
        this.f9593c = null;
        this.d = 0;
        this.e = f9592a;
        this.f = ImageLoaderUtils.b();
        this.g = false;
        this.h = true;
        this.i = true;
        this.o = n;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
    }

    public LoadOptions(LoadOptions loadOptions) {
        this.b = 0;
        this.f9593c = null;
        this.d = 0;
        this.e = f9592a;
        this.f = ImageLoaderUtils.b();
        this.g = false;
        this.h = true;
        this.i = true;
        this.o = n;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.b = loadOptions.b;
        this.f9593c = loadOptions.f9593c;
        this.d = loadOptions.d;
        this.e = loadOptions.e;
        this.f = loadOptions.f;
        this.g = loadOptions.g;
        this.h = loadOptions.h;
        this.i = loadOptions.i;
        this.o = loadOptions.o;
        this.j = loadOptions.j;
        this.k = loadOptions.k;
        this.l = loadOptions.l;
        this.m = loadOptions.m;
    }

    public static LoadOptions c() {
        return new LoadOptions();
    }

    public LoadOptions a(int i, int i2) {
        this.f = ImageLoaderUtils.a(i, i2);
        return this;
    }

    public boolean a() {
        return this.o;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f) && this.f.equals(ImageLoaderUtils.a(0, 0));
    }
}
