package com.android.internal.app;

import android.util.ArrayMap;
import android.util.SparseArray;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessMap.class */
public class ProcessMap<E> {
    final ArrayMap<String, SparseArray<E>> mMap = new ArrayMap<>();

    public E get(String str, int i) {
        SparseArray<E> sparseArray = this.mMap.get(str);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public ArrayMap<String, SparseArray<E>> getMap() {
        return this.mMap;
    }

    public E put(String str, int i, E e) {
        SparseArray<E> sparseArray = this.mMap.get(str);
        SparseArray<E> sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>(2);
            this.mMap.put(str, sparseArray2);
        }
        sparseArray2.put(i, e);
        return e;
    }

    public void remove(String str, int i) {
        SparseArray<E> sparseArray = this.mMap.get(str);
        if (sparseArray != null) {
            sparseArray.remove(i);
            if (sparseArray.size() == 0) {
                this.mMap.remove(str);
            }
        }
    }
}
