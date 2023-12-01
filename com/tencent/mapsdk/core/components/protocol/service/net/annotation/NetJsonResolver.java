package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import com.tencent.map.tools.json.JsonComposer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/service/net/annotation/NetJsonResolver.class */
public @interface NetJsonResolver {
    Class<? extends JsonComposer> outModel();

    int[] queryRange();
}
