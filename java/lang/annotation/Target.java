package java.lang.annotation;

@Target({ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-2895416-dex2jar.jar:java/lang/annotation/Target.class */
public @interface Target {
    ElementType[] value();
}
