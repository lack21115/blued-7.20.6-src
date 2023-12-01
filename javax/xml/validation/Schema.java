package javax.xml.validation;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/validation/Schema.class */
public abstract class Schema {
    protected Schema() {
    }

    public abstract Validator newValidator();

    public abstract ValidatorHandler newValidatorHandler();
}
