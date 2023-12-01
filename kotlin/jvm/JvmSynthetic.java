package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Target({ElementType.FIELD, ElementType.METHOD})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/JvmSynthetic.class */
public @interface JvmSynthetic {
}
