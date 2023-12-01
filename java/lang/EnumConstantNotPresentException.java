package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/EnumConstantNotPresentException.class */
public class EnumConstantNotPresentException extends RuntimeException {
    private static final long serialVersionUID = -6046998521960521108L;
    private final String constantName;
    private final Class<? extends Enum> enumType;

    public EnumConstantNotPresentException(Class<? extends Enum> cls, String str) {
        super("enum constant " + cls.getName() + "." + str + " is missing");
        this.enumType = cls;
        this.constantName = str;
    }

    public String constantName() {
        return this.constantName;
    }

    public Class<? extends Enum> enumType() {
        return this.enumType;
    }
}
