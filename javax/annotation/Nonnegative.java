package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;

@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-3503164-dex2jar.jar:javax/annotation/Nonnegative.class */
public @interface Nonnegative {

    /* loaded from: source-3503164-dex2jar.jar:javax/annotation/Nonnegative$Checker.class */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
    }
}
