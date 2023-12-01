package org.apache.harmony.security.x509.tsp;

import java.security.InvalidParameterException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/PKIFailureInfo.class */
public enum PKIFailureInfo {
    BAD_ALG(0),
    BAD_REQUEST(2),
    BAD_DATA_FORMAT(5),
    TIME_NOT_AVAILABLE(14),
    UNACCEPTED_POLICY(15),
    UNACCEPTED_EXTENSION(16),
    ADD_INFO_NOT_AVAILABLE(17),
    SYSTEM_FAILURE(25);
    
    private static int maxValue;
    private final int value;

    PKIFailureInfo(int i) {
        this.value = i;
    }

    public static PKIFailureInfo getInstance(int i) {
        PKIFailureInfo[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                throw new InvalidParameterException("Unknown PKIFailureInfo value");
            }
            PKIFailureInfo pKIFailureInfo = values[i3];
            if (i == pKIFailureInfo.value) {
                return pKIFailureInfo;
            }
            i2 = i3 + 1;
        }
    }

    public static int getMaxValue() {
        if (maxValue == 0) {
            PKIFailureInfo[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                PKIFailureInfo pKIFailureInfo = values[i2];
                if (pKIFailureInfo.value > maxValue) {
                    maxValue = pKIFailureInfo.value;
                }
                i = i2 + 1;
            }
        }
        return maxValue;
    }

    public int getValue() {
        return this.value;
    }
}
