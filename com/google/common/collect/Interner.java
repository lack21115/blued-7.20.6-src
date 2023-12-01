package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/Interner.class */
public interface Interner<E> {
    E intern(E e);
}
