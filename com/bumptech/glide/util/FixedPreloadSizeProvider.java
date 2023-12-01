package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/FixedPreloadSizeProvider.class */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21102a;

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] a(T t, int i, int i2) {
        return this.f21102a;
    }
}
