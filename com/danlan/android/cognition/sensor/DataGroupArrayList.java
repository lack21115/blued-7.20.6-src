package com.danlan.android.cognition.sensor;

import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/DataGroupArrayList.class */
public class DataGroupArrayList<T> extends ArrayList<T> {
    private final int limit;

    public DataGroupArrayList(int i) {
        super(i);
        this.limit = i;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        if (size() >= this.limit) {
            remove(0);
        }
        return super.add(t);
    }
}
