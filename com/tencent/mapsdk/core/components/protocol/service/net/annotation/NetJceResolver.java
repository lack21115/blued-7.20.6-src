package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import com.qq.taf.jce.MapJceStruct;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/service/net/annotation/NetJceResolver.class */
public @interface NetJceResolver {
    Class<? extends MapJceStruct> inJce();

    Class<? extends MapJceStruct> outJce();

    int[] queryRange();
}
