package com.ishumei.l1111l111111Il;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l11111Il.class */
public @interface l111l11111Il {
    String l1111l111111Il();

    boolean l111l11111I1l() default true;

    boolean l111l11111lIl() default false;
}
