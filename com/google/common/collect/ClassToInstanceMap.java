package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ClassToInstanceMap.class */
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    <T extends B> T getInstance(Class<T> cls);

    <T extends B> T putInstance(Class<T> cls, @NullableDecl T t);
}
