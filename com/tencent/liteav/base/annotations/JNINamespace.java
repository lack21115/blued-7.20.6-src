package com.tencent.liteav.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/annotations/JNINamespace.class */
public @interface JNINamespace {
    String value();
}
