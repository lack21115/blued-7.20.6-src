package java.security.interfaces;

import java.security.PublicKey;
import java.security.spec.ECPoint;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/ECPublicKey.class */
public interface ECPublicKey extends PublicKey, ECKey {
    public static final long serialVersionUID = -3314988629879632826L;

    ECPoint getW();
}
