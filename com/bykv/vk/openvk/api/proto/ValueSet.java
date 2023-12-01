package com.bykv.vk.openvk.api.proto;

import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bykv/vk/openvk/api/proto/ValueSet.class */
public interface ValueSet {

    /* loaded from: source-7206380-dex2jar.jar:com/bykv/vk/openvk/api/proto/ValueSet$ValueGetter.class */
    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i, Class<T> cls);

    boolean booleanValue(int i);

    boolean booleanValue(int i, boolean z);

    boolean containsKey(int i);

    double doubleValue(int i);

    float floatValue(int i);

    float floatValue(int i, float f);

    int intValue(int i);

    int intValue(int i, int i2);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i);

    long longValue(int i, long j);

    <T> T objectValue(int i, Class<T> cls);

    int size();

    String stringValue(int i);

    String stringValue(int i, String str);
}
