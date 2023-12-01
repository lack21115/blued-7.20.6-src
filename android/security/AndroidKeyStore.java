package android.security;

import android.net.wifi.WifiEnterpriseConfig;
import android.util.Log;
import com.android.org.conscrypt.OpenSSLEngine;
import com.android.org.conscrypt.OpenSSLKeyHolder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/security/AndroidKeyStore.class */
public class AndroidKeyStore extends KeyStoreSpi {
    public static final String NAME = "AndroidKeyStore";
    private KeyStore mKeyStore;

    private Date getModificationDate(String str) {
        long j = this.mKeyStore.getmtime(str);
        if (j == -1) {
            return null;
        }
        return new Date(j);
    }

    private Set<String> getUniqueAliases() {
        HashSet hashSet;
        String[] saw = this.mKeyStore.saw("");
        if (saw != null) {
            HashSet hashSet2 = new HashSet(saw.length);
            int length = saw.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                if (i2 >= length) {
                    break;
                }
                String str = saw[i2];
                int indexOf = str.indexOf(95);
                if (indexOf == -1 || str.length() <= indexOf) {
                    Log.e("AndroidKeyStore", "invalid alias: " + str);
                } else {
                    hashSet2.add(new String(str.substring(indexOf + 1)));
                }
                i = i2 + 1;
            }
        } else {
            hashSet = new HashSet();
        }
        return hashSet;
    }

    private boolean isCertificateEntry(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        return this.mKeyStore.contains(Credentials.CA_CERTIFICATE + str);
    }

    private boolean isKeyEntry(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        return this.mKeyStore.contains(Credentials.USER_PRIVATE_KEY + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setPrivateKeyEntry(String str, PrivateKey privateKey, Certificate[] certificateArr, KeyStoreParameter keyStoreParameter) throws KeyStoreException {
        byte[] encoded;
        boolean z;
        byte[] bArr;
        String alias = privateKey instanceof OpenSSLKeyHolder ? ((OpenSSLKeyHolder) privateKey).getOpenSSLKey().getAlias() : null;
        if (alias == null || !alias.startsWith(Credentials.USER_PRIVATE_KEY)) {
            String format = privateKey.getFormat();
            if (format == null || !"PKCS#8".equals(format)) {
                throw new KeyStoreException("Only PrivateKeys that can be encoded into PKCS#8 are supported");
            }
            encoded = privateKey.getEncoded();
            if (encoded == null) {
                throw new KeyStoreException("PrivateKey has no encoding");
            }
            z = true;
        } else {
            String substring = alias.substring(Credentials.USER_PRIVATE_KEY.length());
            if (!str.equals(substring)) {
                throw new KeyStoreException("Can only replace keys with same alias: " + str + " != " + substring);
            }
            z = false;
            encoded = null;
        }
        if (certificateArr == null || certificateArr.length == 0) {
            throw new KeyStoreException("Must supply at least one Certificate with PrivateKey");
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[certificateArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= certificateArr.length) {
                try {
                    byte[] encoded2 = x509CertificateArr[0].getEncoded();
                    if (certificateArr.length > 1) {
                        byte[] bArr2 = new byte[x509CertificateArr.length - 1];
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= bArr2.length) {
                                break;
                            }
                            try {
                                bArr2[i5] = x509CertificateArr[i5 + 1].getEncoded();
                                i3 += bArr2[i5].length;
                                i4 = i5 + 1;
                            } catch (CertificateEncodingException e) {
                                throw new KeyStoreException("Can't encode Certificate #" + i5, e);
                            }
                        }
                        byte[] bArr3 = new byte[i3];
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            bArr = bArr3;
                            if (i8 >= bArr2.length) {
                                break;
                            }
                            int length = bArr2[i8].length;
                            System.arraycopy(bArr2[i8], 0, bArr3, i6, length);
                            i6 += length;
                            bArr2[i8] = 0;
                            i7 = i8 + 1;
                        }
                    } else {
                        bArr = null;
                    }
                    if (z) {
                        Credentials.deleteAllTypesForAlias(this.mKeyStore, str);
                    } else {
                        Credentials.deleteCertificateTypesForAlias(this.mKeyStore, str);
                    }
                    int flags = keyStoreParameter == null ? 0 : keyStoreParameter.getFlags();
                    if (z && !this.mKeyStore.importKey(Credentials.USER_PRIVATE_KEY + str, encoded, -1, flags)) {
                        Credentials.deleteAllTypesForAlias(this.mKeyStore, str);
                        throw new KeyStoreException("Couldn't put private key in keystore");
                    } else if (!this.mKeyStore.put(Credentials.USER_CERTIFICATE + str, encoded2, -1, flags)) {
                        Credentials.deleteAllTypesForAlias(this.mKeyStore, str);
                        throw new KeyStoreException("Couldn't put certificate #1 in keystore");
                    } else if (bArr == null || this.mKeyStore.put(Credentials.CA_CERTIFICATE + str, bArr, -1, flags)) {
                        return;
                    } else {
                        Credentials.deleteAllTypesForAlias(this.mKeyStore, str);
                        throw new KeyStoreException("Couldn't put certificate chain in keystore");
                    }
                } catch (CertificateEncodingException e2) {
                    throw new KeyStoreException("Couldn't encode certificate #1", e2);
                }
            } else if (!"X.509".equals(certificateArr[i2].getType())) {
                throw new KeyStoreException("Certificates must be in X.509 format: invalid cert #" + i2);
            } else {
                if (!(certificateArr[i2] instanceof X509Certificate)) {
                    throw new KeyStoreException("Certificates must be in X.509 format: invalid cert #" + i2);
                }
                x509CertificateArr[i2] = (X509Certificate) certificateArr[i2];
                i = i2 + 1;
            }
        }
    }

    private static X509Certificate toCertificate(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            Log.w("AndroidKeyStore", "Couldn't parse certificate in keystore", e);
            return null;
        }
    }

    private static Collection<X509Certificate> toCertificates(byte[] bArr) {
        try {
            return CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            Log.w("AndroidKeyStore", "Couldn't parse certificates in keystore", e);
            return new ArrayList();
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return Collections.enumeration(getUniqueAliases());
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        return this.mKeyStore.contains(new StringBuilder().append(Credentials.USER_PRIVATE_KEY).append(str).toString()) || this.mKeyStore.contains(new StringBuilder().append(Credentials.USER_CERTIFICATE).append(str).toString()) || this.mKeyStore.contains(new StringBuilder().append(Credentials.CA_CERTIFICATE).append(str).toString());
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        if ((isKeyEntry(str) || isCertificateEntry(str)) && !Credentials.deleteAllTypesForAlias(this.mKeyStore, str)) {
            throw new KeyStoreException("No such entry " + str);
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        byte[] bArr = this.mKeyStore.get(Credentials.USER_CERTIFICATE + str);
        if (bArr != null) {
            return toCertificate(bArr);
        }
        byte[] bArr2 = this.mKeyStore.get(Credentials.CA_CERTIFICATE + str);
        if (bArr2 != null) {
            return toCertificate(bArr2);
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        String[] saw = this.mKeyStore.saw(Credentials.USER_CERTIFICATE);
        if (saw != null) {
            int length = saw.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = saw[i2];
                byte[] bArr = this.mKeyStore.get(Credentials.USER_CERTIFICATE + str);
                if (bArr != null) {
                    X509Certificate certificate2 = toCertificate(bArr);
                    hashSet.add(str);
                    if (certificate.equals(certificate2)) {
                        return str;
                    }
                }
                i = i2 + 1;
            }
        }
        String[] saw2 = this.mKeyStore.saw(Credentials.CA_CERTIFICATE);
        if (saw == null) {
            return null;
        }
        int length2 = saw2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return null;
            }
            String str2 = saw2[i4];
            if (!hashSet.contains(str2) && this.mKeyStore.get(Credentials.CA_CERTIFICATE + str2) != null && certificate.equals(toCertificate(this.mKeyStore.get(Credentials.CA_CERTIFICATE + str2)))) {
                return str2;
            }
            i3 = i4 + 1;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        Certificate[] certificateArr;
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        X509Certificate x509Certificate = (X509Certificate) engineGetCertificate(str);
        if (x509Certificate == null) {
            return null;
        }
        byte[] bArr = this.mKeyStore.get(Credentials.CA_CERTIFICATE + str);
        if (bArr != null) {
            Collection<X509Certificate> certificates = toCertificates(bArr);
            Certificate[] certificateArr2 = new Certificate[certificates.size() + 1];
            Iterator<X509Certificate> it = certificates.iterator();
            int i = 1;
            while (true) {
                int i2 = i;
                certificateArr = certificateArr2;
                if (!it.hasNext()) {
                    break;
                }
                certificateArr2[i2] = it.next();
                i = i2 + 1;
            }
        } else {
            certificateArr = new Certificate[1];
        }
        certificateArr[0] = x509Certificate;
        return certificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        Date modificationDate = getModificationDate(Credentials.USER_PRIVATE_KEY + str);
        if (modificationDate != null) {
            return modificationDate;
        }
        Date modificationDate2 = getModificationDate(Credentials.USER_CERTIFICATE + str);
        return modificationDate2 != null ? modificationDate2 : getModificationDate(Credentials.CA_CERTIFICATE + str);
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (isKeyEntry(str)) {
            try {
                return OpenSSLEngine.getInstance(WifiEnterpriseConfig.ENGINE_ID_KEYSTORE).getPrivateKeyById(Credentials.USER_PRIVATE_KEY + str);
            } catch (InvalidKeyException e) {
                UnrecoverableKeyException unrecoverableKeyException = new UnrecoverableKeyException("Can't get key");
                unrecoverableKeyException.initCause(e);
                throw unrecoverableKeyException;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return !isKeyEntry(str) && isCertificateEntry(str);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return isKeyEntry(str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        if (inputStream != null) {
            throw new IllegalArgumentException("InputStream not supported");
        }
        if (cArr != null) {
            throw new IllegalArgumentException("password not supported");
        }
        this.mKeyStore = KeyStore.getInstance();
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (isKeyEntry(str)) {
            throw new KeyStoreException("Entry exists and is not a trusted certificate");
        }
        if (certificate == null) {
            throw new NullPointerException("cert == null");
        }
        try {
            if (!this.mKeyStore.put(Credentials.CA_CERTIFICATE + str, certificate.getEncoded(), -1, 0)) {
                throw new KeyStoreException("Couldn't insert certificate; is KeyStore initialized?");
            }
        } catch (CertificateEncodingException e) {
            throw new KeyStoreException(e);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetEntry(String str, KeyStore.Entry entry, KeyStore.ProtectionParameter protectionParameter) throws KeyStoreException {
        if (entry == null) {
            throw new KeyStoreException("entry == null");
        }
        if (engineContainsAlias(str)) {
            engineDeleteEntry(str);
        }
        if (entry instanceof KeyStore.TrustedCertificateEntry) {
            engineSetCertificateEntry(str, ((KeyStore.TrustedCertificateEntry) entry).getTrustedCertificate());
        } else if (protectionParameter != null && !(protectionParameter instanceof KeyStoreParameter)) {
            throw new KeyStoreException("protParam should be android.security.KeyStoreParameter; was: " + protectionParameter.getClass().getName());
        } else {
            if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
                throw new KeyStoreException("Entry must be a PrivateKeyEntry or TrustedCertificateEntry; was " + entry);
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
            setPrivateKeyEntry(str, privateKeyEntry.getPrivateKey(), privateKeyEntry.getCertificateChain(), (KeyStoreParameter) protectionParameter);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (cArr != null && cArr.length > 0) {
            throw new KeyStoreException("entries cannot be protected with passwords");
        }
        if (!(key instanceof PrivateKey)) {
            throw new KeyStoreException("Only PrivateKeys are supported");
        }
        setPrivateKeyEntry(str, (PrivateKey) key, certificateArr, null);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException("Operation not supported because key encoding is unknown");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return getUniqueAliases().size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        throw new UnsupportedOperationException("Can not serialize AndroidKeyStore to OutputStream");
    }
}
