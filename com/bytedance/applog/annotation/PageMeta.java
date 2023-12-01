package com.bytedance.applog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/annotation/PageMeta.class */
public @interface PageMeta {
    String path() default "";

    String title() default "";
}
