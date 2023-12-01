package java.security.cert;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertSelector.class */
public interface CertSelector extends Cloneable {
    Object clone();

    boolean match(Certificate certificate);
}
