package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8110460-dex2jar.jar:com/google/j2objc/annotations/AutoreleasePool.class */
public @interface AutoreleasePool {
}
