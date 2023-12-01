package com.alibaba.fastjson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/annotation/JSONPOJOBuilder.class */
public @interface JSONPOJOBuilder {
    String buildMethod() default "build";

    String withPrefix() default "with";
}
