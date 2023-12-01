package com.android.org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/TrustManagerImpl.class */
public final class TrustManagerImpl implements X509TrustManager {
    private final X509Certificate[] acceptedIssuers;
    private final Exception err;
    private final CertificateFactory factory;
    private final TrustedCertificateIndex intermediateIndex;
    private CertPinManager pinManager;
    private final KeyStore rootKeyStore;
    private final TrustedCertificateIndex trustedCertificateIndex;
    private final TrustedCertificateStore trustedCertificateStore;
    private final CertPathValidator validator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/TrustManagerImpl$ExtendedKeyUsagePKIXCertPathChecker.class */
    public static class ExtendedKeyUsagePKIXCertPathChecker extends PKIXCertPathChecker {
        private static final String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private final boolean clientAuth;
        private final X509Certificate leaf;
        private static final String EKU_OID = "2.5.29.37";
        private static final Set<String> SUPPORTED_EXTENSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EKU_OID)));

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z, X509Certificate x509Certificate) {
            this.clientAuth = z;
            this.leaf = x509Certificate;
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException {
            boolean z;
            if (certificate != this.leaf) {
                return;
            }
            try {
                List<String> extendedKeyUsage = this.leaf.getExtendedKeyUsage();
                if (extendedKeyUsage != null) {
                    Iterator<String> it = extendedKeyUsage.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (next.equals(EKU_anyExtendedKeyUsage)) {
                            z = true;
                            break;
                        } else if (this.clientAuth) {
                            if (next.equals(EKU_clientAuth)) {
                                z = true;
                                break;
                            }
                        } else if (next.equals(EKU_serverAuth)) {
                            z = true;
                            break;
                        } else if (next.equals(EKU_nsSGC)) {
                            z = true;
                            break;
                        } else if (next.equals(EKU_msSGC)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        throw new CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
                    }
                    collection.remove(EKU_OID);
                }
            } catch (CertificateParsingException e) {
                throw new CertPathValidatorException(e);
            }
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public Set<String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public void init(boolean z) throws CertPathValidatorException {
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public boolean isForwardCheckingSupported() {
            return true;
        }
    }

    public TrustManagerImpl(KeyStore keyStore) {
        this(keyStore, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, TrustedCertificateStore trustedCertificateStore) {
        TrustedCertificateIndex trustedCertificateIndex;
        CertPathValidator certPathValidator = null;
        X509Certificate[] x509CertificateArr = null;
        CertificateFactory certificateFactory = null;
        KeyStore keyStore2 = null;
        try {
            CertPathValidator certPathValidator2 = CertPathValidator.getInstance("PKIX");
            CertificateFactory certificateFactory2 = CertificateFactory.getInstance("X509");
            if ("AndroidCAStore".equals(keyStore.getType())) {
                certPathValidator = certPathValidator2;
                trustedCertificateStore = trustedCertificateStore != null ? trustedCertificateStore : new TrustedCertificateStore();
                trustedCertificateIndex = new TrustedCertificateIndex();
                keyStore2 = keyStore;
                certificateFactory = certificateFactory2;
                e = null;
                x509CertificateArr = null;
            } else {
                X509Certificate[] acceptedIssuers = acceptedIssuers(keyStore);
                x509CertificateArr = acceptedIssuers;
                e = null;
                certificateFactory = certificateFactory2;
                keyStore2 = null;
                trustedCertificateIndex = new TrustedCertificateIndex(trustAnchors(acceptedIssuers));
                certPathValidator = certPathValidator2;
            }
        } catch (Exception e) {
            e = e;
            trustedCertificateIndex = null;
            trustedCertificateStore = null;
        }
        if (certPinManager != null) {
            this.pinManager = certPinManager;
        } else {
            try {
                this.pinManager = new CertPinManager(trustedCertificateStore);
            } catch (PinManagerException e2) {
                throw new SecurityException("Could not initialize CertPinManager", e2);
            }
        }
        this.rootKeyStore = keyStore2;
        this.trustedCertificateStore = trustedCertificateStore;
        this.validator = certPathValidator;
        this.factory = certificateFactory;
        this.trustedCertificateIndex = trustedCertificateIndex;
        this.intermediateIndex = new TrustedCertificateIndex();
        this.acceptedIssuers = x509CertificateArr;
        this.err = e;
    }

    private static X509Certificate[] acceptedIssuers(KeyStore keyStore) {
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (KeyStoreException e) {
            return new X509Certificate[0];
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, String str, String str2, boolean z) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or zero-length parameter");
        }
        if (this.err != null) {
            throw new CertificateException(this.err);
        }
        HashSet<TrustAnchor> hashSet = new HashSet();
        X509Certificate[] cleanupCertChainAndFindTrustAnchors = cleanupCertChainAndFindTrustAnchors(x509CertificateArr, hashSet);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(cleanupCertChainAndFindTrustAnchors));
        for (TrustAnchor trustAnchor : hashSet) {
            arrayList.add(trustAnchor.getTrustedCert());
        }
        X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
        while (true) {
            X509Certificate x509Certificate2 = x509Certificate;
            TrustAnchor findByIssuerAndSignature = this.trustedCertificateIndex.findByIssuerAndSignature(x509Certificate2);
            if (findByIssuerAndSignature == null) {
                break;
            }
            X509Certificate trustedCert = findByIssuerAndSignature.getTrustedCert();
            if (trustedCert == x509Certificate2) {
                break;
            }
            arrayList.add(trustedCert);
            x509Certificate = trustedCert;
        }
        CertPath generateCertPath = this.factory.generateCertPath(Arrays.asList(cleanupCertChainAndFindTrustAnchors));
        if (str2 != null) {
            try {
                if (!this.pinManager.isChainValid(str2, arrayList)) {
                    throw new CertificateException(new CertPathValidatorException("Certificate path is not properly pinned.", null, generateCertPath, -1));
                }
            } catch (PinManagerException e) {
                throw new CertificateException(e);
            }
        }
        if (cleanupCertChainAndFindTrustAnchors.length != 0) {
            if (hashSet.isEmpty()) {
                throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, generateCertPath, -1));
            }
            ChainStrengthAnalyzer.check(cleanupCertChainAndFindTrustAnchors);
            try {
                PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
                pKIXParameters.setRevocationEnabled(false);
                pKIXParameters.addCertPathChecker(new ExtendedKeyUsagePKIXCertPathChecker(z, cleanupCertChainAndFindTrustAnchors[0]));
                this.validator.validate(generateCertPath, pKIXParameters);
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= cleanupCertChainAndFindTrustAnchors.length) {
                        break;
                    }
                    this.intermediateIndex.index(cleanupCertChainAndFindTrustAnchors[i2]);
                    i = i2 + 1;
                }
            } catch (InvalidAlgorithmParameterException e2) {
                throw new CertificateException(e2);
            } catch (CertPathValidatorException e3) {
                throw new CertificateException(e3);
            }
        }
        return arrayList;
    }

    private X509Certificate[] cleanupCertChainAndFindTrustAnchors(X509Certificate[] x509CertificateArr, Set<TrustAnchor> set) {
        int i;
        int i2;
        TrustAnchor findTrustAnchorByIssuerAndSignature;
        boolean z;
        int i3 = 0;
        X509Certificate[] x509CertificateArr2 = x509CertificateArr;
        while (true) {
            X509Certificate[] x509CertificateArr3 = x509CertificateArr2;
            i = i3;
            x509CertificateArr2 = x509CertificateArr3;
            if (i3 >= x509CertificateArr3.length) {
                break;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4 + 1;
                z = false;
                x509CertificateArr2 = x509CertificateArr3;
                if (i5 >= x509CertificateArr3.length) {
                    break;
                } else if (x509CertificateArr3[i3].getIssuerDN().equals(x509CertificateArr3[i5].getSubjectDN())) {
                    z = true;
                    x509CertificateArr2 = x509CertificateArr3;
                    if (i5 != i3 + 1) {
                        x509CertificateArr2 = x509CertificateArr3;
                        if (x509CertificateArr3 == x509CertificateArr) {
                            x509CertificateArr2 = (X509Certificate[]) x509CertificateArr.clone();
                        }
                        X509Certificate x509Certificate = x509CertificateArr2[i5];
                        x509CertificateArr2[i5] = x509CertificateArr2[i3 + 1];
                        x509CertificateArr2[i3 + 1] = x509Certificate;
                        z = true;
                    }
                } else {
                    i4 = i5;
                }
            }
            if (!z) {
                i = i3;
                break;
            }
            i3++;
        }
        while (true) {
            TrustAnchor findByIssuerAndSignature = this.intermediateIndex.findByIssuerAndSignature(x509CertificateArr2[i]);
            if (findByIssuerAndSignature == null) {
                break;
            }
            X509Certificate trustedCert = findByIssuerAndSignature.getTrustedCert();
            X509Certificate[] x509CertificateArr4 = x509CertificateArr2;
            if (x509CertificateArr2 == x509CertificateArr) {
                x509CertificateArr4 = (X509Certificate[]) x509CertificateArr.clone();
            }
            x509CertificateArr2 = x509CertificateArr4;
            if (i == x509CertificateArr4.length - 1) {
                x509CertificateArr2 = (X509Certificate[]) Arrays.copyOf(x509CertificateArr4, x509CertificateArr4.length * 2);
            }
            x509CertificateArr2[i + 1] = trustedCert;
            i++;
        }
        int i6 = 0;
        while (true) {
            i2 = i6;
            if (i2 > i) {
                break;
            }
            TrustAnchor findTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509CertificateArr2[i2]);
            if (findTrustAnchorBySubjectAndPublicKey != null) {
                set.add(findTrustAnchorBySubjectAndPublicKey);
                break;
            }
            i6 = i2 + 1;
        }
        X509Certificate[] x509CertificateArr5 = i2 == x509CertificateArr2.length ? x509CertificateArr2 : (X509Certificate[]) Arrays.copyOf(x509CertificateArr2, i2);
        if (set.isEmpty() && (findTrustAnchorByIssuerAndSignature = findTrustAnchorByIssuerAndSignature(x509CertificateArr5[i2 - 1])) != null) {
            set.add(findTrustAnchorByIssuerAndSignature);
        }
        return x509CertificateArr5;
    }

    private TrustAnchor findTrustAnchorByIssuerAndSignature(X509Certificate x509Certificate) {
        X509Certificate findIssuer;
        TrustAnchor findByIssuerAndSignature = this.trustedCertificateIndex.findByIssuerAndSignature(x509Certificate);
        if (findByIssuerAndSignature != null) {
            return findByIssuerAndSignature;
        }
        if (this.trustedCertificateStore == null || (findIssuer = this.trustedCertificateStore.findIssuer(x509Certificate)) == null) {
            return null;
        }
        return this.trustedCertificateIndex.index(findIssuer);
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X509Certificate trustAnchor;
        TrustAnchor findBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey != null) {
            return findBySubjectAndPublicKey;
        }
        if (this.trustedCertificateStore == null || (trustAnchor = this.trustedCertificateStore.getTrustAnchor(x509Certificate)) == null) {
            return null;
        }
        return this.trustedCertificateIndex.index(trustAnchor);
    }

    private static Set<TrustAnchor> trustAnchors(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet(x509CertificateArr.length);
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashSet;
            }
            hashSet.add(new TrustAnchor(x509CertificateArr[i2], null));
            i = i2 + 1;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, true);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, str, str2, false);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) throws CertificateException {
        return checkTrusted(x509CertificateArr, str, sSLSession.getPeerHost(), false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.acceptedIssuers != null ? (X509Certificate[]) this.acceptedIssuers.clone() : acceptedIssuers(this.rootKeyStore);
    }

    public void handleTrustStorageUpdate() {
        if (this.acceptedIssuers == null) {
            this.trustedCertificateIndex.reset();
        } else {
            this.trustedCertificateIndex.reset(trustAnchors(this.acceptedIssuers));
        }
    }

    public boolean isUserAddedCertificate(X509Certificate x509Certificate) {
        if (this.trustedCertificateStore == null) {
            return false;
        }
        return this.trustedCertificateStore.isUserAddedCertificate(x509Certificate);
    }
}
