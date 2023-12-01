package com.google.common.util.concurrent;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/Partially.class */
final class Partially {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/Partially$GwtIncompatible.class */
    @interface GwtIncompatible {
        String value();
    }

    private Partially() {
    }
}
