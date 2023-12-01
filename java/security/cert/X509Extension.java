package java.security.cert;

import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/X509Extension.class */
public interface X509Extension {
    Set<String> getCriticalExtensionOIDs();

    byte[] getExtensionValue(String str);

    Set<String> getNonCriticalExtensionOIDs();

    boolean hasUnsupportedCriticalExtension();
}
