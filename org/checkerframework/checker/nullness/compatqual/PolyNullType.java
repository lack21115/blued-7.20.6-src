package org.checkerframework.checker.nullness.compatqual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:org/checkerframework/checker/nullness/compatqual/PolyNullType.class */
public @interface PolyNullType {
}
