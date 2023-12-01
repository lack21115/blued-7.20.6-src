package com.getui.gtc.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/annotation/MutableMethod.class */
public @interface MutableMethod {
    String name();
}
