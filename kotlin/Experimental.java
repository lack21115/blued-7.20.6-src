package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.ANNOTATION_TYPE})
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@Metadata
@DeprecatedSinceKotlin
/* loaded from: source-3503164-dex2jar.jar:kotlin/Experimental.class */
public @interface Experimental {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/Experimental$Level.class */
    public enum Level {
        WARNING,
        ERROR
    }
}
