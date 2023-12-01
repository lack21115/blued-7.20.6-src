package androidx.annotation.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: source-8756600-dex2jar.jar:androidx/annotation/experimental/Experimental.class */
public @interface Experimental {

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/annotation/experimental/Experimental$Level.class */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
