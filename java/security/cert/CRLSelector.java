package java.security.cert;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CRLSelector.class */
public interface CRLSelector extends Cloneable {
    Object clone();

    boolean match(CRL crl);
}
