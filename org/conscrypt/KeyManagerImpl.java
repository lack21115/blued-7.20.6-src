package org.conscrypt;

import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/KeyManagerImpl.class */
class KeyManagerImpl extends X509ExtendedKeyManager {
    private final HashMap<String, KeyStore.PrivateKeyEntry> hash = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyManagerImpl(KeyStore keyStore, char[] cArr) {
        KeyStore.PrivateKeyEntry privateKeyEntry;
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                try {
                    if (keyStore.entryInstanceOf(nextElement, KeyStore.PrivateKeyEntry.class)) {
                        try {
                            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(nextElement, new KeyStore.PasswordProtection(cArr));
                        } catch (UnsupportedOperationException e) {
                            privateKeyEntry = new KeyStore.PrivateKeyEntry((PrivateKey) keyStore.getKey(nextElement, cArr), keyStore.getCertificateChain(nextElement));
                        }
                        this.hash.put(nextElement, privateKeyEntry);
                    }
                } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException e2) {
                }
            }
        } catch (KeyStoreException e3) {
        }
    }

    private String[] chooseAlias(String[] strArr, Principal[] principalArr) {
        String substring;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List asList = principalArr == null ? null : Arrays.asList(principalArr);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, KeyStore.PrivateKeyEntry> entry : this.hash.entrySet()) {
            String key = entry.getKey();
            Certificate[] certificateChain = entry.getValue().getCertificateChain();
            Certificate certificate = certificateChain[0];
            String algorithm = certificate.getPublicKey().getAlgorithm();
            String upperCase = certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSigAlgName().toUpperCase(Locale.US) : null;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    String str = strArr[i2];
                    if (str != null) {
                        int indexOf = str.indexOf(95);
                        if (indexOf == -1) {
                            substring = null;
                        } else {
                            substring = str.substring(indexOf + 1);
                            str = str.substring(0, indexOf);
                        }
                        if (algorithm.equals(str) && (substring == null || upperCase == null || upperCase.contains(substring))) {
                            if (principalArr == null || principalArr.length == 0) {
                                arrayList.add(key);
                            } else {
                                int length2 = certificateChain.length;
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 < length2) {
                                        Certificate certificate2 = certificateChain[i4];
                                        if ((certificate2 instanceof X509Certificate) && asList.contains(((X509Certificate) certificate2).getIssuerX500Principal())) {
                                            arrayList.add(key);
                                        }
                                        i3 = i4 + 1;
                                    }
                                }
                            }
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        if (str == null) {
            return null;
        }
        X509Certificate[] x509CertificateArr = null;
        if (this.hash.containsKey(str)) {
            Certificate[] certificateChain = this.hash.get(str).getCertificateChain();
            int i = 0;
            x509CertificateArr = null;
            if (certificateChain[0] instanceof X509Certificate) {
                X509Certificate[] x509CertificateArr2 = new X509Certificate[certificateChain.length];
                while (true) {
                    x509CertificateArr = x509CertificateArr2;
                    if (i >= certificateChain.length) {
                        break;
                    }
                    x509CertificateArr2[i] = (X509Certificate) certificateChain[i];
                    i++;
                }
            }
        }
        return x509CertificateArr;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        if (str != null && this.hash.containsKey(str)) {
            return this.hash.get(str).getPrivateKey();
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }
}
