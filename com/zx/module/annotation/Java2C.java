package com.zx.module.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: source-8829756-dex2jar.jar:com/zx/module/annotation/Java2C.class */
public @interface Java2C {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/zx/module/annotation/Java2C$Method2C.class */
    public @interface Method2C {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/zx/module/annotation/Java2C$NativeLoad.class */
    public @interface NativeLoad {
    }
}
