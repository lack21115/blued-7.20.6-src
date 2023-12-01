package com.autonavi.base.amap.mapcore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/annotations/CalledByNativeCode.class */
public @interface CalledByNativeCode {
    String value() default "";
}
