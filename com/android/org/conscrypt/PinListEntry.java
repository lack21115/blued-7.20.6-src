package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/PinListEntry.class */
public class PinListEntry {
    private final TrustedCertificateStore certStore;

    /* renamed from: cn  reason: collision with root package name */
    private final String f5814cn;
    private final boolean enforcing;
    private final Set<String> pinnedFingerprints = new HashSet();

    public PinListEntry(String str, TrustedCertificateStore trustedCertificateStore) throws PinEntryException {
        if (str == null) {
            throw new NullPointerException("entry == null");
        }
        this.certStore = trustedCertificateStore;
        String[] split = str.split("[=,|]");
        if (split.length < 3) {
            throw new PinEntryException("Received malformed pin entry");
        }
        this.f5814cn = split[0];
        this.enforcing = enforcementValueFromString(split[1]);
        addPins((String[]) Arrays.copyOfRange(split, 2, split.length));
    }

    private void addPins(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Collections.addAll(this.pinnedFingerprints, strArr);
                return;
            } else {
                validatePin(strArr[i2]);
                i = i2 + 1;
            }
        }
    }

    private boolean chainContainsUserCert(List<X509Certificate> list) {
        if (this.certStore == null) {
            return false;
        }
        for (X509Certificate x509Certificate : list) {
            if (this.certStore.isUserAddedCertificate(x509Certificate)) {
                return true;
            }
        }
        return false;
    }

    private static boolean enforcementValueFromString(String str) throws PinEntryException {
        if (str.equals("true")) {
            return true;
        }
        if (str.equals("false")) {
            return false;
        }
        throw new PinEntryException("Enforcement status is not a valid value");
    }

    private static String getFingerprint(X509Certificate x509Certificate) {
        try {
            return IntegralToString.bytesToHexString(MessageDigest.getInstance("SHA512").digest(x509Certificate.getPublicKey().getEncoded()), false);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private void logPinFailure(List<X509Certificate> list, boolean z) {
        PinFailureLogger.log(this.f5814cn, z, this.enforcing, list);
    }

    private static void validatePin(String str) {
        if (str.length() != 128) {
            throw new IllegalArgumentException("Pin is not a valid length");
        }
        try {
            new BigInteger(str, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Pin is not a valid hex string", e);
        }
    }

    public String getCommonName() {
        return this.f5814cn;
    }

    public boolean getEnforcing() {
        return this.enforcing;
    }

    public boolean isChainValid(List<X509Certificate> list) {
        boolean chainContainsUserCert = chainContainsUserCert(list);
        if (!chainContainsUserCert) {
            for (X509Certificate x509Certificate : list) {
                if (this.pinnedFingerprints.contains(getFingerprint(x509Certificate))) {
                    return true;
                }
            }
        }
        logPinFailure(list, chainContainsUserCert);
        return !this.enforcing || chainContainsUserCert;
    }
}
