package com.alipay.mobile.framework.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-6737240-dex2jar.jar:com/alipay/mobile/framework/service/annotation/OperationType.class */
public @interface OperationType {
    String value();
}
