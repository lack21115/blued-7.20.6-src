package com.bytedance.sdk.openadsdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/IntDef.class */
public @interface IntDef {
    boolean flag() default false;

    int[] value() default {};
}
