package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/Result.class */
public interface Result {
    public static final String PI_DISABLE_OUTPUT_ESCAPING = "javax.xml.transform.disable-output-escaping";
    public static final String PI_ENABLE_OUTPUT_ESCAPING = "javax.xml.transform.enable-output-escaping";

    String getSystemId();

    void setSystemId(String str);
}
