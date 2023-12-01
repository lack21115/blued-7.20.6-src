package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-3503164-dex2jar.jar:org/jetbrains/annotations/Nls.class */
public @interface Nls {

    /* loaded from: source-3503164-dex2jar.jar:org/jetbrains/annotations/Nls$Capitalization.class */
    public enum Capitalization {
        NotSpecified,
        Title,
        Sentence
    }
}
