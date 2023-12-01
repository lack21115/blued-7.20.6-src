package com.tencent.liteav.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/annotations/UsedByReflection.class */
public @interface UsedByReflection {
    String value();
}
