package com.google.android.collect;

import android.util.ArrayMap;
import java.util.HashMap;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/collect/Maps.class */
public class Maps {
    public static <K, V> ArrayMap<K, V> newArrayMap() {
        return new ArrayMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }
}
