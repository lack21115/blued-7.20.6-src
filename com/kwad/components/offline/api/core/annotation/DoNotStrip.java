package com.kwad.components.offline.api.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/annotation/DoNotStrip.class */
public @interface DoNotStrip {
}
