package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.METHOD})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/WireRpc.class */
public @interface WireRpc {
    String path();

    String requestAdapter();

    String responseAdapter();

    String sourceFile() default "";
}
