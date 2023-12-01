package com.tencent.tinker.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/anno/DefaultLifeCycle.class */
public @interface DefaultLifeCycle {
    String application();

    int flags();

    boolean loadVerifyFlag() default false;

    String loaderClass() default "com.tencent.tinker.loader.TinkerLoader";

    boolean useDelegateLastClassLoader() default false;
}
