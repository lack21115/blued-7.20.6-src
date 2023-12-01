package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/MissingResourceException.class */
public class MissingResourceException extends RuntimeException {
    private static final long serialVersionUID = -4876345176062000401L;
    String className;
    String key;

    public MissingResourceException(String str, String str2, String str3) {
        super(str);
        this.className = str2;
        this.key = str3;
    }

    public String getClassName() {
        return this.className;
    }

    public String getKey() {
        return this.key;
    }
}
