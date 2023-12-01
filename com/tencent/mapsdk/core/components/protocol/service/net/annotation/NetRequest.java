package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import com.tencent.map.tools.net.NetMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/service/net/annotation/NetRequest.class */
public @interface NetRequest {
    String authority() default "";

    String constQuery() default "";

    NetHead head() default @NetHead;

    NetMethod method();

    String path() default "";

    String[] queryKeys() default {};

    int retry() default 1;

    boolean useExtraQuery() default true;

    String userAgent() default "androidsdk";
}
