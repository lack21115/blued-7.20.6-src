package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierValidator;

@Syntax("RegEx")
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:javax/annotation/RegEx.class */
public @interface RegEx {

    /* loaded from: source-3503164-dex2jar.jar:javax/annotation/RegEx$Checker.class */
    public static class Checker implements TypeQualifierValidator<RegEx> {
    }
}
