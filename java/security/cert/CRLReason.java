package java.security.cert;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CRLReason.class */
public enum CRLReason implements Comparable<CRLReason>, Serializable {
    UNSPECIFIED,
    KEY_COMPROMISE,
    CA_COMPROMISE,
    AFFILIATION_CHANGED,
    SUPERSEDED,
    CESSATION_OF_OPERATION,
    CERTIFICATE_HOLD,
    UNUSED,
    REMOVE_FROM_CRL,
    PRIVILEGE_WITHDRAWN,
    AA_COMPROMISE
}
