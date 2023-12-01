package org.conscrypt;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.logging.Logger;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/CryptoUpcalls.class */
final class CryptoUpcalls {
    private static final Logger logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    static byte[] ecSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        if ("EC".equals(privateKey.getAlgorithm())) {
            return signDigestWithPrivateKey(privateKey, bArr, "NONEwithECDSA");
        }
        throw new RuntimeException("Unexpected key type: " + privateKey.toString());
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        Provider[] providers = Security.getProviders(str);
        int length = providers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Provider provider = providers[i2];
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
            i = i2 + 1;
        }
        if (arrayList.isEmpty()) {
            Logger logger2 = logger;
            logger2.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 2, bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b4, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r10.getProvider()) != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] rsaOpWithPrivateKey(java.security.PrivateKey r5, int r6, int r7, byte[] r8) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.CryptoUpcalls.rsaOpWithPrivateKey(java.security.PrivateKey, int, int, byte[]):byte[]");
    }

    static byte[] rsaSignDigestWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 1, bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r9.getProvider()) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005f A[LOOP:0: B:11:0x005f->B:19:0x0095, LOOP_START, PHI: r0 r9 
      PHI: (r0v38 java.lang.RuntimeException) = (r0v37 java.lang.RuntimeException), (r0v58 java.lang.RuntimeException) binds: [B:10:0x0037, B:19:0x0095] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v4 java.security.Signature) = (r9v2 java.security.Signature), (r9v8 java.security.Signature) binds: [B:10:0x0037, B:19:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] signDigestWithPrivateKey(java.security.PrivateKey r5, byte[] r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.CryptoUpcalls.signDigestWithPrivateKey(java.security.PrivateKey, byte[], java.lang.String):byte[]");
    }
}
