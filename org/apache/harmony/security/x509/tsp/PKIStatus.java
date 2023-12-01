package org.apache.harmony.security.x509.tsp;

import java.security.InvalidParameterException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/PKIStatus.class */
public enum PKIStatus {
    GRANTED(0),
    GRANTED_WITH_MODS(1),
    REJECTION(2),
    WAITING(3),
    REVOCATION_WARNING(4),
    REVOCATION_NOTIFICATION(5);
    
    private final int status;

    PKIStatus(int i) {
        this.status = i;
    }

    public static PKIStatus getInstance(int i) {
        PKIStatus[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                throw new InvalidParameterException("Unknown PKIStatus value");
            }
            PKIStatus pKIStatus = values[i3];
            if (i == pKIStatus.status) {
                return pKIStatus;
            }
            i2 = i3 + 1;
        }
    }

    public int getStatus() {
        return this.status;
    }
}
