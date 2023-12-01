package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8110460-dex2jar.jar:com/google/errorprone/annotations/concurrent/UnlockMethod.class */
public @interface UnlockMethod {
    String[] value();
}
