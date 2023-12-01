package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use Maps.difference")
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/MapDifference.class */
public interface MapDifference<K, V> {

    @DoNotMock("Use Maps.difference")
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/MapDifference$ValueDifference.class */
    public interface ValueDifference<V> {
        boolean equals(@NullableDecl Object obj);

        int hashCode();

        V leftValue();

        V rightValue();
    }

    boolean areEqual();

    Map<K, ValueDifference<V>> entriesDiffering();

    Map<K, V> entriesInCommon();

    Map<K, V> entriesOnlyOnLeft();

    Map<K, V> entriesOnlyOnRight();

    boolean equals(@NullableDecl Object obj);

    int hashCode();
}
