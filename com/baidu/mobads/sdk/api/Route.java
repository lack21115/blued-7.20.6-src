package com.baidu.mobads.sdk.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/Route.class */
public @interface Route {
    String name() default "";

    String path();
}
