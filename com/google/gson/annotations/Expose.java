package com.google.gson.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8110460-dex2jar.jar:com/google/gson/annotations/Expose.class */
public @interface Expose {
    boolean deserialize() default true;

    boolean serialize() default true;
}
