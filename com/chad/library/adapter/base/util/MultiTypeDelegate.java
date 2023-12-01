package com.chad.library.adapter.base.util;

import android.net.TrafficStats;
import android.util.SparseIntArray;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/util/MultiTypeDelegate.class */
public abstract class MultiTypeDelegate<T> {

    /* renamed from: a  reason: collision with root package name */
    private SparseIntArray f7969a;

    public final int a(int i) {
        return this.f7969a.get(i, -404);
    }

    protected abstract int a(T t);

    public final int a(List<T> list, int i) {
        T t = list.get(i);
        return t != null ? a((MultiTypeDelegate<T>) t) : TrafficStats.TAG_SYSTEM_DOWNLOAD;
    }
}
