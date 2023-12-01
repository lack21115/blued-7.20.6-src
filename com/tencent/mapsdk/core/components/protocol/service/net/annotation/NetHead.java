package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/service/net/annotation/NetHead.class */
public @interface NetHead {
    String[] keys() default {};

    String[] values() default {};
}
