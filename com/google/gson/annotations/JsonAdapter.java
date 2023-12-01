package com.google.gson.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8110460-dex2jar.jar:com/google/gson/annotations/JsonAdapter.class */
public @interface JsonAdapter {
    boolean nullSafe() default true;

    Class<?> value();
}
