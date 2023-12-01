package com.opos.process.bridge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-8303388-dex2jar.jar:com/opos/process/bridge/annotation/BridgeMethod.class */
public @interface BridgeMethod {
    int a();
}
